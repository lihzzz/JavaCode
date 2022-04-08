import org.junit.Test;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class CopyNode {

    Map<Node,Node> cacheNode = new HashMap<>();
    public Node CopyNode(Node node){
        if(!cacheNode.containsKey(node)){
            Node newNode = new Node(node.val);
            for(Node node1 : node.getNodes()){
                newNode.putNodes(CopyNode(node1));
            }
            cacheNode.put(node,newNode);
        }
        return cacheNode.get(node);
    }

    @Test
    public void strIntern(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
        String str3 = new StringBuilder("ja").append("va1").toString();
        System.out.println(str3 == str3.intern());
        String str4 = "java";
        System.out.println(str2.intern() == str4);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
    }
}
