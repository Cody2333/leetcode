/**
 * Created by cody_local on 2016/4/7.
 * substring效率太低了，需要手动使用索引进行字符串截取。
 */
public class Solution {
    public boolean isMatch(String s,String p){
        return isMatch(s,p,0,0);
    }
    public boolean isMatch(String s, String p,int s_index,int p_index) {
        // base case
        if (p.length()-p_index == 0) {
            return s.length()-s_index == 0;
        }

        // special case
        if (p.length()-p_index == 1) {

            // if the length of s is 0, return false
            if (s.length()-s_index < 1) {
                return false;
            }

            //if the first does not match, return false
            else if ((p.charAt(p_index) != s.charAt(s_index)) && (p.charAt(p_index) != '.')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s,p,s_index+1,p_index+1);
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(p_index+1) != '*') {
            if (s.length()-s_index < 1) {
                return false;
            }
            if ((p.charAt(p_index) != s.charAt(s_index)) && (p.charAt(p_index) != '.')) {
                return false;
            } else {
                return isMatch(s,p,s_index+1,p_index+1);
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s,p,s_index,p_index+2)) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i < (s.length()-s_index) && (s.charAt(s_index+i) == p.charAt(p_index) || p.charAt(p_index) == '.')) {
                if (isMatch(s,p,s_index+1+i,p_index+2)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}