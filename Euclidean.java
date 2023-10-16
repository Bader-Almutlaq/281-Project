import java.util.Scanner;

public class Euclidean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack<Integer> numbers = new LinkedStack<>();

        System.out.print("\nEnter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.println("---------------");

        System.out.println("Step 1: Using Euclidean algorithm to find GCD for " + num1 + " and " + num2 + " :");
        int gcd = calculateGCD(num1, num2, numbers);

        System.out.println("---------------");

        System.out.println("# The GCD is " + gcd + " #");

        System.out.println("=======================================");

        System.out.println("Step 2: Working backwards:");
        int arr[] = calculateLinearCombination(numbers, num1, num2);

        System.out.println("---------------");

        System.out.println("s= " + arr[0] + " , t= " + arr[1]);
        scanner.close();
    }

    public static int calculateGCD(int a, int b, LinkedStack<Integer> numbers) {

        while (b != 0) {
            int quotient = a / b;
            int remainder = a % b;
            System.out.println(a + " = " + quotient + " x " + b + " + " + remainder);

            if (remainder != 0) {
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

    public static int[] calculateLinearCombination(LinkedStack<Integer> numbers, int num1, int num2) {
        if (numbers.empty())
            return null;

        int arr[] = new int[2];

        int gcd = numbers.pop();
        int y = numbers.pop();
        int qy = numbers.pop();
        int x = numbers.pop();
        int qx = 1;
        System.out.println(gcd + " = " + x + " - " + qy + " x " + y);

        while (!numbers.empty()) {
            int tempY = numbers.pop();
            int z3 = numbers.pop();
            int z2 = numbers.pop();
            int z1 = numbers.pop();

            if (tempY == y) {
                System.out
                        .println(gcd + " = " + qx + " x " + x + " - " + qy + " x " + " ( " + z1 + " - " + z2 + " x " + z3
                                + " )");
                qx += (qy * z2);
                y = z1;
                System.out.println(gcd + " = " + qx + " x " + x + " - " + qy + " x " + y);

            } else {
                System.out
                        .println(gcd + " = " + qx + " x " + " ( " + z1 + " - " + z2 + " x " + z3 + " )" + " - " + qy
                                + " x " + y);
                qy += (qx * z2);
                x = z1;
                System.out.println(gcd + " = " + qx + " x " + x + " - " + qy + " x " + y);
            }
        }

        arr[0] = qx;
        arr[1] = -qy;
        return arr;
    }
}
