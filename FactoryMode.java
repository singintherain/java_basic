interface Product{}

class Product1 implements Product{}
class Product2 implements Product{}

class ProductFactory{
  public Product getProduct(){
    return new Product1();
  }
}

class Person()
{
  private Product product;

  public buy(Product p)
  {
    this.product = p;
  }
}

public class FactoryMode{
  public static void main(String[] args)
  {
    Person p = new Person();

    //p.buy(ProductFactory.getProduct());
    p.buy(new Product1());
  }
}
