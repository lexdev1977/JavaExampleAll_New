package Java_Extend.Collections_Framework.Method.hashCode_equals;

import java.util.*;

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
        System.out.println(n == m);           // выдаст false
        System.out.println(n.equals(m));    // выдаст true
        System.out.println();

//      создадим два объекта нашего класса Human без переопределения метод equals и hashCode
        Human human01 = new Human(1, "Alex");
        Human human02 = new Human(1, "Alex");

        System.out.println("Сравниваем два объекта класса Human" +
                " без переопределения методов equals и hashCode результат: " + human01.equals(human02) + "\n");


//      создадим два объекта нашего класса Person с переопределением метод equals и hashCode
        Person person01 = new Person(1, "Alex");
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
                address1.equalsIgnoreCase(address2) + "\n\n");   // выдаст true


//                                          ***ПРИМЕРЫ hashCode***

//              создадим объект нашего класса Human без переопределения метод equals и hashCode

//      вызов метода hashCode без переопределения
        Human human03 = new Human(1, "Alex");
        Human human04 = new Human(2, "Kat");
        System.out.println("вызов hashCode для объекта класса Human (1, \"Alex\")" + human03.hashCode());
        System.out.println("вызов hashCode для объекта класса Human (2, \"Kat\")" + human04.hashCode());
        System.out.println();


//        вызов метода hashCode c переопределением и созданием своего алгоритма
        Person person03 = new Person(1, "Alex");
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


        //                             ***ЕЩЕ ПРИМЕНЕНИЕ НА ПРИМЕРАХ LIST И SET***

/*      Смысл такой, есть два контакт с разными ссылками, но с одинаковыми данными самих контактов внутри
        мы переопределяем метод equals и hashCode таким образом, что сравнение уже проводятс по внутренним полям
        добавляем мы контакт первый, а ищем или удаляем из колекций уже по второму контакту
        с переопределенным методом это два одинаковых контакта, с не переопределенным - два разных
 */


        System.out.println("\n\n***ЕЩЕ ПРИМЕНЕНИЕ НА ПРИМЕРАХ LIST И SET***\n");

        ContactNo contactNo01 = new ContactNo(1, "Alex", "0555111222");
        ContactNo contactNo02 = new ContactNo(1, "Alex", "0555111222");

        Contact contact01 = new Contact(1, "Alex", "0555111222");
        Contact contact02 = new Contact(1, "Alex", "0555111222");

        System.out.println("хеш кода контактов без переопределения:\n" + contactNo01.hashCode());
        System.out.println(contactNo02.hashCode());
        System.out.println("Сравнение по equals - " + contactNo01.equals(contactNo02));

        System.out.println("\nхеш кода контактов c переопределением:\n" + contact01.hashCode());
        System.out.println(contact02.hashCode());
        System.out.println("Сравнение по equals - " + contact01.equals(contact02));


        System.out.println("\n\nСоздадим ArrayLis на основе наших контактов с и без переопределением");

        System.out.println("\nдобавим первый контакт без переопределения и проверим содержит ли Лист второй контакт," +
                "\nа также проверим его индекс и удалим его из Листа контактов");
        List <ContactNo> contactNoList = new ArrayList<>();
        contactNoList.add(contactNo01);
        System.out.println("Поиск контакта - " + contactNoList.contains(contactNo02));
        System.out.println("Индекс контакта - " + contactNoList.indexOf(contactNo02));
        contactNoList.remove(contactNo02);
        System.out.println("Размер Листа - " + contactNoList.size());

        System.out.println("\nдобавим первый контакт с переопределением и проверим содержит ли Лист второй контакт," +
                "\nа также проверим его индекс и удалим его из Листа контактов");
        List <Contact> contactList = new ArrayList<>();
        contactList.add(contact01);
        System.out.println("Поиск контакта - " + contactList.contains(contact02));
        System.out.println("Индекс контакта - " + contactList.indexOf(contact02));
        contactList.remove(contact02);
        System.out.println("Размер Листа - " + contactList.size());


        System.out.println("\n\nСоздадим HashSet на основе наших контактов с и без переопределением");

        System.out.println("\nмножество с добавлением контактов без переопределения:");
        Set <ContactNo> contactNoHashSet= new HashSet<>();
        contactNoHashSet.add(contactNo01);
        contactNoHashSet.add(contactNo02);
        System.out.println(contactNoHashSet);
        System.out.println("Размер множества - " + contactNoHashSet.size());

        System.out.println("\nмножество с добавлением контактов c переопределением:");
        Set <Contact> contactHashSet= new HashSet<>();
        contactHashSet.add(contact01);
        contactHashSet.add(contact02);
        System.out.println(contactHashSet);
        System.out.println("Размер множества - " + contactHashSet.size());

//      Далее ма создаем множество на основе контактов у которых методы переопределенны таким образом,
//      что в них участвует только поле ID, это позволит перезаписывать данный в контакте, например
//      если поменялся только телефон

        System.out.println("\nсоздадим объекты с переопределенными методами на основе одного поля ID:");
        System.out.println("\nтакже создадим множество и добавим в него наш объект");

        ContactID contactID01 = new ContactID(1, "Alex", "0555111222");

        Set <ContactID> contactIDSet = new HashSet<>();
        contactIDSet.add(contactID01);

        System.out.println("сейчас в нашем множестве такой контакт - " + contactIDSet);

//      Теперь мы хотим обновить телефон у нашего контакта, удаляем старый контакт,
//      добавляем новый
//      если это делать без переопределения метода, мы просто добавим еще один контакт

        ContactID contactID02 = new ContactID(1, "Alex", "0555333333");
        contactIDSet.remove(contactID02);
        contactIDSet.add(contactID02);

        System.out.println("стал такой контакт - " + contactIDSet);


    }



//                  ***ЧАСТЬ СОЗДАНИЯ КЛАССОВ С ПЕРЕОПРЕДЕЛЕНИЕМ МЕТОДОВ И БЕЗ***

//            создамим класс  создадим класс с двумя полями id и name, без переопрделения методов метод equals и hashCode
    static class Human {
        private int id;
        private String name;

        public Human(int id, String name) {
            this.id = id;
            this.name = name;
        }


    }


//        создадим класс с двумя полями id и name, и переоределим метод equals и hashCode,
//        чтоб сравнение происходило по этим двум полям
    static class Person {
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
            return 2 * Objects.hash(id, name) + 10000001; // здесь мы сами создали алгоритм хешкода
//                                                          по умолчанию java выдала  - Objects.hash(id, name)
        }
    }


//    Еще два класса с переопределенными методами и без

    static class Contact {
        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Contact contact = (Contact) o;
            return id == contact.id && Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone);
        }


        @Override
        public int hashCode() {
            return Objects.hash(id, name, phone);
        }

    }


    static class ContactNo {
        int id;
        String name;
        String phone;

        public ContactNo(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "ContactNo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    static class ContactID {
        int id;
        String name;
        String phone;

        public ContactID(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "ContactNo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContactID contactID = (ContactID) o;
            return id == contactID.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }


}



