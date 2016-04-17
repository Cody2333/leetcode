public class Solution {
    public List<List<String>> partition(String s) {
        List<String> r = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        //先循环遍历标记所以的
        //dp 用于标记回文字符串
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int k = 0;
                for (; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        break;
                    }
                }
                if (k == (j - i+1) / 2) {
                    //是回文字符子串
                    dp[i][j] = 1;
                }
            }
        }

        //遍历标记完成后进行深搜
        dfs(0, dp, s, r, result);
        return result;
    }

    private void dfs(int pos, int[][] dp, String s, List<String> r, List<List<String>> result) {
        if (pos == s.length()) {
            //一次深搜结束
            List<String> t = new ArrayList<>(r);
            Collections.reverse(t);
            System.out.println(t);
            result.add(t);
            return;
        }

        for (int j = pos; j < s.length(); j++) {
            if (dp[pos][j] == 1) {
                //是回文字符子串
                r.add(0, s.substring(pos, j + 1));
                dfs(j + 1, dp, s, r, result);
                r.remove(0);
            }
        }


    }

}