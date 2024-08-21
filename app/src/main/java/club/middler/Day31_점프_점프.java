package club.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14248
public class Day31_점프_점프 {

  private static void bfs(int start, int[] arr, boolean[] visited) {
    if (visited[start]) {
      return;
    }

    visited[start] = true;

    int left = start - arr[start];
    if (left >= 0) {
      bfs(left, arr, visited);
    }

    int right = start + arr[start];
    if (right <= arr.length - 1) {
      bfs(right, arr, visited);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    // 점프 할 수 있는 거리
    int[] arr = new int[count];
    String str = br.readLine();
    StringTokenizer st =  new StringTokenizer(str);
    for (int i = 0; i < count; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int start = Integer.parseInt(br.readLine());

    // 방문 돌
    boolean[] visited = new boolean[count];

    bfs(start - 1, arr, visited);

    int answer = 0;
    for (boolean i : visited) {
      if (i) {
        answer++;
      }
    }
    System.out.println(answer);

  }

}
