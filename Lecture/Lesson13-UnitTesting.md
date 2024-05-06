# Lesson13-UnitTesting

## 1. Testing Your Code

Once you have written a method, a class, or a project, you always have to check if your code works or not. There are many ways to do so.

1. Test your code in the `main()` method. This is what we have done previously, to print something in the `main()`, and check if the printed result is the same as our expectation. The `main()` is also called the `driver method`, and the class containing the `main()` method is called the `driver class`. Testing your code in the driver class is straightforward, and the benefit is that if the operation contains many steps, you can test the entire pipeline in the driver class step by step. However, the disadvantage of testing in the `driver` class is also significant. Usually, you can only test one case in the driver class. But in practice, your code may face many situations, and most of them are not tested in the driver class. For example:

```java
/**
 * checks if a year is a leap year
 * @param year the input year
 * @return if the year is a leap year
 */ 
public static boolean isLeapYear(int year) {
    return year % 4 == 0;
}

public static void main(String[] args) {
    System.out.print(isLeapYear(2000));         // true
    System.out.print(isLeapYear(2002));         // false
} 
```

The method `isLeapYear()` simply mod the year by `4` and compares the result with `0`. Then in the `main()` it was tested with input `2000`, and the result is `true`, seems the result is correct. Then `2002` is also tested and the result is `false`. Since the two input-output pairs are the same as expected, we may consider the method `isLeapYear()` is well written.

However, the fact is that the `isLeapYear()` is not correct, the real algorithm for `isLeapYear()` is much more complicated, cause a year can be divided by `4` is not necessary to be a leap year, The real algorithm is "Every year that is exactly divisible by `4` is a leap year, except for years that are exactly divisible by `100`, but these centurial years are leap years if they are exactly divisible by `400`." For example, `1700` is not a leap year, cause it can be divided by `100` and cannot be divided by `400`, while `1600` is a leap year because it can be divided by `100` but can also be divided by `400`.

Our previous code won't work for `1700`, and will consider it as `true` cause it just checks if the year can be divided by `4`.

In this case, we say our method is not robust, which means it is not completely wrong, but also not completely right. Sometimes it works and sometimes it does not. This is risky and may cause bugs in practice.
2. Unit testing. A project contains many methods, If each method itself works perfectly, then the combination should be working too. Because it is testing each "unit" (method), it is called unit testing. Unit testing does not test the entire project as a whole but each component instead.

A method should be tested with different inputs to make sure it works in different situations. For example:

To check if a String is a palindrome, i.e. a word, phrase, or sequence that reads the same backward as forward, e.g., "madam" or "nurses run", we need to test if some general cases, such as "madam" which returns `true`, while "hello" should return `false`. We should also test some special cases, such as: "MAdam", "a", or even "", we need to test words with both an even length and an odd length, such as "madam" and "noon".  

In sum, unit testing is to test each single method in different test cases (TCs), which makes sure a method is robust. It is very common to have five, six or even more TCs for one single method in practice.

## 2. Test-driven Developmenet (TDD)

Test-driven development (TDD) is a software development practice that emphasizes writing tests before writing the actual code. It follows a cyclical process of writing a failing test, writing the minimum code to make the test pass, and then refactoring the code.

When we have to write a method, we need to first understand the requirement of the method, e.g.: what the method is used for, does it require any parameter, and what its return type should be. Once we have the answers to all these questions, we can design the header of a method.

Instead of directly writing the body of the method, TDD requires us to design TCs for the method. And since you have not implemented any logic yet, your thoughts will not be biased.

If calling the method with an input value, the method returns the expected result, we say the TC is passed. The goal of TDD is to make sure all TCs are passed. If so, our code is robust, or else, we need to find which TCs failed, analyze the problem, modify the code, and re-test them again, until all TCs are passed.

## 3. Procedures of TDD

1. Understanding the requirement and write the method header

    Take the method `isPalindrome()` for example, we can first come out a header with an empty body of the method.

    ```java
    public static boolean isPalindrome(String str) {
        return false;       // we can return a default value which match the return type first
    }
    ```

2. Designing input-output pairs

    To make sure the method works in different situations, we need to come out some with pairs of input-output:
    1. "hello" -> `false`
    2. "madam" -> `true`
    3. "MAdam" -> `true`
    4. "noon" -> `true`
    5. "wow wow" -> `true`
    6. "a" -> `true`
    7. "" -> `true`

    Especially the 6th and 7th TCs, which are special cases, that usually we forget.

3. Adding `junit-jupiter` dependency

    One popular testing framework for Java unit tests is called `Junit`, the latest version is `5`. which is also called `Junit Jupiter`. Search for this keyword and you should find the following dependency:

    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>       <!--version could be different-->
    </dependency>
    ```

    Add it to your `pom.xml` file and load the maven dependency.

4. Creating the testing class

   Once `Junit Jupiter` is added to your project, go to the class that contains the methods you want to test, right-click on the class name and select `Show Context Actions`. From the menu, select `Create test`. In the pop-up menu, select the methods that you want to test. This will create a new class in the `test` directory in your project, where all test-related source code and resources should be located. The standard name for Junit testing classes is `XxxTest` with a suffix `Test`.

    ```java
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

    class MainTest {

        @Test
        void isPalindrome() {
        }
    }
    ```

    The annotation `@Test` indicates the following method `void isPalindrome()` is a test method.

5. Translating the designed input-output pairs into Java code

   A testing method does one thing, it prepares an input, calls the tested method with it, saves the return result, and compares it with an expected value.

    ```java
    @Test
    @DisplayName("isPalindrome: hello")
    void isPalindrome() {
        String input = "hello";
        boolean expResult = false;
        boolean result = Main.isPalindrome(input);
        assertEquals(expResult, result);
    }
    ```

    where in `@DisplayName`, you can give more details about this TC. In the body, we specify the input is "hello", and the expected result should be `false`, then we call the method `isPalindrome()` and keep the return in `result`. The last statement `assertEquals(expResult, result)` simply compares the `expResult` and `result`. If the two are the same, then the TC is passed, else failed.

    We need to translate all input-output pairs into methods in this class. Previously we have designed `7` pairs, thus there should be 7 methods in the test class. The method name cannot be the same, we can simply call it `isPalindrome1` to `isPalindrome7`, or give them more meaningful names.

6. Running/Debugging your tests

   Once all TCs are ready, we can run the Test class, it will not search for a `main()` method, instead, running a Test class runs all TCs in it one by one to check if all of them passed or not. You can also put breakpoints in your code and debug it if there are errors in your code.

   In the end, you always have to make sure that all TCs of the project pass.
