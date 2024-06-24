package com.myth.mall.cloud.controller;

import com.myth.mall.cloud.service.MythGoodsDemoService;
import com.myth.mall.cloud.service.MythShopCartDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MythCloudOrderAPI {

    //    @Resource
//    private RestTemplate restTemplate;
//
//    // 商品服务调用地址
//    private final String CLOUD_GOODS_SERVICE_URL = "http://myth-cloud-goods-service";
//
//    // 购物车服务调用地址
//    private final String CLOUD_SHOPCART_SERVICE_URL = "http://myth-cloud-shopcart-service";
//
//    @GetMapping("/order/saveOrder")
//    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {
//        // 简单的模拟下单流程，包括服务间的调用流程。后续openfeign相关的改造和优化将基于当前项目进行改造。
//
//        // 调用商品服务
//        String goodsResult = restTemplate.getForObject(CLOUD_GOODS_SERVICE_URL + "/goods/" + goodsId, String.class);
//
//        // 调用购物车服务
//        String cartResult = restTemplate.getForObject(CLOUD_SHOPCART_SERVICE_URL + "/shop-cart/" + cartId, String.class);
//
//        // 执行下单逻辑
//
//        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
//    }
    @Resource
    private MythGoodsDemoService mythGoodsDemoService;

    @Resource
    private MythShopCartDemoService mythShopCartDemoService;

    @GetMapping("/order/saveOrder")
    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {
        // 简单的模拟下单流程，包括服务间的调用流程。

        // 调用商品服务
        String goodsResult = mythGoodsDemoService.getGoodsDetail(goodsId);

        // 调用购物车服务
        String cartResult = mythShopCartDemoService.getCartItemDetail(cartId);

        // 执行下单逻辑

        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
    }




}
