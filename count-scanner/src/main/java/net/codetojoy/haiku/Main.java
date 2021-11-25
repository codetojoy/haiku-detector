package net.codetojoy.haiku;

import net.codetojoy.haiku.consumer.*;
import net.codetojoy.haiku.common.*;
import net.codetojoy.haiku.producer.*;

public class Main {
    private Queue<Entry> queue = new SimpleArrayQueue<Entry>();

    void go() {
        var producer = new SimpleProducer();
        producer.produce(queue);
        var consumer = new SimpleConsumer();
        var results = consumer.consume(queue);
        for (Result result : results) {
            System.out.println("TRACER result: " + result);
        }
        System.out.println("TRACER num results: " + results.size());
    }

    public static void main(String... args) {
        new Main().go();
        System.out.println("Ready.");
    }
}
