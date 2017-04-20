**_Periodic Thread Scheduler_**

I need schedule a task for specified date.For example task must be invoked after 2 days at 03:00:00.
But i need it periodically.Each 2 days at 03:00:00.
ExecutorService provides delay time and periodic task execution but it doesn't provide me specify date and time.
So i have to implement to calculate delay time.

I created a repository for this purpose.The client only needs to add annotation to class and implements Runnable interface.That's all.

<b>@PeriodicThread(delayDay = 1, atHour = 3, atMinute = 0, atSecond = 0)</b>

App will submit this runnable object to executor service periodically