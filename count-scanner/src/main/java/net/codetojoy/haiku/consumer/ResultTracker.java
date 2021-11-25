package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.Constants;
import net.codetojoy.haiku.common.Entry;

import java.util.*;
import java.util.stream.Collectors;

public class ResultTracker {
    private ArrayDeque<Entry> queue = new ArrayDeque<Entry>();

    public boolean isMatch() {
        return getSyllableCount() == Constants.TARGET_NUM_SYLLABLES;
    }

    public int getSyllableCount() {
        var result = queue.stream().collect(Collectors.summingInt(Entry::syllableCount));
        return result;
    }

    public List<Entry> getEntries() {
        return new ArrayList<Entry>(queue);
    }

    protected void popWhile(int initialCount) {
        var count = initialCount;
        while (count > Constants.TARGET_NUM_SYLLABLES) {
            var entry = queue.removeFirst();
            count = count - entry.syllableCount();
        }
    }

    public void consume(Entry entry) {
        var count = getSyllableCount() + entry.syllableCount();
        queue.add(entry);

        if (count > Constants.TARGET_NUM_SYLLABLES) {
            popWhile(count);
        }
    }
}
