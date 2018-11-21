import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    //TODO (1): Add an integer instance constant called WIDTH that is initialized to 200
    private final int WIDTH = 200;
    //TODO (2): Add an integer instance constant called HEIGHT that is initialized to 30
    private final int HEIGHT = 30;

    private GreenfootImage frame;
    private GreenfootImage healthBar;

    private Color good;
    private Color warning;
    private Color danger;

        //TODO (3): Create four integer instance variables that are currently not initialized: target, current, max, and speed 
    int target;
    int current;
    int max;
    int speed;
    
    /**
     * Default constructor for objects of the HealthBar class
     * 
     * @param There are no parameters
     * @return an object of the HealthBar type
     */
    public HealthBar()
    {
        //TODO (4): Remove the two slashes in front of the two lines of code that follow once you have finished the code above
        frame = new GreenfootImage(WIDTH, HEIGHT);
        healthBar = new GreenfootImage(WIDTH, HEIGHT);

        frame.setColor( greenfoot.Color.GRAY );
        
        //TODO (5): Remove the two slashes in front of the line of code that follows once you have finished the code above
        frame.fillRect(0, 0, WIDTH, HEIGHT);

        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;

        //TODO (6): Initialize max to be 1000
        max = 1000;
        //TODO (7): Initialize current to be 600
        current = 600;
        //TODO (8): Initialize target to be equal to current
        target = current;
        //TODO (9): Initialize speed to 1
        speed=1;

        updateBar();
    }

    /**
     * Constructor for objects of the HealthBar class that allows for customization
     * 
     * @param c is the current value of health
     * @param m is the maximum health amount
     * @param s is the speed the health bar's health with change at
     * @return an object of the HealthBar type
     */
    public HealthBar(int c, int m, int s)
    {

        //TODO (10): Remove the two slashes in front of the following four lines of code when you are finished the above code
        frame = new GreenfootImage(WIDTH, HEIGHT);
        healthBar = new GreenfootImage(WIDTH, HEIGHT);

        frame.setColor( Color.GRAY );
        frame.fillRect(0, 0, WIDTH, HEIGHT);

        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;

        //TODO (11): Initialize max to m
        max= m;
        //TODO (12): Initialize current to c
        current = c;
        
        //TODO (13): Initialize target as equal to current
        target = current;
        
        //TODO (14): Initialize speed to s
        speed = s;

        updateBar();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //TODO (25): If current is a larger value than our target...
        if(current > target) {
        
            //TODO (26): Take away speed from current and store the new value in current
            current = current - speed;
        
            //TODO (27): If the current value is now less than target...
            if(current < target){
                //TODO (28): Set current equal to target
                current = target;
            }
                
            //TODO (29): Otherwise..
        } else {
            //TODO (30): Add speed to current and store the new value in current
            current = speed +current;
        
            //TODO (31): If the current value is now larger than target...
            
            if(current > target ) {
                
                //TODO (32): Set current equal to target
                current = target;
            }
        }

                
                
        updateBar();
    }

    /**
     * updateBar updates the image of the health bar when the current health
     * changes values
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void updateBar()
    {
        //TODO (15): Remove the two slashes in front of the line of code that follows once you have finished the code above
        GreenfootImage text = new GreenfootImage(WIDTH, HEIGHT);
        
        //TODO (16): Create a double variable called ratio. Set it equal to (current * 1.0) / (max * 1.0)
        double ratio = (current * 1.0)/ (max * 1.0); 
        //TODO (17): Create an int variable caled healthWidth. Set it equal to Math.round(ratio*frame.getWidth()) casted to an int
        int healthWidth = (int)Math.round(ratio*frame.getWidth());
        

        //TODO (18): If the current health value is greater than half of the max health...
        if(current > max/2) {
        
            //TODO (19): Set the healthBar variable's color to good
            healthBar.setColor(good);
        //TODO (20): Otherwise, if the current health value is greater than a quarter of the max health...
        } else if(current > max/4) {
            //TODO (21): Set the healthBar variable's color to warning
            healthBar.setColor(warning);
        } else {
        //TODO (22): Otherwise...
        
            //TODO (23): Set the healthBar variable's color to danger

            healthBar.setColor(danger);
        }
        
        //TODO (24): Remove the pairs of slashes in front of the following lines of code when you are done the above code
        healthBar.clear();
        healthBar.fillRect( 0, 0, healthWidth, HEIGHT );

        text.clear();
        text.setColor( Color.BLACK );
        text.setFont( new Font( "Times New Roman", false, false, 20 ) );
        text.drawString(current + " / " + max, 0, HEIGHT-text.getFont().getSize()/2);

        frame.clear();
        frame.setColor( Color.GRAY );
        frame.fillRect(0, 0, WIDTH, HEIGHT);
        frame.drawImage( healthBar, 0, 0 );
        frame.drawImage( text, WIDTH/3, 0 );

        setImage( frame );
    }

    /**
     * add will change the current value of the health in the health bar
     * 
     * @param change is the amount that the current health will be changed by
     * @return Nothing is returned
     */
    public void add( int change )
    {
        //TODO (33): Add change to target and store the new value in target
        target = target +change;
        //TODO (34): If target is larger than the maximum health value...
        if(target>max) {
            //TODO (35): Set target equal to max
            target = max;
        }
        //TODO (36): If target is less than 0...
        if(target <0){
            //TODO (37): Set target equal to 0
            target = 0;
        }
    }

    /**
     * setTarget will change the target value to whatever the user chooses
     * 
     * @param t is the new, user-chosen target value
     * @return Nothing is returned
     */
    public void setTarget( int t )
    {
        //TODO (38): Remove the pair of slashes in front of this line of code when you are done the above code
        target = t;
    }

    /**
     * setCurrent will change the current value to whatever the user chooses
     * 
     * @param c is the new, user-chosen current value
     * @return Nothing is returned
     */
    public void setCurrent( int c )
    {
        //TODO (39): Remove the pair of slashes in front of this line of code when you are done the above code
        current = c;
    }

    /**
     * setMax will change the maximum value to whatever the user chooses
     * 
     * @param m is the new, user-chosen maximum value
     * @return Nothing is returned
     */
    public void setMax( int m )
    {
        //TODO (40): Remove the pair of slashes in front of this line of code when you are done the above code
        max = m;
    }

    /**
     * setSpeed will change the speed to whatever the user chooses
     * 
     * @param s is the new, user-chosen speed
     * @return Nothing is returned
     */
    public void setSpeed( int s )
    {
        //TODO (41): Remove the pair of slashes in front of this line of code when you are done the above code
        speed = s;
    }

    /**
     * getMax returns the maximum value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the maximum value
     */
    public int getMax()
    {
        //TODO (42): Change this to return max
        return max;
    }

    /**
     * getCurrent returns the current health value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the current health value
     */
    public int getCurrent()
    {
        //TODO (43): Change this to return current
        return current;
    }
    
    /**
     * getTarget returns the target health value for use in other sections of code or for the user's information
     * 
     * @param There are no parameters
     * @return an integer representing the target health value
     */
    public int getTarget()
    {
        //TODO (44): Change this to return target
        return target ;
    }

}
