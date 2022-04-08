import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackWhiteListConfig {

    public enum Cal{
        eq,
        gr,
        eg,
        le,
        leq,
        all
    }

    public  Map<Integer,Cal> white_list;
    public  Map<Integer,Cal> black_list;

    public BlackWhiteListConfig(){
        // load data
        white_list = new HashMap<>();
        black_list = new HashMap<>();
    }
    public int pass(int type,int version){

        // 计算是否在黑名单

        // 计算是否在白名单中

        return 0;
    }
}
