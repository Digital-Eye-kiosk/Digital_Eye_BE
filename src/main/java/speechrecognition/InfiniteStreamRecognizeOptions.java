package speechrecognition;

public class InfiniteStreamRecognizeOptions {
    public String langCode;

    public InfiniteStreamRecognizeOptions(String langCode) {
        this.langCode = langCode;
    }

    // 플래그에서 옵션을 파싱하는 메소드
    public static InfiniteStreamRecognizeOptions fromFlags(String[] args) {
        // 여기서 args를 파싱하여 langCode 등을 설정합니다.
        // 예를 들어, args[0]에 언어 코드가 있다고 가정합니다.
        if (args.length > 0) {
            return new InfiniteStreamRecognizeOptions(args[0]);
        } else {
            return null;
        }
    }
}
