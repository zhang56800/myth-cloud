package com.myth.mall.cloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MythCloudGoodsAPI {

    @Value("${server.port}")
    private String applicationServerPort;// 读取当前应用的启动端口

    @GetMapping("/goodsServiceTest")
    public String goodsServiceTest() {
        // 返回信息给调用端
        return "this is goodsService from port:" + applicationServerPort;
    }
}
