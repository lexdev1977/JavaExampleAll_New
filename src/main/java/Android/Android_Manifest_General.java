package Android;

public class Android_Manifest_General {

/*
                                Файл манифеста AndroidManifest.xml

    Файл манифеста AndroidManifest.xml предоставляет системе основную информацию о программе.
    Каждое приложение должно иметь свой файл AndroidManifest.xml. Редактировать файл манифеста можно вручную,
    изменяя XML-код или через визуальный редактор Manifest Editor, который позволяет осуществлять визуальное
    и текстовое редактирование файла манифеста приложения.

    Назначение файла:

    - описывает компоненты приложения – Activities, Services, Broadcast receivers и Content providers;
    - содержит список необходимых разрешений для обращения к защищенным частям API
      и взаимодействия с другими приложениями;
    - объявляет разрешения, которые сторонние приложения обязаны иметь для взаимодействия
      с компонентами данного приложения;
    - объявляет минимальный уровень API Android, необходимый для работы приложения;
    - перечисляет связанные библиотеки.

    Корневым элементом манифеста является <manifest>.
    Помимо данного элемента обязательными элементами являются теги <application> и <uses-sdk>.
    Элемент <application> является основным элементом манифеста и содержит множество дочерних элементов,
    определяющих структуру и работу приложения. Порядок расположения элементов,
    находящихся на одном уровне, произвольный. Все значения устанавливаются через атрибуты элементов.
    Кроме обязательных элементов, упомянутых выше, в манифесте по мере необходимости используются другие элементы.
    Перечислим некоторые из них:


    * <manifest> является корневым элементом манифеста.
    По умолчанию Eclipse создает элемент с четырьмя атрибутами:

        - xmlns:android определяет пространство имен Android.

        - package определяет уникальное имя пакета приложения.

        - android:versionCode указывает на внутренний номер версии.

        - android:versionName указывает номер пользовательской версии.


    * <permission> объявляет разрешение, которое используется для ограничения доступа к определенным компонентам
    или функциональности данного приложения. В этой секции описываются права, которые должны запросить
    другие приложения для получения доступа к приложению. Приложение может также защитить
    свои собственные компоненты (Activities, Services, Broadcast receivers и Content providers) разрешениями.
    Оно может использовать любое из системных разрешений, определенных Android или объявленных другими приложениями,
    а также может определить свои собственные разрешения.


    * <uses-permission> запрашивает разрешения, которые приложению должны быть предоставлены системой
    для его нормального функционирования. Разрешения предоставляются во время установки приложения,
    а не во время его работы.

        Наиболее распространненные разрешения:

        - INTERNET – доступ к интернету

        - READ_CONTACTS – чтение (но не запись) данных из адресной книги пользователя

        - WRITE_CONTACTS – запись (но не чтение) данных в адресную книгу пользователя

        - RECEIVE_SMS – обработка входящих SMS

        - ACCESS_FINE_LOCATION – точное определение местонахождения при помощи GPS


    * <uses-sdk> позволяет объявлять совместимость приложения с указанной версией (или более новыми версиями API)
    платформы Android. Уровень API, объявленный приложением, сравнивается с уровнем API системы мобильного устройства,
    на который инсталлируется данное приложение.
        Атрибуты:

        - android:minSdkVersion определяет минимальный уровень API, требуемый для работы приложения.
        Система Android будет препятствовать тому, чтобы пользователь установил приложение,
        если уровень API системы будет ниже, чем значение, определенное в этом атрибуте.

        - android:maxSDKVersion позволяет определить самую позднюю версию, которую готова поддерживать программа.

        - targetSDKVersion позволяет указать платформу, для которой разрабатывалось и тестировалось приложение.


    * <uses-configuration> указывает требуемую для приложения аппаратную и программную конфигурацию
    мобильного устройства. Спецификация используется, чтобы избежать инсталляции приложения на устройствах,
    которые не поддерживают требуемую конфигурацию. Если приложение может работать с различными конфигурациями
    устройства, необходимо включить в манифест отдельные элементы <uses-configuration> для каждой конфигурации.


    * <uses-feature> объявляет определенную функциональность, требующуюся для работы приложения.
    Таким образом, приложение не будет установлено на устройствах, которые не имеют требуемую функциональность.
    Например, приложение могло бы определить, что оно требует камеры с автофокусом.
    Если устройство не имеет встроенную камеру с автофокусом, приложение не будет установлено.
        Возможные атрибуты:

        - android.hardware.camera – требуется аппаратная камера.

        - android.hardware.camera.autofocus – требуется камера с автоматической фокусировкой.


    * <supports-screens> определяет разрешение экрана, требуемое для функционирования приложения.
    По умолчанию современное приложение с уровнем API 4 или выше поддерживает все размеры экрана
    и должно игнорировать этот элемент.


    * <application> один из основных элементов манифеста, содержащий описание компонентов приложения.
    Содержит дочерние элементы (<activity>, <service>, <receiver>, <provider> и другие),
    которые объявляют каждый из компонентов, входящих в состав приложения.
    В манифесте может быть только один элемент <application>.

























 */





}
