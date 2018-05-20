# algorithm-study

## Development environment
* Programming Language
    * Java
* IDE
    * IntelliJ
* Algorithm Site
    * Baekjoon Online Judge: [https://www.acmicpc.net/](https://www.acmicpc.net/])
    

## Study Rule
* Github를 통한 코드 공유 및 피드백
    * feature branch workflow 방식을 이용한다
* 개인이 할 일
    * 이론 정리
        * 각자가 해당 범위에 대한 알고리즘 이론 내용을 간단히 정리한다.
    * 문제 풀이
        * 각자가 해당 범위에 대한 알고리즘 문제를 푼다.
        * 문제를 풀 때 발생한 issue는 Readme에 기록한다.
            * issue: 추가로 공부하고 싶은 개념, 어려웠던 부분, 오류가 난 부분 등
            * 해당하는 문제에 대한 링크도 첨부한다.
    * 공유 및 피드백
        1. 각자가 푼 문제에 대한 코드를 feature branch를 따서 github에 push한 후 pull request를 날린다.
        2. 상대방의 코드를 확인한 후 GUI(Github page)를 이용하여 피드백을 적는다.
        3. 피드백을 적은 후 해당하는 feature branch를 merge한다.
    * 회고
        * 새로 업데이트된 코드를 pull받은 후 자신의 코드에 대한 피드백을 확인한다.
        * 각자가 해당 코드의 좋은 예제를 찾아서 분석한다.
        * 피드백과 좋은 예제를 통해 자신의 코드를 수정하여 다시 push한다.
* 스터디 모임에서 할 일
    * 이론 정리 공유
    * 문제 풀이 피드백 확인
        * 문제를 풀 때 발생한 issue에 대해 논의한다.
    * 좋은 코드에 대한 분석 공유

---

## 2018.05.13
### 코드 공유를 위한 Github 환경설정 
* A+B 출력 문제를 통한 환경설정 Test 
    * [https://www.acmicpc.net/problem/1000](https://www.acmicpc.net/problem/1000)

## 2018.05.20

* [#issue1] Java 언어를 이용하여 정렬할 때 시간초과 문제
    * [https://www.acmicpc.net/problem/10989](https://www.acmicpc.net/problem/10989)
    * Scanner 대신에 BufferedReader, BufferedWriter를 사용해야 하는 이유
    * Scanner
        * 사용이 간단. 속도가 느림. Buffer 사이즈: 1024 chars
    * BufferedReader
        * 사용이 조금 복잡. 속도가 비교적 빠름. Buffer 사이즈: 8192 chars
    * 많은 입력이 있다면 성능상 우위에 있는 BufferedReader를 사용한다.
    * 기본적으로는 간단한 Scanner를 사용한다. 
* [#issue2] List와 ArrayList의 차이
    * List: 인터페이스, 다형성을 지원한다.
    * ArrayList: 구현클래스
* [#issue2-1] 업캐스팅, 다운캐스팅이란
    * 업캐스팅
        * 부모 클래스 = 자식 클래스
    * 다운캐스팅
        * 업캐스팅 한 것을 다시 원래의 형으로 변환하는 것
* [#issue3] Arrays.sort()와 Collections.sort()의 차이
    * Arrays.sort()
        * Object Array에서는 TimSort(Merge Sort + Insertion Sort)를 사용
            * Object Array: 새로 정의한 클래스에 대한 배열
        * Primitive Array에서는 Dual Pivot QuickSort(Quick Sort + Insertion Sort)를 사용
            * Primitive Array: 기본 자료형에 대한 배열 
    * Collections.sort()
        * 내부적으로 Arrays.sort()를 사용
* [#issue4] BufferedReader/BufferedWriter, InputStreamReader/OutputStreamWriter의 차이
    * InputStreamReader
        * character(키보드로 입력하는 글자 한 개) 단위로 입력받는다.
    * BufferedReader
        * character가 아닌 줄단위의 문자열을 입력받는다.
        * InputStreamReader에 버퍼링 기능(Buffer 사이즈: 8192 chars)을 추가한 것
        * 속도를 향상시키고 시간의 부하를 줄일 수 있다.
        * 문자(character) 단위로 처리
    * BufferedInputStream
        * 바이트(byte) 단위로 처리
    * bw.flush()의 용도?
        * 버퍼의 모든 내용을 지운다.
* [#issue5] String, StringBuilder, StringBuffer의 차이
    * String
        * 새로운 값을 할당할 때마다 새로 클래스에 대한 객체가 생성된다.
        * String에서 저장되는 문자열은 private final char[]의 형태이기 때문에 String 값은 바꿀수 없다.
            * private: 외부에서 접근 불가
            * final: 초기값 변경 불가
        * String + String + String... 
            * 각각의 String 주솟값이 Stack에 쌓이고, Garbage Collector가 호출되기 전까지 생성된 String 객체들은 Heap에 쌓이기 때문에 메모리 관리에 치명적이다.
        * String을 직접 더하는 것보다는 StringBuffer나 StringBuilder를 사용하는 것이 좋다.
    * StringBuilder, StringBuffer
        * memory에 append하는 방식으로, 클래스에 대한 객체를 직접 생성하지 않는다.
        * StringBuilder
            * 변경가능한 문자열
            * 비동기 처리
        * StringBuffer
            * 변경가능한 문자열
            * 동기 처리
            * multiple thread 환경에서 안전한 클래스(thread safe)
* [#issue6] counting sort(계수정렬)의 개념 및 시간복잡도
    * 원소 간 비교하지 않고 각 원소가 몇 번 등장하는지 개수를 세서 정렬하는 방법 
    * 시간복잡도: O(n), 공간복잡도: O(n) 

> - [http://mygumi.tistory.com/43](http://mygumi.tistory.com/43)
> - [https://stackoverflow.com/questions/3707190/why-does-javas-arrays-sort-method-use-two-different-sorting-algorithms-for-diff](https://stackoverflow.com/questions/3707190/why-does-javas-arrays-sort-method-use-two-different-sorting-algorithms-for-diff)
> - [https://novemberde.github.io/2017/04/15/String_0.html](https://novemberde.github.io/2017/04/15/String_0.html)


## 2018.05.27