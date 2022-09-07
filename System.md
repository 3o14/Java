## 🖥 자바 표준 입출력 클래스 System
* C언어의 printf(), scanf()와 같은 표준 입출력 클래스를 말함

* java.lang 패키지에 포함되어 제공됨

* 클래스 변수(static variable)
  * System.in 
  
  * System.out
  
  * System.err

<br/>
  
### ⌨️ System.out.printIn()
* 모니터에 전달된 데이터를 출력한 후에 줄 바꿈까지 해줌

```java
System.out.println(출력할데이터);
```

* 예제

```java
System.out.print(7);         // print() 메소드는 줄 바꿈을 하지 않음.

System.out.println(3);       // 정수 출력

System.out.println(3.14);    // 실수 출력

System.out.println("자바!"); // 문자열 출력

System.out.println("문자열끼리의 " + "연결도 가능합니다.");

System.out.println("숫자" + 3 + "과 문자열의 연결도 가능합니다.");
```
