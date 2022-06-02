package NetWork_Java_Android_JSON;

public class Android_JSON_Syntaz {

/*

    Android поддерживает готовые библиотеки для работы с JSON, вам не нужно объявлять никакую другую библиотеку.

    В Android и вообще во всех средах существует два типа операций:

    - Преобразовать Java-класс в данные JSON (Сериализация)
    - Разбор данных JSON и создание классов Java (Десериализация)


                                              Десериализация
                                                                                                                                      *//**
     JSONObject jsonObj = new JSONObject(dataJson);                 <!-- создание нового объекта  JSON
                                                                    <!-- помещаем в атрибуты строку в виде JSON

     JSONArray jsonArray = jsonObj.getJSONArray("dataJson");        <!-- помещаем в массив JSON
                                                                    <!-- массив прочитанный из объекта в виде JSON

     JSONObject jsonUserInfo = jsonArray.getJSONObject(0);          <!-- помещаем в  JSON объект
                                                                    <!-- из массива JSON объект под индексом 0

     firstName = jsonUserInfo.getString("first_name");              <!-- запись в переменную типа String
     lastName = jsonUserInfo.getString("last_name");                <!-- данных из объекта JSON в соответствии с именем


     <!-- вариант цикла для чтения массива и добавления в строку
     String result = "";
     for i = 0; i < jsonArray.length(); i++){
     JSONObject jsonUserInfo = jsonArray.getJSONObject(i)

     firstName = jsonUserInfo.getString("first_name");
     lastName = jsonUserInfo.getString("last_name");

     result += "Имя: " +  firstName + "\n" + "Фамилия:" + lastName + "\n\n";


     }





                                                                                                                                                                                 *//*
                                               Сериализация                                                                                                             *//**

     JSONObject jsonObj = new JSONObject();          <!-- создание нового объекта  JSON без передачи аргумента

     jsonObj.put("name", person.getName());          <!-- помещаем пару имя / значение


     jsonObj.put("address", jsonAnother);            <!--  помещаем пару имя /  другой JSON объект в виде значения


     JSONArray jsonArr = new JSONArray();            <!-- создаем новый массив в формате JSON

     jsonObj.put("phoneNumber", jsonArr);            <!-- помещаем пару имя / значение в формате JSON массив



     for (PhoneNumber pn : person.getPhoneList() ) { <!-- помещаем массив в объект JSON
     JSONObject pnObj = new JSONObject();
     pnObj.put("num", pn.getNumber());
     pnObj.put("type", pn.getType());
     jsonArr.put(pnObj);
     }

     jsonObj.toString();                             <!-- перевод JSON объекта в строковое представление


                                                                                                                                                                            *//*
                                                    Данные в JSON:                                                                                               *//**
     {
     "phoneNumber": [
     {
     "type": "work",
     "num": "11111"
     },
     {
     "type": "home",
     "num": "2222"
     }
     ],
     "address": {
     "state": "World",
     "address": "infinite space, 000",
     "city": "Android city"
     },
     "surname": "Swa",
     "name": "Android"
     }                                                                                                                                                                          *//*

    Еще один интересный аспект – анализ данных JSON и создание классов Java.
    Даже если существуют автоматические инструменты, которые создают классы POJO из данных JSON, важно знать,
    что стоит за ними. Когда у вас есть данные JSON, первым шагом является создание анализатора,
    который помогает получить значения внутри JSON.


    JSONObject jObj = new JSONObject(data);

    где данные содержат строку JSON. Теперь, глядя на файл данных JSON,
    мы можем начать извлечение данных. Например, если мы предполагаем, что мы получаем данные JSON,
    подобные показанным выше (см. Данные JSON Person), и мы хотим получить фамилию:
                                                                                                                                                                *//**
    String surname = jObj.getString("surname");                                                                                                                     *//*


    Когда мы хотим получить адрес объекта, мы можем использовать:
                                                                                                                                                            *//**
    JSONObject subObj = jObj.getJSONObject("address");
    String city = subObj.getString("city");
    ...                                                                                                                                                     *//*


    Если мы хотим получить список телефонных номеров, мы просто имеем:
                                                                                                                                                                    *//**
    JSONArray jArr = jObj.getJSONArray("list");
    for (int i=0; i < jArr.length(); i++) {
        JSONObject obj = jArr.getJSONObject(i);
        ....
    }                                                                                                                                                                       *//*







 */






}
