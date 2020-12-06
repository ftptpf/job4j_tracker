package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class EasyStream {
    List<Integer> source;

    public EasyStream(List<Integer> source) {
        this.source = source;
    }

    /**
     * Метод получает исходные данные.
     * @param source Лист исходных числовых значений.
     * @return поток элементов (лист чсловых значений).
     */
    public static EasyStream of(List<Integer> source) {
        EasyStream ofEaseStream = new EasyStream(source);
        return ofEaseStream;
    }

    /**
     * Метод преоразует одной число в другое.
     * @param fun функция преобразования одного числа в другое.
     * @return поток элементов (лист чсловых значений).
     */
    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> mapListResult = new LinkedList<>();
        for (Integer m : source) {
            m = fun.apply(m);
            mapListResult.add(m);
        }
        return new EasyStream(mapListResult);
    }

    /**
     * Метод фильтрует поток элементов.
     * @param fun функция фильтрации.
     * @return поток элементов (лист чсловых значений).
     */
    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> filterListResult = new ArrayList<>();
        for (Integer f : source) {
            if (fun.test(f)) {
                filterListResult.add(f);
            }
        }
        return new EasyStream(filterListResult);
    }

    /**
     * Метод собирает все элементы.
     * @return лист числовых значений.
     */
    public List<Integer> collect() {
        List<Integer> rsl = new ArrayList<>(source);
        return rsl;
    }
}
