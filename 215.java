public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, k);

    }

    public int find(int[] nums, int l, int r, int k) {
        while (l < r) {
            int i = l;
            int j = r;
            int x = nums[l];
            //sorted from big to small
            while (i < j) {
                while (i < j && nums[j] < x) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] >= x) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            //now i == j
            nums[i] = x;

            if (i == k - 1) {
                return nums[i];
            } else if (i < k - 1) {
                l = i+1;
            }else {
                r = i-1;
            }

        }
        return nums[k-1];
    }

}
