package com.learn.designpattern.behaviourmode.oberserve;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lh
 * Created on 2020/12/4
 * 当一个行为发生时，将信息传递给另外一个用户接收做出相应的处理
 */
@Slf4j
public class ObserveTest {
    public static void main(String[] args) {

        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult lotteryResult = lotteryService.doDraw("111123");
        log.info("{}",lotteryResult.toString());
    }
}
