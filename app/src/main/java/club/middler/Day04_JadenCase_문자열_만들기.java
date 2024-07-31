package club.middler;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Day04_JadenCase_문자열_만들기 {

  public static String solution(String s) {
    String answer = "";

    String[] ss = s.split("");
    answer += ss[0].toUpperCase();
    for (int i = 1; i < ss.length; i++) {
      // 첫글자
      if (ss[i - 1].equals(" ") && !ss[i].equals(" ")) {
        answer += ss[i].toUpperCase();

        // 연속 공백
      } else if (ss[i - 1].equals(" ") && ss[i].equals(" ")) {
        answer += " ";

        // 나머지 글자
      } else {
        answer += ss[i].toLowerCase();
      }
    }

    return answer;

    /*
     * String[] sp = s.toLowerCase().split("");
     * boolean flag = true;
     * 
     * for(String ss : sp) {
     *  answer += flag ? ss.toUpperCase() : ss;
     *  flag = ss.equals(" ") ? true : false;
     * }
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    System.out.println(solution(s));

  }

}
