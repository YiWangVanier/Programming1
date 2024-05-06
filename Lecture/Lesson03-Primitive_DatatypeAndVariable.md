# Lesson04-Primitive Datatype and Variable

## 1. Keywords

A keyword is either a reserved word, that has a predefined meaning in the Java language.

In Java syntax, all code is *case-sensitive*, and this includes keywords. As we'll soon see, an `int`, all in lowercase, is not the same as `Int`,
with a capital `I`. Here, an `int`, (all in lowercase) is a keyword in Java.

You cannot redefine a keyword again. All keywords are highlighted in orange color in IntelliJ.

We have seen some of them in the `Hello World` project:

1. `package`: indicates which package the file belongs to. Packages are used to classify classes. When the project goes big, you don't want to put all files in the same package.
2. `public`: is an *access modifier*, an *access modifier* indicates which parts of code can access a particular element. Here, a `public` member can be accessed by anything from any class in the same project.
3. `class`: indicates the following structure is a *class*, you will see other structures such as `interface`, `enum`, etc. in the future.
4. `static`: indicates the following element is `static`. A `static` element belongs to a class, while a non-static element belongs to an object. We will see more examples in the future.
5. `void`: indicates the method returns nothing.

## 2. Variables

Variables are a way to store information on our computer.

Variables that we define in a program, can be accessed by a name we give them, and the computer does the hard work, of figuring out where they get
stored, in the computer's random access memory, or RAM. For example:

```java
int num = 5;
```

Here we defined a variable and gave it a name `num`, a value of `5` is assigned to it, after that, we can directly use `num` to access the value.

A variable contains three parts:

1. data type
2. name
3. value

## 3. Primitive Data Type

When defining a variable, we have to specify what data type it has, is it an integer, a floating value, or it is just a character? Primitive data types are predefined in Java, and there are *eight* of them. All primitive data types are keywords.

| Data Type | Value    | Size |
| --------- | -------- | ---- |
| byte      | integral | 1    |
| short     | integral | 2    |
| char      | integral | 2    |
| int       | integral | 4    |
| long      | integral | 8    |
| float     | floating | 4    |
| double    | floating | 8    |
| boolean   |          |      |

Each primitive data type has a corresponding *wrapper class, e.g., `int` -> `Integer`, `double` -> `Double`, `boolean` -> `Boolean`, we will see them in the future.

### 3.1 Integral

The first five are used to store an integer value, for example

```java
byte num1 = 5;
short num2 = 6;
int num3 = 7;
long num4 = 8L;
```

The only difference among them is the sizes. A `byte` variable will only hold `1` byte space in the memory, thus it only contains `8` bits (`0`s and `1`s), the first bit is used to indicate if the number is positive (`0`) or negative (`1`), then `7` bits for the value. Thus the range of a byte variable is `-128` to `127`. Which means you cannot put a number bigger than `127` into it.

```java
byte num = 128;   // Error, 128 is too big for byte
```

`Short` takes `2` bytes, `int` takes `4` bytes, and long takes `8` bytes. By default, we use `int` for an integral value. Only when the number is too big, then we use `long`. The value should followed by an `L`. In practice, we barely use `byte` or `short`.

`char` is a special data type when we store a character in a computer, such as `'a'`, `'9'`, and `'!'`, it has to be converted into a number first, cause numbers can be converted into binary numbers easily. We can use the American Standard Code for Information Interchange (**ASCII**) table to find the mapping. For example, `a` is represented by `97`, and `9` is `57`. You can easily find the ASCII table online, but there is no need to memorize it. A char value is defined between a pair of single quotes `''`. Remember, `'0'` is different than `0`.

```java
// the following two statements are the same
char character1 = 'a';
char character2 = 97;
```

There are some special values we can directly use:

| Value                        | Meaning                             | Example                                    |
| ---------------------------- | ----------------------------------- | ------------------------------------------ |
| `Integer.MAX_VALUE`        | the maximum an `int` can reach    | `int num = Integer.MAX_VALUE;`           |
| `Integer.MIN_VALUE`        | the minimum an `int` can reach    | `int num = Integer.MIN_VALUE;`           |
| `Double.MIN_VALUE`         | the maximum a `double` can reach | `double num = Double.MAX_VALUE;`         |
| `Double.MAX_VALUE`         | the minimum `double` can reach   | `double num = Double.MIN_VALUE;`         |
| `Double.POSITIVE_INFINITY` | positive infinity                   | `double num = Double.POSITIVE_INFINITY;` |
| `Double.NEGATIVE_INFINITY` | negative infinity                   | `double num = Double.NEGATIVE_INFINITY;` |
| `Double.NaN`               | not a Number                        | `double num = Double.NaN;`               |

### 3.2 Floating

If you want to store a floating number in a variable, you can use the floating type. There are two floating types:

* `float`: less accurate
* `double`: more accurate, by default.

We barely use `float` in practice, but if you need to, the value should followed by an `f``

```java
float num1 = 3.14f;
double num2 = 3.14;
```

### 3.3 Boolean

`boolean` is a special data type, that only has two values: `true` and `false`, we will see the boolean data type in the future.

```java
boolean isCorrect = true;
boolean pass = false;
```

The result of comparing two values to check if they are the same is a boolean:

```java
boolean eq = 1 == 1.0;  // true since 1 equals 1.0 
```

Notice: String is not a primitive data type, all primitive data types are in lowercase, If the first character is uppercase, such as `String`, `Integer`, `Boolean`, or `Double`, it is a class.

## 4. Naming System

I have explained how to name a variable, but just a quick review again. A variable should be a noun, you can put adjectives before it, and sometimes a number after it, e.g.:

```java
int num1;
int num2;
double avgScore;
double finalScore;
double discountRatio;
```

Technically we can put the number among the name (except the very beginning), but it is not usually seen in practice.

The name should be self-documenting, which means the name should indicate what the variable is about. Thus always avoid using unclear names such as `x` and `y`.

You can also use abbreviations but DO NOT create abbreviations by yourself. For example, you can use `avg` for average, `str` for string, `idx` for index, and `num` for number. But do not expect others can understand you if you write `fp` for the final price.

## 5. Initialization

A variable can be (but not obligated) initialized after it is created (declared). You can create a variable without giving it a value immediately, but give a value to it later.

```java
int num1 = 5;  // initialize num1 as 5
int num2;  // num2 has no value yet

// other code
System.out.print(num2); // Error, num2 has no value yet, cannot read it

num2 = 10;  // num2 is assigned after it is created
System.out.print(num2); // print 10
```

One cannot read the value of a variable until it is initialized.

You can always change the value of a variable.

```java
int num = 5;
num = 6; // change the value of num
num = 7; // change the value of num again
num = 10; // change the value of num again
```

You may see someone declare variables of the same data type in the same row, but I personally do not recommend it.

```java
int num1 = 3, num2 = 5, num3 = 10;  // not recommended

// recommended
int num1 = 3;
int num2 = 5;
int num3 = 10;
```

## 6. Scope and Lifetime of A Variable

The *scope* of a variable refers to the areas or sections of the program in which the variable can be accessed, and the *lifetime* of a variable indicates how long the variable stays alive in the memory.

If a variable is defined in a method, it is called a *local variable*, which means it only exists in that method,

A local variable exists until control leaves the block in which it is declared.

```java
public static void main(String[] args) {
    int num1 = 5; // create a local variable in main
    int num1 = 10;  // error, trying to create another num1 in the same scope

    System.out.print(num2);
    // reach the end of the method, after that num1 will be destroyed
}
```

## 7 Escape Sequence

Some characters on the keyboard cannot be directly put in a string or a char, for example, the `enter` key. Or If you want to put a `"` character in a string, that would cause an error.

```java
// error, the first " will match with the second ", then sure"" is invalid
String str = "He said "sure"";

// error, the first ' will match withe the second ' instead of the third '
char character = ''';

// error, directly type enter cannot store it into a string
String str = "
                 ";
```

We can use *escape sequence*s to solve this problem. An escape sequence is a combination of characters that has a meaning other than the literal characters contained therein; it is marked by one or more preceding (and possibly terminating) characters.

| Combination | To Represent |
| ----------- | ------------ |
| `\n`      | `enter`    |
| `\t`      | `tab`      |
| `\"`      | `"`        |
| `\'`      | `'`        |
| `\\`      | `\`        |

```java
String str = "He said \"sure\"";  // the first " will match with the last " since the second " and the third " have a \ in front
char character = ''';    // the first ' will match with the last ' since the second ' has a \ in front
String str = "\n";    // a line breaker is stored in str
String path = "C:\\Users\\yi";   // the path is C:\Users\yi
```

## 8. Keep Code Clean 2

### 8.1 Appropriate Names

Always name your projects, classes, methods, and variables with meaningful names. Bad names will bring misunderstanding and ambiguity to your code

### 8.2 Add Spaces

Just like written in English, you must put spaces around each word so readers can understand, when writing Java code, you need to put one space around each keyword, and operators that take two values.

```java
// int num1 = 5;   // clean
int    num1 = 5;   // unclean
int num1=5;   // unclean
int num1 =5;    // unclean
int num1 = 5 ;   // unclean
```

### 8.3 Add Empty Lines

Adding some empty lines can help to increase the clarity of your code, but of course, you only need to add them in the appropriate places, thus the code can be grouped into different parts, e.g.:

```java
double num1 = 5;
double num2 = 10;
double num3 = 15;

double sum = num1 + num2 + num3;
double avg = sum / 3;

System.out.println("The sum is " + sum);
System.out.println("The average is " + avg);
```

There are two empty lines added in the example above, which groups the code into three parts, the first part declares some variables, the second part calculates the results, and the third part prints the results. In this case, the code is much easier to read.

**Important: Always put ONE empty line at the end of a file.**

### 8.4 Avoid Using Magic Number

The meaning of some numbers is easy to figure out, such as `60` and `24` for a clock, and thus can be used directly, while some others are not, for example, a tax ratio of `0.145`, directly using the value in your code may cause misunderstanding, then it is called a magic number since there is no explanation of it, just like magic. Using magic numbers in your code decreases the clarity of your code. A better way to do this is to create a variable with a meaningful name for it.

```java
// bad since 1.145 is a magic number
double originalPrice = 3.99;
double finalprice = originalPrice * 1.145; 

// good since 1.145 is assigned to a variable with a meaningful name
double originalPrice = 3.99;
double taxRatio = 0.145;
double finalprice = originalPrice * (1 + taxRatio); 
```

## 9. Auto-completion

It is always a good idea to use auto-completion while coding. Modern IDEs can figure out what you are trying to type if you just give a hint to it, e.g.:

If you have already defined a variable `avgScore`, then if you type `a`, a pop-up menu will come out, and you can press enter to auto-complete the variable. This trick reduces the chance of having a type in your code and accelerates the programming speed.

If you have multiple variables that start with `a`, e.g.: `avgScore`, `address`, `apple`, then you can type a little bit more, i.e.: `av`, and the menu will only contain `avgScore`, or type `a` then use arrow keys to choose the right name to complete.
