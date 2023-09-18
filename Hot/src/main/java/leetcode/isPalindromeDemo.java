package leetcode;

/**
 * LeetCode234、回文链表
 */
public class isPalindromeDemo {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))));
        System.out.println(new isPalindromeDemo().isPalindrome(listNode));
    }
    //双指针，分奇偶数
//    int count = 1 ;
    public boolean isPalindrome(ListNode head) {
        //先遍历获取链表的节点个数
        int count = 1 ;
        if (head == null){
            return false;
        }
        if (head.next == null){
            return true;
        }
        ListNode index = head;
        ListNode index2 = head;
        ListNode ind = null;
        ListNode ind2 = null;
        while (index2.next != null){
            index2 = index2.next;
            count++;
        }
        if (count % 2 == 0) {
            //偶数个节点，移动指针count/2-1
            for (int i = 0 ; i<count/2 -1 ; i++){
                index = index.next;
            }
            //反转链表(滚动)
            ind = index.next;
            index.next = null ;
//            ListNode ind3 = ind.next;
            while(ind != null) {
                ListNode ind3 = ind.next;
                ind.next = ind2;
                ind2 = ind;
                ind = ind3;
            }

        }else {
            for (int i = 0 ; i<count/2 ; i++){
                index = index.next;
            }
            //反转链表(滚动)
            ind = index.next;
            index.next = null;
//            ListNode ind1 = ind.next;
//            ind.next.next = null;
//            ind.next.val = index.val; //解除死链(链表中的值只是这个对象中的一部分，不影响指向)

//            ind2 = ind ; //index死链了？？？
            while(ind != null) {
                ListNode ind3 = ind.next;
                ind.next = ind2; //造成死链
                ind2 = ind;
                ind = ind3;
            }
        }

//            ListNode in = index.next;
//            ListNode on = head;
//            while(on != index){
//                if (on.val != in.val){
//                    return false;
//                }
//                in = in.next;
//                on = on.next;
//            }
        while(head!=null && ind2!=null){
            if (head.val == ind2.val){
                head = head.next;
                ind2 = ind2.next;
            }else {
                return false;
            }
        }
        return head.next == null || ind2 == null;
    }

    /**
     * 【快慢指针解法】
     * @param head 头节点
     * @return 返回结果
     */
    public boolean isPalindrome1(ListNode head) {
        return false;
    }

}
