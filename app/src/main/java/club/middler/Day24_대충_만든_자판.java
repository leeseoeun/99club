package club.middler;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/160586
public class Day24_대충_만든_자판 {

  public static int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];

    Map<String, Integer> hm = new HashMap<>();
    for (int i = 0; i < keymap.length; i++) {
      String[] keymapArr = keymap[i].split("");

      for (int j = 0; j < keymapArr.length; j++) {
        hm.put(keymapArr[j], Math.min(hm.getOrDefault(keymapArr[j], 100), j + 1));
      }
    }

    for (int i = 0; i < targets.length; i++) {
      String[] targetsArr = targets[i].split("");
      int result = 0;

      for (int j = 0; j < targetsArr.length; j++) {
        if (hm.get(targetsArr[j]) == null) { // if (!hm.containsKey(targetsArr[j]))
          result = -1;
          break;
        } else {
          result += hm.get(targetsArr[j]);
        }
      }

      answer[i] = result;
    }

    return answer;
  }

  public static void main(String[] args) {

    //    String[] keymap = {"ABACD", "BCEFD"};
    //    String[] targets = {"ABCD","AABB"};
    //    String[] keymap = {"AA"};
    //    String[] targets = {"B"};
    //    String[] keymap = {"AGZ", "BSSS"};
    //    String[] targets = {"ASA","BGZ"};
    String[] keymap = {"ABCDE"};
    String[] targets = {"FGHIJ"};

    System.out.println(solution(keymap, targets));

  }

}
