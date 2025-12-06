package KI_304.Balitskyi.Lab3;

/**
 * Клас {@code LifeSupportSystem} моделює систему життєзабезпечення
 * космічного корабля, яка відповідає за рівень кисню на борту.
 * <p>
 * Система дозволяє зменшувати запас кисню під час польоту,
 * перевіряти його критичний рівень і зчитувати поточне значення.
 * </p>
 */
public class LifeSupportSystem {
    private double oxygenLevel;

    /**
     * Конструктор із заданим рівнем кисню.
     *
     * @param oxygenLevel початковий рівень кисню (у відсотках або умовних одиницях)
     */
    public LifeSupportSystem(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    /**
     * Конструктор за замовчуванням.
     * Встановлює рівень кисню 100%.
     */
    public LifeSupportSystem() {
        this.oxygenLevel = 100.0;
    }

    /**
     * Повертає поточний рівень кисню.
     *
     * @return поточний рівень кисню
     */
    public double getOxygenLevel() {
        return oxygenLevel;
    }

    /**
     * Зменшує рівень кисню на задану кількість.
     * Рівень не може впасти нижче 0.
     *
     * @param amount кількість кисню, що споживається
     */
    public void consumeOxygen(double amount) {
        oxygenLevel = Math.max(0, oxygenLevel - amount);
    }

    /**
     * Перевіряє, чи є рівень кисню критично низьким.
     *
     * @return {@code true}, якщо рівень менше 20%; {@code false} інакше
     */
    public boolean isCritical() {
        return oxygenLevel < 20.0;
    }
}
