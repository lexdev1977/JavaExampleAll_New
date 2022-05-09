package Java_Extend.Other;

public class Exception_Try_Catch_Finally_Syntax {
    public static void main(String[] args) throws InterruptedException, RuntimeException
    // мы можем обозначить исключения, чтоб предупредить, что они могут выскочить, но не обязательно их обрабатывать

    {



        System.out.println("Запуск метода myMethod, который может выкинуть исключение");

        for (int i =0; i < 4; i++){

            switch (i){
                case 1 -> System.out.println("Выкидываем исключение Exception");
                case 2 -> System.out.println("Выкидываем собственное исключение MyException");
                case 3 -> System.out.println("Выкидываем исключение RuntimeException");
                default -> System.out.println("Метод пока не выкинул никаких исключений");
            }
            try {
                myMethod(i);             // в этом блоке располагаем методы, которые могут выбрасывать исключения

                // В этом блоке мы обрабатываем исключения, в случае их выброса
//               каждое исключение обрабатывается в соответствии с его названием,
//               порядок обработки важен, особенно если есть обработка наследника исключения и его родителя.
//               В данном примере нет обработки RuntimeException, но он наследник Exception
//               и выброс его исключения будет обработано в блоке Exception
            } catch (myException e){
                System.out.println("Включился блок обработки исключения myException.......");
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Включился блок обработки исключения Exception.......");
                System.out.println(e.getMessage());
            }


            System.out.println("Ожидаем несколько секунд и пробуем следующее исключение \n");
            Thread.sleep(3000);


        }

    }


    static void myMethod(int value) throws Exception{   // далее происходит выброс исключений в зависимости от условий
        if (value == 1){
            throw new Exception("Текст исключения Exception");
        }
        if (value == 2){
            throw new myException("Здесь текст моего исключения");
        }
        if (value == 3){
            throw new RuntimeException("Текст исключения RuntimeException");
        }

    }

    static class myException extends Exception{

        public myException(String message) {
            super(message);
        }
    }
}

