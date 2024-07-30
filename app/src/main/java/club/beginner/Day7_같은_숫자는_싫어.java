package club.beginner;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Day7_같은_숫자는_싫어 {

  public static int[] solution(int []arr) {
    List<Integer> answer = new ArrayList<Integer>();

    answer.add(arr[0]);
    int preNum = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (preNum != arr[i]) {
        answer.add(arr[i]);
        preNum = arr[i];
      }
    }

    return answer.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {

    int[] arr = {1, 1, 3, 3, 0, 1, 1};

    System.out.println(solution(arr));

  }

}
