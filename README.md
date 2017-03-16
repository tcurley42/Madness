# Madness
March Madness Algorithm to predict the NCAA Champion

The main method in the Tournament class will generate a bracket consisting of 6 rounds based on the teams.csv file. The method will also print out the teams included in each round (the winners from the previous round). The final round will contain a single unbeaten team which will be the overall champion.

The Game class contains methods to determine the winner when given two teams. This determination is made based upon the adjusted offensive efficiency, adjusted defensive efficiency, adjusted tempo, and luck from Ken Pomeroy's statistics site kenpom.com from the 2016-2017 season. The points scored per team is based on the offensive efficiency of one team compared with the defensive efficiency of their opponent augmented by the average tempo of the two teams, with a bit of luck factored in. There is an element of randomness, given the nature of the NCAA Tournament, by randomizing the winner if the game was determined to be within 5 points. This makes it so the outcome changes every time the algorithm is run.

All statistics are contained in stats.csv file from kenpom.com.


Attribute	Definition
O	Offense Efficiency
D	Defense Efficiency
T	Tempo
S	Seed Factor
L	Luck Factor
R	Round
H	Likelihood of Winning (by Seed)
Score	Estimated score of one team for a given game

Score1 = (((O1) * (1 + L1) + (D2) * (1 – L2)) / 200) * (TA) * (S1)
