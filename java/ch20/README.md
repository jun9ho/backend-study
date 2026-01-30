# Ch20: 자바의 기본 클래스

## Wrapper 클래스
- 기본 자료형(정수, 실수, 문자 등)을 `인스턴스로 감싸는 클래스`
- 종류
  - Boolean
  - Character
  - Byte
  - Short
  - Integer
  - Long
  - Float
  - Double
- 중요 기능
  - `박싱(Boxing)`: 값을 인스턴스로 감쌈
  - `언박싱(Unboxing)`: 인스턴스에서 값을 꺼냄
- 래퍼 인스턴스는 `불변(immutable)` 이라서 값 수정이 불가능 → 새 인스턴스를 생성해야 함  
  ### 예시
  ```
    iObj = new Integer(iObj.intValue() + 10);
    dObj = new Double(dObj.doubleValue() + 1.2);
  ```
---

## 오토 박싱 & 오토 언박싱 (Java 5~)
- 컴파일러가 자동으로 박싱/언박싱을 수행

### 예시
```
  class AutoBoxingUnboxing2 {
      public static void main(String[] args) {
          Integer num = 10; // 오토 박싱

          num++; // 오토 박싱 & 오토 언박싱
          System.out.println(num);

          num += 3; // 오토 박싱 & 오토 언박싱
          System.out.println(num);

          int r = num + 5; // 오토 언박싱
          Integer rObj = num - 5; // 오토 언박싱

          System.out.println(r);
          System.out.println(rObj);
      }
  }
```
---

## Number 클래스
- 모든 숫자 래퍼 클래스는 `java.lang.Number` 를 상속
- Number 클래스는 `추상 클래스`이며, 다음 추상 메소드를 가짐
  - public abstract int intValue()
  - public abstract long longValue()
  - public abstract double doubleValue()
- 따라서 Number를 상속하는 래퍼 클래스들은 위 메소드들을 모두 구현하고 있음

---

## 래퍼 클래스의 static 메소드(대표 예: Integer)
- valueOf(num)
- max(n1, n2)
- min(n1, n2)
- sum(n1, n2)
- toBinaryString(num) : num의 2진 표현
- toOctalString(num)  : num의 8진 표현
- toHexString(num)    : num의 16진 표현

---

## java.math.BigInteger
- long 범위를 넘어서는 `아주 큰 정수`를 다루기 위한 클래스
- 숫자는 문자열로 전달해서 생성한다

### 예시
```
  import java.math.BigInteger;

  class SoBigInteger {
      public static void main(String[] args) {
          System.out.println("최대 정수: " + Long.MAX_VALUE);
          System.out.println("최소 정수: " + Long.MIN_VALUE);
          System.out.println();

          BigInteger big1 = new BigInteger("100000000000000000000");
          BigInteger big2 = new BigInteger("-99999999999999999999");

          BigInteger r1 = big1.add(big2);
          System.out.println("덧셈 결과: " + r1);

          BigInteger r2 = big1.multiply(big2);
          System.out.println("곱셈 결과: " + r2);
          System.out.println();

          int num = r1.intValueExact();
          System.out.println("From BigInteger: " + num);
      }
  }
```
- 참고
  - Long.MAX_VALUE / Long.MIN_VALUE : long 범위의 최대/최소값
  - BigInteger는 사칙연산 메소드 제공
    - add(val), subtract(val), multiply(val), divide(val), remainder(val)
- 정확 변환 메소드
  - longValueExact(): long으로 변환
  - intValueExact(): int로 변환

---

## java.math.BigDecimal
- `오차 없는 실수 표현`을 위한 클래스
- 문자열로 수를 전달하는 것이 권장됨(실수로 전달되는 순간 오차가 생길 수 있음)

### 예시
```
  import java.math.BigDecimal;

  class WowBigDecimal {
      public static void main(String[] args) {
          BigDecimal d1 = new BigDecimal("1.6");
          BigDecimal d2 = new BigDecimal("0.1");

          System.out.println("덧셈 결과: " + d1.add(d2));
          System.out.println("곱셈 결과: " + d1.multiply(d2));
      }
  }
```
---

## Math 클래스
- 모든 메소드가 static → `기능 제공 목적` 인스턴스 생성 목적이 아님

### 예시
```
  class SimpleMathUse {
      public static void main(String[] args) {
          System.out.println("원주율: " + Math.PI);
          System.out.println("2의 제곱근: " + Math.sqrt(2));
          System.out.println();

          System.out.println("파이에 대한 Degree: " + Math.toDegrees(Math.PI));
          System.out.println("2 파이에 대한 Degree: " + Math.toDegrees(2.0 * Math.PI));
          System.out.println();

          double radian45 = Math.toRadians(45);

          System.out.println("싸인 45: " + Math.sin(radian45));
          System.out.println("코싸인 45: " + Math.cos(radian45));
          System.out.println("탄젠트 45: " + Math.tan(radian45));
          System.out.println();

          System.out.println("로그 25: " + Math.log(25));
          System.out.println("2의 16승: " + Math.pow(2, 16));
      }
  }
```
---

## Random 클래스
- 난수 생성 클래스 (java.util.Random)
- 주요 메소드
  - nextBoolean()
  - nextInt()
  - nextLong()
  - nextInt(int bound) : 0 이상 bound 미만
  - nextFloat()  : 0.0 이상 1.0 미만
  - nextDouble() : 0.0 이상 1.0 미만
- 시드(Seed)
  - 생성자에 seed를 주면 난수 패턴이 100% 동일
  - seed를 안 주면 현재 시간을 밀리초 단위로 계산해 사용

### 예시
```
  import java.util.Random;

  class RandomNumberGenerator {
      public static void main(String[] args) {
          Random rand = new Random();

          for(int i = 0; i < 7; i++)
              System.out.println(rand.nextInt(1000));
      }
  }
```
---

## StringTokenizer 클래스
- 구분자를 기준으로 문자열을 토큰 단위로 분리
- 생성자
  - StringTokenizer(String str, String delim)
- 구분자는 여러 개 지정 가능

예: `StringTokenizer st = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/= ");`

- 주요 메소드
  - hasMoreTokens() : 남은 토큰 존재 여부
  - nextToken()     : 다음 토큰 반환
- 구분자도 토큰으로 포함하고 싶다면 생성자 마지막 인자에 true 사용

---

## Arrays 클래스 (java.util.Arrays)
### 배열 복사
- copyOf(int[] original, int newLength)
  - 새 배열을 생성해 복사
- copyOfRange(int[] original, int from, int to)
  - [from, to) 구간 복사

### System.arraycopy (java.lang.System)
- arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
- 기존 배열 간 복사(새 배열 생성 X)

### 배열 비교
- Arrays.equals(int[] a, int[] a2)
  - 기본형 배열의 내용 비교
- Object 배열 equals는 내부적으로 각 원소의 equals에 의존
  - 원소 클래스가 equals를 오버라이딩해야 `내용 비교`가 가능

### 예시
```
  import java.util.Arrays;

  class INum {
      private int num;

      public INum(int num) {
          this.num = num;
      }

      @Override
      public boolean equals(Object obj) {
          return this.num == ((INum)obj).num;
      }
  }

  class ArrayObjEquals {
      public static void main(String[] args) {
          INum[] ar1 = new INum[3];
          INum[] ar2 = new INum[3];

          ar1[0] = new INum(1);
          ar2[0] = new INum(1);

          ar1[1] = new INum(2);
          ar2[1] = new INum(2);

          ar1[2] = new INum(3);
          ar2[2] = new INum(3);

          System.out.println(Arrays.equals(ar1, ar2));
      }
  }
```
### 배열 정렬
- sort(int[] a)
- Object 배열 정렬 시: 원소 클래스가 Comparable 구현 필요
  - compareTo(Object o) 구현
  - 오름차순: this - o
  - 내림차순: o - this

### 예시
```
  import java.util.Arrays;

  class Person implements Comparable {
      private String name;
      private int age;

      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }

      @Override
      public int compareTo(Object o) {
          Person p = (Person)o;
          return this.age - p.age; // 오름차순
      }

      @Override
      public String toString() {
          return name + ": " + age;
      }
  }

  public class Practice_2_1 {
      public static void main(String[] args) {
          Person[] ar = new Person[3];

          ar[0] = new Person("Lee", 29);
          ar[1] = new Person("Goo", 15);
          ar[2] = new Person("Soo", 37);

          Arrays.sort(ar);

          for (Person p : ar)
              System.out.println(p);
      }
  }
```
### 배열 탐색
- binarySearch(int[] a, int key)
  - 정렬이 선행되어야 함
  - 이진 탐색 후 인덱스 반환
- Object 배열 탐색
  - binarySearch(Object[] a, Object key)
  - 원소 클래스가 Comparable 구현 상태여야 함
  - compareTo 기준으로 탐색 진행

### 예시
```
  import java.util.Arrays;

  class Person implements Comparable {
      private String name;
      private int age;

      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }

      @Override
      public int compareTo(Object o) {
          Person p = (Person)o;
          return this.age - p.age;
      }

      @Override
      public String toString() {
          return name + ": " + age;
      }
  }

  class ArrayObjSearch {
      public static void main(String[] args) {
          Person[] ar = new Person[3];

          ar[0] = new Person("Lee", 29);
          ar[1] = new Person("Goo", 15);
          ar[2] = new Person("Soo", 37);

          Arrays.sort(ar);

          int idx = Arrays.binarySearch(ar, new Person("Who are you?", 37));
          System.out.println(ar[idx]);
      }
  }
```
