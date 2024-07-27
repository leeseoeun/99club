package club.beginner;

import java.util.Arrays;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Day5_완주하지_못한_선수 {

  public static String solution(String[] participant, String[] completion) {
    String answer = "";

    Arrays.sort(participant);
    Arrays.sort(completion);
    for (int i = 0; i < completion.length; i++) {
      if (!participant[i].equals(completion[i])) {
        answer = participant[i];
        return answer;
      }
    }

    answer = participant[participant.length];

    return answer;

    /*
     * HashMap<String, Integer> hm = new HashMap<>();
     * 
     * // getOrDefault(Object key, V defaultValue)
     * // key에 해당하는 키가 있다면 키의 밸류를 가지고 오고,
     * // 없다면 DefaultValue에 해당하는 값을 가지고 옴
     * 
     * for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
     * for (String player : completion) hm.put(player, hm.get(player) - 1);
     * 
     * for (String key : hm.keySet()) {
     *  if (hm.get(key) != 0){
     *      answer = key;
     *  }
     * }
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();
    String str3 = sc.next();
    String[] participant = {str1, str2, str3};
    String str4 = sc.next();
    String str5 = sc.next();
    String[] completion = {str4, str5};

    System.out.println(solution(participant, completion));

  }

}
