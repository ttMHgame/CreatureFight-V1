import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage buttonImage1 = new GreenfootImage(100, 50);
    private GreenfootImage buttonImage2 = new GreenfootImage(100, 50);
    
    private boolean justClicked = false;
    
    //TODO (45): Add an integer instance variable called value that is not initialized
    int value;
    
    /**
     * Default constructor for objects of the Button class
     * 
     * @param There are no parameters
     * @return an object of the Button type
     */
    public Button()
    {
        GreenfootImage text1 = new GreenfootImage(100 , 50);
        GreenfootImage text2 = new GreenfootImage(100 , 50);

        //TODO (46): Initialize the value of the Button to be 50
        value = 50;

        buttonImage1.setColor(Color.BLUE);
        buttonImage1.fillRect(0, 0, 100, 50);
        text1.setColor( Color.WHITE );
        text1.setFont( new Font( "Helvetica", true, false, 30 ) );
        text1.drawString("" + value, text1.getWidth()/3 + 1, text1.getHeight()/2 + 8);
        //TODO (47): Remove the two slashes on the above line when all previous code is complete

        buttonImage1.drawImage( text1, 0, 0 );

        buttonImage2.setColor( Color.MAGENTA );
        buttonImage2.fillRect(0, 0, 100, 50);
        text2.setColor( Color.BLACK );
        text2.setFont( new Font( "Helvetica", true, false, 30 ) );
        text2.drawString("" + value, text2.getWidth()/3 + 1, text2.getHeight()/2 + 8);
        //TODO (48): Remove the two slashes on the above line when all previous code is complete

        buttonImage2.drawImage( text2, 0, 0 );

        setImage( buttonImage1 );
    }

    /**
     * Button constructor that allows for customization of Button objects
     * 
     * @param c is the Color that the Button will have
     * @param v is the numerical value that is associated with the button
     * @return an object of the Button type
     */
    public Button( Color c, int v )
    {
        GreenfootImage text1 = new GreenfootImage(100 , 50);
        GreenfootImage text2 = new GreenfootImage(100 , 50);
        
    

        if( c.equals( Color.RED ) )
        {
            //TODO (49): Set value to be -v, since a red button means we are taking away health
            value = -v;
        }
        else
        {
            //TODO (50): Set value to be v because every other color means we are adding health
            value = v;
        }

        buttonImage1.setColor(c);
        buttonImage1.fillRect(0, 0, 100, 50);
        text1.setColor( Color.WHITE );
        text1.setFont( new Font( "Helvetica", true, false, 30 ) );
        text1.drawString("" + value, text1.getWidth()/3 + 1, text1.getHeight()/2 + 8);
        //TODO (51): Remove the two slashes on the above line when all previous code is complete

        buttonImage1.drawImage( text1, 0, 0 );

        buttonImage2.setColor( Color.BLACK );
        buttonImage2.fillRect(0, 0, 100, 50);
        text2.setColor( Color.WHITE );
        text2.setFont( new Font( "Helvetica", true, false, 30 ) );
        text2.drawString("" + value, text2.getWidth()/3 + 1, text2.getHeight()/2 + 8);
        //TODO (52): Remove the two slashes on the above line when all previous code is complete

        buttonImage2.drawImage( text2, 0, 0 );

        setImage( buttonImage1 );
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld world = (CreatureWorld) getWorld();
        Creature enemy;
        if( getObjectsInRange(200,Creature.class).get(0).getPlayerOwner()==1){
            enemy = world.getPlayerOne();
        } else {
            enemy = world.getPlayerTwo();
            
        }
        if( justClicked == true )

            {

                

                enemy.getHealthBar().add( value );

                justClicked = false;

            }
         

        
    }    
}
