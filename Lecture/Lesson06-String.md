# Lesson06-String

## 1. String

### 1.1 What Is A String

String is a data type provided by Java, but instead of a primitive data type, String is a `class`. Different from a primitive data type, the String class also provides plenty of methods developers can directly use. And since String is a class, we call the variable `object`.

A string is defined between a pair of double quotes `""`, it is a collection of characters. If nothing is between the double quotes, it is an empty string.

```java
String str1 = "Hello";   // str1 and str2 are objects
String str2 = "";    // empty string
```

Each string has a length, which indicates the number of characters in it. `"hello"` has a length of `5`, `"000"` has a length of `3`, and a whitespace is also a character, thus `" "` has a length of `1`. An empty string (`""`) has a length of `0`.

### 1.2 Index System

Each character in a string has an index, to indicate the location of it in the string. In Java, the index system starts at `0`, so the index of the first character is `0`, the index of the second character is `1`, and in general, the index of the `n`th character is `n - 1`. The index of a character and the value of a character are different. The index is always a positive integer, while the value of a character could be anything.

```java
"HelloWorld"  // value
 0123456789   // index
```

### 1.3 String Concatenation

String only supports one operation: the concatenation. When you apply `+` on two strings, it concatenates the two together.

```java
String str1 = "Hello";
String str2 = "World";

String str3 = str1 + str2;  // "HelloWorld"
```

Value in any data type can also be converted to a string, e.g.: `3` can be converted to `"3"`, `'c'` can be converted to `"c"`, and `true` can be converted to `"true"`. Thus, a string can concatenate with any value.

```java
String str1 = "Hello";
int num1 = 3;
double num2 = 3.14;
char character = '!';
boolean flag = true;

System.out.print(str1 + num1);  // "Hello" + 3 -> "Hello" + "3" -> "Hello3"
System.out.print(str1 + num2);  // "Hello" + 3.14 -> "Hello" + "3.14" -> "Hello3.14"
System.out.print(str1 + character); // "Hello" + '!' -> "Hello" + "!" -> "Hello!"
System.out.print(str1 + flag);  // "Hello" + true -> "Hello" + "true" -> "Hellotrue"
```

One should be careful with the order when using `+` to concatenate strings and other values.

```java
String str = "Hello";

System.out.print(str + 1 + 2);   // ("Hello" + 1) + 2-> "Hello1" + 2 -> "Hello12"
System.out.print(str + (1 + 2));  // "Hello" + 3 -> "Hello3"
System.out.print(1 + 2 + str);   // 3 + "Hello"-> "3Hello"
```

### 1.3 Conversion Between String and Other Data Type

#### 1.3.1 Convert A Value To String

There are two ways to convert a value to a string:

1. `"" + value`: for example, `"" + 3` equals `"3"`
2. `String.valueOf()`: for example, `String.valueOf(3)` equals `"3"`

#### 1.3.2 Convert A String To A Value

Clearly, you cannot convert `"Hello"` to an `int`, but it is possible to convert `"3"`  to `3`, `"3.14"` to `3.14`, or `"true"` to `true`. To do so, we need to use the wrapper class of the target data type.

| Method                        | Usage                            | Example                          | Result   |
| ----------------------------- | -------------------------------- | -------------------------------- | -------- |
| `Integer.parseInt(str)`     | convert `str` to an `int`    | `Integer.parseInt("3")`        | `3`    |
| `Double.parseDouble(str)`   | convert `str` to a `double`  | `Double.parseDouble("3.14")`   | `3.14` |
| `Boolean.parseBoolean(str)` | convert `str` to a `boolean` | `Boolean.parseBoolean("true")` | `true` |

These conversions will only work if the string can be converted, or an exception will be thrown.

### 1.4 `printf()` Method

#### 1.4.1 General Syntax

Previously we have learned how to use `print()` and `println()` to print in the console. With string concatenation, the output result can be more clear.

```java
int num1 = 3;
int num2 = 5;

int sum = num1 + num2;

System.out.print(num1 + " + " + num2 + " = " + sum); // print 3 + 5 = 8
```

However, there is a problem with doing this, in the previous example, `num1`, `num2`, and `sum` are variables, while `+` and `=` are strings, when joining them, we need to use `+` between each of them, and there are 4 `+` used to join them all, each time a `+` is used, spaces should be added around it, also, around the character `+` and `=` there should be spaces as part of the string, which makes it very difficult to write the formula.

Java provides a third way to print the output, the `printf()` method, which is much more powerful than `print()` and `println()`, and can solve the previous problem easily.

`printf()` contains two parts, the general outlook of the output, and the fulfilled values. For example, what we want to print in the previous example is `x + y = z`, where all `x`,  `y`, and `z` are `int`s, thus the first part of `printf()` can be written as `printf("%d + %d = %d")`, where `%d` is a place holder, later will be filled by a value. Different types of values need different placeholders.

| Type       | Place Holder |
| ---------- | ------------ |
| `int`    | `%d`       |
| `double` | `%f`       |
| `String` | `%s`       |

And since we have three placeholders in the first part, we will need to put three values after, each one will fill one of the placeholders. The first place holder should be filled by `num1`, the second place holder should be filled by `num2`, and the third place holder should be filled by `sum`. Thus `printf()` can be written as:

```java
int num1 = 3;
int num2 = 5;

int sum = num1 + num2;

System.out.print(num1 + " + " + num2 + " = " + sum); // print 3 + 5 = 8
System.out.printf("%d + %d = %d", num1, num2, sum);
```

#### 1.4.2 Formatting

We can also use `printf` to format values when we print them. If we want to keep two decimal digits after the `.` for a floating number, we can use `%.2f` instead of `%f`, where `.2` indicates we need 2 decimal points after the dot.

```java
double price = 3.99;
double taxRatio = 0.145;
double totalPrice = price * (1 + taxRatio);  // 4.56855

System.out.print("Total price: $" + totalPrice);  // print Total price: $4.56855
System.out.printf("Total price: $%.2f", totalPrice);  // print Total price: $4.57
```

#### 1.4.3 Zero-padding

If we need to display time, we need to have zero in front of it if the hour, minute, or second has only one digit. Adding zeros in front of a number does not change its value, this is called zero-padding. We can use `printf()` to do so. Instead of using `%d`, we can use `%02d`, where `02` indicates the value will take a length of `2`, and if there is an empty place, it will be filled with `0`.

```java
int hr = 3;
int mi = 30;
int se = 0;

System.out.print(hr + ":" + mi + ":" + se);   // print 3:30:0
System.out.printf("%02d:%02d:%02d", hr, mi, se);  // print 03:30:00
```

You can use `souf` + `tab` to create `printf()` quickly in IntelliJ.

Notice: since `%` is used to define a placeholder in `printf()` method, to print a normal `%` symbol, we need to use two percentage symbols `%%`.

```java
double ratio = 0.05;
System.out.printf("%.2f = %.1f%%\n", ratio, ratio * 100);       // prints 0.05 = 5.0%
```

### 1.5 String Methods

String class provides us with plenty of methods that can be used on String.

#### 1.5.1 `str.length()`

`str.length()` returns the length of a string, e.g., `"hello".length()` returns `5`. `"".length()` returns `0`.

#### 1.5.2 `str.charAt(idx)`

`str.charAt(idx)` returns the character at that index in `str`, e.g., `"hello".charAt(0)` returns `'h'`, `"hello".charAt(4)` returns `'o'`. If the given index is too big, an index out of bound exception will be thrown, e.g.: `"hello".charAt(5)`.

#### 1.5.3 `str.indexOf(c)`

`str.indexOf(c)` returns the index of the first occurrence of character `c`, e.g., `"hello".indexOf('h')` returns `0`, `"hello".indexOf('l')` returns `2`. If the string does not contain character `c`, then a special value of `-1` will be returned, e.g., `"hello".indexOf('z')` returns `-1`.

#### 1.5.4 `str1.contains(str2)`

`str1.contains(str2)` returns `true` if `str1` contains `str2`, else `false`, e.g.: `"hello".contains("ll")` returns `true`, `"hello".contains("h0")` returns `false`.

#### 1.5.5 `str.substring(endIdx)`

`str.substring(endIdx)` returns a substring of `str`, which starts at index `0` and ends at `endIdx`. The character at `endIdx` is excluded, e.g., `"hello".substring(3)` returns `"hel"`. If the given index is too big, an `index out of bound exception` will be thrown, e.g.: `"hello".substring(5)`.

#### 1.5.6 `str.substring(startIdx, endIdx)`

`str.substring(startIdx, endIdx)` returns a substring of `str`, which starts at index `startIdx` and ends at `endIdx`. The character at `startIdx` is included, while the character at `endIdx` is excluded, e.g., `"hello".substring(1, 3)`returns `"el"`. If the given index is too big, an `index out of bound exception` will be thrown, e.g.: `"hello".substring(2, 5)`.

#### 1.5.7 `str.toUpperCase()`

`str.toUpperCase()` returns a string that has the context as `str` but all letters are uppercase, while numbers and symbols remain the same, e.g.: `"Hello123!".toUpperCase()` returns `"HELLO123!"`.

#### 1.5.8 `str.toLowerCase()`

`str.toLowerCase()` returns a string that has the context as `str` but all letters are lowercase, while numbers and symbols remain the same, e.g.: `"Hello123!".toLowerCase()` returns `"hello123!"`.

#### 1.5.9 `str.isEmpty()`

`str.isEmpty()` returns true if `str` is empty, else `false`, e.g.: `"".isEmpty()` returns `true`, `"Hello123!".isEmpty()`returns `false`.

#### 1.5.10 `str1.equals(str2)`

`str1.equals(str2)` returns true if the context of  `str1` is the same as the context of `str2`, else `false`, e.g.: `"hello".equals("hello")` returns `true` , `"hello".equals("HELLO")`returns `false`.

#### 1.5.11 `str1.equalsIgnoreCase(str2)`

`str1.equalsIgnoreCase(str2)` is very similar to `str1.equals(str2)`, but case-insensitive, e.g.: `"hello".equals("hello")` returns `true` , `"hello".equals("HELLO")` also returns `true`.

#### 1.5.12 `String.valueOf(value)`

`String.valueOf(value)` generates a string with the value of `value`, e.g.: `String.valueOf(123)`returns `"123"`, `String.valueOf(true)`returns `"true"`.

#### 1.5.11 `String.format(pattern, fulfill values)`

`String.format(pattern, fulfill values)` is very similar to `printf()`, but instead of printing the value, it returns a string, e.g.: `String str = String.format("Total price: %.2f", totalPrice);`, then `str` equals `"Total price: 4.57"`.

## 2. Console Input

Previously we have seen how to use `print()`, `println()`, and `printf()` to output on the console. We can also input from the console too.

The syntax is

```java
Scanner console = new Console(System.in);

// input an int
int num1 = console.nextInt();       

// input a double
doyble num2 = console.nextDouble();

// input a String 
String str1 = console.next();       // extract the input by both space and enter
String str2 = console.nextLine();   // extract the input by only enter
```

for example

```java
Scanner console = new Console(System.in);

// age should be an int, user enter 17 and enter
System.out.print("Please enter your age: ");
int age = console.nextInt();        

// name should be a String, and since name may contain spaces, we should use nextLine() instead of next() or the input will be extracted when it reaches the first space.
System.out.print("Please enter your name: ");       
String name = console.nextLine();       // user input Yi Wang, and name equals Yi Wang
String name = console.next();           // user input Yi Wang, but name equals Yi

// gender should also be a String, but since it does not contain a space, we can use next().
System.out.print("Please enter your gender: ");
String gender = console.next();   
```

You can also input more than one value at once:

```java
Scanner console = new Console(System.in);

// if user inputs "3 5", then 3 will be stored in num1 and 5 will be stored in num2
System.out.print("Please enter two numbers: ");
int num1 = console.nextInt();   
int num2 = console.nextInt();   
```

Note that if the user input cannot be converted to an int or a double, then `nextInt()` or `nextDouble` will cause an `InputMismatchException`:

```java
// nextInt() will cause an exception
System.out.print("Please enter your age: ");
int age = console.nextInt();                    // user input "3.14" 

// nextDouble() will cause an exception
System.out.print("Please enter a number: ");
double num = console.nextDouble();              // user input "hello" 
```
