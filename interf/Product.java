public class Product implements Interf1, Interf2, Interf3{
  private int price;
  private int amount;
  public Product(int price, int amount){
    this.price = price;
    this.amount = amount;
  }
  public int getPrice(){
    return price;
  }
  public int getAmount(){
    return amount;
  }
  public void action3()
  {
    System.out.println("action3");
  }
  public boolean isSuccess()
  {
    System.out.println("parent interf");
    return true;
  }

  public static void main(String[] args){
    Interf1 p = new Product(3,3);
    System.out.println(p.getPrice());
    Interf3 p3 = new Product(4,4);
    p3.isSuccess();
  }
}
