package club.middler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/evaluate-division/description/
class Day25_Evaluate_Division2 {
  public static double[] answer;
  public static Map<String, Map<String, Double>> graph;
  //  public static boolean stop = false; // 멈춤

  public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    answer = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      answer[i] = -1.0;
    }

    // 그래프 만들기
    graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      //equations.get(i); // ["a", "b"]

      String a = equations.get(i).get(0); // "a"
      String b = equations.get(i).get(1); // "b"
      double value = values[i]; // 2.0

      // a - b
      graph.putIfAbsent(a, new HashMap<>());  // {a : {}}
      graph.putIfAbsent(b, new HashMap<>());

      graph.get(a).put(b, value); // {a : {b : value, c : value2}}
      graph.get(b).put(a, 1 / value);
    }

    for (int i = 0; i < queries.size(); i++) {
      //      stop = false; // 케이스 하나 돌 때마다 초기화
      List<String> query = queries.get(i);
      String numerator = query.get(0);    // 분자
      String denominator = query.get(1);  // 분모

      HashMap<String, Integer> visited = new HashMap<>();
      if (graph.containsKey(numerator) && graph.containsKey(denominator)) {
        if (numerator.equals(denominator)) {
          answer[i] = 1.0;
          continue;
        }
        search(numerator, denominator, -1.0, visited, i);
      }
    }

    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }

    return answer;
  }

  // numerator : a, denominator : x
  public static void search (String numerator, String denominator, double val, HashMap<String, Integer> visited, int idx) {
    //    if (!stop) {
    visited.put(numerator, 1);

    Map<String, Double> node = new HashMap<>();
    node = graph.get(numerator);  // a : {b : 2.0, c : 5.0}
    System.out.println("numerator : " + numerator + ", denominator : " + denominator + ", node : " + node);
    if (node.containsKey(denominator)) {
      //        stop = true;
      answer[idx] *= (node.get(denominator) * val);
    } else {
      for (String key : node.keySet()) {
        if (visited.getOrDefault(key, 0) != 1 && answer[idx] == -1) {
          search(key, denominator, val * node.get(key), visited, idx); // b : {c : 3.0, a : 1/2}, c : {a : 0.2, b : 1/3, d : ...}, d : {c : ...}
        }
      }
    }
    //  }
  }
}