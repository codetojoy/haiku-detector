
package net.codetojoy.haiku.common;

public record Entry(String id, int syllableCount) {
    // TODO: use a JSON serializer
    public String toJson() {
        return "{\"id\": " + id + ", \"syllableCount\": " + syllableCount + "}";
    }

    @Override
    public String toString() {
        return "id: " + id + " syllableCount: " + syllableCount;
    }
}