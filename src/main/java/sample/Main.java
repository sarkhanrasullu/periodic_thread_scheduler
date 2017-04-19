package sample;

import java.lang.annotation.Annotation;
import periodicThreadScheduler.annotations.PeriodicThread;
import periodicThreadScheduler.starter.ThreadSchedulerStarter;

/**
 *
 * @author Sarkhan Rasullu
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ThreadSchedulerStarter.initializeAllThreads("periodicThreadScheduler.thread");
  
    }
}
