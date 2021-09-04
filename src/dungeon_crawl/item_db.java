/**
 * 
 */
package dungeon_crawl; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author user
 *
 */
public class item_db {
	/*
//examples of opening a file	 
	File itemdb = new File("item.db");
    boolean err = itemdb.exists();
    if (!err) {
    	System.out.println("Failed to load item.db");
    } else {
    	System.out.println("Loaded item.db");
    	FileDescriptor in = new FileDescriptor();
    }
    */
	public item_db() throws FileNotFoundException {
		;
	}
	public int items_db[][][] = new int[255][3][255];

	int comma = 0;
	int letter = 0;
	int i = 0; 
	int data;
	
    FileReader fr = new FileReader("item.db");   
    public int load (){
    	try {
		
    		data = fr.read();
			while(data != -1) {
		        if (data != ','){
		    	   if (comma == 0 ) {
		    		   items_db[i][0][letter] = data;
		    		   letter++;
		    	   } else if (comma == 1){
		    		   items_db[i][1][letter] = data;
		    		   letter++;
		    	   } else if (comma == 2){
		    		   items_db[i][2][letter] = data;
		    	   }
		       }  else {
		    	   letter=0;
		    	   comma++; 
		       }
		       if (data == '\n' ) {
		    	   comma=0;//forgot this little guy
		    	   i++;
		       } 
			  data = fr.read();
			}
			fr.close(); 
    	} catch (IOException e) {
			// TODO Auto-generated catch block
    		e.printStackTrace();
    		return 1;
		}
    	finally{
    	}
    	return 0;
    }
}
