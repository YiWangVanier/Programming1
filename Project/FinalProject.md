# Programming 1 - Assignment 6

Submission:

Please create UML class diagram for the following project. Send a `.md` file with only the link of your class diagram on Visual Paradigm. The student number and the student name MUST be added as text in the class diagram.

There is no need to upload any source code for this assignment.

Knowledge Points of This Assignment:

1. UML class diagram
2. Association
3. Aggregation
4. Composition

## Class1

A class of `Address` that contains

- Fields

  1. `int streetNo`
  2. `String street`
  3. `String city`
  4. `String province`
  5. `String postalCode`
  6. `String country`
- Methods

  1. `static boolean isPostalCodeValid(String postalCode)`     // checks if a postcode is valid or not. The length of a postal code can either be 6 or 7, if the length is 6, then it must follow the format: `CDCDCD`, where C is a character, while D is a digit. Case-insensitive; if the length is 7, then it must follow the format: `CDC DCD`. The method is Case-insensitive. Note: this method is a static method, which means it requires a parameter of `postalCode` instead of using the field `postalCode`, the reason of this is because this method should be called in the consturctor, before assigning the input `postalCode` to the field `postalCode`, only valid `postalCode` will be assigned to fields, or `null` will be assigned
  2. All argument Constructor, in which it will directly assign the paramter to fields, except `postalCode`, the method `isPostalCodeValid()` will first be called to check if the parameter `postalCode` is valid or not, if it is valid, then assign it with all character uppercase to the field.
  3. toString
  4. equals
  5. getter
  6. setter

## Class 2

A class of `Student` that contains

- Fields

1. `String studentId` // 6-digits starts with a character `S`
2. `String studentName`
3. `Gender gender`
4. `Address address`
5. `Department department`
6. `Course[]/ArrayList<Course> registeredCourses`
7. `double[]/ArrayList<Double> finaScores`;
8. `static int nextId`   // indicates the next ID that will be used

- Methods

1. `boolean registerCourse(String course)` // registers a course for the student. If the student has registered the course already, directly returns `false`. Otherwise, adds the course into the student's `registeredCourses`, and adds the student into the course's `registeredStudents` and return `true`
2. `boolean dropCourse(String courseId)` // drops a course of a student. If the student has not taken the course, directly returns `false`, else removes the course from the student's `registeredCourses` and removes the student from the course's `registeredStudents`
3. Constructor with `stuentName`, `gender`, `address`, and `department`, it will create a student with `studentId` automatically generated based on the `nextId`, and `registeredCourses` as emtpy object
4. `equals`
5. `toString` // prints everything about the student, for the registered coures, only prints the name of the course. // hint: cannot use lombok, needs to write the toString method and turn the courses part.

## Class 3

A class of `Course` that contains

- Fields

1. `String courseId`  // 6-digits starts with a character `C`
2. `String courseName`
3. `double credits`
4. `Department department`
5. `Assignment[]/ArrayList<Assignment> assignments`
6. `Student[]ArrayList<Student> registeredStudents`
7. `static int nextId`   // indicates the next ID that will be used

- Methods

1. `boolean isAssignmentWeightValid()`   // checks if the sum of weights of all assignments of that course equals to 1 (100%)
2. `int[] calcAssignmentsAverage()`      // calculates the average score for each assignment.
3. `int[] calcStudentsAverage()`         // calculates the average score for each student

Example:

Assume one course contains 4 assignments, and all of them have weight `0.25` equally. With the following fake scores:

|          | Assignment1 | Assignment2 | Assignment3 | Assignment4 |
| -------- | ----------- | ----------- | ----------- | ----------- |
| Student1 | 95          | 98          | 84          | 77          |
| Student2 | 67          | 55          | 62          | 47          |
| Student3 | 85          | 81          | 74          | 97          |

`calcAssignmentsAverage()` calculates the averages for assignment1, assgnment2, assignment3 and assignemnt4, and returns the result in an array such as {82, 78, 73, 74}. Results are rounded to `int`.

`calcStudentsAverage()` calculates the weighted averages for student1, student2 and student3, and returns the result in an array such as {89, 58, 84}. Results are rounded to `int`.

## Class 4

A class of `Assignment` that contains

- Fields

1. `String assignmentId`
2. `String assignmentName`
3. `double weight`
4. `int maxScore`
5. `static int nextId`
6. // TODO: scores?

## Class 5

A class of `Department` that contains

- Fields

1. `String departmentId`  // 2-digits starts with a character `D`
2. `String departmentName`
3. `static int nextId`    // indicates the next ID that will be used
