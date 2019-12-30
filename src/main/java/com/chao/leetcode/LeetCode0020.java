package com.chao.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode0020 {
    /**
     * 初始化有效括号规则
     */
    public static Map<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');
    }

    /**
     * 通过栈来判断是否是有效括号
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                Character peek = stack.peek();
                if (null != mappings.get(peek) && mappings.get(peek) == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    static class Test {
        public static void main(String[] args) {
            String s = "()[]{}";
            System.out.println(isValid(s));
        }
    }
}
