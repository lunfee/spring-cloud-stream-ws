package com.mycompany.bitcoinapi.observer;
//一个函数式接口
public interface PriceObserver {

    void update(PriceMessage priceMessage);
}
