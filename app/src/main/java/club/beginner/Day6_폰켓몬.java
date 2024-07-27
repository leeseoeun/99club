package club.beginner;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Day6_폰켓몬 {

  public static int solution(int[] nums) {
    int answer = 0;

    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int num : nums) {
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    answer = hm.keySet().size() >= (nums.length / 2) ? (nums.length / 2) : hm.keySet().size();

    //    if (hm.keySet().size() >= (nums.length / 2)) {
    //      return nums.length / 2;
    //    } else {
    //      return hm.keySet().size();
    //    }

    return answer;
  }

  public static void main(String[] args) {

    int[] nums = {3, 1, 2, 3};

    System.out.println(solution(nums));
  }

}
