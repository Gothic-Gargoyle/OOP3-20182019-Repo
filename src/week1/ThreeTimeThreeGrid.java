package week1;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/*
(Display a 3 * 3 grid) Write a program that displays a 3 * 3 grid, as shown in Figure 14.47c.
Use red for vertical lines and blue for horizontals.
The lines are automatically resized when the window is resized.
Use pane.widthProperty() and pane.heightProperty() to set endpoints of the lines.
Resizing is accomplished by binding properties, e.g. "line1.endXProperty().bind(pane.widthProperty());"

Gebaseerd op code van J. Hobma, code geprobeerd te begrijpen en eigen te maken.

 */
public class ThreeTimeThreeGrid extends Application {

    @Override
    public void start(Stage primaryStage)  {

        int width = 600;
        int height = 600;
        int rows = 3;
        int cols = 3;
        int len = 10;
        GridPane grid = new GridPane();

//ine1.endXProperty().bind(pane.widthProperty());
        for(int row = 0 ; row < rows ; row++) {
            for (int col = 0; col < cols ; col++) {

                //constrain hoogte van een cel
                ColumnConstraints colCon = new ColumnConstraints();
                colCon.prefWidthProperty().bind(primaryStage.widthProperty().divide(cols));
                grid.getColumnConstraints().add(colCon);

                //constrain breedte van een cel
                RowConstraints rowCon = new RowConstraints();
                rowCon.prefHeightProperty().bind(primaryStage.heightProperty().divide(rows));
                grid.getRowConstraints().add(rowCon);

                //draw blue horizontal lines
                Line line1 = new Line(0,0,600,0);
                line1.setStroke(Color.RED);
                grid.add(line1, row, col);
                GridPane.setValignment(line1, VPos.TOP);

                //draw blue horizontal lines
                Line line2 = new Line(0,0,0,600);
                line2.setStroke(Color.BLUE);
                grid.add(line2, row, col);
            };
        }

        Scene root = new Scene(grid,width,height);
        primaryStage.setTitle("ThreeTimesThreeGrid");
        primaryStage.setScene(root);

        primaryStage.show();

    }
    public static void main (String[]args){
        Application.launch(args);
    }

}