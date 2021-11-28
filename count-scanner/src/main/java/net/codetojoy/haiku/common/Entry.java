
package net.codetojoy.haiku.common;

public record Entry(String id, int syllableCount) {
    @Override
    public String toString() {
        return "id: " + id + " syllableCount: " + syllableCount;
    }
}