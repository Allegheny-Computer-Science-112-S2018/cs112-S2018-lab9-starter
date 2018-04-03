<!---

TASK LIST:

  * Use cp -rf *.* to copy all of the files and directories in this repository
    to the starter repository for this assignment
  * Change into the directory for the starer repository
  * Update the header (e.g., #) to only give the name of the assignment
  * Update the first paragraph to include the commented-out content
  * Change the link in the # Problems section to point to this lab's starter
  * Create the assignment in the GitHub Classroom, noting the URL
  * Test the assignment by accepting it with your own GitHub account
  * Check to ensure that your GitHub repository is created correctly
  * Share the assignment link with all of the students using email or Slack

PROBLEMS?

  * Contact Gregory M. Kapfhammer by email or Slack
  * Raise an issue in the GitHub repository for this assignment

-->

# cs112-S2018-lab9-solution

Designed for use with [GitHub Classroom](https://classroom.github.com/), this
repository contains the solution for Laboratory 9 in Computer Science 112.

<!---

 Since the Travis builds for this repository will initially fail (as evidenced by
 a red &#x2717; appearing in the commit logs instead of a green &#x2714;), the
 programmer is responsible for completing all of the steps needed to satisfy the
 requirements for the assignment, thus causing a &#x2714; to instead appear in
 the commit logs.

--->

## Introduction

This assignment requires a programmer to implement and test the methods provided
by a complete implementation of the `ArrayList` data structure. More details
about the purpose and implementation of the `ArrayList` are available in Section
7.2 of the textbook. Please note that this assignment will also require you to
read and use Java classes that contain a test suite. Specifically, the
programmer is responsible for learning how to run and extend a test suite
written in the JUnit testing framework, as explained in Section 1.9. As verified
by [Checkstyle](https://github.com/checkstyle/checkstyle), the source code for
all of the Java classes must adhere to all of the requirements in the [Google
Java Style Guide](https://google.github.io/styleguide/javaguide.html).

The programmer is also responsible for writing a reflection, stored in the file
`writing/reflection.md`, that responds to the questions in the assignment sheet
and explains the challenges that you faced and the solutions you developed.
Please note that this is a Markdown file that must adhere to the standards
described in the [Markdown Syntax
Guide](https://guides.github.com/features/mastering-markdown/). Remember, you
can preview the contents of a comitted Markdown file by clicking on the name of
the file in your GitHub repository. Finally, don't forget that your
`writing/reflection.md` file should adhere to the Markdown standards established
by the [Markdown linting tool](https://github.com/markdownlint/markdownlint) and
the writing standards set by the [Proselint tool](http://proselint.com/).

The source code in the submitted Java source code files must also pass
additional tests set by the [GatorGrader
tool](https://github.com/gkapfham/gatorgrader). For instance, GatorGrader will
check to ensure that `ArrayList` has `println` statements that can produce the
output from interacting with this array-based structure. GatorGrader will also
run a JUnit test suite that will perform many checks on your implementation of
the Java classes. Critically, the focus of this assignment is to ensure that you
can implement an `ArrayList` that passes the entire test suite. More details
about the GatorGrader checks are included later in this document and in the
assignment sheet.

When you use the `git commit` command to transfer your source code to your
GitHub repository, [Travis CI](https://travis-ci.com/) will initialize a build
of your assignment, checking to see if it meets all of the requirements. If both
your source code and writing meet all of the established requirements, then you
will see a green &#x2714; in the listing of commits in GitHub. If your
submission does not meet the requirements, a red &#x2717; will appear instead.
The instructor will reduce a programmer's grade for this assignment if the red
&#x2717; appears on the last commit in GitHub immediately before the
assignment's due date.

A carefully formatted assignment sheet for this project provides more details
about the steps that a computer scientist should take to complete this
assignment. You can view this assignment sheet by visiting the listing of
laboratories on the course web site.

## Learning

If you have not done so already, please read all of the relevant [GitHub
Guides](https://guides.github.com/) that explain how to use many of the features
that GitHub provides. In particular, please make sure that you have read the
following GitHub guides: [Mastering
Markdown](https://guides.github.com/features/mastering-markdown/), [Hello
World](https://guides.github.com/activities/hello-world/), and [Documenting Your
Projects on GitHub](https://guides.github.com/features/wikis/). Each of these
guides will help you to understand how to use both [GitHub](http://github.com) and
[GitHub Classroom](https://classroom.github.com/).

To do well on this assignment, you should also read Section 1.5.2 to learn more
about iteration constructs and Section 1.9 to learn more about testing. Please
read all of the content and study all of the technical diagrams and source code
segments in Sections 7.1 and 7.2. Finally, please see the course instructor or
one of the teaching assistants or tutors if you have questions about any of
these reading assignments.

## Commands

To get started in using the GatorGrader tool, you can change into the directory
for this assignment and type the command `./gatorgrader.sh --start` in your
terminal. Now, if you want to perform all of the checks that will automatically
evaluate your assignment, you can type the command `./gatorgrader.sh --check`.

Running this command will produce a lot of output that you should carefully
inspect. If the last line of the output indicates that GatorGrader judges that
there are no mistakes in the assignment, then this means that your source code
and writing are passing all of the automated checks. However, if the last line
of the output indicates that there are mistakes, then you will need to
understand what they are and then try to fix them.

You can also complete several important Java programming tasks by using the
`gradle` tool. For instance, you can compile (i.e., create bytecode from the
program's source code if it is a correct program) the program using the command
`gradle build`. There are also additional commands that you can type:

- `gradle clean`: clean the project of all the derived files
- `gradle check`: check the quality of the code using Checkstyle
- `gradle build`: create the bytecode from the Java source code
- `gradle run`: run the Java program in the command-line
- `gradle cleanTest`: clean the JUnit test suite of derived files
- `gradle test`: run the JUnit test suite and produce report
- `gradle tasks`: display details about the Gradle system

To run one of these commands, you must be in the home directory for this
assignment where the `build.gradle` file is located. Then, you can type the
command in the terminal and study the output.

If the course instructor publishes a new version of GatorGrader and asks you to
access it, then you need change into the tool's directory by typing `cd
gatorgrader`. Then, you can type the command `git pull` to download the new
source code for the GatorGrader tool. If this command completes successfully,
then you can return to the main directory for this laboratory assignment by
typing `cd ..` and then continuing your work.

## Output

Typing the command `gradle run` in the terminal window produces the following
output for the instructor's version of `labnine.list.ArrayList`. Notice that
this program will create an `ArrayList` of size ten and then first the first and
then the last element. It is critical that your program does not crash by
throwing an exception when performing these operations on an instance of an
`ArrayList`. Finally, please note that this laboratory assignment invites you to
run comprehensive JUnit test suites for two Java classes. While these test
suites do not produce any output, you should carefully inspect their tests so
that you understand their strategy. In particular, it is critically important
that you study and understand every test case in `TestArrayList`!

```
ArrayList before removing first element:
(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)

ArrayList after removing first element:
(8, 7, 6, 5, 4, 3, 2, 1, 0)

ArrayList after removing last element:
(8, 7, 6, 5, 4, 3, 2, 1)
```

## Checking

In addition to making the checks that are mentioned in the introduction to this
document, your final submission must meet the following requirements.

- `ArrayList.java` contains three `println`s to produce the program's output.
- `ArrayList.java` declares a `main` method as `public static void main`.
- The `ArrayList` has methods that pass the provided JUnit test suite.
- Consists of at least five commits beyond the commit number when starting the
  assignment.
- Contains a total of one paragraph of writing for each of the reflection questions.
- Consists of at least five commits beyond the commit number when starting the
  assignment.

## Updates

If the course instructor updates the provided material for this assignment and
you would like to receive these updates, then you can type this command in the
main directory for this assignment:

```
./gatorgrader.sh --update git@github.com:Allegheny-Computer-Science-112-S2018/cs112-S2018-lab9-starter.git
```

You should only need to type this command once; typing the command additional
times may yield an error message but will not negatively influence the state of
your repository. Now, you are ready to download the updates provided by the
course instructor by typing:

```
./gatorgrader.sh --download
```

This second command can be run whenever the course instructor needs to provide
you with new source code for this assignment. However, please note that, if you
have edited the files that the course instructor updated, running the previous
command may lead to Git merge conflicts. If this happens, you may need to
manually resolve them with the help of the instructor or a teaching assistant.

## Travis

This assignment uses [Travis CI](https://travis-ci.com/) to automatically run
the checking programs every time you commit to your GitHub repository. The
checking will start as soon as you have accepted the assignment, thus creating
your own private repository, and the course instructor enables Travis for it. If
you are using Travis for the first time, you will need to authorize Travis CI to
access the private repositories that you created on GitHub.

## Requirements

The GatorGrader software that supports the checking of this assignment was
developed for the following software and versions:

- gradle 4.1
- java 1.8.0
- junit 4.9.0
- mdl 0.4.0
- proselint 0.7.0
- python 3.5.2

## Problems

If you have found a problem with this assignment's provided source code, then
you can go to the [Computer Science 112 Lab 9
Starter](https://github.com/Allegheny-Computer-Science-112-S2018/cs112-S2018-lab9-starter)
repository and create an issue by clicking the "Issues" tab and then clicking
the green "New Issue" button. If you have found a problem with the [GatorGrader
tool](https://github.com/gkapfham/gatorgrader) and the way that it checks you
assignment, then you can follow the aforementioned steps to create an issue in
its repository. To ensure that your issue is properly resolved, please provide
as many details as is possible about the problem that you experienced. If you
discover a problem with the laboratory assignment sheet, then please raise an
issue in the
[cs112-S2018-sheets](https://github.com/Allegheny-Computer-Science-112-S2018/cs112-S2018-sheets)
repository and mention this assignment.

Students who find, and use the appropriate GitHub issue tracker to correctly
document, a mistake in any aspect of this laboratory assignment will receive
free laptop stickers and extra credit towards their grade for it.

## Assistance

If you are having trouble completing any part of this project, then please talk
with either the course instructor or a teaching assistant during the laboratory
session. Alternatively, you may ask questions in the Slack team for this
course. Finally, you can schedule a meeting during the course instructor's
office hours.
