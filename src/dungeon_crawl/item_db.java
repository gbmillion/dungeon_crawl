/**
 * 
 */
package dungeon_crawl; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class item_db {
	public item_db() throws FileNotFoundException {
		;
	}
	public String items_db [][]= new String[255][255]; 
	private int size; 
	 
	public int getSize() {
		return size;
	} 
	public void setSize(int size) {
		this.size = size;
	}
	public void list() {
		int i=0; 
		for(i=0;i<this.size;++i){
			System.out.print( this.items_db[i][0]);
			System.out.print( this.items_db[i][1]);
			System.out.println( this.items_db[i][2]); 
			
		}
	}
    FileReader fr = new FileReader("item.db");   
    File file = new File("item.db");
    public void load () throws IOException{
    	System.out.println("Loading the database.");
    	BufferedReader br = new BufferedReader(new FileReader(file));
    	String st;
    	int i=0;
    	while ((st = br.readLine()) != null) { 
        	String[] parts = st.split(","); 
        	this.items_db[i][0]=parts[0]; 
        	this.items_db[i][1]=parts[1]; 
        	this.items_db[i][2]=parts[2]; 
        	i++;
    	}
    	this.setSize(i); 
    }
}
