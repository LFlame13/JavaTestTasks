import java.util.Random;
import java.util.Scanner;

public class Task1 {

        // Список слов
        private static final String[] WORDS = {"дружба", "перпендикуляр", "холодильник", "барбекю", "возвышенность", "гидрокарбонат"};

        // Кол-во хп жизней
        private static final int MAX_HP = 7;

        public static void main(String[] args) {

                // Слово которое нужно разгадать
                String guessTheWord = getRandomWord().toLowerCase();
                // Массив для хранения состояния слова
                char[] guessedWord = new char[guessTheWord.length()];

                // Заполняем массив символами '*'
                for (int i = 0; i < guessedWord.length; i++) {
                        guessedWord[i] = '*';
                }

                int hp = MAX_HP;
                Scanner scanner = new Scanner(System.in);
                boolean wordGuessed = false;

                // Массив для хранения уже угаданных букв
                char[] guessedLetters = new char[guessTheWord.length()];
                int guessedCount = 0; // Количество угаданных букв

                System.out.println("Добро пожаловать на Виселицу!");

                // Основной цикл игры
                while (hp > 0 && !wordGuessed) {
                        System.out.println("Текущее состояние слова: " + String.valueOf(guessedWord));
                        System.out.println("Осталось жизней: " + hp);
                        System.out.println("Введите букву: ");

                        // Вводим букву и перевод в нижний регистр
                        char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

                        // Проверка на повторность
                        boolean alreadyGuessed = false;
                        for (int i = 0; i < guessedCount; i++) {
                                if (guessedLetters[i] == guessedLetter) {
                                        alreadyGuessed = true;
                                        break;
                                }
                        }

                        if (alreadyGuessed) {
                                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                                continue;
                        }

                        // Добавляем букву в массив угаданных букв
                        guessedLetters[guessedCount] = guessedLetter;
                        guessedCount++;

                        boolean isCorrectGuess = false;

                        // Проверяем, есть ли введенная буква в слове
                        for (int i = 0; i < guessTheWord.length(); i++) {
                                if (guessTheWord.charAt(i) == guessedLetter) {
                                        // Если буква угадана, заменяем её в текущем состоянии слова
                                        guessedWord[i] = guessedLetter;
                                        isCorrectGuess = true;
                                }
                        }

                        if (!isCorrectGuess) {
                                hp--; // Если буква не угадана, уменьшаем количество жизней
                                System.out.println("Такой буквы нет. Вы теряете 1 жизнь.");
                        }

                        // Проверяем, угадано ли всё слово
                        wordGuessed = isWordGuessed(guessedWord);
                }

                // Результат игры
                if (wordGuessed) {
                        System.out.println("Вы угадали слово: " + guessTheWord);
                } else {
                        System.out.println("Поражение! Загаданное слово было: " + guessTheWord);
                }
        }

        // Метод для выбора случайного слова
        private static String getRandomWord() {
                Random random = new Random();
                int randomIndex = random.nextInt(WORDS.length);
                return WORDS[randomIndex];
        }

        // Метод для проверки, угадано ли слово полностью
        private static boolean isWordGuessed(char[] guessedWord) {
                for (char c : guessedWord) {
                        if (c == '*') {
                                return false; // Если хотя бы одна буква не угадана, возвращаем false
                        }
                }
                return true; // Если все буквы угаданы, возвращаем true
        }
}
