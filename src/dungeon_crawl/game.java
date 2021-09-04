/**
 * 
 */
package dungeon_crawl;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Random;

/**
 * @author george million
 *
 * Todo:
void trap(int * hpp);
void item(struct item invent[100]);
void step(int * hpp, struct item  play[100]); 
void combat(int * hpp, int monster_hp, struct class * player); 
void use(struct class * player);
void potion( int * trait, int buff);

 */

public class game {
	public game() throws FileNotFoundException {
		System.out.println("Error FileNotFoundException.");
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {

		player toon = new player();
		item_db itemdb = new item_db();
		
		// TODO Auto-generated method stu
		int[][] map = new int[100][100];
		int i=0;
		int e=0;
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

		System.out.println("Predefined classes are: mage,fighter,healer,rouge [or enter your own]");
		toon.template("default");


	 	//main game loop
		i=0;
		e = 0; //set starting position
	
		int c1 = 0;
		while (0==0){
			c1 = System.in.read();
			//each movement has a 30 percent chance of hitting a trap
			switch(c1){
			//move in grid
			//call combat check
			case 'a':
				e++;
				System.out.print("You have went left[w,a,s,d].\n");
			/*	if(map[e][i]>0){
					combat(&health,map[e][i],&player);
				} else step(&health,player.inventory);
				*/break;
			case 's':
				i--;
				System.out.print("You have gone back[w,a,s,d].\n");
			/*	if(map[e][i]>0){
					combat(&health,map[e][i],&player);
				}else step(&health,player.inventory);
				*/break;
			case 'd':
				e--;
				System.out.print("You have gone right[w,a,s,d].\n");
			/*	if(map[e][i]>0){
					combat(&health,map[e][i],&player);
				}else step(&health,player.inventory);
				*/break;
			case 'w':
				i++;
				System.out.print("You have gone forward[w,a,s,d].\n");
			/*	if(map[e][i]>0){
					combat(&health,map[e][i],&player);
				}else step(&health,player.inventory);
				*/break;
			case 'i':
				//list inventory
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
			default:
				System.out.print("Movement: [w,a,s,d]\n");
			}
		}		
	}

}
