package sample;

import java.util.logging.Logger;
import periodicThreadScheduler.annotations.PeriodicThread;

/**
 *
 * @author Sarkhan Rasullu
 */
@PeriodicThread(delayDay = 0, atHour = 21, atMinute = 46, atSecond = 30)
public class SampleThread implements Runnable {

    private static final Logger LOG = Logger.getLogger(SampleThread.class.getName());

    /**
     * run() method will be invoked periodically at date and time which you defined 
     *
     */
    @Override
    public void run() {
        System.out.println("sample thread is started");
        //do something
    }

}
