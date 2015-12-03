package competitionapp;
import java.util.Scanner;
import java.util.Arrays;

public class Competition {
    
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private Entrants[] winners, entrant;
    private int maxScore, thresholdScore;
    

    Competition(int noOfEntrants)
    {//This constructor takes a value and uses it to create an array or entrants.
        
        entrant = new Entrants[noOfEntrants];//initialises the entrants array.
        
    }
    
    public void setEntrants()
    {/*Cycles through the entrants array setting each entrant's surname and
      *score
      */
        
        for(int i =0; i<entrant.length; i++){
            
            entrant[i] = new Entrants();
            System.out.println("Please enter entrant #" + (i+1) + "'s surname:");
            entrant[i].setSurname(input.next());
            
            System.out.println("Please enter the score achieved by " + 
                    entrant[i].getSurname() + ";");
            entrant[i].setScore(scoreValidate(), maxScore);  
            
        }
    }
    

    public Entrants[] getEntrants()
    {//Sorts the entrants be score ascending. Returns the entrants array.
        
        Arrays.sort(entrant);
        return entrant;
        
    }
    
    
    public void setWinners()
    {//Sets one or more winners.
        
        double hiScore;
        int noOfWinners = 1;
        
        hiScore = entrant[0].getScore();//Sets the high score to the score of 
                                        //the entrant at array position 0.
        
        for(int i=1; i<entrant.length; i++)
        {//Cycles the array changing the high score when a higher score is found.
            if(entrant[i].getScore() > hiScore){
                
                hiScore = entrant[i].getScore();
                noOfWinners = 1;//When a new high score is found the number of 
                                //winners is reset to one.
            }
            else if(entrant[i].getScore() == hiScore){
                
                noOfWinners++;//The score being checked equals the high score
                              //the number of winners is increased.
            }
        }
        
        winners = new Entrants[noOfWinners];//Creates and array long enough to
                                            //store all the winners.
        
        int arrayPos = 0;//Used as the winners array index.
        
        for(int i=0; i<entrant.length; i++)
        {//Runs through entrants array and stores each entrant with the high
         //score, in the winners array.   
            
            if (entrant[i].getScore() == hiScore)
            {
                winners[arrayPos] = entrant[i];
                arrayPos++;//Moves to the next posistion in the winners array.
            }
            
        }
  
    }
    
    public Entrants[] getWinners()
    {//Returns the winners array.   
        return winners;
    }
    
    public void setThreshold(int thresholdScore)
    { //Sets the threshold score.       
        this.thresholdScore = thresholdScore;
    }

    public int getThreshold()
    {//Returns the threshold score.
        return thresholdScore;
    }
    
    public void setMaxScore(int maxScore)
    {//Sets the max score.        
        this.maxScore = maxScore;
    }
    
    public int getMaxScore()
    {//Returns the max score.
        return maxScore;
    }
    
    public int scoreValidate()
    {/*This method asks the user to enter a value. The value is checked to 
      *make sure that an intiger has been entered. The value is checked to make
      *sure that it is between (including) zero and the maximum score.
      *This repeats until an appropritate value is entered.
      */
        boolean intConfirmed = false;
        String inputValue;
        int returnInt = -1;
        
       
        while (intConfirmed == false)
        {
            inputValue = input.next();
            
            try {
                returnInt = Integer.parseInt(inputValue);
            
            } catch (NumberFormatException e) {
           
                returnInt = -1;
            }
            
            if (returnInt < 0 || returnInt > maxScore)
            {
                System.out.println("******************** INPUT ERROR ********************");
                System.out.println("You can only enter an intiger value. \nIt must be"
                        + " zero or more. \nIt can not be more than the max score."
                        + " (" + maxScore + ")");
                System.out.println("******************** INPUT ERROR ********************"
                        + "\nPlease try again:");
            }else
            {
                intConfirmed = true;
            }
            
        }
        
        return returnInt;
    }
    
    
   
}
