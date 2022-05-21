package Android.Components;

public class Android_TextView {

/*

                                            TextView

    Компонент TextView предназначен для отображения текста без возможности редактирования его пользователем

    - Для отображения текста в TextView в файле разметки используется атрибут android:text
                                                                                                                   *//**
    android:text="Погладь кота, ...!"   (xml)


                                                                                                                    *//*
    Такой подход является нежелательным. Рекомендуется всегда использовать текстовые ресурсы.
    Текстовые переменные хранятся в res/values/strings.xml для добавления новой переменной следующий синтаксис:
                                                                                                                   *//**
    <string name="название переменной">Текст(значение) переменной</string>
                                                                                                                    *//*
    В будущем эта привычка позволит вам обеспечить многоязыковую поддержку:
                                                                                                                   *//**
    android:text="@string/stringName"  (xml)
                                                                                                                    *//*



                        Программно текст можно задать методом setText():
                                                                                                                                        *//**
    android:id="@+id/resNameTV"  (xml) - задаем имя для TextView в в файле разметки

                                                                                                                                        *//*
     !!! Для вызова методов не забыть инициализировать компонент

    Инициализируем компонент                                                                                                         *//**
    private TextView mainNameTV   (main)         - объявляем компонент типа TextView
    mainNameTV = findViewById(R.id.resNameTV);   - инициализируем компонент
                                                                                                                                        *//*
    или сразу инициализируем и проводим связку                                                                                          *//**
    TextView mainNameTV = findViewById(R.id.resNameTV);   (main)
                                                                                                                                        *//*

    // задаём текст                                                                                                                     *//**
    mainNameTV.setText("Hello Kitty!");
                                                                                                                                        *//*

    // или с использованием текстовых ресурсов                                                                                          *//**
    mainNameTV.setText(R.string.stringName);
                                                                                                                                        *//*


                                            Атрибуты

    - android:textsize      размер текста. При установке размера текста используется несколько единиц измерения:
                       px (пиксели), dp, sp, in (дюймы), pt, mm. Для текстов рекомендуется использовать sp:
                       android:textSize="48sp", аналог - метод setTextSize()
    - android:textstyle     стиль текста. Используются константы: normal, bold, italic.
                            Например, android:textStyle="bold" выводит текст жирным
    - android:textcolor     цвет текста. Используются четыре формата в шестнадцатеричной кодировке:
                            #RGB; #ARGB; #RRGGBB; #AARRGGBB, где R, G, B — соответствующий цвет,
                            А — прозрачность (alpha-канал). Значение А, установленное в 0, означает прозрачность 100%.
                                                                                                                                        *//**
    android:textSize="40sp"
    android:textStyle="bold"
    android:textColor="@color/colorName"    например в colors.xml - <color name="purple_500">#FF6200EE</color>
                                                                                                                                        *//*
    Для всех вышеперечисленных атрибутов в классе TextView есть соответствующие методы для чтения
    или задания соответствующих свойств.


                                        Варианты установка цвета
                                                                                                                                     *//**
    textView.setTextColor(Color.parseColor("#FF03DAC5"));
    textView.setTextColor(0x30018786);
    textView.setTextColor(Color.rgb(200,0,0));
    textView.setTextColor(Color.argb(255,200,0,0)); - в RGB с альфа каналом (0 - прозрачность 100%, 255 - непрозрачный)

                                                                                                                                     *//*
                                       Установка цвета из ресурсов

    !!! Для получения цвета из ресурсов применяется метод resources.getColor(),
    который принимает два параметра:
    Первый параметр - идентификатор ресурса, цвет которого надо получить.
    Второй параметр представляет тему. Но поскольку в данном случае тема не важна,
    для этого параметра передаем значение null                                                                                          *//**

    textView.setTextColor(getResources().getColor(R.color.myColor, null)); - новый вариант
                                                                                                                                    *//*
    Следует учитывать, что метод resources.getColor() с двумя параметрами, который использован выше,
    доступен, если для минимальная версия Android не ниже Android 6.0 (или Android 23).
    Однако минимальная версия Android ниже, то можно использовать устаревшую версию с одним параметром:
                                                                                                                                         *//**
    textView.setTextColor(getResources().getColor(R.color.myColor));  -  устарел


                                                                                                                                   *//*
    Программно установим размеры текста при помощи setTextSize() с различными единицами измерения.

                                                                                                                                        *//**
    // 20 DIP (Device Independent Pixels)
    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

    // 0.5 inch
    textView.setTextSize(TypedValue.COMPLEX_UNIT_IN, 0.5f);

    // 10 millimeter
    textView.setTextSize(TypedValue.COMPLEX_UNIT_MM, 10);

    // 30 points
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 30);

    // 30 raw pixels
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 30);

    // 30 scaled pixels
    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

                                                                                                                                        *//*
    По умолчанию у компонентов TextView отсутствует фоновый цвет. Чтобы задать цвет, укажите значение Drawable
    для атрибута android:background. В качестве значения Drawable может использоваться изображение
    или XML-представление фигуры, включающий ресурс Drawable (поместить в папку res/drawable).


                                        Программная установка фона

    В некоторых случаях программисты из-за невнимательности неправильно меняют фон элемента программным способом
    и удивляются, почему ничего не работает.

    Предположим, у вас определён в ресурсах зелёный цвет:
                                                                                                                                                 *//**
    <color name="tvBackground">#337700</color>
                                                                                                                                                *//*
    Следующий код будет ошибочным:
                                                                                                                                          *//**
    textview.setBackgroundColor(R.color.tvBackground); // не работает

                                                                                                                                                    *//*
     Нужно так (два варианта):
                                                                                                                                  *//**
    textView.setBackgroundResource(R.color.tvBackground); // первый вариант
    textView.setBackgroundColor(getResources().getColor(R.color.tvBackground)); // второй вариант                                               *//*


                                        Реагируем на событие onClick

    Если вы хотите, чтобы TextView обрабатывал нажатия (атрибут android:onClick),
    то не забывайте также использовать в связке атрибут android:clickable="true".
    Иначе работать не будет!


                                            Многострочный текст

    Если вы хотите создать многострочный текст в TextView, то используйте символы \n для переноса строк.

    Например, в ресурсах:                                                                                                                   *//**

    <string name="about_text">
        У лукоморья дуб зелёный;\n
        Златая цепь на дубе том:\n
        И днём и ночью <b>кот учёный</b>\n
        Всё ходит по цепи кругом;\n
        Идёт <b>направо</b> - песнь заводит,\n
        <b>Налево</b> - сказку говорит.</string>                                                                                                    *//*

                            Также перенос на новую строку можно задать в коде:
                                                                                                                                        *//**
    textView.setText("Первая строка \nВторая строка \nТретья строка");                                                                                *//*



                                Увеличиваем интервалы между строками

    Вы можете управлять интервалом между соседними строчками текста через атрибут
    android:lineSpacingMultiplier, который является множителем.
    Установите дробное значение меньше единицы, чтобы сократить интервал или больше единицы,
    чтобы увеличить интервал между строками.                                                                                         *//**

    android:lineSpacingMultiplier="0.8"    (xml)
    textView.setLineSpacing(200, 0);                                                                                                           *//*

    пример - https://disk.yandex.com/i/ifM-AJ9iUhxHGA - скачать и запустить



                                            Тень

    Чтобы оживить текст, можно дополнительно задействовать атрибуты для создания эффектов тени:
    shadowColor, shadowDx, shadowDy и shadowRadius. С их помощью вы можете установить цвет тени и ее смещение.
    Во время установки значений вы не увидите изменений, необходимо запустить пример в эмуляторе или на устройстве.
    В следующем примере создана тень красного цвета со смещением в 2 пикселя по вертикали и горизонтали.
    Учтите, что для смещения используются единицы px (пиксели), единицы dp не поддерживаются.

    <TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:padding="12dp"
    android:text="Любой текст"
    android:textSize="80sp"
    android:textStyle="bold"
    android:shadowColor="#ff0000"
    android:shadowDx="2"
    android:shadowDy="2"
    android:shadowRadius="5"/>                                                                                                          *//**


    TextView textShadow = (TextView)findViewById(R.id.hello);
    textShadow.setShadowLayer(
        5f,   //float radius
        10f,  //float dx
        10f,  //float dy
        0xFFFFFFFF //int color
    );                                                                                                                                      *//*

    или                                                                                                                                   *//**

   TextView mainNameTV = findViewById(R.id.resNameTV);
   mainNameTV.setShadowLayer(20f,10f, 10f, 0xFFFFFFFF);                                                                                                                  *//*


                                    Создание ссылок автоматом

    У TextView есть ещё два интересных свойства Auto link (атрибут autoLink) и Links clickable (атрибут linksClickable),
    которые позволяют автоматически создавать ссылки из текста.

    Выглядит это следующим образом. Предположим, мы присвоим элементу TextView сайт:
    yandex.ru и применим к нему указанные свойства.                                                                                             *//**


    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:autoLink="web"
        android:linksClickable="true"
        android:text="Поисковик: yandex.ru" />                                                                                                                      *//*

        При этом уже на этапе разработки вы увидите, что строка адреса сайта после слов Поисковик: стала ссылкой.
        Если вы запустите приложение и нажмете на ссылку, то откроется браузер с указанным адресом.
        Вам даже не придется писать дополнительный код. Аналогично, если указать номер телефона (параметр phone),
        то запустится звонилка.

    Цвет ссылки можно поменять через свойство Text color link (XML-атрибут textColorLink),
    а программно через метод setTextLinkColor().

    Программно можно установить ссылки на текст через класс Linkify:                                                                            *//**


    TextView tvDisplay = (TextView)findViewById(R.id.tvDisplay);

    String data = "" +
            "Пример использования Linkify для создания ссылок в тексте.\n" +
            "\n" +
            "URL: http://что-то.ru/ \n" +
            "Email: lex@yandex.com \n" +
            "Телефон: (000)-00-00-00 \n" +
            "Адрес: 7200053, г. Бишкек, ул. Горького";

            if(tvDisplay != null) {
                tvDisplay.setText(data);
                Linkify.addLinks(tvDisplay, Linkify.ALL);
            }                                                                                                                                   *//*

    Кроме константы ALL, можно также использовать Linkify.EMAIL_ADDRESSES, Linkify.MAP_ADDRESSES, Linkify.PHONE_NUMBERS.
    К сожалению, русские адреса не распознаются. В данном случае индекс был распознан как телефонный номер,
    а город и улица не стали ссылкой.

    В таких случаях придётся самостоятельно добавить ссылки в текстах. Например, определим ссылку в ресурсе:

    <string name="my_site"><a href="http://адрес сайта.ru/android">Какой-то сайт</a></string>

    Присвоим созданный ресурс тексту в TextView и запустим пример. Сам текст будет выглядеть как ссылка,
    но реагировать не будет. Чтобы исправить данную проблему, добавим код:                                                              *//**


    TextView textView = (TextView) findViewById(R.id.textView);
    textView.setMovementMethod(LinkMovementMethod.getInstance());                                                                                    *//*



                            Используйте полупрозрачность с умом

    Если вам нужно установить текст полупрозрачным, то не используйте атрибут android:alpha:                                         *//**


    <TextView
        android:textColor="#fff"
        android:alpha="0.5" />                                                                                                                   *//*

    Дело в том, что такой подход затрачивает много ресурсов при перерисовке.

    Атрибут textColor позволяет установить полупрозрачность без потери производительности:                                                                                               *//**


    <TextView
        android:textColor="80FFFFFF" />                                                                                                                           *//*



                                    Выделить текст для копирования

    По умолчанию, текст в TextView нельзя выделить для копирования. Но в API 11 появилась такая возможность,
    которая может пригодиться. Делается либо при помощи
    - XML-атрибута android:textIsSelectable="true"
    - либо через метод setTextIsSelectable().

    Добавьте в разметку два компонента TextView и одно текстовое поле EditText для вставки скопированного текста.
    У первой текстовой метки установим возможность выделения текста декларативно.                                                            *//**


    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Выдели слово Кот для проверки"
        android:textIsSelectable="true"
        android:textSize="26sp"/>                                                                                                                                            *//*



    Для второго компонента возможность выделения создадим программно.                                                                                                     *//**

    TextView secondTextView = (TextView) findViewById(R.id.textView2);
    secondTextView.setTextIsSelectable(true);                                                                                                                            *//*

    Сделайте долгий тап на тексте в любом TextView. Увидите стандартные ползунки для выбора длины текста.
    Скопируйте текст, сделайте длинный тап в EditText и вставьте текст.



                                             Стили

    Выводим разделитель под текстом.                                                                                                                                                                                                 *//**


    <TextView
        style="?android:listSeparatorTextViewStyle"
        ...
    android:text="Заголовок"/>   *//*


    Дополнительные функции и настройки:

    - textView.setLetterSpacing(0.2F)    (main)    расстояние между буквами


    - android:lines="3"                 // Данный код огранит количество строк до 3 и поставит многоточие
    - android:ellipsize="end"           // в конце если текст не влезает на экран

    - android:textAllCaps: при значении true делает все символы в тексте заглавными

    - android:textDirection: устанавливает направление текста. По умолчанию используется направление слева направо,
      но с помощью значения rtl можно установить направление справо налево

    - android:textAlignment: задает выравнивание текста. Может принимать следующие значения:

        center: выравнивание по центру

        textStart: по левому краю

        textEnd: по правому краю

        viewStart: при направлении текста слева направо выравнивание по левому краю,
        при направлении справа налево - по правому

        viewEnd: при направлении текста слева направо выравнивание по правому краю,
        при направлении справа налево - по левому

      - android:fontFamily: устанавливает тип шрифта. Может принимать следующие значения:

            monospace

            serif

            serif-monospace

            sans-serif

            sans-serif-condensed

            sans-serif-smallcaps

            sans-serif-light

            casual

            cursive

            cursive


                                Пример программной установки:                                                                                               *//**

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.constraintlayout.widget.ConstraintLayout;

    import android.graphics.Typeface;
    import android.os.Bundle;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            ConstraintLayout constraintLayout = new ConstraintLayout(this);
            TextView textView = new TextView(this);
            // установка фонового цвета
            textView.setBackgroundColor(0xffe8eaf6);
            // установка цвета текста
            textView.setTextColor(0xff5c6bc0);
            // делаем все буквы заглавными
            textView.setAllCaps(true);
            // устанавливаем вравнивание текста по центру
            textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            // устанавливаем текста
            textView.setText("Hello Android!");
            // установка шрифта
            textView.setTypeface(Typeface.create("casual", Typeface.NORMAL));
            // устанавливаем высоту текста
            textView.setTextSize(26);

            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
                    (ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            textView.setLayoutParams(layoutParams);

            constraintLayout.addView(textView);
            setContentView(constraintLayout);
        }

                                                                                                                                                                                            *//*
    Иногда необходимо вывести на экран какую-нибудь ссылку, либо телефон,
    по нажатию на которые производилось бы определенное действие.
    Для этого в TextView определен атрибут android:autoLink:                                                             *//**


    <TextView
        android:text="Посетите сайт https://metanit.com"
        android:textSize="21sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:autoLink="web|email"

        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>                                                                             *//*

    android:autoLink может принимать несколько значений:

    none: отключает все ссылки

    web: включает все веб-ссылки

    email: включает ссылки на электронные адреса

    phone: включает ссылки на номера телефонов

    map: включает ссылки на карту

    all: включает все вышеперечисленные ссылки

    То есть при настройке android:autoLink="web" если в тексте есть упоминание адреса url,
    то этот адрес будет выделяться, а при нажатии на него будет осуществлен переход к веб-браузеру,
    который откроет страницу по этому адресу. С помощью прямой черты мы можем объединять условия,
    как в данном случае: android:autoLink="web|email"







 */





}
