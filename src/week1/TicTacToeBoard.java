package week1;


/*
(Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as shown in Figure 14.43b.
A cell may be X, O, or empty. What to display at each cell is randomly decided.
The X and O are images in the files x.gif and o.gif. You should use a GridPane,
and you can use Math.Random() to place either X or O.
*/

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class TicTacToeBoard extends Application {

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
                ColumnConstraints colCon = new ColumnConstraints();
                colCon.prefWidthProperty().bind(primaryStage.widthProperty().divide(cols));
                grid.getColumnConstraints().add(colCon);

                RowConstraints rowCon = new RowConstraints();
                rowCon.prefHeightProperty().bind(primaryStage.heightProperty().divide(rows));
                grid.getRowConstraints().add(rowCon);

                //draw blue horizontal lines
                Line line1 = new Line(0,0,600,0);
                line1.setStroke(Color.RED);
                grid.add(line1, row, col);
                GridPane.setValignment(line1, VPos.TOP);
                StackPane sp = new StackPane();
                Image img = new Image("javafx.jpg");
                ImageView imgView = new ImageView(img);

                //draw blue horizontal lines
                Line line2 = new Line(0,0,0,600);
                line2.setStroke(Color.BLUE);
                grid.add(line2, row, col);
            };
        }

        Scene root = new Scene(grid,width,height);
        primaryStage.setTitle("TicTacToeBoard");
        primaryStage.setScene(root);

        primaryStage.show();

    }
    public static void main (String[]args){
        Application.launch(args);
    }

}
