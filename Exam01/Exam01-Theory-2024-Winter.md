# Exam 01

## True or False (2’ X 5)
1.	`(3.1 * 10 - 10) / 2` equals to `10.0`
2.	hex numbers have 16 symbols 
3.	a double variable takes four times the storage space as a char variable
4.	`Math` class is already included in JDK
5.	`char c = ‘c’.toUpperCase();` is a legal statement
6.	machine code is also called byte-code
7.	`(int) (3.7 + (int) 5.5 / 2)` equals `5`
8.	`char character = 2;` is a legal statement
9.	`Math.pow(num, 0.5)` is the same as `Math.sqrt(num)`
10.	`"Hello".substring("Hello".length() / 2)` equals `"ello"`

## Multiple Choice (2’ X 5)

1. After executing the code, `str2.length()` equals _____ 

    ``` java
    String str1 = “I love Java”;  
    String str2 = str1.substring(str1.indexOf(‘ ’) + 1, str1.length() / 2 * 2 - 1); 
    ```

    A. 7 

    B. 8
    
    C. 9 

    D. 10 

2. After executing the code, `num` equals ____  
    
    ``` java
    double num = 7.14; 
    num -= 3.14 - 2 % 4 % 1; 
    ```

    A. 0.0

    B. 2.0 
    
    C. 4.0 
    
    D. 6.0 

3. ____ is the code higher than the Bytecode 
    
    A. Source code 
    
    B. Unicode
    
    C. Machine code 

    D. Binary code 

4. ____ and ____ take the same size of memory
    
    A. byte, char
    
    B. short, float 
    
    C. short, boolean
    
    D. int, float

5. Which of the following are the same as printf()

    A. `println(String.valueOf())`
    
    B. `print(String,valueOf())`
    
    C. `println(String.format())`
    
    D. `print(String.format())`



## Short Answers (2’ X 5)
1. List all integral data types from small to large
2. After executing the code, `result` equals ___

   ``` java
   int result = 4 % 3 * 10 % 3 + 25 * 4 % 2;
   ```

3. After executing the code, `result` equals ___

    ``` java 
    double result = Math.round(Math.sqrt(9)) / (2 / Math.pow(1, 1));
    ```

4. After executing the code, `chara` equals ___

    ``` java
    char chara = console.next().charAt(0);        //  user input “Hello”  
    ```

5.	After executing the code, ___ will be printed

    ``` java
    char chara = console.nextLine().charAt(0);        //  user input “abc”, ASCII of ‘a’ is 97     
    chara++; 
    System.out.print(++chara);
    ```


Answer: 
1. F
2. T
3. T
4. T
5. F
6. F
7. T
8. T
9. T
10. F

1. A
2. C
3. A
4. D
5. D

1. 
2. 1
3. 2
4. H
5. c