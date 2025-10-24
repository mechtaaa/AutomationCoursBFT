public class LessonSix {
    public static void main(String[] args) {
        String[] list = {"привет", "ПОКА", "гипербола"};
        System.out.println(list[0].toUpperCase());
        System.out.println(list[1].toLowerCase());
        System.out.println(list[2].replace("и","О").substring(0, 3) + " " + list[2].substring(3));
    }

}
