package leetcode;

/**
 * Leetcode、83 删除排序链表中的重复元素（这时一个升序链表）
 */
public class deleteDuplicatesDemo {
    /**
     * 解法一：直接指向
     * @param head 头节点
     * @return 不含重复节点的链表
     */
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

    /**
     * 解法二：递归
     * @param head 头节点
     * @return 不含重复节点的链表
     */
    public ListNode deleteDuplicates1(ListNode head) {
        //递归处理，本质就是将链表压栈后倒序处理了
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates1(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
