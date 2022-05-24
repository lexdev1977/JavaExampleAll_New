package NetWork_Java_Android_JSON;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JSON_General {
/*

   Ссылка на подробное руководство - https://disk.yanйdex.com/i/Bj82Ojmj3GjfcA


                                            JSON

    JSON – это стандарт транспортировки сообщений/данных от одной программы к другой.
    Таких стандартов довольно много. Но если программа написана на JavaScript, она обычно старается работать с JSON.

    в Java есть встроенные стандартные средства сериализации. Но JSON к ним не относится.
    Поэтому если тебе надо использовать сериализацию объекта в JSON, ты можешь использовать один из популярных
    фреймворков(библиотек), которые это умеют:

    - JSON.simple от Yidong Fang. Небольшая и легковесная библиотека для кодирования и декодирования JSON,
      несмотря на свою простоту, выполняет свою работу на высоком уровне.
    - GSON от Google. Библиотека, которая умеет конвертировать Java объекты в JSON и наоборот.
      Не требует специальным образом аннотировать классы, а также в качестве бонуса имеет полную поддержку Java Generics.
      Отсутствие необходимости добавления аннотаций упрощает реализацию и даже может быть главным требованием,
      если вы собираетесь сериализовывать объекты, не имея для них исходного кода.
    - Jackson от FasterXML. Набор инструментов для обработки данных, основанный на потоковом JSON-парсере и генераторе.
      Предназначенная для Java библиотека умеет работать не только с JSON. Имеет самый популярный JSON-парсер
      (исходя из статистики использования на GitHub).
    - JSONP от Oracle. API для работы с JSON, а именно для генерации и разбора потоковых JSON-текстов.
      Эталонная реализация JSR353 с открытым исходным кодом.



      Выбор библиотеки исходя из скорости работы зависит от конкретного случая:

    - если вам часто приходится работать с большими JSON-файлами, то интересующей вас библиотекой будет Jackson.
      GSON испытывает наибольшие затруднения при работе с большими файлами.
    - если вам приходится иметь дело с большим количеством коротких JSON-запросов (как это часто происходит в сервисах
      и распределённых приложениях), выбирайте GSON. Jackson справляется с большим
      количеством маленьких файлов хуже всего.
    - если вам необходимо работать как с большими, так и с маленькими файлами, JSON.simple вам в помощь:
      по результатам тестов он занимает второе место для обоих типов файлов. Ни Jackson,
      ни GSON не могут с должной скоростью работать одновременно с разными по размеру файлами.



                                            JSON структура

      Примеры написания JSON - https://disk.yandex.com/i/WMYqQsXFKYjihg
                             - https://disk.yandex.com/i/RCAFVKecGfuEQQ
      Сравнение JSON и XML   - https://disk.yandex.com/i/zo-xGXA6VDARrA

      Объект в JSON моделируется с помощью {..} а его атрибуты можно моделировать с помощью   name:value

      В качестве значений в JSON могут быть использованы:

    - JSON-объект
    - Массив
    - Число (целое или вещественное)
    - Литералы true (логическое значение «истина»), false (логическое значение «ложь») и null
    - Строка

       Пример:
                                                                                                                                                                        *//**
      {
       "firstName": "Иван",
       "lastName": "Иванов",
       "address": {
           "streetAddress": "Московское ш., 101, кв.101",
           "city": "Ленинград",
           "postalCode": 101101
       },
       "phoneNumbers": [
           "812 123-1234",
           "916 123-4567"
       ]
    }                                                                                                                                                                           *//*

    JSON-объект — это неупорядоченное множество пар «ключ:значение».  -  "firstName": "Иван"

    Переносы строк делать необязательно. Вообще пробелы и переносы строк нужны только
    человеку для читабельности, система поймет и без них:

    Ключ — ВСЕГДА строка, но мы все равно берем его в кавычки. В JavaScript этого можно не делать, в JSON нельзя.



    Популярность JSON привела к его встроенной поддержке многими базами данных, последние версии PostgreSQL и MySQL
    содержат встроенную поддержку запроса данных, хранящихся в полях JSON. Базы данных NoSQL, такие как MongoDB ,
    были построены на основе этого формата и используют документы JSON для хранения записей, точно так же,
    как таблицы и строки хранят записи в реляционной базе данных.




                                              Jackson

    Для конвертирования Java-объекта в JSON есть специальный класс ObjectMapper
    (com.fasterxml.jackson.databind.ObjectMapper). --> пример ниже



    Конвертация объекта из JSON:                                                                                                   *//**

    String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"weight\":4}";
    StringReader reader = new StringReader(jsonString);

    ObjectMapper mapper = new ObjectMapper();

    Cat cat = mapper.readValue(reader, Cat.class);                                                                                   *//*


    К объектам, которые сериализуются/десериализуются в JSON есть несколько требований:

    1) поля должны быть видимые: или public или иметь getter’ы и setter’ы;

    2) должен быть конструктор по умолчанию (без параметров).


    Аннотации в Jackson

    Аннотация	            Описание

    @JsonAutoDetect	        Ставится перед классом.
                            Помечает класс как готовый к сериализациив JSON.

    @JsonIgnore	            Ставится перед свойством.
                            Свойство игнорируется при сериализации.

    @JsonProperty	        Ставится перед свойством или getter’ом или setter’ом.
                            Позволяет задать другое имя поля при сериализации.

    @JsonPropertyOrder	    Ставится перед классом.
                            Позволяет задать порядок полей для сериализации.


    Пример:                                                                                                                                     *//**

    @JsonAutoDetect
    class Cat
    {
     @JsonProperty("alias")
     public String name;
     public int age;
     @JsonIgnore
     public int weight;

     Cat() {
     }
    }                                                                                                                                                                   *//*

     Результат - {"age":5, "alias":"Murka"}

     - указали другое имя полю name — имя alias
     - отметили поле weight как Ignore

     При десериализации из JSON в Java-объект, значение поля alias будет занесено в name объекта Cat


     Три способа обработки JSON в Jackson

    Джексон предлагает три альтернативных способа обработки JSON

    - Потоковый API – читает и записывает контент JSON как отдельные события. JsonParser читает данные,
      тогда как JsonGenerator записывает данные. Это самый мощный подход из трех,
      с минимальными накладными расходами и самый быстрый в операциях чтения / записи.
      Это аналог синтаксического анализатора Stax для XML.

    - Модель дерева – готовит представление дерева JSON в памяти. ObjectMapper построить дерево узлов JsonNode.
      Это самый гибкий подход. Это аналог парсера DOM для XML.

    - Привязка данных – преобразует JSON в POJO (простой старый объект Java) и обратно,
      используя метод доступа к свойствам или аннотации. Это двух типов.

        - Простое связывание данных – преобразует JSON в и из Java-карт, списков, строк, чисел, логических и нулевых объектов.

        - Полная привязка данных – преобразует JSON в любой тип JAVA.

    ObjectMapper читает / записывает JSON для обоих типов привязок данных.
    Привязка данных является наиболее удобным способом и аналогом JAXB parer для XML.



    - Потоковый API – читает и записывает контент JSON как отдельные события. JsonParser читает данные,
      тогда как JsonGenerator записывает данные. Это самый мощный подход из трех,
      с минимальными накладными расходами и самый быстрый в операциях чтения / записи.
      Это аналог синтаксического анализатора Stax для XML.

    - Модель дерева – готовит представление дерева JSON в памяти. ObjectMapper построить дерево узлов JsonNode.
      Это самый гибкий подход. Это аналог парсера DOM для XML.

    - Привязка данных – преобразует JSON в POJO (простой старый объект Java) и обратно,
      используя метод доступа к свойствам или аннотации. Это двух типов.

    - Простое связывание данных – преобразует JSON в и из Java-карт,
      списков, строк, чисел, логических и нулевых объектов.

    - Полная привязка данных – преобразует JSON в любой тип JAVA.



     @JsonAutoDetect

    Аннотация имеет 5 методов:

    - fieldVisibility() - сериализует поля только с указанным модификатором доступа
    - getterVisibility()/setterVisibility() - сериализует поля,
      у которых геттер/сеттер имеет указанный модификатор доступа
    - isGetterVisibility() - отдельная реализация для булевских геттеров

    Важно понимать, что методы работают дизъюнктивно. Т.е. если поле соответствует хотя бы одному
    из указанных в аннотации параметров, то оно попадет в JSON.

    Пример:                                                                                                                                              *//**

        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY,
            getterVisibility        = JsonAutoDetect.Visibility.PUBLIC_ONLY,
            setterVisibility        = JsonAutoDetect.Visibility.PUBLIC_ONLY,
            isGetterVisibility      = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)

        public class HeadClass {
        public String name;
        private Map<String, String> properties;
        public Queue<String> queue;
        protected List<String> list;
        private int age;
        private int number;
        private boolean isHead;

        protected HeadClass(int age) {
            this.age = age;
        }

        public HeadClass() {}

        Map<String, String> getProperties() {
            return properties;
        }

        protected boolean isHead() {
            return isHead;
        }

        protected void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }                                                                                                                                                   *//*

    Четыре перечисленных метода конфигурировали процесс сериализации.
    Пятый же в свою очередь регулирует процесс десериализации:                                                                                               *//**

        creatorVisibility() - работает с конструкторами и с фабричными методами
        (методы, которые создают объект при обращении к ним). Рассмотрим пример:

        @JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
        public class HeadClass {
        public String name;
        public int id;

        HeadClass(@JsonProperty(value = "name") String name, @JsonProperty(value = "id") int id) {
            this.name = name;
            this.id = id;
        }

        protected HeadClass(String name) {
            this.name = name;
            this.id = 123;
        }

        protected HeadClass(int id) {
            this.id = id;
            this.name = "Yes!";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }                                                                                                                                                                       *//*

                                                                                                                                                                                *//**
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String forDeserialize = "{\"name\":\"No!\",\"id\":123}";
        StringReader reader = new StringReader(forDeserialize);

        HeadClass headClass1 = (HeadClass) mapper.readValue(reader, HeadClass.class);
    }                                                                                                                                                                *//*

    Важное замечание по механизму десериализации! Когда мы пытаемся создать объект из JSON,
    то будет осуществляться поиск конструктора требуемого класса с таким же набором параметров,
    что и в JSON объекте. В примере выше наш JSON объект состоит из двух параметров:
    name, id. Угадайте, к какому конструктору он обратится. И да, если мы скомпилируем этот код,
    он выдаст ошибку, а почему? Потому что мы ограничили видимость конструктора
    (видны только конструкторы с модификатором protected, public).
    Если вы удалите creatorVisibility, то он заработает.











 */


 // пример создания JSON при помощи фрейворка Jackson результат - {"name":"Murka", "age":5, "weight":4}

    public static void main(String[] args) throws IOException {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
        cat.id = 10;

        //писать результат сериализации будем во Writer(StringWriter)
        // создаем объект Writer, куда будем писать строку — JSON представление объекта.
        StringWriter writer = new StringWriter();

        // это объект Jackson, который выполняет сериализацию
        //  создаем объект ObjectMapper, который и выполняет всю сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        // пишем JSON-представление объекта cat в writer
        mapper.writeValue(writer, cat);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
    }
    }

    // создаем объект класса Cat и заполняем его данными.
    @JsonAutoDetect
    class Cat
    {
        public String name;
        public int age;
        public int weight;
        public int id;
        Cat(){}
    }

