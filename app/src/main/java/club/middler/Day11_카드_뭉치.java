package club.middler;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class Day11_카드_뭉치 {

  public static String solution(String[] cards1, String[] cards2, String[] goal) {
    String answer = "";

    List<String> card1Arr = new ArrayList<>();
    for (String card1 : cards1) {
      card1Arr.add(card1);
    }

    List<String> card2Arr = new ArrayList<>();
    for (String card2 : cards2) {
      card2Arr.add(card2);
    }

    /*
     *  List<String> card1Ary = new ArrayList<>(Arrays.asList(cards1));
     *  List<String> card2Ary = new ArrayList<>(Arrays.asList(cards2));
     * */

    for (int i = 0; i < goal.length; i++) {
      if (card1Arr.size() != 0 && goal[i].equals(card1Arr.get(0))) {
        card1Arr.remove(0);

      } else if (card2Arr.size() != 0 && goal[i].equals(card2Arr.get(0))) {
        card2Arr.remove(0);

      } else {
        return "No";
      }
    }

    return answer = "Yes";

    /*
     * int cardIdx1 = 0;
     * int cardIdx2 = 0;
     * 
     * for(int i=0; i<goal.length; i++){
     *  String target = goal[i];
     *  
     *  if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
     *      cardIdx1 ++;
     *  else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
     *      cardIdx2++;
     *  else
     *      return "No";
     * }
     * 
     * return "Yes";
     * */
  }

  public static void main(String[] args) {

    //    String[] cards1 = {"i", "drink", "water"};
    String[] cards1 = {"i", "water", "drink"};
    String[] cards2 = {"want", "to"};
    String[] goal = {"i", "want", "to", "drink", "water"};

    System.out.println(solution(cards1, cards2, goal));

  }

}
