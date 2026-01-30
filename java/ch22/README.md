# Ch22: 제네릭2(Generics 2)

## 제네릭 클래스의 상속

- 제네릭 클래스도 일반 클래스처럼 상속 가능

### 예시
```
class Box<T> {
    protected T ob;

    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class SteelBox<T> extends Box<T> {
    public SteelBox(T o) {
        ob = o;
    }
}

class GenericInheritance {
    public static void main(String[] args) {
        Box<Integer> iBox = new SteelBox<>(7959);
        Box<String> sBox = new SteelBox<>("Simple");

        System.out.println(iBox.get());
        System.out.println(sBox.get());
    }
}
```
- 위 상속 관계는 다음과 같음
  - `Box<Integer>` ← `SteelBox<Integer>`
  - `Box<String>` ← `SteelBox<String>`

- 하지만 다음 관계는 성립하지 않음
  - `Box<Integer>` ← `SteelBox<String>`
  - `Box<Number>` ← `SteelBox<Integer>`

- 이유
  - 제네릭 타입은 `자료형이 완전히 일치할 때만` 상속 관계를 형성
  - Integer는 Number의 하위 타입이지만
    - Box<Integer> ≠ Box<Number>


## 타겟 타입(Target Type)

```
public static <T> Box<T> makeBox() {
    Box<T> box = new Box<T>();
    return box;
}
```

- 위와 같은 메소드가 있을 때 다음이 가능

```
Box<Integer> iBox = EmptyBoxFactory<Integer>.makeBox();
Box<Integer> iBox = EmptyBoxFactory.makeBox();
```

- 자바 7부터 컴파일러의 `자료형 유추(Type Inference)` 범위가 확장됨
- 좌변의 타입(Box<Integer>)을 보고
  - T가 Integer임을 컴파일러가 유추
- 이를 `타겟 타입 기반 자료형 유추`라고 함


## 와일드 카드(Wildcard)

```
public static <T> void peekBox(Box<T> box) {
    System.out.println(box);
}

public static void peekBox(Box<?> box) {
    System.out.println(box);
}
```

- 위 두 메소드는 기능적으로 완전히 동일
- 하지만
  - Box<?> 방식이 더 간결하고
  - 타입 파라미터 선언이 불필요하므로
- 실무 및 일반적인 코드에서는 **와일드 카드 방식**을 선호


## 와일드 카드의 상한과 하한

### 상한 제한 (Upper Bound)

public static void peekBox(Box<? extends Number> box)

- Number 또는 Number를 상속하는 클래스만 인자로 전달 가능
  - Integer
  - Double
  - Float 등
- 읽기(get)는 가능
- 쓰기(set)는 제한됨

### 하한 제한 (Lower Bound)

public static void peekBox(Box<? super Integer> box)

- Integer 또는 Integer의 상위 클래스만 전달 가능
  - Integer
  - Number
  - Object
- 쓰기(set)는 가능
- 읽기(get)는 Object 타입으로만 가능


## 언제 와일드 카드에 제한을 거는가?

```
public static <T> void copy(
    List<? super T> dest,
    List<? extends T> src
)
```
- 이 메소드는 반드시 이해할 수 있어야 함

- 의미
  - src: 데이터를 꺼내는 쪽 → extends
  - dest: 데이터를 넣는 쪽 → super

- 이유
  - src는 T 또는 T의 하위 타입을 읽기만 하면 되고
  - dest는 T 또는 T의 상위 타입에 값을 넣기만 하면 됨

- 원칙
  - 읽기 전용 → extends
  - 쓰기 전용 → super


## 상한 / 하한 제한의 목적

- 목적
  - `필요한 만큼만 기능을 허용하여 코드의 오류를 컴파일 시점에 최대한 발견`

### Box<? extends Toy>

- box가 참조하는 인스턴스에서
  - 꺼내는 작업(get)만 허용
- 어떤 하위 타입이 들어있는지 알 수 없으므로
  - 넣는 작업(set)은 허용되지 않음

### Box<? super Toy>

- box가 참조하는 인스턴스에
  - Toy 또는 Toy의 하위 객체를 넣는 작업만 허용
- 꺼낼 때는 Object 타입으로만 가능


## 제한된 와일드카드를 사용하는 제네릭 메소드

### 오버로딩 불가

```
public static void outBox(Box<? extends Toy> box) { ... }
public static void outBox(Box<? extends Robot> box) { ... }

public static void outBox(Box<? super Toy> box) { ... }
public static void outBox(Box<? super Robot> box) { ... }
```

- 컴파일러 입장에서
  - 모두 Box<?> 형태로 동일하게 취급됨
- 따라서 오버로딩으로 인정되지 않음

### 오버로딩 가능

```
public static void outBox(Box<? extends Toy> box, Toy n) { ... }
public static void outBox(Box<? extends Robot> box, Robot n) { ... }
```

- 파라미터 개수 또는 타입이 다르므로
- 정상적인 오버로딩으로 인정

### 제네릭 메소드와 와일드 카드

`public static <T> void outBox(Box<? extends T> box)`

- 의미
  - box는 T 또는 T의 하위 타입을 담고 있는 Box
- 호출 시점에 T가 결정되며
- 메소드 내부에서 타입 안정성을 보장 가능


## 제네릭 인터페이스의 정의와 구현
```
interface Getable<T> {
    T get();
}

class Box<T> implements Getable<T> {

    private T ob;

    public void set(T o) {
        ob = o;
    }

    @Override
    public T get() {
        return ob;
    }
}

public static void main(String[] args) {
    Box<Toy> box = new Box<>();
    box.set(new Toy());

    Getable<Toy> gt = box;
}
```
- Getable<T> 타입 참조 변수로
  - Box<T> 인스턴스를 참조 가능
- 단, `T의 자료형은 반드시 일치해야 함`

### implements 시 타입 고정 가능

```
class ToyBox implements Getable<String> {
    @Override
    public Toy get() {
        return new Toy();
    }
}
```

- 이 경우
  - 인터페이스의 T는 String로 고정
- 메소드 구현 시 T가 아닌 String를 명시해야 함
```
Box<Toy> box = new Box<>();
Getable<String> gt = box;
```
- 단 위와 다르게 T의 자료형과 상관없이 참조가능
