package club.middler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42628
public class Day10_이중우선순위큐 {

  public static int[] solution(String[] operations) {
    int[] answer = new int[2];

    List<Integer> nums = new ArrayList<>();
    for (String o : operations) {
      String[] str = o.split(" ");
      if (str[0].startsWith("I")) {
        nums.add(Integer.parseInt(str[1]));

        // 최댓값 삭제
      } else if (nums.size() != 0 && str[1].equals("1")) {
        Collections.sort(nums, Collections.reverseOrder());

        nums.remove(0);

        // 최솟값 삭제
      } else if (nums.size() != 0 && str[1].equals("-1")) {
        Collections.sort(nums);

        nums.remove(0);
      }
    }

    if (nums.size() == 0) {
      answer[0] = 0;
      answer[1] = 0;

    } else {
      Collections.sort(nums);

      answer[0] = nums.get(nums.size() - 1);
      answer[1] = nums.get(0);
    }

    //////////////////////////////////////////////////

    // 오름차순
    PriorityQueue<Integer> ascending = new PriorityQueue<>();
    // 내림차순
    PriorityQueue<Integer> descending = new PriorityQueue<>(Collections.reverseOrder());

    for (String o : operations) {
      String[] str = o.split(" ");
      if (str[0].startsWith("I")) {
        ascending.offer(Integer.parseInt(str[1]));
        descending.offer(Integer.parseInt(str[1]));

        // 최댓값 삭제
      } else if (!ascending.isEmpty() && str[1].equals("1")) {
        ascending.remove(descending.poll());

        // 최솟값 삭제
      } else if (!descending.isEmpty() && str[1].equals("-1")) {
        descending.remove(ascending.poll());
      }
    }

    answer[0] = (descending.peek() == null ? 0 : descending.poll());
    answer[1] = (ascending.peek() == null ? 0 : ascending.poll());

    return answer;
  }

  public static void main(String[] args) {

    //    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

    System.out.println(solution(operations));

  }

}
