public class EuclideanAlgorithm {
    private static LinkedStack<Integer> numbers;

    public static int calculateGCD(int a, int b) {
        if (numbers == null)
            numbers = new LinkedStack<Integer>();

        emptyStack();
        
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

    public static int[] calculateLinearCombination(int num1, int num2) {
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
                        .println(
                                gcd + " = " + qx + " x " + x + " - " + qy + " x " + " ( " + z1 + " - " + z2 + " x " + z3
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

    private static void emptyStack() {
        while (!numbers.empty())
            numbers.pop();
    }
}
