package leetcode.stack;

import java.util.PriorityQueue;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-11 13:55
 * 703. 数据流中的第K大元素
 **/

public class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : arr) {
            add(n);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

}
