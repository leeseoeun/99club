package club.beginner;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class Day1_자연수_뒤집어_배열로_만들기 {

  public static int[] solution(long n) {
    String str = ("" + n);
    String[] strArr = str.split("");

    int[] answer = new int[strArr.length];

    for (int i = strArr.length - 1; i >= 0 ; i--) {
      answer[strArr.length - i - 1] = Integer.parseInt(strArr[i]);
    }

    /*
     * String str = Long.toString(n);
     * StringBuilder sb = new StringBuilder(str);
     * String[] strArr = sb.reverse().toString().split("");
     * 
     * int[] answer = new int[strArr.length];
     * for (int i= 0; i< strArr.length; i++){
     *  answer[i] = Integer.parseInt(strArr[i]);
     * }
     * */

    return answer;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();

    System.out.println(solution(n));

  }

}
