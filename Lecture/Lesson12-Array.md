# Lesson12-Array

## 1. Introduction of Array

Previously we have learned the data type of String, which is a collection of characters. An Array is a structure very similar to `String`, but the data type of elements in it can not only be characters but also numbers, booleans, or any kind of user-defined classes.

When a method needs to return, it can only follow one value, but what if you need to return two numbers from a method? You can return an array of two numbers since an array is considered as one unit, even though it may contain many values inside.

## 2. Initialize An Array

An array can be initialized in two ways:

1. If you do not have any specific number to initialize in an array:

   ```java
    // datatypep[] arrayName = new datatype[length];
    int[] nums = new int[5];
   ```

    where `int[]` indicates the datatype of the variable is an `int` array, and the name `nums` is a plural, which shows that it is a collection of numbers instead of just a single one. Another way to name an array is `xxxArray` such as `numArray`, which also clearly shows the variable is an array. On the right side of the `=`, the `int[5]` indicates the length of the array is `5`. This will create an array of `5` `int` elements, with default values inside. For numbers, the initial value is `0`, for boolean, the initial value is `false`, for any object, the initial value is `null`.

2. If you have some specific numbers to initialize in an array:

   ```java
    // datatypep[] arrayName = {value list}
    int[] nums = {4, 7, 1, -2, 8};
   ```

    where all initial values are listed between the `{}`. There is no need to indicate the length since Java can count by itself.

Once an array is initialized, no matter in which way, the length cannot be changed. In other words, the length of an array is fixed.

## 3. Access Elements In An Array

Even though the length of an array is fixed, we can still read/write the value of each element in an array.

The array uses the same index system the same as `String`. The index of an element starts at `0` and ends at `length - 1`; We can use `.length` to check the length of an array.
Notice: we use `.length()` for a String, but `.length` for an array.

```java
int[] nums = {1, 2, 3, 4, 5};
System.out.print(nums.length);      // print 5
```

1. Read an element:

   ```java
   int[] nums = {1, 2, 3, 4, 5};
   System.out.print(nums[2]);      // print 3
   System.out.print(nums[nums.length - 1]);      // print 5
   ```

2. Modify an element:

   ```java
   int[] nums = {1, 2, 3, 4, 5};
   nums[0] = 9;     // modify the first element to 9
   System.out.print(nums[0]);      // print 9
   ```

## 4. Arrays class

`Arrays` class provides some useful methods that we can directly use:

1. `Arrays.toString()`: arrays are also objects, thus directly printing an array will show the reference (address) instead of the values inside. We can use `Arrays.toString()` to convert an array into a String and print it.

   ```java
   int[] nums = {1, 2, 3, 4, 5};
   System.out.print(nums);                       // print address
   System.out.print(Arrays.toString(nums));      // print [1, 2, 3, 4, 5]
   ```

2. `Arrays.fill()`: if you have a long array that you want to fill with a specific value, you don't want to use `{}` and list them one by one, instead, we can use `Arrays.fill()` to fill the values in it quickly;

   ```java
   int[] nums = new int[100];       // Put some default value first
   Arrays.fill(nums, 0, nums.length, 100);      // fill nums from idx 0 to 99 with value 100
   ```

3. `Arrays.sort()`: sorts an array in increasing order.

   ```java
    int[] nums = {3, 5, 1, 2, 4, 0};       // Put some default value first
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));      // print [0, 1, 2, 3, 4, 5]
   ```

## 5. Enhanced `for` loop

### 5.1 Basic About Enhanced `for` Loop

Previously we have learned for loops, and there is an enhanced `for` loop that can be applied on an array which can simplify the regular `for` loop. For example, if we want to go through an `double` array and calculate the sum of all elements in it, with a regular `for` loop we can write:

```java
    /**
     * calculates the sum of all elements of a double array
     * @param nums the input double array
     * @return the sum of all elements of the double array
     */
    public static double sum(double[] nums) {
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        return sum;
    }
```

In this example, to go through the array, we used a `for` loop, in which we have created a variable `i` that is used as an index to iterate. However, the value of `i` is not important, we only use it as a tool to fetch the real element values in the array. The enhanced `for` loop will iterate the ENTIRE array without the index `i`, instead, it directly takes each element out.

```java
    /**
     * calculates the sum of all elements of a double array
     * @param nums the input double array
     * @return the sum of all elements of the double array
     */
    public static double sum(double[] nums) {
        double sum = 0;

        for (double num : nums) {
            sum += num;
        }

        return sum;
    }
```

where `for (double num : nums)` is an enhanced `for` loop, num will directly equal each element of `nums`, which can directly be accumulated into `sum`.

### 5.2 Using Enhanced `for` Loop On A String

You CANNOT directly use enhanced for loop for `String`, but you can always convert a string into a `char[]` and then use enhanced for loop on it.

```java
String str = "hello";

// use a regular for loop to iterate each character of a string and print it
for (int i = 0; i < str.length(); i++) {
    System.out.println(str.charAt(i));      
}

// conver string into a char array and use an enhaced for loop to iterate through it
char[] charaters = str.toCharArray();

for (char charater : charaters) {
    System.out.println(charater);
}
```

### 5.3 Situations Enhanced `for` Loop Will Not Work

There are a few situations which we cannot use enhanced `for` loop.

1. If we only need to iterate part of an array since enhanced `for` loop will always iterate through the entire array
2. If we want to iterate an array reversely since enhanced `for` loop will always iterate through an array from idx `0` to idx `length - 1`;
3. If we have to use the index in our logic since enhanced `for` loop does not contain an index, e.g.:
   1. iterate two arrays synchronously

        ```java
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {7, 8 ,9};

        // have to use a regular for loop because an index is required to synchroize two arries
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i] + nums2[i]);
        }
        ```  

   2. add `i` to the `ith` element

   ```java
   int[] nums = {1, 2, 3};

   // have to use a regular for loop because an index is required to added to each element
   for (int i = 0; i < nums1.length; i++) {
        nums1[i] += i;
   }
   ```

## 6. Array of Object

The datatype of elements in an array can not only be primitive data types but also User-defined classes.

```java
int[] nums = new int[5];                // [0, 0, 0, 0, 0]
Student[] students = new Student[5];    // [null, null, null, null, null]

Cat cat1 = new Cat();
Cat cat2 new Cat("Snow", 2, "white");
Cat[] cats = {cat1, cat2};              // [cat1, cat2]
```

You can also use the index to access each element

```java
Cat cat1 = new Cat();
Cat cat2 new Cat("Snow", 2, "white");
Cat[] cats = {cat1, cat2};              // [cat1, cat2]

System.out.print(cats[1].getColor());   // print white
```

## 7. Multi-dimension Array

Previous examples are called `single-dimension arrays`, or `1-D arrays`, which can be understood as a row of data, such as `1 2 3`.

Java supports multi-dimension arrays, there are two ways to understand it.

1. If `int[]` is an array that contains `int` values, and each element inside is an `int`; then `int[][]` is an array that contains `int[]` values, and each element inside is an `int[]`.
2. If `int[]` is a row of data, then `int[][]` is a matrix of data, which contains multiple rows of data, and each line contains multiple columns of data.

```java
int[] nums1 = {1, 2, 3};
int[] nums2 = new int[5];

int[][] numss1 = {{1,2}, {4,5}, {7,8}};     // 3 rows, 2 columns
int[][] numss2 = new int[3][2]              // 3 rows, 2 columns, {{0,0},{0,0},{0,0}}
```
