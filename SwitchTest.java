public class SwitchTest{
  private final int VALUE = 1;
  public static final int value()
  {
    return 1;
  }

  public void test()
  {
    int num = 1;
    //static final int value = value();
    //int value = 1;
    switch(num){
      case value():
        System.out.println("test");
      default:
        System.out.println("default");
    }
  }

  public static void main(String[] args)
  {
    SwitchTest test = new SwitchTest();
    test.test();
  }
}
