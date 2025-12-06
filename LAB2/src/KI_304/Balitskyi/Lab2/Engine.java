package KI_304.Balitskyi.Lab2;

/**
 * Клас Engine представляє двигун космічного корабля.
 * Двигун може запускатися та зупинятися, також містить інформацію про поточний рівень палива.
 */
public class Engine {
    private boolean isRunning;
    private double fuel;

    /**
     * Конструктор для створення двигуна.
     *
     * @param isRunning Чи працює двигун під час створення
     * @param fuel Початковий рівень палива
     */
    public Engine(boolean isRunning, double fuel) {
        this.isRunning = isRunning;
        this.fuel = fuel;
    }

    /**
     * Метод для запуску двигуна.
     */
    public void start() {
        isRunning = true;
    }

    /**
     * Метод для зупинки двигуна.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Метод для перевірки, чи працює двигун.
     *
     * @return true, якщо двигун працює, false - якщо двигун зупинено
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Метод для встановлення стану роботи двигуна.
     *
     * @param running true, якщо потрібно запустити двигун, false - якщо потрібно зупинити
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Метод для отримання рівня палива.
     *
     * @return Поточний рівень палива
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Метод для встановлення рівня палива.
     *
     * @param fuel Новий рівень палива
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}
