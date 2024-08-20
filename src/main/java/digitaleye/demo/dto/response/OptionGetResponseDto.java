package digitaleye.demo.dto.response;

public class OptionGetResponseDto {
    private int check;
    private int option;

    public OptionGetResponseDto(int check, int option) {
        this.check = check;
        this.option = option;
    }

    public int getCheck() {
        return check;
    }

    public int getOption() {
        return option;
    }
}
