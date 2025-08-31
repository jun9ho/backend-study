# Ch12: 콘솔 입력과 출력

## System.out.println()
- 참조값이 전달되면 해당 인스턴스를 대상으로 `toString` 메소드를 호출
- `toString` 메소드가 반환하는 문자열을 출력

---

## System.out.printf()
- 서식 지정자를 활용한 출력
  - `%d` : 정수
  - `%f` : 실수
  - `%c` : 문자
  - `%o` : 8진수
  - `%x` : 16진수
  - `%e` : 지수 표기법
  - `%g` : 데이터에 따라 %e 또는 %f 로 출력
  - `%s` : 문자열
- `System.out.format()` 메소드와 기능 동일

---

## Scanner 클래스
- 패키지: `import java.util.Scanner;`
- 생성자에 전달되는 소스로부터 데이터를 추출
  - `Scanner(File source)`
  - `Scanner(String source)`
    - 예: source = "1 3 5"
    - `sc.nextInt()` 호출 시 int 값 순차 추출 가능
  - `Scanner(InputStream source)`

### 키보드 입력 적용
- `Scanner sc = new Scanner(System.in);`

### 입력 메소드
- `nextInt()` : 정수 입력
  - 키보드로 데이터 입력 전까지 대기 상태
  - 입력 후 Enter → 입력 종료 및 데이터 읽음
- `nextByte()`
- `nextLine()`
- `nextDouble()`
- `nextBoolean()`
