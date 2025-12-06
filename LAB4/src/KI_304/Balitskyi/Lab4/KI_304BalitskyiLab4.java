package KI_304.Balitskyi.Lab4;

import java.io.IOException;
import java.util.Scanner;

/**
 * Програма-драйвер для класу {@link CtgCalculator}.
 * Дозволяє ввести значення x, обчислити y = ctg(x),
 * обробити можливі помилки та записати результат у файл.
 * 
 * @author 
 *     Балiцький Ростислав, KI-304
 * @version 
 *     1.0
 */
public class KI_304BalitskyiLab4 {

    /**
     * Головний метод програми.
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CtgCalculator calculator = new CtgCalculator();

        try {
            System.out.print("Enter x (in radians): ");
            double x = scanner.nextDouble();

            double y = calculator.calculate(x);
            System.out.printf("Result: y = %.4f%n", y);

            calculator.writeResultToFile("Z:/Result.txt", x, y);
            System.out.println("The result has been written to Result.txt");

        } catch (ArithmeticException e) {
            System.err.println("Calculation error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File wrirting error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
