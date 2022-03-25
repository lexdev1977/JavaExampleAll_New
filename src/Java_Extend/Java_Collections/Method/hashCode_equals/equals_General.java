package Java_Extend.Java_Collections.Method.hashCode_equals;

public class equals_General {

    /*

                            Метод Equals() - сравнение объектов

    Метод equals() принадлежит классу Object самому главному классу в Java, от которого происходят все остальные классы.
    Метод по умолчанию работает таким образом, что он сравнивает два объекта по их ссылкам,
    и не смотрит само содержимое объектов.

     public boolean equals(Object obj) {
                 return (this == obj);
                 }

    Таки образом два объекта с одинаковым содержимым, будут являтся разными объектами:

                Person person01 = new People ("Alex", 10);
                Person person02 = new People ("Alex", 10);

    В классах обертках тиа Integer, String и т.д. этот метод уже переопределен нужным образом.


    Эти объекты равны:

                Integer x = 10;
                Integer y = 10;

                String a = "Hello";
                String b = "Hello";

                x.equals(y) - true
                a.equals(b) - true

                также будет верно и:

                x==y
                a==b

     !!! Однако если создать вот таким образом:

      String n = "Hello!";
      String m = new String("Hello!");

      n==m         выдаст - false
      n.equals(m)  выдаст - true

      Это связанно со специальной областью памяти для хранения строк — пулом строк (String pool)
      О String pool читать в разделе String\String pool

      У String есть переопределенный метод equals(). И сравнивает он не ссылки,
      а именно последовательность символов в строках.
      И если текст в строках одинаковый, неважно, как они были созданы и где хранятся:
      в пуле строк, или в отдельной области памяти. Результатом сравнения будет true.


      Кстати, Java позволяет корректно сравнивать строки без учета регистра.

      Для этого случая в классе String имеется метод equalsIgnoreCase().
      Если в твоем сравнении главным является именно последовательность конкретных символов,
      а не их регистр, можно применить его

      Пример:

      String address1 = "г. Москва, ул. Академика Королева, дом 12";
      String address2 = new String("Г. МОСКВА, УЛ. АКАДЕМИКА КОРОЛЕВА, ДОМ 12");
      System.out.println(address1.equalsIgnoreCase(address2));   // выдаст true


     Метод в классе можно переопределить самостоятельно и самому решить по какому сценарию будут сравниваться объекты,
     также можно воспользоваться средой, которая автоматически сгенерирует переопределение нажав alt+insert
     и выбрав раздел "equals() and hashCode()", далее нужно выбрать поля для сравнения

     Например, сравним два объекта класса Man по полю dnaCode:

     static class Man {     // создаем класс

     int dnaCode;           // поле

     public boolean equals(Man man) {           // переопределяем метод equals
       return this.dnaCode ==  man.dnaCode;
     }

     public static void main(String[] args) {

       Man man1 = new Man();
       man1.dnaCode = 1111222233;

       Man man2 = new Man();
       man2.dnaCode = 1111222233;

       System.out.println(man1.equals(man2));

   }
}

            !!! Важно помнить

            Во первых - поля имеющие тип String,  нужно сравнивать с помощью вызова метода equals.

            например:  this.name.equals(person.name)

            Во вторых поле равным null: тогда вызвать метод equals у него нельзя.
            Нужна дополнительная проверка на null:

             например: this.name != null && this.name.equals(person.name)

            Однако если name равно null в обоих объектах, имена все-таки равны.






     */



}
