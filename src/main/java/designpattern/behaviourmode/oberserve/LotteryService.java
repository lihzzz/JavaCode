package designpattern.behaviourmode.oberserve;

/**
 * @author lh
 * Created on 2020/12/4
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService(){
        eventManager = new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ,new MqEventListener());
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());

    }
    public LotteryResult draw(String uid){
        LotteryResult lotteryResult = doDraw(uid);
        eventManager.notify(EventManager.EventType.MQ,lotteryResult);
        eventManager.notify(EventManager.EventType.Message,lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uid);

}
