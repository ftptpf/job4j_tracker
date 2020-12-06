package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class EasyStream {
    List<Integer> source;

    public EasyStream(List<Integer> source) {
        this.source = source;
    }

    public List<Integer> getSource() {
        return source;
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
        EasyStream mapEaseStream = new EasyStream(source);
        List<Integer> mapList = mapEaseStream.getSource();
        List<Integer> mapListResult = new LinkedList<>();
        for (Integer m : mapList) {
            m = fun.apply(m);
            mapListResult.add(m);
        }
        EasyStream mapEaseStreamResult = new EasyStream(mapListResult);


        return mapEaseStreamResult;
    }

    /**
     * Метод фильтрует поток элементов.
     * @param fun функция фильтрации.
     * @return поток элементов (лист чсловых значений).
     */
    public EasyStream filter(Predicate<Integer> fun) {
        EasyStream filterEaseStream = new EasyStream(source);
        List<Integer> filterList = filterEaseStream.getSource();
        List<Integer> filterListResult = new ArrayList<>();
        for (Integer f : filterList) {
            if (fun.test(f)) {
                filterListResult.add(f);
            }
        }
        EasyStream filterEaseStreamResult = new EasyStream(filterListResult);

        return filterEaseStreamResult;
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
