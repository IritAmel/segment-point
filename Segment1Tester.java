
/**
 * Compilation (only !) tester for Maman 12, 20441, 2021a
 * 
 * @author Course staff 
 * @version 2_1
 */
public class Segment1Tester
{
    public static void main()
    {
        System.out.println("============ Testing class Segment1 =============");
    
        Segment1 s11 = new Segment1(1.0 , 2.0, 3.0, 4.0);
        Segment1 s12 = new Segment1(1.0 , 2.0, 3.0, 4.0);
        if (!s11.equals(s12))
            System.out.println("Check your equals method in class Segment1");        
            
        Point p3 = new Point(5.0, 6.0);
        Point p4 = new Point(7.0, 8.0);
        Segment1 s13 = new Segment1(p3, p4);
        Segment1 s14 = new Segment1(s12);
        
        Point p5 = s11.getPoLeft();
        p5 = s11.getPoRight();
        
        double d1 = s11.getLength();
        
        if (s11.toString().indexOf('@') != -1)
            System.out.println("Check your toString method in class Segment1");
            
        boolean b1 = s11.isAbove(s12);
        b1 = s11.isUnder(s12);
        b1 = s11.isLeft(s12);
        b1 = s11.isRight(s12);
        
        s11.moveHorizontal(1.0);
        s11.moveVertical(1.0);
        s11.changeSize(1.0);
        
        b1 = s11.pointOnSegment(p3);
        b1 = s11.isBigger(s12);
        d1 = s11.overlap(s12);
        d1 = s11.trapezePerimeter(s12);

        System.out.println("============ Testing class Segment1 Done =============");
    }
    
}
