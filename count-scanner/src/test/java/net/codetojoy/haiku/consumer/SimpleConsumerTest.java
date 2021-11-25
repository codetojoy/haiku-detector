package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SimpleConsumerTest {
    private Consumer<Entry> consumer = new SimpleConsumer();

    @Test
    public void testConsume_basic() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(5150,5));
        queue.push(new Entry(5151,7));
        queue.push(new Entry(5152,5));

        // test
        var results = consumer.consume(queue);

        assertEquals(1, results.size());
        assertEquals(3, results.get(0).entries().size());
    }

    @Test
    public void testConsume_empty() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();

        // test
        var results = consumer.consume(queue);

        assertTrue(results.isEmpty());
    }

    @Test
    public void testConsume_underflow() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(5150,5));
        queue.push(new Entry(5151,7));

        // test
        var results = consumer.consume(queue);

        assertTrue(results.isEmpty());
    }

    @Test
    public void testConsume_compound_1() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(5150,10));
        queue.push(new Entry(5151,7));
        queue.push(new Entry(5152,5));
        queue.push(new Entry(5153,13));
        queue.push(new Entry(5154,13));
        queue.push(new Entry(5155,5));
        queue.push(new Entry(5156,7));
        queue.push(new Entry(5157,3));
        queue.push(new Entry(5158,2));

        // test
        var results = consumer.consume(queue);

        assertEquals(2, results.size());
        assertEquals(2, results.get(0).entries().size());
        assertEquals(4, results.get(1).entries().size());
    }

    @Test
    public void testConsume_compound_2() {
        Queue<Entry> queue = new SimpleArrayQueue<Entry>();
        queue.push(new Entry(5150,17));
        queue.push(new Entry(5151,17));
        queue.push(new Entry(5152,17));
        queue.push(new Entry(5153,17));

        // test
        var results = consumer.consume(queue);

        assertEquals(4, results.size());
        assertEquals(1, results.get(0).entries().size());
        assertEquals(1, results.get(1).entries().size());
        assertEquals(1, results.get(2).entries().size());
        assertEquals(1, results.get(3).entries().size());
    }
}
