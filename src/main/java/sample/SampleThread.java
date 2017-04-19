package sample;

import java.util.logging.Logger;
import periodicThreadScheduler.annotations.PeriodicThread;

/**
 *
 * @author Sarkhan Rasullu
 */
@PeriodicThread(delayDay = 1, atHour = 3, atMinute = 0, atSecond = 0)
public class SampleThread implements Runnable {

    private static final Logger LOG = Logger.getLogger(SampleThread.class.getName());

    /**
     * run() method will be invoked periodically at date and time which you defined 
     *
     */
    @Override
    public void run() {
        //do something
    }

}
