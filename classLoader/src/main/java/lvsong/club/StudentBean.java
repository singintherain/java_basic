package lvsong.club;

public class StudentBean
{
  private String name;
  private String age;

  public String getName()
  {
    return this.name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getAge()
  {
    return this.age;
  }
  public void setAge(String age)
  {
    this.age = age;
  }

  public StudentBean(){}

  public StudentBean(String name, String age)
  {
    setName(name);
    setAge(age);
  }
}
