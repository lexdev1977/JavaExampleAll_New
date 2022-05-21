package Android.Components;

public class Android_ScrollView {
/*

    - атрибут android:scrollbars="none" - скрывает полосы прокрутки

    ScrollView  — служит для упаковки иерархии объектов View в контейнер, который можно прокручивать (скролить).

    Контейнер Scrollview представляет собой особый тип FrameLayout. Его особенность состоит в том,
    что он позволяет пользователям просматривать контент, который занимает больше места,
    чем физически есть на дисплее. Иными словами — просматривать контент, который не вмещается на экране без прокрутки.

    Scrollview может содержать только один дочерний элемент или контейнер ViewGroup

    - Никогда не используйте view-компонент ListView или GridView вместе со ScrollView.
      ListView предназначен для отображения списка элементов и оптимизирован для работы с большим объемом данных.
      Кроме того, он содержит встроенные возможности для прокрутки содержимого.
    - Контейнер Scrollview поддерживает только вертикальную прокрутку. Если Вы хотите добавить горизонтальную прокрутку,
      то нам понадобится другой наследник FrameLayout — контейнер HorizontalScrollView.
    - В xml разметке контейнер ScrollView имеет полезное свойство android:fillViewport, которое определяет,
      должен ли Scrollview растягивать свое содержание, чтобы заполнить доступное место на экране.
      Также доступен метод для установки этого значения в коде: setFillViewport(boolean).


                                Пример использования Scrollview в Android

    Первым делом создадим новый Android проект.

    Теперь создадим макет, в котором будет виджет ImageView с картинкой и два TextView: для заголовка и текста.
    Все это обернем в вертикальный LinearLayout и поместим в корневой ScrollView
    (помним, что Scrollview не может содержать больше одного дочернего элемента):

                                                                                                                        *//**
    <?xml version="1.0" encoding="utf-8"?>
    <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fillViewport="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="212dp"
                android:src="ВАША_КАРТИНКА" />

            <TextView
                android:layout_marginTop="15dp"
                android:layout_marginBottom="15dp"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="SharedPreferences в Android: сохраняем настройки"
                android:textAppearance="?android:attr/textAppearanceLarge" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="10dp"
                android:textAppearance="?android:attr/textAppearanceSmall"
                android:text="Вставьте здесь очень длинный текст, который должен будет прокручиваться" />
        </LinearLayout>
    </ScrollView>
                                                                                                                                                    *//*


                                                    Из другой статьи

                                             ScrollView и HorizontalScrollView

    При большом количестве информации, которую нужно поместить на экране приходится использовать полосы прокрутки.
    В Android существуют специальные компоненты ScrollView и HorizontalScrollView, которые являются контейнерными
    элементами и наследуются от ViewGroup. Обратите внимание, что класс TextView использует свою собственную прокрутку
    и не нуждается в добавлении отдельных полос прокрутки. Но использование отдельных полос даже с TextView
    может улучшить вид вашего приложения и повышает удобство работы для пользователя.

    На панели инструментов компоненты можно найти в разделе Containers.

    В контейнеры ScrollView и HorizontalScrollView можно размещать только один дочерний элемент (обычно LinearLayout),
    который в свою очередь может быть контейнером для других элементов. Виджет ScrollView, несмотря на свое название,
    поддерживает только вертикальную прокрутку, поэтому для создания вертикальной и горизонтальной прокрутки
    необходимо использовать ScrollView в сочетании с HorizontalScrollView. Обычно ScrollView используют
    в качестве корневого элемента, а HorizontalScrollView в качестве дочернего. Можно и наоборот, пробуйте.

    Можно вложить ImageView, чтобы просматривать большие картинки:
                                                                                                                                                *//**
        <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="vertical" >

        <TextView
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="@string/hello" />

        <HorizontalScrollView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">
            <ScrollView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">
                <ImageView
                    android:src="@drawable/bigpicture"
                    android:layout_height="wrap_content"
                    android:layout_width="wrap_content"
                    android:scaleType="center"/>
            </ScrollView>
     </HorizontalScrollView>
    </LinearLayout>                                                                                                                  *//*















 */





}
