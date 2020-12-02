
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{

    /**
     * Constructor for objects of class main
     */
    public static void main(String []args)
    {
        Point point1 = new Point(6,6);
        Point point2 = new Point(8,6);
        //Point copyPoint = new Point(4,5);
        //System.out.println(point.toString());
        //point.move(1,0);
        //System.out.println(point.toString());
        //Segment2 seg = new Segment2(point1, 4);
        //System.out.println(seg.toString());
        Segment2 seg1 = new Segment2(1.0 , 2.0, 3.0, 4.0);
        Segment2 seg2 = new Segment2(1.0 , 2.0, 3.0, 4.0);
        System.out.println(seg1.toString());
        System.out.println(seg2.toString());
        System.out.println("seg1 length:" + seg1.getLength());
        System.out.println("seg2 length:" + seg2.getLength());
        System.out.println("seg1 center:" + seg1.getCenter());
        System.out.println("seg2 center:" + seg2.getCenter());
        System.out.println(seg1.equals(seg2));
        Segment2 seg3 = new Segment2(point1, point2);
        //System.out.println(seg3.toString());
        //seg2.moveVertical(3);
        //System.out.println(seg2.toString());
   
    }

}
