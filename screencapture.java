import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Mahafuz on 08-07-2017.
 * Help to take picture
 */
class ScreenShort {
    private void captureScreen(String fileName) throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));

    }
    private static int push = 1;

    public static void main(String[] args) throws Exception {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ScreenShort screenShort = new ScreenShort();
                try {
                    String s = "Screen"+push+".jpg";
                    screenShort.captureScreen(s);
                    push ++;
                    System.out.print(s+"\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,30000,30000);

    }

}
