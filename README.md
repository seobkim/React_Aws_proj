# Book Study - React.js, 스프링 부트, AWS로 배우는 웹 개발 101
## 실습 코드

> React.js, 스프링 부트, AWS로 배우는 웹 개발 101
> [책 정보](http://www.yes24.com/Product/Goods/103768882)



### 정리
- Generic 객체
- Optional 객체
- Spring Validation
- Java8

# Generic
제네릭(Generic)은 직역하자면 '일반적인'이라는 뜻이다. '데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 하는 방법'이다.

Java의 Jeneric에 와일드 카드로 아래와 같이 사용가능한데, 각 와일드카드의 내용에 따라 형식에 맞춰 객체를 생성하면된다.
<T> Type => String / Integer 등
<E> Element => Array/ ArrayList/ Map 등의 Object 형식
<K> Key => Key 값의 타입
<V> Value => Value 값의 타입
<N> Number => 숫자 형식

Generic의 장점
제네릭을 사용하면 잘못된 타입이 들어올 수 있는 것을 컴파일 단계에서 방지할 수 있다.
클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다. 즉, 관리하기가 편하다.
비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.
위의 와일드카드 형식은 반드시 한 글자일 필요는 없다. 또한 설명과 반드시 일치해야 할 필요도 없다.
예로들어 라고 해도 전혀 무방하다. 다만 대중적으로 통하는 통상적인 선언이 가장 편하기 때문에 위와같은 암묵적(?)인 규칙이 있을 뿐이다.


# Optional
Optional이란?
Optional는 “존재할 수도 있지만 안 할 수도 있는 객체”, 즉, “null이 될 수도 있는 객체”을 감싸고 있는 일종의 래퍼 클래스입니다. 원소가 없거나 최대 하나 밖에 없는 Collection이나 Stream으로 생각하셔도 좋습니다. 직접 다루기에 위험하고 까다로운 null을 담을 수 있는 특수한 그릇으로 생각하시면 이해가 쉬우실 것 같습니다.

Optional의 효과

예외를 유발할 수 있는 null을 직접 다루지 않아도됨.
null 체크를 직접 하지 않아도 됨.
명시적으로 해당 변수가 null일 수도 있다는 가능성을 표현할 수 있습니다. (따라서 불필요한 방어 로직을 줄일 수 있습니다.)

# Spring Validation

-> @Valid는 Java 에서 지원해주는 어노테이션이고 @Validated는 Spring에서 지원해주는 어노테이션
@Validated는 @Valid의 기능을 포함하고, 유효성을 검토할 그룹을 지정할 수 있는 기능을 추가로 가지고 있다.



`@Null  // null만 혀용합니다.`  
`@NotNull  // null을 허용하지 않습니다. "", " "는 허용합니다.`  
`@NotEmpty  // null, ""을 허용하지 않습니다. " "는 허용합니다.`  
`@NotBlank  // null, "", " " 모두 허용하지 않습니다.`  

`@Email  // 이메일 형식을 검사합니다. 다만 ""의 경우를 통과 시킵니다`  
`@Pattern(regexp = )  // 정규식을 검사할 때 사용됩니다.`  
`@Size(min=, max=)  // 길이를 제한할 때 사용됩니다.`  

`@Max(value = )  // value 이하의 값을 받을 때 사용됩니다.`  
`@Min(value = )  // value 이상의 값을 받을 때 사용됩니다.`  

`@Positive  // 값을 양수로 제한합니다.`  
`@PositiveOrZero  // 값을 양수와 0만 가능하도록 제한합니다.`  

`@Negative  // 값을 음수로 제한합니다.`  
`@NegativeOrZero  // 값을 음수와 0만 가능하도록 제한합니다.`  

`@Future  // 현재보다 미래`  
`@Past  // 현재보다 과거`  

`@AssertFalse  // false 여부, null은 체크하지 않습니다.`  
`@AssertTrue  // true 여부, null은 체크하지 않습니다.`  

# Java8 변경 사항
1. 람다 표현식(lambda Expression) : 함수형 프로그래밍
2. 스트림 API(Stream API) : 데이터의 추상화
3. java.time 패키지 : Joda-Time을 이용한 새로운 날짜와 시간 API

- 람다표현식(Lambda Expression)
: 람다 표현식이란 간단히 말해 메소드를 하나의 식으로 표현한 것.
즉, 식별자 없이 실행할 수 있는 함수 표현식을 의미하며, 따라서 익명 함수(Anonymous function)이라고도 부릅니다.

메소드를 이렇게 람다 표현식으로 표현하면 클래스를 만들고 객체를 생성하지 않아도 메소드를 사용할 수 있습니다.
또한, 람다 표현식은 메소드의 매개변수로 전달될 수도 있고, 메소드의 결과값으로 반환가능
이러한 표현식은 기존의 불필요한 코드를 줄여주고, 작성된 코드의 가독성을 높이는데 목적을 갖고있다.

- 스트림 API (Stream API)
자바에서는 많은양의 데이터를 저장하기 위해서 배열이나 컬렉션을 사용 또한, 이렇게 저장된 데이터에 접근하기 위해서는 반복문이나 반복자(Iterator)를 사용하여 매번 코드를 작성해야 했다

하지만 이렇게 작성된 코드는 길이가 너무길고 가독성도 떨어지며, 코드의 재사용이 거의 불가능
또, 데이터베이스의 쿼리와 같이 정형화된 처리 패턴을 가지지 못했기에 데이터마다 다른 방법으로 접근해야하만 했다.
이러한 문제점을 극복하기 위해서 스트림 API 는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공합니다.

따라서 스트림 API를 이용하면 배열이나 컬렉션뿐만 아니라 파일에 저장된 데이터도 모두 같은 방법으로 다룰 수 있습니다.




