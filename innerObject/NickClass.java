interface Product{
  public void test();
}

public class NickClass{
  public void nick(Product product)
  {
    product.test();
  }

  public static void main(String[] args){
    NickClass n = new NickClass();
    n.nick(new Product(){
      public void test(){
        System.out.println("aaa");
      }
    });
  }
}
