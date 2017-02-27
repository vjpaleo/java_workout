/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vising
 */
public class MadLibs {
	
	Scanner scanner = new Scanner(System.in);
	String story;
	String name;
	String noun1;
	String noun2;
	String noun3;
	String adjective1;
	String adjective2;
	String adverb;
	String randomNums;
	Random rand = new Random();
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public String getStory() {
		return this.story;
	}
	
	public String getNoun1() {
		return this.noun1;
	}
	
	public String getNoun2() {
		return this.noun2;
	}
	
	public String getNoun3() {
		return this.noun3;
	}
	
	public String getAdjective1() {
		return this.adjective1;
	}
	
	public String getAdjective2() {
		return this.adjective2;
	}
	
	public String getAdverb() {
		return this.adverb;
	}
	
	public String getRandomNums() {
		return this.randomNums;
	}
	
	// setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStory(String story) {
		this.story = story;
	}
	
	public void setNoun1(String noun1) {
		this.noun1 = noun1;
	}
	
	public void setNoun2(String noun2) {
		this.noun2 = noun2;
	}
	
	public void setNoun3(String noun3) {
		this.noun3 = noun3;
	}
	
	public void setAdjective1(String adjective1) {
		this.adjective1 = adjective1;
	}
	
	public void setAdjective2(String adjective2) {
		this.adjective2 = adjective2;
	}
	
	public void setAdverb(String adverb) {
		this.adverb = adverb;
	}
	
	public void setRandomNums() {
		int num = Math.abs(rand.nextInt()) % 100;
		int index = 0;
		int[] numberHolder = new int[3];
		
		while (index < numberHolder.length) {
			numberHolder[index] = num + index;
			index++;
		}
		
		this.randomNums = "not " + numberHolder[0] + ", not " + numberHolder[1] + ", but " + numberHolder[2];
	}
	
	// Print instructions to player.
	public void printInstructions() {
		System.err.println("Welcome to the MadLibs game. If you type in "
				+ "words, we'll give you a story. Start by typing in a name.");
	}
	
	// Get data from player.
	public void enterName() {
		System.out.println("Enter your name!");
		this.setName(scanner.nextLine());
	}
	
	public void enterNoun1() {
		System.out.println("Give me a noun!");
		this.setNoun1(scanner.nextLine());
	}
	
	public void enterNoun2() {
		System.out.println("Give me another noun!");
		this.setNoun2(scanner.nextLine());
	}
	
	public void enterNoun3() {
		System.out.println("Give me last noun!");
		this.setNoun3(scanner.nextLine());
	}
	
	public void enterAdjective1() {
		System.out.println("I need an adjective!");
		this.setAdjective1(scanner.nextLine());
	}
	
	public void enterAdjective2() {
		System.out.println("I need another adjective!");
		this.setAdjective2(scanner.nextLine());
	}
	
	public void enterAdverb() {
		System.out.println("I need an adverb!");
		this.setAdverb(scanner.nextLine());
	}
	
	public void putStoryTogether() {
		
		String story;
		
		int num = Math.abs(rand.nextInt()) % 2;
		
		if( num % 2 == 0) {
			story = "Jesse and her best friend " + getName() + " went to Disney World Today! "
				+ "They saw a " + this.getNoun1() + " in a show at the Magic Kingdom "
				+ "and ate a " + this.getAdjective1() + " feast for dinner. The next day I"
				+ " ran " + this.getAdverb() + " to meet Mickey Mouse in his " + this.getNoun2() + " "
				+ "and then that night I gazed at the " + this.getRandomNums() + " " + this.getAdjective2() + " "
				+ "fireworks shooting from the " + this.getNoun3() + ".";
		
		} else {
			story = "Myself and " + this.getName() + " went on a walk.";
		}
		
		this.setStory(story);
	}
	
	public void play() {
		this.enterName();
		this.enterNoun1();
		this.enterNoun2();
		this.enterNoun3();
		this.enterAdjective1();
		this.enterAdjective2();
		this.enterAdverb();
		this.setRandomNums();
		this.putStoryTogether();
		System.out.println( this.getStory());
		
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		MadLibs game = new MadLibs();
		game.printInstructions();
		game.play();
	}
	
}
