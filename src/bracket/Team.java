package bracket;

import java.io.FileReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Team {

  private String SEEDS_FILE_PATH = ".//data//seed.csv";
  private String STATS_FILE_PATH = ".//data//stats.csv";

  private int seed;

  private double offense;
  private double defense;
  private double tempo;
  private double luck;
  private double win;

  private String name;

  public Team(String name) throws Exception{
    this.name = name;

    seed = getIntStat(name, STATS_FILE_PATH, "Seed");
    offense = getDoubleStat(name, STATS_FILE_PATH, "AdjO");
    defense = getDoubleStat(name, STATS_FILE_PATH, "AdjD");
    tempo = getDoubleStat(name, STATS_FILE_PATH, "AdjT");
    luck = getDoubleStat(name, STATS_FILE_PATH, "Luck");
    win = getDoubleStat(this.seed, SEEDS_FILE_PATH, "Likelihood of Winning");
  }

  private double getDoubleStat(String name, String filePath, String statName) throws Exception{

    Reader fileReader = new FileReader(filePath);
    Iterable <CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fileReader);
    for(CSVRecord row : records){
      if(name.equals(row.get(0))){
        return Double.parseDouble(row.get(statName));
      }
    }
    throw new Exception("Unable to find stat");
  }

  private double getDoubleStat(int seed, String filePath, String statName) throws Exception{

    Reader fileReader = new FileReader(filePath);
    Iterable <CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fileReader);
    for(CSVRecord row : records){
      if(seed == (Integer.parseInt(row.get(0)))){
        return Double.parseDouble(row.get(statName));
      }
    }
    throw new Exception("Unable to find stat");
  }

  private int getIntStat(String name, String filePath, String statName) throws Exception{

    Reader fileReader = new FileReader(filePath);
    Iterable <CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fileReader);
    for(CSVRecord row : records){
      if(name.equals(row.get(0))){
        return Integer.parseInt(row.get(statName));
      }
    }
    throw new Exception("Unable to find stat");
  }

  public int getSeed() {
    return seed;
  }

  public double getOffense() {
    return offense;
  }

  public double getDefense() {
    return defense;
  }

  public double getTempo() {
    return tempo;
  }

  public double getLuck() {
    return luck;
  }

  public double getWin() {
    return win;
  }

  public String getName() {
    return name;
  }
}
