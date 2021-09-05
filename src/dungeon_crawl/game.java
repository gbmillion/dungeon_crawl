/**
 * 
 */
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
		//first 
		Random rand = new Random();
		int item_found=rand.nextInt(255);
		
		
		System.out.println("Hellow world" + itemdb.items_db[item_found][0].toString() + itemdb.getSize());
		;
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
		
		// TODO Auto-generated method stu
		int c1 = 0;
		int[][] map = new int[100][100];
		int i=0;
		int e=0;
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
		
		item(toon, itemdb);
		
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
				
				//list inventory
			/*	while (player.inventory[in].amount=='1') {
					System.out.print("%d: %s\n",in,player.inventory[in].type);
					in++;
				}
				in=0;
				*/break;
			case 'l':
					//list item db
					/*	while (player.inventory[in].amount=='1') {
							System.out.print("%d: %s\n",in,player.inventory[in].type);
							in++;
						}
						in=0;
						*/break;
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
