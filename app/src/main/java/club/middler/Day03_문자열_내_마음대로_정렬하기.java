package club.middler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class Day03_문자열_내_마음대로_정렬하기 {

  public static String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];

    List<String> strs = Arrays.asList(strings);
    Collections.sort(strs, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        if (o1.charAt(n) > o2.charAt(n)) {
          return 1;

        } else if (o1.charAt(n) == o2.charAt(n)) {
          int flag = 0;

          for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            if (o1.charAt(i) > o2.charAt(i)) {
              flag = 1;
              break;
            } else if (o1.charAt(i) < o2.charAt(i)) {
              flag = -1;
              break;
            }
          }

          return flag;

        } else {
          return -1;
        }
      }
    });

    answer = strs.toArray(new String[strings.length]);

    return answer;

    /*
     * 1
     * ArrayList<String> arr = new ArrayList<>();
     * for (int i = 0; i < strings.length; i++) {
     * // 인덱스 n에 해당하는 문자 + string을 배열에 넣기
     *  arr.add("" + strings[i].charAt(n) + strings[i]);
     * }
     * // 정렬
     * Collections.sort(arr);
     * answer = new String[arr.size()];
     * // 인덱스 n에 해당하는 문자를 제외하고 정렬된 string을 배열에 넣기
     * for (int i = 0; i < arr.size(); i++) {
     *  answer[i] = arr.get(i).substring(1, arr.get(i).length());
     * }
     * */

    /*
     * 2
     * // 문자열 배열을 n번째 문자를 기준으로 정렬
     * Arrays.sort(strings, (s1, s2) -> {
     *  // n번째 문자가 다른 경우 해당 문자를 비교
     *  if (s1.charAt(n) != s2.charAt(n)) {
     *      // n번째 문자를 비교
     *      return Character.compare(s1.charAt(n), s2.charAt(n));
     *  } else {
     *      // n번째 문자가 같으면 전체 문자열을 비교
     *      return s1.compareTo(s2);
     *  }
     *  return strings;
     * */
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //    String str1 = sc.next();
    //    String str2 = sc.next();
    //    String str3 = sc.next();
    //    String[] strings = {str1, str2, str3};
    int n = sc.nextInt();

    //    System.out.println(solution(strings, n));

    String[] tempStrings = {"abce", "abcd", "cdx"};

    System.out.println(solution(tempStrings, n));

  }

}
