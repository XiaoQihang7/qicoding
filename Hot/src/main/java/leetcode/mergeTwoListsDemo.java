package leetcode;

/**
 * LeetCode21、合并两个有序链表 (升序)
 */
public class mergeTwoListsDemo {
    /**
     * 解法一：递归解法
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 返回合并的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}

