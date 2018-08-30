package Tracker;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
//import java.io.IOException;

// TO DO
// Small Test!

public class GameTracker 
{
	public static int totalGamesCount;
	public static Scanner userInput = new Scanner(System.in);
	
	public static Consoles Playstation1 = new Consoles();
	public static Consoles Playstation2 = new Consoles();
	public static Consoles Playstation3 = new Consoles();
	public static Consoles Playstation4 = new Consoles();
	public static Consoles PSP = new Consoles();
	public static Consoles PSVita = new Consoles();
	
	public static Consoles GBC = new Consoles();
	public static Consoles GBA = new Consoles();
	public static Consoles NDS = new Consoles();
	public static Consoles N3DS = new Consoles();
	public static Consoles NES = new Consoles();
	public static Consoles SNES = new Consoles();
	public static Consoles N64 = new Consoles();
	public static Consoles Gamecube = new Consoles();
	public static Consoles Wii = new Consoles();
	public static Consoles WiiU = new Consoles();
	public static Consoles NintendoSwitch = new Consoles();
	
	public static Consoles Xbox = new Consoles();
	public static Consoles Xbox360 = new Consoles();
	public static Consoles XboxOne = new Consoles();
	
	public static Consoles SegaGameGear = new Consoles();
	public static Consoles SegaGenesis = new Consoles();
	public static Consoles SegaDreamcast = new Consoles();
	public static Consoles SegaSaturn = new Consoles();
	
	public static String selection, gameName, loadText;
	
	static ArrayList <Consoles> consolesList = new ArrayList<>();

	public static void main(String[]args) 
	{
		nameConsoles();
		addConsolesToList();
		FileReader();
		StartProgram();
	}
	public static void FileReader() 
	{
		try {
		    BufferedReader loadReader = new BufferedReader(new FileReader("GamesList.txt"));
		    //String loadText = "";
		    int consoleIndex = -1; // for storing the console index
		    while((loadText = loadReader.readLine()) != null) {
		        // getting the index of loadText from consoleList.
		        // store your consoles name in uppercase in consoleList.
		    	int index = -1;
		    	for(int x = 0; x < consolesList.size();x++) {
		    		if(loadText.equalsIgnoreCase(consolesList.get(x).consoleName)) {
		    			index = x;
		    		}
		    	}
		        if(index != -1){ // if console name is present in loadText
		            consoleIndex = index;
		            continue;
		        }
		        // put game in respected console.
		        consolesList.get(consoleIndex).gamesList.add(loadText);
		    }
		} catch (Exception e) {
		    //System.out.println("This did nothing");
		}
	}
	public static void nameConsoles() 
	{
		Playstation1.setConsoleName("Playstation 1");
		Playstation2.setConsoleName("Playstation 2");
		Playstation3.setConsoleName("Playstation 3");
		Playstation4.setConsoleName("Playstation 4");
		PSP.setConsoleName("Playstation portable");
		PSVita.setConsoleName("Playstation Vita");
		GBC.setConsoleName("Gameboy Color");
		GBA.setConsoleName("Gameboy Advanced");
		NDS.setConsoleName("Nintendo DS");
		N3DS.setConsoleName("Nintendo 3DS");
		NES.setConsoleName("Nintendo Entertainment System");
		SNES.setConsoleName("Super Nintendo Entertainment System");
		N64.setConsoleName("Nintendo 64");
		Gamecube.setConsoleName("Nintendo GameCube");
		Wii.setConsoleName("Nintendo Wii");
		WiiU.setConsoleName("Nintendo WiiU");
		NintendoSwitch.setConsoleName("Nintendo Switch");
		Xbox.setConsoleName("Xbox");
		Xbox360.setConsoleName("Xbox 360");
		XboxOne.setConsoleName("Xbox One");
		SegaGameGear.setConsoleName("Sega GameGear");
		SegaGenesis.setConsoleName("Sega Genesis");
		SegaSaturn.setConsoleName("Sega Saturn");
		SegaDreamcast.setConsoleName("Sega Dreamcast");
	}
	public static void addConsolesToList() 
	{
		consolesList.add(Playstation1); 
		consolesList.add(Playstation2);
		consolesList.add(Playstation3);
		consolesList.add(Playstation4);
		consolesList.add(PSP);
		consolesList.add(PSVita);
		consolesList.add(GBC);
		consolesList.add(GBA);
		consolesList.add(NDS);
		consolesList.add(N3DS);
		consolesList.add(NES);
		consolesList.add(SNES);
		consolesList.add(N64);
		consolesList.add(Gamecube);
		consolesList.add(Wii);
		consolesList.add(WiiU);
		consolesList.add(NintendoSwitch);
		consolesList.add(Xbox);
		consolesList.add(Xbox360);
		consolesList.add(XboxOne);
		consolesList.add(SegaGameGear);
		consolesList.add(SegaGenesis);
		consolesList.add(SegaSaturn);
		consolesList.add(SegaDreamcast);
	}
	public static void StartProgram() 
	{
		OrganizeGameList();
		System.out.println("Welcome. What would you like to do?");
		System.out.println("\"Console\", \"Count\", \"List\" or \"save\"?");
		
		selection = userInput.nextLine();
		
		if(selection.equalsIgnoreCase("Console")) 
		{
			System.out.println();
			System.out.println("Which console would you like to select?");
			
			for(int x = 0; x < consolesList.size(); x++) {
				consolesList.get(x).getConsoleName();
			}
			
			selection = userInput.nextLine();
			
			ConsoleSelection(selection);
		}
		
		else if(selection.equalsIgnoreCase("Count")) 
		
		{
			CountAllGames();
		}
		else if(selection.equalsIgnoreCase("List")) 
		{
			ListAllGames();
		}
		else if(selection.equalsIgnoreCase("Save")) {
			CreateSaveFile("GamesList.txt");
		}
		else 
		{
			System.out.println();
			System.out.println("That wasn't one of the options!");
			System.out.println();
			StartProgram();
		}
	}	
	public static void ConsoleSelection(String select)
	{
	
		if(select.equalsIgnoreCase("Xbox One") || select.equalsIgnoreCase("Xbone")) 
		{
			ConsoleOptions(XboxOne);
		}
		else if(select.equalsIgnoreCase("Playstation 4") || select.equalsIgnoreCase("PS4"))
		{
			ConsoleOptions(Playstation4);
		}
		else if(select.equalsIgnoreCase("Nintendo Switch") || select.equalsIgnoreCase("Switch")) 
		{
			ConsoleOptions(NintendoSwitch);
		}
		else if(select.equalsIgnoreCase("Playstation 1") || select.equalsIgnoreCase("PS1"))
		{
			ConsoleOptions(Playstation1);
		}
		else if(select.equalsIgnoreCase("Playstation 2") || select.equalsIgnoreCase("PS2")) 
		{
			ConsoleOptions(Playstation2);
		}
		else if(select.equalsIgnoreCase("Playstation 3") || select.equalsIgnoreCase("PS3"))
		{
			ConsoleOptions(Playstation3);
		}
		else if(select.equalsIgnoreCase("Playstation Portable") || select.equalsIgnoreCase("PSP")) 
		{
			ConsoleOptions(PSP);
		}
		else if(select.equalsIgnoreCase("Playstation Vita") || select.equalsIgnoreCase("PSVita") || select.equalsIgnoreCase("PSVITA"))
		{
			ConsoleOptions(PSVita);
		}
		else if(select.equalsIgnoreCase("Xbox"))
		{
			ConsoleOptions(Xbox);
		}
		else if(select.equalsIgnoreCase("Xbox360") || select.equalsIgnoreCase("Xbox 360")) 
		{
			ConsoleOptions(Xbox360);
		}
		else if(select.equalsIgnoreCase("Nintendo Entertainment System") || select.equalsIgnoreCase("NES"))
		{
			ConsoleOptions(NES);
		}
		else if(select.equalsIgnoreCase("Super Nintendo Entertainment System 2") || select.equalsIgnoreCase("SNES")) 
		{
			ConsoleOptions(SNES);
		}
		else if(select.equalsIgnoreCase("Nintendo 64") || select.equalsIgnoreCase("N64"))
		{
			ConsoleOptions(N64);
		}
		else if(select.equalsIgnoreCase("Wii")) 
		{
			ConsoleOptions(Wii);
		}
		else if(select.equalsIgnoreCase("WiiU"))
		{
			ConsoleOptions(WiiU);
		}
		else if(select.equalsIgnoreCase("GameCube"))
		{
			ConsoleOptions(Gamecube);
		}
		else if(select.equalsIgnoreCase("Gameboy Color") || select.equalsIgnoreCase("GBC")) 
		{
			ConsoleOptions(GBC);
		}
		else if(select.equalsIgnoreCase("Gameboy Advance") || select.equalsIgnoreCase("GBA"))
		{
			ConsoleOptions(GBA);
		}
		else if(select.equalsIgnoreCase("Nintendo DS") || select.equalsIgnoreCase("NDS")) 
		{
			ConsoleOptions(NDS);
		}
		else if(select.equalsIgnoreCase("Nintendo 3DS") || select.equalsIgnoreCase("N3DS"))
		{
			ConsoleOptions(N3DS);
		}
		else if(select.equalsIgnoreCase("Sega Gamegear")) 
		{
			ConsoleOptions(SegaGameGear);
		}
		else if(select.equalsIgnoreCase("Sega Genesis"))
		{
			ConsoleOptions(SegaGenesis);
		}
		else if(select.equalsIgnoreCase("Sega Saturn")) 
		{
			ConsoleOptions(SegaSaturn);
		}
		else if(select.equalsIgnoreCase("Dreamcast"))
		{
			ConsoleOptions(SegaDreamcast);
		}
		else 
		{
		System.out.println(select + " is not registered as an option! Program resetting!");	
		System.out.println();
		StartProgram();
		}
		
		ConsoleSelection(select);
	}
	public static void ConsoleOptions(Consoles console) 
	{
		System.out.println();
		System.out.println("Would you like to \"add\" a new game, \"count\" the total you have for this console, \"list\", \"remove\" or \"exit\"?");
		
		selection = userInput.nextLine();
		
		if(selection.equalsIgnoreCase("add")) 
		{
			AddGameToList(console);
		}
		else if(selection.equalsIgnoreCase("count")) 
		{
			console.gamesTotal = console.gamesList.size();
			System.out.println("You have " + console.gamesTotal + " " + console.consoleName + " games!");
		}
		else if(selection.equalsIgnoreCase("exit")) 
		{
			StartProgram();
		}
		else if(selection.equalsIgnoreCase("Remove")) 
		{
			RemoveGameFromList(console);
		}
		else if(selection.equalsIgnoreCase("list")) 
		{
			for(int x = 0; x < console.gamesList.size(); x++) 
			{
				console.gamesList.sort(null);
				System.out.println(console.gamesList.get(x));
			}
		}
	}
	public static void AddGameToList(Consoles console) 
	{
		boolean gameAlreadyAdded = false;
		System.out.println();
		System.out.print("Enter the name of the game: ");
		
		gameName = userInput.nextLine();
		
		for(int x = 0; x < console.gamesList.size();x++) 
		{
			if(gameName.equalsIgnoreCase(console.gamesList.get(x))) 
			{
				System.out.println();
				System.out.println("You already have this game added!");
				gameAlreadyAdded = true;
			}
		}
		
		if(!gameAlreadyAdded) 
		{
		console.gamesList.add(gameName);
		System.out.println("You've added \"" + gameName + "\" to your list of games!");
		}
	}
	public static void RemoveGameFromList(Consoles console) 
	{
		Scanner input = new Scanner(System.in);
		for(int x = 0; x < console.gamesList.size(); x++) 
		{
			System.out.println("" + (x+1) + ") " + console.gamesList.get(x));
		}
		
		System.out.println("Select the number of the game you would like to remove");
		int numInput = input.nextInt();
		System.out.println(console.gamesList.get(numInput - 1) + " has been removed!");
		console.gamesList.remove(numInput - 1);
	}	
	public static void CountAllGames()
	{
		System.out.println();
		totalGamesCount = XboxOne.gamesList.size() + Playstation4.gamesList.size() + NintendoSwitch.gamesList.size() + Playstation1.gamesList.size() + Playstation2.gamesList.size()
		 + Playstation3.gamesList.size() + Xbox.gamesList.size() + Xbox360.gamesList.size() + NES.gamesList.size() + SNES.gamesList.size() + N64.gamesList.size() 
		 + Gamecube.gamesList.size() + Wii.gamesList.size() + WiiU.gamesList.size() + PSP.gamesList.size() + PSVita.gamesList.size() + SegaGameGear.gamesList.size() 
		 + SegaGenesis.gamesList.size() + SegaSaturn.gamesList.size() + SegaDreamcast.gamesList.size() + GBC.gamesList.size() + GBA.gamesList.size() 
		 + NDS.gamesList.size() + N3DS.gamesList.size();
		System.out.println("You have "+ totalGamesCount + " total games across all platforms");
		StartProgram();
	}
	public static void OrganizeGameList() 
	{
		for(int x = 0; x < consolesList.size(); x++) 
		{
			for(int y = 0; y < consolesList.get(x).gamesList.size(); y++) 
			{
				consolesList.get(x).gamesList.sort(null);
			}
		}
	}
	public static void ListAllGames() 
	{
		for(int x = 0; x < consolesList.size();x++) 
		{
			if(consolesList.get(x).gamesList.size() != 0) 
			{
			System.out.println("List of games for " + consolesList.get(x).consoleName + ":");
			}
			for(int y = 0; y < consolesList.get(x).gamesList.size(); y++) 
			{
				System.out.println(y + 1 + ") " + consolesList.get(x).gamesList.get(y));
			}
		}
		StartProgram();
	}
	public static void CreateSaveFile(String filePath) 
	{
		System.out.println("Would you like to save this information? \"yes\" or \"no\"");
		String choice = userInput.nextLine();
		if(choice.equalsIgnoreCase("yes")) 
		{
			try(PrintWriter outStream = new PrintWriter(new FileOutputStream(filePath, false)))
			{
				for(int x = 0; x < consolesList.size();x++) 
				{
					if(consolesList.get(x).gamesList.size() != 0) 
					{
					outStream.println(consolesList.get(x).consoleName);
					}
					for(int y = 0; y < consolesList.get(x).gamesList.size(); y++) 
					{
						outStream.println(consolesList.get(x).gamesList.get(y));
					}
				}
			}
			catch(FileNotFoundException e) 
			{
				System.err.println("That didn't work!");
			}
			System.out.println("Saving complete!");
		}
		StartProgram();
	}
}