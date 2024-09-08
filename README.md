# Minimum Maximum Path Problem

## Problem Statement

Given a triangle of numbers:

- We define a **path** in the triangle to be a sequence of numbers starting from the top and ending at the bottom of the
  triangle.
- We define minimal path to be a path such that the sum of the numbers in the path is the smallest among all possible
  paths through the triangle.

### Example

Consider the triangle below:

```
    7
   6 3
  3 8 5
11 2 10 9
```

The minimal path is `7 -> 6 -> 3 -> 2` and the sum of the numbers in the minimal path is `18`.

## Resources

In this project, we provide some resources to help you get started in the [`data`](./data) folder.

- `triangle-example.txt`: A sample triangle of numbers.
- `data_small.txt`: A triangle of numbers with 50 rows.
- `data_big.txt`: A triangle of numbers with 2000 rows.

## Gettings Started

In order to execute the program, you need to do the following:

1. Clone the repository
2. Open the terminal and navigate to the directory where the repository is located
3. Run the following command to create the artifact:

```
sbt assembly
```

4. Run the following command to execute the program:

```
java -jar target/scala-2.12/minmax-triangle-path.jar <path-to-file>
```

The `<path-to-file>` should be the path to a file containing the triangle of numbers.

### Example

```
java -jar target/scala-2.12/minmax-triangle-path.jar data/triangle-example.txt
```



