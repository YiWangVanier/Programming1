# Lesson08 OOP

## 1. Procedural Programming VS Object-oriented Programming

*Object-oriented Programming (OOP)* is a key knowledge point of Java. Java is OOP-obligated, which means all source code should be written in classes.

The traditional way to write code is to focus on a specific task, such as registering for a course, which is called `Procedural Programming`.

OOP does not focus on a specific task but focuses on what object may be affected by the task, for example, it is a student who needs to register for a course, so both the student and the course will be affected by this behavior.

Instead of writing everything in methods and joining methods together to accomplish a task, OOP seals fields and methods into `classes`, and then creates `objects` of classes.

## 2. Class VS Object

OOP will always write fields and methods into classes. A class is always a noun, such as a `Student`, a `Course`, a `Cat`, a `Restaurant`, a `User`, etc.

A class can be understood as a user-defined data type, and you can create objects of it just like you can create variables of a primitive data type.

```java
int num1;
int num2; 

Cat cat1;
Cat cat2;
```

The real values are stored in objects instead of classes, the same as the values are stored in variables instead of primitive datatypes. Thus people say the class is like an abstract blueprint, and only the object is real.

### 2.1 Class Definition

A class may contain two parts:

1. data members(fields)
2. methods
***IMPORTANT: All members in the same class can access each other.***

Data members are used to store data of objects of the class, while methods control the behaviors of objects of the class.

For example, if we want to create a `Student` class, we need to have a data member to store the name of a student, which should be a string, we may also need to know its gender, which should also be a string, assume we need to store its age, it could be an `int`. You can have as many data members in a class as you want.
***IMPORTANT: Usually all data members should be `private`.***

```java
public class Student{
    private String name;
    private String gender;
    private int age;
}
```

OK, now you have a very simple class, which means you can create a student object that contains three values, a name, a gender and an age. Now we can test it by creating an object in the main method.

```java
public static void main(String[] ages) {
    Student student;
}
```

But now we cannot pass a name, a gender or an age to that object, cause we cannot just pass a value on the right side of an `=` sign for an object as for a variable.

To achieve this goal, we need to create special methods for a class named `Constructor`s.

`Contructor`s are methods for classes to create objects. Constructors should mostly be `public` cause we usually need to call them in other classes to create objects. Constructors are always `non-static` and have NO return type (not even `void`). The names of constructors are the same as the class name, e.g.: for the `Student` class, the constructors should all have names `Student`. Constructors are the only methods that have names start with an uppercase letter.

The main job of constructors is to initialize data members of the class for an object. In this example, the `Student` class contains three data members, thus each student object should have a name, a gender and an age. We can use a constructor to set values for them.

```java
// example of a default constructor
public Student() {
    this.name = "Yi Wang";
    this.gender = "male";
    this.age = 39;
}
```

In this example, the constructor takes no parameter, which is called `NoArgumentsConstructor` or `Default Constructor`. A default constructor is used to give default values to each data member.

The keyword `this` represents `this object`. The dot operator `.` is a syntactic element, i.e. it denotes the separation between class and package, method and class, variable and reference variable. It can also be called a `separator operator`. It is mainly used for separating a variable and method from a reference variable, for accessing class and sub-packages from a package, and for accessing any member of a class or a package. You can understand it as `'s` in English. For example, `this.name` means this object's name, and since it is the `Student` class, the object would be a student, it can also be understood as this student's name.

Thus this constructor takes no parameter, and set the student's name as "Yi Wang", the student's gender as "male", and the student's age as 39.

You can have overload constructors for a class, to provide different ways to initialize objects of the class.

```java
// example of a all arguments constructor
public Student(String name, String gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
}
```

These two constructors exist in the same class, with the same method name, and different parameter lists, thus they are overload methods.

The second constructor takes three parameters, and since the class contains three data members, thus it is called `All Arguments Constructor` (parameter = argument)

In this constructor, there are two `name`s, one is `this.name` and one is `name`. The `name` with no `this` in front is the local variable `name` declared in the parameter list, while `this.name` is the student's name, which represents the data member `private String name`. Thus the statement `this.name = name` assigns the value of the parameter `name` to the data member `name`. Same for `gender` and `age`. As mentioned before, all members in the same class can access each other, so the constructor can directly visit the data member `this.name` that is defined outside of it and modify its value.

Technically you can have as many overload constructors as you want, but `NoArgumentsConstructor` and `AllArgumentConstructor` are the most frequently used ones.

If a class contains no constructor at all, Java will provide a default constructor for that class, with all values set to a default value. `int` and `double` will be set as `0`, `String` or other objects will be set as `null`.

```java
// If there is no constructor for Student class, Java will provide a default one
public Strudent() {
    this.name = null;
    this.gender = null;
    this.age = 0;
}
```

`null` is a special value that can be set to any object, which indicates the reference of the object is pointing at nowhere. In this case, the object does not have two pieces of memory. If an object is set as `null`, you cannot use `.` operator to access any data of it, since it does not hold any values in it at all. Trying to do so will cause a `NPE` which stands for `NullPointException`.

Once a class contains constructors, we can use them to initialize the object. Back to the `main()`

```java
public static void main(String[] ages) {
    // initialize the object with NoArgumentConstructor
    Student student1 = new Stduent();    
    
    // initialize the object with AllArgumentsConstructor
    Student student1 = new Stduent("John Snow", "male", 20);    
}
```

In these examples, we used the keyword `new` and a specific constructor to create a new object. The keyword `new` is used to create a new object. Previously when we learned the `Random` class, we also have seen `Random rand = new Random();`, which is also creating an object of the `Random` class by using its default constructor.

### 2.2 Memory Allocation

Objects and primitive datatype variables are very different in memory allocation.

A primitive data type variable takes one piece of memory, e.g.: an `int` variable takes `4` bytes, and a `double` variable takes `8` bytes. The value will directly be stored in it, and that's the reason why we can use `==` to compare two primitive datatype variables. For example, for `int num = 5;`, `num` is the same as `5` since `5` is stored in one piece of memory which is called `num`.

An object, on the other hand, takes two pieces of memories, one piece (called `reference`) stores the address of the other piece, and the second piece is used to store the real data. For example, for `Student student = new Student();`, `student` is the reference, which does not store the `name`, `gender` and `age` of the student, it only stores the address of another piece of memory, e.g.: `@30f39991`, and the values of data members are stored in the second piece of memory.

This causes issues for us:

1. To print the object, we cannot directly use `System.out.print(student);`, since the reference `student` only holds an address, which usually we do not care about.
2. To compare two objects, we cannot directly use `==` like `student1 == student2`, cause directly comparing two objects with `==` only compares their addresses instead of their values. Two objects that have the same values of data members may still have different addresses.

There are solutions to both these two issues which we will see soon.

### 2.3 `equals()` Method

Since we cannot compare two objects by using `==`, we need to find another way to do so. When we want to compare two objects, we actually want to compare the values of their data members, for example, if the `name`, the `gender` and the `age` of two students are the same or not. If all of them are the same, then we would consider the two students to be the same.

We can create a method of `equals()` in a class for comparing objects of that class.

For a `Student` class with `name`, `gender` and `age`:

```java
public boolean equals(Student student) {
    return this.age == student.age && 
            this.name.equals(student.name) && 
            this.gender.equals(student.gender);
}
```

The `equals()` method takes one parameter that is also a `Student`, and compares the two objects' data members. Since `age` is an `int`, we can use `==` to compare them. But `name` and `gender` are `String`, we need to compare them also with `equals()`. The String class already has one so we can directly use it. That's why we can see `this.name.equals(student.name)`.

To compare two objects, now we can do:

```java
public static void main(String[] args) {
    Student s1 = new Student();
    Student s2 = new Student();

    // compare two objects by using ==
    System.out.print(s1 == s2);              // false
    // compare two objects by using equals() 
    System.out.print(s1.equals(s2));         // true
}
```

### 2.4 `toString()` Method

We also cannot print an object directly, cause the reference only contains the address of the other piece of memory. To fix this issue, we need to create a method named `toString()`, the name indicates that this method converts the object to a String.

For a `Student` class with `name`, `gender` and `age`:

```java
@Override
public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", age=" + age +
            '}';
}
```

It simply reads the values of `name`, `gender`, and `age`, then links all of them into one string and returns it.

The annotation `@Override` will be explained when the concept `inheritance` is explained. Here we just need to know all `toString()` methods should have `@Override` above it.

Usually, there is no need to call the `toString()` method manually. Java will call it automatically when you want to print an object, also, if you want to join a String with an object, Java will convert the object into a String, where `toString()` will also be called automatically.

```java
public static void main(String[] args) {
    Student s = new Student();

    // if there is no toString() in the Student class
    // an address will be printed @30f39991
    System.out.print(s);

    // if there is a toString() in the Student class
    // toString() will be called automatically and print the object as a string
    // print Student{name="Yi Wang", gender="male", age=39}
    System.out.print(s);
}
```

### 2.5 Getter and Setter

Usually, data members in classes should be `private`, which means those data members can only be accessed by other members in the same class, but not code in other places. This is to protect the data of objects.

However, what if we need to access some of of data members outside of the class? One way is to modify the access modifier of specific data members, which could be dangerous and thus is not recommended.

The other way is to create some public getters and setters. Getters and setters are special methods that allow code outside of the class to access data members.

For a `Student` class with `name`, `gender` and `age`:

```java
public class Student {
    private String name;
    private String gender;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

In this example, `getName()` is a getter, that takes no parameter, and it only returns the value of the data member `name`. Because it is located in the Student class, thus it can directly access the data member `name`, and because it is `public`, it can be used in other classes too.

`setName()` is a setter, that takes a String, and uses it to update the value of the data member `name`. It also can directly access the data member `name` and can be used in other classes.

The benefits of using getters and setters are:

1. The reading and writing of a data member are separated, if you provide a getter for a data member, then others can use it to read the value of the data member, if you provide a setter for a data member, then others can use it to write the value of the data member. However, if you do not want any code outside of the class to read/write the data member, you can keep the data member `private` without any getter and setter.
2. Getters and setters can be customized. Even though most of the time getters and setters look simple and boring, they can be customized to be more powerful. For example:

    ```java
    /**
     * fetches the name of the student, but hide all characters except the first and the last.
     */
    public String getName() {
        int len = name.length();
        String hiddenName = name.charAt(0);

        for (int i = 0; i < name.length() - 2; i++) {
            hiddenName += "*";
        }  

        return hiddenName + name.charAt(len - 1) ;
    }
    ```

    ```java
    /**
     * udpates the name of the student, the input name is converted to titlecase first
     * @param name the new name of the student 
     */
    public void setName(String name) {
        this.name = name.charAt(0).toUpperCase() + name.substring(1).toLowerCase();
    }
    ```

Getters or setters can be used in any classes since they are public:

```java
public static void main(String[] args) {
    Student s = new Student();

    // calling getName() in the Main class to read the student name
    System.out.print(s.getName());

    // calling setName() in the Main class to modify the student name
    s.setAge(20);
}
```

### 2.6 Using Code Completion

Previously we have seen some special methods in a class such as `constructor`, `equals`, `toString`, getter and setter. Most of them are standardized, which means no matter if you create a `Cat` class, a `Dish` class or a `User` class, those methods would look very similar. The only work that we have to do by ourselves is to determine the data members. For example, for a `Student` class, we have to figure out that we need to have a `name`, a `gender`, and an `aga` data member. And IDEs can help us to generate special methods for us.

For IntelliJ, you can go to the menu and select `Code` -> `Generate`, in the pop-up menu, select the methods that you want to add to your class.

Note: For generating `equals()`, the option is `equals() and hashCode()` in the pop-up menu, `hashCode()` is a method that will not be used this semester. You can still generate it and keep it in the class.

### 2.7 Using `lombok` Dependency

Even though can be generated, previous special methods are still long and take a lot of space in a class. If you have other user-defined methods in the class, those special methods will make the user-defined ones difficult to find. If we can use these methods without seeing them in a class, that would be perfect.

The `lombok` third-party library provides annotations to solve this problem. A third-party library is a collection of code that is not part of the JDK but written by other companies or individuals. Once we involve a third-party library in our project, we can use it just like the code the JDK provides.

The traditional way to involve a library in a project is to download the source code of the third-party library and put it in the project directory. This is not a very convenient solution since 1. You will have to download the source code of the third party and keep it with your code, which can make your project messy. 2. The third-party library keeps updating, which means the one you have downloaded may get out of date after a while, which may cause bugs in your code. To avoid this happening, you will have to always keep an eye on the new version of the third-party library, and download the new version to replace the previous one.

If you use `maven` or `gradle` as the project build system, all these inconveniences can be avoided easily. This course will take `maven` as an example, the way how `gradle` works is very similar to it.

First, search on the browser "lombok maven", and the first search result that comes out should be would show you how to add `lombok` to your `pom` file. The `pom` file is a file every `maven` project has, which contains the basic configs of the `maven` project.

All you need is to paste the dependency from the website at the end of the pom file:

```xml
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Now your pom file may look like

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Test1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```

Once the `pom` file is updated, the new pasted code may be shown in red, you will have to reload the `maven` project. There should be an `m` button on the top right of the screen that you can click each time the `pom` file is updated. Click that button, `maven` will download the `lombok` library store it and link it with your project and the red error on the new paste code will disappear. Now you can use `lombok` in your project. In the future, if there is a new version of `lombok` released, all you need to do is to update the `<version>` in the dependency and reload the project, `maven` will take care of the rest for you again.

If you want to use `lombok` in another project, you will add the dependency in the `pom` file of that project too.

Once `lombok` is added as a dependency in the project, you can use it in your code. `lombok` provides plenty of annotations to help you create a project quickly, such as:

1. `@NoArgsConstructor`: to generate a NoArgumentsConstructor for a class
2. `@AllArgsConstructor`: to generate an AllArgsConstructor for a class
3. `@ToString`: to generate a `toString()` for a class
4. `@EqualsAndHashCode`: to generate an `equals()` and a `hashCode()` for a class
5. `@Getter`: to generate getters for a class
6. `@Setter`: to generate setters for a class

Once you add any of these annotations before a class, `lombok` will generate the corresponding methods for the class without showing them.

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String name;
    private String gender;
    private int age;
}
```

Now the `Student` class contains two constructors, a `toString()` a `equals()`, a `hashCode()`, three getters and three setters.

## 3. Static VS Non-static

We have seen some `static` methods such as `main()` and the methods we wrote in Lesson07-Method, but in this lesson all methods are `non-static`. This section explains the difference between `static` methods and `non-static` methods.

In general, `static` methods belong to classes, while `non-static` methods belong to objects.

Take the `Student` class for example, when we create objects, i.e. students, each student should have their `name`, `age` and `gender`, in this case, we say `name`, `age`, and `gender` belong to objects. If you change one object's name, it will not affect other objects. But let's say all students belong to "VanierCollege", you do not want to create a data member called `school` and then assign the same value to all of them. There are two problems with it, first, each object will have to store its data members, if we have 5000 students, then there will be 5000 "VanierCollege" stored, which wastes space. Second, if the college decides to change its name, we will have to update the value of `school` for every student.

In this case, we can make the member `school` `static`. A `static` member belongs to a class instead of an object. Since there is only one class `Student`, then this member will have only one copy of it, and then all objects of that class can share it. If the value of the member is changed, for example, the school name is changed from "VanierCollege" to "YiCollege", it will affect all objects of the class. And because `static` members belong to the class, we usually directly initialize it when we create it, instead of initializing it in a constructor, which is used to initialize objects.

For example:

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String name;
    private String gender;
    private int age;

    private static String school = "VanierCollege";
}
```

To access a `non-static` member, we need to access through an object, but a `static` member should be accessed through the class.

```java
public static void main(String[] args) {
    Student student = new Student();

    // access a non-static member through an object
    System.out.print(student.getName());

    // access a static member through a class
    System.out.print(Student.getSchool());
}
```

IMPORTANT: A non-static member can access both static and non-static members, while a static member can only access static members but not non-static members. Cause non-static members belong to each object, a `static` member belongs to the entire class, if you ask a `static` member to access a `non-static` member, it does not know which object's value it should access.

```java
public class Student {
    private String name;
    private String gender;
    private int age;

    private static String school = "VanierCollege";

    // static method
    public static void m1() {
        // correct: a ststic member can access static members
        System.out.printf("School: %s\n", school);

        // error: a ststic member cannot access non-static members 
        System.out.printf("Name: %s\n", name);
    }

    // non-static method
    public void m2() {
        // correct: a non-ststic member can access static members
        System.out.printf("School: %s\n", school);

        // correct: a non-ststic member can access non-static members
        System.out.printf("Name: %s\n", name);
    }
}
```

When designing a class, we have to always first ask ourselves, if the method requires to access any non-static fields, if so, then the method should be `non-static` too, or it should be `static`.

### 3.1 Constant

If the value of a static field in a class will never change, then it is a constant. A constant should be declared with two keywords: `static` and `final`, the keyword `final` indicates that it cannot be changed.

Also, to highlight a constant, its name should be all uppercase, this is the only situation that we do not name an element with camel-case. A constant is named with `snake-case`, and words are linked with underscores.

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String name;
    private String gender;
    private int age;

    // constant, with two keywords: static and final
    private static final String SCHOOL_NAME = "VanierCollege";
}
```

## 4. User-defined Methods in A Class

Methods in a class usually are slightly different from the methods we have seen before because of the data members.

First, because data members are all `non-static` members and most methods will have to access some data members, thus they should be `non-static` too.

Second, because members in a class can access each other, the formal parameter list and the return type of methods could be different than before. For example, if we need to check if a student is an adult or not, we need to check if the age is less than `18` or not. A method we may write before looks like this:

```java
public static boolean isAdult(int age) {
    return age >= 18;
}
```

This method takes a parameter `age` as input and then checks if it is bigger or equal to `18`. But now since we have data member `private int age;` in the class, and any method in the class can directly access it, we don't have to pass any parameters to the method.

```java
public static boolean isAdult() {
    return age >= 18;           // directly access to the data member age
}
```

All local variables will be destroyed when a method is over, thus we will have to return the result before it happens and assign the return value to a variable after the method is returned. But if now we want to modify a value, which is also a data member, we can directly modify it in the method.

```java
// previously we have to return the result or the value will be lost
public static String formatName(String name) {
    return name.charAt(0).toUpperCase() + name.substring(1).toLowerCase();
} 
```

```java
// In a class, we can directly modify name in another method if name is a data member.
public static void formatName() {
    name = name.charAt(0).toUpperCase() + name.substring(1).toLowerCase();
} 
```

## 5. Use Class As A Datatype In Another Class

Defining a class is like defining a new data type, thus it can be used also in another class as data members:

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int aptNo;
    private int streetNo;
    private String street;
    private String city;
    private String zipcode;
}
```

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String name;
    private String gender;
    private int age;
    private Address address;    // a data member of Address class

    private static String school = "VanierCollege";
}
```

We can access the student's address by using getters of student class

```java
public static void main(String[] args) {
    Student student = new Student();

    // check the address of the student
    System.out.print(student.getAddress());     

    // check the city of of the address of the student
    System.out.print(student.getAddress().getCity());     
}
```

## 6. Enum

For the `gender` field in the `Student` class, currently, we declare its datatype as `String`, so it cannot be a number such as `3` or `3.14`, However, someone can still put a value of `"hello"` in it, which is illegal for a gender. Let's say now the gender can only be three values: `female`, `male` and `others`, while all other values should be considered as invalid for the system. We can use `enum` to add this kind of restriction for the choices, which stands for "enumerate".

An `Enum` is like a class, but only the values listed inside can be given to an object of the enum. For example:

```java
// defines an enum for gender, which only contains three constants
public enum Gender {
    FEMALE, MALE, OTHERS
}
```

Then in the `Student` class, the data type of `gender` is not `Gender` instead of `String`.

```java
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String name;
    private Gender gender;
    private int age;
}
```

And when we want to give a value to `gender`, we can only give a value that is defined in the `Gender` enum.

```java
public static void main(String[] args) {
    // Gender.MALE is a value defined in Gender
    Student student = new Student("Yi", Gender.MALE, 39);

    // error, try to assign a string to a Gender
    Student student = new Student("Yi", "male", 39);
}
```

## 7. UML

When a project gets big, it may contain a large number of classes, each containing plenty of data members and methods, and there may be different relationships between classes. Also, there could be a certain order of methods to be called. All of these should be described and documented so others can understand how the project works.

A Unified Modeling Language (UML) diagram is a way to visualize systems and software. UML provides a standard notation for many types of diagrams which can be roughly divided into three main groups: behavior diagrams, interaction diagrams, and structure diagrams. It is much more efficient to use UML to visualize the system instead of describing everything in words.

### 7.1 Class Diagram

There are many types of diagrams in UML, we will only work with one of them now: `Class Diagram`.

A Class diagram is a diagram to visualize each class in a project, and also the relationship between classes if there is any.

Each class is represented by a rectangular, which contains three parts, the name of the class, the fields, and the methods.

In a class diagram, the access modifier of a member is simplified by

* `+`: `public`
* `-`: `private`
* `#`: `protected`
* `~`: default

Also, the data type is written after a field or a variable, for example: `-name: String` for a field `private String name`, and `+isValiod(age: int): boolean` for a method `public boolean isValid(int age)`. If a member is static, then it is underlined. for example: <ins>`-collegeName: String`</ins> for `private static String collegeName`, and <ins>`+max(num1: double, num2: double): double`</ins> for `public static double max(double num1, double num2)`.

A class may contain many methods if you count the constructors, the `toString`, the `equals`, the `hashcode`, the getters and the setters. Listing all these methods in a class diagram will make the diagram huge. Thus even though the class contains those methods, usually we do not add them to a class diagram. Only the user-defined methods are added to it.

Now we know how to draw one class in a class diagram, but when there are many classes in a project, they are not independent from each other. For example, a class `Student` may contain a field `Address address`, where the `Address` is also a class.

There are four common relationships between classes:

* Association: When two classes have a general relationship. For example, a `Student` registers a `Course`. indicated by a solid line between two classes in a class diagram.
* Aggregation: When one class contains another, that satisfies the `has a` relationship, while the contained one always exists when the other exists, for example `Library` and `Book`, where a library contains books, but a book can still exist even if the library does not exist. Indicated by a solid line with an empty diamond between two classes in a class diagram, where the diamond is on the container class side.
* Composition: When one class contains another, that satisfies the `has a` relationship, while the contained one only exists when the other exists, for example: `Dog` and `Tail`, where a dog contains a tail, and the tail will only exist if the dog exists. If the dog object is destroyed, the tail object of the dog should also be destroyed. Indicated by a solid line and a solid diamond between two classes in a class diagram, where the diamond is on the container class side.
* Generalization: When there is a super-class and a suc-class, that satisfy the `is a` relationship, for example, `Cat` is a special kind of `Pet`, then `Cat` is a generalization of `Pet`. Indicated by a solid line with an empty triangle between two classes in a class diagram, where the triangle is on the super-class side.

More details can be found in [UML Class Diagram Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/).
