package lvsong.club;

class Tester
{
  static
  {
    System.out.println("类的静态初始化");
  }
}
public class ClassInitialize
{
  static
  {
    b = 6;
    //System.out.println("----------------------");
    //System.out.println("类的静态初始化");
  }

  static int a = 5;
  static int b = 9;
  static int c;

  public static void main(String[] args) throws ClassNotFoundException
  {
    ClassLoader cl = ClassLoader.getSystemClassLoader();
    cl.loadClass("Tester");
    System.out.println("系统加载Tester类");
    //System.out.println(ClassInitialize.b);
  }
}
