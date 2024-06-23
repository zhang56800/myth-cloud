package com.myth.mall.cloud.web.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * {@link ConsumerController }.
 *
 * @author Jarvis
 * @version v1.0
 * @date 2024/6/23-14:36
 */
@RestController
public class ConsumerController {

    private final String SERVICE_URL = "http://localhost:8081";
    private final WebClient webClient = WebClient.builder().baseUrl(SERVICE_URL).build();


    /**
     * 使用WebClient处理http请求
     * @return
     */
    @GetMapping("/webClientTest")
    public String httpClientTest() throws IOException {

        Mono<String> stringMono = webClient.get().uri("/hello").retrieve().bodyToMono(String.class);

        stringMono.subscribe(System.out::println);

        return "请求成功";


    }




    
}
