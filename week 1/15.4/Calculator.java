import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class Calculator extends Application {
  private TextField tfNumber1 = new TextField();
  private TextField tfNumber2 = new TextField();
  private TextField tfResult = new TextField();


  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    Button badd = new Button("+");
    Button bsub = new Button("-");
    Button bmul = new Button("*");
    Button bdiv = new Button("/");

    badd.setOnAction(e -> calculate("add"));
    bsub.setOnAction(e -> calculate("sub"));
    bmul.setOnAction(e -> calculate("mul"));
    bdiv.setOnAction(e -> calculate("div"));

    GridPane gridPane = new GridPane();

    gridPane.add(new Label("First number:"), 0, 0);
    gridPane.add(tfNumber1, 1, 0);
    gridPane.add(new Label("Second number:"), 2, 0);
    gridPane.add(tfNumber2, 3, 0);
    gridPane.add(new Label("Result:"), 4, 0);
    gridPane.add(tfResult, 5, 0);

    gridPane.add(badd, 0, 1);
    gridPane.add(bsub, 1, 1);
    gridPane.add(bmul, 2, 1);
    gridPane.add(bdiv, 3, 1);



    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 900, 200);
    primaryStage.setTitle("Calculator"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // Must request focus after the primary stage is displayed
    gridPane.requestFocus();
  }
  private void calculate(String type) {
    int first = Integer.parseInt(tfNumber1.getText());
    int second = Integer.parseInt(tfNumber2.getText());
    int result = 0;
    if (type == "add") {
      result = first + second;
    } else if (type == "sub") {
      result = first - second;
    } else if (type == "mul") {
      result = first * second;
    } else if (type == "div") {
      result = first / second;
    }
    tfResult.setText(String.valueOf(result));
  }
}
