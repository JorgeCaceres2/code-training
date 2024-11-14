package varios;

public class Varios {

    public static String getHello(final Person person) {
        return person.getName().trim();
    }



    public static void main(String[] args) {

        Person person = new Person();
        person.setName("  John Doe  ");
        person.setAge(30);

        System.out.println(getHello(person));

    }
}

class Person {
    private String name;
    private int age;

    //setter and getter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
