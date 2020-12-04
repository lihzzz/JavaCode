package designpattern.behaviourmode.oberserve;

/**
 * @author lh
 * Created on 2020/12/4
 */
public class LotteryServiceImpl extends LotteryService {
    MinibusTargetService minibusTargetService = new MinibusTargetService();
    @Override
    protected LotteryResult doDraw(String uid) {
        String lottery = minibusTargetService.lottery(uid);
        return new LotteryResult(uid,lottery);
    }
}
