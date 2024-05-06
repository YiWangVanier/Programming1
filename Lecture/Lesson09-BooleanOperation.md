# Lesson09-BooleanOperation

A boolean variable can only be `true` or `false`. Boolean values have their own operations.

## 1. Comparing

When comparing two values, the result is boolean, e.g.: `3 < 5` is `true`, while `5 < 3` is `false``.

Java supports six comparing operators:

1. `>`: greater than
2. `>=`: greater or equal
3. `<`: less than
4. `<=`: less or equal
5. `==`: equal
6. `!=`: not equal

These six comparing operations can be applied to most primitive data type values. But booleans can only be compared with `==` and `!=`.

Also, comparing double values by using `==` can sometimes cause problems, cause `==` compares if two values are exactly the same or not, when diving double values, the result may not be accurate, and using `==` to compare the result may always result in a `false``. A better way to do this in this situation is to use subtraction to compare the difference between the two double values and consider the two values equal if the difference is small enough.

```java
// Example of comparing two double values, expecting true, but results false
System.out.print(10.0 / 3 == 3.33333);              // false

// Compare the difference 
Systemm.out.print(10.0 / 3 - 3.33333 < 0.00001)     // true
```

## 2. And, Or, Not

Two boolean values can be joined by using `and`, `or`, and `not`.

### 2.1 And

And (`&&`) joins two boolean values and only gets `true` if both of them are `true`, else `false`. For example: "If you are no younger than 16 and you have your driving license, then you can drive" can be written as `age >= 18 && hasADriveingLicence`.

The truth table of `&&` is:

| `A` | `B` | `A && B` |
|---|---|--------|
|F|F|F|
|F|T|F|
|T|F|F|
|T|T|T|

### 2.2 Or

Or (`||`) joins two boolean values and only gets `false` if both of them are `false`, else `true`. For example: "If you are younger than 16 or no younger than 65, then you can enter the museum for free" can be written as `age < 16 || age >= 65`.

The truth table of `||` is:

| `A` | `B` | `A \|\| B` |
|---|---|--------|
|F|F|F|
|F|T|T|
|T|F|T|
|T|T|T|

### 2.3 Not

Not (`!`) simply reverse a boolean value, from `true` to `false` or from `false` to `true`. For example: "If you are neither younger than 16 nor no younger than 65, then you must pay" can be written as `!(age < 16 || age >= 65)`.

The truth table of `!` is:

| `A` | `!A` |
|---|---|--------|
|F|F|F|
|F|T|T|

Notice:

`>`, `>=`, `<`, and `<=` can not be used to compare boolean values. Thus if we want to represent that `age` is greater or equal to `18` and lower than `65`, we have to make sure the values around `&&` are both boolean.

Both `&&` and `||` can only be used to join boolean values.

```java
18 <= age < 65          // wrong, same as `true < 65` or `false < 65`
grade == 'A' || 'B';    // wrong, same as `true || 'B` or `false || 'B'`

age >= 18 && age < 65           // correct
grade == 'A' || grade == 'B'    // correct
```

## 3. Short Circuit

For `A && B`, we know that the result would be `true` only if both `A` and `B` are `true`. If `A` is `false`, then the value of `B` will not affect the result. In this case, Java will ignore the value of `B` or any operation related to `B`. This is called a *short circuit*.

The same for `A || B`, we know that the result would be `false` only if both `A` and `B` are `false`. If `A` is `true`, then the value of `B` will not affect the result. In this case, Java will ignore the value of `B` or any operation related to `B`.

In short, for `&&` and `||`, if the first value can determine the result, then Java will skip the second value and the related operation.

```java
// 3 < 1 is false, the result of && will be false without check the second part, thus the ++ on the second part will be ignored, num will still be 3 after the statement.
int num1 = 3;
System.out.print(num1 < 1 && num1++ > 0);

// 3 > 5 is true, the result of || will be true without check the second part, thus the ++ on the second part will be ignored, num will still be 3 after the statement.
int num2 = 3;
System.out.print(num2 > 5 || num++ > 0);
```

## 4. DeMorgan's laws

The `!` operation sometimes can decrease the clarity of the code. like in the previous example, "If you are neither younger than 16 nor no younger than 65, then you must pay" can be written as `!(age < 16 || age >= 65)`. It may take a while for people to understand the logic. *DeMorgan's law* provides a solution to this.

DeMorgan’s laws were developed by Augustus De Morgan in the 1800s. They show how to handle the negation of a complex conditional, which is a conditional statement with more than one condition joined by an `&&` or `||`.

`!(A && B)` is the same as `!A || !B`.
`!(A || B)` is the same as `!A && !B`.

So to apply DeMorgan's law, you can remove the `not`, and then reverse all boolean operators in its range, e.g.:

```java
!(age < 16 || age >= 65)
// can be written as
age >= 16 && age < 65
```

where `!` is removed, and then `<` is reversed as `>=`, `||` is reversed as `&&`, `>=` is reversed as `<`.

Notice: the opposite of `>` is `<=` instead of `<`, the opposite of `<` is `>=` instead of `>`, and the opposite of `=`=` is `!=`.
