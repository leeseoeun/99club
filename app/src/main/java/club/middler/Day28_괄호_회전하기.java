package club.middler;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Day28_괄호_회전하기 {

  public static int solution(String s) {
    int answer = 0;

    String newS = "";
    Stack<Character> stack = new Stack<>();
    boolean flag = true;

    for (int i = 0; i < s.length(); i++) {
      newS = s.substring(i) + s.substring(0, i);
      stack.clear();
      flag = true;

      for (char c : newS.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
          stack.push(c);
        } else {
          if (stack.isEmpty()) {
            flag = false;
            break;
          }

          char top = stack.pop();
          if ((c == ')' && top != '(') ||
              (c == ']' && top != '[') ||
              (c == '}' && top != '{')) {
            flag = false;
          }
        }
      }

      if (flag && stack.isEmpty()) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {

    String s = "[](){}";

    System.out.println(solution(s));

  }

}
