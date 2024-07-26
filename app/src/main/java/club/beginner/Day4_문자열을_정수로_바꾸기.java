package club.beginner;

import java.util.Scanner;

public class Day4_문자열을_정수로_바꾸기 {

  public static int solution(String s) {
    int answer = 0;

    String sign = s.substring(0, 1);
    if (sign.equals("+")) {
      answer = Integer.parseInt(s.substring(1));
    } else if (sign.equals("-")) {
      answer -= Integer.parseInt(s.substring(1));
    } else {
      answer = Integer.parseInt(s);
    }

    return answer;

    /*
     * return Integer.parseInt(s);
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    System.out.println(solution(s));

  }

}
