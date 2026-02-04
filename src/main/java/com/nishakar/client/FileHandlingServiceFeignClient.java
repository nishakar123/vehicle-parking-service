package com.nishakar.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "file-handling-service")
public interface FileHandlingServiceFeignClient {

    @GetMapping("/api/file-handling-service/hello")
    String hello();
}
