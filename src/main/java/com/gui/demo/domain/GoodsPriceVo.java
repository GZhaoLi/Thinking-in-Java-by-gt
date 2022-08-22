package com.gui.demo.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据skuId+activityId属性 做聚合
 */
@Data
public class GoodsPriceVo {
    private String skuId;
    private String activityId;
    private Integer price;
    private Integer num;

    public static void main(String[] args) {
        List<GoodsPriceVo> priceVoList = new ArrayList<>();
        GoodsPriceVo goodsPriceVo = new GoodsPriceVo();
        goodsPriceVo.setSkuId("123");
        goodsPriceVo.setActivityId("a0001");
        goodsPriceVo.setPrice(20);
        goodsPriceVo.setNum(2);
        GoodsPriceVo goodsPriceVo2 = new GoodsPriceVo();
        goodsPriceVo2.setSkuId("123");
        goodsPriceVo2.setActivityId("a0001");
        goodsPriceVo2.setPrice(10);
        goodsPriceVo2.setNum(1);
        priceVoList.add(goodsPriceVo);
        priceVoList.add(goodsPriceVo2);
        System.out.println("聚合前："+priceVoList);

        List<GoodsPriceVo> newGoodsPriceList = new ArrayList<>();
        priceVoList.parallelStream()
                .collect(Collectors.groupingBy(item -> item.getActivityId() + item.getSkuId(), Collectors.toList()))
                .forEach((id, transfer) -> transfer.stream().reduce((a, b) -> {
                            GoodsPriceVo priceVo = new GoodsPriceVo();
                            priceVo.setSkuId(a.skuId);
                            priceVo.setActivityId(a.getActivityId());
                            priceVo.setPrice(a.getPrice() + b.price);
                            priceVo.setNum(a.getNum() + b.getNum());
                            return priceVo;
                        }
                ).ifPresent(newGoodsPriceList::add));
        System.out.println("聚合后："+newGoodsPriceList);
    }
}
