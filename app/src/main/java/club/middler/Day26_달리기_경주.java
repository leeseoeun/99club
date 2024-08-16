package club.middler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Day26_달리기_경주 {

  public static String[] solution(String[] players, String[] callings) {
    String[] answer = new String[players.length];

    Map<String, Integer> name = new HashMap<>();
    Map<Integer, String> rank = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      name.put(players[i], i + 1);
      rank.put(i + 1, players[i]);
    }

    for (int i = 0; i < callings.length; i++) {
      int currentRank = name.get(callings[i]);
      String previousName = rank.get(currentRank - 1);

      name.put(callings[i], currentRank - 1);
      name.put(previousName, currentRank);

      rank.put(currentRank - 1, callings[i]);
      rank.put(currentRank, previousName);
    }

    List<Integer> keySet = new ArrayList<>(rank.keySet());
    Collections.sort(keySet);

    for (int i = 0; i < answer.length; i++) {
      answer[i] = rank.get(keySet.get(i));
    }

    return answer;

    /*
     * int n = players.length;
     * HashMap<String, Integer> indexMap = new HashMap<>();
     * 
     * for (int i = 0; i < n; i++) {
     *  indexMap.put(players[i], i);
     * }
     * 
     * for (String calling : callings) {
     *  int idx = indexMap.get(calling);
     *  if (idx > 0) {
     *      String temp = players[idx - 1];
     *      players[idx - 1] = players[idx];
     *      players[idx] = temp;
     *      
     *      indexMap.put(players[idx - 1], idx - 1);
     *      indexMap.put(players[idx], idx);
     *  }
     * }
     * 
     * return players;
     * */
  }

  public static void main(String[] args) {

    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};

    System.out.println(solution(players, callings));

  }

}
