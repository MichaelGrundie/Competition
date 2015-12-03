package competitionapp;
import java.util.Scanner;


public class CompetitionApp {//This is the main class

    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    static boolean runTime = true;//A reference to repeat the program. (main method)
    
    public static void main(String[] args){
        
        while(runTime == true)//Program ends when this is false.
        {

            Competition competition = new Competition(5);//Creates a new competition and set the number of entrants.

            System.out.println("Please enter the maximum achievable score:");
            competition.setMaxScore(maxScoreValidate());//Sets validate max score.
            System.out.println("Please enter the theshold score:");
            competition.setThreshold(threshScoreValidate(competition.getMaxScore()));//Sets a validated threshold.
            competition.setEntrants();//Sets entrants.
            competition.setWinners();//Sets winners.
            printWinners(competition.getWinners(), competition.getMaxScore());//Prints winners list.
            printScores(competition);//Prints the entrants scores.
            runTime = exitPrompt();//Asks the user if they which to quit or not.
        }
    }
    
    public static void printWinners (Entrants[] winners, int maxScore)
    {/*Takes an array of winners and a max score. Prints each winner and their 
      *score.
      */
        System.out.println("******************************************************");
        
        for (int i=0; i<winners.length; i++ )
        {
            System.out.println("\nWinner " + winners[i].getSurname() + " scored " +
                    (int)winners[i].getScore() + " out of " + maxScore + "\t\t(" + 
                    (int)winners[i].getPercentage() + "%)");
        }
    } 
    
    public static void printScores(Competition competition)
    {/*Takes a reference of the competition and prints the scores of the
      *entrants in that competition.  
      */
        boolean postThreshold = false;
        Entrants[] entrants = competition.getEntrants();
        
        for (int i =0; i<entrants.length; i++)//Cycles through an array or entrants.
        {
            if (i == 0)//Prints the following message before the first score is printed.
            {
                System.out.println("\n******************************************************");
                System.out.println("THESE ENTRANTS DID NOT MEET THE THRESHOLD SCORE:");
                System.out.println("******************************************************\n");
            }else
               
            //Prints the following message before the score of the first person to meet the freshold.    
            if((entrants[i].getScore()>=competition.getThreshold()) && (postThreshold==false))
            {
                System.out.println("\n******************************************************");
                System.out.println("THESE ENTRANTS MET OR SURPASSED THE THRESHOLD SCORE:");
                System.out.println("******************************************************\n");
                postThreshold = true;//Ensures this message only prints once.
            }
            
            System.out.println("Contestant " + entrants[i].getSurname() + " scored "+
                    entrants[i].getScore() + " out of " + competition.getMaxScore() +
                    "\t\t(" + entrants[i].getPercentage() + "%)");
        }
    }
    
    public static boolean exitPrompt()
    {/*This method asks the user to enter a letter. If the exit letter entered,
      *'false' is returned which let the main method know not to run again. 
      *otherwise 'true' is returned and the program repeats.   
      */
        System.out.println("To exit enter 'E' or enter any other character to "
                + "start again:");

        switch (input.next().charAt(0)){
            
            case 'e':
            case 'E':
                return false;
            default:
                return true;
                
        }
      
    }
    
    public static int maxScoreValidate()
    {/*This method takes an input. It validates that input is an integer. It
      *validates the intiger is more than 0. This is repeated until a suitable
      *value is entered. The value is returned.
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
            
            if (returnInt < 1)
            {
                System.out.println("******************** INPUT ERROR ********************");
                System.out.println("You can only enter an intiger value. \nIt must be"
                        + " more than zero.");
                System.out.println("******************** INPUT ERROR ********************"
                        + "\nPlease try again:");
            }else
            {
                intConfirmed = true;
            }
            
        }
        
        return returnInt;
 
    }
    
    
    
    public static int threshScoreValidate(int maxScore)
    {/*This method takes an input. It validates that input is an integer. It
      *validates the intiger is more than 0 but not more than the max score.
      *This is repeated until a suitable value is entered. The value is returned.
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
            
            if (returnInt < 1 || returnInt > maxScore)
            {
                System.out.println("******************** INPUT ERROR ********************");
                System.out.println("You can only enter an intiger value. \nIt must be"
                        + " more than zero. \nIt can not be more than the max score."
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

    
