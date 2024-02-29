package LeetCode.ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                stack.push(array[i]);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char current = stack.pop();
                if(current=='(' && array[i]==')')
                    continue;
                if(current=='{' && array[i]=='}')
                    continue;
                if(current=='[' && array[i]==']')
                    continue;
                return false;
            }
        }
        if(!stack.isEmpty())
            return false;

        return true;
    }
}
