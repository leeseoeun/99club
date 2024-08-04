package club.beginner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Day8_올바른_괄호 {

  public static boolean solution(String s) {
    boolean answer = true;

    String[] ss = s.split("");
    Queue<String> queue = new LinkedList<String>();
    for (String str : ss) {
      if (str.equals("(")) {
        queue.offer(s);
      } else if (queue.poll() == null) {
        return false;
      }
    }

    if (!queue.isEmpty()) {
      return false;
    }

    /*
     * boolean answer = false;
     * int count = 0;
     * for(int i = 0; i<s.length();i++){
     *  if(s.charAt(i) == '('){
     *      count++;
     *  }
     *  if(s.charAt(i) == ')'){
     *      count--;
     *  }
     *  if(count < 0){
     *      break;
     *  }
     * }
     * 
     * if(count == 0){
     *  answer = true;
     * }
     * */

    return answer;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    System.out.println(solution(s));

  }

}
