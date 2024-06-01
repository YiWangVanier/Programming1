# Exam 02 

Two files are required to be submitted, one `Main.java` that contains the source code of all three tasks. One `MainTest.java` that contains the unit testing for Task 3.

## Task 1

1. Write a static method `containsSpace()` that takes a string and checks if the string contains spaces or not. 
2. Write a static method `countVowels()` that takes a string and counts the number of vowels in the string
3. Write a static method `isNotThree()` that takes an int and check if the number can be divided by three or contains three.
4. In `main()`, ask the user to input a string, 
   1. if the string contains space, print `"The string contains space"`, 
   2. else count the number of vowels in the string, and check if the string can be divided by three or contains three. Print the results, such as
      1.  `"There are 6 vowels in the string, the number can be divided by three or contains three."` or 
      2.  `"There are 4 vowels in the string, the number cannot be divided by three and does not contain three"`

Example 1:

``` data
Please enter a string: how are you
The String contains space
```

Example 2:

``` data
Please enter a string: university
There are 4 vowels in the string, the number cannot be divided and does not contain three
```

## Task 2

1. Write a static method `split()` that takes an int array and splits it into two int array based on the value (if the number is less than 0 or not), the method returns a 2D array
2. Write a static method `sum` that takes two int arrays and sum the element at the same index of the two array. The method returns a 1D array
3. In `main()`, 
   1. create an int array, 
   2. split the array into two arrays based on the value (if the number is less than 0 or not),
   3. sum the two arrays together as one array,
   4. print the original array, the two split arrays, the summed array

Printing Example:

``` data
Original array: [3, -1, 5, 0, -6, -2, -1]
Less than zero: [-1, -6, -2, -1]
Greater or equal than zero: [3, 5, 0]
Summed array: [2, -1, -2, -1]
```

## Task 3
Write a static method `mergeArraysWithNoEven()` that mergers two int arrays into one, all even numbers are skipped.

Hint: you can
1.	create a helper of `countOdd()` that counts the number of odd elements in an array
2.	create a helper of `removeEven()` that takes an array and returns a new array with only values of the input array.

Example: 

``` data
Nums1: `{1, 2, 3, 4, 5}`
Nums2: `{6, 7, 8, 9, 10}`
MergedNums: `{1, 3, 5, 7, 9}`
```

Apply unit testing for the method. Make sure task cases cover both general and special situations.
Here is the dependency for junit testing:

``` xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.11.0-M1</version>
    <scope>test</scope>
</dependency>
```
