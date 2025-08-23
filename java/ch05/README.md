# Ch5: 실행 흐름의 컨트롤

## 조건문
- `if ~ else` 문
- 삼항 연산자 ( ? : )
- `switch` 문
  - 각 case 뒤에는 break 를 반드시 작성해야 함
  - default 에도 break 를 작성하는 것이 권장됨
  - 일부러 break 를 생략하면 case 문이 이어질 수 있음 (fall-through)
  - case 로 범위를 표현하는 것은 비효율적 → 범위 조건은 if 문을 사용

---

## 반복문
- `while` 문
- `do-while` 문
  - 조건과 관계없이 반드시 한 번은 실행
- `for` 문

---

## break & continue
- `break` : 반복문 강제 종료
- `continue` : 현재 반복만 건너뛰고 다음 반복으로 이동
- 중첩 반복문에서 특정 반복문만 종료하려면 **라벨(label)** 을 사용

```
outer: for (int i = 0; i < 100; i++) {
    for (int j = 0; j < 100; j++) {
        for (int k = 0; k < 100; k++) {
            if (i * j * k == 200) break outer;
        }
    }
}
```
