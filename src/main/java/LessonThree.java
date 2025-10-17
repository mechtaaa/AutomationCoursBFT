public class LessonThree {

        public String publicStringVar;
        public int publicIntVar;

        public static int staticStringVar;


        public static void staticMethod() {
            System.out.println("Значение статической переменной: " + staticStringVar);
            staticStringVar += 50;
            System.out.println("После изменения: " + staticStringVar);
        }



        public void methodVar() {
            System.out.println("publicStringVar: " + publicStringVar);
            System.out.println("publicIntVar: " + publicIntVar);
            System.out.println("staticStringVar: " + staticStringVar);
        }


        public static void main(String[] args) {
            LessonThree.staticStringVar = 50;

            LessonThree lessonThree = new LessonThree();

            // До переопределения публичные переменные
            lessonThree.publicStringVar = "До переопределения public переменная";
            lessonThree.publicIntVar = 100;

            lessonThree.methodVar();
            LessonThree.staticMethod();

            // Переопределяем переменные
            lessonThree.publicStringVar = "После переопределения public строка";
            lessonThree.publicIntVar = 200;
            LessonThree.staticStringVar = 300;

            lessonThree.methodVar();
            LessonThree.staticMethod();

        }

}
