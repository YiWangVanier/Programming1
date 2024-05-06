# Lesson01-Introduction

## 1. Basic Knowledge of Computer

### 1.1 Source Code, Binary Code, and Byte Code

Computer can only understand `0` and `1`, which is called *binary code*, or *machine code*. Any movie, sound, image, or text is `0`s and `1`s on computers. Each `0` or `1` is called a *bit* (`b`), and if we combine 8 bits, it turns into a *byte* (`B`), e.g.: `10010011`. `1024bytes` can be written as `1KB`, `1024KB` can be written as `1MB`, `1024MB` can be written as `1GB` and `1024GB` can be written as `1TB`.

Java is a high-level programming language that can be used for many purposes. Java *source code* (the code developers write) is friendly to developers such as:

```java
double salary = hourlyPay * workingHour;
```

Even for beginners, you might figure out what this code is about. However, computers cannot understand it since it is not binary code. Thus there must be a translation between the source code and the binary code. This translating procedure is called *compiling*, which is done by a *compiler*.

Compiling is usually slow, and depending on the CPU, the same source code can be compiled into different binary code, and that causes a problem. Let's say I wrote a piece of code that I want to share with all of you. I can give you the source code, and then ask you to compile it, then each of you will have to spend the time on the compiling, if the project is big, it may take hours or days. And if I want to compile the code by myself, and provide the binary code to you, it won't work cause your CPU might be different than mine.

Java invented a *byte code* that is between source code and binary code, the concept can be understood as, someone can compile the code to byte code, and then send the byte code to others, then the receiver only needs to process the rest part by themselves. You can understand it as cooking a strew, which usually takes hours to finish. But if the beans or meat is pre-cooked, then you only need to spend maybe 15 mins for the rest.

In short.

* Before Java, compiling means translating source code to binary code
* For Java, compiling means translating source code to byte code

### 1.2 JRE, JVM and JDK

To allow Java to run on a computer, we need to pre-install something to allow our computer to understand Java.

* Java Runtime Environment (**JRE**):
* Java Virtue Machine (**JVM**): JVM contains JRE plus some supported tools for Java to run on a computer. JRE is required for Java to be executed.
* Java Development Kit (**JDK**): JDK contains JVM plus more libraries and a compiler. JDK is required for Java development. The current Long term support (**LTS**) version for JDK is *JDK 21*, and the previous one is *JDK 17*. Either these two versions are find.

### 1.3 Software for This Course

1. IDE

Integrated Development Environment (**IDE**) is software for developers to write code, execute code, and debug code, it provides many features to help developers to write high-quality code. An IDE usually contains an editor, compiling tools, debug tools, etc. Different programming languages may have different IDEs, and for one language there is more than one IDE too. For this course, we use "IntelliJ" as the IDE, which is one of the most popular and powerful IDEs for Java.

There are two editions of IntelliJ:

* Community: Free, installed in all college labs
* Ultimate: Not Free, but can apply for a free license with an academic email address.

Either edition works for this course.
2. Editor

You might need to use a text editor to write `md` files to take notes, Visual Studio Code (VSC) is a good choice, it is light and powerful. You can use it to write not only `md` files but others such as Java, C#, Python, C++, JS, etc. But For Java programming, still suggest you use an IDE instead of VSC.
