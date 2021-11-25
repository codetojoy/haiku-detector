package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.*;

import java.util.ArrayList;
import java.util.List;

public class SimpleConsumer implements Consumer<Entry> {
    @Override
    public List<Result> consume(Queue<Entry> queue) {
        var results = new ArrayList<Result>();
        var numEntries = queue.size();
        var resultTracker = new ResultTracker();

        for (int i = 0; i < numEntries; i++) {
            var entry = queue.get(i);
            resultTracker.consume(entry);
            if (resultTracker.isMatch()) {
                var entries = resultTracker.getEntries();
                var result = new Result(entries);
                results.add(result);
            }
        }

        return results;
    }
}
