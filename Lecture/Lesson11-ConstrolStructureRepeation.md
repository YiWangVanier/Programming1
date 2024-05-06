# Lesson11-ControlStructureRepetition

## 1. Repetition

The selection allows us to skip some code, and the repetition allows us to go back to the previous code and re-execute it again. There are three different repetition structures in Java:

1. `while` loop
2. `for` loop
   1. regular `for` loop
   2. enhanced `for` loop
3. `do`...`while` loop

where `while` loop is usually used if the iteration is uncertain, `for` loop is used if the iteration can be determined. and `do`...`while` is only used if the operation should be done before checking the condition.

In practice, the `for` loop is the most frequently used structure, the `while` loop is much less used, and the `do`...`while` loop is the least used.

### 1.1 `while` Loop

The syntax of the `while` loop is very similar to a single `if` statement.

```java
Scanner console = new Scanner(System.in);
System.out.print("Please enter a number: ");
int num = console.nextInt();

// a single if statement
if (num > 0) {
    num--;
}

// a while loop
while (num > 0) {
    num--;
}
```

In this example, the `if` statement will check the condition for one time, if the condition is `true`, then `num` will be decreased by `1`, and then the `if` statement is completed. The `if` statement will either be executed by `0` or `1` times. The `while` loop will first check the condition. If the condition is `true`, then `num` will be decreased by `1`, and after that, it will jump back to the very beginning of the while, re-check the condition again, and repeat this behavior until the condition is finally `false`. The `while` loop can be executed by not necessarily `0` or `1` times but many times.

In practice, we always want to make sure a loop can be stopped at one point instead of repeating forever, which is called an *infinite loop*. An infinite loop happens when the code is badly designed.

```java
Scanner console = new Scanner(System.in);
System.out.print("Please enter a positive number: ");


// an infinite loop since the nextInt() is not part of the loop
int num = console.nextInt();
while (num <= 0) {
    System.out.printf("%d is not a positive number, please re-enter.", num);
}

// an better solution
int num = -1;
while (num <= 0) {
    num = console.nextInt();
    System.out.printf("%d is not a positive number, please re-enter.", num);
}
```

In all these examples, we do not know the number of iterations since it is determined by the user input, which cannot be predicted. This is a perfect situation to use a `while` loop.

Another way to use the `while` loop is to create an infinite loop and then break it with a condition.

```java
// while(true) creates an infinite loop
int num;
while (true) {
    System.out.print("Please enter a positive number: ");
    num = console.nextInt();

    if (num > 0) {
        break;
    }
}
```

In this example, the `while` loop is an infinite loop, but there is a single `if` statement nested inside of it. The `if` statement checks if `num` is a positive number or not, if so, it will execute a `break` statement. The `break` statement will break the loop structure, even though it is infinite.

### 1.2 `for` Loop

If the number of iterations can be determined, the `for` loop is a much better choice than the `while` loop.

For example, let's calculate the sum of `1`, `2`, ..., `100`. We can implement it with a `while` loop.

```java
int sum = 0;

int i = 1;              // initialize an iterator
while (i <= 100) {      // set the condition
    sum += i;
    i++;                // update the iterator
}
```  

This loop contains three parts:

1. initializing the iterator, which is located before the `while` loop since we need to use it in the first step of the loop
2. setting the condition, which is located at the very beginning of the `while` loop, and specifies when the loop will be stopped.
3. updating the iterator, which is located at the end of the `while` loop, which guarantees the condition can be equal to `false`` at some point and the loop can be stopped.

This is a classic situation we can use a `for` loop since we know where the loop will start, and where it will end. A `for` loop is just a simple way to write a `while` loop. Instead of writing the three parts above in three different places, it writes them all together.

```java
// while loop
int sum = 0;

int i = 1;              // initialize an iterator
while (i <= 100) {      // set the condition
    sum += i;
    i++;                // update the iterator
}

// for loop
int sum = 0;

for (int i = 1; i <= 100; i++) {
    sum += i;
}
```

The logic and the order of each statement in the `for` loop are the same as the ones in the `while` loop, which means it will first execute `int i = 1;` before the for loop, then check the condition `i <= 100`, if it equals `true`, then the body `sum += i;` will be executed. Once the body is completed, it will update the iterator `i++;` and then go back to the beginning of the loop and check the condition again.

The `for` loop is also usually used to go through a String, since a string always has a specific length, and the index of a string `str` is always in range `[0, str.length())`.

```java
String str = "hello";

for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    System.out.printf("character at index %d is %c\n", i, c);
}
```

The `for` loop goes through the entire string by increasing the index. `for (int i = 0; i < str.length(); i++)` is the standard way to iterate through a String. In the future, we will see that we can use the same way to go through any collections.

You can also iterate through a String in a reversed order:

```java
String str = "hello";

for (int i = str.length() - 1; i >= 0; i--) {
    char c = str.charAt(i);
    System.out.printf("character at index %d is %c\n", i, c);
}
```

### 1.3 `do`...`while` Loop

The `do`...`while` loop is the least used loop, we only need to use it if we need to execute the operation before checking the condition.

In all previous examples, the condition is first checked, and the body will be executed only if the condition is `true`. Thus, if the condition is `false` at the very beginning, the loop can be skipped with `0`-time execution.

The `do`...`while` loop will first execute the body of the loop with no condition, and only after the first iteration is executed, then check the condition to determine if the loop would continue for more iterations.

For example, after you arrive home from school, you check your hands to see if they are dirty, if so, you will wash your hands, and if they are still dirty after washing, you want to wash them again, until they are clean in the end. This is first checking, then taking the action, which can be written as a `while` loop, since if the hands are clean, you may wash them for `0` time.

But let's say you always wash your hands after you get home, no matter if they look clean or not, and you will check if they are clean after you wash them, this should be written as a `do`...`while` loop since the action is taken before the checking, and you will at least wash your hands for `1` time.

```java
// while loop may be executed for 0 time
while (!areHandsClean()) {
    washHands();
}

// do...while loop must be executed for at least 1 time
do {
    washHands();
} while (!areHandsClean());
```

### `return`, `break` and `continue`

Previously we have seen that a method can return a value by using the `return` keyword. Here we will compare `return`, `break` and `continue` together since all of them may exist in a loop.

1. `return`: may exist in a method, which will immediately kill the method, and jump back to the previous method.
2. `break`: may exist in a `switch`...`case` structure or a loop, which will immediately kill the loop, and jump to the code after the loop.
3. `continue`: may exist only in a loop, which will immediately kill the current iteration, and start a new iteration in the same loop.

```java
// return kills the entire method, once it is executed, the stream will jump to m2()
public static void m1() {
    // statements A

    for (int i = 0; i < 10; i++) {
        // statements B
        if (condition) {
            return;
        }
         
    }

    // statements C
}

public static void m2() {
    m1();
}
```

```java
// break kills the loop, once it is executed, the stream will jump to statements C
public static void m1() {
    // statements A

    for (int i = 0; i < 10; i++) {
        // statements B
        if (condition) {
            break;
        }
         
    }

    // statements C
}
```

```java
// continue kills the current iteration, once it is executed, the stream will execute i++, and then jump to the beginning of the for loop
public static void m1() {
    // statements A

    for (int i = 0; i < 10; i++) {
        // statements B
        if (condition) {
            break;
        }
         
    }

    // statements C
}
```

```java
/**
 * example of using break, the loop will stop when it meets the first number that can be divided by 3
 * if num = 10, it will print 1 2 
 * @param num boundary of the numbers
 */
public static void printNumsCannotDivideByThree(int num) {
    for (int i = 1; i <= num; i++) {
        if (i % 3 == 0) {
            break;
        }
        System.out.print(i + " ");
    }
}

/**
 * example of using continue, the loop will skip any number that can be divided by 3, and will stop at num
 * if num = 10, it will print 1 2 4 5 7 8 10
 * @param num boundary of the numbers
 */
public static void printNumsCannotDivideByThree(int num) {
    for (int i = 1; i <= num; i++) {
        if (i % 3 == 0) {
            continue;
        }
        System.out.print(i + " ");
    }
}
```

## 2.  Debugging Tools

With methods and control structures, our code is getting more and more complicated, and it jumps from one place to another when executed. Sometimes some code is skipped and sometimes some code is repeated.

If our code does not work properly, either causing an exception or resulting in unexpected values, we will have to find what causes the problem and fix it, which is called *debugging*. Developers have to spend a huge amount of time on debugging, using debugging tools provided by the IDE can help us to debug efficiently.

When we choose to *Run* our code, Java executes the code as fast as it can and provides us with the result. However, that is not what we want if we know the code has some problems. We want to pause the execution at some point if we think around that place the code is suspicious to have some bug. This is called setting a `breakpoint`. By clicking on the line number of the text editor in an IDE, you can set/unset a breakpoint at that line, and you can set as many breakpoints as you want in your code. A breakpoint is shown as a red solid circle in IntelliJ.

Breakpoints will not be activated if you choose to `Run` your code, to activate them, you will need to choose to `Debug` your code. By doing so, Java will execute the code as fast as it can, until it reaches a breakpoint, and pauses there until orders from the developer are received.

There are three orders usually given

1. `Step over`: execute the current line and move to the next line
2. `Step in`: if the current line contains a method call, move to that method
3. `Step out`: if the current method is called, move to the previous method that calls the current method.

In debug mode, you can also check the values of each variable, analyze why it gets that value, and if it is reasonable to be that value. The values are shown at the bottom of the IDE, and you can also add a new `watch` by entering the value you want to check at the `Evaluate expression or add a watch` input field.
