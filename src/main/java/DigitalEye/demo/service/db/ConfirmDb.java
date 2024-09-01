package DigitalEye.demo.service.db;

import DigitalEye.demo.domain.KTXSeat;
import DigitalEye.demo.domain.NonKTXSeat;
import DigitalEye.demo.domain.Train;
import DigitalEye.demo.domain.User;
import DigitalEye.demo.dto.request.normal.ConfirmRequestDto;
import DigitalEye.demo.dto.request.voice.ConfirmRequestVoiceDto;
import DigitalEye.demo.dto.request.voice.OnlyIdRequestDto;
import DigitalEye.demo.repository.KTXRepository;
import DigitalEye.demo.repository.NonKTXRepository;
import DigitalEye.demo.repository.TrainRepository;
import DigitalEye.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConfirmDb {
    private static final KTXRepository ktxRepository = null;
    private static final NonKTXRepository nonKTXRepository = null;


    public static void confirmNormalDb(UserRepository userRepository,TrainRepository trainRepository, ConfirmRequestDto confirmRequestDto){
        // 사용자 ID로 User 엔티티를 조회합니다.
        User user = userRepository.findById(confirmRequestDto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        //train ID로 Train 엔티티 조회
        Train train = trainRepository.findById(confirmRequestDto.train_table_id())
                .orElseThrow(() -> new RuntimeException("Train not found"));

        if( train.getTrainType() == "KTX"){
            //train ID로 KTXSeat 엔티티 조회
            KTXSeat ktxSeat = ktxRepository.findById(confirmRequestDto.train_table_id())
                    .orElseThrow(() -> new RuntimeException("Train not found"));
            //seat문자열 "," 기준 분리하여 배열로 가공
            String[] seatArray = confirmRequestDto.seat().split(",");

            for (String seat : seatArray) {
                // 예: "1-3"이면 "-"로 나눠서 carNum과 seatNum을 구분
                String[] seatInfo = seat.split("-");
                int carNum = Integer.parseInt(seatInfo[0]);  // 예: "1"
                int seatNum = Integer.parseInt(seatInfo[1]); // 예: "3"

                ktxSeat = updateKTXSeat(ktxSeat,carNum,seatNum);
            }
        }else {
            //train ID로 nonKTXSeat 엔티티 조회
            NonKTXSeat nonktxSeat = nonKTXRepository.findById(confirmRequestDto.train_table_id())
                    .orElseThrow(() -> new RuntimeException("Train not found"));

            //seat문자열 "," 기준 분리하여 배열로 가공
            String[] seatArray = confirmRequestDto.seat().split(",");

            for (String seat : seatArray) {
                // 예: "1-3"이면 "-"로 나눠서 carNum과 seatNum을 구분
                String[] seatInfo = seat.split("-");
                int carNum = Integer.parseInt(seatInfo[0]);  // 예: "1"
                int seatNum = Integer.parseInt(seatInfo[1]); // 예: "3"

                nonktxSeat = updateNonKTXSeat(nonktxSeat, carNum, seatNum);
            }


        }
        return;
    }
    public static void confirmVoiceDb(TrainRepository trainRepository, ConfirmRequestVoiceDto confirmRequestVoiceDto){
        //train ID로 Train 엔티티 조회
        Train train = trainRepository.findById(confirmRequestVoiceDto.train_table_id())
                .orElseThrow(() -> new RuntimeException("Train not found"));
        if( train.getTrainType() == "KTX"){
            //train ID로 KTXSeat 엔티티 조회
            KTXSeat ktxSeat = ktxRepository.findById(confirmRequestVoiceDto.train_table_id())
                    .orElseThrow(() -> new RuntimeException("Train not found"));
            //seat문자열 "," 기준 분리하여 배열로 가공
            String[] seatArray = confirmRequestVoiceDto.seat().split(",");

            for (String seat : seatArray) {
                // 예: "1-3"이면 "-"로 나눠서 carNum과 seatNum을 구분
                String[] seatInfo = seat.split("-");
                int carNum = Integer.parseInt(seatInfo[0]);  // 예: "1"
                int seatNum = Integer.parseInt(seatInfo[1]); // 예: "3"

                ktxSeat = updateKTXSeat(ktxSeat,carNum,seatNum);
            }
        }else {
            //train ID로 nonKTXSeat 엔티티 조회
            NonKTXSeat nonktxSeat = nonKTXRepository.findById(confirmRequestVoiceDto.train_table_id())
                    .orElseThrow(() -> new RuntimeException("Train not found"));

            //seat문자열 "," 기준 분리하여 배열로 가공
            String[] seatArray = confirmRequestVoiceDto.seat().split(",");

            for (String seat : seatArray) {
                // 예: "1-3"이면 "-"로 나눠서 carNum과 seatNum을 구분
                String[] seatInfo = seat.split("-");
                int carNum = Integer.parseInt(seatInfo[0]);  // 예: "1"
                int seatNum = Integer.parseInt(seatInfo[1]); // 예: "3"

                nonktxSeat = updateNonKTXSeat(nonktxSeat, carNum, seatNum);
            }
        }
        return;
    }

    public static KTXSeat updateKTXSeat(KTXSeat ktxSeat, int carNum, int seatNum){
        // 각 carNum에 해당하는 문자열의 특정 자리를 업데이트
        switch (carNum) {
            case 1:
                ktxSeat.setCarNum1(updateSeatString(ktxSeat.getCarNum1(), seatNum));
                break;
            case 2:
                ktxSeat.setCarNum2(updateSeatString(ktxSeat.getCarNum2(), seatNum));
                break;
            case 3:
                ktxSeat.setCarNum3(updateSeatString(ktxSeat.getCarNum3(), seatNum));
                break;
            case 4:
                ktxSeat.setCarNum4(updateSeatString(ktxSeat.getCarNum4(), seatNum));
                break;
            case 5:
                ktxSeat.setCarNum5(updateSeatString(ktxSeat.getCarNum5(), seatNum));
                break;
            case 6:
                ktxSeat.setCarNum6(updateSeatString(ktxSeat.getCarNum6(), seatNum));
                break;
            case 7:
                ktxSeat.setCarNum7(updateSeatString(ktxSeat.getCarNum7(), seatNum));
                break;
            case 8:
                ktxSeat.setCarNum8(updateSeatString(ktxSeat.getCarNum8(), seatNum));
                break;
            case 9:
                ktxSeat.setCarNum9(updateSeatString(ktxSeat.getCarNum9(), seatNum));
                break;
            case 10:
                ktxSeat.setCarNum10(updateSeatString(ktxSeat.getCarNum10(), seatNum));
                break;
            case 11:
                ktxSeat.setCarNum11(updateSeatString(ktxSeat.getCarNum11(), seatNum));
                break;
            case 12:
                ktxSeat.setCarNum12(updateSeatString(ktxSeat.getCarNum12(), seatNum));
                break;
            case 13:
                ktxSeat.setCarNum13(updateSeatString(ktxSeat.getCarNum13(), seatNum));
                break;
            case 14:
                ktxSeat.setCarNum14(updateSeatString(ktxSeat.getCarNum14(), seatNum));
                break;
            case 15:
                ktxSeat.setCarNum15(updateSeatString(ktxSeat.getCarNum15(), seatNum));
                break;
            default:
                throw new IllegalArgumentException("Invalid car number: " + carNum);
        }
        return ktxSeat;
    }
    public static NonKTXSeat updateNonKTXSeat(NonKTXSeat nonKTXSeat, int carNum, int seatNum){
        // 각 carNum에 해당하는 문자열의 특정 자리를 업데이트
        switch (carNum) {
            case 1:
                nonKTXSeat.setCarNum1(updateSeatString(nonKTXSeat.getCarNum1(), seatNum));
                break;
            case 2:
                nonKTXSeat.setCarNum2(updateSeatString(nonKTXSeat.getCarNum2(), seatNum));
                break;
            case 3:
                nonKTXSeat.setCarNum3(updateSeatString(nonKTXSeat.getCarNum3(), seatNum));
                break;
            case 4:
                nonKTXSeat.setCarNum4(updateSeatString(nonKTXSeat.getCarNum4(), seatNum));
                break;
            case 5:
                nonKTXSeat.setCarNum5(updateSeatString(nonKTXSeat.getCarNum5(), seatNum));
                break;
            default:
                throw new IllegalArgumentException("Invalid car number: " + carNum);
        }
        return nonKTXSeat;
    }


    // 주어진 자리 번호에 해당하는 문자열의 세 번째 자리를 1로 변경하는 메소드
    private static String updateSeatString(String carString, int seatNum) {
        StringBuilder sb = new StringBuilder(carString);
        sb.setCharAt(seatNum - 1, '1'); // 0부터 시작하므로 seatNum - 1 위치를 변경
        return sb.toString();
    }

}
