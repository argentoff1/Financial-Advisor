package praktikum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Converter converter = new Converter(77.3, 83.7, 0.6, 80.8, 11.9, 3080298.7, 229610.3);
        DinnerAdvisor dinnerAdvisor = new DinnerAdvisor();
        ExpensesManager expensesManager = new ExpensesManager();

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");

                System.out.print("Введите сумму, которую вы хотите конвертировать: ");
                double moneyForConvert = scanner.nextDouble();

                if (moneyForConvert > moneyBeforeSalary){
                    System.out.println("Ошибка! Вы ввели сумму, большую своей накопленной.");
                    break;
                }

                System.out.println("Во что вы хотите конвертировать свои сбережения? Доступные варианты: 1 - валюта, 2 - криптовалюта");
                int currencyOrCrypto = scanner.nextInt();

                if (currencyOrCrypto == 1) {
                    System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY, 4 - CHF, 5 - CNY.");
                    int currency = scanner.nextInt();
                    converter.convert(moneyForConvert, currency);

                    moneyBeforeSalary -= moneyForConvert;
                } else if (currencyOrCrypto == 2) {
                    System.out.println("В какую криптовалюту вы хотите конвертировать? Доступные варианты: 1 - BTC, 2 - ETH.");
                    int crypto = scanner.nextInt();
                    converter.convertToCrypto(moneyForConvert, crypto);

                    moneyBeforeSalary -= moneyForConvert;
                }
            } else if (command == 2)
                dinnerAdvisor.getAdvice(moneyBeforeSalary, daysBeforeSalary); // Вызовите метод класса DinnerAdvisor
            else if (command == 3) {
                System.out.println("За какой день вы хотите ввести трату: 1 - ПН, 2 - ВТ, 3 - СР, 4 - ЧТ, 5 - ПТ, 6 - СБ, 7- ВС?");
                int day = scanner.nextInt();

                System.out.println("Введите размер траты: ");
                double expense = scanner.nextDouble();

                moneyBeforeSalary = expensesManager.saveExpense(moneyBeforeSalary, expense, day);
            } else if (command == 4)
                expensesManager.printAllExpenses();
            else if (command == 5)
                System.out.println("Самая большая сумма расходов на этой неделе составила " + expensesManager.findMaxExpense() + " руб.");
            else if (command == 0) {
                System.out.println("Выход");
                break;
            } else
                System.out.println("Извините, такой команды пока нет.");
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту / криптовалюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }
}