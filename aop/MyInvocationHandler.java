import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public class MyInvocationHandler implements InvocationHandler
{
  private Object target;
  public void setTarget(Object target)
  {
    this.target = target;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Exception
  {
    DogUtil du = new DogUtil();
    du.method1();
    Object result = method.invoke(target, args);
    du.method2();

    return result;
  }
}
