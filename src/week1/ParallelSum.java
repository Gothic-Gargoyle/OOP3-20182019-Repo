package week1;
//(Parallel sum) Implement the following method using Fork/Join to find the sum of a list:
//
// public static double parallelSum(double[] list)
//
// Write a test program that finds the sum in a list of 1000 double values.
//
// !Note! : this is quite similar to LISTING 30.11 ParallelMax.java (see Blackboard).
// But now you create a private static class SumTask extends RecursiveTask<Double> { }.

import java.util.concurrent.*;

public class ParallelSum {
    static double sum = 0;
    public static void main(String[] args)
    {
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
        ForkJoinPool<double> pool = new ForkJoinPool();

        return sum;
    }

   /* private static class SumTask extends RecursiveTask<Double>
    {
        private final static int THRESHOLD = 1000;
        private int[] list;
        private int low;
        private int high;
    }

     private static class MaxTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 1000;
        private int[] list;
        private int low;
        private int high;

        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        public Integer compute() {
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++)
                    if (list[i] > max)
                        max = list[i];
                return new Integer(max);

            } else {
                int mid = (low + high) / 2;
                RecursiveTask<Integer> left = new MaxTask(list, low, mid);
                RecursiveTask<Integer> right = new MaxTask(list, mid, high);
                right.fork();
                left.fork();
                return new Integer(Math.max(left.join().intValue(),
                        right.join().intValue()));
            }
        }
    }
*/
}
