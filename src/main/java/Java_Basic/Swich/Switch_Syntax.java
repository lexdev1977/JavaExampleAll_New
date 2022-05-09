package Java_Basic.Swich;

public class Switch_Syntax {

// вариант свича с использованием лямбда выражений:

    public static void main(String[] args) {
        int value = 3;
        switch (value) {
            case 1 -> System.out.println("value == 1");
            case 2, 3, 4 -> System.out.println("value == 2,3,4");
            default -> System.out.println("Нет такого значения");
        }


        char charValue = switch (value) {
            case 1 -> '1';
            case 2, 3, 4 -> '2';
            default -> '0';
        };
        System.out.println("Значение charValue - " + charValue);


//      старый вариант свича

        switch (value){
            case 1:
                System.out.println("value == 1");
                break;
            case 2:
                System.out.println("value == 2");
                break;
            default:
                System.out.println("Нет такого значения");
        }
    }


}
