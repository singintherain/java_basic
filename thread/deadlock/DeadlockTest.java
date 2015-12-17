class A
{
  public synchronized void foo(B b)
  {
    System.out.println("当前线程名: " + Thread.currentThread().getName() + "进入A实例的foo方法");

    try
    {
      Thread.sleep(200);
    }
    catch(InterruptedException ex)
    {
      ex.printStackTrace();
    }

    System.out.println("当前线程名: " + Thread.currentThread().getName() + "企图调用B实例的last方法");
    b.last();
  }

  public synchronized void last()
  {
    System.out.println("进入A类的last方法内部");
  }

  public void print()
  {
    System.out.println("A类的非安全性方法");
  }
}
class B
{
  public synchronized void foo(A a)
  {
    System.out.println("当前线程名: " + Thread.currentThread().getName() + "进入B实例的foo方法");

    try
    {
      Thread.sleep(200);
    }
    catch(InterruptedException ex)
    {
      ex.printStackTrace();
    }

    System.out.println("当前线程名: " + Thread.currentThread().getName() + "企图调用A实例的last方法");
    //a.last();
    a.print();
  }

  public synchronized void last()
  {
    System.out.println("进入B类的last方法内部");
  }

  public void print()
  {
    System.out.println("B类的非安全性方法");
  }

}
public class DeadlockTest implements Runnable
{
  A a = new A();
  B b = new B();
  public void init()
  {
    Thread.currentThread().setName("主线程");
    a.foo(b);
    System.out.println("进入主线程之后");
  }
  public void run()
  {
    Thread.currentThread().setName("子线程");
    b.foo(a);
    System.out.println("进入子线程之后");
  }

  public static void main(String[] args)
  {
    DeadlockTest dl = new DeadlockTest();
    new Thread(dl).start();
    dl.init();
  }
}
