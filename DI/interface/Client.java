public class Client implements ServiceAware
{
  private Service service;

  public void injectService(Service service)
  {
    this.service = service;
  }

  public void doSomething()
  {
    service.execute();
  }

  public static void main(String[] args)
  {
    InterfaceInjector.configure();

    Client client = InterfaceInjector.getInstance(Client.class);

    client.doSomething();
  }
}

