//public class SortNode {
//
//    public Node sort(Node node){
//
//        Node slow = node;
//        Node fast = node;
//        while(fast != null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        Node right = sort(slow.next); // 右边
//
//        Node left = sort(node); // 左边
//
//        Node res = merge(right,left);
//        return res;
//
//    }
//
//    public Node merge(Node left,Node right){
//        Node first = new Node(-1);
//        Node one = first;
//        while(left != null && right != null){
//            if(left.val < right.val){
//                one.next = left;
//                left = left.next;
//            }else{
//                one.next = right;
//                right = right.next;
//            }
//        }
//
//        while(left != null){
//            one.next = left;
//            one = one.next;
//        }
//
//        while(right != null){
//            one.next = right;
//            one.next = one;
//        }
//        return first.next;
//    }
//}
