public class Guitar implements Playable {
    @Override
    public void play(int countStrings){
        System.out.println("Гитара играет на " + countStrings + " струнах");
    }
}
