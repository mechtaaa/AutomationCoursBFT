public class Car {
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    String model;
    int year;


    public void makeBeBe(){
        System.out.println("Модель авто: " + model + " , " + year + " года");
    }

    public static void main(String[] args) {
        Car tayote = new Car("RAV 4", 2022);
        Car opel = new Car ("Astra", 2007);

        tayote.makeBeBe();
        opel.makeBeBe();
    }
}