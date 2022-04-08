import java.util.LinkedList;
import java.util.Queue;

public class Ali {

    public int res = 0;
    public int getKStepMaxSum(Node node,int step){
        return dfs(node,step,0);

    }

    public int dfs(Node node,int step,int value){
        if(step <= 0){
            return value;
        }

        int maxValue = 0;
        for (int i = 0; i < node.getNodes().size(); i++) {
            Node tmp = node.getNodes().get(i);
            int tmpValue = dfs(tmp,step-1, value + node.val);
            maxValue = Math.max(maxValue,tmpValue);
        }
        return maxValue;
    }

    public static String deleteStr(String str){
        if(str.isEmpty()){
            return str;
        }
        int bIndex = str.indexOf('\b');
        if(bIndex == -1){
            return str;
        }
        return deleteStr(bIndex <= 1 ? str.substring(bIndex + 1) :str.substring(0, bIndex - 1) + str.substring(bIndex + 1));
    }

    public static void main(String[] args) {
        String str = "xabc\b\bd\b\bghi";
        System.out.println(deleteStr(str));
    }
}
