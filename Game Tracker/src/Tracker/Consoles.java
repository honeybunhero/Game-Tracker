package Tracker;

import java.util.ArrayList;

public class Consoles 
{
	int gamesTotal;
	public String consoleName;
	ArrayList<String> gamesList = new ArrayList<>();
	
	public void getConsoleName() 
	{
		System.out.println("\"" + consoleName + "\"");
	}
	
	public void setConsoleName(String name) 
	{
		this.consoleName = name;
	}
}
