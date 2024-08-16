package speechrecognition;

public class SpeechRecognitionApp {
    public static void main(String[] args) {
        try {
            StreamingSpeechRecognizer.streamingMicRecognize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

