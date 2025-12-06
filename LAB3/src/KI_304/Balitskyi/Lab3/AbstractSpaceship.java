package KI_304.Balitskyi.Lab3;

import java.io.IOException;

/**
 * Абстрактний клас {@code AbstractSpaceship} представляє базову модель космічного корабля.
 * <p>
 * Він містить спільні характеристики та функціональність для всіх типів кораблів:
 * двигун ({@link Engine}), навігаційну систему ({@link NavigationSystem}),
 * систему життєзабезпечення ({@link LifeSupportSystem}), захисне поле (щит)
 * та базові методи моніторингу стану.
 * </p>
 *
 * <p>Клас також реалізує базовий механізм логування через {@link Logger}.</p>
 *
 * <p>Наслідується такими класами, як {@link ReusableSpaceship}.</p>
 *
 * @author
 *     Ростислав Баліцький
 * @version
 *     1.0
 */
public abstract class AbstractSpaceship {

    /** Об’єкт двигуна корабля. */
    protected final Engine engine;

    /** Об’єкт навігаційної системи корабля. */
    protected NavigationSystem navigationSystem;

    /** Об’єкт системи життєзабезпечення корабля. */
    protected LifeSupportSystem lifeSupportSystem;

    /** Назва корабля. */
    protected String name;

    /** Поточний рівень енергії захисного щита. */
    protected double shieldEnergy;

    /** Статус захисного поля: {@code true}, якщо активне. */
    protected boolean shieldActive;

    /** Об’єкт для ведення логів дій корабля. */
    protected Logger logger;

    /**
     * Конструктор класу {@code AbstractSpaceship}.
     * <p>
     * Ініціалізує всі основні системи корабля та створює файл логів.
     * </p>
     *
     * @param engine
     *     двигун корабля
     * @param navigationSystem
     *     система навігації
     * @param lifeSupportSystem
     *     система життєзабезпечення
     * @param name
     *     назва корабля
     * @param shieldEnergy
     *     енергія щита при старті
     * @param shieldActive
     *     стан щита ({@code true}, якщо активний)
     * @throws IOException
     *     якщо виникає помилка під час створення або запису лог-файлу
     */
    public AbstractSpaceship(Engine engine,
                             NavigationSystem navigationSystem,
                             LifeSupportSystem lifeSupportSystem,
                             String name,
                             double shieldEnergy,
                             boolean shieldActive) throws IOException {
        this.engine = engine;
        this.navigationSystem = navigationSystem;
        this.lifeSupportSystem = lifeSupportSystem;
        this.name = name;
        this.shieldEnergy = shieldEnergy;
        this.shieldActive = shieldActive;
        this.logger = new Logger("absract_spaceship_log.txt");
        logger.log("Spaceship " + name + " constructed.");
    }

    /**
     * Запускає космічний корабель.
     *
     * @throws IOException
     *     якщо виникає помилка під час логування або активації систем
     */
    public abstract void launch() throws IOException;

    /**
     * Виконує посадку корабля.
     *
     * @throws IOException
     *     якщо виникає помилка під час логування або зупинки систем
     */
    public abstract void land() throws IOException;

    /**
     * Перевіряє рівень кисню в системі життєзабезпечення.
     *
     * @return поточний рівень кисню
     * @throws IOException
     *     якщо виникає помилка під час запису в лог
     */
    public double checkOxygenLevel() throws IOException {
        double oxygenLevel = lifeSupportSystem.getOxygenLevel();
        logger.log("Oxygen level: " + oxygenLevel);
        return oxygenLevel;
    }

    /**
     * Перевіряє рівень пального у двигуні.
     *
     * @return кількість пального
     * @throws IOException
     *     якщо виникає помилка під час запису в лог
     */
    public double checkFuelLevel() throws IOException {
        logger.log("Fuel level: " + engine.getFuel());
        return engine.getFuel();
    }

    /**
     * Перевіряє стан захисного поля.
     *
     * @return рядок із описом стану щита
     * @throws IOException
     *     якщо виникає помилка під час запису в лог
     */
    public String checkShieldStatus() throws IOException {
        String status = "Shield " + (shieldActive ? "active" : "inactive") +
                ". Energy: " + shieldEnergy;
        logger.log(status);
        return status;
    }

    /**
     * Закриває логер, припиняючи запис у лог-файл.
     *
     * @throws IOException
     *     якщо виникає помилка під час закриття лог-файлу
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    /**
     * Повертає текстове представлення корабля зі всіма основними характеристиками.
     *
     * @return текстовий опис корабля
     */
    @Override
    public String toString() {
        return "Spaceship{" +
                "engine=" + engine +
                ", navigationSystem=" + navigationSystem +
                ", lifeSupportSystem=" + lifeSupportSystem +
                ", name='" + name + '\'' +
                ", shieldEnergy=" + shieldEnergy +
                ", shieldActive=" + shieldActive +
                '}';
    }
}
