import java.util.EmptyStackException;

/**
 * Created by Vadim Yastrebov on 19/7/17.
 */
public class StackReferenceBased<E> implements StackInterface<E>{
    private Node<E> top;
    /*
     * I don't really see the point in writing comments here. it's all simple and the code will be more descriptive than the comments.
     */

    /**
     * Clears the stack
     */
    @Override
    public void popAll() {
        top = null;

    }

    /**
     * Determines if the stack is empty.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Pushes an item onto the stack
     * @param element is an item to push
     * @throws StackOverflowError   if the stack is full
     */
    @Override
    public void push(E element) throws StackOverflowError{
        top = (isEmpty() ? new Node<>(element) : new Node<>(element, top)); //ternary for pushing onto stack depending if the stack is empty.

    }

    /**
     * Pops the item from the stack
     * @return the popped item
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E item = top.getItem();
            top = top.getNext();
            return item;
        }
    }

    /**
     * Peek at the item on top of the stack without discarding it
     * @return the peeked item
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.getItem();
        }
    }
}
