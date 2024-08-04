package club.middler;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Day12_H_Index {

  public static int solution(int[] citations) {
    int answer = 0;

    Arrays.sort(citations);

    for (int i = 0; i < citations.length; i++) {
      int count = 0;
      for (int j = i; j < citations.length; j++) {
        if (citations[i] <= citations[j]) {
          count++;
        }
      }

      answer = Math.max(answer, Math.min(citations[i], count));
    }

    return answer;

    /*
     * Arrays.sort(citations);
     * 
     * int len = citations.length;
     * for (int i = 0; i < len; i++) {
     *  int paper = len - i;
     *  if (citations[i] >= paper) {answer = paper; break;}
     * }
     * */
  }

  public static void main(String[] args) {

    //    int[] citations = {3, 0, 6, 1, 5};
    int[] citations = {1, 2, 3, 5, 6, 7, 10, 11};

    System.out.println(solution(citations));

  }

}
