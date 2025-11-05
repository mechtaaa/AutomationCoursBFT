public class LessonSix {

    public static String randomList(String[] list){
        int randomList = (int) (Math.random() * list.length);
        return list[randomList];
    }


    public static void main(String[] args) {
        String[] list = {"привет", "ПОКА", "гипербола"};
        System.out.println(list[0].toUpperCase());
        System.out.println(list[1].toLowerCase());
        System.out.println(list[2].replace("и","О").substring(0, 3) + " " + list[2].substring(3));

        int randomInt = (int) (Math.random() * 3);
        System.out.println(randomInt);

        System.out.println(randomList(list));
    }
}