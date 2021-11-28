package net.codetojoy.haiku.producer;

import net.codetojoy.haiku.common.*;

public class SimpleProducer implements Producer<Entry> {
    private static final int NUM_ENTRIES = 100;
    private static final int MAX_SYLLABLE_COUNT = 10;

    @Override
    public void produce(Queue<Entry> queue) {
        var random = new MyRandom();
        for (int i = 1; i <= NUM_ENTRIES; i++) {
            int id = i;
            int syllableCount = random.get(MAX_SYLLABLE_COUNT);
            var entry = new Entry("" + id, syllableCount);
            queue.push(entry);
        }
    }
}