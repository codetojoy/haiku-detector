package net.codetojoy.haiku.common;

import java.util.List;

public record Result(List<Entry> entries) {
    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append("result: [\n");
        for (var entry : entries) {
            builder.append(entry.toString() + "\n");
        }
        builder.append("]");
        return builder.toString();
    }
}
