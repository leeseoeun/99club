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

    Map<String, Integer> xyz = new HashMap<>();

    return answer;
  }

  public static void main(String[] args) {

    String[] want = {"banana", "apple", "rice", "pork", "pot"};
    int[] number = {3, 2, 2, 2, 1};
    String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

    System.out.println(solution(want, number, discount));

  }

}
