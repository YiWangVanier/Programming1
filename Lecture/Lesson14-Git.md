# Lesson14-Git

## 1. Introduction of Git

`Git` is a free and open-source version control system, originally created by Linus Torvalds in 2005. A version control system is a system to help developers back up code, keep a history of code changes, compare different versions of code, and withdraw changes is it is necessary. It also can help to resolve conflict if multiple developers work on the same project.

## 2. How Git works

Here is a basic overview of how Git works:

1. Create a `repository` (project) with a git hosting tool (like GitHub)
2. Copy (or `clone`) the repository to your local machine
3. `Add` files to your local repo and `commit` (save) the changes
4. `Push` your changes to your main branch
5. Make a change to your file with a git hosting tool and commit
6. `Pull` the changes to your local machine
7. Create a `branch`, make a change, commit the change
8. Open a `pull request` (propose changes to the main branch)
9. `Merge` your branch to the main branch

The basic operations beginners need to know are:

1. `git clone`: to clone a repository into a new directory
2. `git pull`: to fetch from and integrate with another repository or a local branch
3. `git add`: to add file contents to the index
4. `git commit`: to record changes to the repository
5. `git push`: to update remote refs along with associated objects

## 3. IntelliJ Git Tutorial

You can use Git for version control by either 1. desktop software; 2. command line; 3. IDE.

The command line is the most recommended way, however, it requires basic Linux knowledge.

Morden IDEs such as IntelliJ provides version control system (`VCS`) tools to use version control efficiently.

To configure Git in IntelliJ:

1. select `VCS` on the menu, then `Enable Version Control Intergration...`, and make sure the system is `Git`. Then the item on the menu will be changed to `Git`.
2. Open `Settings`, search for `Github` and add a GitHub account on the right.
3. When you need to commit your code, click on the `commit` icon behind the project icon on the left of the IntelliJ main screen. Choose the files you want to add, and write the commit under it.
4. select `Git` on the menu, then `push` to push your code.
  
If you want to clone a project from a Git repository, you can directly select `File` on the menu, then `Project from Version Control...` and then input the path of the repository into the `URL` field, and choose where to store the cloned project.
