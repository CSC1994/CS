package leetcode.recrusion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 19:52
 * 169、多数元素
 **/

public class MajorityElement {
    public int majorityElement(int[] nums){
        int count=1;
        int num=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if (num==nums[i]){
                count++;
            }else {
                count--;
                if (count==0){
                    num=nums[i+1];
                }
            }
        }
        return num;
    }
}
