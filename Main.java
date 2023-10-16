import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.println("---------------");

        System.out.println("Step 1: Using Euclidean algorithm to find GCD for " + num1 + " and " + num2 + " :");
        int gcd = EuclideanAlgorithm.calculateGCD(num1, num2);

        System.out.println("---------------");

        System.out.println("# The GCD is " + gcd + " #");

        System.out.println("=======================================");

        System.out.println("Step 2: Working backwards:");
        int arr[] = EuclideanAlgorithm.calculateLinearCombination(num1, num2);

        System.out.println("---------------");

        System.out.println("s= " + arr[0] + " , t= " + arr[1]);
        System.out.println();
        
        scanner.close();
    }
}
