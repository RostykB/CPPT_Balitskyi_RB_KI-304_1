package KI_304.Balitskyi.Lab3;

import java.io.IOException;

/**
 * Клас {@code ReusableSpaceship} представляє багаторазовий космічний корабель,
 * який може виконувати кілька польотів, запускати місії та повернутися для повторного використання.
 * <p>
 * Наслідує {@link AbstractSpaceship} та реалізує інтерфейс {@link IMission}.
 * Під час польоту відслідковується кількість здійснених рейсів.
 * </p>
 */
public class ReusableSpaceship extends AbstractSpaceship implements IMission {

    /** Лічильник кількості здійснених польотів. */
    private int flightCount;

    /**
     * Конструктор класу {@code ReusableSpaceship}.
     *
     * @param engine двигун корабля
     * @param navigationSystem навігаційна система
     * @param lifeSupportSystem система життєзабезпечення
     * @param name назва корабля
     * @param shieldEnergy початкова енергія щита
     * @param shieldActive стан щита ({@code true}, якщо активний)
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public ReusableSpaceship(Engine engine,
                             NavigationSystem navigationSystem,
                             LifeSupportSystem lifeSupportSystem,
                             String name,
                             double shieldEnergy,
                             boolean shieldActive) throws IOException {
        super(engine, navigationSystem, lifeSupportSystem, name, shieldEnergy, shieldActive);
        this.flightCount = 0;
    }

    /**
     * Запускає корабель.
     * <p>
     * Перевіряє наявність пального. Якщо пального недостатньо, політ не відбувається.
     * </p>
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void launch() throws IOException {
        if (!engine.consumeFuel(50)) {
            logger.log("Not enough fuel to launch!");
            System.out.println("Not enough fuel to launch!");
            return;
        }
        engine.start();
        flightCount++;
        logger.log("Launch successful. Flight #" + flightCount);
        System.out.println("Launch successful. Flight #" + flightCount);
    }

    /**
     * Виконує посадку корабля.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void land() throws IOException {
        if (!engine.isRunning()) {
            logger.log("Engine already off. Landing anyway.");
        }
        engine.stop();
        logger.log("Landing completed.");
        System.out.println("Landing completed.");
    }

    /**
     * Виконує місію до заданого пункту призначення.
     * <p>
     * Розраховує відстань, витрачає паливо та кисень.
     * Логи відображають успішність виконання місії.
     * </p>
     *
     * @param destination пункт призначення місії
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void performMission(String destination) throws IOException {
        logger.log("Mission started to " + destination);
        System.out.println("Mission started to " + destination);

        double distance = navigationSystem.calculateDistance(destination);
        logger.log("Calculated distance: " + distance + " km");
        System.out.println("Calculated distance: " + distance + " km");

        if (!engine.consumeFuel(distance / 10)) {
            logger.log("Mission failed: not enough fuel.");
            System.out.println("Mission failed: not enough fuel.");
            return;
        }

        lifeSupportSystem.consumeOxygen(distance / 100);
        logger.log("Mission completed. Oxygen left: " + lifeSupportSystem.getOxygenLevel());
        System.out.println("Mission completed. Oxygen left: " + lifeSupportSystem.getOxygenLevel());
    }

    /**
     * Повертає кількість здійснених польотів корабля.
     *
     * @return кількість польотів
     */
    public int getFlightCount() {
        return flightCount;
    }
}
