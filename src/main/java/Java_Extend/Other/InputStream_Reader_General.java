package Java_Extend.Other;

public class InputStream_Reader_General {

/*
                                        Потоки для ввода данных

                                        Потоки данных

                                        Иерархия


        InputStream
        |
        |--- ByteArrayInputStream
        |
        |--- FileInputStream
        |
        |--- FilterInputStream
        |           |
        |           |--- BufferedInputStream
        |           |
        |           |--- DataInputStream
        |
        |--- ObjectInputStream
        |
        |--- PipedInputStream





                                 * Входной поток InputStream

    Базовый класс InputStream - это абстрактный класс, определяющий входной поток данных,
    и является родителем для классов, получающих данные из различных источников :
    массив байтов, строки (String), файлы, каналы pipe, у которых одна из сторон является входом,
    а вторая сторона играет роль выхода, и т.д. Методы класса InputStream при возникновении ошибки
    вызывают исключение IOException.

    Класс InputStream часто выступает в качестве параметров конструкторов или методов различных классов.
    Согласно правилам наследования это означает, что в качестве параметра может быть передан объект
    любого класса-наследника. Это позволяет комбинировать классы для достижения нужных нам целей.


        Методы класса InputStream :

    Метод	                                Описание
    int read()	                            возвращает очередной доступный символ во входном потоке в виде целого
    int read(byte b[])	                    чтение b.length байтов из входного потока в массив b.
                                            Возвращает количество прочитанных из потока байтов
    int read(byte b[], int off, int len)	чтение len байтов в массиве b, начиная со смещения off.
                                            Возвращает количество реально прочитанных байтов
    long skip(long n)	                    пропуск во входном потоке n байтов. Возвращает количество пропущенных байтов
    int available()	                        получение количество доступных для чтения байтов
    void close()	                        закрытие источник ввода. Последующие попытки чтения из этого потока
                                            вызывают IOException
    void mark(int readlimit)	            установка метки в текущей позиции входного потока, которую можно будет
                                            использовать до тех пор, пока из потока не будет прочитано readlimit байтов
    void reset()	                        перевод указателя потока на установленную ранее метку
    boolean markSupported()	                проверка поддержки потоком операции mark/reset



                                        * ByteArrayInputStream

    Класс ByteArrayInputStream использует байтовый массив в качестве источника данных. Он имеет следующие конструкторы :

    ByteArrayInputStream(byte[] buf);
    ByteArrayInputStream(byte[] buf, int offset, int length);

    В качестве параметров конструкторы ByteArrayInputStream используют массив байтов buf для чтения,
    смещение относительно начала массива offset и количество считываемых символов length.

    В отличие от других классов потоков для закрытия объекта ByteArrayInputStream не требует вызывать метод close.                       *//**

        public class TestBIS
    {
        public static void main(String[] args)
        {
            byte[] array1 = new byte[]{1, 3, 5, 7};
            ByteArrayInputStream bis1;
            bis1 = new ByteArrayInputStream(array1);
            int b;
            while((b = bis1.read()) != -1)
                System.out.println(b);

            String text = "Hello world!";
            byte[] array2 = text.getBytes();
            ByteArrayInputStream bis2;
            bis2 = new ByteArrayInputStream(array2, 0, 5);
            while((b = bis2.read()) != -1)
                System.out.println((char)b);
        }
    }                                                                                                                                                                   *//*



                                            * FileInputStream

    FileInputStream - основной класс из данной иерархии для работы с файлами. Имеет два основных конструктора.

    FileInputStream(File file) throws FileNotFoundException;
    FileInputStream(String name) throws FileNotFoundException;


    FileInputStream(String fileName) throws FileNotFoundException
    Если файл не может быть открыт то генерируется исключение FileNotFoundException.

    Пример считывания данных из файла и вывод содержимого в консоль:                                                                                                    *//**

    import java.io.FileInputStream;

    public class FilesApp
    {
        public static void main(String[] args)
        {
            try {
                FileInputStream fis;
                fis=new FileInputStream("C:\\test_dir\\test.txt");
                System.out.println("Размер файла: " +
                                    fis.available() + " байт(а)");
                int i = -1;
                while(( i = fis.read()) != -1){
                    System.out.print((char)i);
                }
                fis.close();
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }                                                                                                                                           *//*

    Данные файла можно считать в массив байтов :                                                                                                                         *//**

    byte[] buffer = new byte[fis.available()];
    // чтение файла в буфер
    fis.read (buffer, 0, fis.available());

    System.out.println ("Содержимое файла:");
    for(int i = 0; i < buffer.length; i++){
        System.out.print((char)buffer[i]);
    }                                                                                                                                                                                               *//*

    Класс FileInputStream предназначен прежде всего для работы с двоичными файлами.
    Его можно использовать для работы с текстовыми файлами, но все же для этой задачи больше подходят другие классы.

    Пример использования FileInputStream для чтения файла свойств в кодировке UTF-8:

    Файл свойств "data.properties" в кодировке UTF-8:

    #
    # Параметры сервера SMTP
    #
    company=Рога и копыта
    manager=Остап Бендер
    Листинг примера :                                                                                                                                                       *//**

    import java.io.Reader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.FileInputStream;
    import java.io.InputStreamReader;

    import java.util.Properties;

    public class Main
    {
        public static void main(String[] args)
        {
            try {
                InputStream is;
                is = new FileInputStream("data.properties");
                if (is != null) {
                    Reader reader;
                    reader = new InputStreamReader(is, "UTF-8");
                    Properties props = new Properties();
                    props.load(reader);

                    System.out.println (
                             props.getProperty ("company") + ", "
                             props.getProperty ("manager"));

                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }                                                                                                                                                                         *//*


                                          * FilterInputStream

    FilterInputStream - абстрактный класс, предоставляющий интерфейс для классов-надстроек,
    которые добавляют к существующим потокам полезные свойства. FilterInputStream является базовым классом
    для двух других классов. Его единственный конструктор требует передачи в качестве параметра объекта
    класса InputStream, т.е. фактически объекта некоторого неабстрактного класса, порожденного от InputStream.

    Прямое использование FilterInputStream в программе нецелесообразно.


                                           * BufferedInputStream

    BufferedInputStream служит для организации более эффективного "буферизованного" ввода данных.
    Буферизация ввода-вывода является удобным способом оптимизации производительности,
    позволяя заключить в оболочку любой поток класса InputStream.                                                                                       *//**

    import java.io.*;

    public class TestBufferedInputStream
    {
        public static void main(String[] args)
        {
            String text = "Hello world!";
            byte[] buffer = text.getBytes();
            ByteArrayInputStream bais;
            bais = new ByteArrayInputStream(buffer);
            try {
                BufferedInputStream bis;
                bis = new BufferedInputStream(bais);
                int c;
                while((c = bis.read()) != -1){
                    System.out.print((char)c);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }                                                                                                                                                               *//*

    В конструкторе класса BufferedInputStream необходимо передать InputStream.
    В данном случае таким объектом является экземпляр класса ByteArrayInputStream.

    Как и все потоки ввода BufferedInputStream обладает методом read(),
    который считывает данные с помощью метода read из массива buffer.

    Фактические все то же самое можно было сделать и с помощью одного ByteArrayInputStream,
    не прибегая к буферизированному потоку. Класс BufferedInputStream просто оптимизирует производительность
    при работе с потоком ByteArrayInputStream.



                                               * DataInputStream

    Для чтения байтовых данных (не строк) применяется класс DataInputStream.
    В этом случае необходимо использовать классы из группы InputStream. Для преобразования строки в массив байтов,
    пригодный для помещения в поток ByteArrayInputStream, в классе String предусмотрен метод getBytes().
    Полученный ByteArrayInputStream представляет собой поток InputStream, подходящий для передачи DataInputStream.

    При побайтовом чтении символов из форматированного потока DataInputStream методом readByte()
    любое полученное значение будет считаться действительным, поэтому возвращаемое значение неприменимо
    для идентификации конца потока. Вместо этого можно использовать метод available(), который сообщает,
    сколько еще осталось символов.

    Класс DataInputStream позволяет читать элементарные данные из потока через интерфейс DataInput,
    который определяет методы, преобразующие элементарные значения в форму последовательности байтов.
    Такие потоки облегчают сохранение в файле двоичных данных.

    Конструктор класса DataInputStream:

    DataInputStream(InputStream stream)


    Методы DataInputStream

    Метод	                    Описание
    boolean readBoolean()	    байт булевого однобайтового значения
    byte readByte()	            байт одного байта
    char readChar()	            байт значения char
    double readDouble()	        байт восьмибайтового значения double
    float readFloat()	        чтение четырехбайтового значения float
    int readInt()	            чтение целочисленного значения int
    long readLong()	            чтение значения long
    short readShort()	        чтение значения short
    String readUTF()	        чтение строки в кодировке UTF-8
    int skipBytes(int n)	    пропуск при чтении n байтов

    Пример чтения из бинарного файла с использованием DataInputStream                                                                                       *//**

    import java.io.*;

    public class TestDataInputStream
    {
        public static void main(String[] args)
        {
            // Считывание из бинарного файла data.bin объекта
            // типа Person
            try {
                DataInputStream dis;
                dis = new DataInputStream(
                                new FileInputStream("data.bin"));
                String name     = dis.readUTF();
                int    age      = dis.readInt();
                double height   = dis.readDouble();
                boolean married = dis.readBoolean();
                System.out.printf("Человека зовут: %s ; " +
                                   "его возраст: %d , " +
                                   "его рост: %f метров, " +
                                   "женат/замужем: %b",
                                   name, age, height, married);
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
       }
    }                                                                                                                                                                    *//*


                                       * ObjectInputStream

    Класс ObjectInputStream отвечает за чтение ранее сериализованных данных из потока.
    В конструкторе он принимает ссылку на поток ввода:

    ObjectInputStream(InputStream in)


    Основные методы класса ObjectInputStream :

    Метод	                Описание
    int read()	            чтение одного байта; возвращает его целочисленное представление
    boolean readBoolean()	чтение одного значения boolean
    byte readByte()	        чтение одного байта
    char readChar()	        чтение одного символ char
    double readDouble()	    чтение значения типа double
    float readFloat()	    чтение значения типа float
    int readInt()	        чтение целочисленного значения int
    long readLong()	        чтение значения типа long
    short readShort()	    чтение значения типа short
    String readUTF()	    чтение строки в кодировке UTF-8
    Object readObject()	    чтение объекта
    int skipBytes(int len)	пропуск при чтении нескольких байт, количество которых равно len
    int available()	        чтение количества доступных для чтения байт
    void close()	        закрытие потока


    Пример чтения объекта Person из файла :                                                                                                                                 *//**

    import java.io.*;

    public class TestObjectInputStream
    {
        public static void main(String[] args)
        {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(
                            new FileInputStream("person.dat"));
                Person person = (Person) ois.readObject();
                System.out.printf("Имя: %s \t Возраст: %d \n",
                                   person.name, person.age);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        class Person implements Serializable
        {
            private static final long serialVersionUID = 1L;

            public String name;
            public int age;
            public double height;
            public boolean married;

            public Person(String n, int a, double h, boolean m)
            {
                this.name    = n;
                this.height  = h;
                this.age     = a;
                this.married = m;
            }
        }
    }                                                                                                                                                    *//*


                                    * Класс PipedInputStream

    Класс PipedInputStream - это специальный класс, используемый для связи отдельных программ (потоков)
    друг с другом внутри одной JVM. Данный класс является важным инструментом организации синхронизации потоков.

    Конструкторы PipedInputStream :

    PipedInputStream()
    PipedInputStream(int pipeSize)
    PipedInputStream (PipedOutputStream src)
    PipedInputStream (PipedOutputStream src, int pipeSize)


    Методы PipedInputStream :

    available()
    close()
    connect (PipedOutputStream src)
    read()
    read(byte[] b, int off, int len)
    receive(int b)

    Пример простого использования PipedInputStream :                                                                                                    *//**

    InputStream input = new PipedInputStream (pipedOutputStream);

    int data = input.read();
    while(data != -1) {
        // обработка данных в отдельном
        // методе doSomethingWithData
        doSomethingWithData(data);

        data = input.read();
    }
    input.close();                                                                                                                                               *//*



                                Из другой статьи и ниже примеры

    Любая программа редко существует сама по себе. Обычно она как-то взаимодействует с «внешним миром».
    Это может быть считывание данных с клавиатуры, отправка сообщений, загрузка страниц из интернета или, наоборот,
    загрузка файлов на удалённый сервер.

    Все это называется — процесс обмена данными между программой и внешним миром.

    Сам процесс обмена данными можно разделить на два типа: получение данных и отправка данных.
    Например, вы считываете данные с клавиатуры с помощью объекта Scanner — это получение данных.
    И выводите данные на экран с помощью команды System.out.println() — это отправка данных.

    Для описания процесса обмена данными в программировании используется термин поток.

    Потоки — это универсальный инструмент. Они позволяют программе получать данные откуда угодно (входящие потоки)
    и отправляют данные куда угодно (исходящие потоки). Делятся на два вида:

    - Входящий поток (Input): используется для получения данных
    - Исходящий поток (Output): используется для отправки данных

    Для реализации потоков существует два класса - InputStream и OutputStream

    У класса InputStream есть метод read(), который позволяет читать из него данные.
    А у класса OutputStream есть метод write(), который позволяет записывать в него данные.
    Помимо этих методов, существуют и другие, для работы с потоком.


                                         Байтовые потоки

    Что же это за данные и в каком виде их можно читать? Другими словами,
    какие типы данных поддерживаются этими классами?

    Это универсальные классы, и поэтому они поддерживают самый распространённый тип данных — byte.
    В OutputStream можно записывать байты (и массивы байт), а из объекта InputStream можно читать байты
    (или массивы байт). Все — никакие другие типы данных они не поддерживают.

    Поэтому такие потоки еще называют байтовыми потоками.

    Особенность потоков в том, что данные из них можно читать (писать) только последовательно.
    Вы не можете прочитать данные из середины потока, не прочитав все данные перед ними.

    Именно так работает чтение с клавиатуры через класс Scanner: вы читаете данные с клавиатуры последовательно:
    строка за строкой. Прочитали строку, прочитали следующую строку, прочитали следующую строку и т.д.
    Поэтому метод чтения строки и называется nextLine() (дословно — «следующая срока»).

    Запись данных в поток OutputStream тоже происходит последовательно. Хороший пример — вывод на экран.
    Вы выводите строку, за ней еще одну и еще одну. Это последовательный вывод. Вы не можете вывести 1-ю строку,
    затем 10-ю, а затем вторую. Все данные записываются в поток вывода только последовательно.


                                           Символьные потоки

    Строки — второй по популярности тип данных
    Java-программисты учли этот факт и написали еще два класса: Reader и Writer.
    Класс Reader — это аналог класса InputStream, только его метод read() читает не байты, а символы — char.
    Класс Writer соответствует классу OutputStream, и так же, как и класс Reader, работает с символами (char),
    а не байтами.

                        Байты (byte)	    Символы (char)
    Чтение данных       InputStream         Reader
    Запись данных       OutputStream        Writer

    Сами классы InputStream, OutputStream, Reader и Writer в явном виде никто не использует:
    они не присоединены ни к каким внешним объектам, из которых можно читать данные (или в которые можно писать данные).
    Однако у этих четырех классов много классов-наследников


                                            Класс InputStream

    Класс InputStream интересен тем, что является классом-родителем для сотен классов-наследников.
    В нем самом нет никаких данных, однако у него есть методы, которые есть у всех его классов-наследников.

    Объекты-потоки вообще редко хранят в себе данные. Поток — это инструмент чтения/записи данных, но не хранения.
    Хотя бывают и исключения.

    Методы класса InputStream и всех его классов-наследников:

      Методы	                  Описание
    - int read()                  Читает один байт из потока
    - int read(byte[] buffer)     Читает массив байт из потока
    - byte[] readAllBytes()       Читает все байты из потока
    - long skip(long n)           Пропускает n байт в потоке (читает и выкидывает)
    - int available()             Проверяет, сколько байт еще осталось в потоке
    - void close()                Закрывает поток


    Метод read()
    Читает один байт из потока и возвращает его. Вас может сбить тип результата — int, однако так было сделано,
    потому что тип int — это стандарт всех целых чисел. Три первые байта типа int будут равны нулю.

    Метод read(byte[] buffer)
    Это вторая модификация метода read(). Он позволяет считать из InputStream сразу массив байт.
    Массив для сохранения байт нужно передать в качестве параметра.
    Метод возвращает число — количество реально прочитанных байт.
    Допустим у вас буфер на 10 килобайт, и вы читаете данные из файла с помощью класса FileInputStream.
    Если файл содержит всего 2 килобайта, все данные будут помещены в массив-буфер,
    а метод вернет число 2048 (2 килобайта).

    Метод readAllBytes()
    Очень хороший метод. Просто считывает все данные из InputStream, пока они не закончатся,
    и возвращает их в виде единого массива байт. Очень удобен для чтения небольших файлов.
    Большие файлы могут физически не поместиться в память, и метод кинет исключение.

    Метод skip(long n)
    Этот метод позволяет пропустить n первых байт из объекта InputStream.
    Поскольку данные читаются строго последовательно,
    этот метод просто вычитывает n первых байт из потока и выбрасывает их.
    Возвращает число байт, которые были реально пропущены (если поток закончился раньше, чем прокрутили n байт).

    Метод int available()
    Метод возвращает количество байт, которое еще осталось в потоке

    Метод void close()
    Метод close() закрывает поток данных и освобождает связанные с ним внешние ресурсы.
    После закрытия потока данные из него читать больше нельзя.


    Давайте напишем пример программы, которая копирует очень большой файл.
    Его нельзя весь считать в память с помощью метода readAllBytes(). Пример:

                                                                                                                                                    *//**
    String src = "c:\\projects\\log.txt";
    String dest = "c:\\projects\\copy.txt";

    try(FileInputStream input = new FileInputStream(src);     <!-- InputStream для чтения из файла
    FileOutputStream output = new FileOutputStream(dest))     <!-- OutputStream для записи в файл
    {
       byte[] buffer = new byte[65536]; // 64Kb               <!-- Буфер, в который будем считывать данные
       while (input.available() > 0)                          <!-- Пока данные есть в потоке
       {
          int real = input.read(buffer);                      <!-- Считываем данные в буфер
          output.write(buffer, 0, real);                      <!-- Записываем данные из буфера во второй поток
       }
    }                                                                                                                                                *//*

    В этом примере мы использовали два класса: FileInputStream — наследник InputStream для чтения данных из файла,
    и класс FileOutputStream — наследник OutputStream для записи данных в файл.

    Еще один интересный момент — это переменная real. Когда из файла будет читаться последний блок данных,
    легко может оказаться, что его длина меньше 64Кб. Поэтому в output нужно тоже записать не весь буфер,
    а только его часть: первые real байт. Именно это и делается в методе write().





                                                Класс Reader

    Класс Reader — это полный аналог класса InputStream, с одним только отличием: он работает с символами — char,
    а не с байтами. Класс Reader, так же, как и класс InputStream самостоятельно нигде не используется:
    он является классом-родителем для сотен классов-наследников и задает для них всех общие методы.

      Методы	                  Описание
    - int read()                  Читает один char из потока
    - int read(char[] buffer)     Читает массив char’ов из потока
    - long skip(long n)           Пропускает n char’ов в потоке (читает и выбрасывает)
    - boolean ready()             Проверяет, что в потоке еще что-то осталось
    - void close()                Закрывает поток

    Методы очень похожи на методы класса InputStream, хотя есть и небольшие отличия.

    Метод int read()
    Это метод читает из потока один char и возвращает его. Тип char расширяется до типа int,
    но первые два байта результата всегда нули.

    Метод int read(char[] buffer)
    Это вторая модификация метода read(). Он позволяет считать из Reader сразу массив символов.
    Массив для символов нужно передать в качестве параметра.
    Метод возвращает число — количество реально прочитанных символов.

    Метод skip(long n)
    Этот метод позволяет пропустить n первых символов из объекта Reader.
    Работает точно так же, как аналогичный метод класса InputStream.
    Возвращает число символов, которые были реально пропущены.

    Метод boolean ready()
    Возвращает true, если в потоке есть еще не прочитанные байты.

    Метод void close()
    Метод close() закрывает поток данных и освобождает связанные с ним внешние ресурсы.
    После закрытия потока данных из него читать больше нельзя.

    Давайте для сравнения напишем программу, которая копирует текстовый файл:
                                                                                                                                                            *//**
    String src = "c:\\projects\\log.txt";
    String dest = "c:\\projects\\copy.txt";

    try(FileReader reader = new FileReader(src);            <!-- Reader для чтения из файла
    FileWriter writer = new FileWriter(dest))               <!-- Writer для записи в файл
    {
       char[] buffer = new char[65536]; // 64Kb             <!-- Буфер, в который будем считывать данные
       while (reader.ready())                               <!-- Пока данные есть в потоке
       {
          int real = reader.read(buffer);                   <!-- Читаем данные в буфер
          writer.write(buffer, 0, real);                    <!-- Записываем данные из буфера во второй поток
       }
    }                                                                                                                                                           *//*








 */






}
