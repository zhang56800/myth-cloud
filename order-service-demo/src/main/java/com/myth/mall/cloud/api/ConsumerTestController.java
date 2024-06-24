package com.myth.mall.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerTestController {

    // 测试方法，暂未通过Nacos调用下级服务
    @GetMapping("/nacosRegTest")
    public String nacosRegTest() {
        return "nacosRegTest";
    }


    @Resource
    RestTemplate restTemplate;
    private final String SERVICE_URL = "http://myth-cloud-goods-service";

    // 通过Nacos调用下级服务
    @GetMapping("/consumerTest")
    public String consumerTest() {
        return restTemplate.getForObject(SERVICE_URL + "/goodsServiceTest", String.class);
    }
}
