package DigitalEye.demo.openapi.util;

//공통으로 사용되는 key, url정보를 위한 class
public class ApiUtils {

    private static final String BASE_URL = "http://apis.data.go.kr/1613000/TrainInfoService";
    private static final String SERVICE_KEY =
            "3L9RQEx6rksngfO6dNnpfgs/VXkAVhLHGg8KVnASxUs9fyGlwmxHaEQHKoF4hRTrZM3wQ2YkoNFWuQoJI70puA==";
    //각각에 맞는 url생성
    public static String buildTrainInfoUrl(String depPlaceId, String arrPlaceId, String depPlandTime) {
        return BASE_URL + "/getStrtpntAlocFndTrainInfo?serviceKey=" + SERVICE_KEY
                + "&depPlaceId=" + depPlaceId + "&arrPlaceId=" + arrPlaceId
                + "&depPlandTime=" + depPlandTime + "&_type=json";
    }

    public static String buildStationsUrl(String cityCode) {
        return BASE_URL + "/getCtyAcctoTrainSttnList?serviceKey=" + SERVICE_KEY
                + "&cityCode=" + cityCode + "&_type=json";
    }

    public static String buildVehicleTypeUrl() {
        return BASE_URL + "/getVhcleKndList?serviceKey=" + SERVICE_KEY + "&_type=json";
    }

    public static String buildCityCodesUrl() {
        return BASE_URL + "/getCtyCodeList?serviceKey=" + SERVICE_KEY + "&_type=json";
    }
}

/*
클래스에서 공공데이터 api호출 시

TrainInfoService trainInfoService = new TrainInfoService();
TrainInfo trainInfo = trainInfoService.getTrainInfo("NAT010000", "NAT011668", "20230817");

StationListService stationListService = new StationListService();
Station[] stations = stationListService.getStationsByCity("22");

VehicleTypeService vehicleTypeService = new VehicleTypeService();
VehicleType[] vehicleTypes = vehicleTypeService.getVehicleTypes();

CityCodeService cityCodeService = new CityCodeService();
CityCode[] cityCodes = cityCodeService.getCityCodes();

 */
