package designpattern.behaviourmode.oberserve;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lh
 * Created on 2020/12/4
 */
@Slf4j
public class MqEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult result) {
        log.info("记录用户:{},摇号结果:{}",result.getUid(),result.getMsg());
    }
}
