package Java_Extend.Functional_Programming;

public class FunctionalInterface_Syntax {

    /*

                               *** FunctionalInterface (Функциональные интерфейсы) ***
                              		их можно записать в виде лямбда выражений

	Функциональные интерфейсы содержат всего один метод,
	для аннотации такого интерфейса можно указать @FunctionalInterface поставив его перед строкой объявления интерфейса
	он нас защищает от случайного добавления других методов в интерфейс
	метод не может быть default или private

	пример:
	    																							               *//**
	@FunctionalInterface
	public interface FunctionInterface01 {
    void run();
	}		                                                                                                    	*//*


    Каждый из объявляемых классов выполняет какую-то одну функцию,
    но для её описания мы используем кучу лишнего вспомогательного кода:                                           *//**

    Supplier<String> supplier = new Supplier<String>() {
	    @Override
	    public String get() {
		    return "String";
	    }
    };

    Consumer<String> consumer = new Consumer<String>() {
	    @Override
	    public void accept(String s) {
		    System.out.println(s);
	    }
    };

    Function<String, Integer> converter = new Function<String, Integer>() {
	    @Override
	    public Integer apply(String s) {
		    return Integer.valueOf(s);
	    }
    };                                                                                                              *//*


    И разработчики Java так же подумали. Поэтому,
    они ввели набор "функциональных интерфейсов" (@FunctionalInterface) и решили,
    что теперь Java сама будет "додумывать" за нас всё, кроме важного:
                                                                                                                   *//**

        Supplier<String> supplier = () -> "String";

        Consumer<String> consumer = s -> System.out.println(s);

        Function<String, Integer> converter = s -> Integer.valueOf(s);
                                                                                                                    *//*

    Supplier — поставщик. Он не имеет параметров, но возвращает что-то, то есть поставляет это.

    Consumer — потребитель. Он принимает на вход что-то (параметр s) и с этим что-то что-то делает,
    то есть потребляет что-то.

    Есть ещё функция. Она принимает на вход что-то (параметр s), что-то делает и возвращает что-то.
    Как мы видим, активно используются дженерики.







     */


}
