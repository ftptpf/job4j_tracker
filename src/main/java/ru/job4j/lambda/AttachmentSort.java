package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] agrs) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> comparatorName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                String left = o1.getName();
                String right = o2.getName();
                return left.compareTo(right);
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);

    }
}
