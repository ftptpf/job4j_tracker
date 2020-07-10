package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: "); //в командной строке вводим имя
                Item item = new Item();
                item.setName(name); // записываем имя "Item"
                tracker.add(item); // в массива "items" записываем имя и автоматически присваиваем id
            } else if (select == 1) {
                System.out.println("=== All items ====");
                Item[] item = tracker.findAll(); // должен показать все не пустые элементы массива
                for (int i = 0; i < item.length; i++) { //цикл для поэлементного вывода значений массива
                    System.out.println("id: " + item[i].getId() + " name: " +item[i].getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit (replace) item ====");
                int id = Integer.valueOf(input.askInt("Enter id: ")); // вводим в командной строке id который ищем
                String name = input.askStr("Enter new Name: "); // вводим новое имя в командной строке для "Item"
                Item newItem = new Item();
                newItem.setName(name); // записываем новое имя которое ввели в командной строке
                if (tracker.replace(id, newItem)) { // производим поиск по id c заменой на новое имя в "Item"
                    System.out.println("Replacement was done.");
                } else {
                    System.out.println("Replacement error.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = Integer.valueOf(input.askInt("Enter id: ")); // вводим в командной строке id по котрому будет найдена
                // и удалена информация соответствующей ячейки массива
                if (tracker.delete(id)) { // производим поиск по id и удаление соответстующего "Item" из массива
                    System.out.println("Delete is Ok.");
                } else {
                    System.out.println("Delete error.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                int id = Integer.valueOf(input.askInt("Enter id: ")); // вводим в командной строке id который ищем
                Item t = tracker.findById(id);
                if (t.equals(null)) {
                    System.out.println("Error. Item is null");
                }else {
                    System.out.println("id: " + t.getId() + " name: " + t.getName());
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                String name = input.askStr("Enter name: "); //в командной строке вводим имя которое ищем
                Item[] n = tracker.findByName(name);
                if (n.length == 0) {
                    System.out.println("Error. We can't find result.");
                } else {
                    for(int i = 0; i < n.length; i++)
                    System.out.println("id: " + n[i].getId() + " name: " + n[i].getName());
                }

            } else  if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input,tracker);
    }
}
