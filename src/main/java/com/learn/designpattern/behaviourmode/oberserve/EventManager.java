package com.learn.designpattern.behaviourmode.oberserve;

import java.util.*;

/**
 * @author lh
 * Created on 2020/12/4
 */
public class EventManager {

    public enum EventType {
        MQ, Message;
    }

    // eventListener 相当于事件监听的用户，能够对于不同的通知做出不同的处理
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<EventListener>());
        }
    }


    public void subscribe(Enum<EventType> eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(eventListener);
    }

    public void unsubscribe(Enum<EventType> eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(eventListener);
    }

    public void notify(Enum<EventType> eventType, LotteryResult lotteryResult) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener eventListener : users) {
            eventListener.doEvent(lotteryResult);
        }
    }
}
