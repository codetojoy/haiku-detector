
package net.codetojoy.haiku.producer;

import net.codetojoy.haiku.common.*;

public interface Producer<T> {
    void produce(Queue<T> queue);
}