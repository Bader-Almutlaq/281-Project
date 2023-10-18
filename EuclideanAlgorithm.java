public class EuclideanAlgorithm {
    private static LinkedStack<Integer> numbers; // a Stack to store the equations.

    public static int calculateGCD(int a, int b) {
        if (numbers == null) // If the stack was not created.
            numbers = new LinkedStack<Integer>();

        emptyStack(); // Empty the stack from the previous operations.

        if (b > a) { // Swapping if the second number is bigger.
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) { // Going through the loop until the remainder equals zero
            int quotient = a / b;
            int remainder = a % b;
            System.out.println(a + " = " + quotient + " x " + b + " + " + remainder);

            if (remainder != 0) { // Filing the stack but not including the last equation
                numbers.push(a);
                numbers.push(quotient);
                numbers.push(b);
                numbers.push(remainder);
            }

            a = b;
            b = remainder;
        }
        return a;
    }

    public static int[] calculateLinearCombination(int num1, int num2) {
        if (numbers == null || numbers.empty()) // If the stack is not created or empty we call calculateGCD().
            calculateGCD(num1, num2);

        int arr[] = new int[2]; // Array that stores the result.

        // Popping the numbers in order to work backward
        int gcd = numbers.pop(); // GCD was the last number added to the stack.
        int y = numbers.pop();
        int y_Coefficient = numbers.pop();
        int x = numbers.pop();
        int x_Coefficient = 1; // Coefficient of x is always 1 in the first equation.

        System.out.println(gcd + " = " + x + " - " + y_Coefficient + " x " + y); // Printing the first equation.

        while (!numbers.empty()) { // Going through the loop to print the equations until the stack is empty.

            int tempY = numbers.pop(); // The remainder in the equation
            int z3 = numbers.pop(); // These numbers will substitute the remainder
            int z2 = numbers.pop();
            int z1 = numbers.pop();

            if (tempY == y) { // If the remainder is equal to y we substitute in y.
                System.out
                        .println(
                                gcd + " = " + x_Coefficient + " x " + x + " - " + y_Coefficient + " x " + " ( " + z1
                                        + " - " + z2 + " x " + z3
                                        + " )");

                x_Coefficient += (y_Coefficient * z2); // multiply Coefficient
                y = z1; // prepare for the next equation.
                System.out.println(gcd + " = " + x_Coefficient + " x " + x + " - " + y_Coefficient + " x " + y);

            } else { // substitute in x.
                System.out
                        .println(gcd + " = " + x_Coefficient + " x " + " ( " + z1 + " - " + z2 + " x " + z3 + " )"
                                + " - " + y_Coefficient
                                + " x " + y);

                y_Coefficient += (x_Coefficient * z2); // multiply Coefficient
                x = z1; // prepare for the next equation.
                System.out.println(gcd + " = " + x_Coefficient + " x " + x + " - " + y_Coefficient + " x " + y);
            }
        }

        arr[0] = x_Coefficient;
        arr[1] = -y_Coefficient;
        return arr;
    }

    private static void emptyStack() {
        while (!numbers.empty()) // Pop all the numbers in the stack.
            numbers.pop();
    }
}
