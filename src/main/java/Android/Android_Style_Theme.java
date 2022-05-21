package Android;

public class Android_Style_Theme {
/*
                            Использование своих стилей в Андроид


    Платформа Android поддерживает создание новых пользовательских виджетов с использованием стилей.

    Стиль представляет собой набор свойств, которые определяют внешний вид и способы отображение виджета
    на устройствах с разными размерами экрана. С помощью стилей можно задавать такие свойства,
    как высота, отступы, цвет и размер шрифта, а также цвет фона и многое другое.
    В Android стили работают аналогично CSS (каскадные таблицы стилей), которые используются в веб-разработке.

    В Android стили представляют собой XML-файлы, которые размещаются в папке /res/values вашего андроид-проекта.
    В корне этого XML файла должен использоваться тег <resources> и вложенный в него тег <style>:                                        *//**

    <resources>

    <!-- Это стандартная тема созданного 'Hello world' проекта -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- используем тег item для задания цветов вашей темы -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    </resources>                                                                                                                            *//*

    Как видим из примера выше, этот тег содержит несколько тегов <item>, которые определяют цвета,
    которые будут использоваться в теме.

    Для применения своих стилей используется ключевое слово - style
                                                                                                                                                 *//**
        <TextView
        android:id="@+id/helloMessage"
        style="@style/myStyle"
        android:text="@string/hello_world" >
        </TextView>                                                                                                                         *//*

                                Создание стиля в Android

    XML-файл со стилями может быть создан один раз и быть использован в других макетах.
    Для этого нужно создать новый XML-файл и сохранить его в папке res/values/ вашего проекта.
    Как вы уже знаете, в корне файла должен быть тег <resources>.

    В одном файле style.xml могут быть определены сразу несколько стилей. Для каждого стиля,
    который вы хотите определить в файле style.xml, следует добавить тег <style> с уникальным идентификатором стиля.
    Затем добавьте тег <item> для каждого свойства этого стиля. Значением тега <item> может быть строка,
    шестнадцатеричный код цвета, ссылка на другой тип ресурса или другое значение в зависимости от свойства стиля.

    Пример:                                                                                                                                                          *//**

    <style name = "myStyle" >
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">120dp</item>
        <item name="android:textColor">#382063</item>
        <item name="android:typeface">serif</item>
        <item name="android:background">#f0f0f0</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textSize">24sp</item>
        <item name="android:gravity">center</item>
    </style>                                                                                                                                                    *//*


                                Применяем стиль к теме

    Тема — это стиль, который применяется к Activity или приложению в целом.

    Создание темы аналогично созданию стиля. Смотрим пример:                                                                                                *//**

    <style name="MyTheme" parent="android:Theme.Light">
        <item name="android:windowNoTitle">true</item>
        <item name="android:colorBackground">@color/default_bg</item>
    </style>                                                                                                                                                    *//*

    Обратите внимание, этот стиль переопределяет тему по умолчанию android:Theme.Light
    и переопределяет значение android:windowNoTitle.

    Чтобы установить эту тему для всех Activity вашего приложения, откройте файл AndroidManifest.xml
    и отредактируйте тег <application> добавив android:theme атрибут с названием стиля. Пример:


    <application
           android:theme="@style/MyTheme"
    ...
    >

    Если вы хотите применить тему только к одной активности вашего приложения,
    то просто добавьте атрибут android:theme в тег <activity>.



    !!! Если не изменяются цвета кнопок:
                                                                                                                                        *//**
    Замените  <!-- Theme.MaterialComponents.DayNight.DarkActionBar на Theme.AppCompat.DayNight.DarkActionBar
    в папках res -> values -> themes -> themes.xml.
    В android studio 4.1 по умолчанию тема уже применена к кнопкам.
    Затем вы можете просто сказать: android:background="@color/black", например.

                                                                                                                                                     *//*




 */


}
