package Task1;

public class Main {
    public static void main(String[] args) {

        Shape[] shape = new Shape[3];
        shape[0] = new Triangle();
        shape[1] = new Circle();
        shape[2] = new Rectangle();

        ((Triangle)shape[0]).setA(5.2);
        ((Triangle)shape[0]).setB(4);
        ((Triangle)shape[0]).setH(8);

        ((Circle)shape[1]).setRadius(3);

        ((Rectangle)shape[2]).setA(2.2);
        ((Rectangle)shape[2]).setB(4);



        for (Shape sh : shape) {
            System.out.println("Площадь фигуры: " + sh.square());
        }
    }

}
