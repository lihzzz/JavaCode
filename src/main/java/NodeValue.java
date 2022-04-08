//import java.util.Stack;
//
//public class NodeValue {
//
//    public Node addNodeValue(Node first,Node second){
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//
//        Node one = first;
//        Node two = second;
//
//        while(one != null){
//            stack1.push(one.val);
//            one = one.next;
//        }
//
//        while(two != null){
//            stack2.push(two.val);
//            two = two.next;
//        }
//
//        Node res = new Node(-1);
//        Node head = res;
//        int addValue = 0;
//        while(!stack1.isEmpty() || !stack2.isEmpty()){
//
//            int sum  = addValue;
//            if(!stack1.isEmpty()){
//                sum += stack1.pop();
//            }
//            if(!stack2.isEmpty()){
//                sum += stack2.pop();
//            }
//
//            // 进位
//            addValue = sum / 10;
//            // 创建新节点
//            Node node = new Node(sum % 10);
//            node.next = head.next;
//            head.next = node;
//            head = head.next;
//        }
//        return res.next;
//    }
//}
