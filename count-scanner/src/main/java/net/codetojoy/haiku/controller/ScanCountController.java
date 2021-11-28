package net.codetojoy.haiku.controller;

import io.micronaut.http.*;
import io.micronaut.http.annotation.*;

import java.util.*;

import net.codetojoy.haiku.common.*;
import net.codetojoy.haiku.consumer.*;
import net.codetojoy.haiku.producer.*;

/*
data: [
    {id: "", syllableCount: },
]
*/

/*
class Data {
    public String id;
    public int syllableCount;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\": " + id +", \"syllableCount\": " + syllableCount + "}");
        return builder.toString();
    }
}

class DataList {
    public List<Data> data;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var d : data) {
            builder.append(d + "\n");
        }
        return builder.toString();
    }
};
*/

record Data(String id, int syllableCount) {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\": " + id +", \"syllableCount\": " + syllableCount + "}");
        return builder.toString();
    }
}

record DataList(List<Data> data) {
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
    @Post("/find")
    public String find(@Body DataList dataList) {
        /*
        var foo = request.getParameters().getFirst("foo").get();
        */
        System.out.println("TRACER v2 param dataList: " + dataList.toString());
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