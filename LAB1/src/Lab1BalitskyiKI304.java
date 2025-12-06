
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас <code>Lab1BalitskyiKI304</code> демонструє побудову спеціальної зубчастої матриці символів.
 *
 * <p>Програма:
 * <ul>
 *   <li>зчитує розмір квадратної матриці від користувача;</li>
 *   <li>зчитує символ-заповнювач (один символ);</li>
 *   <li>створює зубчастий масив char[n][]:
 *       <ul>
 *           <li>у верхній половині матриці символи починаються з першої колонки;</li>
 *           <li>у нижній половині – символи починаються з середини матриці.</li>
 *       </ul>
 *   </li>
 *   <li>виводить масив у консоль та одночасно записує у файл "lab1.txt".</li>
 * </ul>
 *
 * @author Balitskyi
 * @version 1.0
 * @since 2025
 */
public class Lab1BalitskyiKI304
{

    /**
     * Головний метод програми.
     * Виконує послідовність дій:
     * <ul>
     *   <li>зчитування розміру матриці;</li>
     *   <li>зчитування символу-заповнювача;</li>
     *   <li>створення та заповнення зубчастої матриці;</li>
     *   <li>вивід матриці у консоль та файл.</li>
     * </ul>
     *
     * @param args аргументи командного рядка (не використовуються)
     * @throws FileNotFoundException якщо файл "lab1.txt" не може бути створений
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);

        int n = readMatrixSize(in);
        char c = readFillerSymbol(in);

        char[][] arr = createJaggedMatrix(n);
        fillJaggedMatrix(arr, c);
        printAndSaveMatrix(arr, "lab1.txt");

        in.close();
    }

    /**
     * Зчитує розмір квадратної матриці від користувача.
     *
     * @param in Scanner для введення даних
     * @return розмір матриці
     */
    public static int readMatrixSize(Scanner in)
    {
        System.out.print("Enter size of matrix: ");
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

    /**
     * Зчитує символ-заповнювач від користувача.
     *
     * @param in Scanner для введення даних
     * @return символ-заповнювач
     */
    public static char readFillerSymbol(Scanner in)
    {
        System.out.print("Enter the character: ");
        String filler = in.nextLine();
        if (filler.length() != 1) {
            System.out.println("You should write only one symbol!");
            System.exit(0);
        }
        return filler.charAt(0);
    }

    /**
     * Створює порожню зубчасту матрицю розміру n.
     *
     * @param n розмір квадратної матриці
     * @return порожня зубчаста матриця
     */
    public static char[][] createJaggedMatrix(int n)
    {
        return new char[n][];
    }

    /**
     * Заповнює зубчасту матрицю символами.
     *
     * <p>Правила заповнення:
     * <ul>
     *   <li>верхня половина: символи починаються з першої колонки;</li>
     *   <li>нижня половина: символи починаються з середини матриці.</li>
     * </ul>
     *
     * @param arr матриця для заповнення
     * @param c символ-заповнювач
     */
    public static void fillJaggedMatrix(char[][] arr, char c) {
        int n = arr.length;
        int half = n / 2;
        for (int i = 0; i < n; i++)
        {
            int jStart = (i < half) ? 0 : half;
            int jEnd = i;
            int count = (jEnd >= jStart) ? (jEnd - jStart + 1) : 0;
            arr[i] = new char[count];
            int idx = 0;
            for (int j = jStart; j <= jEnd; j++) {
                arr[i][idx++] = c;
            }
        }
    }

    /**
     * Виводить зубчасту матрицю у консоль та зберігає її у файл.
     *
     * @param arr матриця для виводу
     * @param filename шлях до файлу
     * @throws FileNotFoundException якщо файл не може бути створений
     */
    public static void printAndSaveMatrix(char[][] arr, String filename) throws FileNotFoundException
    {
        int n = arr.length;
        int half = n / 2;

        PrintWriter fout = new PrintWriter(new File(filename));

        for (int i = 0; i < n; i++) {
            int leadingCols = (i < half) ? 0 : half;

            for (int k = 0; k < leadingCols; k++)
            {
                System.out.print("  ");
                fout.print("  ");
            }

            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
    }
}
