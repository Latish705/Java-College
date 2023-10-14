package Model;

public abstract class person {
    private int age;
    public void set_age(int age)
    {
        this.age=age;
    }

    public int get_age()
    {
        return age;
    }
    public abstract void set_nationality(String nationality);
    public abstract String get_nationality();

}
