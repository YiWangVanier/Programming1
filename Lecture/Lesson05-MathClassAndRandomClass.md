# Lesson05-Math Class and Random Class

## 1. Math Class

We have seen the basic arithmetic operations, and there are more tools Java provides us for mathematical calculation, located in the `Math` class.

`Math` class is part of JDK, in this case, once you have installed the JDK, you can directly use it.

| Method             | Usage                                          | Example                            | Result                 |
| ------------------ | ---------------------------------------------- | ---------------------------------- | ---------------------- |
| `Math.pow(a, b)` | calculates the `a` power of `b`            | `double num = Math.pow(2, 3);`   | `8`                  |
| `Math.sqrt(a)`   | calculates the square root of `a`            | `double num = Math.sqrt(4);`     | `2`                  |
| `Math.min(a, b)` | gets the smaller value between `a` and `b` | `double num = Math.min(2, 3);`   | `2`                  |
| `Math.max(a, b)` | gets the bigger value between `a` and `b`  | `double num = Math.max(2, 3);`   | `3`                  |
| `Math.round(a)`  | rounds `a` either up or down                 | `double num = Math.round(3.14);` | `3.0`                |
| `Math.ceil(a)`   | rounds `a` up                                | `double num = Math.ceil(3.14);`  | `4.0`                |
| `Math.floor(a)`  | rounds `a` down                              | `double num = Math.floor(3.14);` | `3.0`                |
| `Math.abs(a)`    | gets the absolute value of `a`               | `double num = Math.abs(-2);`     | `2`                  |
| `Math.random()`  | generates a random number in range `[0, 1)`  | `double num = Math.random();`    | `0.8200578291667548` |

1. `Math.pow(a, b)` can be used to calculate the future salary. For example, if every year, your salary increases by `5%`, assume the initial salary is `salary`, then after one year the salary would be `salary * (1 + 0.05)`, and after two years the salary would be `salary * (1 + 0.05) * (1 + 0.05)`, which is `salary * Math.pow(1 + 0.05, 2)`. In general, after `year` years the salary would be `salary * Math.pow(1 + 0.05, year)`.
2. `Math.sqrt(a)` can be used to calculate the standard deviation, which includes a square root calculation.
3. `Math.ceil(a)` can be used to calculate the parking fees. For example, if you park your car for `1` hour plus `10` minutes, usually you have to pay `2`-hour parking fees, in that case, the number of hours is always rounded up.

## 2. Random Class

If we need a random number in the range `[0, 1)` (`[` indicates included, `)` indicates excluded), we can directly use `Math.random()`. However, if we need a number in other ranges, `Math.random()` might not be the best choice.

For example, if we want to generate a dice, which can give us a random number in the range `[1, 6]`, or `[1, 7)`. If we want to generate an integer number in a specific range, we can use the `Random` class.

```java
Random rand = new Random();
int dice = rand.nextInt(1, 7);  // 1 is included, and 7 is excluded
```

### 2.1 `import` statement

When you type `Random`, IntelliJ will pop up an auto-complete menu again, and the first element is `Random   java.util`, press enter to choose it, this will allow IntelliJ to automatically import the class for you, and you will see a line of code added at the very beginning of your file.

```java
import java.util.Random;  // this line is automatically generated

Random rand = new Random();
int dice = rand.nextInt(1, 7);
```

This is the first time we see `import`, let's see what is it. When you install the JDK, a huge amount of classes are installed on your computer, which contains a lot of tools that we can use. some of them are very popular, while others are less frequently used. Whenever you start to program, Java would like to bring some of the tools to your environment, but certainly not all of them cause there are too many. So tools like `println`, `print`, and `Math` are imported without noticing you. While for other less frequently used tools, such as `java.util.Random`, we will have to tell Java to import it by ourselves. the `java.util` is the package name and the statement `import java.util.Random;` means, asking Java to bring the `Random` class from the `java.util` package to the current class, so you can use it. The `import` statement is always located at the very beginning of a file, just under the package name.

### 2.2 Random Strategy

Computers do not understand randomness, and cannot provide a real random value. Even though the result provided by Java looks random, it is calculated.

Usually, there is a complicated random formula `f(x)`, it will take an input value which is called a seed to calculate the result. Since the formula is so complicated, the calculated result would be very different from the input seed. By bringing the result into the required range, it would look like a random number, and then a new seed can be used to calculate for another random number, thus all results would look random. Some languages use the current time in either seconds, milliseconds, or nanoseconds as the seed to calculate the random value. Technically, if we know what seed is used, and the formula, we can predict what random value would be generated.

For example, We need to generate a dice value `[1, 7)`, and use `0` for seed, and `f(0)` equals `1029417`, and Java knows all six possible choices are `{1, 2, 3, 4, 5, 6}`, it will calculate `1029417 % 6`, and the result equals `3`. `a % 6` would end with results `[0, 6)`, which is not the same range `[1, 7)` as we need. By adding `1` the range will be matched. Thus the random value generated by Java is `4` in this case.
