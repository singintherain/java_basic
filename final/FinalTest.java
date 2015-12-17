class Test
{
  private int i = 1;
}
public class FinalTest
{
  private int i = 0;

  public static void main(String[] args)
  {
    FinalTest finalTest = new FinalTest();
    Test test = new Test();

    System.out.println("i=" + (test.i));
    //System.out.println("i=" + (new Test().i));
  }
}
