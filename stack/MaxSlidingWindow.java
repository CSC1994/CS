package leetcode.stack;

import java.util.*;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-11 14:14
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值
 **/

public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length<2){
            return nums;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });

        List<Integer> res = new ArrayList<>(nums.length - k + 1);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        res.add(maxHeap.peek());
        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i-k]);
            maxHeap.offer(nums[i]);
            res.add(maxHeap.peek());
        }
        int[] out = new int[nums.length - k + 1];
        int count = 0;
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()) {
            out[count] = iterator.next();
            count++;
        }
        return out;

    }
}
