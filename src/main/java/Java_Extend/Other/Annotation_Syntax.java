    package Java_Extend.Other;

    import java.lang.annotation.ElementType;
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    import java.lang.annotation.Target;

    // ограничим применение нашей аннотации, будет применяться только к методу, полю и классу
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})

    @Retention(RetentionPolicy.RUNTIME) // аннотация будет видна в ходе программы

    public @interface Annotation_Syntax {   // аннотация для примера, в которую передаем информацию о своих методах
        String author() default "Alex";         // кто автор
        int dateOfCreation() default 2022;       // дата создания
        String purpes();            // какая у метода цель
    }
