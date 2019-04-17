package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
	private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private TextArea ta = new TextArea();
	
    @Override
    public void start(Stage primaryStage) {

    	BorderPane paneForTextField = new BorderPane();
    	paneForTextField.setPadding(new Insets(5, 5, 5, 5));
    	paneForTextField.setLeft(new Label("Message: "));
    	
    	TextField tf = new TextField();
    	tf.setAlignment(Pos.BOTTOM_RIGHT);
    	paneForTextField.setCenter(tf);
    	
    	BorderPane mainPane = new BorderPane();
    	mainPane.setCenter(new ScrollPane(ta));
    	mainPane.setBottom(paneForTextField);
    	
    	Scene scene = new Scene(mainPane, 450, 200);
    	primaryStage.setTitle("Client");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
    	tf.setOnKeyPressed(e -> {
    		if (e.getCode().equals(KeyCode.ENTER)) {
    			try {
					out.write(tf.getText() + "\r\n");
					out.flush();
					tf.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	});
    	
    	new Thread( () -> {
	        try {
	            this.socket = new Socket("localhost", 1337);
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	        if (this.socket != null) {
	            try {
	                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	                    
	            } catch (IOException ioe) {
	                ioe.printStackTrace();
	            }
	            while (true) {
					try {
						final String line = this.in.readLine();
						if (line != null) {
				            Platform.runLater( () -> {
								ta.appendText(line + '\n');
							});
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
    	}).start();
	}
}
