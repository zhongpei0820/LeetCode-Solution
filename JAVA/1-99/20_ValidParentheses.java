// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// Solution : We can use a stack to solve this problem by the following steps.
// 1. If the stack is empty, we push the str[i] into the stack, i++;
// 2. Then we check if str[i] == stack.peek(), if yes, pop it out; if not, push str[i] into the stack;
// 3. After finishing the iteration, if the stack is empty return true; if not, return false.

public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(!isPair(stack.peek(),s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
                return stack.empty();
    }

    private boolean isPair(char c1, char c2){
        if(c1 == '(' && c2 == ')') return true;
        if(c1 == '[' && c2 == ']') return true;
        if(c1 == '{' && c2 == '}') return true;
        return false;
    }
}