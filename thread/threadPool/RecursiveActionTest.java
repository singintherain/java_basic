import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

class PrintTask extends RecursiveAction
{
  private static final int THRESSHOLD = 50;
  private int start;
  private int end;

  public PrintTask(int start, int end)
  {
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute()
  {
    if(end - start < THRESSHOLD)
    {
      for(int i = start; i < end; i++)
      {
        System.out.println(Thread.currentThread().getName()
            + "的i值:" + i);
      }
    }else{
      int middle = (start + end)/2;
      PrintTask left = new PrintTask(start, middle);
      PrintTask right = new PrintTask(middle + 1, end);

      left.fork();
      right.fork();
    }
  }
}

public class RecursiveActionTest
{
  public static void main(String[] args)
    throws Exception
  {
    ForkJoinPool pool = new ForkJoinPool();
    pool.submit(new PrintTask(0, 300));
    pool.awaitTermination(2, TimeUnit.SECONDS);

    pool.shutdown();
  }
}
