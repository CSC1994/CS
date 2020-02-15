package leetcode.linkedList;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 19:17
 *  25. K 个一组翻转链表
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 **/

public class ReverseKGroup {
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

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode res = reverseKGroup.reverseKGroup(l1, 2);
        while (res!=null){
            System.out.println(res);
            res=res.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode root=new ListNode(-1);
        root.next=head;
        ListNode res=root;
        ListNode tmp=head;
        int i=0;
        while (tmp!=null){
            i++;
            tmp=tmp.next;
        }
        while (i>=k){
            for (int j = 0; j < k - 1; j++) {
                ListNode node=root.next;
                root.next=head.next;
                head.next=root.next.next;
                root.next.next=node;
            }
            root=head;
            head=head.next;
            i-=k;
        }
        return res.next;
    }
}
