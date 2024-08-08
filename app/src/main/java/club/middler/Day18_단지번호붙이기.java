package club.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/2667
public class Day18_단지번호붙이기 {
  public static int[][] visited;
  public static ArrayList<Integer> complexCntArr = new ArrayList<Integer>();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //StringTokenizer st = new StringTokenizer(br.readLine());
    //int n = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(br.readLine());
    int cnt = 0;

    // 이중 배열로 입력받기
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      //st = new StringTokenizer(br.readLine(), "");
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        //arr[i][j] = Integer.parseInt(st.nextToken());
        arr[i][j] = Character.getNumericValue(line.charAt(j));
      }
    }

    visited = new int[n][n];    // 방문 여부 체크

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 1 || arr[i][j] == 0) {
          continue;
        } else {
          cnt++;
          search_bfs(arr, i, j, true);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(cnt);
    sb.append("\n");
    Collections.sort(complexCntArr);
    for (int i = 0; i < cnt; i++) {
      sb.append(complexCntArr.get(i));
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }

  public static void search_bfs(int[][] arr, int col, int row, boolean isStart) {
    if (col < 0 || row < 0 || col >= arr.length || row >= arr.length || arr[col][row] == 0 || visited[col][row] == 1) {
      return;
    } else {
      if (isStart) {  // count : 5
        complexCntArr.add(1);
      } else { // count : 5
        // get last element
        int lasetElementIdx = complexCntArr.size() - 1;
        int lastElement = complexCntArr.get(lasetElementIdx);

        complexCntArr.set(lasetElementIdx, lastElement + 1);
      }
      visited[col][row] = 1;
      search_bfs(arr, col + 1, row, false);
      search_bfs(arr, col - 1, row, false);
      search_bfs(arr, col, row + 1, false);
      search_bfs(arr, col, row - 1, false);
    }

  }
}