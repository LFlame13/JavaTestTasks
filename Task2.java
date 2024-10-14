import java.util.Scanner;

public class Task2 {

    private static final double DOL_EXCHANGE = 95.60; // 1 доллар = 95,60 руб
    private static final double AED_EXCHANGE = 26.03; // 1 дирхам = 26.03 руб
    private static final double CNY_EXCHANGE = 13.49; // 1 юань = 13.49 руб
    private static final double EUR_EXCHANGE = 104.27; // 1 евро = 104.27 руб
    private static final double BYN_EXCHANGE = 29.21; // 1 белорусский рубль = 29,21 руб

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму в RUB");
        double sumRUB = scanner.nextDouble();

        // Конвертация
        double sumInDOL = sumRUB / DOL_EXCHANGE;
        double sumInAED = sumRUB / AED_EXCHANGE;
        double sumInCNY = sumRUB / CNY_EXCHANGE;
        double sumInEUR = sumRUB / EUR_EXCHANGE;
        double sumInBYN = sumRUB / BYN_EXCHANGE;

        // Вывод
        System.out.printf("Сумма в долларах: %.2f\n", sumInDOL);
        System.out.printf("Сумма в дирхамах: %.2f\n", sumInAED);
        System.out.printf("Сумма в китайских юанях: %.2f\n", sumInCNY);
        System.out.printf("Сумма в евро: %.2f\n", sumInEUR);
        System.out.printf("Сумма в белорусских рублях: %.2f\n", sumInBYN);

    }
}