package Android;

public class Android_Various_Settings {
/*



    Удаление строки заголовка проекта
    Перейдите в theme в styles.xml и измените его .DarkActionBar на .NoActionBar

    например:                                                                                                                               *//**
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    на
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">                                                                                          *//*



    Другой вариант для конкретного пректа, изменить строку в манифесте                                                                                                                                             *//**

    android:theme="@style/AppTheme" // AppTheme - название проекта
    на
    android:theme="@style/Theme.AppCompat.NoActionBar"                                                                                                       *//*


    программный способ скрытия                                                                                                                                       *//**
    ActionBar actionBar = getSupportActionBar();
        actionBar.hide();                                                                                                                                   *//*







 */


}
