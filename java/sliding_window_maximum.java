public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k +1; i++) {
            int max =0;
            for (int j=i;j<k+i;j++){
                if (j==i){
                    max =nums[j];
                }else{
                    if(nums[j]>max){
                        max=nums[j];
                    }
                }
            }
            result[i] = max;
        }

        return result;
    }
}