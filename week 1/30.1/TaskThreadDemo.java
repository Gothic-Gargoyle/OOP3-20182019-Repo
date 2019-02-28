// Week 1 opdracht 30.1

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class TaskThreadDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Week 1 opdracht 30.1");
		StackPane pane = new StackPane();
		TextArea textarea = new TextArea();
		pane.getChildren().add(textarea);

                // Create tasks
                Runnable printA = new PrintChar('a', 100, textarea);
                Runnable printB = new PrintChar('b', 100, textarea);
                Runnable print100 = new PrintNum(100, textarea);
                // Create threads
                Thread thread1 = new Thread(printA);
                Thread thread2 = new Thread(printB);
                Thread thread3 = new Thread(print100);
                // Start threads
                thread1.start();
                thread2.start();
                thread3.start();

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}

// The task for printing a character a specified number of times
class PrintChar implements Runnable {
	private char charToPrint; // The character to print
	private int times; // The number of times to repeat
	private TextArea textarea;
	private String text = "";
	/**
	 * Construct a task with a specified character and number of times to print the
	 * character
	 */
	public PrintChar(char c, int t, TextArea texta) {
		charToPrint = c;
		times = t;
		textarea = texta;
	}

	@Override /**
				 * Override the run() method to tell the system what task to perform
				 */
	public void run() {
		for (int i = 0; i < times; i++) {
			text = Integer.toString(charToPrint);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					textarea.appendText(text);
				}
			});
		}
	}
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
	private int lastNum;
	private TextArea textarea;
	private String text = "";

	/** Construct a task for printing 1, 2, ..., n */
	public PrintNum(int n, TextArea texta) {
		lastNum = n;
		textarea = texta;
	}

	@Override /** Tell the thread how to run */
	public void run() {
		for (int i = 1; i <= lastNum; i++) {
			text = " " + Integer.toString(i);
			Platform.runLater(new Runnable() {
				@Override
                                public void run() {
                                        textarea.appendText(text);
                                }
                        });
		}
	}
}
