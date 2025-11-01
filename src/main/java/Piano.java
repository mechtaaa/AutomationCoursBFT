public class Piano  implements Playable {
    @Override
    public void play(int countStrings){
        System.out.println("Пианино играет на " + countStrings + " струнах");
    }
}
