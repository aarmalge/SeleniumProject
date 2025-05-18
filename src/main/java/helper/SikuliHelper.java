package helper;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliHelper {

    private Screen screen;

    public SikuliHelper() {
        this.screen = new Screen();
    }

    public void clickOkButton(String imagePath) {
        try {
            Pattern okButton = new Pattern(imagePath);
            screen.wait(okButton, 10);
            screen.click(okButton);
            System.out.println("Clicked OK button successfully.");
        } catch (Exception e) {
            System.out.println("Failed to click OK button: " + e.getMessage());
        }
    }
}
