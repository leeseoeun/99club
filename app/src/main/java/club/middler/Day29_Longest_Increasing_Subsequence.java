package club.middler;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Day29_Longest_Increasing_Subsequence {

  public static int lengthOfLIS(int[] nums) {
    int answer = 0;

    //    Stack<Integer> stack = new Stack<>();
    //    for (int i = 0; i < nums.length; i++) {
    //      System.out.println("현재 숫자 : " + nums[i]);
    //      if (!stack.isEmpty()) {
    //        System.out.println("stack에 있는 마지막 숫자 : " + stack.peek());
    //        if (nums[i] <= stack.peek()) {
    //          System.out.println("숫자 뺌 : " + stack.peek());
    //          //          while (!stack.isEmpty() && nums[i] <= stack.peek()) {
    //          stack.pop();
    //          //          }
    //        }
    //      }
    //      stack.add(nums[i]);
    //
    //      System.out.println(stack);
    //      System.out.println("----------");
    //    }
    //
    //    answer = stack.size();

    return answer;
  }

  public static void main(String[] args) {

    //    int[] nums = {10,9,2,5,3,7,101,18};
    //    int[] nums = {4,10,4,3,8,9};
    int[] nums = {0,1,0,3,2,3};

    System.out.println(lengthOfLIS(nums));

  }

}
