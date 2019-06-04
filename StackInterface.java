/**
 * Created by Vadim Yastrebov on 19/7/17.
 */
public interface StackInterface<E> {
    public void popAll();
    public boolean isEmpty();
    public void push(E element);
    public E pop();
    public E peek();
}
