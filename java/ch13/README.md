# Ch13: 배열

## 배열의 기본
- 같은 타입의 둘 이상의 데이터를 저장할 수 있는 1차원 메모리 구조
- 배열은 인스턴스이다.
### 예시
  - `int[] ref = new int[5];`
    - `int[] ref` : int형 1차원 배열 인스턴스를 참조할 수 있는 참조 변수 선언
    - `new int[5]` : int형 값 5개를 저장할 수 있는 배열 인스턴스 생성
- 인스턴스를 담을 수 있는 배열도 생성 가능

---

## 배열 초기화
- 배열 생성과 동시에 초기화
  - `int[] ref = new int[3] {1,2,3};` → 컴파일 오류
  - `int[] ref = new int[] {1,2,3};`
  - `int[] ref = {1,2,3};`
  - `int ref[] = {1,2,3};` (참조 변수 위치 변경 가능, 그러나 첫 번째 방식 권장)

---

## 메소드와 배열
- 자바는 `call-by-value`
  - 기본형: 값 자체가 전달됨
  - 참조형: 주소값(참조값)이 복사되어 전달됨
- 함수 인자로 넘길 때
  - 예시: `void method(int[] ary)`
- 반환값으로 배열 반환 가능
  - 예시: `int[] makeNewIntAry(int len)`

---

## 배열 초기값
- 배열 생성 시 모든 요소는 0 또는 null 로 초기화
  - `int[] ar = new int[10];` → 0으로 초기화
  - `String[] ar = new String[10];` → null로 초기화
- `Arrays.fill()` 메소드 (java.util.Arrays 클래스)
  - `fill(int[] a, int val)`
  - `fill(int[] a, int fromIndex, int toIndex, int val)`
- 배열 복사: `System.arraycopy()` (java.lang.System 클래스)
  - `arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`
  - 독립된 배열 생성 가능
  - 단순히 행 교체 시 `arr[0] = arr[1]` 형태로 주소값 복사도 가능

---

## main 메소드와 매개변수
- `public static void main(String[] args)`
- 클래스 이름이 Simple 일 때:
  - `java Simple abc def ghi` 실행 시
  - `String[] args = {"abc","def","ghi"}` 가 생성되고 main 메소드 호출

---

## Enhanced for문 (for-each)
- 자바 5부터 추가
- 배열 길이를 직접 확인하지 않아도 됨
- 코드가 간결해진다
- 구문: for(요소 : 배열) { 반복문 내용 }
- 인스턴스 배열에도 동일하게 적용 가능

---

## 다차원 배열
- 선언: `int[][] arr = new int[3][4];`
### 초기화 예시
```
int[][] arr = {
    {11},
    {22, 33},
    {44, 55, 66}
};
```
- [3][3] 크기로 초기화되는 것이 아니라, 각각의 행 길이가 다른 배열로 초기화됨
