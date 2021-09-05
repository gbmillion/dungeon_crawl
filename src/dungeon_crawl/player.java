/**
 * 
 */
package dungeon_crawl;

import java.io.IOException;
/**
 * @author user
 *
 */
import java.util.Random;
import java.util.Scanner;

public class player { //base class template
	Random rand = new Random(); //instance of random class
	String name[];
	public int Dexterity=rand.nextInt(20);
	public int Stamina=rand.nextInt(20);
	public int Wisdom=rand.nextInt(20);
	public int Strength=rand.nextInt(20);
	public int Intelligence=rand.nextInt(20);
	public int Agility=rand.nextInt(20);
	public int hp=100+rand.nextInt(20);
	public int mana=100+rand.nextInt(20);
	public int inventory[][][] = new int[255][3][255];
	String clas;
	
	public int damage (int dmg) {
		 this.hp = this.hp - dmg;
		 return 0;
	}
	public void template (String class_name) throws IOException {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter a class: "); 
		this.clas = sc.nextLine(); 
		if (this.clas.equals("") ){
			this.clas=class_name;
			System.out.println("Using randomly genorated values for your class.");
		}
		//this is where we add classes
		switch(this.clas) {
		case "mage" :
			System.out.println("You have selected mage.");
			this.Dexterity=10;
			this.Stamina=10;
			this.Wisdom=10;
			this.Strength=10;
			this.Intelligence=18;
			this.Agility=16; 
			break;
		case "fighter" :
			System.out.println("You have selected fighter.");
			this.Dexterity=10;
			this.Stamina=16;
			this.Wisdom=10;
			this.Strength=18;
			this.Intelligence=10;
			this.Agility=10; 
			break;
		case "healer" :
			System.out.println("You have selected healer.");
			this.Dexterity=10;
			this.Stamina=16;
			this.Wisdom=18;
			this.Strength=10;
			this.Intelligence=10;
			this.Agility=10; 
			break;
		case "rouge" :
			System.out.println("You have selected rouge.");
			this.Dexterity=18;
			this.Stamina=10;
			this.Wisdom=10;
			this.Strength=10;
			this.Intelligence=10;
			this.Agility=16; 
			break;
		default:
			   System.out.println("You have selected " + this.clas + ".");
		}
		//sc.close();
	}
}
