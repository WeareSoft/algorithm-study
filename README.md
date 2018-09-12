# algorithm-study

## Development environment
* Programming Language
    * Java
* IDE
    * IntelliJ
* Algorithm Site
    * Baekjoon Online Judge: [https://www.acmicpc.net/](https://www.acmicpc.net/)
    

## Study Rule
* Github를 통한 코드 공유 및 피드백
    * [Feature Branch Workflow](https://gmlwjd9405.github.io/2017/10/27/how-to-collaborate-on-GitHub-1.html) 방식을 이용한다
* 개인이 할 일
    * 이론 정리
        * 각자가 해당 범위에 대한 알고리즘 이론 내용을 간단히 정리한다.
    * 문제 풀이
        * 각자가 해당 범위에 대한 알고리즘 문제를 푼다.
        * 문제를 풀 때 발생한 **[issue]** 를 Readme에 기록한다.
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
        * 문제를 풀 때 발생한 **[issue]** 에 대해 논의하여 Readme에 정리한다.
    * 좋은 코드에 대한 분석 공유

---

## 2018.05.13
### 코드 공유를 위한 Github 환경설정 
* A+B 출력 문제를 통한 환경설정 Test 
    * [https://www.acmicpc.net/problem/1000](https://www.acmicpc.net/problem/1000)

## 2018.05.20
### 정렬
:heavy_check_mark: [issue 정리 내용](/contents/180520.md)
* [#issue1] Comparable, Comparator 을 이용한 Java 객체 정렬
* [#issue1-1] Comparable, Comparator 사용 예제
* [#issue2] Java 언어를 이용하여 정렬할 때 시간초과 문제
* [#issue3] List와 ArrayList의 차이
* [#issue3-1] 업캐스팅, 다운캐스팅이란
* [#issue4] Arrays.sort()와 Collections.sort()의 차이
* [#issue5] BufferedReader/BufferedWriter, InputStreamReader/OutputStreamWriter의 차이
* [#issue6] String, StringBuilder, StringBuffer의 차이
* [#issue7] counting sort(계수정렬)의 개념 및 시간복잡도
* [#issue8] Java Collections Framework
* [#issue8-1] java Map 인터페이스 구현체의 종류
* [#issue8-2] java Set 인터페이스 구현체의 종류
* [#issue8-3] java List 인터페이스 구현체의 종류
* [#issue9] java 자료형의 범위 (ex. Integer, Long, BigInteger, BigDecimal)
* [#issue9-1] 입력값 조건에 따른 java 자료형 선택 방법
* [#issue10] 문자열 분리를 위한 StringTokenizer와 String.spilt의 차이
* [#issue10-1] 문자열 분리를 위한 StringTokenizer와 String.spilt의 사용 예제
* [#issue11] BufferedReader/Scanner, Arrays.sort()/Collections.sort()에 따른 시간복잡도 분석

## 2018.05.27
### 수학1-1(나머지, 최대공약수, 최소공배수, GCD의 합, 진법)
:heavy_check_mark: [issue 정리 내용](/contents/180527.md)
* [#issue1] 최대공약수(GCD)를 구하는 방법 '유클리드 호제법'의 개념
* [#issue1-1] 최대공약수를 이용하여 최소공배수(LCM)를 구하는 방법 
* [#issue2] 기본적인 아스키코드
* [#issue3] 10진수 <-> 2진수, 8진수, 16진수 변환 시 Integer API 사용

## 2018.06.03
### 수학1-2(소수, 소인수분해, 팩토리얼)
:heavy_check_mark: [issue 정리 내용](/contents/180603.md)
* [#issue1] 1~N 까지의 수에서 모든 소수를 구하는 방법 '에라토스테네스의 체'의 개념 
* [#issue2] 소인수분해의 개념과 간단한 풀이법

## 2018.06.10
### 수학2-1(제곱, 행렬, 피보나치의 수, 이항계수, 파스칼의 삼각형)
:heavy_check_mark: [issue 정리 내용](/contents/180610.md)
* [#issue1] 분할정복을 이용하여 제곱을 구하는 방법 
* [#issue2] 이진수의 원리를 이용하여 제곱을 구하는 방법
* [#issue3] 행렬의 곱 구하기
* [#issue4] 피사노 주기의 개념과 구하는 방법
* [#issue5] 음수 번째의 피보나치의 수에 대한 규칙성
* [#issue6] 이항계수 구하는 방법

## 2018.06.17
### 수학2-2(카탈란 수, 오일러 피 함수, 유클리드 알고리즘, 나머지 연산, 순열)
:heavy_check_mark: [issue 정리 내용](/contents/180617.md)
* [#issue1] 카탈란 수의 개념과 적용 사례
* [#issue1-1] 카탈란 수 구하는 방법
* [#issue2] 오일러 피 함수의 개념과 활용
* [#issue2-1] 오일러 피 함수 구하는 방법
* [#issue3] 사전순으로 다음에 오는 순열

## 2018.06.24
### 자료구조1(스택, 큐, 덱, 문자열)
:heavy_check_mark: [issue 정리 내용](/contents/180624.md)
* [#issue1] 스택(Stack)의 개념
* [#issue1-1] 스택(Stack) 관련 메서드
* [#issue2] 큐(Queue)의 개념
* [#issue2-1] 큐(Queue) 관련 메서드
* [#issue3] 덱(Deque, Double-ended Queue)의 개념
* [#issue3-1] 덱(Deque, Double-ended Queue) 관련 메서드
* [#issue4] String indexOf()의 사용법
* [#issue5] String substring()의 사용법

## 2018.07.01
### 자료구조2(스택, Disjoint-set, 비트마스크, 힙, 이진 탐색 트리)
:heavy_check_mark: [issue 정리 내용](/contents/180701.md)
* [#issue1] Disjoint-set(서로소 집합 자료구조)의 개념과 사용 예제
* [#issue1-1] Disjoint-set 구현 방법
* [#issue2] 비트마스크의 개념과 사용 이유
* [#issue2-1] 비트연산의 종류와 사용법
* [#issue3] 이진 트리의 개념과 종류
* [#issue3-1] 이진 트리와 관련된 용어들
* [#issue4] 최대힙의 삽입과 삭제
* [#issue5] 이진 탐색 트리의 개념 


## 2018.07.08
### 트리와 이진 탐색
:heavy_check_mark: [issue 정리 내용](/contents/180708.md)
* [#issue1] 트리의 개념과 적용 사례
* [#issue1-1] 트리의 지름 개념과 구하는 방법 
* [#issue1-2] 트리와 그래프의 차이점
* [#issue1-3] 이진 트리의 순회(전위, 중위, 후위 순회)
* [#issue2] 이진 탐색의 개념


## 2018.07.15
### 그래프1(그래프, DFS, BFS, 이분그래프, 사이클, 플러드 필)
:heavy_check_mark: [issue 정리 내용](/contents/180715.md)
* [#issue1] 그래프의 개념과 적용 사례
* [#issue2] 트리나 그래프를 방문 또는 탐색하는 방법 1: BFS(너비 우선 탐색) 
* [#issue3] 트리나 그래프를 방문 또는 탐색하는 방법 2: DFS(깊이 우선 탐색)
* [#issue4] 이분 그래프의 개념
* [#issue4-1] 이분 그래프인지 확인하는 방법
* [#issue5] 사이클의 개념
* [#issue6] 플러드 필(Flood Fill) 알고리즘의 개념

## 2018.08.26
### 그래프2(DAG(Directed Acyclic Graph), 위상 정렬, 최소 비용 신장 트리(Minimum Spanning Tree), Prim, Kruskal, 최단 경로(Shortest Path), Bellman-Ford)
:heavy_check_mark: [issue 정리 내용](/contents/180826.md)
* [#issue1] DAG(Directed Acyclic Graph)의 개념
* [#issue2] 위상 정렬(Topological Sort)
* [#issue3] 최소 비용 신장 트리(MST, Minimum Spanning Tree)
* [#issue3-1] Prim MST 알고리즘
* [#issue3-2] Kruskal MST 알고리즘
* [#issue4] 최단 경로(Shortest Path)
* [#issue4-1] Bellman-Ford 알고리즘

## 2018.09.02
### 그래프2(다익스트라(Dijkstra), 플로이드(Floyd-Warshall), SPFA(Shortest Path Faster))
:heavy_check_mark: [issue 정리 내용](/contents/180902.md)
* [#issue1] 

## 2018.09.16
### 삼성 SW 역량 테스트 기출 문제 (1)
:heavy_check_mark: [issue 정리 내용](/contents/180916.md)
* [#issue1] 치킨 배달
* [#issue2] 드래곤 커브
* [#issue3] 사다리 조작
* [#issue4] 감시


## 2018.09.23
### 삼성 SW 역량 테스트 기출 문제 (2)
:heavy_check_mark: [issue 정리 내용](/contents/180923.md)
* [#issue1] 톱니바퀴
* [#issue2] 경사로
* [#issue3] 스타트와 링크
* [#issue4] 연산자 끼워넣기
* [#issue5] 로봇 청소기
* [#issue6] 연구소


## 2018.09.30
### 삼성 SW 역량 테스트 기출 문제 (3)
:heavy_check_mark: [issue 정리 내용](/contents/180930.md)
* [#issue1] 퇴사
* [#issue2] 테트로미노
* [#issue3] 주사위 굴리기
* [#issue4] 시험 감독
* [#issue5] 뱀
* [#issue6] 구슬 탈출 2
