package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        /**
         * Метод вычисляет общий средний балл.
         *
         * Метод averageScore - с этим методом все достаточно просто, для реализации понадобятся методы:
         * - flatMap() для преобразования в поток объектов Subject;
         * - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
         * - average() для расчета среднего бала по предмету;
         * - orElse() для того чтобы вернуть значение по умолчанию.
         */
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(x -> x.getScore())
                .average()
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        /**
         * Метод вычисляет средний балл ученика по его предметам.
         * Возвращает список из объекта Tuple (имя ученика и средний балл).
         *
         * Поскольку нам надо выполнить преобразование в поток объектов класса Tuple, последовательность будет следующей:
         * - метод map() для преобразования в поток объектов класса Tuple, внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
         * - при этом в конструктор первым параметром будет передаваться имя текущего объекта Pupil - используем соответствующий геттер;
         * - вторым параметром рассчитанный средний балл - расчет можно произвести по той же последовательности, что описана для метода averageScore;
         * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
         */
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(z -> z.getScore())
                .average()
                .orElse(0.0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        /**
         * Метод вычисляет средний балл по всем предметам для каждого ученика.
         * Возвращает список из объекта Tuple (название предмета и средний балл).
         *
         * Поскольку в данном случае требуется выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
         * - flatMap() для преобразования в поток объектов Subject;
         * - метод collect() в который мы передаем метод groupingBy() (минимум с двумя параметрами) класса Collectors.
         * При этом карта собирается следующим образом: ключ - это имя предмета,
         * значение - средний балл по этому предмету для каждого ученика.
         * Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
         * - после этого собранную карту мы разбираем с помощью entrySet() и открываем поток с помощью stream();
         * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
         * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
         * - в конструктор мы будем передавать параметры с помощью методов getKey() и getValue() интерфейса Entry;
         * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
         */
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        /**
         * Метод возвращает лучшего ученика.
         * Лучшим считается ученик с наибольшим баллом по всем предметам.
         *
         * Для реализации данного метода можно использовать метод averageScoreBySubject за исключением следующих особенностей:
         * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо average() нужно использовать метод sum();
         * - терминальной операцией будет не метод collect(), а использование метода max(), в который будем передавать компаратор.
         * При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
         * - orElse() для того чтобы вернуть значение по умолчанию.
         */
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(z -> z.getScore())
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("NoOne", 0.0));
    }
    public static Tuple bestSubject(Stream<Pupil> stream) {
        /**
         * Метод возвращает предмет с наибольшим баллом для всех студентов.
         * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
         *
         * Для реализации данного метода можно использовать метод averageScoreByPupil за исключением следующих особенностей:
         * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо averagingDouble() нужно использовать метод summingDouble();
         * - терминальной операцией будет не метод collect(), а использование метода max(), в который будем передавать компаратор.
         * При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
         * - orElse() для того чтобы вернуть значение по умолчанию.
         */
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("NoOne", 0.0));
    }
}
