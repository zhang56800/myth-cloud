package com.myth.mall.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MythCloudShopCartJdbcAPI {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/shop-cart/getGoodsId")
    public int getGoodsId(@RequestParam("cartId") int cartId) {
        // 根据主键id查询购物表
        Map<String, Object> cartItemObject = jdbcTemplate.queryForMap("select * from tb_cart_item where cart_id=" + cartId + " limit 1");
        if (cartItemObject.containsKey("goods_id")) {
            // 返回商品id
            return (int) cartItemObject.get("goods_id");
        }
        return 0;
    }

    @DeleteMapping("/shop-cart/{cartId}")
    public Boolean deleteItem(@PathVariable("cartId") int cartId) {
        // 删除购物车数据
        int result = jdbcTemplate.update("delete from tb_cart_item where cart_id=" + cartId);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
