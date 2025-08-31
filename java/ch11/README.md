# Ch11: 메소드 오버로딩과 String 클래스

## 메소드 오버로딩
- 매개변수 선언이 다르면 동일한 이름의 메소드 정의 가능
- 매개변수의 수가 다르거나, 수가 같아도 자료형이 다르면 된다
- 단, 반환형만 다르게 정의하는 것은 불가능

### 예외 케이스
```
void simple(int p1, int p2)  
void simple(int p1, double p2)  

inst.simple(7, 'k')  
```
- 형 변환 규칙상 가장 가까운 자료형으로 자동 변환된다.  
- 하지만 전달인자와 매개변수의 자료형을 일치시키는 것이 권장된다.

### 생성자 오버로딩
- 생성자도 오버로딩이 가능하다.

### this 키워드
1. 다른 생성자를 호출할 때 사용
```
Person(int rnum, int pnum) {  
    regiNum = rnum;  
    passNum = pnum;  
}  

Person(int rnum) {  
    this(rnum, 0); // 위의 생성자 호출  
}  
```
2. 인스턴스 변수와 매개변수 이름이 동일할 경우 구분용으로 사용  
   `this.data = data;`

---

## String 클래스
- 선언 방법  
1. `String str1 = new String("...")`  
2. `String str2 = "..."  `

- `println` 은 다양한 인자 타입에 대해 오버로딩되어 있다.  
- 문자열 리터럴만으로도 `String` 인스턴스가 자동으로 생성된다.  

### String 의 특징
- `String` 인스턴스는 Immutable (불변)  
- `==` 연산자는 같은 객체인지 여부 판단  
- 내용 비교는 `equals()` 사용
### 예시
```
  - String str1 = "Simple";  
  - String str2 = "Simple"; → 같은 객체  
  - String str3 = new String("Simple");  
  - String str4 = new String("Simple"); → 서로 다른 객체  
```
---

## 주요 메소드

### concat
- 문자열을 이어붙임
- `str1.concat(str2)`
- 체이닝 가능: `str1.concat(str2).concat(str3)`
- 하지만 성능에 비효율적 (인스턴스가 계속 생성됨)

### substring
- `substring(int beginIndex)` → beginIndex ~ 끝까지
- `substring(int beginIndex, int endIndex)` → beginIndex ~ (endIndex-1)

### compare
- `compareTo(String anotherString)`
  - 반환형: `int`
  - 일치 → 0, 사전순으로 앞 → 음수, 뒤 → 양수
  - 대문자는 소문자보다 앞에 위치
- `compareToIgnoreCase(String anotherString)`
  - 대소문자 구분 없이 비교
- `equals(Object anObject)`
  - 내용이 같으면 `true`, 다르면 `false` 반환

### valueOf
- 기본 자료형 → 문자열 변환
- `valueOf(Object obj)`  
- `valueOf(char[] data, int offset, int count)` → 배열 일부를 문자열로 반환

---

## 문자열 연산자
- `+`, `+=` 연산은 내부적으로 concat 으로 변환됨
- 어디서든 사용 가능
- 예시:  
  - `str = "age: "` + 17; → 정상  
  - `str = "age: ".concat(17);` → 오류 (String 인자만 허용)  
  - `str = "age: ".concat(String.valueOf(17)`); → 정상  

---

## StringBuilder 클래스
- 문자열을 저장할 메모리 공간을 내부적으로 관리
- 수정 가능한(mutable) 문자열 클래스
- 주요 메소드
  - `append(object)`
  - `delete(int start, int end)`
  - `insert(int offset, String str)`
  - `replace(int start, int end, String str)`
  - `reverse()`
  - `toString()`
- 생성자
  - `StringBuilder()` : 기본 16문자 크기의 공간 확보
  - `StringBuilder(int capacity)` : capacity 크기 지정
  - `StringBuilder(String str)` : str + 16 문자 공간 확보
### 예시  
  - `StringBuilder sb = new StringBuilder(64)`

### String vs StringBuilder
- `String` : Immutable (불변)  
- `StringBuilder` : Mutable (가변)  
- 성능 차이: 문자열 연산이 많을 경우 `StringBuilder` 권장  
- 단, `StringBuilder` 는 스레드 안전하지 않음  
- 멀티스레드 환경에서는 `StringBuffer` 사용 (Thread-safe)

---

## 컴파일러 최적화
- 문자열 덧셈 연산은 컴파일러가 `StringBuilder` 로 변환
### 예시
```
  String birth = "<양>" + 7 + '.' + 16;  
  -> (new StringBuilder("<양>")).append(7).append('.').append(16).toString();
```
---

## 정리
- `String` 은 불변, 연산 시 새로운 객체가 생성됨  
- `StringBuilder` / `StringBuffer` 는 가변, 문자열 처리 성능에 강점  
- 멀티스레드 → `StringBuffer`, 단일스레드 → `StringBuilder`
