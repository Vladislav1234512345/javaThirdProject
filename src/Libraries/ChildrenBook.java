package Libraries;

public class ChildrenBook extends Book {
    protected int age;

    ChildrenBook() {
        super();
        this.age = 0;
    }
    ChildrenBook(String author, String name, double cost, int year, int age) {
        this.author = author;
        this.name = name;
        this.cost = cost;
        this.year = year;
        this.age = age;
    }
    ChildrenBook(String author, int year) {
        this();
        this.author = author;
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\nАвтор: " + getAuthor()
                + "\nИмя: " + getName()
                + "\nСтоимость: " + getCost()
                + "\nГод: " + getYear()
                + "\nВозраст: " + getAge();
    }
}
