package leetcode.stack;

import java.util.Stack;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 22:03
 *  20. 有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 **/

public class IsValid {
    public boolean isValid(String s){
        char[] ch=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i]=='(' || ch[i] =='[' ||ch[i]=='{'){
                stack.push(ch[i]);
            }else if (ch[i]==')'){
                if (stack.isEmpty() || stack.peek()!='('){
                    return false;
                }
                stack.pop();
            }else if (ch[i]==']'){
                if (stack.isEmpty() || stack.peek()!='['){
                    return false;
                }
                stack.pop();
            }else if (ch[i]=='}'){
                if (stack.isEmpty() || stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
