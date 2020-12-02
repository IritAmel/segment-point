/**
 * Segment1 represents a line (parallel to the x-axis) using two Points.
 * Maman 12 Q2
 * @author Irit Amelchenko
 */
public class Segment1 {
    private Point _poRight;
    private Point _poLeft;
    private final int DEFAULT_VAL = 0;
    //constructors:
    /**
    * Constructs a new segment using two Points. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
    * @param left the left point of the segment
    * @param right the right point of the segment
    */
    public Segment1(Point left, Point right)
    {
        if (left.getY() != right.getY())
            right.setY(left.getY());
            
        _poLeft = left;
        _poRight = right;
 
    }
    /**
    * Constructs a new segment using 4 specified x y coordinates: Two coordinates for the left point and two coordinates for the right point. 
    * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
    * @param leftX X value of left point.
    * @param leftY Y value of left point.
    * @param rightX X value of right point.
    * @param rightY Y value of right point.
    */
    public Segment1(double leftX, double leftY, double rightX, double rightY)
    {
        if (leftY != rightY) 
        _poRight = new Point(rightX, leftY);
        else 
        _poRight = new Point(rightX, rightY);      
        
        _poLeft = new Point(leftX, leftY);
    }
    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other the reference segment.
     */
    public Segment1(Segment1 other)
    {
        if (other != null)
        _poRight = other._poRight;
        _poLeft = other. _poLeft;
    }
    /**
     * Returns the left point of the segment.
     * @return The left point of the segment.
     */
    public Point getPoLeft(){
        return _poLeft;
    }
    /**
     * Returns the right point of the segment.
     * @return The right point of the segment.
     */
    public Point getPoRight(){
        return _poRight;
    }
    /**
     * Returns the segment length.
     * @return The segment length.
     */
    public double getLength(){
        return Math.round((_poRight.getX() - _poLeft.getX())*10000)/(double)10000;
    }
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @override toString in class java.lang.Object
     * @return String representation of this segment.
     */
    public String toString(){
        return "(" + Math.round(_poLeft.getX()*10000)/(double)10000 + "," 
        + Math.round(_poLeft.getY()*10000)/(double)10000 + ")---(" 
        + Math.round(_poRight.getX()*10000)/(double)10000 + "," 
        + Math.round(_poRight.getY()*10000)/(double)10000 + ")";
    } 
    /**
     * Check if the reference segment is equal to this segment.
     * @param other the reference segment.
     * @return True if the reference segment is equal to this segment.
     */
    public boolean equals(Segment1 other){
        return this.getPoLeft().getX() ==  other.getPoLeft().getX() && this.getPoLeft().getY() ==  other.getPoLeft().getY() 
        && this.getPoRight().getX() ==  other.getPoRight().getX() && this.getPoRight().getY() ==  other.getPoRight().getY();
    }
    /**
     * Check if this segment is above a reference segment.
     * @param other the reference segment.
     * @return True if this segment is above the reference segment.
     */
    public boolean isAbove(Segment1 other){
        return this.getPoLeft().getY() > other.getPoLeft().getY();
    }
    /**
     * Check if this segment is under a reference segment.
     * @param other the reference segment.
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other){
        return other.isAbove(this);
    }
    /**
     * Check if this segment is left of a received segment.
     * @param other the reference segment.
     * @return True if this segment is left to the reference segment.
     */
    public boolean isLeft(Segment1 other){
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }
    /**
     * Check if this segment is right of a received segment.
     * @param other the reference segment.
     * @return True if this segment is right to the reference segment.
     */
    public boolean isRight(Segment1 other){
        return this.getPoLeft().getX() > other.getPoRight().getX();
    }
    /**
     * Move the segment horizontally by delta.
     * @param delta the displacement size.
     */
    public void moveHorizontal (double delta){
        getPoLeft().move(delta,0);
        getPoRight().move(delta,0);
    }
    /**
     * Move the segment vertically by delta.
     * @param delta the displacement size.
     */
    public void moveVertical (double delta){
        getPoLeft().move(0,delta);
        getPoRight().move(0,delta);
    }
    /**
     * Change the segment size by moving the right point by delta. Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta the length change.
     */
    public void changeSize (double delta){
        getPoRight().move(delta,0);
    }
    /**
     * Check if a point is located on the segment.
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p){
       if (p.getY() == this.getPoLeft().getY())
           return p.getX() <= getPoRight().getX() && (p.getX() >= this.getPoLeft().getX());
       else 
           return false;
    }
    /**
     * Check if this segment is bigger than a reference segment.
     * @param other the reference segment
     * @ return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment1 other){
        return this.getLength() > other.getLength();
    }
    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other the reference segment
     * @return The overlap size.
     */
    public double overlap(Segment1 other){
        double aLeftPointX = getPoLeft().getX();
        double aRightPointX = getPoRight().getX();
        double bLeftPointX = other.getPoLeft().getX();
        double bRightPointX = other.getPoRight().getX();
        if (aLeftPointX > bLeftPointX && aLeftPointX < bRightPointX){
            if (aRightPointX < bRightPointX)
                return this.getLength();
            else 
                return Math.round((bRightPointX - aLeftPointX)*10000)/(double)10000;
        }
        else if (aRightPointX > bLeftPointX && aRightPointX < bRightPointX)
            return Math.round((aRightPointX - bLeftPointX)*10000)/(double)10000;
        else if (bLeftPointX > aLeftPointX && bLeftPointX < aRightPointX && bRightPointX < aRightPointX)
                return other.getLength();
        else 
            return DEFAULT_VAL;
    }
    /**
     * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
     * @param oter the reference segment.
     * @return the trapeze perimeter.
     */
    public double trapezePerimeter(Segment1 other){
        return (other.getLength() + this.getLength() + this.getPoLeft().distance(other.getPoLeft()) + this.getPoRight().distance(other.getPoRight()));
    }
}
        