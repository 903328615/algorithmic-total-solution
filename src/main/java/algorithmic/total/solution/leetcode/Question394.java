package algorithmic.total.solution.leetcode;

import java.util.Stack;

/**
 * @program: algorithmic-total-solution
 * @description: 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * @author: wangzibin
 * @create: 2023-03-10
 **/
public class Question394 {

    public static String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                // 可以弹出了
                StringBuilder tmpStr = new StringBuilder();
                while (!stack.empty() && !"[".equals(stack.peek())) {
                    tmpStr.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder tmpNum = new StringBuilder();
                while (!stack.empty() && isNumeric(stack.peek())) {
                    tmpNum.insert(0, stack.pop());
                }
                int num = Integer.parseInt(tmpNum.toString());
                StringBuilder decode = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    decode.append(tmpStr);
                }
                stack.push(decode.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        StringBuilder result=new StringBuilder();
        while (!stack.empty()&&!isNumeric(stack.peek())) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a1[c2[q]]]"));
    }
}

