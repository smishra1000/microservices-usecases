package com.sameer.fullstack;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class FallBackController {

    @RequestMapping("/studentFallBack")
public Mono<String> studentServiceFallBack(){
    return Mono.just("Student service is down now.please try again later");
}

    @RequestMapping("/courseFallBack")
    public Mono<String> courseServiceFallBack(){
        return Mono.just("Course service is down now.please try again later");
    }


}
