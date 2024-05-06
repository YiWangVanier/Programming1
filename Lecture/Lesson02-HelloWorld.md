# Lesson02-HelloWorld

## 1. What is HelloWorld

It is always been a tradition, when you are learning a new programming language, to create a simple program that outputs the text "Hello World".

This lets us test all the necessary parts, to create a successful program, with very little investment of time, or knowledge of the language.

## 2. Project, Class, Statement

In an IDE, we create a project for a specific task. A project may contain many files (classes, interfaces, enum, etc.). In this semester, you will see files as classes, and next semester you will see files can also be interfaces. A class can contain many methods and statements.

You can understand it as cooking a wonderful meal for your family is a big project, which contains different dishes (classes), and each dish may contain more than one material.

A statement is like a complete command to be executed. It can include one or more expressions. A statement must end with `;`, e.g.: `int num = 3;`

In IntelliJ, you can create a new Project, give it an appropriate project name (describe below), relocate the project to a place that you can easily find (Desktop is recommended), and make sure the language is `Java`, the Build system is `Maven`, JDK is `17` or `21`.

The build system will not affect the Java language, but it affects the structure of a project. We will see more details about `Maven` later in this course.

If you check the `Add sample code` option, a `Main` class will be generated for you, with a short piece of sample code in it. But DO NOT check the `Generate code with onboarding tips` option.

Expand the `Advanced Settings`, and change the `GroupId` from `org.example` to `org.yourname`, e.g.: `org.yi`. The `GroupId` will determine the name of the default package of your project. A package is just a directory. Grouping different files into different packages can help to keep your code clean and organized.

## 3. Naming System

In Java, you have to give names to many things, a project, a class, a method, a variable, etc. There are naming rules to be followed. Always follow the standard to name something. For example, a project, a class, and a variable should always be a noun. You may add an adjective before it, e.g.: `Dog` or `HappyDog`. When the name contains more than one word, there should be NO space between them, but capitalize the first character of a word. This is called the *camel case*. For a project or a class, the first character should be uppercase, while for a variable or a method, the first character should be lowercase. A method name should be like a verb. Following are examples:

* Project or Class: `Dog` `HappyDog`
* Variable: `dog` `happyDog`
* Method: `equals` `toString`

## 4. Project Structure

If we select `Maven` as the project build system, then the structure of the project would look like:

``` bash
Project
|-.idea
|-src
| |-main
| | |-java              // write code in this folder
| | |-resources
| |
| |-test
|   |-java
|   |-resources
|
|-target
|-.gitignore
|-pom.xml
```

where

* `.idea` is a directory for IntelliJ project settings, and we will not touch it.
* `src/main/java` is the directory for the source code
* `src/main/resources` is the directory for external files that your source code may need, usually data files
* `test/main/java` is the directory for source code for testing
* `test/main/java` is the directory for testing data
* `target` is the directory for generated files, such as `.class` and `.jar`
* `.gitignore` is a file that lists all files that we do not want to update to the repository when using git version control.
* `pom.xml` is the `maven` project config file.

This semester we will first focus on `src/main/java`, and then introduce `test/main/java`, `.gitignore`, and `pom.xml` after.

## 5. `main()` method

A project may contain many files, and each file may contain many methods, like a meal, if it contains many dishes, we need to find which one to start with, certainly not the dessert. Each part is indicated by a pair of curly brackets `{}`.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Java always starts the project at `main()`, when you see a word followed by a pair of brackets `xxx()`, it indicates that it is a method. A method is a collection of statements to perform an operation, e.g.: if I want to ask someone to clean a table, there could be a method `cleanTable()`, which may require a few steps, such as removing all items on the desk, wetting the mop, cleaning the table, putting all items back on the table.

The `String[] args` is the formal parameter of `main()`, `args` stands for `arguments`.

You can also use `psvm` + tab to create a `main()` by yourself. `psvm` are the four starting characters of `main()`: `public`, `static`, `void`, and `main`.

Technically a project can have `0` or `1` or more than one `main()` method, but we will start with `1` `main()`.

## 6. `Sout`

The only statement we need to put for this project is

```java
System.out.println("Hello World");
```

This statement calls the method `System.out.println()` in JDK, which will print the context in the console. The context is passed to the method between the `()`.

`println` stands for "print line", if you remove the `ln`, then you will have `System.out.print()`, which will also print the context in the console, but with no line breaker in the end.

If you use IntelliJ, you can use the shortcut `sout` + `tab` to generate the `System.out.println()` statement, that is the reason why this chapter is called `sout.`

Here, `"Hello World"` is a string, and in Java, a String is defined between a pair of double quotes `""`. In Java, a string cannot be changed.

## 7. Executing Code

Once the code is completed, we need to execute it to see if the result is the same as we expected. We can click the green triangle button to execute the code or use the short-cut `shift` + `F10` on Windows.

Here `Run` or `executing` is an umbrella term that contains many steps, it will have to link the code from different files, compile them to the binary code, then execute them, and show the result in the console.

A black window called console would be shown at the button of the IDE, where you can see the result `Hello World` printed.

The sentence `Process finished with exit code 0` indicates the code is executed with no error. On the other hand, if the exit code is not `0`, that means there is something wrong with your code.

## 8. Comments

Comments are text ignored by the Java compiler. You can write comments to explain your code, so others or yourself can understand it better.

There are three different comments in Java:

### 8.1 Single-line Comment

Single-line comments are the most frequently used comment, anything after  `//` till the end of the row will be considered as a single-line comment. You can put it just above the code you want to explain, or on the right of a short statement.

```java
int finalGrade;   // the final grade the student gets
int avgScore;   // the average score the student gets

// calculate the average score
avgScore = (score1 + score2 + score3 + score4) * assignmentWeight + (score5 + score6) * examWeight;
```

Another way to use single-line comments is to temporarily hide some of your code. Assume you have written a piece of code, but the result is not what you expected, so you know there is so mistake in your code. At this moment, you may delete some of your code, and re-write it, but what if the code you re-write is still not good, and you want to go back to the previous version that you have deleted and try something else? It would be difficult since the previous version has already been deleted.

A better way is to comment on the code instead of deleting them. The code is still there, but the compiler will ignore it, so you are free to re-write it. If you want to bring the code back, you just need to uncomment (remove the `//` in front) it, and the original code is back.

In IntelliJ, the shortcut to comment/uncomment code is `Ctrl` + `/`. You can use the shortcut for more than one line.

### 8.2 Multi-line Comment

A multi-line comment starts with `/*` and ends with `*/`. Any text between `/*` and  `*/`* will be ignored by Java. Usually, it is used if the comment is long.

```java
/*
This is a long comments that may cross multi-lines
I am still a comment
Me too
*/
```

### 8.3 Documentation (Java-doc)

Documentation only exists on a Class/Interface/Enum level or a method level to explain what the class/interface/enum, or method is about. Documentation starts with `/**` and ends with `*/`. It is always a good idea to write documentation for every class/interface/enum and method, unless it is too straightforward, for example `main()`.

The following shows an example of a documentation of a method.

```java
/**
 calculates the sum of elements of a double array.
 @variable nums the input double array
 @return the sum of the elements of the input double array
 */
public static double calcSum(double[] nums) {
     // code inside
}
```

We will see more about documentation when we learn the method and class.

## 9. Keep Code Clean 1

It is extremely important to keep your code clean. The code may be correct, but if it is not clean, it causes big issues for others to understand your code, and maintain the code in the future. Like a novel book, no matter how interesting it is, the author never breaks a line and writes everything in the same paragraph, with no spaces between each word. Technically the meaning remains the same, but no one wants to really read it.

### 9.1 Indent

There are many rules to be followed to keep your code clean. One rule for now is to indent `B` for one level from `A` if `B` is part of `A`. For example, methods are part of a class, thus there should be one level of indent of method from a class; statements are part of methods, so there should be one level of indent of statements from methods.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

### 9.2 Avoid Long Line Code

You may see a vertical line on the right of your editor, which is a guideline to help you to keep your code short. Usually, it can be `80`/`100`/`120` characters wide. Try to keep your code on the left of it. If one statement is long, you can try to write it into two lines and indent two levels for the unfinished part.

```java

System.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7
        + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15);
```

## 10 How to Find Your Project

Once you have created a project in IntelliJ, you can find it stored on your computer. If you saved the `HelloWorld` project on the Desktop, you should find a directory `HelloWorld` on the Desktop, which contains the structure the same as the structure shown in Chapter 4. The project contains many files generated by IntelliJ, only the source code in the `source/main/java` is written by you. When submitting homework, only submit the source files, NOT the entire project.
