import java.util.HashMap;
import java.util.Map;

public class InterfaceInjector{
  private static InterfaceInjector injector;
  private Map<Class, Object> services = new HashMap<Class, Object>();

  public static void configure()
  {
    load(new InterfaceInjector());
  }

  public static <T> T getInstance(Class<T> clazz)
  {
    return injector.loadService(clazz);
  }

  private static void load(InterfaceInjector container)
  {
    InterfaceInjector.injector = container;
  }

  private <T> T loadService(Class<T> clazz)
  {
    Object service = injector.services.get(clazz);

    if(service != null)
      return (T) services;

    try{
      service = clazz.newInstance();
      if(service instanceof ServiceAware)
      {
        ((ServiceAware) service).injectService(new ServiceImpl());
      }

      injector.services.put(clazz, service);
    } catch (InstantiationException e){
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return (T) service;
  }
}

