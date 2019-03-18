package ru.geekbrains.lesson_1;

public class Main {

    public static void main(String[] args) {

    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
	byte val1 = 16;
	short val2 = -32550;
	int val3 = 214562;
	long val4 = 100000L;
	float val5 = -158.354f;
	double val6 = 645.756;
	char val7 = '*';
	boolean val8 = true;

		System.out.println(calculation	(-15, 7, 15, 5));
		System.out.println(check(6, 9));
		positiveOrNegative(6);
		System.out.println(negativeNumber(-16));
		helloName ("Vladislav");
		year (2400);
    }
	// 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
	// где a, b, c, d – входные параметры этого метода;
	public static int calculation (int a, int b, int c, int d) {
	return a * (b + (c / d));
	}

	//4. Написать метод, принимающий на вход два числа,
	// и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
	// если да – вернуть true, в противном случае – false;
	public static boolean check (int number1, int number2){
    	int summ = number1 + number2;
    	if ((summ >=10) && (summ <=20)) {
    		return true;
		} else {
			return false;
		}
	}

	//5. Написать метод, которому в качестве параметра передается целое число,
	// метод должен напечатать в консоль положительное ли число передали, или отрицательное;
	// Замечание: ноль считаем положительным числом.
	public static void positiveOrNegative (int number3) {
    	if (number3 >=0) {
			System.out.println("Положительное число");
		} else {
			System.out.println("Отрицательное число");
		}
	}

	//6. Написать метод, которому в качестве параметра передается целое число,
	// метод должен вернуть true, если число отрицательное;
	public static boolean negativeNumber (int number4) {
    	if (number4 < 0){
    		return true;
		}
		return false;
	}
	//7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
	// метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
	public static void helloName (String name){
		System.out.println("Hello, " + name + "!");



		}
//8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
	public static void year (int year1){
        int remain1 = year1%4;
        int remain2 = year1%100;
        int remain3 = year1%400;
        if (remain1 ==0) {
            if (remain2 ==0) {
                if (remain3 == 0) {
                    System.out.println("Год високосный");
                } else {
                    System.out.println("Год не високосный");
                }
            } else {
                System.out.println("Год високосный");
            }
        } else {
            System.out.println("Год не високосный");
        }
    }

    }





