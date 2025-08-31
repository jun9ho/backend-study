# Ch10: 클래스 변수와 클래스 메소드

## 클래스 변수
- 클래스 내에 선언된 변수 앞에 `static` 을 붙이면 인스턴스 변수가 아닌 **클래스 변수**가 된다.
- 클래스 변수 = 모든 인스턴스가 공유하는 변수 (전역 변수)
- 접근 방법
  - 클래스 내부: 변수 이름으로 직접 접근
  - 클래스 외부: 클래스 이름 또는 인스턴스 이름으로 접근
- 클래스 변수는 **인스턴스 생성 이전**에 메모리 공간에 존재

---

## 클래스 로딩
- 클래스 정보는 자바 가상머신(JVM)이 읽는다.
- 특정 클래스의 인스턴스를 생성하려면, 해당 클래스가 반드시 JVM에 의해 로딩되어야 한다.
- 따라서 인스턴스 생성보다 클래스 로딩이 먼저 이루어진다.
- `static final` 은 경우에 따라 `public` 선언이 허용된다.

---

## 클래스 메소드
- 클래스 메소드 역시 클래스 변수와 동일한 특성을 가진다.
- 클래스 메소드로 정의하는 것이 적절한 경우
  - 객체를 생성하지 않고도 기능을 외부에 제공해야 하는 경우
  - 인스턴스 변수 값을 참조하거나 수정하지 않는 경우
- 특징
  - 클래스 메소드는 인스턴스 변수에 접근 불가
  - 클래스 메소드는 인스턴스 메소드 호출 불가
  - 클래스 메소드는 같은 클래스에 정의된 클래스 메소드와 클래스 변수에는 접근 가능

---

## System.out.println()
- `System` : 클래스 이름
- `out` : 클래스 변수 (static 변수)
- `println` : 클래스 메소드
- 실제 구조
  - `java.lang.System.out.println()`
  - `import java.lang.*` 구문은 컴파일러가 자동으로 삽입
  - `System` 클래스의 static 변수 `out` 이 참조하는 인스턴스의 `println` 메소드를 호출하는 문장

---

## main 메소드
- `public static void main(String[] args)`
  - main 메소드 호출은 클래스 외부에서 이루어지므로 `public` 선언
  - main 메소드는 인스턴스 생성 이전에 호출되므로 `static` 선언
- main 메소드는 사실 어느 클래스에 두어도 무방
  - 실행 시 해당 클래스가 실행의 시작점이 된다.
  - 일반적으로 main 전용 클래스를 따로 선언하는 방식이 권장된다.

---

## static 초기화 블록
- static 변수(클래스 변수)를 선언과 동시에 초기화할 때 사용

### 예시

```
import java.time.LocalDate;

class DateOfExecution {
    static String date;

    static {
        LocalDate nDate = LocalDate.now();
        date = nDate.toString();
    }

    public static void main(String[] args) {
        System.out.println(date);
    }
}
```
---

## static import 선언
- 특정 클래스의 static 멤버를 직접 호출할 수 있도록 해준다.
- 하지만 최소한으로, 적절하게 사용하는 것이 바람직하다 (구분이 어려워질 수 있음)

### 예시

```
import static java.lang.Math.*;

System.out.println(PI);   // Math.PI 를 생략 가능
```
