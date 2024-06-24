package com.myth.mall.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "myth-cloud-shopcart-service", path = "/shop-cart")
public interface MythShopCartDemoService {

    @GetMapping(value = "/{cartId}")
    String getCartItemDetail(@PathVariable(value = "cartId") int cartId);
}
