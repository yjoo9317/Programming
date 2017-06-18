import java.utill.*;

public class Solution {
	public static int sqrt(int a) {
        if(a == 0 || a == 1) {
            return a;
        }
        int start = 1, end = a / 2;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == a / mid) {
                return mid;
            }
            if(mid < a / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
	}
  
  public static void main(String[] args){
    System.out.println(sqrt(54321));
  }
}
