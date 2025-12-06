package KI_304.Balitskyi.Lab3;

import java.io.IOException;

/**
 * Інтерфейс {@code IMission} визначає базовий набір дій,
 * які може виконувати будь-який космічний корабель під час місії.
 * <p>
 * Містить методи для запуску, посадки та виконання польоту до заданої цілі.
 * </p>
 *
 * <p>Імплементується класами, які реалізують логіку космічних операцій,
 * наприклад {@link ReusableSpaceship}.</p>
 *
 * @author
 *     Ростислав Баліцький
 * @version
 *     1.0
 */
public interface IMission {

    /**
     * Запускає космічний корабель.
     *
     * @throws IOException
     *     якщо виникає помилка під час запису в лог або взаємодії з системами корабля
     */
    void launch() throws IOException;

    /**
     * Виконує посадку космічного корабля.
     *
     * @throws IOException
     *     якщо виникає помилка під час запису в лог або обробки даних посадки
     */
    void land() throws IOException;

    /**
     * Виконує місію до певної точки призначення.
     *
     * @param destination
     *     назва планети або іншого місця, куди має полетіти корабель
     * @throws IOException
     *     якщо виникає помилка під час виконання місії або роботи з логом
     */
    void performMission(String destination) throws IOException;
}
