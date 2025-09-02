# Ch19: 자바의 메모리 모델과 Object 클래스

## 자바 메모리 모델
- 자바 가상머신(JVM)은 운영체제 위에서 실행되는 하나의 프로그램
- 자바 프로그램은 JVM 위에서 실행됨
- 메인 메모리: 물리적 RAM
  - 프로그램 실행에 필요한 메모리 공간
  - 운영체제가 관리하고 응용 프로그램에 할당
- JVM은 운영체제로부터 할당받은 메모리 공간을 기반으로 실행됨

### 메모리 영역
1. 메소드 영역
   - 메소드의 바이트 코드, static 변수 저장
   - 바이트 코드: JVM이 실행 가능한 코드
   - 클래스가 메모리에 올라갈 때 채워지는 영역
   - 프로그램 종료 시까지 유지
2. 스택 영역
   - 지역 변수, 매개변수 저장
   - 중괄호로 구분된 지역 내에서만 유효
3. 힙 영역
   - 인스턴스 저장
   - 인스턴스는 스택과 별도 관리 (소멸 시점이 다르기 때문)
   - 인스턴스 소멸은 JVM이 관리 → 가비지 컬렉션
   - 참조하지 않는 인스턴스는 GC 대상
   - GC는 즉시 수행되지 않고, 별도의 알고리즘에 따라 실행
   - GC가 자주 실행되면 시스템에 부하 발생

---

## Object 클래스

### `finalize()`
- `protected void finalize() throws Throwable`
- 인스턴스가 GC에 의해 소멸되기 전 자동 호출
- 소멸 시 반드시 실행해야 하는 코드가 있다면 오버라이딩 가능
- `super.finalize()` 호출 → 상위 클래스 `finalize` 실행
- 단, GC 타이밍이 보장되지 않아 호출이 생략될 수 있음
- 관련 메소드
  - `public static void gc()` : GC 수행 요청
  - `public static void runFinalization()` : 보류된 finalize 호출 요청
  - 두 메소드 모두 요청일 뿐, 100% 보장되지 않음

### 예시:
```
@Override  
protected void finalize() throws Throwable {  
    super.finalize();  
    System.out.println("destroyed.");  
}  
```
---

### equals()
- 인스턴스 비교 메소드
- Object 클래스의 equals() → 참조값 비교 (== 과 동일)
- 원하는 비교 방식이 있다면 오버라이딩 필요
- String 클래스의 equals() 는 내용 비교로 이미 오버라이딩 되어 있음
- 즉, equals 를 오버라이딩하지 않은 클래스의 인스턴스 비교는 참조값 비교임

---

### clone()
- 인스턴스 복사
- `protected Object clone() throws CloneNotSupportedException`
- 호출 시 인스턴스 복사본 생성 후 참조값 반환
- 단, `Cloneable` 인터페이스를 구현한 인스턴스만 가능
  - `Cloneable`: 마커 인터페이스 (clone 허용 표식)

### 예시:
```
@Override  
public Object clone() throws CloneNotSupportedException {  
    return super.clone();  
}  
```
- `Cloneable` 미구현 시 `CloneNotSupportedException` 발생
- `clone()` 은 `protected` → 외부에서 사용하려면 `public` 으로 오버라이딩 필요
- 접근 범위는 넓힐 수 있으나 좁힐 수 없음
- 얕은 복사 vs 깊은 복사
  - 기본형과 불변 객체(`String` 등) → 얕은 복사로 충분
  - 다른 인스턴스를 참조하는 경우 깊은 복사 필요

### 예시 (깊은 복사 고려):
```
class Person implements Cloneable {  
    private String name;  
    private int age;  

    @Override  
    public Object clone() throws CloneNotSupportedException {  
        Person cpy = (Person) super.clone();  
        cpy.name = new String(name);  
        return cpy;  
    }  
}  
```
- `String` 은 불변 객체이므로 굳이 깊은 복사 대상이 아님
- Java 5부터 오버라이딩 시 반환형 변경 허용
  - 단, 자기 클래스 타입으로만 변경 가능
  - 예: `Object` → `Person`

---

## 정리
- JVM 메모리: 메소드 영역, 스택, 힙
- 힙 메모리 관리: GC
- Object 클래스 주요 메소드
  - finalize(): 인스턴스 소멸 전 호출
  - equals(): 내용 비교 위해 오버라이딩 필요
  - clone(): 복제, Cloneable 구현 + public 오버라이딩 필수
