class MyException {
  public void throwException() throws Exception{
    throw new Exception("MyException");
  }
}

public class PrintStack {
  public static void main(String[] args)
  {
    MyException ex = new MyException();
    System.out.println("before myException");
    try{
      ex.throwException();
    }
    catch(Exception e){
      e.printStackTrace();
    }

    System.out.println("after myException");
  }
}
