package com.myth.mall.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * {@link  }.
 *
 * @author Jarvis
 * @version v1.0
 * @date 2024/6/25-21:08
 */
public class OrderService {
    @Resource
    private MythShopCartDemoService mythShopCartDemoService;
    @Resource
    private MythGoodsDemoService goodsDemoService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Boolean saveOrder(int cartId) {
        // 简单的模拟下单流程，包括服务间的调用流程。

        // 调用购物车服务-获取即将操作的goods_id
        int goodsId = mythShopCartDemoService.getGoodsId(cartId);

        // 调用商品服务-减库存
        Boolean goodsResult = goodsDemoService.deStock(goodsId);

        // 调用购物车服务-删除当前购物车数据
        Boolean cartResult = mythShopCartDemoService.deleteItem(cartId);

        // 执行下单逻辑
        if (goodsResult && cartResult) {
            // 向订单表中新增一条记录
            int orderResult = jdbcTemplate.update("insert into tb_order(`cart_id`) value (\"" + cartId + "\")");
            if (orderResult > 0) {
                return true;
            }
            return false;
        }
        return false;
    }
}
