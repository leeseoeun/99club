package club.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10815
public class Day13_숫자_카드 {

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 상근이 숫자 카드
    int number = Integer.parseInt(br.readLine());
    int[] sgArr = new int[number];

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    for (int i = 0; i < number; i++) {
      sgArr[i] = Integer.parseInt(st.nextToken());
    }

    // 숫자 카드
    number = Integer.parseInt(br.readLine());
    int[] numberArr = new int[number];

    str = br.readLine();
    st = new StringTokenizer(str);
    for (int i = 0; i < number; i++) {
      numberArr[i] = Integer.parseInt(st.nextToken());
    }

  }

}
