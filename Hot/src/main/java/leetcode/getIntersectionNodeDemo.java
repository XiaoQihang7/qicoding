package leetcode;

/**
 * LeetCode160、相交链表,找出并返回两个单链表相交的起始节点
 */
public class getIntersectionNodeDemo {

    /**
     * 解法有四：暴力枚举、map记忆搜索、双指针循环遍历、差值遍历
     * @param headA 链表一
     * @param headB 链表二
     * @return 返回结果
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针循环遍历
        if (headA == null || headB == null ) return null;
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2 ){
            head1 = head1.next==null ? headB : head1.next;
            head2 = head2.next==null ? headA : head2.next;
        }
        return head1;
    }
}
