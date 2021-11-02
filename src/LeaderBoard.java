import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class LeaderBoard {
	private HashMap<Integer,String > easy = new HashMap<Integer,String>();
	private HashMap<Integer,String> medium = new HashMap<Integer,String>();
	private HashMap<Integer,String> hard = new HashMap<Integer,String>();

	LeaderBoard(String n,String m, int s){
		
		easy.put(20, "jj");
		easy.put(23, "hat");
		easy.put(19, "iop");
		
		medium.put(35, "uop");
		medium.put(37, "yike");
		medium.put(31, "pet");
		medium.put(32, "tate");
		
		hard.put(45, "kil");
		hard.put(38, "bad");
		hard.put(47,"chris");
		hard.put(55, "red");
		
		if(m=="easy")
		{
			easy.put(s,n);
		}
		else if(m=="medium")
		{
			medium.put(s,n);
		}
		else
		{
			hard.put(s,n);
		}
		sort();
		
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
		new LeaderBoard("name","easy",25);
	}
	public void makeFile()
	{
		try
		{
			Writer output = null;
		    File file = new File("leaderboard.txt");
		    output = new BufferedWriter(new FileWriter(file));

		    String toWrite = "Easy\n\n"+"Medium\n\n"+"Hard";
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
		    FileWriter fw = new FileWriter(filename,false);
		    fw.write("Easy");
		    for (Entry<Integer, String> mapElement : easy.entrySet()) {
	            int key = mapElement.getKey();
	            String value = (mapElement.getValue());
	  
	            fw.write("\t"+value+" "+key+"\t");
		    }
		    fw.write("\nMedium");
		    for (Entry<Integer, String> mapElement : medium.entrySet()) {
	            int key = mapElement.getKey();
	            String value = (mapElement.getValue());
	  
	            fw.write("\t"+value+" "+key+"\t");
		    }
		    fw.write("\nHard");
		    for (Entry<Integer, String> mapElement : hard.entrySet()) {
	            int key = mapElement.getKey();
	            String value = (mapElement.getValue());
	  
	            fw.write("\t"+value+" "+key+"\t");
		    }
		    
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
	
	public void sort()
	{
		
	}
}
