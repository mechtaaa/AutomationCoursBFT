public class Manager extends Employee{
    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void work(){
        System.out.println("Менеджер " + name + " получает зарплату в размере " + salary + " рублей");
    }
}
