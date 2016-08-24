import java.util.ArrayList;
import java.util.List;

/**
 * Created by cody_local on 2016/4/7.
 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            if(i == num.length-1){
                return current;
            }
            result = new ArrayList<>(current);
        }
        return null;
    }
}