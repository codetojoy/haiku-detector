package net.codetojoy.haiku.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import net.codetojoy.haiku.common.*;
import net.codetojoy.haiku.consumer.*;
import net.codetojoy.haiku.producer.*;

@Controller("/scan-count")
public class ScanCountController {
    @Get
    public String index() {
        var builder = new StringBuilder();
        var queue = new SimpleArrayQueue<Entry>();

        var producer = new SimpleProducer();
        producer.produce(queue);
        var consumer = new SimpleConsumer();
        var results = consumer.consume(queue);

        // TODO: use a JSON serializer
        var numResults = results.size();
        var i = 1;
        builder.append("{\"data\": [");
        for (var result : results) {
            builder.append(result.toJson());

            if (i < numResults) {
                builder.append(",");
            }
            i++;
        }
        builder.append("]}");

        return builder.toString();
    }
}