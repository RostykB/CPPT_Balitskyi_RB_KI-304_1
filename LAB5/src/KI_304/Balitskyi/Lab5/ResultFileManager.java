package KI_304.Balitskyi.Lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас ResultFileManager реалізує методи для запису та читання
 * результатів обчислення функції у текстовому та двійковому форматах.
 * 
 * <p>Використовується у лабораторній роботі №5 для демонстрації
 * роботи з потоками введення/виведення.</p>
 * 
 * @author 
 *     Балiцький Ростислав, KI-304
 * @version 
 *     1.0
 */
public class ResultFileManager {

    /**
     * Запис результатів у текстовий файл.
     *
     * @param filename шлях до файлу
     * @param x аргумент функції
     * @param y результат обчислення
     * @throws IOException якщо виникла помилка під час запису
     */
    public void writeText(String filename, double x, double y) throws IOException {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(String.format("x = %.4f; y = %.4f%n", x, y));
        }
    }

    /**
     * Зчитування результатів із текстового файлу.
     *
     * @param filename шлях до файлу
     * @return список рядків із файла
     * @throws IOException якщо виникла помилка під час читання
     */
    public List<String> readText(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * Запис результатів у двійковий файл.
     *
     * @param filename шлях до файлу
     * @param x аргумент функції
     * @param y результат обчислення
     * @throws IOException якщо виникла помилка під час запису
     */
    public void writeBinary(String filename, double x, double y) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeDouble(x);
            dos.writeDouble(y);
        }
    }

    /**
     * Зчитування результатів із двійкового файлу.
     *
     * @param filename шлях до файлу
     * @return список пар [x, y]
     * @throws IOException якщо виникла помилка під час читання
     */
    public List<double[]> readBinary(String filename) throws IOException {
        List<double[]> results = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                double x = dis.readDouble();
                double y = dis.readDouble();
                results.add(new double[]{x, y});
            }
        }
        return results;
    }
}
