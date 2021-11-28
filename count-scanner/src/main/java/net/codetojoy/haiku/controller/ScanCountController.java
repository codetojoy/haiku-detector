package net.codetojoy.haiku.controller;

import io.micronaut.http.*;
import io.micronaut.http.annotation.*;

import java.net.http.*;
import java.util.List;

import net.codetojoy.haiku.common.*;
import net.codetojoy.haiku.consumer.*;
import net.codetojoy.haiku.producer.*;

// TODO: consider generics
record DataList(List<Entry> data) {}
record ResultList(List<Result> data) {}

@Controller("/scan-count")
public class ScanCountController {
    @Get("/ping")
    public String ping() {
        var format = "{ \"status\": \"ok\", \"time\": \"%s\" }";
        return String.format(format, new java.util.Date());
    }

    @Post("/find")
    public ResultList find(@Body DataList dataList) {
        var version = "------------------ v6";
        System.out.println("TRACER " + version + " param dataList: " + dataList.toString());
        var queue = new SimpleArrayQueue<Entry>();

        var producer = new HttpProducer(dataList.data());
        producer.produce(queue);
        var consumer = new SimpleConsumer();
        var results = consumer.consume(queue);
        var resultList = new ResultList(results);
        return resultList;
    }
}