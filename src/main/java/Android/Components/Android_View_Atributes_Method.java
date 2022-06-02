package Android.Components;

public class Android_View_Atributes_Method {

/*
  Выписка по атрибутам и методам компонента View и его наследников

                                                Атрибуты

    <EditText

        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginRight="10dp"       // отступ справа
        android:hint="@string/hintText"         // текст подсказки

                />


    <LinearLayout

            android:id="@+id/nameView"
            android:layout_width="match_parent"
            android:layout_height="80dp"
            android:background="#9C27B0"
            android:orientation="horizontal"
            android:gravity="center_vertical"

            >

    <androidx.cardview.widget.CardView          // создание карточки
                android:layout_width="200dp"
                android:layout_height="200dp"
                app:cardCornerRadius="20dp"
                app:cardBackgroundColor="#673AB7">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">


            <TextView
               android:id="@+id/info_text"
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="Test CardView"
               android:layout_centerInParent="true"
               android:textSize="18sp"
               android:textColor="#fff"/>
            </RelativeLayout>

    </androidx.cardview.widget.CardView>



                                                        Методы

    - .getText().toString() - взять содержимое View и конвертировать в текст

    - .setText() - установить текст во View

    - .setVisibility(View.VISIBLE); [View.VISIBLE || View.INVISIBLE) || View.GONE] - видимость View




 */

}
