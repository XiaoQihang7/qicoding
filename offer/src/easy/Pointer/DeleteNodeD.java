package easy.Pointer;

public class DeleteNodeD {
    /**
     * offer18、删除链表的节点，并返回头节点（删除后的节点）
     *
     * 指针相当于手术刀，操作本体不是本体。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, nex = head.next;
        while(nex != null && nex.val != val) {
            pre = nex;
            nex = nex.next;
        }
        if(nex != null) pre.next = nex.next;//找到删除的节点，使用双指针进行移除
        return head;
    }
}
