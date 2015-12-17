import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer>
{
  public Integer call() throws Exception
  {
    int i = 0;
    for(; i < 100; i++)
    {
      System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
      //throw new Exception("测试线程中抛出异常的处理方法\n");
      //System.exit(0);
    }

    return i;
  }
  public static void  main(String[] args)
  {
    CallableThread ct = new CallableThread();
    FutureTask<Integer> task = new FutureTask<Integer>(ct);
    FutureTask<Integer> task2 = new FutureTask<Integer>(ct);
    for(int i = 0; i < 100; i++)
    {
      System.out.println(Thread.currentThread().getName() + " 的循环变量i的值为: " + i);
      if(i == 20)
      {
        //new Thread(task2, "有返回值的线程").start();
        new Thread(task, "有返回值的线程").start();
        new Thread(task, "有返回值的线程1").start();
      }

      //if(i == 21)
      //{
        ////new Thread(task2, "有返回值的线程").start();
        ////new Thread(task, "有返回值的线程").start();
        //System.out.println("---------------------");
        //new Thread(task, "有返回值的线程2").start();
      //}

    }

    try
    {
      System.out.println("子线程的返回值: " + task.get());
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
