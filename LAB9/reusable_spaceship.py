from spaceship import SpaceShip

# Клас ReusableSpaceShip — похідний від SpaceShip
# Реалізує логіку багаторазового використання корабля
class ReusableSpaceShip(SpaceShip):
    def __init__(self, name, crew_size, cargo_capacity, max_reuses):
        # Виклик конструктора базового класу
        super().__init__(name, crew_size)
        # Додаткові параметри для багаторазового корабля
        self.cargo_capacity = cargo_capacity   # Максимальна вантажопідйомність (тонн)
        self.max_reuses = max_reuses           # Максимальна кількість запусків
        self.reuse_count = 0                   # Кількість уже виконаних польотів
        self.hull_integrity = 100              # Цілісність корпусу (%)
        self.cargo_loaded = 0                  # Поточне завантаження (тонн)

    # Завантаження вантажу
    def load_cargo(self, weight):
        if self.status != "Ready":
            print(f"{self.name} is not ready for loading.")
            return
        if self.cargo_loaded + weight <= self.cargo_capacity:
            self.cargo_loaded += weight
            print(f"{weight} tons loaded. Current cargo: {self.cargo_loaded} tons.")
        else:
            print(f"Cannot load {weight} tons — exceeds capacity!")

    # Перевизначений метод запуску для багаторазового корабля
    def launch(self):
        # Перевірка обмежень на кількість використань
        if self.reuse_count >= self.max_reuses:
            print(f"{self.name} cannot launch — reached reuse limit.")
            return False
        # Перевірка стану корпусу
        if self.hull_integrity < 30:
            print(f"{self.name} cannot launch — hull too damaged ({self.hull_integrity}%).")
            return False
        # Виклик базового методу запуску
        if not super().launch():
            return False

        # Оновлення параметрів після польоту
        self.reuse_count += 1
        self.hull_integrity -= 20
        self.cargo_loaded = 0
        print(f"{self.name} completed flight #{self.reuse_count}. Hull integrity: {self.hull_integrity}%.")
        self.land()
        return True

    # Метод ремонту корабля
    def repair(self):
        print(f"{self.name} undergoing repairs...")
        self.hull_integrity = 100
        self.reuse_count = 0
        print(f"{self.name} is fully repaired and ready for next missions.")

    # Вивід повної інформації про стан корабля
    def info(self):
        return (f"ReusableSpaceShip {self.name}, Crew size: {self.crew_size}, "
                f"Cargo cap: {self.cargo_capacity} tons, Reuses: {self.reuse_count}/{self.max_reuses}, "
                f"Hull: {self.hull_integrity}%, Status: {self.status}")
