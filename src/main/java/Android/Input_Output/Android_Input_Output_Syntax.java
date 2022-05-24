package Android.Input_Output;

public class Android_Input_Output_Syntax {

/*

                                        Примеры чтения и записи

    Пример с использованием InputStream
    (в примере) ресурс должен быть предварительно загружен в папку с ресурсами                                                              *//**

        String text = "";

        try {
            InputStream is = getAssets().open("nameFile.txt");  <!-- вариант создания из папки asset

<!--        InputStream is = this.getResources().openRawResource(R.raw.engdict);  вариант создание из res (raw ресурсов)

            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            dictionary = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
            tv_nameTextView.setText(text);                                                                                                                            *//*



        Второй пример чтения через InputStream и конвертирование через BufferedReader
        (в примере) ресурс должен быть предварительно загружен в папку с ресурсами
                                                                                                                                      *//**
        AssetManager am = this.getAssets();

            InputStream is = null;

            try {
                is = am.open("nameFile.txt");

                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String result = reader.lines().collect(Collectors.joining(System.lineSeparator()));

                is.close();
                tv_nameTextView.setText(result);


            } catch (IOException e) {
                e.printStackTrace();
            }                                                                                                                                                                *//*

    Метод Collectors.joining() может работать без указания разделителя, однако
    это может привести к неожиданным результатам, когда входные данные содержат новые строки.
    Установив разделитель в System.LineSeparator() , мы позволяем механизму базовой системы включаться для концов строк.


 */



}
