package Java_Extend.Other;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Reflection_Syntax {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {




        Person person01 = new Person();

//      первый способ получения объекта типа Class
            Class personClass = Person.class;


//      второй способ получения объекта типа Class
            Class personClass02 = person01.getClass();


//      третий способ получения объекта типа Class
            Class personClass03 = Class.forName("Java_Extend.Other.Person");




//            получение всех методов класса и запись в массив
        Method[] methodsPerson = personClass.getMethods();

        for (Method method: methodsPerson){
            System.out.println(method.getName() + ", " + method.getReturnType() + ", "
                    + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*******************************************");




//            получение всех полей класса и запись в массив

        Field[] fieldPerson = personClass.getDeclaredFields();  // данный метод нарушает инкапсуляцию
                                                                // и показывает методы с пометкой private
        for (Field filds: fieldPerson){
            System.out.println(filds.getName() + ", " + filds.getType());

        }
        System.out.println("*******************************************");



//            получение всех аннотаций класса и запись в массив

        Annotation[] annotationsPerson = personClass.getAnnotations();
        for (Annotation annotation: annotationsPerson){
            System.out.println(annotation.annotationType());
            if (annotation instanceof Annotation_Syntax){   // идет проверка является ли аннотация Annotation_Syntax
                System.out.println("Yes");
            }
        }

        System.out.println("*******************************************\n\n");



        // будем динамически создавать два объекта и вызывать метод одного объекта на другом
        // в качестве параметра зададим - Java_Extend.Other.Person java.lang.String setName
        // где Java_Extend.Other.Person - класс Person расположенный по пути Java_Extend.Other.
        // java.lang.String - класс который мы передаем в качестве аргумента
        // setName - метод который есть у класса Person и в который мы передаем объект класса java.lang.String

        Scanner scanner = new Scanner(System.in);

        // считаем название первого класса, затем второго, затем метода
        // считываем строку - "Java_Extend.Other.Person java.lang.String setName"
        // разделение в каждую переменную идет по пробелу

        Class classObject01 = Class.forName(scanner.nextLine());  // создаем объект класса Класс на основе данных
        Class classObject02 = Class.forName(scanner.nextLine());
        String nameMethod = scanner.nextLine();



        // создаем объект класса Method на основе объекта первого класса, в качестве аргумента объект второго класса

        Method method01 = classObject01.getMethod(nameMethod, classObject02);



        // создание объекта на основе нашего класса с пустым конструктором

        Object object01 = classObject01.newInstance();



        // создание объекта на основе нашего класса, но сначала создаем конструктор, со строковым значением
        // и потом создаем объект передавая в качестве аргумента строковую переменную

        Object object02 = classObject02.getConstructor(String.class).newInstance("String value");



        // вызываем наш метод method01 на объекте object01 с аргументом object02

        method01.invoke(object01, object02);

        System.out.println(object01);





    }








}

    // создаем тестовый класс Person с набором разных полей, методов и конструкторов и аннотацией
    @Annotation_Syntax(purpes = "Demo Reflection")
    class Person{
        private int id;
        private String name;

        public Person() {
            this.id = -1;
            this.name = "No Name";
        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void sayHello(){
            System.out.println("Person with id: " + id + "and name: " +name  + "say Hello");
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }




