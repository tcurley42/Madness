package bracket;

public class Game {

	private Team winner;

	public Game(Team team1, Team team2) throws Exception{
      /*System.out.println("ROUND: " + round);
      System.out.println(team1.getName());
      System.out.println(team2.getName());*/
	  //  double seedFactor1 = getSeedFactor(team1.getWin(), team2.getWin(), round);
	  //  double seedFactor2 = getSeedFactor(team2.getWin(), team1.getWin(), round);
	   // double team1_score = pointsScored(team1, team2, seedFactor1);
	   // double team2_score = pointsScored(team2, team1, seedFactor2);

	    double team1_score = pointsScored(team1, team2);
        double team2_score = pointsScored(team2, team1);

	    System.out.println(team1.getName() + "(" + team1.getSeed() + ") scored " + team1_score);
	    System.out.println(team2.getName() + "(" + team2.getSeed() + ") scored " + team2_score);

		if(team1_score >= team2_score){
		  if(Math.abs(team1_score - team2_score) <= 5) {
		    double coin = Math.random();
		    if (coin < 0.5) winner = team2;
		    else winner = team1;
	  }
		  else winner = team1;
		 // winner = team1;

		} else winner = team2;
		System.out.println("Winner: " + this.winner.getName());
	}
	
	/*
	 * Predict the number of points scored by the given team
	 */
	/*private double pointsScored(Team team1, Team team2, double seedFactor) throws Exception{

	  double o1 = team1.getOffense();
	  double l1 = team1.getLuck();
	  double tA = (team1.getTempo() + team2.getTempo())/2;
	  double l2 = team2.getLuck();
	  double d2 = team2.getDefense();
	  
	  return ((o1*(1+l1)+d2*(1-l2))/200)*tA*seedFactor;
	}*/
	
	private double pointsScored(Team team1, Team team2) throws Exception{

      double o1 = team1.getOffense();
      double l1 = team1.getLuck();
      double tA = (team1.getTempo() + team2.getTempo())/2;
      double l2 = team2.getLuck();
      double d2 = team2.getDefense();
      
      return ((o1*(1+l1)+d2*(1-l2))/200)*tA;
    }
	
/*	private double getSeedFactor(double seed1, double seed2, int round) {
	  return (1 +((round*(seed1 - seed2))/18));
	}*/
	
	public Team getWinner(){
		return winner;
	}

}
