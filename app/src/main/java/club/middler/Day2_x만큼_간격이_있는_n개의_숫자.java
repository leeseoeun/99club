package club.middler;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12954
public class Day2_x만큼_간격이_있는_n개의_숫자 {

  public static long[] solution(int x, int n) {
    long[] answer = new long[n];

    // x = 10000000, n = 1000일 때 int의 범위를 벗어나기 때문에 long으로 형 변환
    long num = Long.valueOf(x);
    for (int i = 0; i < n; i++) {
      answer[i] = (num * (i + 1));
    }

    return answer;

    /*
     * answer[0] = x;
     * for (int i = 1; i < n; i++) {
     *  answer[i] = answer[i - 1] + x;
     * }
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int n = sc.nextInt();

    System.out.println(solution(x, n));

  }

}
