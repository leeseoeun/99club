package club.middler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-right-interval/description/
public class Day30_Find_Right_Interval {
  /**
   * Input: intervals = [[3,4],[2,3],[1,2]]
     Output: [-1,0,1]

     Input: intervals = [[1,4],[2,3],[3,4]]
     Output: [-1,2,-1]
   */
  public static int[] findRightInterval(int[][] intervals) {
    int len = intervals.length;
    int[] answer = new int[len];

    Map<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < len; i++) {
      hm.put(intervals[i][0], i);
    }

    /**
     * 💡 Arrays.binarySearch() 함수
       - 매개변수로 주어진 배열에서 원하는 값을 이진 탐색하여 인덱스를 반환합니다.
       만약 해당 원소가 배열에 없다면 음수를 반환합니다.
       이진 탐색을 하기 전에 반드시 배열을 정렬해야 합니다.

       public static int binarySearch(Object[] keySet, Object end)

       int[] numbers = {(-1) 1, (-2) 3, (-3) 5, (-4) 9, (-5) 11, (-6) 15 (-7)}; // len = 6
       int index = Arrays.binarySearch(numbers, 12);
       System.out.println(index);
       // -6
     */

    /**
     * [[3,4],[2,3],[1,2]]
     * [-1,1,2]
     * [-1,0,1]
     */

    List<Integer> keySet = new ArrayList<>(hm.keySet());
    Collections.sort(keySet);
    int[] keySet2 = keySet.stream().mapToInt(i -> i).toArray();
    for (int i = 0; i < len; i++) {
      int idx = Arrays.binarySearch(keySet2, intervals[i][1]);
      if (idx < 0 && (-1 * idx) == len + 1) { // (-1 * idx + 1)
        answer[i] = -1;
      } else if (idx < 0) {
        answer[i] = hm.get(keySet2[(-1 * idx) - 1]);
      } else {
        answer[i] = hm.get(keySet2[idx]);
      }
    }

    return answer;

    /*
     * class Solution {
     *  private List<Integer> keySet;
     *  
     *  public static int[] findRightInterval(int[][] intervals) {
     *      HashMap<Integer, Integer> map = new HashMap<>();
     *      int len = intervals.length;
     *      int[] ans = new int[len];
     *      Arrays.fill(ans, -1);   // 모든 값을 -1로 초기화
     *      
     *      // Key : startJ , Value : intervals의 index
     *      for (int i = 0; i < len; i++) {
     *          map.put(intervals[i][0], i);
     *      }
     *      
     *      // keySet에는 startJ의 값들을 정렬
     *      keySet = new ArrayList<>(map.keySet);
     *      Collections.sort(keySet);
     *      
     *      // 각 intervals의 endI 값에 대해 처리 및 순회
     *      for (int i = 0; i < len; i++) {
     *          int endI = intervals[i][1];
     *          
     *          // endI 값보다 크거나 같은 startJ 값을 가진 keySet에서의 하한값 위치를 찾는다
     *          int pos = findLowerBound(endI, 0, keySet.size() - 1);
     *          
     *          // 찾은 위치가 keySet 범위 내에 있고 그 위치의 값이 endI보다 크거나 같은 경우
     *          // ans 배열에 map에서 해당 시작 값(key)에 대응하는 인덱스(value)를 저장
     *          // 없으면 -1이 그대로 들어가 있따
     *          if (pos < keySet.size() && keySet.get(pos) >= endI) {
     *              ans[i] = map.get(keySet.get(pos);
     *          }
     *      }
     *      
     *      return ans;
     *  }
     *  
     *  // 하한 값을 찾는 이분 탐색 메소드
     *  private int findLowerBound(int num, int start, int end) {
     *      while (start < end) {
     *          int mid = (start + end) / 2;
     *          
     *          if (keySet.get(mid) < num) {
     *              start = mid + 1;
     *          } else {
     *              end = mid;
     *          }
     *      }
     *      
     *      return start;
     *  }
     * */
  }

  public static void main(String[] args) {

    int[][] intervals = {{1,2}};

    System.out.println(findRightInterval(intervals));

  }

}
