package club.middler;

import java.util.ArrayList;

class Solution {
  public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> answer = new ArrayList<>();

    int endProgress = 0;    // 첫번째 기준
    int count = 0;          // 배포되는 기능 수
    while (endProgress < progresses.length) {
      for (int i = endProgress; i < progresses.length; i++) {
        progresses[i] += speeds[i];
      }
      if (progresses[endProgress] >= 100) {
        for (int i = endProgress; i < progresses.length; i++) {
          count++;
          if (i == progresses.length - 1 || progresses[i + 1] < 100) {
            endProgress = i + 1;
            answer.add(count);
            break;
          }
        }
      }

      count = 0;
    }

    return answer;
  }
}

/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    // 각 기능의 개발이 완료되는 데 필요한 날 수를 저장할 리스트
    List<Integer> days = new ArrayList<>();

    // 각 기능별로 개발 완료까지 걸리는 날 수를 계산
    for (int i = 0; i < progresses.length; i++) {
      int progress = progresses[i];  // 현재 작업의 진도
      int speed = speeds[i];          // 현재 작업의 개발 속도
      // 작업 완료까지 걸리는 날 수 계산
      int daysToComplete = (int) Math.ceil((100.0 - progress) / speed);
      // 리스트에 계산된 날 수 추가
      days.add(daysToComplete);
    }

    // 개발 완료까지 걸리는 날 수를 큐에 저장
    Queue<Integer> queue = new LinkedList<>(days);
    // 각 배포일에 몇 개의 기능이 배포되는지를 저장할 리스트
    List<Integer> result = new ArrayList<>();

    // 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      // 현재 처리할 기능의 개발 완료까지 걸리는 날 수
      int currentDay = queue.poll();
      int count = 1;  // 현재 기능을 포함하여 배포되는 기능 수 (최소 1개는 배포됨)

      // 현재 기능이 배포될 날에 배포될 수 있는 후속 기능들 확인
      while (!queue.isEmpty() && queue.peek() <= currentDay) {
        queue.poll();  // 후속 기능을 큐에서 제거
        count++;       // 배포되는 기능 수 증가
      }

      // 배포되는 기능의 수를 결과 리스트에 추가
      result.add(count);
    }

    // 결과 리스트를 배열로 변환하여 반환
    return result.stream().mapToInt(i -> i).toArray();
  }
}
 */