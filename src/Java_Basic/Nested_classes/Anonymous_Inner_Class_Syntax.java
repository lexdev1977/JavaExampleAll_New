package Java_Basic.Nested_classes;


import java.util.ArrayList;
import java.util.List;

public class Anonymous_Inner_Class_Syntax {

//    объявление класса Animal с методом eat
    static class Animal{

        public void eat(){
            System.out.println("Животное кушает");
        }
    }

    //    объявление интерфейса start
    public interface Start {
        void starCar();
    }


    public static void main(String[] args) {

//            ***пример Анонимного класса на основе другого класса (Anonymous Inner class)***

        Animal animal01 = new Animal();

//      Создание анонимного класса, в нем мы переопределяем методы родителя
//      В конце стоит точка с запятой! Она стоит там не просто так.
//      Мы одновременно объявляем класс (посредством фигурных скобок) и создаем его объект с помощью ();

        Animal animal02 = new Animal() {     // анонимный класс
            public void eat(){
                System.out.println("Животное номер два кушает");
            }
        };

        animal01.eat();
        animal02.eat();
        System.out.println();


//              Еще один пример когда анонимный класс можно вставить сразу в параметры
        List<Animal> animalAll = new ArrayList<>();
        animalAll.add(animal01);
        animalAll.add(new Animal(){        // анонимный класс
            public void eat(){
                System.out.println("Еще одно анонимное животное кушает");
            }
        });

//        animalAll.get(0).eat();
//        animalAll.get(1).eat();

        Animal animal001 = animalAll.get(0);
        animal001.eat();
        Animal animal002 = animalAll.get(1);
        animal002.eat();

        System.out.println();



        //         ***пример Анонимного класса на основе интерфейса start (Anonymous Inner class)***

        System.out.println("пример Анонимного класса на основе интерфейса start:");
        Start Car01 = new Start() {
            @Override
            public void starCar() {
                System.out.println("первая машина стартовала");
            }
        };
        Start Car02 = new Start() {
            @Override
            public void starCar() {
                System.out.println("вторая машина стартовала");
            }

            public void run(){
                System.out.println("Поехала");
            }
        };


        Car01.starCar();
        Car02.starCar();

    }






}
