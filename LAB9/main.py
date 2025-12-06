from spaceship import SpaceShip
from reusable_spaceship import ReusableSpaceShip

# Точка входу в програму
def main():
    # Створення звичайного корабля
    ship = SpaceShip("Orion", 4)
    # Створення багаторазового корабля
    shuttle = ReusableSpaceShip("Falcon-9", 6, 30, 3)

    # Вивід інформації про кораблі
    print(ship.info())
    ship.launch()
    ship.land()

    print()
    print(shuttle.info())

    # Завантаження вантажу і запуск
    shuttle.load_cargo(20)
    shuttle.launch()

    print()
    # Перевантаження — перевірка обмеження
    shuttle.load_cargo(35)
    shuttle.launch()

    print()
    # Імітація пошкодження та ремонту
    shuttle.launch()
    shuttle.repair()
    shuttle.launch()

# Запуск програми
if __name__ == "__main__":
    main()
