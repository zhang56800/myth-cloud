package com.myth.mall.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "myth-cloud-shopcart-service", path = "/shop-cart")
public interface MythShopCartDemoService {

    @GetMapping(value = "/{cartId}")
    String getCartItemDetail(@PathVariable(value = "cartId") int cartId);

    @GetMapping(value = "/getGoodsId")
    int getGoodsId(@RequestParam(value = "cartId") int cartId);

    @DeleteMapping(value = "/{cartId}")
    Boolean deleteItem(@PathVariable(value = "cartId") int cartId);
}
