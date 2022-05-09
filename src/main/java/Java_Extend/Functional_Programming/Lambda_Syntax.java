package Java_Extend.Functional_Programming;

public class Lambda_Syntax {

//                                   Синтаксис Лямбда выражений

    interface Interface01{                                  // создаем Интерфейс с единственным методом runInterface()
        void runInterface();
    }

   static class ClassNew{                                   // создаем класс с методом runClass01 на вход которого
        public void runClass01(Interface01 e){              // передаем реализацию интерфейса Interface01
            e.runInterface();                               // и который потом запустит метод runInterface
        }
   }

   static class ClassImplimentInterface implements Interface01{  // класс который реализует метод интерфеса Interface01
       @Override
       public void runInterface() {
           System.out.println("Hello");
       }
   }

    public static void main(String[] args) {                // три варианта написания одного и того же действия
                                                            // по реализации метода runInterface интерфейса Interface01


        ClassNew classObject = new ClassNew();

        classObject.runClass01(new ClassImplimentInterface());{    // 1. создаем объект реализующий метод runInterface
        }

        classObject.runClass01(new Interface01() {                 // 2. создаем анонимный класс с методом runInterface
            @Override
            public void runInterface() {
                System.out.println("Hello");
            }
        });

        classObject.runClass01(() -> System.out.println("Hello")); // 3. описываем при помощи лямбда выражения




        ClassInter01 object01 = new ClassInter01();
        ClassInter02 object02 = new ClassInter02();
        ClassInter03 object03 = new ClassInter03();
        ClassInter04 object04 = new ClassInter04();



        object01.runClass01(new Inter01() {
            @Override
            public void runInter01() {
                System.out.println("1");
            }
        });

        object01.runClass01(() -> System.out.println("1"));             // лямбда



        object02.runClass02(new Inter02() {
            @Override
            public int runInter02() {
                return 2;
            }
        });

        object02.runClass02(() -> 2);                                   // лямбда



        object03.runClass3(new Inter03() {
            @Override
            public int runInter03(int x) {
                return x - 7;
            }
        });

        object03.runClass3((x) -> x-7);                                 // лямбда



        final int s = 20;                               // использовать другие переменные в лямбда можно обозначив
        object04.runClass04((x, y) -> x + y - s);       // их явно или неявно final (их нельзя изменять)
                                                        // у лямбда выражений нет своей области видимости,
                                                        // поэтому равна области, в которой она создана




    }


// создаем разные интерфейсы с разными методами

    interface Inter01 {
        void  runInter01();
    }

    interface Inter02 {
        int  runInter02();
    }

    interface Inter03 {
        int runInter03(int x);
    }

    interface Inter04 {
        int runInter04(int x, int y);
    }

// создаем разные классы, использующие в своих методах на вход разные интерфейсы
    static class ClassInter01{
        public void runClass01 (Inter01 i){
            i.runInter01();
        }
    }

    static class ClassInter02{
        public void runClass02 (Inter02 i){
            int a = i.runInter02();
            System.out.println(a);

        }
    }

    static class ClassInter03{
        public void runClass3 (Inter03 i){   // здесь мы создаем объект i на базе интерфейса Inter03
            int a = i.runInter03(10);     // при запуске его метода .runInter03 на этом объекте на вход
            System.out.println(a);           // получаем данные (x: 10), а вот реализацию самого метода мы получили
        }                                    // при создании объекта этого класса и переопределении в нем метода
    }

    static class ClassInter04{
        public void runClass04 (Inter04 i){
            int a = i.runInter04(10,20);
            System.out.println(a);

        }
    }






}
