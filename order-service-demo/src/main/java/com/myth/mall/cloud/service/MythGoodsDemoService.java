package com.myth.mall.cloud.service;

import com.myth.mall.cloud.entity.MythGoodsInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "myth-cloud-goods-service", path = "/goods")
public interface MythGoodsDemoService {

    @GetMapping(value = "/{goodsId}")
    String getGoodsDetail(@PathVariable(value = "goodsId") int goodsId);


    @GetMapping(value = "/detail")
    String getGoodsDetail3(@RequestParam(value = "goodsId") int goodsId, @RequestParam(value = "sellStatus") int sellStatus);

    @GetMapping(value = "/listByIdArray")
    List<String> getGoodsArray(@RequestParam(value = "goodsIds") Integer[] goodsIds);

    @GetMapping(value = "/listByIdList")
    List<String> getGoodsList(@RequestParam(value = "goodsIds") List<Integer> goodsIds);

    @PostMapping(value = "/updMythGoodsInfo")
    MythGoodsInfo updNewBeeGoodsInfo(@RequestBody MythGoodsInfo mythGoodsInfo);
}
