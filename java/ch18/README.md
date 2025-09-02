# Ch18: 예외처리

## try ~ catch 문
- try 영역에서 발생한 예외 상황을 catch 영역에서 처리
- 예외 발생 시 가상머신은 예외 클래스의 인스턴스를 생성
  - 예외 클래스: 상황별 오류를 표현하기 위한 클래스
- catch 문은 해당 인스턴스를 인자로 받을 수 있는지 확인 후 처리
- catch 문은 여러 개 작성 가능
  - 자바 7부터 하나의 catch 문에서 둘 이상의 예외 처리 가능
  - 예: `catch(ArithmeticException | InputMismatchException e)`

---

## Throwable 클래스
- 모든 예외 클래스의 최상위 클래스
- 주요 메소드
  - `getMessage()` : 예외 원인을 문자열로 반환
  - `printStackTrace()` : 예외 발생 위치와 메소드 호출 정보를 출력
- 예외처리를 하지 않으면 상위 메소드로 책임이 넘어감
- main 까지 예외처리를 하지 않으면 JVM이 대신 처리
- 실제 예외는 Throwable 이 아니지만 상속 관계 덕분에 Throwable 로 처리 가능
- JVM 또한 예외 처리 시 printStackTrace 메소드 호출

---

## 예외 클래스의 구분
1. Error 계열 (Error 상속)
   - VirtualMachineError: JVM에 심각한 오류 발생
   - IOError: 입출력 관련 복구 불가능 오류
   - 코드 수준 복구 불가
2. Exception 계열 (Exception 상속)
   - 반드시 try-catch 처리하거나 throws 선언 필요
   - 두 가지 처리 방법
     1. try-catch 문
     2. throws 선언: 메소드 옆에 `throws IOException` 등 명시
        - 호출한 메소드로 예외를 전달
        - main 까지 전달되면 JVM으로 예외 전파
        - 여러 예외를 동시에 throws 가능
   - 예: IOException
3. RuntimeException 계열
   - Exception 상속, 단 예외 처리는 선택 사항
   - 주요 클래스
     - `ArithmeticException` : 수학 연산 오류
     - `ClassCastException` : 허용 불가 형변환
     - `IndexOutOfBoundsException` : 잘못된 인덱스 접근
     - `InputMismatchException` : Scanner 입력 형식 오류
     - `NullPointerException` : null 참조에 대한 메소드 호출
     - `ArrayIndexOutOfBoundsException` : 배열 인덱스 오류
     - `NegativeArraySizeException` : 음수 길이 배열 생성
     - `ArrayStoreException` : 부적절한 인스턴스를 배열에 저장

---

## 프로그래머 정의 예외
- Exception 을 상속하여 정의
- 문법적 오류는 아니지만 프로그래머가 의도적으로 예외를 발생시킬 때 사용

### 예시
```
class ReadAgeException extends Exception {
    public ReadAgeException() {
        super("유효하지 않습니다.");
    }
}

public static int readAge() throws ReadAgeException {
    Scanner kb = new Scanner(System.in);
    int age = kb.nextInt();
    if(age < 0)
        throw new ReadAgeException(); // 예외 발생
    return age;
}

public static void main(String[] args) {
    try {
        int age = readAge();
    }
    catch(ReadAgeException e) {
        System.out.println(e.getMessage());
    }
}
```
---

## 잘못된 catch 구문 구성
- 상위 예외 클래스가 앞에 오면 하위 예외 클래스는 도달 불가 → 컴파일 오류

### 잘못된 예시:
```
catch(FirstException e) { ... }
catch(SecondException e) { ... }
catch(ThirdException e) { ... }
```
### 올바른 예시:
```
catch(ThirdException e) { ... }
catch(SecondException e) { ... }
catch(FirstException e) { ... }
```
---

## finally 구문
- try 블록에 진입하면 반드시 실행되는 영역
- 필요 시 finally 안에도 try-catch 중첩 가능

---

## try-with-resources 문 (Java 7~)
- 자원(resource) 자동 해제
- 구조: `try(resource) { ... } catch(...) { ... }`
- try 블록을 벗어날 때 `close()` 자동 실행
- `AutoCloseable` 인터페이스의 `close` 메소드 호출
- 둘 이상의 리소스 관리도 가능 → `try(resource1; resource2)`

### 예시
```
try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\javastudy\\Simple.txt"))) {
    writer.write('A');
    writer.write('Z');
}
catch(IOException e) {
    e.printStackTrace();
}
```
---

## 성능 고려
- 예외 처리는 성능 저하를 유발
- try 블록 안의 코드는 바깥 코드보다 느리게 실행됨
- 과도한 예외 처리는 성능 저하로 이어질 수 있음
- 모든 예외를 세세하게 처리하는 것은 비효율적일 수 있다
