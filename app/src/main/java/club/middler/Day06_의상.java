package club.middler;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42578
public class Day06_의상 {

  public static int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Integer> hm = new HashMap<String, Integer>();
    for (int i = 0; i < clothes.length; i++) {
      hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
    }

    for (int value : hm.values()) {
      answer *= (value + 1);
    }

    return answer - 1; // - 1 : 아무 종류도 안 입는 경우 제외

    /*
     * 1. 의상 종류가 1개인 경우 (의상 A가 a개)
     * -> a개의 조합 가능
     * 
     * 2. 의상 종류가 2개인 경우 (의상 A가 a개, 의상 B가 b개)
     * ->  a + b + ab개의 조합 가능
     * 
     * 3. 의상 종류가 3개인 경우 (의상 A가 a개, 의상 B가 b개, 의상 C가 c개)
     * -> a + b + c + ab + ac + bc + abc개의 조합 가능
     * 
     * 의상 종류가 1개 : a = (a + 1) - 1
     * 의상 종류가 2개 : a + b + ab = (a + 1)(b + 1) - 1
     * 의상 종류가 3개 : a + b + c + ab + ac + bc + abc = (a + 1)(b + 1)(c + 1) - 1
     * => (1번 종류의 수 + 1)(2번 종류의 수 + 1) ... (n번 종류의 수 + 1) - 1 을 계산하면 됨
     * */
  }

  public static void main(String[] args) {

    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    System.out.println(solution(clothes));

  }

}
