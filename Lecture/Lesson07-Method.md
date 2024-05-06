# Lesson07-Method

## 1. Avoid Super Method

For developers, "super" is not a good word, when someone says "super method" means the method is too big. When a method is too big, it is difficult for people to understand and maintain.

Previously we have written everything in the `main()`, as the task gets more complicated, the `main()` method would grow into a super method. Besides, `main`()` does not sound like a good name for a method, cause you cannot figure it out what the method is used for. The same as variables, the names of methods should also be self-documented.

`main()` should only be used as the entrance of the project, you should use it as a pipeline, which should not contain too many details. All details should be written in other places, i.e.: other methods.

## 2. What Are Methods

A method in Java is a collection of statements that takes some parameters, performs some specific task and *return*s the result to the caller. A Java method can perform some specific task without returning anything. Java Methods allows us to reuse the code without retyping the code. In Java, every method must be part of some class.

For example, if I need someone to buy me a cup of coffee, that could be understood as a method cause it is a collection of actions that performs a specific task. To complete the task, I need to give it some money, and the amount of sugar, and milk I need for the coffee, these inputs are called parameters. The one needs to take the money, go to the shop, wait in a queue, communicate with the staff, wait until the coffee is ready, take the coffee, add the sugar and milk if they are mentioned in the requirements, and all these steps are hidden in the method, in the end, it has to give the coffee back to me, which is called the `return` value of the method.

### 2.1 Defining A Method

A method needs to be defined first before it is used. If you just call the method `orderCoffee()` without even defining it, Java does not understand what to do about the calling.

The definition of a method contains two parts, the `header` and the `body`.

#### 2.1.1 Method Header

The `header` provides the first glance of the methods, like a brief view, based on which, we can recognize which part of the code can access this method, what parameters it requires, what is the method used for, and what kind of value it can return. The `body`, on the other hand, contains the detailed behaviors of the method.

The syntax of a method definition is:

```java
accessModifier static/non-static returnType methodName(formalParameterList) {
    body
}
```

where

1. `access modifier`: a keyword to indicate which piece of code can use the following code.
   1. `public`: any piece of code can use the following code.
   2. `protected`: only the code in the current package or the same hierarchy can use the following code.
   3. default (with no keyword): only the code in the current package can use the following code.
   4. `private`: only the code in the current class can use the following code.

    We will only focus on the `public` and `private` in this course.

2. `static`: a method can be `static` or `non-static`, more details will be explained in the OOP chapter.
3. `return type`: the return type indicates what data type a method should return, for example, a method to calculate the average score should return a `double`, a method to reverse a string should return a `String`, a method to buy a cup of coffee should return a `Coffee`. You may also hear some developers call a method that returns `int` as an `int` method, a method that returns `boolean` as a `boolean` method, etc. If a method does not need to return anything, then the return type should be `void`. For example, `print()` is a void method, it outputs values on the console without returning any value in the code.
4. `method name`: the name of a method should be self-documented, which means the name should explain what the method is for. Usually, the name of a method contains a verb, such as `calcAvgScore` instead of `avgScore`, the second one sounds more like a variable. Adding a verb to the method name leads to less misunderstanding. A boolean method is usually called `isXxxx` or `areXxxx` such as `isEmtpy()`. The name should still follow the `camel case` rule.
5. `formal parameter list`: If a method requires some inputs, they need to be designed before the method is used. For example, to order a cup of coffee, you have to indicate the amount of sugar and milk. These two parameters are called formal parameters cause we just know the amount of sugar and milk are essential but the real values are unknown.

Usually from the header, we can figure out what is the method used for and what we need to input when using it.

```java
// methods headers
// receive a string, reverse it and return the reversed string
public static String reverse(String strIn) 

// receive a string, count and return the number of vowels in it
public static int countVowel(String str) 

// receive a string, check if a string contains digits
public static boolean containsDigit(String str)

// receive a number, find it's biggest primer 
public static int findPrimer(int num) 
```

#### 2.1.2 Java Doc

For each user-defined method, it is always recommended to write a Java documentation for it to help others understand what it is used for. Once you finish the header of a method, you should create the Java doc for the method immediately.

The Java doc starts with `/**` and IntelliJ will automatically generate the Java doc structure for you based on the header of the method.

The Java doc always starts with a short description of what the method is about to do, and it should start with a verb without any subject such as `"This method"` or `"it"`.

If the header shows the method requires any parameter, the `@param` tags will be generated, and you will have to also explain what are parameters, even though the names could be self-documented already.

If the header shows the method has a return value, the `@return` tag will be generated, and you will have to also explain what will be returned.

```java
/**
 * reverses a string
 * @param strIn the input string
 * @return the reversed string
 */
public static String reverse(String strIn)
```

#### 2.1.3 Method Body

The body of a method contains statements to complete the task. In the method body, even though the values of formal parameters are unknown, we can directly use them.

```java
/**
 * reverses a string
 * @param strIn the input string
 * @return the reversed string
 */
public static String reverse(String strIn) {
    String strOut = "";
    // we can directly use strIn even though we do not know its value yet
    for (int i = strIn.length() - 1; i >= 0; i++) {     
        strOut += strIn.charAt(i);
    }
    return strOut;
}
```

### 2.2 Calling A Method

Defining a method will not affect your code unless it is called. You can understand it as if you bought a new machine, it will not do anything unless you power it on.

Once a method is defined, you can call the method through the method name with `actual parameters`. For example, if the `public static String reverse(String strIn)` is defined, we can call it to use it.

```java
public static void main(String[] args) {
    System.out.print(reverse("hello"));
}
```

In this example, the `print()` method is first called, however, Java does not know what to print yet, cause `reverse("hello")` is not a value that Java can directly use, so Java will have to pause the `print()` and call the method `reverse("hello")` instead. When `reverse()` is called, an actual parameter `"hello"` is passed to it. Java will leave all current parameters alone, and jump to `reverse()` only with `"hello"`. Once Java jumps to `reverse()`, it will assign the value `"hello"` to the formal parameter `strIn`, thus `strIn = "hello"`, and then execute the code in `reverse()`. In the end, when Java reaches either the keyword `return` or the end of the method, it will release all variables in `reverse()`, only bringing the value of `strOut` back to the place where it is called, i.e.: `System.out.print(reverse("hello"));`, and use the returning value to replace the method call, i.e. `System.out.print("olleh");`. Now since Java knows what value to print, it will execute the `print()` method and print `"olleh"` in the console.

## 3. Overload Methods

Assume you have a method to repeat a string for a certain time, it can be written as

```java
/**
 * repeats a string for a certain time
 * @param strIn input string
 * @param time repeat time
 * @return the repeated string
 */
public static String repeat(String strIn, int time) {
    String strOut = "";
    for (int i = 0; i < time; i++) {
        strOut += strIn;
    }
    return strOut;
}
```

Then in practice, you realize that in many situations, you need to repeat the string just one time, for example, `"hello"` -> `"hellohello"`. You can use the previous method, but every time, you need to pass the second parameter of value `2`, which is annory.

It would be easier if you could have a method that only requires one parameter as the input string, and automatically repeats it `2` times. And since both the previous method and this new method repeat strings, their names should be the same, so you do not have to memorize what method to call each time.

Java provides a solution for it, which is called the `overload method`. Overload methods mean more than one method in the same class that has the same method name, but different parameter lists. e.g.:

```java
/**
 * repeats a string for a certain time
 * @param strIn input string
 * @param time repeat time
 * @return the repeated string
 */
public static String repeat(String strIn, int time) {
    String strOut = "";
    for (int i = 0; i < time; i++) {
        strOut += strIn;
    }
    return strOut;
}

/**
 * repeats a string for a two time
 * @param strIn input string
 * @return the repeated string
 */
public static String repeat(String strIn) {
    return strOut + strOut;
}
```

Now both of these two methods are in the same class, having the same method name, but their parameter lists are different, the first one takes two parameters, while the second one takes only one parameter. If you call a method `repeat("hello", 2)`, Java knows that you are calling the first method since two values are passed, one is `String` while the other is `int`, which perfectly matches the parameter list of the first method. If you call a method `repeat("hello")`, Java knows that you are calling the second method since only one `String` value is passed, which perfectly matches the parameter list of the second method.

Overload methods allow us to write different versions of a method, and some of them may contain some default values for some parameters, e.g. `repeat(String strIn)` is a specified version of `repeat(String strIn, int time)` where `time` equals `2`.

Assume we have a method `public static Coffee buyCoffee(int size, int sugar, int milk)` that requires the user to indicate the size of the coffee and the amount of sugar and milk to add.
There could be another overload method `public static Coffee buyCoffee(int sugar, int milk)` that only requires the user to indicate the amount of sugar and milk to add and give a default size of `median` if the user does not specify the size.
There could be another overload method `public static Coffee buyCoffee()` that requires no parameter and will provide a coffee with `median` size, no sugar and no milk.

```java
    // the user indicates the size, the amount of sugar and milk
    public static Coffee buyCoffee(int size, int sugar, int milk)

    // median size, the user indicates the amount of sugar and milk
    public static Coffee buyCoffee(int sugar, int milk)

    // median size, no sugar, no milk
    public static Coffee buyCoffee()
```

## 4. The Scope And Lifetime of Variables In A Method

Variables in a method are called `local variables` cause the scope of them is the method they belong to. Parameters are all local variables. Local variables will not affect other methods, for example:

```java
// str and num are local variables in m1, which only will affect m1, but not m2
public static void m1(String str) {
    int num = 3;
    // other code
}

// str and num are local variables in m2, which only will affect m2, but not m1
public static void m2(String str) {
    int num =10;
    // other code
}
```

All local variables will be released(destroyed) when the method is returned.
