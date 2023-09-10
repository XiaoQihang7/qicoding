package easy.Pointer;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class IntersectionNode {

    /**
     * offer52、两个链表的公共节点
     *
     * 集合求解（hashSet）
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode temp = headA;
        while (temp!=null){
            listNodes.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if (listNodes.contains(temp)) {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }


    /**
     * 双指针
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode a = headA, b = headB ;
        while (a!=b){
            a=a!=null?a.next:headB;
            b=b!=null?b.next:headA;
        }
        return a;
    }
}
