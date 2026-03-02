package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class GenericStack<T> {

    private ArrayList<T> items;

    public GenericStack() {
        items = new ArrayList<>();
    }

    // Push = add to top (end of list)
    public void push(T item) {
        items.add(item);
    }

    // Pop = remove last element
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    // Peek = look at top
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }
}
