# Book Study - React.js, 스프링 부트, AWS로 배우는 웹 개발 101
## 실습 코드

> React.js, 스프링 부트, AWS로 배우는 웹 개발 101
> [책 정보](http://www.yes24.com/Product/Goods/103768882)



### 정리
Generic 정리 / Spring Validation

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


