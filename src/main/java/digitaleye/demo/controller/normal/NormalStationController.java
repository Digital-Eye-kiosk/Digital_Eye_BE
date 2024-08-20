package digitaleye.demo.controller.normal;

import digitaleye.demo.dto.request.normal.RegionGetRequestDto;
import digitaleye.demo.dto.request.normal.StationGetRequestDto;
import digitaleye.demo.service.api.City;
import digitaleye.demo.service.api.TrainStation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RestController
public class NormalStationController {

    private final JdbcTemplate jdbcTemplate;

    public NormalStationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/basic/departure/regions")
    public void departureRegion (@RequestBody RegionGetRequestDto region) {
        //출발역의 시/도 코드를 가져오는 코드
        String cities;
        City city = new City();
        try {
            cities = city.getCityCodeJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(cities);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        int cityCode = -1;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String cityName = item.getString("cityname");
            if (cityName.equals(region.getRegion())) {
                cityCode = item.getInt("citycode");
                break;
            }
        }

        //에러 처리
        if (cityCode == -1) {
            System.out.println("citycode를 찾을 수 없습니다.");
        }

        //그 코드를 db에 저장하는 코드
        String sql = "INSERT INTO user (dep_region) VALUES (?)";
        jdbcTemplate.update(sql, cityCode);
        //db 에러 처리
    }

    @PostMapping("/api/basic/arrival/regions")
    public void arrivalRegion (@RequestBody RegionGetRequestDto region) {
        //도착역의 시/도 코드를 가져오는 코드
        String cities;
        City city = new City();
        try {
            cities = city.getCityCodeJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(cities);
        JSONArray itemsArray = jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");

        int cityCode = -1;
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            String cityname = item.getString("cityname");
            if (cityname.equals(region.getRegion())) {
                cityCode = item.getInt("citycode");
                break;
            }
        }

        //에러 처리
        if (cityCode == -1) {
            System.out.println("citycode를 찾을 수 없습니다.");
        }

        //그 코드를 db에 저장하는 코드
        String sql = "INSERT INTO user (arr_region) VALUES (?)";
        jdbcTemplate.update(sql, cityCode);
        //db 에러 처리
    }

    @PostMapping("/api/basic/departure")
    public void departureStation (@RequestBody StationGetRequestDto departure) {
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
        if(regionId == null) {
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

    @PostMapping("/api/basic/arrival")
    public void arrivalStation (@RequestBody StationGetRequestDto arrival) {
        //도착역의 시/도 코드를 db에서 가져오는 코드
        String sql = "SELECT arr_region FROM user";
        List<Integer> id = jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("arr_region");
                return id;
            }
        });
        Integer regionId = id.get(0);
        //db 에러 처리
        if(regionId == null) {
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
            if (nodeName.equals(arrival)) {
                nodeId = item.getString("nodeid");
                break;
            }
        }

        //에러 처리
        if (nodeId == null) {
            System.out.println("nodeId를 찾을 수 없습니다.");
        }

        //그 코드를 db에 저장하는 코드
        sql = "INSERT INTO user (arrival) VALUES (?)";
        jdbcTemplate.update(sql, nodeId);
        //db 에러 처리
    }
}
