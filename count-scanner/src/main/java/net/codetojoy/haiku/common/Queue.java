
package net.codetojoy.haiku.common;

public interface Queue<T> {
    void push(T item);
    void pop();

    T get(int index);

    boolean isEmpty();
    int size();
}