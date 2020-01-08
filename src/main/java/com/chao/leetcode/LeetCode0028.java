package com.chao.leetcode;

public class LeetCode0028 {
    /**
     * 暴力求解法
     *
     * @param srcStr
     * @param dstStr
     * @return
     */
    public static int strStr(String srcStr, String dstStr) {
        int M = srcStr.length();
        int N = dstStr.length();
        for (int i = 0; i < M - N; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (srcStr.charAt(j + i) != dstStr.charAt(j))
                    break;
            }
            // pat 全都匹配了
            if (j == N) return i;
        }
        // txt 中不存在 pat 子串
        return -1;
    }

    static class Test {
        public static void main(String[] args) {
            int i = strStr("111113333sss", "3s");
            System.out.println(i);
        }
    }


    class KMP {
        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            this.pat = pat;
            int M = pat.length();
            // dp[状态][字符] = 下个状态
            dp = new int[M][256];
            // base case
            dp[0][pat.charAt(0)] = 1;
            // 影子状态 X 初始为 0
            int X = 0;
            // 构建状态转移图（稍改的更紧凑了）
            for (int j = 1; j < M; j++) {
                for (int c = 0; c < 256; c++) {
                    dp[j][c] = dp[X][c];
                    dp[j][pat.charAt(j)] = j + 1;
                    // 更新影子状态
                    X = dp[X][pat.charAt(j)];
                }
            }
        }

        public int search(String txt) {
            int M = pat.length();
            int N = txt.length();
            // pat 的初始态为 0
            int j = 0;
            for (int i = 0; i < N; i++) {
                // 计算 pat 的下一个状态
                j = dp[j][txt.charAt(i)];
                // 到达终止态，返回结果
                if (j == M) return i - M + 1;
            }
            // 没到达终止态，匹配失败
            return -1;
        }
    }

}
