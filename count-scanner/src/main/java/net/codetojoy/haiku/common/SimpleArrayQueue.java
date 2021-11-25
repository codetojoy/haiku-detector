package net.codetojoy.haiku.common;

import java.util.*;

public class SimpleArrayQueue<T> implements Queue<T> {
    private ArrayDeque<T> queue = new ArrayDeque<T>();

    @Override
    public T get(int index) {
        // this is terribly inefficent: switch API to iterator
        T[] array = (T[]) queue.toArray();
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void pop() {
        queue.pop();
    }

    @Override
    public void push(T item) {
        queue.add(item);
    }

    @Override
    public int size() {
        return queue.size();
    }
}