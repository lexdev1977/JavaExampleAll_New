package Android.Multithreading;

public class Android_Multithreading_AsyncTask_Loaders {
/*

    При создании мобильного приложения чуть сложнее «Hello, world» почти наверняка требуется скачать
    что-то из Сети или считать файл с диска. Для стабильной работы программы в целом эти действия должны
    совершаться в отдельных потоках.


                                            Процессы и потоки

    Прежде чем разбираться с Android API, вспомним, какой структурой обладает эта ОС.
    В ее основе лежит Linux-ядро, в котором реализованы базовые механизмы, присущие всем *nix-системам.
    В ядре собраны модули, предназначенные для низкоуровневой работы: взаимодействия с железом, организации памяти,
    файловой системы и так далее.

    В мире Linux каждая запущенная программа — это отдельный процесс. Каждый процесс обладает уникальным номером
    и собственной «территорией» — виртуальным адресным пространством, в рамках которого содержатся все данные процесса.
    Поток же — это набор инструкций внутри запущенной программы (процесса), который может быть выполнен отдельно.
    У потока нет своего уникального идентификатора и адресного пространства — все это он наследует
    от родительского процесса и делит с другими потоками.

    Такое положение дел приводит к тому, что со стороны неизвестно, как протекает жизнь внутри процесса,
    есть ли там потоки и сколько их, — для ОС и других процессов это атомарная структура с уникальным идентификатором.
    Поэтому ОС может манипулировать лишь процессом, а управляет потоками только породивший их процесс.

    Когда в компьютерах (а вслед за ними — в планшетах и телефонах) появились процессоры с несколькими ядрами,
    программисты внедрили в ОС планировщик задач. Такой планировщик самостоятельно распределяет нагрузку
    по всем ядрам процессора, исполняя блоки кода параллельно или асинхронно, и тем самым повышает производительность.

    В Android программист обязан повсеместно создавать новые потоки и процессы.
    Все операции, которые могут продлиться более нескольких секунд, должны обязательно выполняться в отдельных потоках.
    Иначе начнутся задержки в отрисовке интерфейса и пользователю будет казаться, что приложение «зависает».

    Вообще, суть многопоточного программирования в том, чтобы максимально задействовать все ресурсы устройства,
    при этом синхронизируя результаты вычислений. Это не так легко, как может показаться на первый взгляд,
    но создатели Android добавили в API несколько полезных классов, которые сильно упростили жизнь Java-разработчику.



                                           Потоки в Android

    Запущенное в Android приложение имеет собственный процесс и как минимум один поток —
    так называемый главный поток (main thread). Если в приложении есть какие-либо визуальные элементы,
    то в этом потоке запускается объект класса Activity, отвечающий за отрисовку
    на дисплее интерфейса (user interface, UI).

    В главном Activity должно быть как можно меньше вычислений, единственная его задача — отображать UI.
    Если главный поток будет занят подсчетом числа пи, то он потеряет связь с пользователем — пока число не досчиталось,
    Activity не сможет обрабатывать запросы пользователя и со стороны будет казаться, что приложение зависло.
    Если ожидание продлится чуть больше пары секунд, ОС Android это заметит
    и пользователь увидит сообщение ANR (application not responding — «приложение не отвечает»)
    с предложением принудительно завершить приложение.


                                                Looper

    Было бы классно уметь перекидывать данные из одного потока в другой.
    В Android, как и любой Linux-системе, это возможно. Один из доступных в Android способов — это создать
    очередь сообщений (MessageQueue) внутри потока. В такую очередь можно добавлять задания из других потоков,
    заданиями могут быть переменные, объекты или кусок кода для исполнения (Runnable).

    Message msg = new Message();
    Bundle mBundle = new Bundle();
    mBundle.putString("KEY", "textMessage");
    msg.setData(mBundle);

    Чтобы организовать очередь, нужно воспользоваться классами Handler и Looper:
    первый отвечает за организацию очереди, а второй в бесконечном цикле проверяет, нет ли в ней новых задач для потока.

                                                                                                                                                                                                                                          *//**
    public class MyLooper extends Thread {
      Integer number;
      public Handler mHandler;
      @Override
      public void run() {
        Looper.prepare();
        mHandler = new Handler() {
          @Override
          public void handleMessage(Message msg) {
            // process incoming messages here
            Log.e("Thread", "#"+number + ": "+msg.getData().getString("KEY"));
          }
        };
        Looper.loop();
      }
    }                                                                                                                                                                   *//*

    Запуск такого потока устроен по похожей схеме — создание нового объекта и вызов метода start.                                                            *//**

    MyLooper myLooper = new MyLooper();
    myLooper.start();

                                                                                                                                *//*
    После выполнения этого метода создастся новый поток, который заживет своей жизнью.
    А это значит, что инициализация переменных и создание объектов будут уже идти параллельно с теми вызовами,
    которые забиты в следующих строчках после команды myLooper.start(). Поэтому перед обращением к очереди
    в новом потоке нужно немного подождать — объект handler может еще не существовать.                                                                                  *//**

    If (myLooper.hanlder!=null) {
      myLooper.mHandler.sendMessage(msg);
    }                                                                                                                                                                                    *//*


                                            AsyncTask

    Загружая или вычисляя что-то в фоне, хорошо бы не только получить результаты, но еще и иметь возможность
    выводить пользователю информацию о прогрессе. Конечно, все это можно сделать самому с помощью очереди сообщений,
    но разработчики Android и тут упростили нам жизнь, создав класс AsyncTask.

    Класс AsyncTask — это представитель Java-обобщений (generic) в мире Android.
    У классов-обобщений заранее не определен тип данных, с которыми им предстоит работать.
    Этот прием позволяет создать класс, который в последующем сможет без проблем работать с любым типом данных.
    В данном случае благодаря дженерику AsyncTask возможно запускать новые потоки
    с совершенно произвольными объектами внутри.

    C помощью AsyncTask теперь можно почти не думать (о вероятных последствиях позже) о создании потока,
    а просто создать объект и обрабатывать результаты. К примеру, с помощью AsyncTask удобно
    преобразовывать файлы (например, их зашифровать), при этом сам метод шифрования modifyFile
    может быть объявлен в Activity главного потока.                                                                                                     *//**

    private class FileCryptor extends AsyncTask<URL, Integer, String> {
    protected String doInBackground(URL... urls) {
      int count = urls.length;
      long totalSize = 0;
      for (int i = 0; i < count; i++) {
        totalSize += modifyFile(urls[i]);
        publishProgress((int) ((i / (float) count) * 100));
        // Escape early if cancel() is called
        if (isCancelled()) break;
      }
      return totalSize;
    }                                                                                                                                                                   *//*

    Помимо doInBackground, порождающего новый поток, в AsynkTask есть методы,
    которые будут выполняться уже в главном потоке.                                                                                                                                                                                          *//**

    protected void onProgressUpdate(Integer... progress) {
      setProgress(progress[0]);
    }
    protected void onPostExecute(Long result) {
      showDialog("Downloaded " + result + " bytes");
    }                                                                                                                                   *//*

    Для запуска нового потока достаточно одной строчки в Activity:                                                                       *//**

    new FileCryptor().execute(url);                                                                                                     *//*

    С появлением AsyncTask разработчики обрели практически универсальный инструмент,
    позволяющий в короткие сроки написать код, генерирующий новые потоки, а потом так же быстро получить в UI
    результаты вычислений, отслеживая при этом прогресс. Но у этого класса есть несколько неприятных моментов,
    которые могут сделать приложение совершенно нестабильным.


    Сложность с отменой

    Для отмены вычислений существует метод cancel(boolean), который в идеале должен остановить поток
    и высвободить ресурсы. Но этого не происходит. В случае если он вызван с аргументом false,
    вычисления будут продолжены, только их результат не будет возвращен в UI.
    Вызов cancel(true) лишь частично поможет решить проблему, поскольку существуют методы,
    которые из-за механизма синхронизации прервать нельзя, — к примеру,
    получение изображения с помощью BitmapFactory.decodeStream().


    Утечка памяти

    А это самый неприятный недостаток AsyncTask, который напрямую следует из предыдущего пункта.
    После запуска нового Activity прошлый экземпляр UI должен быть выгружен из памяти сборщиком мусора.
    Но этого не произойдет, поскольку на «старый» UI есть ссылка в работающем потоке, созданном AsyncTask.
    Ничего не поделать, придется создавать еще один поток и запускать все вычисления в нем по новой.
    Но есть риск, что пользователь опять повернет экран! При такой организации рабочего процесса
    вся выделенная память потратится на содержание ненужных Activity и дополнительных потоков,
    и ОС принудительно завершит приложение с ошибкой OutOfMemoryException.

    Что же делать?
    Сделать экземпляр AsyncTask статическим и использовать слабые связи (WeakReference).
    При таком подходе в приложении не будут генериться лишние потоки, а слабая связность позволит сборщику мусора
    выгрузить ненужные Activity из памяти.


                                            WeakReference

    Немного о связях в Java. Создавая новый объект и ассоциируя его с переменной, мы создаем ссылку между ними. Привычное создание объекта сопровождается созданием сильной (strong) ссылки.

    SimpleClass sObj = new SimpleClass();
    В Java нет принудительного уничтожения объектов, этим занимается сборщик мусора.
    Пока сильная ссылка существует, объект будет висеть в памяти.
    Разрушить такую ссылку можно только вручную, приравняв переменную sObj к null.
    Если же объект связан только слабыми ссылками (WeakReference),
    то сборщик мусора при первой же возможности выгрузит его из памяти.                                                          *//**

    private class myTask extends AsyncTask<String, Void, Bitmap> {
        WeakReference<ImageView> wImage;
        myTask(ImageView imageView) {
          wImage = new WeakReference<ImageView>(imageView);
    }
                                                                                                                                                        *//*
    В работающей программе неизвестно, в какой момент начнет свой очередной проход сборщик мусора.
    Поэтому лучше перестраховаться и каждый раз получать доступ к объекту по слабой ссылке.                                                                 *//**

        protected void onPostExecute(Bitmap bitmap) {
      final ImageView imageView = wImage.get();
      if (imageView != null) {
        imageView.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
      }
      ...
    }                                                                                                                                                           *//*


                                              Loaders

    Схема работы загрузчиков - https://disk.yandex.com/i/RLDZ1F4mKclM3Q

    Пожалуй, основная задача 90% всех мобильных приложений вообще
    — это быстро и незаметно для пользователя загрузить данные из сети или файловой системы,
    а затем красиво отобразить их на дисплее. Для всего этого отлично подходит AsyncTask,
    но его проблемы не только неочевидны для неопытных разработчиков, но и плохо детектируются в процессе отладки.

    Массовое распространение в Google Play приложений, имеющих проблемы с утечкой памяти,
    резонно вызовет у пользователей ощущение, что «Android тормозит».
    Компания Google решила взять ситуацию под свой контроль и добавила в API класс-загрузчик (Loader),
    который еще больше упрощает генерацию потоков и самостоятельно обходит слабые места AsyncTask.
    Создание нового потока теперь ведется через класс AsyncTaskLoader, который обязательно должен быть статическим.                     *//**

    private static class SimpleLoader extends AsyncTaskLoader<List<String>> {
    public SimpleLoader(Context context) {
    super(context);
    }                                                                                                                                                                   *//*

    Его реализация очень похожа на то, что приходится делать при использовании родительского AsyncTask,
    только теперь все вычисления в новом потоке находятся в методе loadInBackground.                                                                    *//**

    public List<String> loadInBackground() {
      final ArrayList<String> list = new ArrayList<String>();
      ...
      return list;
    }                                                                                                                                                                                                   *//*

    Проблемы, которые вылезли в AsyncTask, решены путем введения промежуточного звена — менеджера загрузки.
    Класс LoaderManager.LoaderCallbacks управляет созданным потоком и по окончании вычислений возвращает данные
    в действующий Activity. Теперь достаточно быстро можно создать код, экономящий ресурсы и решающий проблему
    перезапуска Activity: вычисления продолжатся в самом первом потоке, а менеджер подключит новый Activity
    к ранее созданному потоку.

    Для примера поместим на экран ListView, данные для которого поступят из сгенерированного потока.
    Менеджер потока тоже класс-дженерик, сегодня он будет работать со списком строк.                                                                        *//**

    public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> { ...                            *//*

    Теперь нужно создать менеджер и подключить к нему поток (Loader).
    Под управлением у менеджера может быть несколько потоков с уникальными номерами,
    но менеджер в Activity должен быть только один.                                                                                                                 *//**

    LoaderManager manager= getLoaderManager();
    manager.initLoader(loader_id,null,this);                                                                                                *//*

    Данные будут обновляться после нажатия кнопки — к примеру, FloatingActionButton.
    Для доступа к менеджеру из обработчика setOnClickListener нужно добраться до контекста приложения
    и вытащить оттуда экземпляр класса LoaderManager.                                                                                                       *//**

      fab.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        getLoaderManager()
          .initLoader(31337, null, (android.app.LoaderManager.LoaderCallbacks<List<String>>) v.getContext())
          .forceLoad();
      }
    });                                                                                                                                                                     *//*


    Создаваться поток будет в методе onCreateLoader, который ОС вызовет и обработает самостоятельно.
    В качестве параметров этот метод принимает уникальный номер будущего потока (31337),
    а также объект класса Bundle, через который можно задавать параметры по связке «ключ — значение».                               *//**

    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
      SimpleLoader loader = new SimpleLoader(this);
      return loader;
    }                                                                                                                                           *//*

    После того как AsyncTaskLoader выполнит все действия, в менеджере сработает метод onLoadFinished.
    Для передачи данных в UI тут нужно заново получить доступ к визуальным объектам, так как они могли быть пересозданы.                *//**

    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
      final ListView listView = (ListView) findViewById(R.id.listview);
      final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
      listView.setAdapter(adapter);
    }                                                                                                                                                               *//*

    Чтобы избежать ошибок с передачей некорректных данных, нужно еще заполнить метод onLoaderReset.
    Он вызывается в том случае, если действия, выполняющиеся в AsyncTaskLoader, были отменены или перезапущены.                  *//**

    public void onLoaderReset(Loader<List<String>> loader) {
      final ListView listview = (ListView) findViewById(R.id.listview);
      listview.setAdapter(null);                                                                                                                            *//*
    }

    По каким-то причинам в загрузчике не был реализован аналог метода onProgressUpdate из AsyncTask.
    Но это возможно сделать самостоятельно, передавая данные в UI с помощью слабых ссылок.

    !!!@ Помимо doInBackground, порождающего новый поток, в AsynkTask есть методы,
    которые будут выполняться уже в главном потоке.

     — не совсем так. Метод execute() вызывает doInBackGround на этом executor:
    public static final Executor THREAD_POOL_EXECUTOR
    = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);

    пул тредов в свою очередь имеет очередь
    private final BlockingQueue workQueue;
    из которой потоки берут новые задачи на выполнение, в данном случае те что создаются в конструкторе
    AsyncTask(там создается FutureTask)

































 */







}