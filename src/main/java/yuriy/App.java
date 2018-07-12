package yuriy;





import org.apache.commons.lang3.tuple.Pair;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        calculateQuadraticEquation();
    }

    private static void calculateQuadraticEquation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Program for Discriminant: Please fill the data !");
        double a = readFromConsole("a");
        double b = readFromConsole("b");
        double c = readFromConsole("c");
        in.close();
        double discriminant = calculateDiscriminant(a, b, c);
        if (discriminant < 0) {
            System.out.println("Roots could not be calculated");
        } else if (discriminant == 0) {
            double root = calculateSingleRoot(b, a);
            System.out.println("Equation has single root: " + root);
        } else {
            Pair<Double, Double> roots = calculateTwoRoot(a, b, c);
            System.out.println("Equation has two roots: " + roots.getLeft() + " ," + roots.getRight());
        }
    }

    private static double calculateDiscriminant(double a, double b, double c) {

        double discriminant = (b * b) - (4 * a * c);
        System.out.println("DISCRIMINANT: " + discriminant);
        return discriminant;
    }

    private static double calculateSingleRoot(double a, double b) {
        return -b / 2 * a;
    }

    private static Pair<Double, Double> calculateTwoRoot(double a, double b, double c) {
        double root1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        double root2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        return Pair.of(root1,root2);
    }

    private static double readFromConsole(String name) {
        System.out.println(String.format("Type %s: ", name));
        Scanner in = new Scanner(System.in);
        double value;
        try {
            value = in.nextDouble();
        } catch (Exception ex) {
            System.out.println("Value must be digit");
            value = readFromConsole(name);
        }
        return value;
    }
}
