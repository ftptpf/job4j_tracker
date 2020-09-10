package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    /**
     * Метод сравнивает два текста, проверяет их на уникальность,
     * т.е. на то что предложения могут содержать одни и теже слова,
     * но в разной последовательности.
     * @param originText первый текст (оригинал)
     * @param duplicateText второй текс (дубликат)
     * @return
     */
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");//Преобразование строки в массив слов
        String[] text = duplicateText.split(" ");//Преобразование строки в массив слов
        HashSet<String> check = new HashSet<>();
        for (String str : origin) {// Проходим по массиву, берем слова из (оригинального) текста
            check.add(str);//вставляем (уникальные) уникальные слова в коллекцию
        }
        for (String hs : text) {// Проходим по массиву, берем слова из (проверяемого) текста
            if (!check.contains(hs)) {//проверяем, если хотя бы одно из слов уникально, его нет в оригинальной строке
                rsl = false;// возврашаем false
                break;//прерываем выполнение цикла
            }
        }
        return rsl;
    }
}
