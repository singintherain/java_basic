package lvsong.club;

import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExtendedObjectPoolFactory
{
  private Map<String, Object> objectPool = new HashMap<String, Object>();
  private Properties config = new Properties();

  public void init(String filename)
  {
    try {
      FileInputStream fis = new FileInputStream(filename);
      config.load(fis);
    } catch (IOException e) {
      System.out.println("读取" + filename + "异常");
    }
  }

  private Object createObject(String clazzName) throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    Class<?> clazz = Class.forName(clazzName);

    return clazz.newInstance();
  }

  public void initPool() throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    for(String name : config.stringPropertyNames())
    {
      if(!name.contains("%"))
      {
        objectPool.put(name, createObject(config.getProperty(name)));
      }
    }
  }

  public void initProperty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
  {
    for(String name : config.stringPropertyNames())
    {
      if(name.contains("%"))
      {
        String[] objAndProp = name.split("%");
        Object target = getObject(objAndProp[0]);
        String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() + objAndProp[1].substring(1);
        Class<?> targetClass = target.getClass();
        Method mtd = targetClass.getMethod(mtdName, String.class);
        // 对象target, 方法名mtd, 参数config.getProperty(name)
        mtd.invoke(target, config.getProperty(name));
      }
    }
  }

  public Object getObject(String name)
  {
    return objectPool.get(name);
  }

  public static void main(String[] args) throws Exception
  {
    ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
    epf.init("extObj.txt");
    epf.initPool();
    epf.initProperty();
    System.out.println(epf.getObject("xiaoming"));
    //System.out.println((StudentBean)(epf.getObject("xiaoming")).getAge());
    System.out.println(new StudentBean().getAge());
  }
}

