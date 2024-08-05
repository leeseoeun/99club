package club.middler; 

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/prefix-and-suffix-search/submissions/1345265167/
public class Day15_Prefix_and_Suffix_Search {

  static class WordFilter {

    static Map<String, Integer> hm = new HashMap<String, Integer>();

    public WordFilter(String[] words) {
      for (int i = 0; i < words.length; i++) {
        for (int j = 0; j < words[i].length() + 1; j++) {
          for (int k = 0; k < words[i].length() + 1; k++) {
            hm.put(words[i].substring(0, j) + "#" + words[i].substring(k), i);

            System.out.println(words[i].substring(0, j) + "#" + words[i].substring(k));
          }
        }
      }
    }

    public int f(String pref, String suff) {
      int answer = -1;

      answer = (hm.get(pref + "#" + suff) != null ? hm.get(pref + "#" + suff) : -1);

      return answer;
    }
  }

  public static void main(String[] args) {

    String[] words = {"apple"};
    String pref = "a";
    String suff = "e";
    //    String[] words = {"abbba","abba"};
    //    String pref = "ab";
    //    String suff = "ba";

    WordFilter obj = new WordFilter(words);
    int param_1 = obj.f(pref,suff);
    System.out.println(param_1);

  }

}
