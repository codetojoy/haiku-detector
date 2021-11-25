
package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.*;

import java.util.List;

public interface Consumer<T> {
    List<Result> consume(Queue<T> queue);
}