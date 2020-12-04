package designpattern.behaviourmode.oberserve;

import lombok.Data;

/**
 * @author lh
 * Created on 2020/12/4
 */
@Data
public class LotteryResult {
    private String uid;

    public LotteryResult(String uid, String msg) {
        this.uid = uid;
        this.msg = msg;
    }

    private String msg;
}
