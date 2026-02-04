package com.nishakar.controller;

import com.nishakar.client.FileHandlingServiceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final FileHandlingServiceFeignClient fileHandlingServiceFeignClient;

    @GetMapping("/test")
    public String test() {
        log.info("TestController -> test");
        String s = fileHandlingServiceFeignClient.hello();
        log.info("TestController -> test -> {}", s);
        return s;
    }
}
