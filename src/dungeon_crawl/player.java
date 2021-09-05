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
	private Random rand = new Random(); //instance of random class
	public String name;
	private int Dexterity=rand.nextInt(20);
	private int Stamina=rand.nextInt(20);
	private int Wisdom=rand.nextInt(20);
	private int Strength=rand.nextInt(20);
	private int Intelligence=rand.nextInt(20);
	private int Agility=rand.nextInt(20);
	public int hp=100+rand.nextInt(20);
	public int mana=100+rand.nextInt(20);
	public char inventory[][][] = new char[255][3][255];
	public String clas;
	
	public int damage (int dmg) {
		 this.hp = this.hp - dmg;
		 return 0;
	}
	public void template (String class_name) throws IOException {
		@SuppressWarnings("resource")
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param input the name to set
	 */
	public void setName(String input) {
		this.name = input;
	}
	/**
	 * @return the dexterity
	 */
	public int getDexterity() {
		return Dexterity;
	}
	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(int dexterity) {
		Dexterity = dexterity;
	}
	/**
	 * @return the stamina
	 */
	public int getStamina() {
		return Stamina;
	}
	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(int stamina) {
		Stamina = stamina;
	}
	/**
	 * @return the wisdom
	 */
	public int getWisdom() {
		return Wisdom;
	}
	/**
	 * @param wisdom the wisdom to set
	 */
	public void setWisdom(int wisdom) {
		Wisdom = wisdom;
	}
	/**
	 * @return the strength
	 */
	public int getStrength() {
		return Strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		Strength = strength;
	}
	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return Intelligence;
	}
	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		Intelligence = intelligence;
	}
	/**
	 * @return the agility
	 */
	public int getAgility() {
		return Agility;
	}
	/**
	 * @param agility the agility to set
	 */
	public void setAgility(int agility) {
		Agility = agility;
	}
	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	/**
	 * @return the mana
	 */
	public int getMana() {
		return mana;
	}
	/**
	 * @param mana the mana to set
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}
	/**
	 * @return the clas
	 */
	public String getClas() {
		return clas;
	}
	/**
	 * @param clas the clas to set
	 */
	public void setClas(String clas) {
		this.clas = clas;
	}
}
