package leetcode.MapAndSet;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-11 16:39
 **/

public class IsAnagram {

    public boolean isAnggram_1(String s, String t){
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        return String.valueOf(sCh).equals(String.valueOf(tCh));
    }

    public boolean isAnggram_2(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c :s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (Character c: t.toCharArray()){
            Integer count=map.get(c);
            if (count==null){
                return false;
            }else if (count>1){
                map.put(c,count-1);
            }else {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram(String s, String t){
        int[] sCount=new int[26];
        int[] tCount=new int[26];
        for (char c:s.toCharArray()) {
            sCount[c-'a']++;
        }
        for (char c:t.toCharArray()) {
            tCount[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCount[i]!=tCount[i]){
                return false;
            }
        }
        return true;
    }
}
