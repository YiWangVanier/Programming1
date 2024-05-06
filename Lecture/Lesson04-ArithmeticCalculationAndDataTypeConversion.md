# Lesson04-ArithmeticCalculationAndDataTypeConversion

## 1. Arithmetic Calculation

Java supports five arithmetic calculations

1. `+`: Addition
2. `-`: Subtraction
3. `*`: Multiplication
4. `/`: Division
5. `%`: Modulo

The first three are straightforward, however, the division might be slightly different than what you have learned before, and modulo is also a new calculation.

```java
int num1 = 1 + 2;
int num2 = 3 - 1;
double num3 = 1.2 * 3.4;
```

### 1.1 Division

When an integer value is divided by another integer value, the result is also an integer, e.g.: `10 / 2` equals `5`. However, if the result contains the floating part, it will be discarded, no matter what the value is. For example: `10 / 3` equals `3`, `10 / 4` equals `2`, `9 / 10` equals `0`.

An integer divided by an integer `0` will cause a `divide by zero exception`.

### 1.2 Modulo

Modulo is also called mod for short, it calculates the remainder after the division, for example, to calculate `10 % 3`, a division of `10 / 3` is first calculated, and that results in `3`, then `1` is left after the division.

You can understand `a % b` as: if you have `$a` in your pocket, and you go to a store to buy a product `$b` as many as possible, and the result equals the money left in your pocket.

For example, `10 % 3` can be calculated as you have `$10`, and you want to buy a product worth `$3` as many as possible, since you can only buy `3`, which will cost you `$9`, and only `$1` will left, so the result equals `1`.

There are two special situations:

1. a positive integer modulo by `1` equals `0`, e.g.: `10 % 1` equals `0`.
2. a small integer modulo by a big integer equals the small integer itself, e.g.: `3 % 10` equals `3`.

Also, for `a % b`, the result can only be `[0, b)`, e.g.: `a % 3`, no matter what value `a` is, the result can only be `0`, `1`, and `2`.

One usage of modulo is to check if a number is even or odd. if `num` is even, then `num % 2` equals `0`, else `num % 2` equals `1`.

### 1.3 Assign Operation

Technically, `=` is also an operation, it assigns the value on the right to the variable on the left.

### Shorthand Operation

#### 1.4.1 `+=` Operation

In many situations, we would like to read the value of a variable, and then update it, e.g.: if your account balance is `10`, and then you withdraw `3`, then the new balance would be `7`, you may have some code like `balance = balance - 3;`. in which `-` is calculated before `=`, thus the old value of `balance` is read and used, and then the result is assigned to `balance` as its new value.

Java provides an easy way to implement the operation above

1. `a += b;` can be used to represent `a = a + b;`
2. `a -= b;` can be used to represent `a = a - b;`
3. `a *= b;` can be used to represent `a = a * b;`
4. `a /= b;` can be used to represent `a = a / b;`
5. `a %= b;` can be used to represent `a = a % b;`

#### 1.4.2 `++` Operation

In some more special situations, the value of `b` is `1`, for example, if you want to count the number of people entering a museum, it adds `1` each time when a person enters, it can be implemented by `counter += 1;`.

Java provides an even easier way to implement the operation

1. `a++;` or `++a` can be used to represent `a = a + 1` or `a += 1`;
2. `a--;` or `--a` can be used to represent `a = a - 1` or `a -= 1`;

There is no `**`, `//`, or `%%`.

##### 1.4.2.1 Prefix or Postfix

If there is only `++` or `--` operation in a statement, then the location of `++` or `--` causes no difference, i.e.: `++a;` and `a++;` are the same. However, if the statement contains more than the `++` operation, then the location of `++` matters.

* If `++` is in front of a variable, then `++` is first executed.
* If `++` is after a variable, then `++` is last executed.
  
```java
// there is no difference between num++ and ++num if the statement contains only ++
int num = 5;
num++;
++num;

// ++ is in front of num1, so ++ is first calculated before printting. 
int num1 = 5;
System.out.print(++num1);     // print 6

// ++ is after num1, so ++ is last calculated after printting. 
int num2 = 5;
System.out.print(++num2);     // print 5, then num2 = 6
```

### 1.5 Priority

`*`. `/` and `%` has higher than `+` and `-`, and `=` has the lowest priority.

You can also use `()` to change the priority.

```java
int num1 = 1 + 2;   // first execute 1 + 2, then execute num = 3, no need to change the priority
int num2 = 1 + 2 * 3;  // first execute 2 * 3, then execute 1 + 6, then execute num2 = 7
int num3 = (1 + 2) * 3;  // first execute 1 + 2, then execute 3 * 3, then execute num3 = 9
```

## 2. Data Type Conversion

In previous examples, we only see operations between `int`s and `double`s, but in reality, the situations could be more complected, values in different data types can interact with each other.

The general rule is that Java will not directly calculate two values with different data types, it will try its best to first convert them into the same data type, if it can be done SAFELY, and then calculate the result in the same data type. This process is called *auto-conversion*.

### 2.1 Auto-conversion

If Java can convert a value into another type without losing any data, then it is considered to be safe. For example, converting `3` from int to double is safe, the value will be `3.0` and nothing is lost. However, converting a `3.1` from double to int is not safe, since the value will be changed to `3`, this is called a *lossy conversion*.

The following are popular conversions

| From   | To     | IsSafe |
| ------ | ------ | ------ |
| int    | double | True   |
| double | int    | False  |
| float  | double | True   |
| double | float  | False  |
| int    | char   | True   |
| char   | int    | True   |
| Any    | String | True   |

The last one convert to String will be explained when we learn String

This explains why previously we could assign an integer value to a double variable or a char variable, cause Java can convert an integer to char safely.

```java
// Correct
double num = 3;   // Java converts 3 into 3.0, and then assign it to num
char character = 97;  // Java convert 97 to 'a' and then assign it the character

// Wrong
int num1 = 3.14;  // Java cannot convert a double to an int safely
float num2 = 3.14;  // Java cannot convert a double to a float safely
```

When Java has to calculate `10 / 4.0`, Java will first check if it can bring the two values into the same data type safely. Since `int` can be converted to `double` safely, Java will do so and then divide a `double` value by another `double` value, and then the result will be also a `double`. In this example, `10 / 4.0` -> `10.0 / 4.0` -> `2.5`.

Another example would be `char character = 'a' + 1;`, where there are two operations, first `+`, and then `=`, since `+` has higher priority than `=`, Java will first calculate `'a' + 1`, which is a `char` plus an `int`. Java will convert a `char` into an `int`, and the result will be an `int`, then Java will assign the `int` value to a `char` variable, thus Java will convert the `int` into a `char` and then assign it. I.e.: `char character = 'a' + 1;` -> `char character = 97 + 1;` -> `char character = 98;` -> `char character = 'b';`

### 2.2 Manual-conversion

In some situations, we want to convert a value to another data type unsafely, i.e.: If I want to set a timer, the real-time can be stored as a `double` such as `5.86`, but I only want to display an `int` result, i.e.: `5` instead, I need to convert the `double` into `int` and discard the floating part.

Even though that is exactly what we want, Java will not cast it automatically for us, cause it is not safe. If we insist on doing so, we have to manually convert the value.

To convert a value to another type manually, we need to add the target type between a pair of brackets in front of the value.

```java
int num1 = (int) 3.14;   // Java first convert 3.14 to 3, then assign 3 to num1
float num2 = (float) 3.14; // Java first convert 3.14 to 3.14f, then assign 3.14f to num2
```

Notice, that manual conversion is also an operation, and its priority is higher than all arithmetic operations. So be careful when you use it with other operations.

```java
System.out.print((char) 'a' + 1);  // print 98, Java will first execute manual-conversion, then +, thus the manual-conversion does not affect anything
System.out.print((char) ('a' + 1));  // print 'b', Java will first execute +, then manual-conversion, thus the manual-conversion affect the result
```

Manual conversion is also called *casting*.

`boolean` cannot be converted to any other primitive datatypes.

## 3. Keep Code Clean 3

1. A white space should be added after the Manual-conversion target datatype

   ```java
   (int)3.14   // unclean
   (int) 3.14  // clean
   ```

2. Only add `()` to change the priority when it is required

   ``` java
   int num1 = (1 + 2);   // unclean
   int num2 = 1 + 2;     // clean
   int num3 = (1 + 2) * 3;   // clean
   ```

3. If you can use `a++` or `++a`, do not use `a += 1`, and if you can use `a += b`, do not use `a = a + b`.
