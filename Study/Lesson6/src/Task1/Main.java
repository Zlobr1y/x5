package Task1;

public class Main {
    public static void main(String[] args) {
        ArrayScroll<String> arrayScroll = new ArrayScroll<>();
        LinkedScroll<String> linkedScroll = new LinkedScroll<>();

        arrayScroll.add("Антананариву");
        arrayScroll.add("Джамалунгма");
        arrayScroll.add("Тигусигальпа");
        System.out.println("Размер свитка: " + arrayScroll.size());
        arrayScroll.remove(0);
        System.out.println(arrayScroll.get(0));
        arrayScroll.clear();


        linkedScroll.add("Амазонка");
        linkedScroll.add("Миссисипи");
        linkedScroll.add("Нил");
        linkedScroll.add("Лена");
        System.out.println("Размер свитка: " + linkedScroll.size());
        linkedScroll.remove(2);
        System.out.println(linkedScroll.get(2));
        linkedScroll.clear();


    }
}

