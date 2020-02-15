package leetcode.linkedList;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 15:31
 *  24、两两交换链表中的节点
 *  给定：1->2->3->4
 *  返回：2->1->4->3
 **/

public class SwapPais {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=null;

        SwapPais swapPais = new SwapPais();
        ListNode res = swapPais.swapNode(l1);
        while (res!=null){
            System.out.println(res);
            res=res.next;
        }

    }

    public ListNode swapNode(ListNode head){

        if (head==null || head.next==null){
            return head;
        }
        //关键明确反转之后的头节点
        ListNode prev=new ListNode(0);//虚拟节点
        prev.next=head;
        ListNode self=head.next;//反转之后的头节点
        while (prev.next !=null && prev.next.next!=null){
            ListNode a=prev.next;//第一个节点
            ListNode b=a.next;//第二个节点
            prev.next=b;
            a.next=b.next;
            b.next=a;
            prev=a;
        }
        return self;
    }
}









