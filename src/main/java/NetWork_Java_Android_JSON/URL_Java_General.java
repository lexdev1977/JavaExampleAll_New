package NetWork_Java_Android_JSON;

public class URL_Java_General {
/*
    URL – адрес-это ссылка или адрес на ресурс в сети.
    Java-код, передаваемый по сети, может использовать java.net.URL класс для представления адресов ресурсов.

                                                                                                                                        *//**
    <!--  .openStream - получает объект InputStream у URL(интернет) объекта                                                                                 *//*


    URL обозначает унифицированный указатель ресурса и представляет ресурс во Всемирной компьютерной сети,
    такой как веб-страница или каталог FTP (протокол пересылки файлов).

    В этом разделе указано о том, как писать Java-программы, которые взаимодействуют с URL.
    URL может быть разбит на части, как указано ниже:                                                                                            *//**

    <!-- protocol://host:port/path?query#ref                                                                                                                    *//*

    Примеры протоколов включают HTTP (протокол передачи гипертекстовых файлов),
    HTTPS (протокол защищенной передачи гипертекстовой информации),
    FTP и файлов. Путь также называется именем файла, а хост также называется полномочием.

    Ниже приведен URL-адрес веб-страницы, протоколом которой является HTTP:                                                                                  *//**

    <!-- https://www.amrood.com/index.htm?language=en#j2se                                                                                                *//*

    Обратите внимание, что этот URL не указывает порт, и в этом случае используется порт по умолчанию для протокола.
    При HTTP порт по умолчанию - 80.

    Класс java.net.URL представляет URL и имеет полный набор методов для управления URL в Java.

    Класс URL имеет несколько конструкторов для создания URL, включая следующие:

    - 1	public URL(String protocol, String host, int port, String file) throws MalformedURLException
        public URL(URL context, String url) throws MalformedURLException
    - 2	public URL(String protocol, String host, String file) throws MalformedURLException
        Идентичен предыдущему конструктору, за исключением того, что для данного протокола используется порт по умолчанию.
    - 3	public URL(String url) throws MalformedURLException
        Создает URL путем заданной адресной строки.
    - 4	public URL(URL context, String url) throws MalformedURLException
        Создает URL, анализируя аргументы URL и адресной строки.


                                        Методы класса URL

    Класс URL содержит много методов для доступа к различным частям представляемого URL.
    Некоторые из методов в классе URL включают следующее:                                                                                        *//**


     <!-- public String getPath()                   Возвращает путь URL.
     <!-- public String getQuery()                  Возвращает часть запроса URL.
     <!-- public String getAuthority()              Возвращает полномочия URL.
     <!-- public int getPort()                      Возвращает порт URL.
     <!-- public int getDefaultPort()               Возвращает порт по умолчанию протокола URL.
     <!-- public String getProtocol()               Возвращает протокол URL.
     <!-- public String getHost()                   Возвращает хост URL.
     <!-- public String getHost()                   Возвращает хост URL.
     <!-- public String getFile()                   Возвращает имя файла URL.
     <!-- public String getRef()                    Возвращает часть ссылки URL.
     <!-- public URLConnection openConnection()     Открывает соединение с URL,
          throws IOException             <!--       позволяя клиенту взаимодействовать с ресурсом.                                                                                                             *//*



    Пример:                                                                                                                                             *//**

    try {
                URL url = new URL("https://www.amrood.com/index.htm?language=en#j2se");

                System.out.println("URL: " + url.toString());
                System.out.println("протокол: " + url.getProtocol());
                System.out.println("полномочия: " + url.getAuthority());
                System.out.println("имя файла: " + url.getFile());
                System.out.println("хост: " + url.getHost());
                System.out.println("путь: " + url.getPath());
                System.out.println("порт: " + url.getPort());
                System.out.println("порт по умолчанию: " + url.getDefaultPort());
                System.out.println("запрос: " + url.getQuery());
                System.out.println("ссылка: " + url.getRef());
            } catch (IOException e) {
                e.printStackTrace();
            }                                                                                                                                                       *//**

    Вывод на консоль:                                                                                                                            *//**

     <!--           URL: https://www.amrood.com/index.htm?language=en#j2se
     <!--           протокол: http
     <!--           полномочия: www.amrood.com
     <!--           имя файла: /index.htm?language=en
     <!--           хост: www.amrood.com
     <!--           путь: /index.htm
     <!--           порт: -1
     <!--           порт по умолчанию: 80
     <!--           запрос: language=en
     <!--           ссылка: j2se                                                                                                                                                 *//*




    Платформа Java поставляется со встроенной сетевой поддержкой, включенной в java.net пакет

    Получение страницы из интернета:                                                                                                                        *//**

    URL url = new URL("https://javarush.ru");   // Создает объект URL с путем к странице
        InputStream input = url.openStream();   // Получает InputStream у интернет-объекта
        byte[] buffer = input.readAllBytes();   // Читает все байты и возвращает массив байт
        String str = new String(buffer);        // Преобразуем массив в строку
        System.out.println(str);                // Выводим строку на экран                                                                                                                      *//*



                                Сравнение работы File и URL

    URL — это такой аналог File или Path, только Path хранит путь к ресурсу в файловой системе,
    а URL — путь к ресурсу в интернете.

    Вызывая метод openStream() получаем сразу объект типа InputStream

            Работа с интернетом	                                            Работа с файлом                                                                             *//**
    URL url = new URL("https://javarush.ru");               File file = new File("c:\\readme.txt");
    InputStream input = url.openStream();                   InputStream input = new FileInputStream(file);

    byte[] buffer = input.readAllBytes();                   byte[] buffer = input.readAllBytes();
    String str = new String(buffer);                        String str = new String(buffer);
    System.out.println(str);                                System.out.println(str);                                                                                        *//*




                                        Класс URLConnection

    Кроме простого чтения данных из интернета, мы еще можем и загружать туда данные.

    Метод openConnection() возвращает java.net.URLConnection, абстрактный класс,
    подклассы которого представляют различные типы подключений URL.

    Например:

    Если вы подключаетесь к URL, протокол которого HTTP, метод openConnection() возвращает объект подключения HttpURL.
    Если вы подключаетесь к URL, который представляет файл JAR (архивный файл приложения на языке Java),
    метод openConnection() возвращает объект подключения JarURL и т.д.
    У класса подключения URL есть много методов для установки или определения информации о соединении,
    включая следующие:

                                                                                                                                                                    *//**
     <!--   Object getContent()
            Получает содержимое этого URL-соединения.

     <!--   Object getContent(Class[] classes)
            Получает содержимое этого URL-соединения.

     <!--   String getContentEncoding()
            Возвращает значение строки заголовка с кодировкой содержимого.

     <!--   int getContentLength()
            Возвращает значение строки заголовка с длиной содержимого.

     <!--   String getContentType()
            Возвращает значение строки заголовка с типом содержимого.

     <!--   int getLastModified()
            Возвращает значение строки заголовка с последними изменениями.

     <!--   long getExpiration()
            Возвращает значение строки заголовка, превышающее длину.

     <!--   long getIfModifiedSince()
            Возвращает значение поля ifModifiedSince этого объекта.

     <!--   public void setDoInput(boolean input)
            Передает true (истина), чтобы обозначить, что соединение будет использоваться для ввода.
            Значение по умолчанию - true, потому что клиенты обычно считывают из URL-соединения.

     <!--   public void setDoOutput(boolean output)
            Передает true, чтобы обозначить, что соединение будет использоваться для вывода.
            Значение по умолчанию - false (ложь), поскольку многие типы URL не поддерживают запись.

     <!--   public InputStream getInputStream() throws IOException
            Возвращает поток входных данных URL-соединения для считывания из ресурса.

     <!--   public OutputStream getOutputStream() throws IOException
            Возвращает поток выходных данных URL-соединения для записи на ресурс.

     <!--   public URL getURL()
            Возвращает URL, с которым связан данный объект URL-соединения.                                                                           *//*



    Пример использования:

    Следующая программа URLConnectionDemo подключается к URL-адресу, введенному из командной строки.

    Если URL представляет ресурс HTTP, соединение преобразуется в HttpURL-соединение,
    и данные в ресурсе считываются по одной строке за раз.                                                                                      *//**

        // File Name : URLConnDemo.java
    import java.net.*;
    import java.io.*;

    public class URLConnDemo {

       public static void main(String [] args) {
          try {
             URL url = new URL("https://www.amrood.com");
             URLConnection urlConnection = url.openConnection();
             HttpURLConnection connection = null;
             if(urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
             }else {
                System.out.println("Пожалуйста, введите HTTP URL.");
                return;
             }

             BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
             String urlString = "";
             String current;

             while((current = in.readLine()) != null) {
                urlString += current;
             }
             System.out.println(urlString);
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    }                                                                                                                                                                   *//*

    Пробный запуск этой программы даст следующий результа:

    $ java URLConnDemo

    .....HTML-содержимое домашней страницы amrood.com.....



    Пример использования 2:                                                                                                                                    *//**

    URL url = new URL("https://javarush.ru");                   // Создаем объект URL с путем к странице
    URLConnection connection = url.openConnection();            // Создаем двустороннее соединение

     <!-- получили поток для отправки данных
    OutputStream output = connection.getOutputStream();         // Получаем поток вывода
    output.write(1);                                            // Выводим в него данные

     <!-- получили поток для чтения данных
    InputStream input = connection.getInputStream();            // Получаем поток ввода
    int data = input.read();                                    // Читаем из него данные                                                                                 *//*

    Обратите внимание, что тут мы больше не вызываем метод url.openStream(). Вместо этого:

    - Сначала мы устанавливаем стабильное двустороннее соединение с помощью метода URLConnection openConnection()
    - Затем получаем поток для отправки данных с помощью метода connection.getOutputStream() и отправляем данные серверу
    - Затем получаем поток для чтения данных с помощью метода connection.getInputStream()
      и начинаем читать из него данные.

                                            Контроль ресурсов

    Строго говоря, мы должны все потоки обернуть в try-with-resources для безопасной работы.
    А еще не помешало бы обернуть голые InputStream и OutputStream во что-нибудь более удобное.
    Например, в PrintStream и BufferedReader.                                                                                                                        *//**

    URL url = new URL("https://javarush.ru");
    URLConnection connection = url.openConnection();

     <!-- отправляем данные
    try (OutputStream output = connection.getOutputStream();
       PrintStream sender = new PrintStream(output))
    {
       sender.println("Привет");
    }

     <!-- читаем данные
    try(InputStream input = connection.getInputStream();
       BufferedReader reader = new BufferedReader(new InputStreamReader(input)))
    {
       while (reader.ready())
          System.out.println(reader.readLine());
    }                                                                                                                                                       *//*



                                          Примеры работы с сетью



    Код для сохранения рисунка на диске по указанному адресу в сети                                                                                                *//**

        <!-- получаем поток данных от интернет-ресурса
        String image = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        URL urlPictures = new URL(image);
        InputStream input = urlPictures.openStream();

        <!-- создаем имя файла, в который будем сохранять картинку.
        <!-- Имя может быть любым, однако расширение файла должно совпадать с расширением картинки в интернете
        Path path = Path.of("c:\\GoogleLogo.png");

        <!-- Этот метод принимает в качестве первого параметра источник данных — байтовый поток (InputStream),
        <!-- а в качестве второго параметра — имя файла, куда нужно записывать данные.
        Files.copy(input, path);                                                                                                                                    *//*


    Теоретически, если бы URL картинки был коротким, этот код вообще можно было бы записать в одну строку:                                                                      *//**

    <!-- Копирование данных из потока в файл
    Files.copy(
       new URL("https://www.google.com/logo.png").openStream(),
       Path.of("c:\\GoogleLogo.png")
    );                                                                                                                                                               *//*

    Писать так, конечно же, не нужно, однако этот пример демонстрирует,
    насколько удобные и мощные в Java потоки ввода-вывода.

























































 */




}
