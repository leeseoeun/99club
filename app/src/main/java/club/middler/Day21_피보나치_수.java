package club.middler;

public class Day21_피보나치_수 {

  public static int solution(int n) {    
    int[] fibonacci = new int[n + 1];
    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i < fibonacci.length; i++) {
      fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
    }

    return fibonacci[n] % 1234567;
  }

  public static void main(String[] args) {

    int n = 3;

    System.out.println(solution(n));

  }

}
