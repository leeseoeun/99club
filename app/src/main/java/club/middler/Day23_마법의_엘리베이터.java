package club.middler;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class Day23_마법의_엘리베이터 {

  public static int solution(int storey) {
    int answer = 0;

    while (storey > 0) {
      int current = storey % 10; // 현재 자릿수
      int next = (storey / 10) % 10; // 다음 자릿수

      if (current > 5 || (current == 5 && next >= 5)) {
        answer += (10 - current); // 반올림
        storey += (10 - current); // 올림
      } else {
        answer += current; // 그대로 계산
      }

      storey /= 10;
    }

    return answer;
  }

  public static void main(String[] args) {

    //    int storey = 16;
    int storey = 2554;

    System.out.println(solution(storey));

  }

}
