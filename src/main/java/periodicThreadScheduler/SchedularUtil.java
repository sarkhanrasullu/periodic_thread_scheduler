/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicThreadScheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sarkhanrasullu
 */
public class SchedularUtil {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    public static Date schedule(ScheduledExecutorService executorService, int hour, int minute, int second, int delayDay, Runnable r) {
        if (executorService == null) {
            executorService = SchedularUtil.executorService;
        }
        Calendar specificTime = Calendar.getInstance();
        specificTime.set(Calendar.DAY_OF_MONTH, specificTime.get(Calendar.DAY_OF_MONTH) + delayDay);
        specificTime.set(Calendar.HOUR_OF_DAY, hour);
        specificTime.set(Calendar.MINUTE, minute);
        specificTime.set(Calendar.SECOND, second);

        Calendar now = Calendar.getInstance();

        long wait = specificTime.getTimeInMillis() - now.getTimeInMillis();
        executorService.schedule(r, wait, TimeUnit.MILLISECONDS);
        return specificTime.getTime();
    }

    public static Date schedule(int hour, int minute, int second, int delayDay, Runnable r) {
        return schedule(null, hour, minute, second, delayDay, r);
    }
}
