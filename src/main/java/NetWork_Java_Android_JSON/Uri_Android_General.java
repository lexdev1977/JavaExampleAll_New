package NetWork_Java_Android_JSON;

public class Uri_Android_General {

/*

                                URI (Uniform Resource Identifier)

                                                                                                                                                                *//**
                                                    Uri
     <!--   .parse() - создает объект Uri, используя переданную ему строку,


                                                Uri.Builder

      Uri.Builder builder = new Uri.Builder();

     <!--   .buildUpon()  - начинает конструирование создавая объект  Uri.Builder для дальнейшего добавления

     <!--   .appendQueryParameter() - добавляет параметры // userID
     <!--   .appendEncodedPath()
     <!--   .appendPath
     <!--   .builder.scheme                               // "http", "https://api.vk.com"

     <!--   .build()  - заканчивает конструирование Uri                                                                                                                         *//*


    URI - это специальный идентификатор, по которому можно определить абстрактный или физический ресурс.
    Самый понятный пример с URI - это обычная веб-страница.
    Возьмём к примеру страницу http://developer.alexanderklimov.ru/android/catshop/catshop.php.
    Данный адрес можно разбить на несколько частей:

    Scheme - http
    Scheme - specific part - //developer.alexanderklimov.ru/android/catshop/catshop.php
    Path - /android/catshop/

    Универсальный идентификатор ресурса (URI) - это строка символов, используемая для идентификации ресурса.
    URI идентифицирует ресурс либо по местоположению, либо по имени, либо по обоим параметрам.
    Такая идентификация позволяет взаимодействовать с представлениями ресурса в сети, обычно во всемирной паутине,
    с использованием определенных протоколов.
    ex- URL - это URI. * Что такое Uri.parse () * он не выполняет «синтаксический анализ»,
    но фактически создает объект Uri, используя переданную ему строку, и эта строка скрыта от пользователя.
    Теперь вопрос в том, что делает объект Uri ?? Таким образом,
    объект URI - это неизменная ссылка на URI, которую мы можем использовать для ссылки на ресурсы.

    У объекта Intent имеет атрибут action. С помощью этого атрибута обычно дается указание действия.
    Например, просмотр или редактирование. Но действие обычно совершается не просто так, а с чем-либо.
    Значит кроме указания действия, мы должны указывать на объект, с которым эти действия нужно произвести.
    Для этого Intent имеет атрибут data.

    Один из способов присвоения значения этому атрибуту – метод setData (Uri data) у объекта Intent.
    На вход этому методу подается объект Uri.

    Uri – это объект, который берет строку, разбирает ее на составляющие и хранит в себе эту информацию.
    Строка, конечно, должна быть не любая, а составлена в соответствии с этим документом RFC 2396.
    Uri имеет кучу методов, которые позволяют извлекать из распарсенной строки отдельные элементы.

    Например возьмем такую строку - http адрес:

    Uri uri = Uri.parse("http://developer.android.com/reference/android/net/Uri.html");

    Смотрим, чего нам возвращают методы:

    uri.getScheme(): http
    uri.getSchemeSpecificPart(): //developer.android.com/reference/android/net/Uri.html
    uri.getAuthority(): developer.android.com
    uri.getHost(): developer.android.com
    uri.getPath(): /reference/android/net/Uri.html
    uri.getLastPathSegment(): Uri.html


    Понятия Scheme, Authority, Host, Path и пр. – взяты из RFC дока:

    https://disk.yandex.com/i/kv4B72Is7Tt2vQ - русская версия RFC 2396
    https://disk.yandex.com/i/2vwz7DDLpDeAHA - аншлийская версия RFC 2396

    Рассмотрим еще примеры:


    FTP

    Uri uri = Uri.parse("ftp://bob @ google.com:80/data/files");
    (Код, написанный выше, идет одной строкой на самом деле. Здесь идут пробелы вокруг @ из-за особенностей разметки)

    uri.getScheme(): ftp
    uri.getSchemeSpecificPart(): //bob@google.com:80/data/files
    uri.getAuthority(): bob@google.com:80
    uri.getHost(): google.com
    uri.getPort(): 80
    uri.getPath(): /data/files
    uri.getLastPathSegment(): files
    uri.getUserInfo(): bob


    Координаты

    Uri uri = Uri.parse("geo:55.754283,37.62002");
    uri.getScheme(): geo
    uri.getSchemeSpecificPart(): 55.754283,37.62002

    Здесь уже получилось выделить только Scheme и SchemeSpecificPart.



    Номер телефона

    Uri uri = Uri.parse("tel:12345");
    uri.getScheme(): tel
    uri.getSchemeSpecificPart():12345

    Аналогично, получилось выделить только две части из строки.


    Контакт из адресной книги

    Uri uri = Uri.parse("content://contacts/people/1");
    uri.getScheme(): content
    uri.getSchemeSpecificPart(): //contacts/people/1
    uri.getAuthority(): contacts
    uri.getPath(): /people/1
    uri.getLastPathSegment(): 1

    В этом примере Scheme равен content. Это особый тип данных – Content Provider.
    Он позволяет любой программе давать доступ к своим данным, а другим программам – читать и менять эти данные.
    Эту тему мы рассмотрим позднее, и сами будем создавать такой тип данных.



                                        Пример создания Uri

                                                                                                                                                               *//**
    public class NetworkUtils {    <!-- создание класса с методов который генерирует адрес в VK по ID

        private static final String VK_API_BASE_URL = "https://api.vk.com";  <!-- идет задание констант
        private static final String VK_USER_GET = "/method/users.get";
        private static final String PARAM_USER_ID = "user_ids";
        private static final String PARAM_VERSION = "v";


        public static URL generateURL (String userID){  <!-- создание метода для конструирования Uri, на входе userID
        Uri buildURI = Uri.parse(VK_API_BASE_URL + VK_USER_GET) <!-- передаем в аргументы

            .buildUpon() <!-- возвращает класс Uri.Builder что позволяет нам конструировать наш Uri дальше

            .appendQueryParameter(PARAM_USER_ID, userID)   <!-- добавление параметров с помощью данного метода
            .appendQueryParameter(PARAM_VERSION,"5.8")
            .build();                                      <!-- заканчиваем конструирование Uri

                URL url = null;         <!-- инициализируем и присваиваем значение null объекту URL
                try {
                    url = new URL(buildURI.toString());  <!-- передаем в качестве параметров созданный Uri
                                                         <!-- конвертируя объект в строку
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return url;
            }

        }

     Результат:
     <!--  https://api.vk.com/method/users.get?user_ids=123&v=5.8
                                                                                                                                                                    *//*

























 */

}
