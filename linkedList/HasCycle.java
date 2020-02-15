package leetcode.linkedList;

import java.util.concurrent.locks.Lock;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 16:50
 *  141、环形链表
 *  给定一个链表，判断是否有环
 **/

public class HasCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head){

        ListNode fast=head;
        ListNode slow=head;
        while (slow !=null && fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
