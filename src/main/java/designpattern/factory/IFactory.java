package designpattern.factory;

import designpattern.factory.simple.cal.Operation;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public interface IFactory {
    Operation createOperation();
}
