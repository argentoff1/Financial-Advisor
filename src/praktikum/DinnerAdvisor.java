package praktikum;

public class DinnerAdvisor {
    void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        if (moneyBeforeSalary < 3000)
            System.out.println("Сегодня лучше поесть дома. Экономия наше всё!");
        else if (moneyBeforeSalary < 10000) {
            if (daysBeforeSalary < 10)
                System.out.println("Окей, пора в кафе!");
            else
                System.out.println("Сегодня лучше поесть дома. Экономия наше всё!");
        } else if (moneyBeforeSalary < 30000) {
            if (daysBeforeSalary < 10)
                System.out.println("Хорошо! Можете инвестировать свои сбережения и зайти поужинать в классное место.");
            else
                System.out.println("Окей, всё не так плохо! Пора в кафе!");
        } else {
            if (daysBeforeSalary < 10)
                System.out.println("Отлично! Можете инвестировать свои сбережения и заказать себе крабов!");
            else
                System.out.println("Хорошо! Можете инвестировать свои сбережения и зайти поужинать в классное место.");
        }
    }
}
