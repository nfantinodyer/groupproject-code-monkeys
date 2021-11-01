import java.io.*;

public class LeaderBoard {
	private String name;
	private String mapSize;
	private int score;
	

	LeaderBoard(String n,String m, int s){
		name = n;
		mapSize = m;
		score = s;
		writeFile();
	}
	public static void main(String[] args) {
		new LeaderBoard("name","small",25);
	}
	public void writeFile()
	{

	    try
	    {
	        Writer output = null;
	        File file = new File("leaderboard.txt");
	        output = new BufferedWriter(new FileWriter(file));

	        String toWrite = "\nIGNORE\n";
	        output.append(toWrite);
	        

	        output.close();
	        System.out.println("File has been written");

	    }catch(Exception e)
	    {
	        System.out.println("Could not create file");
	    }
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void setSize(String M) {
		mapSize = M;
	}
	public String getName() {
		return name;
	}
	public String getMapSize() {
		return mapSize;
	}
	public int getScore() {
		return score;
	}
}
