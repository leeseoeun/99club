package club.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10816
public class Day14_숫자_카드_2 {

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder(); // 시간 초과 방지

    // 상근이 숫자 카드
    int number = Integer.parseInt(br.readLine());
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    for (int i = 0; i < number; i++) {
      int num = Integer.parseInt(st.nextToken());
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    // 숫자 카드
    number = Integer.parseInt(br.readLine());

    str = br.readLine();
    st = new StringTokenizer(str);
    for (int i = 0; i < number; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (hm.get(num) != null) {
        sb.append(hm.get(num)).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }

    System.out.println(sb.toString());

  }

}
