package core.basesyntax;

import core.basesyntax.exception.EmptyStackException;

public class Stack<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public Stack() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public E push(E item) {
        elementData[size++] = item;
        if (size == elementData.length) {
            grow();
        }
        return item;
    }

    public E pop() {
        E item;
        try {
            item = (E) elementData[--size];
        } catch (Exception e) {
            throw new EmptyStackException("Stack is empty");
        }
        elementData[size] = null;
        return item;
    }

    private void grow() {
        int newCapacity = elementData.length * 2;
        Object[] newElementData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }
}
