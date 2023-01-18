import java.util.ArrayList;

public class Queue<T> {
  ArrayList<T> queue = new ArrayList<>();

  public Queue(ArrayList<T> queue)
  {
    this.queue = queue;
  }

  public void add(T item)
  {
    queue.add(queue.size(), item);
  }

  public T remove()
  {
    if(queue.isEmpty())
      return null;
    else
      return queue.remove(0);
  }
}
