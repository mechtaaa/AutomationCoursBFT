public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Алексей", 50000);
        Developer developer = new Developer("Андрей", 90000);

        manager.work();
        developer.work();

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();
    }
}