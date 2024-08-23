package digitaleye.demo.controller.normal;

import digitaleye.demo.domain.User;
import digitaleye.demo.dto.request.normal.ArrivalRegionRequestDto;
import digitaleye.demo.dto.request.normal.DepartureRegionRequestDto;
import digitaleye.demo.dto.response.normal.ArrRegionResponseDto;
import digitaleye.demo.dto.response.normal.DepRegionResponseDto;
import digitaleye.demo.repository.UserRepository;
import digitaleye.demo.service.CityCode;
import digitaleye.demo.service.api.City;
import digitaleye.demo.service.db.DepartureRegionDb;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static digitaleye.demo.service.CityCode.cityCode;
import static digitaleye.demo.service.db.ArrivalRegionDb.arrivalRegionDb;
import static digitaleye.demo.service.db.DepartureRegionDb.departureRegionDb;

@RestController
@RequiredArgsConstructor
public class NormalStationController {

    private final UserRepository userRepository;

    @Transactional
    @PostMapping("/api/basic/departure/regions")
    public ResponseEntity<?> departureRegion(@RequestBody DepartureRegionRequestDto departureRegionRequestDto) {
        //출발역의 도시 코드를 가져옴
        int cityCode = cityCode(departureRegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User savedUser = departureRegionDb(userRepository, cityCode);

        //id 값을 보냄
        return ResponseEntity.ok(DepRegionResponseDto.of(savedUser.getId()));
    }

    @Transactional
    @PatchMapping("/api/basic/arrival/regions")
    public ResponseEntity<?> arrivalRegion(@RequestBody ArrivalRegionRequestDto arrivalRegionRequestDto) {
        //도착역의 도시 코드를 가져옴
        int cityCode = cityCode(arrivalRegionRequestDto.region());
        //여기서 이상한 값 들어오면 안됨. 그럴 경우에는 예외처리 해주기!
        //도시 코드 db에 저장
        User savedUser = arrivalRegionDb(userRepository, arrivalRegionRequestDto, cityCode);

        return ResponseEntity.ok(ArrRegionResponseDto.of(savedUser.getId()));
    }

    @PostMapping("/api/basic/departure")
    public void departureStation(@RequestBody StationGetRequestDto departure) {
        //출발역의 시/도 코드를 db에서 가져오는 코드
        String sql = "SELECT dep_region FROM user";
        List<Integer> id = jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("dep_region");
                return id;
            }
        });
        Integer regionId = id.get(0);
        //db 에러 처리
        if (regionId == null) {
            //에러 처리
        }
        String regionid = Integer.toString(regionId);

        //시/도 코드를 통해 해당 역의 코드 조회
        String stations;
        TrainStation trainStation = new TrainStation();
        try {
            stations = trainStation.getStationCodeJson(regionid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(stations);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        String nodeId = null;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String nodeName = item.getString("nodename");
            if (nodeName.equals(departure)) {
                nodeId = item.getString("nodeid");
                break;
            }
        }

        //에러 처리
        if (nodeId == null) {
            System.out.println("nodeId를 찾을 수 없습니다.");
        }

        //그 코드를 db에 저장하는 코드
        sql = "INSERT INTO user (departure) VALUES (?)";
        jdbcTemplate.update(sql, nodeId);
        //db 에러 처리
    }
}

//    @PostMapping("/api/basic/arrival")
//    public void arrivalStation (@RequestBody StationGetRequestDto arrival) {
//        //도착역의 시/도 코드를 db에서 가져오는 코드
//        String sql = "SELECT arr_region FROM user";
//        List<Integer> id = jdbcTemplate.query(sql, new RowMapper<Integer>() {
//            @Override
//            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Integer id = rs.getInt("arr_region");
//                return id;
//            }
//        });
//        Integer regionId = id.get(0);
//        //db 에러 처리
//        if(regionId == null) {
//            //에러 처리
//        }
//        String regionid = Integer.toString(regionId);
//
//        //시/도 코드를 통해 해당 역의 코드 조회
//        String stations;
//        TrainStation trainStation = new TrainStation();
//        try {
//            stations = trainStation.getStationCodeJson(regionid);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        JSONObject jsonObject = new JSONObject(stations);
//        JSONArray itemsArray = jsonObject.getJSONObject("response")
//                .getJSONObject("body")
//                .getJSONObject("items")
//                .getJSONArray("item");
//
//        String nodeId = null;
//        for (int i = 0; i < itemsArray.length(); i++) {
//            JSONObject item = itemsArray.getJSONObject(i);
//            String nodeName = item.getString("nodename");
//            if (nodeName.equals(arrival)) {
//                nodeId = item.getString("nodeid");
//                break;
//            }
//        }
//
//        //에러 처리
//        if (nodeId == null) {
//            System.out.println("nodeId를 찾을 수 없습니다.");
//        }
//
//        //그 코드를 db에 저장하는 코드
//        sql = "INSERT INTO user (arrival) VALUES (?)";
//        jdbcTemplate.update(sql, nodeId);
//        //db 에러 처리
//    }

