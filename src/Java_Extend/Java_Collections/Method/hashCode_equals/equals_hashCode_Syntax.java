package Java_Extend.Java_Collections.Method.hashCode_equals;

import java.util.Objects;

public class equals_hashCode_Syntax {
    public static void main(String[] args) {


//                                   ***ПРИМЕРЫ equals***

//      В классах обертках тиа Integer, String и т.д. метод .equals уже переопределен нужным образом,
//      поэтому там сравнение идет уже по другому.

        Integer x = 10;
        Integer y = 10;

        System.out.println(x == y);  // два объекта равны

        String a = "Hello!";
        String b = "Hello!";
        System.out.println();

        System.out.println(a == "Hello!");  // объект и строка равны
        System.out.println(a == b);   // два объекта равны
        System.out.println(a.equals(b));   // два объекта равны
        System.out.println(a.equals("Hello!"));   // объект и строка равны

        System.out.println();

//      отличия в String будет когда мы сами создаем объект класса String,
//      поэтому лучше сравнивать методом equals
        String n = "Hello!";
        String m = new String("Hello!");

        System.out.println("Сравниваем наш объект строк и созданный Java");
        System.out.println(n==m);           // выдаст false
        System.out.println(n.equals(m));    // выдаст true
        System.out.println();

//      создадим два объекта нашего класса Human без переопределения метод equals и hashCode
        Human human01 = new Human(1, "Alex");
        Human human02 = new Human(1, "Alex");

        System.out.println("Сравниваем два объекта класса Human" +
                " без переопределения методов equals и hashCode результат: " + human01.equals(human02) + "\n");


//      создадим два объекта нашего класса Person с переопределением метод equals и hashCode
        Person person01 = new Person(1,"Alex");
        Person person02 = new Person(1, "Alex");

        System.out.println("Сравниваем два объекта класса Person" +
                " с переопределенными методами equals и hashCode результат: " + person01.equals(person02));
        System.out.println();

//        Сравнение строк без учета регистра
        String address1 = "г. Москва, ул. Академика Королева, дом 12";
        String address2 = "Г. МОСКВА, УЛ. АКАДЕМИКА КОРОЛЕВА, ДОМ 12";
        System.out.println("г. Москва, ул. Академика Королева, дом 12" + "\n" +
                "Г. МОСКВА, УЛ. АКАДЕМИКА КОРОЛЕВА, ДОМ 12");


        System.out.println("Проверка строк без учета регистра посредством .equalsIgnoreCase - " +
                address1.equalsIgnoreCase(address2) +"\n\n");   // выдаст true



//                                          ***ПРИМЕРЫ hashCode***

//              создадим объект нашего класса Human без переопределения метод equals и hashCode

//      вызов метода hashCode без переопределения
        Human human03 = new Human(1, "Alex");
        Human human04 = new Human(2, "Kat");
        System.out.println("вызов hashCode для объекта класса Human (1, \"Alex\")" + human03.hashCode());
        System.out.println("вызов hashCode для объекта класса Human (2, \"Kat\")" + human04.hashCode());
        System.out.println();


//        вызов метода hashCode c переопределением и созданием своего алгоритма
        Person person03 = new Person(1,"Alex");
        Person person04 = new Person(2, "Kat");
        System.out.println("вызов hashCode для объекта класса Person (1, \"Alex\")" + person03.hashCode());
        System.out.println("вызов hashCode для объекта класса Person (2, \"Kat\")" + person04.hashCode());

/*      ниже в классе он переопределен следующим образом:
        @Override
        public int hashCode() {
            return 2 * Objects.hash(id, name) +10000001; // здесь мы сами создали алгоритм хешкода
                                                          по умолчанию java выдала  - Objects.hash(id, name)
                              }
*/

    }



//                  ***ЧАСТЬ СОЗДАНИЯ ДВУХ КЛАССОВ С ПЕРЕОПРЕДЕЛЕНИЕМ МЕТОДОВ И БЕЗ***

//        создамим класс  создадим класс с двумя полями id и name, без переопрделения методов метод equals и hashCode
    static class Human{
        private int id;
        private String name;

    public Human(int id, String name) {
        this.id = id;
        this.name = name;
    }

}


//        создадим класс с двумя полями id и name, и переоределим метод equals и hashCode,
//        чтоб сравнение происходило по этим двум полям
    static class Person{
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

//            среда автоматически сгенерирует переопределение нажав alt+insert и выбрав раздел "equals() and hashCode()"
//            далее нужно выбрать поля для сравнения
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name); // класс Objects утилитный класс
        }

        @Override
        public int hashCode() {
            return 2 * Objects.hash(id, name) +10000001; // здесь мы сами создали алгоритм хешкода
//                                                          по умолчанию java выдала  - Objects.hash(id, name)
        }
    }
}
