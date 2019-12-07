import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    private static double passengerCarMaxWeight = 3500.0; // kg   Create double var
    private static int passengerCarMaxHeight = 2000; // mm Create int var
    private static int controllerMaxHeight = 3500; // mm Create int var

    private static int passengerCarPrice = 100; // RUB Create int var
    private static int cargoCarPrice = 250; // RUB Create int var
    private static int vehicleAdditionalPrice = 200; // RUB Create int var

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in); //Create scanner var
        int carsCount = scanner.nextInt(); //Create int var

        for(int i = 0 /*Create int tmp var*/; i < carsCount; i++)
        {
            Car car = Camera.getNextCar(); //Create car var
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car); //Create int var
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        int carHeight = car.height; //Create int var  Высота машины
        int price = 0; // Create int var Цена
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            double weight = car.weight;  //Create double var
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight)
            {
                price = cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = passengerCarPrice; // цена легкогого автомобиля
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
        }
        else {
            return price;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}