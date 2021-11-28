package net.codetojoy.haiku.controller;

import io.micronaut.http.*;
import io.micronaut.http.annotation.*;

import java.util.List;

import net.codetojoy.haiku.common.*;
import net.codetojoy.haiku.consumer.*;
import net.codetojoy.haiku.producer.*;

record DataList(List<Entry> data) {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var d : data) {
            builder.append(d + "\n");
        }
        return builder.toString();
    }
}

@Controller("/scan-count")
public class ScanCountController {
    @Get("/ping")
    public String ping() {
        var format = "{ \"status\": \"ok\", \"time\": \"%s\" }";
        return String.format(format, new java.util.Date());
    }

    @Post("/find")
    public String find(@Body DataList dataList) {
        System.out.println("TRACER v3 param dataList: " + dataList.toString());
        var builder = new StringBuilder();
        var queue = new SimpleArrayQueue<Entry>();

        var producer = new HttpProducer(dataList.data());
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