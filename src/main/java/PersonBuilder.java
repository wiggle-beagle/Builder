public class PersonBuilder {

    private String name;
    private String lastName;
    private int age;
    private String address;
    private boolean hasAge = true;
    private boolean hasAddress = true;


    public PersonBuilder setHasAge(boolean hasAge) {
        this.hasAge = hasAge;
        return this;
    }

    public PersonBuilder setHasAddress(boolean hasAddress) {
        this.hasAddress = hasAddress;
        return this;
    }

    public PersonBuilder setName(String name) {
        if (this.name == null)
            this.name = name;
        return this;

    }


    public PersonBuilder setLastName(String lastName) {
        if (this.lastName == null)
            this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0)
            throw new IllegalArgumentException("некорректный возраст");
        if (this.age == 0)
            this.age = age;
        return this;
    }


    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() {

        if ((hasAge == true & age == 0)
                || (hasAddress == true & address == null)
                || (name == null)
                || (lastName == null))
            throw new IllegalStateException("ошибка! не хватает обязательных полей");

        Person person = new Person(this.name, this.lastName, this.age, this.address);
        return person;
    }
}

