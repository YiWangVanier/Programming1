# Exam 02 

## True or False (2’ X 5)
1.	`Switch expression` can only be used to compare numbers but cannot be used to compare characters
2.	You can specify which layer of loop to break in a nested loop structure.
3.	You can increase the number of elements of it after an array is created
4.	`||` has higher priority than `&&`
5.	The current junit testing version is `5`

## Multiple Choice (2’ X 5)
1.	After executing the following code, `result` equals ___

    ``` java
    int result = 1; 
    for (int i = -3; i < 5; i += 2) {
        if (i % 3 != 0) {  
            result += i;
        }
    }
    ```

    A. 1

    B. 15

    C. 11

    D. 13

2.	The following loop will print ___ stars

    ``` java
    int num = 5;
    while (true) {
        if (num-- < 0) {
            break;
        }
        if (num % 2 == 0) {
            continue;
        }
        System.out.print(“*”);
    }
    ```

    A.	2

    B.	3

    C.	4

    D.	5

3.	which of the following words is a keyword 

    A.	continue

    B.	console

    C.	String

    D.	outer

4.	To apply deep copy, we may need ___ 

    A.	No argument constructor

    B.	All argument constructor

    C.	Copy constructor

    D.	Nothing since we can directly apply deep copy

5.	Which combination of the following sentence is correct

    1.	Static member CAN visit static member, but CANNOT visit non-static member
    2.	Static member CAN visit static member, and CAN visit non-static member
    3.	Non-Static member CAN visit static member, but CANNOT visit non-static member
    4.	Non-Static member CAN visit static member, and CAN visit non-static member

    A.	1 and 3

    B.	1 and 4

    C.	2 and 3

    D.	2 and 4


## Short Answers (2’ X 5)
1.	Use both a while loop and a for loop to print numbers from 1 to 10 separately.
2.	Explain how short-circuit works in `if (str == null || str.isEmpty())`
3.	Write 5 git commands and explain what each command does.
4.	Create the truth table for `!(A || !B)` ____________
5.	Assume there is a class of Student, which contains a field `private Gender gender`, where `Gender` is an enum, which only supports two values to represent two genders. In the `main()` in the `Main` class, a student `student` is created. (All necessary default methods are created for Student class)
    Write one statement in to print a value based on a student’s gender, if it is a female student, print `1`, else print `2`


Answer: 
F
T
F
F
T

A
B
A
C
B
