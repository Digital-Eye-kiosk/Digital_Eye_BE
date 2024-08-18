package speechrecognition;

public class sttTest {
    public static void main(String[] args) {
        try {
            // 5초 동안 음성을 인식하고 그 결과를 받아오는 예시
            String recognizedText = StreamingSpeechRecognizer.streamingMicRecognize(5);

            // 인식된 텍스트 출력
            System.out.println("텍스트:" + recognizedText);

            // 여기서 recognizedText를 사용하여 추가적인 로직을 수행할 수 있습니다.
            if (recognizedText.contains("안녕하세요")) {
                System.out.println("good");
            } else {
                System.out.println("other");
            }

        } catch (Exception e) {
            System.out.println("wrong " + e.getMessage());
            e.printStackTrace();
        }
    }
}
