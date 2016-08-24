/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int high = n;
        int low = 1;
        while (true) {
            int mid = low + (high-low)/2;
            int flag = guess(mid);
            if (flag == -1) {
                high = mid-1;
            } else if (flag == 1) {
                low = mid+1;
            } else if (flag == 0) {
                return mid;
            }
        }
    }
}
