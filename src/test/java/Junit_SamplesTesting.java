import Testing.Junit_Samples;
import org.junit.*;

public class Junit_SamplesTesting {
    private final double EPS = 1e-9; //по конвенции лучше выводить констант используемые постоянно отдельным полем
    private static Junit_Samples testObject;  // поле статическое из за  @BeforeClass

    @BeforeClass
    public static void createNewObject(){    // создаем и подготавливаем объекты, данные для среды тестирования
        testObject = new Junit_Samples();   // в отличии от @Before, объект создастся один раз для всех тестов
    }

//    @Before
//    public void createNewObject(){          // создаем и подготавливаем объекты, данные для среды тестирования
//        testObject = new Junit_Samples();   // перед каждым новым тестом будет выполняться этот метод
//    }



    @Test    // аннотация обозначающая блок тестирования
    public void newVectorShouldHaveZeroLenght() { // тест, который проверит нулевые значения при создании нового вектора


        // идет проверка нулевого значения, со значением которое возвращает метод vector2DLength
        // (1e-9 - 0,0000000001)  - точность с которой проводится проверка,
        // отличие должно быть не более чем указанная дельта, т.к. double - вещественное число

        Assert.assertEquals(0, testObject.vector2DLength(), EPS);

        // Тест пройден - так как значения действительно нулевые

    }

    @Test
    public void newVectorShouldHaveZeroLenghtAssume() {

        Assume.assumeFalse(testObject.returnBoolean(0));

        // Тест будет пропущен, так как провален, он вернул True, а ждали assumeFalse
        // и используется класс Assume, который пропускает в случае провала
    }


    @Test (expected = ArithmeticException.class)  // проверяем на генерацию исключения ArithmeticException
    public void zeroDenominatorShouldThrowException(){ // проверка деления на ноль
        Junit_Samples.divide(10, 0);

        // Тест пройден, так как делить на ноль нельзя и выброшено исключение ArithmeticException
    }

    @Test (timeout = 3500)
    public void getConnectionShouldReturnFasterThrownOneSecond(){
        Junit_Samples.getConnection();

        // Тест пройден, так как выполнение соединения прошло за время меньшее 3500 миллисекунд.
    }


    @Ignore   // этот тест будет проигнорирован в пятой версии - @Disabled
    @Test
    public void getConnectionShouldReturnFasterThrownOneSecond2(){
        Junit_Samples.getConnection();
    }

    }



