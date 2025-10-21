import java.util.Scanner;

public class LessonFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        float depositFor = scanner.nextFloat();

        System.out.print("Введите срок вклада в месяцах: ");
        int monthsFor = scanner.nextInt();

        for (int i = 0; i < monthsFor; i++) {
            depositFor += depositFor * 0.07f;
        }

        System.out.println("После " + monthsFor + " месяцев сумма вклада составит " + depositFor);



        System.out.print("Введите сумму вклада: ");
        float depositWhile = scanner.nextFloat();

        System.out.print("Введите срок вклада в месяцах: ");
        int monthsWhile = scanner.nextInt();

        int counter = 0;
        while (counter < monthsWhile) {
            depositWhile += depositWhile * 0.07f;
            counter++;
        }

        System.out.print("После " + monthsWhile + " месяцев сумма вклада составит " + depositWhile);
    }
    }