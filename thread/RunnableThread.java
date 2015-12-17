public class RunnableThread implements Runnable
{
  private int i;

  public void run()
  {
    for(; i < 100; i++)
    {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }

  public static void  main(String[] args)
  {
    for(int i = 0; i < 100; i++)
    {
      System.out.println(Thread.currentThread().getName());

      if(i == 20)
      {
        RunnableThread thread = new RunnableThread();
        new Thread(thread, "first").start();
        new Thread(thread, "second").start();
      }
    }
  }
}
