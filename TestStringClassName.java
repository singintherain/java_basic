public class TestStringClassName {
    public static void main(){
      String class_name = "BaseClass";

      Class<?> klass = Class.for_name(class_name);

      Object obj = new klass("test");

      System.out.println("obj: " + obj.to_string());
    }
}
