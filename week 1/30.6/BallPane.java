import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.application.Platform;

public class BallPane extends Pane implements Runnable {
  public final double radius = 20;
  private double x = radius, y = radius;
  private double dx = 1, dy = 1;
  private Circle circle = new Circle(x, y, radius);
  private volatile int wachttijd = 10;
  private volatile boolean animate = true;
  private Integer myMonitorObject = 1;

  public BallPane() {
    circle.setFill(Color.GREEN); // Set ball color
    getChildren().add(circle); // Place a ball into this pane

  }

  public void play() {
    this.animate = true;
  }

  public void pause() {
    this.animate = false;
  }

  public void increaseSpeed() {
    wachttijd = wachttijd > 2 ? wachttijd - 1 : 3;
  }

  public void decreaseSpeed() {
    wachttijd = wachttijd + 1;
  }

  public DoubleProperty rateProperty() {
    //return animation.rateProperty();
    return null;
  }

  protected void moveBall() {
    // Check boundaries
    if (x < radius || x > getWidth() - radius) {
      dx *= -1; // Change ball move direction
    }
    if (y < radius || y > getHeight() - radius) {
      dy *= -1; // Change ball move direction
    }

    // Adjust ball position
    x += dx;
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
  }

  @Override
  public void run() {
    while (true) {
      while (animate) {
        try {
          Thread.sleep(wachttijd);
        } catch (InterruptedException e) {
          System.out.println("Doeg");
        }
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            moveBall();
          }
        });
      }
    }
  }

}
