package club.middler;

import java.util.Arrays;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Day5_전화번호_목록 {

  public static boolean solution(String[] phone_book) {
    boolean answer = true;

    Arrays.sort(phone_book);
    for (int i = 1; i < phone_book.length; i++) {
      if (phone_book[i - 1].indexOf(phone_book[i]) == 0 || phone_book[i].indexOf(phone_book[i - 1]) == 0) {
        answer = false;
      }
    }

    //    for (int i = 0; i < phone_book.length; i++) {
    //      for (int j = 0; j < phone_book.length; j++) {
    //        if (i != j) {
    //          if (phone_book[i].indexOf(phone_book[j]) == 0) {
    //            answer = false;
    //          }
    //        }
    //      }
    //    }

    /*
     * for(int i=0; i<phoneBook.length-1; i++) {
     *  for(int j=i+1; j<phoneBook.length; j++) {
     *      if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
     *      if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
     *  }
     * }
     * return true;
     * */

    return answer;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();
    String str3 = sc.next();
    String[] phone_book = {str1, str2, str3};

    System.out.println(solution(phone_book));

  }

}
