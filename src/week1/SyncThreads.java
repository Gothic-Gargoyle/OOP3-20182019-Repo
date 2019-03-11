package week1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncThreads {
    Integer sum = 0;
    Object syncer = new Object();
//schrijf een programma die 1000 threads lanceerd, elke thread voegt 1 toe aan een
// variable som, die initieel 0 is, defineer een integer wrapper opbject om som in te stoppen
//run met én zonder syncronization om het effect te zien.
//gebruik newFixedThreadPool)) om een fixed aantal threads in de pool te houden.

    public static void main(String[] args) {
        SyncThreads syncthread = new SyncThreads();
        syncthread.main();
    }

    private void main(){
        //nieuwe fixedthreadpool, 1k threads
        ExecutorService executor = Executors.newFixedThreadPool(1000);

        //submit tasks naar de executer
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddPrintNum());
        }

    }
    class AddPrintNum implements Runnable {
        @Override
        public void run() {

            synchronized (syncer) {
                sum++;
                System.out.println(" " + sum);
            }

        }
    }
}




