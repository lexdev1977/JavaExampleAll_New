package Java_Extend.Collections_Framework.Method.getClass;

public class getClass {

    /*
            В Java почти все сущности являются объектами, за исключением примитивных типов.
            У каждого объекта есть класс. Сами классы тоже является объектами, и они принадлежат классу Class.

            метод .getClass вызывается на объекте класса и позволяет получить тип данного объекта.
            Другими словами мы получаем класс к которому относится объект у которого мы вызываем этот метод.

            Person tom = new Person();
            tom.getClass;

            Результат

            class Java_Extend.Java_Collections.Method.getObject.getClass$Person


     */

    public static void main(String[] args) {

        Person tom = new Person("Tom");
        System.out.println(tom.getClass());

    }

    static class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }
    }


}
