package net.codetojoy.haiku.common;

import static org.junit.Assert.*;
import org.junit.*;

public class SimpleArrayQueueTest {

    @Test
    public void testGet() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(1,1));
        queue.push(new Entry(2,2));
        queue.push(new Entry(3,3));

        // test
        Entry result = queue.get(1);

        assertEquals(2, result.id());
    }

    @Test
    public void testPop() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(1,1));
        queue.push(new Entry(2,2));
        queue.push(new Entry(3,3));

        // test
        queue.pop();

        assertEquals(2, queue.size());
    }
}
