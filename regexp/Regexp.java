class Regexp
{
  public static void main(String[] args){
    String pattern = ".*\\.xml";
    String name = "asdf.xml";

    if(name.matches(pattern))
      System.out.println("the pattern test is right");
    else
      System.out.println("the pattern test is wrong");
  }
}
