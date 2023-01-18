public class Students implements Comparable<Students>{
  private String name;
  private int id;
  public Students(String name, int id){
    this.name = name;
    this.id = id;
  }
  public int compareTo(Students second){
    if(this.id > second.id)
      return 1;
    else if (this.id == second.id)
      return 0;
    else
      return -1;
  }
  public String toString(){
    return String.format("          %-10s   %7d", name, id);
  }
}
