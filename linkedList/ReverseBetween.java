package leetcode.linkedList;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 17:01
 *  92、反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *  说明:1 ≤ m ≤ n ≤ 链表长度
 *  示例：
 *  输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 **/

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;

        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode res = reverseBetween.reverseBetween(l1, 2, 4);
        while (res!=null){
            System.out.println(res);
            res=res.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n){
        if (m==n){
            return head;
        }

        ListNode dum=new ListNode(0);
        dum.next=head;
        ListNode revereHead=head;
        ListNode revereTail=head;
        ListNode prevHead=dum;
        for (int i = 0; i < m - 1; i++) {
            revereHead=revereHead.next;//待反转节点的头
            prevHead=prevHead.next;//待反转节点的前一个节点
        }
        //反转部分
        ListNode prev=revereHead;//第一个节点
        ListNode cur=prev.next;//第二个节点
        for (int i = 0; i < n - m; i++) {
            revereTail=cur;
            cur=cur.next;
            revereTail.next=prev;
            prev=revereTail;
        }
        prevHead.next=revereTail;
        revereHead.next=cur;
        return dum.next;
    }
}
