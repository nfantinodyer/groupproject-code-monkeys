import java.io.*;

public class LeaderBoard {
	private String name;
	private String mapSize;
	private int score;
	

	LeaderBoard(String n,String m, int s){
		name = n;
		mapSize = m;
		score = s;
		File f = new File("leaderboard.txt"); 
		if(!f.exists())
		{
			makeFile();
		}
		else
		{
			writeFile();
			readFile();
		}
	}
	public static void main(String[] args) {
		new LeaderBoard("name","small",25);
	}
	public void makeFile()
	{
		try
		{
			Writer output = null;
		    File file = new File("leaderboard.txt");
		    output = new BufferedWriter(new FileWriter(file));

		    String toWrite = "\n"+name+" "+mapSize+" "+score+" "+"\n";
		    output.append(toWrite);
		        

		    output.close();
		    System.out.println("File has been written");
		}catch(IOException ioe) {}
		

	    
	}
	public void writeFile()
	{
		try
		{
			String filename= "leaderboard.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write("\n"+name+" "+mapSize+" "+score+" "+"\n");
		    fw.close();
		}catch(IOException ioe) {}
		
	}
	public void readFile()
	{
		try
		{
			int ch = 0;
			FileReader fr=null;
	        fr = new FileReader("leaderboard.txt");
	  
	       while ((ch=fr.read())!=-1)
	       {
	    	   System.out.print((char)ch);
	       }
				    
			
		    fr.close();
		}catch(IOException ioe) {}
		
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
