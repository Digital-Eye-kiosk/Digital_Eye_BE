package DigitalEye.demo.service;

import DigitalEye.demo.dto.request.both.StationGetRequestDto;
import DigitalEye.demo.dto.response.both.StationGetResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static DigitalEye.demo.service.GetCodeService.getCityCode;
import static DigitalEye.demo.service.api.OpenApiService.getStationJson;

public class StationGetService {


    public List<StationGetResponseDto> stationService(StationGetRequestDto stationGetRequestDto) throws IOException {
        int cityCode = getCityCode(stationGetRequestDto.station());
        String cityCodeString = String.valueOf(cityCode);
        String stationJson = getStationJson(cityCodeString);

        List<StationGetResponseDto> stations = parseStationJson(stationJson);

        return stations;
    }

    private List<StationGetResponseDto> parseStationJson(String stationJson) throws IOException {
        ObjectMapper objectMapper = null;
        JsonNode rootNode = objectMapper.readTree(stationJson);
        List<StationGetResponseDto> stationList = new ArrayList<>();

        JsonNode stationsNode = rootNode.path("response").path("body").path("items").path("item");

        if (stationsNode.isArray()) {
            for (JsonNode node : stationsNode) {
                String nodeId = node.path("nodeid").asText();  // 기차역 ID 추출
                String nodeName = node.path("nodename").asText();  // 기차역 이름 추출

                StationGetResponseDto dto = new StationGetResponseDto(nodeId, nodeName);
                stationList.add(dto);
            }
        }

        return stationList;
    }
}
