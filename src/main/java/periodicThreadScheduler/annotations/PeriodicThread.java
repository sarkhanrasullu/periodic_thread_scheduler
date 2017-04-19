package periodicThreadScheduler.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PeriodicThread {

    public int delayDay();

    public int atHour();

    public int atMinute();

    public int atSecond();
    
}
