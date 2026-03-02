package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class GenericQueue<T> {

    private ArrayList<T> items;

    public GenericQueue() {
        items = new ArrayList<>();
    }

    // Add to back
    public void enqueue(T item) {
        items.add(item);
    }

    // Remove from front
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.remove(0);
    }

    // Peek at front
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
