package club.middler;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945
/*
 * 모듈러 연산
 * https://ajar-utensil-d36.notion.site/99-20-TIL-989317edccfa4fefb1a0956cfcaf788f
 */
public class Day21_피보나치_수 {

  public static int solution(int n) {    
    int[] fibonacci = new int[n + 1];
    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i < fibonacci.length; i++) {
      fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % 1234567; // 오버플로우 방지
    }

    return fibonacci[n];
  }

  public static void main(String[] args) {

    int n = 3;

    System.out.println(solution(n));

  }

}
