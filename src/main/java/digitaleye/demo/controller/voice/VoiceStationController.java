package digitaleye.demo.controller.voice;

import digitaleye.demo.dto.response.voice.RegionGetResponseDto;
import digitaleye.demo.dto.response.voice.StationGetResponseDto;
import digitaleye.demo.service.stt.SpeechToText;
import digitaleye.demo.service.api.City;
import digitaleye.demo.service.api.TrainStation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RestController
public class VoiceStationController {

    private final JdbcTemplate jdbcTemplate;

    public VoiceStationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/audio/departure/regions")
    public RegionGetResponseDto departureRegion () {
        //stt 함수로 사용자 응답을 받아냄
        String text = null;
        try {
            SpeechToText speechToText = new SpeechToText();
            text = speechToText.streamingMicRecognize(5);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }

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
            if (cityName.equals(text)) {
                cityCode = item.getInt("citycode");
                break;
            }
        }

        //출발역의 시/도가 제대로 받아졌는지 확인
        String region = text;
        if(cityCode == -1) {
            return new RegionGetResponseDto(0, null);
        }
        else {
            //그 코드를 db에 저장하는 코드
            String sql = "INSERT INTO user (dep_region) VALUES (?)";
            jdbcTemplate.update(sql, cityCode);
            //db 에러 처리
            return new RegionGetResponseDto(1, region);
        }
    }

    @PostMapping("/api/audio/arrival/regions")
    public RegionGetResponseDto arrivalRegion () {
        //stt 함수로 사용자 응답을 받아냄
        String text = null;
        try {
            SpeechToText speechToText = new SpeechToText();
            text = speechToText.streamingMicRecognize(5);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }

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
            String cityName = item.getString("cityname");
            if (cityName.equals(text)) {
                cityCode = item.getInt("citycode");
                break;
            }
        }

        //도착역의 시/도가 제대로 받아졌는지 확인
        String region = text;
        if(cityCode == -1) {
            return new RegionGetResponseDto(0, null);
        }
        else {
            //그 코드를 db에 저장하는 코드
            String sql = "INSERT INTO user (arr_region) VALUES (?)";
            jdbcTemplate.update(sql, cityCode);
            //db 에러 처리
            return new RegionGetResponseDto(1, region);
        }
    }

    @PostMapping("/api/audio/departure")
    public StationGetResponseDto departureStation () {
        //stt 함수로 사용자 응답을 받아냄
        String text = null;
        try {
            SpeechToText speechToText = new SpeechToText();
            text = speechToText.streamingMicRecognize(5);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }

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
            if (nodeName.equals(text)) {
                nodeId = item.getString("nodeid");
                break;
            }
        }

        //출발역이 제대로 받아졌는지 확인
        String station = text;
        if (nodeId == null) {
            return new StationGetResponseDto(0, null);
        }
        else {
            //그 코드를 db에 저장하는 코드
            sql = "INSERT INTO user (departure) VALUES (?)";
            jdbcTemplate.update(sql, nodeId);
            //db 에러 처리
            return new StationGetResponseDto(1, station);
        }
    }

    @PostMapping("/api/audio/arrival")
    public StationGetResponseDto arrivalStation () {
        //stt 함수로 사용자 응답을 받아냄
        String text = null;
        try {
            SpeechToText speechToText = new SpeechToText();
            text = speechToText.streamingMicRecognize(5);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }

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
            if (nodeName.equals(text)) {
                nodeId = item.getString("nodeid");
                break;
            }
        }

        //도착역이 제대로 받아졌는지 확인
        String station = text;
        if (nodeId == null) {
            return new StationGetResponseDto(0, null);
        } else {
            //그 코드를 db에 저장하는 코드
            sql = "INSERT INTO user (arrival) VALUES (?)";
            jdbcTemplate.update(sql, nodeId);
            //db 에러 처리
            return new StationGetResponseDto(1, station);
        }
    }
}
