/**
 * Represents 2 dimensional points.
 * Maman 12 Q1
 * @author Irit Amelchenko
 */
public class Point {
    private double _radius;
    private double _alpha;
    private final int FIRST_QUADRANT = 0;
    private int ninetyDegrees = 90;
    //constructors:
    /**
    * Constructor for objects of class Point. Construct a new point with the specified x y coordinates. 
    * If the x coordinate is negative it is set to zero. If the y coordinate is negative it is set to zero.
    * @param _radius the distance between the point and the point (0,0)
    * @param _alpha the degree between r and the axis.
    */
    public Point(double x, double y)
    {
        if (x < FIRST_QUADRANT)
            x = FIRST_QUADRANT;
        if (y < FIRST_QUADRANT)
            y = FIRST_QUADRANT;
            
        if (x == FIRST_QUADRANT) {
            _radius = y;
            _alpha = ninetyDegrees;
        }
        else {
            _radius = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            _alpha = (Math.atan(y/x)*(180/Math.PI));
        }
    }
    /**
     * Constructor for objects of class Point. Copy constructor, construct a point using another point.
     * @param other The point from which to construct the new object
     */
    public Point(Point other)
    {
        if (other!=null)
            _radius = other._radius;
            _alpha = other._alpha;
    }
    /**
     * Check the distance between this point and a given point.
     * @param other The point to check the distance from.
     * @return the distance.
     */
    public double distance(Point other)
    {
        return Math.sqrt(Math.pow(_radius,2)+Math.pow(other._radius,2)-2*_radius*other._radius*(Math.cos(degreesToRadians(_alpha - other._alpha))));
    }
    /**
     * This method returns the x coordinate of the point.
     * @return The x coordinate of the point.
     */
    public double getX()
    {
        return _radius*Math.cos(degreesToRadians(_alpha));
    }
    /**
     * This method returns the y coordinate of the point.
     * @return The y coordinate of the point.
     */
    public double getY()
    {
        return _radius*Math.sin(degreesToRadians(_alpha));
    }
    /**
     * Check if the given point is equal to this point.
     * @param other The point to check equality with.
     * @return True if the given point is equal to this point.
     */
    public boolean equals(Point other)
    {
        return (other._radius == _radius && other._alpha == _alpha);
    }
    /**
     * Check if this point is above a received point.
     * @param other The point to check if this point is above.
     * @return True if this point is above the other point.
     */
    public boolean isAbove(Point other)
    {
        return other.getY() < getY();
    }
    /**
     * Check if this point is below a received point.
     * @param other The point to check if this point is below.
     * @return True if this point is below the other point.
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }
    /**
     * Check if this point is left of a received point.
     * @param other The point to check if this point is left of.
     * @return True if this point is left of the other point.
     */
    public boolean isLeft(Point other)
    {
        return other.getX() > getX();
    }
    /**
     * Check if this point is right of a received point.
     * @param other The point to check if this point is right of.
     * @return True if this point is right of the other point.
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }
   
    /**
     * This method sets the x coordinate of the point. If the new x coordinate is negative the old x coordinate will remain unchanged.
     * @param x The new x coordinate.
     */
    public void setX(double x)
    {
        double prevY = getY();
        if (x > FIRST_QUADRANT) {
            _radius = Math.sqrt(Math.pow(x, 2)+Math.pow(prevY, 2));
            _alpha = (Math.atan(prevY/x)*(180/Math.PI));
        }
    }
    /**
     * This method sets the y coordinate of the point. If the new y coordinate is negative the old y coordinate will remain unchanged.
     * @param y The new y coordinate.
     */
    public void setY(double y)
    {
        double prevX = getX();
        if (y > FIRST_QUADRANT) {
            _radius = Math.sqrt(Math.pow(prevX, 2)+Math.pow(y, 2));
            _alpha = (Math.atan(y/prevX)*(180/Math.PI));   
        }
    }
    /**
    * Returns a string representation of Point in the format (x,y).
    * @overrides toString in class java.lang.Object
    * @return A String representation of the Point.
    */
    public String toString()
    {
        return "(" + Math.round(getX()*10000)/(double)10000 +","+Math.round(getY()*10000)/(double)10000+")";
    }  
    /**
    * Moves a point. If either coordinate becomes negative the point remains unchanged.
    * @param dx The difference to add to x.
    * @param dy The difference to add to y.
    */
    public void move (double dx, double dy)
    {
        if (getX()+dx >=0 && (getY()+dy >=0)) {
            setX(getX()+dx);
            setY(getY()+dy);
            }
    }
    /**
    * Converts degrees to radians.
    * @param degree The number of degrees to convert.
    * @return the number of degrees in radian units.
    */
    private double degreesToRadians(double degree)
    {
        return degree * Math.PI/180;
    }
}