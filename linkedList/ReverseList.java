package leetcode.linkedList;

import java.util.Objects;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-09 20:57
 *
 * 206. 链表反转
 *  输入：1->2->3->4->5->null
 *  输出：5->4->3->2->1->null
 **/

public class ReverseList {

    public static void main(String[] args) {
        ListNode head=new ListNode(0);
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);

        head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;

        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.reverseList(l1);
        while (listNode!=null){
            System.out.println(listNode);
            listNode=listNode.next;
        }

    }

    public ListNode reverseList(ListNode head){

        ListNode cur=head;
        ListNode next=null;
        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next=next;
            next=cur;
            cur=tmp;
        }
        return next;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
