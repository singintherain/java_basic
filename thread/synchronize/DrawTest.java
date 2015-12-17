public class DrawTest
{
  public static void main(String[] args)
  {
    //Account account = new Account("1234567", 1000);
    //new DrawThread("甲", account, 800).start();
    //new DrawThread("乙", account, 800).start();
    //
    Account account = new Account("123456", 0);
    new DrawThread("取钱者", account, 800).start();
    new DepositThread("存款者", account, 800).start();
    //new DepositThread("存款者乙", account, 800).start();
    //new DepositThread("存款者丙", account, 800).start();
  }
}

