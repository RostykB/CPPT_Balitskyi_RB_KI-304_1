package KI_304.Balitskyi.Lab2;

/**
 * Клас NavigationSystem представляє систему навігації космічного корабля, яка дозволяє встановлювати координати для переміщення в просторі.
 */
public class NavigationSystem {
    private double x, y, z;

    /**
     * Конструктор для створення навігаційної системи з заданими початковими координатами.
     *
     * @param x Початкова координата X
     * @param y Початкова координата Y
     * @param z Початкова координата Z
     */
    public NavigationSystem(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод для встановлення нових координат.
     *
     * @param x Нова координата X
     * @param y Нова координата Y
     * @param z Нова координата Z
     */
    public void setCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
