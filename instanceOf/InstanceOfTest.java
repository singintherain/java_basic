interface Duck{};

class FlyDuck implements Duck{};

class JumpDuck implements Duck{};

class Mom
{
  public void buy(Duck duck)
  {
    if(duck instanceof FlyDuck)
      System.out.println("Mom buy a duck that can fly!");
    else if(duck instanceof JumpDuck)
      System.out.println("Mom buy a duck that can jump!");
    else
      System.out.println("Mom buy a unknown duck!");
  }
}

public class InstanceOfTest
{
  public static void main(String[] args)
  {
    Mom myMom = new Mom();
    myMom.buy(new FlyDuck());
  }
}
