import java.util.concurrent.*;

public class ParallelSum {
  public static void main(String[] args) {
    // Create a list
    final int N = 1000;
    double[] list = new double[N];
    for (int i = 0; i < list.length; i++)
      list[i] = i;

    long startTime = System.currentTimeMillis();
    System.out.println("\nThe sum of numbers is " + sum(list));
    long endTime = System.currentTimeMillis();
    System.out.println("Number of processors is " +
      Runtime.getRuntime().availableProcessors());
    System.out.println("Time with " + (endTime - startTime) + " milliseconds");
  }

  public static double sum(double[] list) {
    RecursiveTask<Double> task = new MaxTask(list, 0, list.length);
    ForkJoinPool pool = new ForkJoinPool();
    return pool.invoke(task);
  }

  private static class MaxTask extends RecursiveTask<Double> {
    private final static int THRESHOLD = 1000;
    private double[] list;
    private int low;
    private int high;

    public MaxTask(double[] list, int low, int high) {
      this.list = list;
      this.low = low;
      this.high = high;
    }

    @Override
    public Double compute() {
      if (high - low < THRESHOLD) {
        double sum = 0;
        for (int i = low; i < high; i++)
          sum = sum + list[i];
        return new Double(sum);
      }
      else {
        int mid = (low + high) / 2;
        RecursiveTask<Double> left = new MaxTask(list, low, mid);
        RecursiveTask<Double> right = new MaxTask(list, mid, high);

        right.fork();
        left.fork();
        return new Double(Math.max(left.join().doubleValue(), right.join().doubleValue()));
      }
    }
  }
}
