package Android.Components;

public class Android_Font {

/*
                                           Для добавления шрифта

    - Правый клик по папке app/res вашего проекта и выберите New > Android resource directory.
    - Откройте выпадающее меню и выберите font.
    - Введите font в File name.
    - Нажмите OK.

    https://disk.yandex.com/i/0DQVUY5VP3BpZw

    - Переместите файлы вашего шрифта в новую папку res/font.

    Вы можете применить свой шрифт к тексту, используя новый XML атрибут android:fontFamily:

                                                                                                                                                                                *//**
    <TextView
      android:text="This is some text"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:fontFamily="@font/doublefeature"/>                                                                                                                                                *//*


      Вы можете добавить пользовательский шрифт к любым стилям, которые вы создали в приложении.
                                                                                                                                                                                    *//**
    <style name=“headlineFont" parent="@android:style/TextAppearance.Small">
       <item name="android:fontFamily">@font/doublefeature</item>
    </style>                                                                                                                                *//*


                                        Создание семейства шрифта

    Иногда при распаковке папки со шрифтом вы можете обнаружить несколько версий одного и того же шрифта,
    например, курсивную версию, или шрифты с различной толщиной.

    Если вы используете несколько версий одного и того же шрифта, вы можете сгруппировать их вместе в семейство шрифтов.
    Семейство шрифтов по существу является отдельным XML-файлом, в котором вы определяете каждую версию шрифта
    со всеми связанными с ним атрибутами стиля и веса.

    Чтобы создать семейство шрифтов:

    - Убедитесь, что вы добавили все файлы шрифта в папку res/font вашего проекта.
    - Щелкните правой кнопкой мыши по папке res/font вашего проекта и выберите New > Font resource file.
    - Дайте этому файлу имя и нажмите OK.
    - Откройте этот XML-файл и определите все различные версии этого шрифта, а также их атрибуты стиля и веса, например:
                                                                                                                                                                *//**
        <?xml version="1.0" encoding="utf-8"?>
    https://schemas.android.com/apk/res/android">
      <font
           android:fontStyle="normal"
           android:fontWeight="400"
           android:font="@font/doublefeature_regular" />

       <font
           android:fontStyle="italic"
           android:fontWeight="400"
           android:font="@font/doublefeature_italic" />

     <font
           android:fontStyle="bold"
           android:fontWeight="400"
           android:font="@font/doublefeature_bold" />

    </font-family>                                                                                                                                                                       *//*

    Затем вы можете ссылаться на любой из шрифтов в этом семействе, используя атрибут android:fontFamily.
    Например:
                                                                                                                                                *//**
    android:fontFamily="@font/doublefeature_bold"                                                                                                                       *//*












 */

}
