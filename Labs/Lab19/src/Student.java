import java.io.Serializable;
public class Student implements Comparable<Student>, Serializable {
  private int id;
  private String name;

  public Student(String name, int id){
    this.name = name;
    this.id = id;
  }
  public int compareTo(Student s2){
    if(this.id > s2.id)
      return 1;
    else if (this.id == s2.id)
      return 0;
    else
      return -1;
  }
  public String toString(){
    return id + " " + name;
  }
}
