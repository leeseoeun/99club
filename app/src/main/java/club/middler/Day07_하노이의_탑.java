package club.middler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946
public class Day07_하노이의_탑 {

  static List<int[]> list = new ArrayList<int[]>();

  public static void move(int count, int start, int end, int middle) {  // 1, 3, 2
    // 원반이 한개인 경우
    // 한개 : 일번 -> 삼번 기둥
    if (count == 1) {
      list.add(new int[] {start, end});

      // 원반이 두개 이상인 경우
      // n - 1개     : 일번 -> 삼번 -> 이번 기둥
      // 나머지 한개 : 일번 -> 삼번 기둥
      // n - 1개     : 이번 -> 일번 -> 삼번 기둥
    } else {
      move(count - 1, start, middle, end);  // n - 1개     : 일번 -> 삼번 -> 이번 기둥
      list.add(new int[] {start, end});     // 나머지 한개 : 일번 -> 삼번 기둥
      move(count - 1, middle, end, start);  // n - 1개     : 이번 -> 일번 -> 삼번 기둥
    }
  }

  public static int[][] solution(int n) {

    move(n, 1, 3, 2);

    int[][] answer = new int[list.size()][];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(solution(n));

  }

}
