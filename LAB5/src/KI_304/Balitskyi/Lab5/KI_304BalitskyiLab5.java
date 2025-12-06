package KI_304.Balitskyi.Lab5;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Тестова програма для демонстрації роботи класів CtgCalculator і ResultFileManager.
 * 
 * <p>Програма обчислює значення ctg(x), записує його у файли (текстовий і двійковий)
 * і виводить вміст цих файлів на екран.</p>
 * 
 * @author 
 *     Балiцький Ростислав, KI-304
 * @version 
 *     1.0
 */
public class KI_304BalitskyiLab5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CtgCalculator calculator = new CtgCalculator();
        ResultFileManager fileManager = new ResultFileManager();

        try {
            System.out.print("Enter x (in radians): ");
            double x = scanner.nextDouble();
            double y = calculator.calculate(x);

            System.out.printf("Result: y = %.4f%n", y);

            // Запис у файли
            fileManager.writeText("Z:/ResultText.txt", x, y);
            fileManager.writeBinary("ResultBinary.bin", x, y);
            System.out.println("Results written to text and binary files.");

            // Зчитування з текстового файлу
            List<String> textData = fileManager.readText("ResultText.txt");
            System.out.println("\n--- Text file content ---");
            textData.forEach(System.out::println);

            // Зчитування з двійкового файлу
            List<double[]> binData = fileManager.readBinary("ResultBinary.bin");
            System.out.println("\n--- Binary file content ---");
            for (double[] pair : binData) {
                System.out.printf("x = %.4f; y = %.4f%n", pair[0], pair[1]);
            }

        } catch (ArithmeticException e) {
            System.err.println("Calculation error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
