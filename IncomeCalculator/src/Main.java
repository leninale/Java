import java.util.Scanner;

public class Main
{

    private static int maxIncome = 900000;  //создание переменной максимального дохода

    private static int officeRentCharge = 140000;  //создание переменной аренда офиса
    private static int telephonyCharge = 12000;     //создание переменной телефония
    private static int internetAccessCharge = 7200;  //создание переменной доступа в интеренет

    private static int assistantSalary = 45000; // создание переменной зарплаты ассистента
    private static int financeManagerSalary = 90000; // Зарплата финансового менеджера

    private static double mainTaxPercent = 0.24; // создание переменной основной процент налога
    private static double managerPercent = 0.15; // создание переменной процент менеджеру

    private static double minInvestmentsAmount = 100000; // создание переменной минимальная сумма для инвестиции
    private static int minIncome = (int) ((minInvestmentsAmount + (1-mainTaxPercent)* calculateFixedCharges())/((1-mainTaxPercent)-(1-mainTaxPercent)*managerPercent)); //создание переменной минимального дохода

    public static void main(String[] args) // мейн метод
    {          while(true) // запуск бесконечного цикла
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от " + minIncome + " до 900 тысяч рублей): "); // вывод строки
            int income = (new Scanner(System.in)).nextInt(); // создание переменной дохода и инициализация ее вводом из консоли

            if(!checkIncomeRange(income)) { //цикл проверки дохода, если не входит, то повторить ввод
                continue;
            }

            double managerSalary = income * managerPercent; // создание  переменной зарплаты менеджера доход * на процент менеджера
            double pureIncome = income - managerSalary -
                calculateFixedCharges(); // создание переменной бюджета (доход - зп менеджера - расходы)
            double taxAmount = mainTaxPercent * pureIncome; // создание перменной налога процент налога * на сумму бюджета
            double pureIncomeAfterTax = pureIncome - taxAmount; //бюджет после вычета налогов

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount; //булевая переменная на проверку, может ли инвестировать компания
            System.out.println("Зарплата менеджера: " + managerSalary); // вывод на экран
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0)); // проверка если налог бо льше 0 то вывод суммы налога, нет то вывести 0
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет")); // проверка, может ли инвестировать компания
            if(pureIncome < 0) { // если бюджет в минусе, то сказать об этом
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income)  // статичный метод, который проверяет входит ли доход в диапозон
    {
        if(income <= minIncome) // если доход ниже, то вернуть false и сказать что он ниже
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome) // если доход выше, то вернуть false и сказать что он выше
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true; //вернуть true если входит в диапозон
    }

    private static int calculateFixedCharges()  //метод расчета затрат
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary; // вернуть сумму всех затрат
    }
}
