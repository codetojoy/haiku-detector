package net.codetojoy.haiku.common;

import java.util.List;

public record Result(List<Entry> entries) {
    // TODO: use a JSON serializer
    public String toJson() {
        var builder = new StringBuilder();
        builder.append("{\"result\": [ ");
        var numEntries = entries.size();
        var i = 1;
        for (var entry : entries) {
            builder.append(entry.toJson());

            if (i < numEntries) {
                builder.append(",");
            }
            i++;
        }
        builder.append(" ]}");
        return builder.toString();
    }

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
