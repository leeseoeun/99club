package club.middler;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2529
public class Day37_부등호 {

  public static void main(String[] args) {
    //  > < < < > > > < < : > 기준  왼쪽에 최댓값
    // 9 5 6 7 8 4 3 0 1 2
    // answer = "9"
    // answer = "9"

    //  > < < < > > > < < : < 기준  왼쪽에 최솟값
    // 1 0 2 3 7 6 5 4 8 9

    //  < >
    // 8 9 7
    // 0 2 1

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] inequalitySign = new String[n];
    for (int i = 0; i < n; i++) {
      inequalitySign[i] = sc.next();
    }

    int[] maxArr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int[] minArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String answerMax = "";
    // 최댓값 찾기
    int maxIdx = 0;
    for (int i = 0; i < inequalitySign.length; i++) {
      // 부등호가 > 일 때 최댓값 넣기
      if (inequalitySign[i].equals(">")) {
        for (int j = i; j >= maxIdx; j--) {
          answerMax += maxArr[j];    // 9567843
        }
        maxIdx = i + 1; // 5
      }

      if (i == inequalitySign.length - 1) {
        for (int j = i + 1; j >= maxIdx; j--) {
          answerMax += maxArr[j];
        }
      }

      // 부등호가 < 이면 skip
    }

    // 최댓값 찾기
    String answerMin = "";
    int minIdx = 0;
    for (int i = 0; i < inequalitySign.length; i++) {
      // 부등호가 < 일 때 최솟값 넣기
      if (inequalitySign[i].equals("<")) {
        for (int j = i; j >= minIdx; j--) {
          answerMin += minArr[j];    // 
        }
        minIdx = i + 1; // 5

      } 
      if (i == inequalitySign.length - 1) {
        for (int j = i + 1; j >= minIdx; j--) {
          answerMin += minArr[j];
        }
      }

      // 부등호가 < 이면 skip
    }
    System.out.println(answerMax);
    System.out.println(answerMin);

    //    Queue<Integer> maxQueue = new LinkedList<Integer>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
    //    int[] maxAnswer = new int[n + 1];
    //    Arrays.fill(maxAnswer, -1);
    //
    //    // 최댓값 찾기
    //    int maxPreIdx = 0;
    //    boolean maxFlag = false;
    //    for (int i = 0; i < n; i++) {
    //      // 부등호가 > 일 때 최댓값 넣기
    //      if (inequalitySign[i].equals(">")) {
    //        maxAnswer[i] = maxQueue.poll();
    //        maxFlag = true;
    //      }
    //
    //      if (maxFlag) {
    //        for (int j = i - 1; j > maxPreIdx; j--) {
    //          maxAnswer[j] = maxQueue.poll();
    //        }
    //        maxFlag = false;
    //        maxPreIdx = i;
    //      }
    //
    //      // 부등호가 < 이면 skip
    //    }
    //
    //    String maxStr = "";
    //    for (int i = 0; i < maxAnswer.length; i++) {
    //      if (maxAnswer[i] == -1) {
    //        maxAnswer[i] = maxQueue.poll();
    //      }
    //      maxStr += maxAnswer[i];
    //    }
    //    System.out.println(maxStr);

  }

}