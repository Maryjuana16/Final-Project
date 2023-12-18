/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cramersrule;
import java.util.Scanner;

public class CramersRule {

    public static float determinant(float a, float b, float c, float d) {
        return a * d - b * c;
    }

    public static float determinant(float a, float b, float c, float d, float e, float f, float g, float h, float i) {
        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
    }

    public static void solveSystem2x2(float a1, float b1, float c1, float a2, float b2, float c2) {
        float detA = determinant(a1, b1, a2, b2);

        if (detA == 0) {
            System.out.println("The system has no unique solution (infinite or no solutions).");
        } else {
            float detX = determinant(c1, b1, c2, b2);
            float detY = determinant(a1, c1, a2, c2);

            float x = detX / detA;
            float y = detY / detA;

            System.out.println("Solution:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }

    public static void solveSystem3x3(float a1, float b1, float c1, float d1, float a2, float b2, float c2, float d2, float a3, float b3, float c3, float d3) {
        float detA = determinant(a1, b1, c1, a2, b2, c2, a3, b3, c3);

        if (detA == 0) {
            System.out.println("The system has no unique solution (infinite or no solutions).");
        } else {
            float detX = determinant(d1, b1, c1, d2, b2, c2, d3, b3, c3);
            float detY = determinant(a1, d1, c1, a2, d2, c2, a3, d3, c3);
            float detZ = determinant(a1, b1, d1, a2, b2, d2, a3, b3, d3);

            float x = detX / detA;
            float y = detY / detA;
            float z = detZ / detA;

            System.out.println("Solution:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("z = " + z);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of unknowns (2 or 3): ");
        int unknowns = scanner.nextInt();

        if (unknowns == 2) {
            System.out.print("Enter coefficients for the first equation (a1 b1 c1): ");
            float a1 = scanner.nextFloat();
            float b1 = scanner.nextFloat();
            float c1 = scanner.nextFloat();

            System.out.print("Enter coefficients for the second equation (a2 b2 c2): ");
            float a2 = scanner.nextFloat();
            float b2 = scanner.nextFloat();
            float c2 = scanner.nextFloat();

            solveSystem2x2(a1, b1, c1, a2, b2, c2);
        } else if (unknowns == 3) {
            System.out.print("Enter coefficients for the first equation (a1 b1 c1 d1): ");
            float a1 = scanner.nextFloat();
            float b1 = scanner.nextFloat();
            float c1 = scanner.nextFloat();
            float d1 = scanner.nextFloat();

            System.out.print("Enter coefficients for the second equation (a2 b2 c2 d2): ");
            float a2 = scanner.nextFloat();
            float b2 = scanner.nextFloat();
            float c2 = scanner.nextFloat();
            float d2 = scanner.nextFloat();

            System.out.print("Enter coefficients for the third equation (a3 b3 c3 d3): ");
            float a3 = scanner.nextFloat();
            float b3 = scanner.nextFloat();
            float c3 = scanner.nextFloat();
            float d3 = scanner.nextFloat();

            solveSystem3x3(a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3);
        } else {
            System.out.println("Invalid number of unknowns. Please enter 2 or 3.");
        }

        scanner.close();
    }
}