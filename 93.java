import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by cody_local on 2016/4/7.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        if (length < 4 || length > 12) {
            return result;
        }
        int[] divider = {1, 2, 3};
        int[] last = {length - 3, length - 2, length - 1};
        while (true) {
            String[] slist = new String[4];
            slist[0] = s.substring(0, divider[0]);
            slist[1] = s.substring(divider[0], divider[1]);
            slist[2] = s.substring(divider[1], divider[2]);
            slist[3] = s.substring(divider[2], length);

            if (isValid(slist)) {
                result.add(slist[0] + "." + slist[1] + "." + slist[2] + "." + slist[3]);
            }
            if (divider[2]!=length-1){
                divider[2]++;
            }else if (divider[2]==length-1){
                if (divider[1]!= length-2){
                    divider[1]++;
                    divider[2]=divider[1]+1;
                }else if (divider[1]==length-2){
                    if (divider[0]!= length-3){
                        divider[0]++;
                        divider[1]=divider[0]+1;
                        divider[2]=divider[1]+1;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }


    private Boolean isValid(String[] slist) {
        Boolean result = true;
        for (String s : slist) {
            if (s.charAt(0)=='0'){
                if (!s.equals("0")){
                    result = false;
                }
            }else{
                Integer num = Integer.parseInt(s);
                if (num > 255 || num < 0) {
                    result = false;
                }
            }

        }
        return result;
    }
}