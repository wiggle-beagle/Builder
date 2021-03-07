

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setLastName("вольф")
                .setAge(35)
                .setAddress("Москва")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println(mom);
        System.out.println(son);

        Person dad = new PersonBuilder()
                .setHasAge(false)
                .setName("Анна")
                .setLastName("вольф")
                .setAddress("Москва")
                .build();

        System.out.println(dad);


        try {
            // Не хватает обяхательных полей
            new PersonBuilder().setName("Ирина").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
