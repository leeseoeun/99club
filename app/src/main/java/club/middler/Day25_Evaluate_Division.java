package club.middler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/evaluate-division/description/
public class Day25_Evaluate_Division {

  public static double[] answer;
  public static Map<String, Map<String, Double>> graph;

  public static double[] calcEquation(List<List<String>> equations, 
      double[] values,
      List<List<String>> queries) {

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
      List<String> query = queries.get(i);
      String numerator = query.get(0);    // 분자
      String denominator = query.get(1);  // 분모

      // numerator / denominator
      // graph.get(a) : {b : 2.0, c : 5.0}
      // graph.get(b) : {c : 3.0, a : 1/2}
      // graph.get(c) : {a : 0.2, b : 1/3, d : ...}
      // graph.get(d) : {c : ...}
      /**
       *     a
       *    //  
       *    b = c
       *        ||
       *        d
       */
      HashMap<String, Integer> visited = new HashMap<>();
      if (graph.containsKey(numerator) && graph.containsKey(denominator)) {
        answer[i] = search(numerator, denominator, 1.0, visited);
      } 
    }

    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }

    return answer;
  }

  // numerator : a, denominator : x
  public static double search (String numerator, String denominator, double val, HashMap<String, Integer> visited) {
    visited.put(numerator, 1);

    Map<String, Double> node = new HashMap<>();
    node = graph.get(numerator);  // a : {b : 2.0, c : 5.0}

    System.out.println("numerator : " + numerator + ", denominator : " + denominator + ", node : " + node);

    if (node.containsKey(denominator)) {
      return node.get(denominator) * val;
    } else {
      for (String key : node.keySet()) {  // {x1=0.3333333333333333, x3=4.0}
        if (visited.getOrDefault(key, 0) != 1) {
          return search(key, denominator, val * node.get(key), visited); // b : {c : 3.0, a : 1/2}, c : {a : 0.2, b : 1/3, d : ...}, d : {c : ...}
        }
      }
    }

    return 1.0;
  }

  public static void main(String[] args) {
    // equations = [["a","b"],["b","c"]]
    // equations = [["a","b"],["b","c"],["c","d"]]  a/b 2.0, b/c 5.0, c/d 3.0 -> d/c 1/3, c/b 1/5, b/a 1/2
    List<List<String>> equations = List.of(
        //        List.of("a", "b"), // ["a", "b"]
        //        List.of("b", "c"),
        //        List.of("c", "d")
        List.of("x1","x2"),
        List.of("x2","x3"),
        List.of("x3","x4"),
        List.of("x4","x5")
        );

    //    double[] values = {2.0, 5.0, 3.0};
    double[] values = {3.0, 4.0, 5.0, 6.0};

    // ["d", "a"]
    List<List<String>> queries = List.of(
        //        List.of("a", "c"),
        //        List.of("b", "a"),
        //        List.of("a", "e"),
        //        List.of("a", "a"),
        //        List.of("x", "x")
        List.of("x1","x5"),
        List.of("x5","x2"),
        List.of("x2","x4"),
        List.of("x2","x2"),
        List.of("x2","x9"),
        List.of("x9","x9")
        );

    System.out.println(calcEquation(equations, values, queries));

  }

}
/**
 *  numerator : x1, denominator : x5, node : {x2=3.0}
    numerator : x2, denominator : x5, node : {x1=0.3333333333333333, x3=4.0}
    numerator : x3, denominator : x5, node : {x2=0.25, x4=5.0}
    numerator : x4, denominator : x5, node : {x3=0.2, x5=6.0}
    numerator : x5, denominator : x2, node : {x4=0.16666666666666666}
    numerator : x4, denominator : x2, node : {x3=0.2, x5=6.0}
    numerator : x3, denominator : x2, node : {x2=0.25, x4=5.0}

    numerator : x2, denominator : x4, node : {x1=0.3333333333333333, x3=4.0}
    numerator : x1, denominator : x4, node : {x2=3.0}

    numerator : x2, denominator : x2, node : {x1=0.3333333333333333, x3=4.0}
    numerator : x1, denominator : x2, node : {x2=3.0}
 */