package week1;
//(Parallel sum) Implement the following method using Fork/Join to find the sum of a list:
//
// public static double parallelSum(double[] list)
//
// Write a test program that finds the sum in a list of 1000 double values.
//
// !Note! : this is quite similar to LISTING 30.11 ParallelMax.java (see Blackboard).
// But now you create a private static class SumTask extends RecursiveTask<Double> { }.
/*
import java.util.concurrent.*;

public class ParallelSum {
    static double sum = 0;

    public static void main(String[] args) {
        // Create a list
        final int N = 1000;
        double[] list = new double[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
            System.out.println(i);
        }
    }

    public static double parallelSum(double[] list)
    {
        //implementeer met Fork/Join!
        RecursiveTask<Double> task = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

     private static class SumTask extends RecursiveTask<Double>
    {
        private final static int THRESHOLD = 1000;
        private double[] list;
        private double sum;
        private double start;
        private double mid;
        private double max;


        public SumTask(double[] list, double sum, double start, double mid, double max ) {
            this.list = list;
            this.sum = sum;
            this.start = start;
            this.mid = mid;
            this.max = max;

        }

        @Override
        public Integer compute() {
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++)
                    if (list[i] > max)
                        //tel op?
                return new Integer(max);

            } else {
                double mid = (start + max) / 2;
                RecursiveTask<Double> left = new SumTask(list, low, mid);
                RecursiveTask<Double> right = new SumTask(list, mid, high);
                right.fork();
                left.fork();
                return new Integer(Math.max(left.join().intValue(),
                        right.join().intValue()));
            }
        }
    }
}
*/