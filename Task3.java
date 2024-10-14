import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Изначальная длина пароля
        int passwordLength = 0;

        //Цикл на ввод
        while (true) {
            System.out.println("Введите длину пароля (от 8 до 12 символов):");
            passwordLength = scanner.nextInt();

            // Проверка на длину пароля
            if (passwordLength >= 8 && passwordLength <= 12) {
                break; // Выход если true
            } else {
                System.out.println("Ошибка: длина пароля должна быть не менее 8 символов и не более 12. Попробуйте снова.");
            }
        }
        /// Генерируем пароль и выводим его
        String password = generatePassword(passwordLength);
        System.out.println("Ваш сгенерированный пароль: " + password);
    }

    private static String generatePassword(int length) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Заглавные буквы
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"; // Строчные буквы
        String digits = "0123456789"; // Цифры
        String specialChars = "!@#$%^&*()-_=+<>?"; // Спец символы

        Random random = new Random();
        String password = "";

        // Добавляем по одному символу из каждой категории
        password += uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())); // Заглавная буква
        password += lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())); // Строчная буква
        password += digits.charAt(random.nextInt(digits.length())); // Цифра
        password += specialChars.charAt(random.nextInt(specialChars.length())); // Специальный символ

        // Заполняем оставшуюся длину пароля случайными символами из всех категорий
        String allChars = uppercaseLetters + lowercaseLetters + digits + specialChars;
        for (int i = 4; i < length; i++) { // Начинаем с 4, так как уже добавили символы
            password += allChars.charAt(random.nextInt(allChars.length()));
        }

        // Перемешиваем символы пароля
        return shuffleString(password);
    }

    // Метод для перемешивания символов пароля
    private static String shuffleString(String password) {
        char[] passwordArray = password.toCharArray();
        Random random = new Random();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Меняем местами элементы
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }
        return new String(passwordArray);
    }
}
