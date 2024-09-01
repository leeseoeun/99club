package club.middler;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class Day33_리코쳇_로봇 {

  private static String[][] arr;
  private static boolean[][] visited;

  public static int solution(String[] board) {
    int answer = 0;

    int row = board.length;
    int col = board[0].split("").length;
    arr = new String[row][col];

    int startRow = 0;
    int startCol = 0;
    for (int i = 0; i < row; i++) {
      String[] tempArr = board[i].split("");
      for (int j = 0; j < col; j++) {
        if (tempArr[j].equals("R")) {
          startRow = i;
          startCol = j;
        }

        arr[i][j] = tempArr[j];
      }
    }

    visited = new boolean[row][col];

    search(startRow, startCol, answer);
    search(startRow + 1, startCol, answer);
    search(startRow - 1, startCol, answer);
    search(startRow, startCol + 1, answer);
    search(startRow, startCol - 1, answer);

    return answer;
  }

  private static void search(int row, int col, int answer) {
    if (row < 0 || col < 0 || row > arr.length - 1 || col > arr[row].length - 1 ||
        arr[row][col].equals("D")) {
      answer++;

      return;
    }
  }

  public static void main(String[] args) {

    String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

    System.out.println(solution(board));

  }

}
