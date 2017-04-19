package periodicThreadScheduler.starter;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.reflections.Reflections;
import periodicThreadScheduler.annotations.PeriodicThread;
import periodicThreadScheduler.thread.ScheduledThreadWrapper;

/**
 *
 * @author Sarkhan Rasullu
 */
public class ThreadSchedulerStarter {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    public static void initializeAllThreads(String threadsLocation) throws Exception {
        System.out.println("initilazie");
        Reflections reflections = new Reflections(".*");

        Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(PeriodicThread.class);
        System.out.println("all classes:"+allClasses.isEmpty());
        Iterator<Class<?>> it = allClasses.iterator();
        while (it.hasNext()) {
            Class<?> c = it.next();
            Runnable r = (Runnable) c.newInstance();
            ScheduledThreadWrapper t = new ScheduledThreadWrapper(r, executorService);
            t.startSchedule();
        }
    }
}
