import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Telephone> telephones = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Монько Максим Витальевич");
        System.out.println("РИБО-01-21");

        telephones.add(new Telephone("Iphone 14 Pro Max", "JK999PH", "white", true));
        telephones.add(new Telephone("Hao Zayn", "RS965MN", "brown", false));
        telephones.add(new Telephone("Samsung A8", "XC378BD", "blue", true));
        telephones.add(new Telephone("Panasonic", "DF567MG", "black", false));
        telephones.add(new Telephone("Xiaomi Note 5", "LX231JQ", "red", true));


        int a;
        while (true) {
            while (true) {
                System.out.println();
                System.out.println("Выберите действие:");
                System.out.println("1 - Добавить телефон");
                System.out.println("2 - Удалить телефон по серийному номеру");
                System.out.println("3 - Удалить все телефоны");
                try {
                    a = Integer.parseInt(scan());
                    if (a != 1 && a != 2 && a != 3) {
                        System.out.println("Необходимо ввести целое число от 1 до 3");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Необходимо ввести целое число от 1 до 3");
                }
            }
            switch (a) {
                case 1:
                    addTelephone(createTelephone());
                    showAllTelephones();
                    break;
                case 2:
                    deleteTelephoneByNumber(askNumber());
                    showAllTelephones();
                    break;
                case 3:
                    deleteAllTelephones();
                    showAllTelephones();
                    break;
            }
        }

    }

    public static Telephone createTelephone() {
        String model, number, color;
        int a;
        while (true) {
            System.out.println();
            System.out.println("Введите модель телефона:");
            model = scan();
            if (model.isEmpty() || model.isBlank()) {
                System.out.println("Поле \"Модель\" должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Введите серийный номер телефона:");
            number = scan();
            if (number.isEmpty() || number.isBlank()) {
                System.out.println("Поле \"Серийный номер\" должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Введите цвет телефона:");
            color = scan();
            if (color.isEmpty() || color.isBlank()) {
                System.out.println("Поле \"Цвет\" должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Выберите тип телефона(введите число):");
            System.out.println("1 - Смартфон");
            System.out.println("2 - Стационарный");
            try {
                a = Integer.parseInt(scan());
                if (a != 1 && a != 2) {
                    System.out.println("Необходимо ввести целое число от 1 до 2");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число от 1 до 2");
            }
        }
        return new Telephone(model, number, color, a==1);
    }

    public static void addTelephone(Telephone telephone) {
        System.out.println();
        if (telephones.isEmpty()) {
            telephones.add(telephone);
            System.out.println("Телефон успешно добавлен!");
            return;
        }
        for (Telephone tele : telephones) {
            if (tele.getNumber().equals(telephone.getNumber())) {
                System.out.println("Телефон с таким серийным номером уже существует.");
                return;
            }
        }
        telephones.add(telephone);
        System.out.println("Телефон успешно добавлен!");
    }

    public static void deleteTelephoneByNumber(String number) {
        Telephone tel = null;
        System.out.println();
        if (telephones.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        for (Telephone telephone : telephones) {
            if (telephone.getNumber().equals(number)) {
                tel = telephone;
                break;
            }
        }
        if (tel != null) {
            telephones.remove(tel);
            System.out.println("Телефон успешно удален!");
        } else {
            System.out.println("Телефон с таким серийным номером отсутствует.");
        }
    }

    public static String askNumber() {
        String number;
        while (true) {
            System.out.println();
            System.out.println("Введите серийный номер:");
            number = scan();
            if (number.isEmpty() || number.isBlank()) {
                System.out.println("Поле \"Серийный номер\" должно быть заполнено.");
                continue;
            }
            break;
        }
        return number;
    }

    public static void deleteAllTelephones(){
        System.out.println();
        telephones.clear();
        System.out.println("Список успешно очищен!");
    }

    public static void showAllTelephones() {
        System.out.println();
        if (telephones.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        for (Telephone telephone: telephones) {
            System.out.println(telephone);
        }
    }

    public static String scan() {
        return new Scanner(System.in).nextLine();
    }
}