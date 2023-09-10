package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedDemo {

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next=listNode1;
        listNode1.next=listNode2;

        System.out.println(reverseList(null));
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }

    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> arrayList1 = new ArrayList<>();
    /**
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * 用数组返回
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
//        int c=0;
//        ArrayList<Object> arrayList = new ArrayList<>();
//        while (head!=null){
//            c++;
//            arrayList.add(head.val);
//            head=head.next;
//        }
//        int[] arrayInt =new int[c+1];
//        Collections.reverse(arrayList);
//        arrayInt = arrayList.stream().mapToInt(x -> (int) x).toArray();
//        System.out.println(Arrays.toString(arrayInt));
//        return arrayList.toString();

        recur(head);
//        Integer[] integers = (Integer[]) arrayList.toArray();
        return (int[]) arrayList.stream().mapToInt(x -> (int) x).toArray();//流没有手写的for循环快呀。。
    }

    static void recur(ListNode head){
        if(head==null){
            return;
        }
        recur(head.next);
        arrayList.add(head.val);
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //迭代(双指针)
        ListNode result =null,re=null;
        ListNode pre =head;
        while(pre!=null){
            //来开一把数字华容道
            result=pre;
            pre=pre.next;
            result.next=re;//指向前一个节点
            re=result;


//        ListNode tmp = pre.next; // 暂存后继节点 pre.next
//        pre.next = re;          // 修改 next 引用指向
//        re = pre;               // re 暂存 pre
//        pre = tmp;               // pre 访问下一节点
        }



        //双递归求解
        recurNode(head);
        ListNode listNode=null;
        if (arrayList1.size()>0) {
            listNode = new ListNode(arrayList1.get(0));
        }
//        for (int i=1;i<size-1;i++){
//            listNode.next=new ListNode(arrayList1.get(i));
//            addNode(listNode,i);
//        }
        addNode(listNode,1);
        return listNode;
    }

    private static void addNode(ListNode listNode, int i) {
        if (i>=arrayList1.size()){
            return;
        }
        listNode.next=new ListNode(arrayList1.get(i));
        addNode(listNode.next,++i);
    }

     static void recurNode(ListNode head){
        if(head==null){
            return;
        }
        recurNode(head.next);
        arrayList1.add(head.val);
    }
}
class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    ListNode(int x) { val = x; }

}
