public class Account
{
  private String accountNo;
  private double balance;
  // 记录改帐号是否已有存款
  private boolean flag = false;
  public Account(){}
  public Account(String accountNo, double balance)
  {
    this.accountNo = accountNo;
    this.balance   = balance;
  }
  public String getAccountNo()
  {
    return this.accountNo;
  }
  public void setAccoutNo(String accountNO)
  {
    this.accountNo = accountNo;
  }
  public double getBalance()
  {
    return this.balance;
  }
  private void setBalance(double balance)
  {
    this.balance = balance;
  }

  public int hashCode()
  {
    return getAccountNo().hashCode();
  }

  public boolean equals(Object obj)
  {
    if(this == obj)
      return true;
    if(obj != null && obj.getClass() == Account.class)
    {
      Account target = (Account)obj;
      return target.getAccountNo().equals(accountNo);
    }

    return false;
  }

  public synchronized void draw(double drawAmount, int num)
  {
    try{
      if(!flag)
      {
        System.out.println(Thread.currentThread().getName() + "第" + num + "次" + "取钱等待");
        wait();
      }else
      {
        if(getBalance() >= drawAmount)
        {
          System.out.println(Thread.currentThread().getName() + "第" + num + "次" + "取钱成功！取出钞票:" + drawAmount);

          try{
            Thread.sleep(1);
          }
          catch(InterruptedException ex)
          {
            ex.printStackTrace();
          }

          setBalance(getBalance() - drawAmount);
          System.out.println("\t余额为: " + getBalance());
          flag = false;
          notifyAll();
        }
        else
        {
          System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
        }
      }
    }
    catch (InterruptedException ex)
    {
      ex.printStackTrace();
    }
  }

  public synchronized void deposit(double depositAmount)
  {
    try{
      if(flag)
      {
        wait();
      }
      else
      {
        System.out.println(Thread.currentThread().getName() + " 存款:" + depositAmount);
        balance += depositAmount;
        System.out.println("账户余额为: " + balance);
        flag = true;
        notifyAll();
      }
    }
    catch(InterruptedException ex)
    {
      ex.printStackTrace();
    }
  }
}
