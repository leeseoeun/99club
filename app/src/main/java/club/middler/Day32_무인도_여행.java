package club.middler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class Day32_무인도_여행 {

  private static int[][] arr;
  private static boolean[][] visited;
  private static List<Integer> foodCntArr = new ArrayList<>();

  public static int[] solution(String[] maps) {
    int[] answer;

    int row = maps.length;
    int col = maps[0].split("").length;
    arr = new int[row][col];

    for (int i = 0; i < row; i++) {
      String[] tempArr = maps[i].split("");
      for (int j = 0; j < col; j++) {
        arr[i][j] = tempArr[j].equals("X") ? 0 : Integer.parseInt(tempArr[j]);
      }
    }

    visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] != 0 || !visited[i][j]) {
          search(i, j, true);
        }
      }
    }

    if (foodCntArr.size() == 0) {
      return new int[] {-1};
    }

    Collections.sort(foodCntArr);
    answer = new int[foodCntArr.size()];
    for (int i = 0; i < foodCntArr.size(); i++) {
      answer[i] = foodCntArr.get(i);
    }

    return answer;
  }

  private static void search(int row, int col, boolean isStart) {
    if (row < 0 || col < 0 || row > arr.length - 1 || col > arr[row].length - 1 ||
        arr[row][col] == 0 || visited[row][col]) {
      return;
    }

    if (isStart) {
      foodCntArr.add(arr[row][col]);
    } else {
      int lasetElementIdx = foodCntArr.size() - 1;
      int lastElement = foodCntArr.get(lasetElementIdx);

      foodCntArr.set(lasetElementIdx, lastElement + arr[row][col]);
    }

    visited[row][col] = true;

    search(row + 1, col, false);
    search(row - 1, col, false);
    search(row, col + 1, false);
    search(row, col - 1, false);
  }

  public static void main(String[] args) {

    String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

    System.out.println(solution(maps));

  }

}
