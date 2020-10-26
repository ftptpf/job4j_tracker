package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        //Supplier<List<Attachment>> rsl = ArrayList::new;
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }

        }
        return rsl;

    }

    public static List<Attachment> filterSizeFunction(List<Attachment> list) {
        BiFunction<List<Attachment>, Attachment, List<Attachment>> function = new BiFunction<List<Attachment>, Attachment, List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> lst, Attachment at) {
                lst.add(at);
                return lst;
            }
        };

        Predicate<Attachment> sizePredicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment el) {
                return el.getSize() > 100;
            }
        };
        return filter(list, sizePredicate);
    }

    public static List<Attachment> filterSizeFName(List<Attachment> list) {
        BiFunction<List<Attachment>, Attachment, List<Attachment>> function = new BiFunction<List<Attachment>, Attachment, List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> lst, Attachment at) {
                lst.add(at);
                return lst;
            }
        };

        Predicate<Attachment> namePredicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment el) {
                return el.getName().contains("bug");
            }
        };
        return filter(list, namePredicate);
    }



    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("Star", 120),
                new Attachment("Moon", 34),
                new Attachment("Somebug", 13)
        );
        System.out.println(filterSizeFunction(attachments));
        System.out.println(filterSizeFName(attachments));
    }
}
