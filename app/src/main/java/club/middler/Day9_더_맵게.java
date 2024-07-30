package club.middler;

import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class Day9_더_맵게 {

  public static int solution(int[] scoville, int K) {
    int answer = 0;

    // 우선 순위 큐
    // 기본 값 : 오름차순
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s : scoville) {
      // add    : 값 추가 / 실패 시 에러 발생
      // offer  : 값 추가 / 실패 시 false 반환
      pq.offer(s);
    }

    // peek : 첫번째 값을 '제거하지 않고' 반환
    // poll : 첫번째 값을 '제거하고' 반환
    while (pq.size() > 1 && pq.peek() < K) {
      answer++;

      int newScoville = pq.peek() + pq.peek() * 2;
      pq.add(newScoville);
    }
    // 우선 순위(오름차순) 값이 먼저 나오기 때문에 새로운 스코빌 지수 추가
    // 스코빌 지수가 가장 낮은 값과 K를 비교하고 낮은 값 두개를 계산하여 비교

    if (pq.peek() < K) {
      return -1;
    }

    return answer;
  }

  public static void main(String[] args) {

    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;

    System.out.println(solution(scoville, K));

  }

}
