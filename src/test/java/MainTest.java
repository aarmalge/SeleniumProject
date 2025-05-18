import helper.SikuliHelper;


public class MainTest {
    public static void main(String[] args) {
        SikuliHelper sikuliHelper = new SikuliHelper();

        // Path to your OK button image
        String okButtonImage = "src/main/resources/images/ok_button.png";

        // Click the OK button popup
        sikuliHelper.clickOkButton(okButtonImage);

        System.out.println("Test Completed!");
    }
}

