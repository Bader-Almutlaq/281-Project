# GCD and Linear Combination Calculator

This project takes two numbers as input from the user, calculates their greatest common divisor (GCD) using the Euclidean algorithm, and expresses the GCD as a linear combination of the two input numbers. Each step in the process of finding the linear combination is printed out.

## Files

The project contains the following files:

- `Main.java`: Contains the main class that handles user input and displays the results.
- `EuclideanAlgorithm.java`: Contains the implementation of the Euclidean algorithm and the extended Euclidean algorithm for finding the linear combination.
- `Node.java`: Represents a node in a linked list, used for the stack implementation.
- `LinkedStack.java`: Implements a stack using a linked list.

## Usage

1. **Compile the project**:
    ```sh
    javac Main.java EuclideanAlgorithm.java Node.java LinkedStack.java
    ```

2. **Run the project**:
    ```sh
    java Main
    ```

3. **Follow the prompts** to input two numbers. The program will display the steps to find the GCD and the linear combination.

## Euclidean Algorithm

The Euclidean algorithm is an efficient method for computing the greatest common divisor (GCD) of two integers. The algorithm is based on the principle that the GCD of two numbers also divides their difference.

### Steps

1. Divide the larger number by the smaller number.
2. Replace the larger number with the smaller number and the smaller number with the remainder from step 1.
3. Repeat until the remainder is 0. The non-zero remainder just before this step is the GCD.

## Extended Euclidean Algorithm

The extended Euclidean algorithm not only computes the GCD of two integers `a` and `b` but also finds two integers `s` and `t` such that:
GCD(a, b) = a * s + b * t

### Steps

1. Use the Euclidean algorithm to find the GCD.
2. Track the coefficients of the linear combination through each step of the algorithm.
3. Work backwards through the steps to express the GCD as a linear combination of the original numbers.

## Example

### Input
```
Enter the first number: 240
Enter the second number: 46
```

### Output
```
---------------
Step 1: Using Euclidean algorithm to find GCD for 240 and 46 :
240 = 5 x 46 + 10
46 = 4 x 10 + 6
10 = 1 x 6 + 4
6 = 1 x 4 + 2
4 = 2 x 2 + 0
---------------
# The GCD is 2 #
=======================================
Step 2: Working backwards:
---------------
2 = 6 - 1 x 4
2 = 6 - 1 x (10 - 1 x 6)
2 = 2 x 6 - 1 x 10
2 = 2 x (46 - 4 x 10) - 1 x 10
2 = 2 x 46 - 9 x 10
2 = 2 x 46 - 9 x (240 - 5 x 46)
2 = 47 x 46 - 9 x 240
---------------
s= 47 , t= -9
```
This output shows the steps taken to find the GCD using the Euclidean algorithm and then expresses the GCD as a linear combination of the input numbers.
