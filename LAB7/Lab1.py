def read_matrix_size():
    # Зчитуємо розмір квадратної матриці від користувача
    n = int(input("Enter size of matrix: "))
    return n

def read_filler_symbol():
    # Зчитуємо символ-заповнювач від користувача
    c = input("Enter the character: ")
    if len(c) != 1:
        # Якщо введено не один символ, завершуємо програму
        print("You should write only one symbol!")
        exit()
    return c

def create_jagged_matrix(n):
    # Створюємо порожню зубчасту матрицю (список списків)
    # На початку кожен рядок None, заповнимо пізніше
    return [None] * n

def fill_jagged_matrix(arr, c):
    # Заповнюємо зубчасту матрицю символами
    n = len(arr)
    half = n // 2  # Розділяємо матрицю на верхню та нижню половини
    for i in range(n):
        # Для верхньої половини символи починаються з першої колонки
        # Для нижньої половини символи починаються з середини
        j_start = 0 if i < half else half
        j_end = i
        count = max(0, j_end - j_start + 1)  # Кількість символів у рядку
        arr[i] = [c] * count  # Заповнюємо рядок символами




def print_and_save_matrix(arr, filename):
    # Виводимо матрицю у консоль та одночасно записуємо у файл
    n = len(arr)
    half = n // 2
    with open(filename, "w") as fout:
        for i in range(n):
            # Додаємо відступи для нижньої половини
            leading_cols = 0 if i < half else half

            line = "  " * leading_cols + " ".join(arr[i])
            print(line)          # Вивід у консоль
            fout.write(line + "\n")  # Запис у файл

def main():
    # Основна функція програми
    n = read_matrix_size()         # Розмір матриці
    c = read_filler_symbol()       # Символ-заповнювач
    arr = create_jagged_matrix(n)  # Створення пустої матриці
    fill_jagged_matrix(arr, c)     # Заповнення матриці
    print_and_save_matrix(arr, "lab1.txt")  # Вивід та збереження

if __name__ == "__main__":
    main()  # Вилик основної функції
