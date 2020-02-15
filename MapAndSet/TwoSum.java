package leetcode.MapAndSet;

import java.util.HashMap;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-11 17:15
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] index=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                index[0]=i;
                index[1]=map.get(nums[i]);
                return index;
            }
            map.put(target-nums[i],i);
        }
        return index;
    }
}
