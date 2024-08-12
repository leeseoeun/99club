package club.middler;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Day20_큰_수_만들기 {

  public static String solution(String number, int k) {
    StringBuilder answer = new StringBuilder();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < number.length(); i++) {
      char num = number.charAt(i);
      while (!stack.isEmpty() && stack.peek() < num && k > 0) {
        stack.pop();
        k--;
      }

      stack.add(num);
    }

    for (int i = 0; i < stack.size(); i++) {
      answer.append(stack.get(i));
    }

    return answer.toString().substring(0, answer.length() - k);
  }

  public static void main(String[] args) {

    //    String number = "1924";
    //    int k = 2;
    String number = "1231234";
    int k = 3;

    System.out.println(solution(number, k));

  }

}
