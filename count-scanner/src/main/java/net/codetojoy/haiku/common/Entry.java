
package net.codetojoy.haiku.common;

public record Entry(int id, int syllableCount) {
    @Override
    public String toString() {
        return "id: " + id + " syllableCount: " + syllableCount;
    }
}