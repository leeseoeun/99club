package club.middler;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Day27_할인_행사 {

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    Map<String, Integer> jh = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      jh.put(want[i], number[i]);
    }

    for (int i = 0; i < discount.length - 9; i++) {
      Map<String, Integer> xyz = new HashMap<>();
      boolean flag = true;

      for (int j = i; j < 10 + i; j++) {
        xyz.put(discount[j], xyz.getOrDefault(discount[j], 0) + 1);
      }

      for (String k : jh.keySet()) {
        if (jh.get(k) != xyz.get(k)) {
          flag = false;
        }
      }

      if (flag) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {

    String[] want = {"banana", "apple", "rice", "pork", "pot"};
    int[] number = {3, 2, 2, 2, 1};
    String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

    System.out.println(solution(want, number, discount));

  }

}
