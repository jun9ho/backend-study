# Ch8: 패키지와 클래스 패스

## 클래스 패스 (Class Path)
- 자바 가상머신이 클래스 파일을 찾는 경로
- 지정하지 않을 시 현재 디렉토리에서 필요한 클래스를 찾는다.
- 둘 이상의 경로 지정 가능
- 현재 설정된 클래스 패스 확인: `set classpath`
- 클래스 패스 설정: `set classpath = '경로';`
- 절대경로: 지정한 경로 그대로 사용
- 상대경로: 현재 디렉토리를 기준으로 표현된 파일/디렉토리 위치

### 클래스 패스 고정 방법
- 환경 변수 `classpath` 를 설정해 경로 고정 가능
- 그러나 권장되지 않는 방법

---

## 클래스 파일 규칙
- 하나의 소스파일에는 `public` 으로 선언된 클래스 정의를 하나만 둘 수 있다.
- 소스파일의 이름은 `public` 으로 선언된 클래스 이름과 동일해야 한다.

---

## 패키지 (Package)
- 패키지 이름은 모두 소문자로 작성
- 인터넷 도메인 이름의 역순으로 구성
- 패키지 이름 끝에 클래스를 정의한 주체 또는 팀 이름을 추가
- 예시:
  - 회사 도메인: wxfx.com
  - 팀: smart
  - 패키지명: `com.wxfx.smart`
  - 저장 위치: `\com\wxfx\smart`

### 패키지 선언
- 클래스를 패키지로 묶을 때는 소스파일 상단에 `package` 선언 필요
  - `package com.wxfx.smart;`

### 패키지 컴파일
- `javac -d <directory> <filename>`
- 예시:  
  `C:\PackageStudy> javac -d . Circle.java`

---

## 클래스 탐색 순서
- 자바 컴파일러는 패키지를 먼저 찾고, 그 다음 클래스 패스를 참조한다.
- 참조하여 인스턴스 생성이 이루어진다.

---

## import 선언
- 특정 클래스 import:
  - `import com.wxfx.smart.Circle;`
  - 이후 `Circle c1 = new Circle();` 가능
- 동일한 이름의 클래스를 동시에 import 불가능
- 전체 패키지 import:
  - `import com.wxfx.smart.*;`
  - 해당 패키지 내의 클래스는 패키지명 생략 가능
