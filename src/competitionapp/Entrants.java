package competitionapp;

public class Entrants implements Comparable<Entrants> 
{/*Entrants implements comparable to allow the value of score to be compared.
  *This entrant class
  */
    
    private String surname;
    private double score, percentage;
    
    public void setSurname(String surname)
    {//Sets the entrant's surname.
        this.surname = surname; 
    }
    
    public String getSurname()
    {//Returns the entrant's surname.
        return surname;
    }

    public void setScore(double score, double maxScore)
    {//Takes an entrant's score and a competition's max score. 
        
        this.score = score;//Sets the entrant's score.
        percentage = 100*(score/maxScore);//Sets the entrant's percentage.
        
    }
    
    public int getScore()
    {//Returns the entrant's score.
        return (int)score;
    }
    
    public int getPercentage()
    {//Returns the entrant's percentage.
        return (int)percentage;
    }
    
    public int compareTo(Entrants compareEntrants)
    {//Allows each entrants score to be sorted in ascending order.
        
        double compareScores = ((Entrants) compareEntrants).getScore();
        return (int)(this.score - compareScores);
 
    }

}

