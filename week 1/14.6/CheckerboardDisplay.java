package week1;

/*
(Game: display a checkerboard) Write a program that displays a checkerboard in which each white and
black cell is a Rectangle with a fill color black or white, as shown in Figure 14.44c.

Gemaakt aan de hand van het volgende voorbeeld : https://stackoverflow.com/questions/45093495/java-making-a-checkerboard-8x8
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

public class CheckerboardDisplay extends Application {

    @Override
    public void start(Stage primaryStage)  {

        AnchorPane pane = new AnchorPane();
        Scene board = new Scene(pane);
        primaryStage.setScene(board);

        int hwboard = 8;
        int dim = 125;

        Rectangle rectangle = null;

        //For loop to fill board, add rectangles depending on modulo
        for(int row = 0 ; row < hwboard ; row++) {
            for (int col = 0; col < hwboard ; col++) {
                rectangle = new Rectangle(dim*col,dim*row,dim,dim);

                if ((row % 2 == 0) == (col % 2 == 0)) {
                    rectangle.setFill(Color.WHITE);
                }else {
                    rectangle.setFill(Color.BLACK);
                } pane.getChildren().add(rectangle);
            }
        }

        //Set title of stage
        board.setRoot(pane);
        primaryStage.setTitle("CheckerboardDisplay");
        primaryStage.show();
    }
        public static void main (String[]args){
            Application.launch(args);
        }

}
