# Programming 1 - Assignment 6

Submission:

A `public` git repository must be created and maintained for the final project. Git comments history and `README` file will be evaluated.

A `.md` file with the link to the git repository should be submitted.

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

  1. `static boolean isPostalCodeValid(String postalCode)` // checks if a postcode is valid or not. The length of a postal code can either be `6` or `7`,
     1. if the length is `6`, then it must follow the format: `CDCDCD`,
     2. if the length is `7`, then it must follow the format: `CDC DCD`.
     3. where `C` is a character, while `D` is a digit. Case-insensitive;
     4. Note: this method is a static method, which means it requires a parameter of `postalCode` instead of using the field `postalCode`, the reason of this is because this method should be called in the constructor, before assigning the input `postalCode` to the field `postalCode`, only valid `postalCode` will be assigned to fields, or `null` will be assigned
  2. All argument Constructor, in which the method `isPostalCodeValid()` will first be called to check if the parameter `postalCode` is valid or not, if it is valid, then set all fields, while postal code with all character uppercase to the field, else set everything as `null`.
  3. toString
  4. equals
  5. getter
  6. setter

## Class 2

A class of `Department` that contains

- Fields

1. `String departmentId` // 2-digits starts with a character `D`
2. `String departmentName`
3. `static int nextId` // indicates the next ID that will be used

- Methods

1. `static boolean validateDepartmentName(String departmentName)` // checks if a department name is valid or not, a department name should only contain letters or space
2. Constructor // if the `departmentName` is invalid, create the object with everything as `null`;
3. toString
4. equals
5. getter
6. setter

## Class 3

A class of `Student` that contains

- Fields

1. `String studentId` // 6-digits starts with a character `S`
2. `String studentName`
3. `Gender gender`
4. `Address address`
5. `Department department`
6. `Course[]/ArrayList<Course> registeredCourses`
7. `static int nextId` // indicates the next ID that will be used

- Methods

1. `boolean registerCourse(Course course)` // registers a course, this method (1) adds the course to the student's registeredCourses list, (2) adds the student to the course's registeredStudents list, (3) appends a `null` for the `scores` of each assignment of the course. If the course is already registered, directly returns `false`
2. `boolean dropCourse(Course course)` // drops a course, remove the course from the student's registeredCourses list, and remove the student from the course's registeredStudents list. If the course is not registered yet, directly returns `false`
3. Constructor with `studentName`, `gender`, `address`, and `department`, it will create a student with `studentId` automatically generated based on the `nextId`, and `registeredCourses` as empty object
4. `toSimplifiedString` // converts a student to a simple string with only the `studentId`, the `studentName`, and `departmentName`. This method is called in `Course` `toString()`.
5. `toString` converts a student to a string that contains the `studentId`, the `studentName`, the `gender`, the `address` and the `department`, and the `registeredCourses` (only the `courseId`, the `courseName`, and the `departmentName`)
6. equals
7. getters
8. setters

## Class 4

A class of `Assignment` that contains

- Fields

1. `String assignmentId`
2. `String assignmentName`
3. `double weight`
4. `int maxScore`
5. `double assignmentAverage`
6. `int[]/ArrayList<Integer> scores`
7. `static int nextId`

- Methods

1. `void calcAssignmentAvg()` // calculates the average score for one assignment
2. `void generateRandomScore()` // generates random scores for all students in an assignment, the scores are generated with the following rule: Firstly generate a random number in range `[0, 10]`, then

   - if the number is `0`, then generate a random score in range `[0, 60)` for the student
   - if the number is `1`, `2`, then generate a random score in range `[60, 70)` for the student
   - if the number is `3`, `4`, then generate a random score in range `[70, 80)` for the student
   - if the number is `5`, `6`, `7`, `8`, then generate a random score in range `[80, 90)` for the student
   - if the number is `9`, `10`, then generate a random score in range `[90, 100]` for the student

   1. `toString` // generates a string to represent an assignment, with assignmentId, assignmentName, weight and maxScore

## Class 5

A class of `Course` that contains

- Fields

1. `String courseId` // `C-departmentId-twoDigitCourseId`, e.g.: `C-D01-01`
2. `String courseName`
3. `double credits`
4. `Department department`
5. `Assignment[]/ArrayList<Assignment> assignments`
6. `Student[]/ArrayList<Student> registeredStudents`
7. `double[]/ArrayList<Double> finalScores`
8. `static int nextId` // indicates the next ID that will be used

- Methods

1. `boolean isAssignmentWeightValid()` // checks if the sum of weights of all assignments of that course equals to 1 (100%)
2. `boolean registerStudent(Student student)` // adds a student to the student list of the course, also expand the score size for each assignment of this course, and add a new `null` element for the finalScores.
3. `int[] calcStudentsAverage()` // calculates the weighted average score of a student.
4. `boolean addAssignment(String assignmentName, double weight, int maxScore)` // adds a new assignment to the course
5. `void generateScores()` // generates random scores for each assignment and student, and calculate the final score for each student.
6. `void displayScores()` // displays the scores of a course in a table, with the assignment averages and student weighted average

    ``` data
      example:
      Course: Programming 1(C-D00-01)
                        Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score
              Yi Wang             82             82             76             85             80             82
              Yi Wang             97             92             84             67             90             83
              Yi Wang             91             68             82             83             83             82
      
              Average             90             81             81             78             84
    ```

7. `String toSimplifiedString()` // converts a course to a simple string with only the `courseId`, `courseName`, `credits`, and `departmentName`.
8. `String toString()` // converts a course to a string that contains the `courseId`, the `courseName`, the credits, the `departmentName` the `assignments`, and the `registeredStudents` (only the `studentId`, the `studentName` and the `departmentName`)
9. equals
10. getter
11. setter

## Class 6

A enum of `Gender` that contains `FEMALE` and `MALE`

## Class 7

A class `Util` locates in a new package `util` which contains

- Methods:

1. `static String toTitleCase(String strIn)` // converts each word in a a string to title case, such as `Yi Wang`, `Computer Science`. You can
   1. simply assume the string `strIn` only contains two words with one space in between,
   2. or you can implement the method for general situation, in this case, `str.split()` method will be used.
   3. All `studentName`, `departmentName`, `courseName` needs to be in title case.

## Unit Testing

The following methods requires unit testing:

1. `Address`
   1. `isPostalCodeValid`
2. `Assignment`
   1. `calcAssignmentAvg` // you will need to create object of an assignment, then use setter to change the scores of it, instead of using the random generated scores.
   2. `isAssignmentsTotalWeightValid`
3. `Course`
   1. `calcStudentAvg`
4. `Util`
   1. `toTitleCase`
