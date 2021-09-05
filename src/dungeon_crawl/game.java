package dungeon_crawl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 * @author george million
 *
 * Todo: 
 * 
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
	private static void combat( player toon, int monster_hp ) {
		;
	}
	private static void use (player toon) {
		;
	}
	private static void potion( int trait, int buff) {
		;
	}
	/**
	 * @param args
	 * @throws IOException 
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
