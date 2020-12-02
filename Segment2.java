
/**
 * Segment2 represents a line (parallel to the x-axis) using a center point and length.
 * Maman 12 Q3
 * @author Irit amelchenko
 */
public class Segment2
{
    //constructors:
    /**
    * Constructs a new segment using a center point and the segment length. 
    * @param poCenter - the Center Point.
    * @param length - the segment length.
    */
    private Point _poCenter;
    private double _length;
    private final int DEFAULT_VAL = 0;
    
    public Segment2(Point poCenter, double length){
        _poCenter = poCenter;
        _length = length;
    }
    /**
     * Constructs a new segment using 4 specified x y coordinates: two coordinates for the left point and two coordinates for the right point. 
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param leftX - X value of left point
     * @param leftY - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment2(double leftX, double leftY, double rightX, double rightY)
    {
        _length = (rightX - leftX);
        _poCenter = new Point(leftX + _length/2, leftY);
    }
    /**
     * Constructs a new segment using two Points. If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param left - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment2(Point left, Point right)
    {
        double centerX = left.getX() + (right.getX() - left.getX())/2;
        _poCenter = new Point(centerX, left.getY());
        _length = (right.getX() - left.getX());
    }
    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other - the reference segment
     */
    public Segment2(Segment2 other)
    {
       _poCenter = other._poCenter;
       _length = other._length;
    } 
    /**
     * Returns the left point of the segment.
     * @return The left point of the segment
     */
    public Point getPoLeft(){
        double newLeftX = _poCenter.getX() - _length/2.0;
        return new Point(newLeftX, _poCenter.getY());
    }
    /**
     * Returns The right point of the segment.
     * @return The right point of the segment

     */
    public Point getPoRight(){
        double newRightX = _poCenter.getX() + _length/2.0;
        return new Point(newRightX, _poCenter.getY());
    }
    /** 
     * Returns the segment length.
     * @return The segment length
     */
    public double getLength(){
        return _length;
    }
    /**
     * Returns the center point of the segment.
     * @return the center point of the segment
     */
    public Point getCenter(){
        return _poCenter; 
    }
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @override toString in class java.lang.Object
     * @return String representation of this segment
     */
    public String toString(){
        return "(" + Math.round(getPoLeft().getX()*10000)/(double)10000 + "," 
        + Math.round(getPoLeft().getY()*10000)/(double)10000 + ")---(" 
        + Math.round(getPoRight().getX()*10000)/(double)10000 + "," 
        + Math.round(getPoRight().getY()*10000)/(double)10000 + ")"; 
    }
    /**
     * Check if the reference segment is equal to this segment.
     * @param other - the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other){
        return (this.getCenter().getX() == other.getCenter().getX() && this.getCenter().getY() == other.getCenter().getY() &&this.getLength() == other.getLength());
    }
    
    /**
     * Check if this segment is above a reference segment.
     * @param other the reference segment.
     * @return True if this segment is above the reference segment.
     */
    public boolean isAbove(Segment2 other){
        return this._poCenter.getY() > other._poCenter.getY();
    }
    /**
     * Check if this segment is under a reference segment.
     * @param other the reference segment.
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other){
        return other.isAbove(this);
    }
    /**
     * Check if this segment is left of a received segment.
     * @param other the reference segment.
     * @return True if this segment is left to the reference segment.
     */
    public boolean isLeft(Segment2 other){
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }
    /**
     * Check if this segment is right of a received segment.
     * @param other the reference segment.
     * @return True if this segment is right to the reference segment.
     */
    public boolean isRight(Segment2 other){
        return this.getPoLeft().getX() > other.getPoRight().getX();
    }
    /**
     * Move the segment horizontally by delta.
     * @param delta the displacement size.
     */
    public void moveHorizontal (double delta){
        getCenter().move(delta, 0);
    }
    /**
     * Move the segment vertically by delta.
     * @param delta the displacement size.
     */
    public void moveVertical (double delta){
        getCenter().move(0, delta);
    }
    /**
     * Check if this segment is bigger than a reference segment.
     * @param other the reference segment
     * @ return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment2 other)
    {
        return this.getLength() > other.getLength();
    }
    /**
     * Check if a point is located on the segment.
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p)
    {
        if (p.getY() == this.getCenter().getY())
            return (this.getCenter().getX() + _length > p.getX() || this.getCenter().getX() - _length < p.getX());
        else
            return false;
    }
    /**
     * Change the segment size by moving the right point by delta. Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta the length change.
     */    
    public void changeSize(double delta){
        Point leftPoint = getPoLeft();
        _length = _length + delta;
        _poCenter.setX(leftPoint.getX()+_length/2);
    }
    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other the reference segment
     * @return The overlap size.
     */
    public double overlap(Segment2 other)
    {
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
    public double trapezePerimeter(Segment2 other)
    {
        return (other.getLength() + this.getLength() + this.getPoLeft().distance(other.getPoLeft()) + this.getPoRight().distance(other.getPoRight()));
    }
}
