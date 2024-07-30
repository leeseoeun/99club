package club.beginner;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class Day3_문자열_내_p와_y의_개수 {

  static boolean solution(String s) {
    boolean answer = true;

    String[] sArr = s.split("");
    int pCount = 0;
    int yCount = 0;
    for (int i = 0; i < sArr.length; i++) {
      if (sArr[i].toLowerCase().equals("p")) {
        pCount++;
      } else if (sArr[i].toLowerCase().equals("y")) {
        yCount++;
      }
    }

    answer = (pCount == yCount ? true : (pCount == 0 && yCount == 0 ? true : false));

    return answer;

    /*
     * s = s.toLowerCase();
     * int count = 0;
     * 
     * for (int i = 0; i < s.length(); i++) {
     * 
     * if (s.charAt(i) == 'p')
     *  count++;
     * else if (s.charAt(i) == 'y')
     *  count--;
     * 
     * if (count == 0)
     *  return true;
     * else
     *  return false;
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    System.out.println(solution(s));

  }

}
