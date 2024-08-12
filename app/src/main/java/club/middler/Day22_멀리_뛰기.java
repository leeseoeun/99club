package club.middler;

// https://school.programmers.co.kr/learn/courses/30/lessons/12914
class Day22_멀리_뛰기 {
  public static long[] dp = new long[2001];
  public long solution(int n) {
    long answer = 0;
    answer = fibonacci(n);
    return answer;
  }
  public static long fibonacci(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (dp[n] != 0) {
      return dp[n];
    } else {
      dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567; // 오버플로우 방지
      return dp[n];
    }
  }
  /*
   * n : 1 -> 1
   * n : 2 -> 2
   * n : 3 -> 3
   * n : 4 -> 5
   * n : 5 -> 8
   * n : 6 -> 13
   * n : 7 -> 21
   */
}