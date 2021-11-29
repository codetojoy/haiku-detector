package net.codetojoy.haiku.controller;

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.*

@CompileStatic
@Controller("/hello") 
class HelloController {
    @Get 
    @Produces(MediaType.TEXT_PLAIN) 
    String index(HttpRequest request) {
        def foo = request.parameters.getFirst("foo").get()
        println "TRACER ----------> foo: $foo"
        "Hello World" 
    }
}
