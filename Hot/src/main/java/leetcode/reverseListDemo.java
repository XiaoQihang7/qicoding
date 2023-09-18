package leetcode;

/**
 * LCR24、反转链表
 */
public class reverseListDemo {
    //双指针解法（混动）
    public ListNode reverseList(ListNode head) {
        ListNode ind1 = head ;
        ListNode ind2 = null ;
        while (ind1 != null){
            ListNode next = ind1.next;
            ind1.next = ind2 ;
            ind2 = ind1;
            ind1 = next;
        }
        return ind1;
    }

}
