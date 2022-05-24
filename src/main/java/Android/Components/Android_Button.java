package Android.Components;

public class Android_Button {
/*

                                        Практическое применение



                                            Параметры Button:


    Установки в XML:
    - android:id="@+id/playButton" -                задание id кнопки
    - android:text="Button" -                       текст на кнопке, лучше использовать переменные @string/button_text
    - style="@style/myStyle" -                      присвоение стиля
    - android:layout_width="match_parent" -         ширина
    - android:layout_height="match_parent" -        высота
    - android:layout_gravity="center" -             выравнивание (использовать в Layout)
    - android:gravity="center" -                    выравнивание текста внутри кнопки
    - android:background="@drawable/rounded_button" использование вектора вместо фона
    - android:layout_margin="10dp" -                задает внешние отступы для объекта
    - android:textColor="@color/white" -            цвет текста
    - android:backgroundTint="@color/purple_500" -  цвет кнопки



                                         Программная установка:

    * создание и добавление кнопки в Layout

    - Button button01 = new Button(this);         - создаем новый компонент кнопку

    - LinearLayout layout01 = findViewById(R.id.nameLayout); -  создаем новый компонент LinearLayout(например)
      для данной реализации готовый Layout должен иметь ID

    - layout01.addView(button01); - добавляем созданную кнопку в готовый Layout
                                    если нужно изменить параметры читать далее ->




               задача и настройка параметров кнопки может происходить сразу после ее создания

    - button01.setVisibility(View.GONE); -                       убирает кнопку
    - button01.setVisibility(View.INVISIBLE); -                  делает кнопку невидимой
    - button01.setBackgroundResource(R.drawable.roundbutton); -  подключения вектора из drawable
    - button01.setTextColor(0xFFFFFFFF); -                       установка цвета текста
    - button01.setText("Button"); -                              задание текста на кнопке
    - button01.setId(R.string.stringName) -                      установка ID


                                        программное изменение параметров

    Для изменения некоторых параметров, таких как размер, отступы и т.п., для начала нужно создать
    один из компонентов таких как - LinearLayout, ViewGroup с вызовом .LayoutParams
    у каждого компонента свой определенный набор параметров

    пример, задаем сразу параметры ширины и высоты для LinearLayout:

    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT);

                или

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams (800 , 200);

    после создания объекта с параметрами вызываем методы для разных настроек

    layoutParams.setMargins(10,20,10,20);  - создаем внешние отступы со всех сторон
    layoutParams.gravity = Gravity.CENTER; - выравнивание объектов по центру

    и наконец при добавлении нового компонента указываем в качестве параметра созданный нами layoutParams

    layout01.addView(button01, layoutParams);





                                                                                                                             *//*



















 */




}
