package club.middler;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Day12_H_Index {

  public static int solution(int[] citations) {
    int answer = 0;

    Arrays.sort(citations);

    return answer;
  }

  public static void main(String[] args) {

    //    int[] citations = {3, 0, 6, 1, 5};
    int[] citations = {1, 2, 3, 5, 6, 7, 10, 11};

    System.out.println(solution(citations));

  }

}
