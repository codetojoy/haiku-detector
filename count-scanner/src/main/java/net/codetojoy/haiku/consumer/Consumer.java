
package net.codetojoy.haiku.consumer;

import net.codetojoy.haiku.common.*;

import java.util.List;

// TODO: consider a stream and use Java's Consumer interface

public interface Consumer<T> {
    List<Result> consume(Queue<T> queue);
}