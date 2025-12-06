package KI_304.Balitskyi.Lab5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас CtgCalculator реалізує метод обчислення функції y = ctg(x)
 * і запис результатів у файл.
 * 
 * <p>Під час виконання може виникнути виключення {@link ArithmeticException},
 * якщо функція ctg(x) не визначена для заданого значення x.</p>
 * 
 * @author 
 *     Балiцький Ростислав, KI-304
 * @version 
 *     1.0
 */
public class CtgCalculator {

    /**
     * Обчислює значення функції y = ctg(x)
     * 
     * @param x значення аргументу (у радіанах)
     * @return результат обчислення y = 1 / tan(x)
     * @throws ArithmeticException якщо tan(x) = 0 (ctg(x) не існує)
     */
    public double calculate(double x) throws ArithmeticException {
        double tanX = Math.tan(x);
        if (Math.abs(tanX) < 1e-10) {
            throw new ArithmeticException("Error: ctg(x) does not exist with x = " + x);
        }
        return 1.0 / tanX;
    }

    /**
     * Записує результат у текстовий файл.
     * 
     * @param filename шлях до файлу
     * @param x        аргумент функції
     * @param y        результат обчислення
     * @throws IOException якщо виникла помилка запису
     */
    public void writeResultToFile(String filename, double x, double y) throws IOException {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(String.format("x = %.4f; y = %.4f%n", x, y));
        }
    }
}
