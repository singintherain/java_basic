public interface InterfaceTest{
  public void test();
}

public class Parent
{
  public void fly(){
    t();
  }
  public void t(){}
}

public class Child extends Parent{
  //public void t(){
    //puts 'aaa';
  //}
  puboic void fly(){
    puts 'bb';
    t();
  }
  public void z(){}
}

public class Main{
  Parent p = new Child();
  p.fly();
  (Child)p.z();
}

