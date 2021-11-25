package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.Constants;
import net.codetojoy.haiku.common.Entry;

import java.util.*;

public class ResultTracker {
    private int count = 0;
    private ArrayDeque<Entry> queue = new ArrayDeque<Entry>();

    public boolean isMatch() {
        return count == Constants.TARGET_NUM_SYLLABLES;
    }

    public int getSyllableCount() {
        return count;
    }

    public List<Entry> getEntries() {
        return new ArrayList<Entry>(queue);
    }

    protected void popWhile() {
        if (queue.isEmpty()) {
            count = 0;
        } else {
            while (count > Constants.TARGET_NUM_SYLLABLES) {
                var entry = queue.removeFirst();
                count = count - entry.syllableCount();
            }
        }
    }

    public void consume(Entry entry) {
        var entryCount = entry.syllableCount();
        count += entryCount;
        queue.add(entry);

        if (count > Constants.TARGET_NUM_SYLLABLES) {
            popWhile();
        }
    }
}
