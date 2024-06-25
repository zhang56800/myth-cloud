package com.myth.mall.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link  }.
 *
 * @author Jarvis
 * @version v1.0
 * @date 2024/6/25-20:58
 */

@RestController
public class MythCloudGoodsJDBCAPI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PutMapping("/goods/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") int goodsId) {
        // 减库存操作
        int result = jdbcTemplate.update("update tb_goods set goods_stock=goods_stock-1 where goods_id=" + goodsId);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
