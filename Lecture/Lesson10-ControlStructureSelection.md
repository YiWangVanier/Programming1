# Lesson10-ControlStructureSelection

## 1. Control Structure

Control structures / Control statements enable a programmer to determine the order in which program statements are executed. These control structures allow you to do two things such as skipping some statements while executing others or repeating one or more statements while some condition is true.

There are three control structures:

1. Sequential: Execute code from top to bottom line by line.
2. Selection: Allows to skip some statements while executing others
3. Repetition: Allows to repeat one or more statements

What we have seen previously is sequential, the code is executed from the top to bottom.

## 2. Selection

The selection allows one to skip some statements while executing others. For example, when I say "If there is a snow storm, then the class will be canceled, else we will have the class as usual", even though I have listed two situations, there would be only one executed depending on the weather tomorrow, and the other one will be skipped (ignored).

### 2.1 `if` Statement

The simplest selection is a single `if` statement, the syntax of `if` is

```java
if (condition) {
    statements;
}
```

where the `condition` is a boolean value, it can be an operation such as `age < 18` or directly a boolean value such as `true`.

If the condition is `true`, then the statements between the curly brackets `{}` will be executed, else it will be ignored.

```java
Scanner console = new Console(System.in);

System.out.print("Please enter a number: ");
int num = console.nextInt();
if (num < 0) {
    num *= -1;      // bring negative number to positive
}   
```

In this example, we check if `num` is negative or not, if so, `num *= -1;` will be executed and `num` will be converted to positive. If `num` is not negative, then `num *= -1;`  will be skipped. There are two branches, one is to execute the inside statement, while the other is executing nothing.

### 2.2 `if`...`else` Statement

In the previous example, even though there are two branches, one branch does nothing, thus we do not write that branch. In other situations, we may need to specify what the other branch does. In those cases, we need to use the `if`...`else` statement. The syntax of `if`...`else` is

```java

if (condition) {
    statements;
} else {
    statements;
}
```

where the `else` is paired with the `if`. In other words, `else` cannot exist by itself, it MUST be used with an `if`. Also, `else` does not take any condition, it will be executed if the paired `if` condition fails.

```java
Scanner console = new Console(System.in);

System.out.print("Please enter a number: ");
int num = console.nextInt();
if (num % 2 == 0) {
    System.out.printf("%d is an even number.");
}  
else {
    System.out.printf("%d is an odd number.");
}  
```

In this example, if `num % 2 == 0`, then the first `print` will be executed, while the second `print` will be skipped, and if `num % 2 != 0`, then the first `print` will be skipped, while the second `print` will be executed.

If the `if`...`else` statement only assigns values to one variable or returns a value, we can use a `conditional operator` to simplify it. The conditional operator is the only `ternary operator`, which takes three values: a `boolean` condition, and two values. The syntax looks like:

```java
return (condition) ? valueA : value B;

variable = (condition) ? valueA : value B;
```

For example:

```java
if (age < 18) {
    price = 5;
} else {
    price = 10;
}
```

can be written as:

```java
price = (age < 18) ? 5 : 10;
```

The Conditional operator is only suggested to be used when there are two branches. Using it for situations with more branches reduces the clarity of the code.

### 2.3 `if`...`else if`...`else` Statement

Sometimes we have to face more than two branches. For example, a number can be positive, negative, or zero; or the size of clothes can be small, medium, large, or extra large, etc.

We can use the `if`...`else if`...`else` structure to handle those situations. The number of `else if` is not necessary to be one, you can have as many `else if` as you want in an `if`...`else if`...`else` statement.

```java
Scanner console = new Console(System.in);

System.out.print("Please enter a number: ");
int num = console.nextInt();
if (num % 2 < 0) {
    System.out.printf("%d is a negative number.");
}  
else if (num % 2 > 0) {
    System.out.printf("%d is a positive number.");
}  
else {
    System.out.printf("%d is zero.");
} 
```

```java
Scanner console = new Console(System.in);

System.out.print("Please enter the size: ");
String size = console.next().toLowerCase();
if (size.equals("s")) {
    System.out.printf("The size is SMALL");
}  
else if (size.equals("m")) {
    System.out.printf("The size is MEDIUM");
}  
else if (size.equals("l")) {
    System.out.printf("The size is LARGE");
}  
else if (size.equals("xl")) {
    System.out.printf("The size is EXTRA LARGE");
}  
else {
    System.out.printf("The input is invalid...");
} 
```

### 2.4 `switch`...`case` Statement

In the previous example, there are five branches, and each branch compares the size by using `equals()`. If all branches compare the same variable with different values by using either `==` or `equals()`, the `if`...`else if`...`else` statement can be replaced by a `switch`...`case` statement. There are two ways to write `switch`...`case` statements:

#### 2.4.1 Traditional `switch`...`case`

Since the `switch`...`case` can only compare one variable with different values by using `==` or `equals`, it can simplify the code by hiding the `==` or `equals`.

```java
Scanner console = new Console(System.in);

System.out.print("Please enter the size: ");
String size = console.next().toLowercase();
if (size.equals("s")) {
    System.out.printf("The size is SMALL");
}  
else if (size.equals("m")) {
    System.out.printf("The size is MEDIUM");
}  
else if (size.equals("l")) {
    System.out.printf("The size is LARGE");
}  
else if (size.equals("")) {
    System.out.printf("The size is EXTRA LARGE");
}  
else {
    System.out.printf("The input is invalid...");
} 

// can be written as:
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();

switch (size) {
    case "s":
        System.out.print("The size is SMALL");
        break;
    case "m":
        System.out.print("The size is MEDIUM");
        break;
    case "l":
        System.out.print("The size is LARGE");
        break;
    case "xl":
        System.out.print("The size is EXTRA LARGE");
        break;
    default:
        System.out.print("The input is invalid...");
}
```

In this example, since we always compare the `size` with a value, by using the `switch`...`case`, we do not have to repeat the `size` for each branch, also, the `equals` method is hidden because the `switch` only supports `==` or `equals`.

Each `case` represents one branch, while the `default` is the same as `else` in an `if`...`else if`...`else` statement.

Notice that in the traditional `switch`...`case`, if one case is matched, Java will execute the code after until it reaches a keyword `break` or the end of the `switch`...`case` statement.

If a few branches share the same behaviors:

```java
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();

switch (size) {
    case "s":       // s and m share the same statement
    case "m":
        System.out.print("The size is S or M");
        break;
    case "l":       // l and lx share the same statement
    case "xl":
        System.out.print("The size is L or XL");
        break;
    default:
        System.out.print("The input is invalid...");
}
```

#### 2.4.2 `switch` Expression

Since `JDK 12`, an even simpler `switch` expression has been introduced to replace the traditional `switch`...`case` statement, the new `switch` expression uses `->` instead of `:` and `break``.

```java
// regular switch...case statement
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();

switch (size) {
    case "s":
        System.out.print("The size is SMALL");
        break;
    case "m":
        System.out.print("The size is MEDIUM");
        break;
    case "l":
        System.out.print("The size is LARGE");
        break;
    case "xl":
        System.out.print("The size is EXTRA LARGE");
        break;
    default:
        System.out.print("The input is invalid...");
}

// switch 
Scanner console = new Scanner(System.in);
System.out.print("Please enter the size: ");
String size = console.next().toLowerCase();

switch (size) {
    case "s" -> System.out.print("The size is SMALL");
    case "m" -> System.out.print("The size is MEDIUM");
    case "l" -> System.out.print("The size is LARGE");
    case "xl" -> System.out.print("The size is EXTRA LARGE");
    default -> System.out.print("The input is invalid...");
}
```

As can be seen, because the `break` is removed, the code gets much shorter.

If you have a few branches share the statement, it can also be written in `switch` expression.

```java
// regular switch...case statement 
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();

switch (size) {
    case "s":       // s and m share the same statement
    case "m":
        System.out.print("The size is S or M");
        break;
    case "l":       // l and lx share the same statement
    case "xl":
        System.out.print("The size is L or XL");
        break;
    default:
        System.out.print("The input is invalid...");
}

// switch expression
switch (size) {
    case "s", "m" -> System.out.print("The size is S or M");
    case "l", "xl" -> System.out.print("The size is L or XL");
    default -> System.out.print("The input is invalid...");
}
```

If you want to use the `switch` expression to assign different values to a variable or return a value, the assignment and the return can be written before the `switch` expression and shared by all cases.

```java
// Example of assigning different values to the same variable by using the switch expression
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();

// different value are assigned to price 
double price = switch (size) {
    case "s" -> 9;
    case "m" -> 10;
    case "l" -> 11;
    case "xl" -> 12;
    default -> Double.NaN;
}
```

```java
// Example of returning different values by using the switch expression
/**
 * Checks the price of a cloth based on its size
 * @param size the size of a clothes
 * @return the price of a cloth
 */
public static double checkPrice(String size) {
    return switch (size) {
        case "s" -> 9;
        case "m" -> 10;
        case "l" -> 11;
        case "xl" -> 12;
        default -> Double.NaN;
    }
}
```

If there is more than one statement for each case, a pair of curly brackets `{}`` can be used:

```java
// Example of multy statements for a case in the switch expression
System.out.print("Please enter the size: ");
String size = console.next().toLowercase();
double price;

// switch expression
switch (size) {
    case "s", "m" -> {
        System.out.print("The size is S or M");
        price = 9;
    }
    case "l", "xl" -> {
        System.out.print("The size is L or XL");
        price = 10;
    }
    default -> {
        System.out.print("The input is invalid...");
        price = Double.NaN;
    }
}
```

Even though the regular `switch`...`case` still works, it is strongly encouraged to use the `switch` expression, which not only can simplify the code but also can help you understand *lambda expressions* in the future.
