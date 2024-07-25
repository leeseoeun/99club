# 99club

<b>Arrays.sort(배열)</b>
- 배열을 리스트로 변환할 필요 없이 정렬할 수 있음

<b>Arrays.sort(배열, Comparator 구현체)</b>
- Arrays.sort(배열, new Comparator<String>() {}) 형태로 사용
- `Comparator` 인터페이스에는 `compare` 메소드가 존재
- `compare` 메소드
    - |리턴||
        |-|-|
        |1|o1 > o2|
        |0|o1 = o2|
        |-1|o1 < o2|

<b>compareTo</b>
- o1.compareTo(o2) 형태로 사용
- 문자열, 숫자 비교

<b>Character.compare(char, char)</b>
- char 비교
