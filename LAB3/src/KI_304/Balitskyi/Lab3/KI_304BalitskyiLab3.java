package KI_304.Balitskyi.Lab3;

import java.io.IOException;

/**
 * Головний клас лабораторної роботи №3.
 * <p>
 * Програма моделює роботу багаторазового космічного корабля, який має
 * декілька підсистем — двигун, систему навігації та систему життєзабезпечення.
 * Корабель може здійснювати запуск, виконувати місії на різні планети
 * та повертатися для повторного використання.
 * </p>
 *
 * <p>Основна мета — продемонструвати взаємодію між об'єктами,
 * обробку винятків та використання логування.</p>
 *
 * @author
 *     Ростислав Баліцький
 * @version
 *     1.0
 */
public class KI_304BalitskyiLab3 {

    /**
     * Точка входу в програму.
     * <p>
     * У методі створюються всі підсистеми корабля, ініціалізується об'єкт
     * {@link ReusableSpaceship}, виконується перевірка стану ресурсів,
     * запуск, місія та посадка. Наприкінці програма закриває логер.
     * </p>
     *
     * @param args
     *     аргументи командного рядка (не використовуються)
     *
     * @throws IOException
     *     якщо під час створення або запису лог-файлу виникає помилка
     */
    public static void main(String[] args) {
        try {
            // Створюємо всі системи корабля
            Engine engine = new Engine(false, 1000);
            NavigationSystem nav = new NavigationSystem(0, 0, 0);
            LifeSupportSystem life = new LifeSupportSystem(100);

            // Створюємо багаторазовий космічний корабель
            ReusableSpaceship spaceship = new ReusableSpaceship(
                    engine,
                    nav,
                    life,
                    "Enterprise-X",
                    100,
                    false
            );

            // Перевіряємо стан ресурсів
            System.out.println("Fuel level: " + spaceship.checkFuelLevel());
            System.out.println("Oxygen level: " + spaceship.checkOxygenLevel());
            System.out.println("Shield status: " + spaceship.checkShieldStatus());

            // Виконуємо місію
            spaceship.launch();
            spaceship.performMission("Mars");
            spaceship.land();

            // Другий політ для демонстрації багаторазовості
            spaceship.launch();
            spaceship.performMission("Moon");
            spaceship.land();

           

            System.out.println("Total flights: " + spaceship.getFlightCount());

            // Закриваємо логер
            spaceship.closeLogger();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
