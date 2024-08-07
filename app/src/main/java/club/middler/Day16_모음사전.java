package club.middler;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Day16_모음사전 {

  static String[] alphabet = {"A", "E", "I", "O", "U"};
  static List<String> list = new ArrayList<String>();
  static int idx = 0;

  private static void addAlphabet(String currentWord, int length) {
    if (length > 5) {
      return;
    }

    list.add(currentWord);

    for (int i = 0; i < alphabet.length; i++) {
      addAlphabet(currentWord + alphabet[i], length + 1);
    }
  }

  public static int solution(String word) {
    int answer = 0;

    addAlphabet("", 0);

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(word)) {
        answer = i;
      }
    }

    return answer;
  }

  public static void main(String[] args) {

    String word = "AAAAE";

    System.out.println(solution(word));

  }

}
