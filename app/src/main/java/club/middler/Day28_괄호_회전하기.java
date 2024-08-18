package club.middler;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Day28_괄호_회전하기 {

  public static int solution(String s) {
    int answer = 0;

    String[] ss = s.split("");
    for (int i = 0; i < ss.length; i++) {
      String newS = s.substring(i) + s.substring(0, i);
      System.out.println(newS);
    }

    return answer;
  }

  public static void main(String[] args) {

    String s = "[](){}";

    System.out.println(solution(s));

  }

}
