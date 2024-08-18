//package DigitalEye.demo.controller.normal;
//
//import DigitalEye.demo.dto.request.normal.RegionID;
//import DigitalEye.demo.openapi.model.Station;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.swing.plaf.synth.Region;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@RestController
//public class StationController {
//    private final JdbcTemplate jdbcTemplate;
//
//    public StationController(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @PostMapping("/api/basic/departure/regions")
//    public void departureRegion (@RequestParam Region region) {
//        //출발역의 시/도 코드를 가져오는 코드
//
//        //그 코드를 db에 저장하는 코드
//        String sql = "INSERT INTO user (dep_region) VALUES (?)";
//        jdbcTemplate.update(sql, /*시/도 코드*/);
//    }
//
//    @PostMapping("/api/basic/arrival/regions")
//    public void arrivalRegion (@RequestParam Region region) {
//        //도착역의 시/도 코드를 가져오는 코드
//        //그 코드를 db에 저장하는 코드
//        String sql = "INSERT INTO user (arr_region) VALUES (?)";
//        jdbcTemplate.update(sql, /*시/도 코드*/);
//    }
//
//    @PostMapping("/api/basic/departure")
//    public void departureStation (@RequestParam Station station) {
//        //출발역의 시/도 코드를 db에서 가져오는 코드
//        String sql = "SELECT dep_region FROM user";
//        jdbcTemplate.query(sql, new RowMapper<RegionID>() {
//            @Override
//            public RegionID mapRow(ResultSet rs, int rowNum) throws SQLException {
//                int regionId = rs.getInt("dep_region");
//                return regionId;
//            }
//        });
//        //시/도 코드를 통해 해당 역의 코드 조회
//
//        //그 코드를 db에 저장하는 코드
//        sql = "INSERT INTO user (departure) VALUES (?)";
//        jdbcTemplate.update(sql, /*역 코드*/);
//    }
//
//    @PostMapping("/api/basic/arrival")
//    public void arrivalStation (@RequestParam Station station) {
//        //도착역의 시/도 코드를 db에서 가져오는 코드
//        String sql = "SELECT arr_region FROM user";
//        jdbcTemplate.query(sql, new RowMapper<RegionID>() {
//            @Override
//            public RegionID mapRow(ResultSet rs, int rowNum) throws SQLException {
//                int regionId = rs.getInt("arr_region");
//                return regionId;
//            }
//        });
//        //시/도 코드를 통해 해당 역의 코드 조회
//
//        //그 코드를 db에 저장하는 코드
//        sql = "INSERT INTO user (arrival) VALUES (?)";
//        jdbcTemplate.update(sql, /*역 코드*/);
//    }
//}
