package club.middler;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Day19_구명보트 {

  public static int solution(int[] people, int limit) {
    int answer = 0;

    // 투 포인터
    int left = 0;
    int right = people.length - 1;

    Arrays.sort(people);

    // 두 포인터가 만날 때까지
    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
      }

      right--; // 무거운 큰 사람만 태우기

      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {

    //    int[] people = {70, 50, 80, 50};
    int[] people = {70, 80, 50};
    int limit = 100;

    System.out.println(solution(people, limit));

  }

}
