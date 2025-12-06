package KI_304.Balitskyi.Lab3;

/**
 * Клас {@code NavigationSystem} відповідає за керування координатами
 * космічного корабля та розрахунок відстані до цілі.
 */
public class NavigationSystem {
    private double x, y, z;

    /**
     * Створює об’єкт {@code NavigationSystem} із заданими координатами.
     *
     * @param x початкова координата по осі X
     * @param y початкова координата по осі Y
     * @param z початкова координата по осі Z
     */
    public NavigationSystem(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Встановлює нові координати корабля.
     *
     * @param x нове значення координати X
     * @param y нове значення координати Y
     * @param z нове значення координати Z
     */
    public void setCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Повертає поточні координати корабля.
     *
     * @return масив із трьох елементів: {x, y, z}
     */
    public double[] getCoordinates() {
        return new double[]{x, y, z};
    }

    /**
     * Обчислює приблизну відстань до пункту призначення.
     * Для демонстрації повертає випадкове значення в діапазоні 1000–6000.
     *
     * @param destination назва пункту призначення
     * @return розрахована відстань у кілометрах
     */
    public double calculateDistance(String destination) {
        return 1000 + Math.random() * 5000;
    }
}
