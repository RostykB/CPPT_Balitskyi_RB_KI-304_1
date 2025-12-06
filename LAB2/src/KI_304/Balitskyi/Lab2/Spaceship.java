package KI_304.Balitskyi.Lab2;

import java.io.IOException;

/**
 * Клас Spaceship представляє космічний корабель, який оснащений двигуном, навігаційною системою,
 * системою життєзабезпечення та захисним полем. Клас також веде логування подій.
 */
public class Spaceship {
    private Engine engine;
    private NavigationSystem navigationSystem;
    private LifeSupportSystem lifeSupportSystem;
    private String name;
    private double shieldEnergy;
    private boolean shieldActive;
    private Logger logger;

    /**
     * Конструктор за замовчуванням, що створює космічний корабель з початковими параметрами.
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Spaceship() throws IOException {
        this(new Engine(false, 500),
                new NavigationSystem(0, 0, 0),
                new LifeSupportSystem(), "Tesla", 1000, false);
        this.logger = new Logger("spaceship_log.txt");

        logger.log(String.format("Spaceship %s is done.", this.toString()));
    }

    /**
     * Конструктор, що дозволяє створити космічний корабель з заданими параметрами.
     *
     * @param engine Двигун корабля
     * @param navigationSystem Навігаційна система корабля
     * @param lifeSupportSystem Система життєзабезпечення
     * @param name Ім'я корабля
     * @param shieldEnergy Початкова енергія щита
     * @param shieldActive Чи активний щит при створенні корабля
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Spaceship(Engine engine,
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

        this.logger = new Logger("spaceship_log.txt");

        logger.log(String.format("Spaceship %s is done.", this.toString()));
    }

    /**
     * Метод для запуску двигуна.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void startEngine() throws IOException {
        engine.start();

        logger.log("The engine is started");
        System.out.println("The engine is started");
    }

    /**
     * Метод для зупинки двигуна.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void stopEngine() throws IOException {
        engine.stop();

        logger.log("The engine was stopped");
        System.out.println("The engine was stopped");
    }

    /**
     * Метод для навігації до заданих координат.
     *
     * @param x Координата X
     * @param y Координата Y
     * @param z Координата Z
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void navigateTo(double x, double y, double z) throws IOException {
        navigationSystem.setCoordinates(x, y, z);

        logger.log(String.format("Set course to coordinates: %s,%s,%s", x, y, z));
        System.out.printf("Set course to coordinates: %s,%s,%s \n", x, y, z);
    }

    /**
     * Метод для перевірки рівня кисню.
     *
     * @return Рівень кисню у відсотках
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public double checkOxygenLevel() throws IOException {
        double oxygenLevel = lifeSupportSystem.getOxygenLevel();

        logger.log(String.format("Oxygen level checked: %s", oxygenLevel));
        System.out.printf("Oxygen level checked: %s\n", oxygenLevel);
        return oxygenLevel;
    }

    /**
     * Метод для дозаправки корабля.
     *
     * @param amount Кількість палива для дозаправки
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void refuel(double amount) throws IOException {
        double fuelLevel = engine.getFuel() + amount;

        if (fuelLevel < 500.0) {
            engine.setFuel(fuelLevel);
        }else {
            logger.log(String.format("The amount of fuel %s to refuel is greater than the tank capacity", amount));
            System.out.printf("The amount of fuel %s to refuel is greater than the tank capacity\n", amount);
        }

        logger.log(String.format("Ship refueled. New fuel level: %s", fuelLevel));
        System.out.printf("Ship refueled. New fuel level: %s\n", fuelLevel);
    }

    /**
     * Метод для перевірки рівня палива.
     *
     * @return Рівень палива у відсотках
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public double checkFuelLevel() throws IOException {
        logger.log(String.format("Fuel level checked: %s", engine.getFuel()));
        System.out.printf("Fuel level checked: %s\n", engine.getFuel());

        return engine.getFuel();
    }

    /**
     * Метод для отримання інформації про корабель.
     *
     * @return Рядок з інформацією про корабель
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public String getInfo() throws IOException {
        String info = String.format("Spaceship: %s, Fuel: %s, Oxygen: %s", name, engine.getFuel(), checkOxygenLevel());

        logger.log(String.format("Get info about %s", info));
        System.out.printf("Get info about %s\n", info);
        return info;
    }

    /**
     * Метод для активації захисного поля.
     *
     * @return true, якщо поле успішно активовано, false - якщо недостатньо енергії
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public boolean activateShield() throws IOException {
        if (shieldEnergy >= 20.0 && !shieldActive) {
            shieldActive = true;
            shieldEnergy -= 20.0;

            logger.log(String.format("Protective field activated. Shield energy remaining: %s", shieldEnergy));
            System.out.printf("Protective field activated. Shield energy remaining: %\n", shieldEnergy);
            return true;
        } else {
            logger.log("Failed to activate the protective field. Insufficient power or the shield is already active.");
            System.out.println(" Failed to activate the protective field. Insufficient power or the shield is already active.\n");
            return false;
        }
    }

    /**
     * Метод для деактивації захисного поля.
     *
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void deactivateShield() throws IOException {
        if (shieldActive) {
            shieldActive = false;

            logger.log(String.format("Protective field deactivated. Current shield energy: %s", shieldEnergy));
            System.out.printf("Protective field deactivated. Current shield energy: %s\n", shieldEnergy);
        } else {
            logger.log("The protective field has already been deactivated.");
            System.out.println("The protective field has already been deactivated.\n");
        }
    }

    /**
     * Метод для перевірки стану щита.
     *
     * @return Рядок зі станом щита
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public String checkShieldStatus() throws IOException {
        String status = "Shield " + (shieldActive ? "active" : "non-active") +
                ". Energy of shield: " + shieldEnergy + "%";

        logger.log(String.format("Shield condition checked: %s", status));
        System.out.printf("Shield condition checked: %s", status);
        return status;
    }

    /**
     * Метод для коректного закриття логера.
     *
     * @throws IOException якщо виникає помилка під час закриття лог-файлу.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "engine=" + engine +
                ", navigationSystem=" + navigationSystem +
                ", lifeSupportSystem=" + lifeSupportSystem +
                ", name='" + name + '\'' +
                ", shieldEnergy=" + shieldEnergy +
                ", shieldActive=" + shieldActive +
                ", logger=" + logger +
                '}';
    }
}
