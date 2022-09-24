package com.learn.designpattern.behaviourmode.oberserve;


import lombok.extern.slf4j.Slf4j;


/**
 * @author lh
 * Created on 2020/12/4
 */
@Slf4j
public class MessageEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult result) {

        log.info("给用户:{} 发送短信通知：{}",result.getUid(),result.getMsg());
    }
}
