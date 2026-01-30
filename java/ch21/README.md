# Ch21: 제네릭(Generics 1)

## 제네릭의 개념
- 제네릭은 `일반화`를 의미하며, 대상은 `자료형`
- 자료형에 의존하지 않는 클래스를 정의하기 위함
- 예시: `Box<T>`
  - 타입 매개변수(Type Parameter): T
  - 매개변수화 타입(제네릭 타입): Box<Apple>
  - 타입 인자(Type Argument): Apple

---

## 다중 매개변수 기반 제네릭 클래스
- 둘 이상의 타입 매개변수 사용 가능
- 형식: `<A, B>`

---

## 타입 매개변수의 이름 규칙
- 한 문자 사용
- 대문자 사용
- 관례적으로 사용되는 이름
  - E : Element
  - K : Key
  - N : Number
  - T : Type
  - V : Value

---

## 기본 자료형 사용 제한
- 제네릭 타입 인자로 `기본 자료형은 사용 불가`
  - Box<int> → 컴파일 오류
- 기본 자료형에 대응되는 래퍼 클래스 사용
  - Box<Integer> → 가능

---

## 타입 인자 생략 (다이아몬드 연산자)
- Java 7부터 지원
- 생성자 호출 시 타입 인자 생략 가능
  - Box<Apple> aBox = new Box<Apple>();
  - Box<Apple> aBox = new Box<>();

---

## 제네릭 타입을 타입 인자로 전달
- 매개변수화 타입 또한 타입 인자로 사용 가능

### 예시
```
  class Box<T> {
      private T ob;

      public void set(T o) {
          ob = o;
      }
      public T get() {
          return ob;
      }
  }

  class BoxInBox {
      public static void main(String[] args) {
          Box<String> sBox = new Box<>();
          sBox.set("I am so happy.");

          Box<Box<String>> wBox = new Box<>();
          wBox.set(sBox);

          Box<Box<Box<String>>> zBox = new Box<>();
          zBox.set(wBox);

          System.out.println(zBox.get().get().get());
      }
  }
```
---

## 제네릭 클래스의 타입 인자 제한
- extends 키워드 사용
- 특정 클래스의 하위 타입만 허용

- Number를 상속하는 타입만 허용
  - class Box<T extends Number>

- 제한 시, 상위 클래스의 메소드 사용 가능

### 예시
```
  class Box<T extends Number> {
      private T ob;

      public int toIntValue() {
          return ob.intValue();
      }
  }
```
---

## 인터페이스로 타입 인자 제한
- 클래스 제한과 동일하게 extends 사용
- 인터페이스의 메소드 호출 가능
- 해당 인터페이스를 구현한 클래스만 타입 인자로 허용

### 예시
```
  interface Eatable {
      String eat();
  }

  class Apple implements Eatable {
      public String toString() {
          return "I am an apple.";
      }

      @Override
      public String eat() {
          return "It tastes so good!";
      }
  }

  class Box<T extends Eatable> {
      private T ob;

      public void set(T o) {
          ob = o;
      }
      public T get() {
          System.out.println(ob.eat());
          return ob;
      }
  }

  class BoundedInterfaceBox {
      public static void main(String[] args) {
          Box<Apple> box = new Box<>();
          box.set(new Apple());

          Apple ap = box.get();
          System.out.println(ap);
      }
  }
```
---

## 클래스 + 인터페이스 동시 제한
- 하나의 클래스 + 하나 이상의 인터페이스 가능
- 형식:
  - `class Box<T extends Number & Eatable>`

---

## 제네릭 메소드
- 클래스 전체가 아닌 `일부 메소드만 제네릭으로 정의`
- 인스턴스 메소드, static 메소드 모두 가능
- 제네릭 클래스: 인스턴스 생성 시 타입 결정
- 제네릭 메소드: `메소드 호출 시 타입 결정`

### 예시
```
  class BoxFactory {
      public static <T> Box<T> makeBox(T o) {
          Box<T> box = new Box<>();
          box.set(o);
          return box;
      }
  }

  Box<String> sBox = BoxFactory.makeBox("Sweet");
  Box<Double> dBox = BoxFactory.makeBox(7.59);
```
---

## 제네릭 메소드의 타입 인자 제한
- 제네릭 메소드에서도 타입 인자 제한 가능

### 예시
```
  public static <T extends Number> Box<T> makeBox(T o) {
      Box<T> box = new Box<>();
      box.set(o);
      System.out.println(box.get().intValue());
      return box;
  }
```
- 타입 인자를 Number를 상속하는 클래스로 제한
