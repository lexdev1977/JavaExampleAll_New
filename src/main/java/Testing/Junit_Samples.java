package Testing;

/*
    Примеры некоторой логики, для того чтоб провести тестирование, при помощи Junit
    Само тестирование и результаты теста, располагаются в папке test/java/Junit_SamplesTesting.class

 */


public class Junit_Samples {
    private double x;
    private double y;


    // метод производит вычисление 2D вектора - при создании объекта значения будут нулевыми, это проверим в тесте
    public double vector2DLength(){
        return Math.sqrt(x*x + y*y); // sqrt - извлекает квадратный корень
    }

    // метод, который делит одно число на другое - проверка на деление на ноль,
    // и выбрасывание исключения ArithmeticException

    public static double divide(int a, int b){
        if (b==0){
            throw new ArithmeticException("Не можем делить на ноль (Can't divide by zero)");
        }
        return a / b;
    }

    // метод имитирующий какое-то соединение, которое занимает какое-то время
    // в тесте будет идти проверка на время занимаемое данным соединением
    public static void getConnection(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean returnBoolean(int n){
        return n == 0;
    }








}
