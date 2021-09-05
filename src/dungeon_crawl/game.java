package dungeon_crawl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 * @author george million
 *
 * Todo: 
 * 	use
 * 	potion
 * 	stats
 * oo
 */

public class game {
	public game() throws FileNotFoundException {
		System.out.println("Error FileNotFoundException.");
	}
	private static void step(player toon, item_db itemdb ){
		Random rand = new Random(); 
		if (rand.nextInt(100) < 30) trap(toon);//30% to hit trap
		else if (rand.nextInt(100) > 90) item( toon,itemdb);//10% chance to get item
	}
	private static void trap(player toon ){
		Random rand = new Random();
		toon.setHp(toon.getHp() - rand.nextInt(10)); 
		System.out.println("You have stepped on a trap, your hp is now " + toon.getHp()  );	
	}
	private static void item( player toon, item_db itemdb ){ 
		Random rand = new Random();
		int item_found=rand.nextInt(itemdb.getSize());
		System.out.println("You have found a " + itemdb.items_db[item_found][0]+".");
		toon.inventory[toon.getInv_size()][0]= itemdb.items_db[item_found][0];
		toon.inventory[toon.getInv_size()][1]= itemdb.items_db[item_found][1];
		toon.inventory[toon.getInv_size()][2]= itemdb.items_db[item_found][2];
		toon.setInv_size( toon.getInv_size() + 1 );
	}
	private static void combat( player toon, int monster_hp){
	int hit_dmg=0, heal=0;
	Random rand = new Random();
	while(monster_hp>0){//combat loop until monster dead
		if (rand.nextInt(100)  > 50){ //monster hits you
			System.out.println("The monster hits you.");
			if(toon.getDexterity() < rand.nextInt(20) ){//use dex to determine if you avoid an attack
				hit_dmg = rand.nextInt(10) ;
				toon.setHp(toon.getHp()-hit_dmg) ;
				System.out.println("You have been hit for "+hit_dmg+".");
				hit_dmg=0; 
			} else {
				System.out.println("You jump out of the way, avoiding damage.");
			}
			if(toon.getHp()<=0){//check players hp & exit if dead
				System.out.println("You have died.");
				System.exit(0);
				break;
			} else {
				System.out.println("Health: "+ toon.getHp());
			}
		} else {
			//you hit monster (or heal yourself)
			if(toon.getWisdom() < rand.nextInt(20)){
				toon.setStamina(toon.getStamina() - 10); 
				if (toon.getStamina()<= 0 ) hit_dmg = toon.getStrength() *  rand.nextInt(5) ;
					else hit_dmg = toon.getStrength() *  rand.nextInt(10) ;
				// if you're out of stamina you do half damage
				monster_hp = monster_hp - hit_dmg;
				System.out.println("You have hit the monster for "+hit_dmg+".");
				hit_dmg=0;
			} else {
				heal = rand.nextInt(10);
				System.out.println("The gods have favor on you, healing you for "+heal+".");
				toon.setHp(toon.getHp()+heal);
			}
		}
		//cast a spell
		if(toon.getIntelligence()>rand.nextInt(20 )){
			if (toon.getMana() > 0){
				hit_dmg = rand.nextInt(10) ;
				monster_hp = monster_hp - hit_dmg;
				System.out.println("Your spell  has hit the monster for "+hit_dmg+".");
				hit_dmg=0;
				toon.setMana(toon.getMana()-10); 
			}

		}
		if (toon.getAgility() > rand.nextInt(20)){//check agil for chance of additional attack
			System.out.println("You dodge a blow and are granted an additional attack.");
			hit_dmg = toon.getStrength() *  rand.nextInt(10) ; 
			monster_hp = monster_hp - hit_dmg;
			System.out.println("You have hit the monster for "+hit_dmg+".");
			hit_dmg=0;
		}
		if(monster_hp<=0){//you have killed the monster, reset player
			System.out.println("The monster is dead.");
			toon.setMana(100); 
			toon.setStamina(100);
			toon.setHp(100);
		}
	}
	} 
	private static void use (player toon) {
		;
	}
	private static void potion( int trait, int buff) {
		;
	}
	/**
	 * @param args
	 * @throws IOException throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		player toon = new player();
		item_db itemdb = new item_db();
		int c1 = 0;
		int[][] map = new int[100][100];
		int i=0;
		int e=0;
		int count=0;
		String input;
		Random rand = new Random(); 

		System.out.println("Welcome to dungeon hack!\nCommands: i[inventory],x[exit],u[use]");
		for(i=0;i<100;++i){
			for(e=0;e<100;++e){
				//squares have a fifty fifty chance to have a random monster value on them
				if (rand.nextInt(100) > 50 ){
					map[e][i]= rand.nextInt(100);//monsters hp up to 100
				} else {
					map[e][i]= 0;
				}
			}
		}
		System.out.print("Generated 100x100 map.\n");
		itemdb.load();
		System.out.println("What would you like your player to be called?");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		input = sc.nextLine(); 
		while(0==0) {
			if (input.equals("") ){
				System.out.println("You must enter a name.");
			} else break;
			input = sc.nextLine();
		}
		toon.setName(input);
		System.out.println("Predefined classes are: mage,fighter,healer,rouge [or enter your own]");
		toon.template("default");
		i=0;
		e = 0; //set starting position
		//main game loop
		while (0==0){ 
			c1 = System.in.read(); 
			switch(c1){ 
			case 'a':
				if (e == 100) {
					System.out.println("You can not go that way.");
				} else {
					e++;
					System.out.print("You have went left[w,a,s,d].\n");
					if(map[e][i]>0){
						combat(toon,map[e][i]);
					} else step(toon,  itemdb);
				}
				break;
			case 's':
				if (i == 0) {
					System.out.println("You can not go that way.");
				} else {
					i--;
					System.out.print("You have gone back[w,a,s,d].\n");
				 	if(map[e][i]>0){
				 		combat(toon,map[e][i]);
					}else step(toon,  itemdb);
				}
				break;
			case 'd':
				if (e == 0) {
					System.out.println("You can not go that way.");
				} else {
					e--;
					System.out.print("You have gone right[w,a,s,d].\n");
				 	if(map[e][i]>0){
				 		combat(toon,map[e][i]);
					}else step(toon,  itemdb);
				}
				break;
			case 'w':
				if (i == 1000) {
					System.out.println("You can not go that way.");
				} else {
					i++;
					System.out.print("You have gone forward[w,a,s,d].\n");
				 	if(map[e][i]>0){
				 		combat(toon,map[e][i]);
					}else step(toon,  itemdb);
				}
				break;
			case 'i':
				for(count=0;count< toon.getInv_size();++count){
					System.out.println(count + " " +toon.inventory[count][0] + " of " + toon.inventory[count][1]);
				}
				
				break;
			case 'l':
				itemdb.list();
				break;
			case 'x':
				//exit(0);
			case 'u':
				//use(&player);//use item in inventory
				break;
			case '\0':
				break;
			default:
				System.out.print("Movement: [w,a,s,d]\n");
			}
		}		
	}
}
