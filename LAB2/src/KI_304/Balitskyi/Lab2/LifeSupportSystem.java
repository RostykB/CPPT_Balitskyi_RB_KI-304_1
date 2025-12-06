package KI_304.Balitskyi.Lab2;

/**
 * Клас LifeSupportSystem представляє систему життєзабезпечення космічного корабля,
 * яка контролює рівень кисню на борту.
 */
public class LifeSupportSystem {
    private double oxygenLevel;

    /**
     * Конструктор для створення системи життєзабезпечення з заданим рівнем кисню.
     *
     * @param oxygenLevel Початковий рівень кисню у відсотках
     */
    public LifeSupportSystem(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    /**
     * Конструктор за замовчуванням, який створює систему життєзабезпечення з рівнем кисню 100%.
     */
    public LifeSupportSystem() {
        this.oxygenLevel = 100.0;
    }

    /**
     * Метод для отримання поточного рівня кисню.
     *
     * @return Поточний рівень кисню у відсотках
     */
    public double getOxygenLevel() {
        return oxygenLevel;
    }
}
