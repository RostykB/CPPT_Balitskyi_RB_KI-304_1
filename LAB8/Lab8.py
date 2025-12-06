"""
Модуль для обчислення y = ctg(x) та роботи з файлами.
Функціонал:
- обчислення y = 1/tan(x) для списку x;
- запис та зчитування результатів у текстові та бінарні файли;
- введення значень x з консолі;
- коментарі для пояснення коду.
"""

import math
import pickle  # Для бінарних файлів


def calculate_ctg(values):
    """
    Обчислює y = ctg(x) = 1/tan(x) для списку значень x.

    :param values: список чисел (у радіанах)
    :return: список словників з x та y
    """
    results = []
    for x in values:
        try:
            y = 1 / math.tan(x)  # Обчислюємо котангенс
        except ZeroDivisionError:
            y = None  # Якщо tan(x) = 0, котангенс не визначений
        results.append({"x": x, "y": y})
    return results


def save_to_text_file(filename, data):
    """Записує результати у текстовий файл"""
    with open(filename, "w") as f:
        for item in data:
            f.write(f"x: {item['x']}, y: {item['y']}\n")


def read_from_text_file(filename):
    """Зчитує рядки з текстового файлу"""
    with open(filename, "r") as f:
        return f.readlines()


def save_to_binary_file(filename, data):
    """Записує результати у бінарний файл (pickle)"""
    with open(filename, "wb") as f:
        pickle.dump(data, f)


def read_from_binary_file(filename):
    """Зчитування даних з бінарного файлу (pickle)"""
    with open(filename, "rb") as f:
        return pickle.load(f)


def main():
    # Ввід значень x з консолі
    x_values = []
    print("Enter x values in radians (type 'done' to finish):")
    while True:
        entry = input("> ")
        if entry.lower() == "done":
            break
        try:
            x = float(entry)
            x_values.append(x)
        except ValueError:
            print("Please enter a valid number or 'done' to finish.")

    # Обчислення котангенсу
    results = calculate_ctg(x_values)

    # Запис результатів у файли
    save_to_text_file("results.txt", results)
    save_to_binary_file("results.bin", results)

    # Читання файлів для перевірки
    print("\nText file content:")
    print("".join(read_from_text_file("results.txt")))

    print("Binary file content:")
    print(read_from_binary_file("results.bin"))


if __name__ == "__main__":
    main()
