package easy.Pointer;

public class MergeTwoLiked {
    public static void main(String[] args) {

        MergeTwoLiked mergeTwoLiked = new MergeTwoLiked();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next=listNode2;
        listNode2.next=listNode3;
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        System.out.println(mergeTwoLiked.mergeTwoLists3(listNode, listNode4));
    }

    /**
     *Offer25、合并两个排序的链表
     *
     * 出现的疑惑，怎么向一个链表中依次向后添加另一个链表中的元素
     * 使用指针操作（双指针解法）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while(l1!=null&&l2!=null){
            if (l1.val>=l2.val){
                cur.next=l2;
                l2=l2.next;
            }else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return dummy.next;
    }

    /**
     * 递归+回溯
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode result = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l1.val > l2.val){
            result=l2;
            result.next=mergeTwoLists2(l1,result.next);
        }else {
            result=l1;
            result.next=mergeTwoLists2(result.next,l2);
        }
        return result;
    }

    //递归简化
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        ListNode result = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
//        result=l1.val>l2.val?l2:l1; //这样写会出现循环引用，报错（原因：当l1节点等于l2节点时，传入的两个链表相同）
        result=l2.val>l1.val?l1:l2;
        result.next=mergeTwoLists3(l1.val>=l2.val?l1:l2,result.next);
        return result;
    }
}
