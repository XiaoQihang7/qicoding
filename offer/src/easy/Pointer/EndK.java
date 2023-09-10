package easy.Pointer;

public class EndK {
    /**
     * offer22、链表中的倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
//        if (head.next==null) return head;
        ListNode firstNode=head,lastNode=head;
        for (int i=0;i<k;i++){
            firstNode=firstNode.next;
        }
        while (firstNode!=null){ //这样写简便，但是好像执行没有用if直接返回快
            firstNode=firstNode.next;
            lastNode=lastNode.next;
        }
        return lastNode;
    }
}

