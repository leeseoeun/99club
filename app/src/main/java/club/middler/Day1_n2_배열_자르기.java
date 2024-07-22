package club.middler;

import java.util.Scanner;

public class Day1_n2_배열_자르기 {

  public static int[] solution(int n, long left, long right) {
    /*
     * n = 3, left = 2, right = 5일 때
     * 이차원 배열에 해당하는 인덱스는
     * arr[0][2], ..., arr[1][2]
     * == arr[2 / 3][2 % 3], ..., arr[5 / 3][5 % 3]
     * == arr[left / n][left % n], ..., arr[right / n][right % n]
     * */

    int[] answer = new int[(int) (right - left + 1)];
    for (long i = left; i < right + 1; i++) {
      answer[(int) (i - left)] = ((int) Math.max(i / n, i % n) + 1);
    }

    return answer;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long left = sc.nextInt();
    long right = sc.nextInt();

    System.out.println(solution(n, left, right));

  }

}
