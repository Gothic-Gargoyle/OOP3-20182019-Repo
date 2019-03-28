package week1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 800;
        int height = 800;
        int rows = 3;
        int columns = 3;
        GridPane grid = new GridPane();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                ColumnConstraints colCon = new ColumnConstraints();
                colCon.prefWidthProperty().bind(primaryStage.widthProperty().divide(columns));
                grid.getColumnConstraints().add(colCon);

                RowConstraints rowCon = new RowConstraints();
                rowCon.prefHeightProperty().bind(primaryStage.heightProperty().divide(rows));
                grid.getRowConstraints().add(rowCon);

                Line hor = new Line(0, 0, 800, 0);
                hor.setStyle("-fx-stroke: blue; -fx-stroke-width: 3px;");
                grid.add(hor, row, col);
                GridPane.setValignment(hor, VPos.TOP);

                Line ver = new Line(0, 0, 0, 800);
                ver.setStyle("-fx-stroke: red; -fx-stroke-width: 3px;");
                grid.add(ver, row, col);

            }
        }


        Scene root = new Scene(grid, width, height);
        primaryStage.setTitle("3x3 grid");
        primaryStage.setScene(root);

        grid.prefWidthProperty().bind(root.widthProperty());
        grid.prefHeightProperty().bind(root.heightProperty());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}