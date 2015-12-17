public class AssertionTest
{
  public void test()
  {
    AssertError error = new AssertError();

    error.test();
  }

  public static void main(String[] args)
  {
    AssertionTest test = new AssertionTest();
    test.test();
  }
}
