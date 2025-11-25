import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    public static void main(String[] args) {

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(5.5, 5.6, 3.5));
        boxes.add(new Box(31.0, 31.0, 21.0));
        boxes.add(new Box(35.5, 25.0, 18.8));
        boxes.add(new Box(31.9, 15.4, 15.3));

        List<Box> widthBoxes = new ArrayList<>();

        Iterator<Box> it = boxes.iterator();
        while (it.hasNext()) {
            Box box = it.next();
            if (box.width > 30) {
                widthBoxes.add(box);
                it.remove();
            }
        }
        System.out.println("boxes: " + boxes.size() + " шт");
        System.out.println("widthBoxes: " + widthBoxes.size() + " шт");
    }
}