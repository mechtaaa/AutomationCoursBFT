public class Developer extends Employee {
    public Developer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void work(){
        System.out.println("Разработчик " + name + " получает зарплату в размере " + salary + " рублей");
    }
}
