## 🖥 이름을 가지는 반복문(break with label)

일반적인 break 문은 단 하나의 반복문만을 빠져나가게 해줍니다.

따라서 여러 반복문이 중첩된 상황에서 한 번에 모든 반복문을 빠져나가거나, 특정 반복문까지만 빠져나가고 싶을 때는 다른 방법을 사용해야 합니다.

```java
allLoop :

for (int i = 2; i < 10; i++) {

    for (int j = 2; j < 10; j++) {

        if (i == 5) {

            break allLoop;

        }

        System.out.println(i + " * " + j + " = " + (i * j));

    }

}
```

