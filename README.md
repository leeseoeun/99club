# 99club

|개념|days|
|-|-|
|배열|01, 02|
|문자열|03, 04|
|해시|05, 06|
|스택/큐|07, 08, 28|
|힙(Heap)|09, 10|
|정렬|11, 12|
|이분탐색|13, 14, 29, 30|
|완전탐색|15, 16, 36, 37|
|깊이/너비 우선 탐색(DFS/BFS)|17, 18, 31, 32, 33, 34, 35|
|탐욕법(Greedy)|19, 20, 23, 38, 39|
|동적계획법|21, 22, 40, 41, 42|
|그래프|24, 25|
|시뮬레이션|26, 27|

<br>

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
