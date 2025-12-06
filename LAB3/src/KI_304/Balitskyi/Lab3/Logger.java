package KI_304.Balitskyi.Lab3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас {@code Logger} призначений для ведення журналу подій (логування)
 * у файл. Використовується для запису станів і дій об’єктів під час роботи програми.
 */
public class Logger {
    private FileWriter fileWriter;

    /**
     * Створює об’єкт {@code Logger}, який записує повідомлення у вказаний файл.
     *
     * @param fileName ім’я файлу для запису логів
     * @throws IOException якщо виникає помилка при створенні або відкритті файлу
     */


    /**
     * Записує повідомлення у файл журналу.
     *
     * @param message текст повідомлення, яке потрібно зберегти
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void log(String message) throws IOException {
        if (fileWriter != null) {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }
    }

    /**
     * Закриває файл журналу, звільняючи ресурси.
     * У разі помилки виводить повідомлення у стандартний потік помилок.
     */
    public void close() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Помилка при закритті файлу: " + e.getMessage());
            }
        }
    }
}
