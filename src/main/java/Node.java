import java.util.LinkedList;
import java.util.List;

public class Node {
    int val;
    List<Node> node ;
    public Node(int val){
        this.val = val;
        node = new LinkedList<>();
    }

    public List<Node> getNodes(){
        return this.node;
    }

    public void putNodes(Node node){
        this.node.add(node);
    }
}
