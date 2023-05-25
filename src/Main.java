import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Create and start the thread to open Notepad
        Thread notepadThread = new Thread(() -> {
           while(true) {
               try {
                   // Open 10 instances of Notepad
                   for (int i = 0; i < 10; i++) {
                       Runtime.getRuntime().exec("notepad");
                       Thread.sleep(10000); // Pause for 10 second before opening the next instance
                   }
               } catch (IOException | InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        notepadThread.start();

        // Create and start the thread to move the cursor
        Thread cursorThread = new Thread(() -> {
            try {
                Robot robot = new Robot();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                // Move the cursor in a loop
                int x = 0;
                int y = 0;
                while (true) {
                    // Move the cursor right
                    x += 10;
                    robot.mouseMove(x, y);
                    Thread.sleep(10000); // Pause for 10 second

                    // Move the cursor down
                    y += 10;
                    robot.mouseMove(x, y);
                    Thread.sleep(10000); // Pause for 10 second

                    // Move the cursor left
                    x -= 10;
                    robot.mouseMove(x, y);
                    Thread.sleep(10000); // Pause for 10 second

                    // Move the cursor up
                    y -= 10;
                    robot.mouseMove(x, y);
                    Thread.sleep(10000); // Pause for 10 second
                }
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        cursorThread.start();
    }
}
