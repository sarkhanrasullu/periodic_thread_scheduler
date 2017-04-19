package periodicThreadScheduler.thread;

import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import periodicThreadScheduler.annotations.PeriodicThread;

/**
 * this class is for scheduleing threads periodically at specific time.
 *
 * @author Sarkhan Rasullu
 */
public class ScheduledThreadWrapper {

    private static final Logger LOG = Logger.getLogger(ScheduledThreadWrapper.class.getName());
    private boolean started = false;
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

        Calendar specificTime = Calendar.getInstance();
        specificTime.set(Calendar.DAY_OF_MONTH, specificTime.get(Calendar.DAY_OF_MONTH) + p.delayDay());
        specificTime.set(Calendar.HOUR_OF_DAY, p.atHour());
        specificTime.set(Calendar.MINUTE, p.atMinute());
        specificTime.set(Calendar.SECOND, p.atSecond());

        Calendar now = Calendar.getInstance();

        long wait = specificTime.getTimeInMillis() - now.getTimeInMillis();
        executorService.schedule(r, wait, TimeUnit.MILLISECONDS);

        this.started = true;
        debug(" scheduled for:" + specificTime.getTime());
    }

    public final void startSchedule() {
        debug(" run method is invoked");
        if (started) {
            try {
                r.run();
            } catch (Exception ex) {
                LOG.error(null, ex);
            }
        }
        schedule();
    }

    private void debug(String message) {
        System.out.println("cron:" + this.getClass().getName() + "=>" + message);
    }
}
