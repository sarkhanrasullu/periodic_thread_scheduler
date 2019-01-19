package periodicThreadScheduler.thread;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.log4j.Logger;
import periodicThreadScheduler.SchedularUtil;
import periodicThreadScheduler.annotations.PeriodicThread;

/**
 * this class is for scheduleing threads periodically at specific time.
 *
 * @author Sarkhan Rasullu
 */
public class ScheduledThreadWrapper {

    private static final Logger LOG = Logger.getLogger(ScheduledThreadWrapper.class.getName());
//    private boolean started = false;
    private final Runnable r;
    private final ScheduledExecutorService executorService;

    public ScheduledThreadWrapper(Runnable r, ScheduledExecutorService executorService) {
        this.r = r;
        this.executorService = executorService;
    }

    public void schedule() {
        debug("scheduling");

        PeriodicThread p = r.getClass().getAnnotationsByType(PeriodicThread.class)[0];

        debug(p.delayDay() + "," + p.atHour() + "," + p.atMinute() + "," + p.atSecond());
        Date scheduledDate = SchedularUtil.schedule(executorService, p.atHour(), p.atMinute(), p.atSecond(), p.delayDay(), r);

//        this.started = true;
        debug(" scheduled for:" + scheduledDate);
    }

    public final void startSchedule() {
        debug(" run method is invoked");
//        if (started) {
//            try {
//                r.run();
//            } catch (Exception ex) {
//                LOG.error(null, ex);
//            }
//        }
        schedule();
    }

    private void debug(String message) {
        System.out.println("cron:" + this.getClass().getName() + "=>" + message);
    }
}
