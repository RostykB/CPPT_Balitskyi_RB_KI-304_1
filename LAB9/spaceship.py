# Клас SpaceShip — базовий клас, що описує загальні властивості космічного корабля
class SpaceShip:
    def __init__(self, name, crew_size):
        # Ініціалізація атрибутів корабля
        self.name = name                # Назва корабля
        self.crew_size = crew_size      # Кількість членів екіпажу
        self.status = "Ready"           # Початковий статус корабля

    # Метод запуску корабля
    def launch(self):
        if self.crew_size <= 0:
            print(f"{self.name} cannot launch without crew!")
            return False
        print(f"{self.name} is launching!")
        self.status = "In flight"
        return True

    # Метод посадки
    def land(self):
        print(f"{self.name} has landed successfully.")
        self.status = "Ready"

    # Метод для виведення основної інформації про корабель
    def info(self):
        return f"SpaceShip {self.name}, Crew size: {self.crew_size}, Status: {self.status}"
