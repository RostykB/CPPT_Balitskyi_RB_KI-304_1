package KI_304.Balitskyi.Lab3;

/**
 * Клас {@code Engine} моделює роботу двигуна космічного корабля.
 * <p>
 * Зберігає стан роботи двигуна (увімкнено/вимкнено) та рівень пального.
 * Дозволяє запускати, зупиняти двигун і споживати паливо під час польоту.
 * </p>
 *
 * <p>Використовується у класі {@link ReusableSpaceship} для керування польотом корабля.</p>
 *
 * @author
 *     Ростислав Баліцький
 * @version
 *     1.0
 */
public class Engine {
    /** Поточний стан двигуна — {@code true}, якщо запущено. */
    private boolean isRunning;

    /** Кількість пального, доступного в системі (у літрах або одиницях умовного палива). */
    private double fuel;

    /**
     * Конструктор класу {@code Engine}.
     *
     * @param isRunning
     *     початковий стан двигуна ({@code true}, якщо запущено)
     * @param fuel
     *     кількість пального при створенні двигуна
     */
    public Engine(boolean isRunning, double fuel) {
        this.isRunning = isRunning;
        this.fuel = fuel;
    }

    /**
     * Запускає двигун.
     */
    public void start() { isRunning = true; }

    /**
     * Зупиняє двигун.
     */
    public void stop() { isRunning = false; }

    /**
     * Перевіряє, чи працює двигун.
     *
     * @return {@code true}, якщо двигун запущений; {@code false}, якщо вимкнений
     */
    public boolean isRunning() { return isRunning; }

    /**
     * Повертає поточний рівень пального.
     *
     * @return кількість пального
     */
    public double getFuel() { return fuel; }

    /**
     * Встановлює новий рівень пального.
     *
     * @param fuel
     *     нове значення кількості пального
     */
    public void setFuel(double fuel) { this.fuel = fuel; }

    /**
     * Зменшує кількість пального на задану величину.
     * <p>
     * Якщо пального достатньо — воно споживається, і метод повертає {@code true}.
     * Якщо пального менше, ніж потрібно — паливо не змінюється, метод повертає {@code false}.
     * </p>
     *
     * @param amount
     *     кількість пального, яку потрібно спожити
     * @return {@code true}, якщо паливо успішно спожито; {@code false}, якщо його недостатньо
     */
    public boolean consumeFuel(double amount) {
        if (fuel >= amount) {
            fuel -= amount;
            return true;
        }
        return false;
    }
}
