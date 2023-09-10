package leetcode;

/**
 * Leetcode、83 删除排序链表中的重复元素
 */
public class deleteDuplicatesDemo {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
