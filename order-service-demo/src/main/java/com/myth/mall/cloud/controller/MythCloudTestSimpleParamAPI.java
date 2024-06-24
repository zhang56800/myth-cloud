package com.myth.mall.cloud.controller;

import com.myth.mall.cloud.entity.MythGoodsInfo;
import com.myth.mall.cloud.service.MythGoodsDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MythCloudTestSimpleParamAPI {

    @Resource
    private MythGoodsDemoService simpleParamService;

    @GetMapping("/order/simpleParamTest")
    public String simpleParamTest2(@RequestParam("sellStatus") int sellStatus, @RequestParam("goodsId") int goodsId) {
        return simpleParamService.getGoodsDetail3(goodsId, sellStatus);
    }

    @GetMapping("/order/listByIdArray")
    public String listByIdArray() {

        Integer[] goodsIds = new Integer[4];
        goodsIds[0] = 1;
        goodsIds[1] = 3;
        goodsIds[2] = 5;
        goodsIds[3] = 7;

        List<String> result = simpleParamService.getGoodsArray(goodsIds);
        StringBuilder resultString = new StringBuilder();
        for (String s : result) {
            resultString.append(s).append(" ");
        }
        return resultString.toString();
    }

    @GetMapping("/order/listByIdList")
    public String listByIdList() {
        List<Integer> goodsIds = new ArrayList<>();
        goodsIds.add(2);
        goodsIds.add(4);
        goodsIds.add(6);
        goodsIds.add(8);

        List<String> result = simpleParamService.getGoodsList(goodsIds);
        StringBuilder resultString = new StringBuilder();
        for (String s : result) {
            resultString.append(s).append(" ");
        }
        return resultString.toString();
    }


    @GetMapping("/order/simpleObjectTest")
    public String simpleObjectTest1() {

        MythGoodsInfo mythGoodsInfo = new MythGoodsInfo();
        mythGoodsInfo.setGoodsId(2022);
        mythGoodsInfo.setGoodsName("Spring Cloud Alibaba 微服务架构");
        mythGoodsInfo.setStock(2035);

        MythGoodsInfo result = simpleParamService.updNewBeeGoodsInfo(mythGoodsInfo);

        return result.toString();
    }
}
