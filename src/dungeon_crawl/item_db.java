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
	public char items_db[][][] = new char[255][3][255];
	public int size;
	int comma = 0;
	int letter = 0;
	int i = 0; 
	char data;
	
	public void list() {
		int i=0;
		int word = 0;
		for(i=0;i<size;++i){
			while (items_db[i][1][word]=='\0') {
				System.out.print(items_db[i][1][word]);
				word++; 
			}
			System.out.println(":" + i );
		}
	}
    FileReader fr = new FileReader("item.db");   
    public int load (){
    	try {
		
    		data = (char) fr.read();
			while(data != -1) {
		        if (data != ','){
		    	   if (comma == 0 ) {//i is the unique number for each item
		    		   items_db[i][0][letter] = data;//item type (corrispones to 0)
		    		   System.out.print( items_db[i][0][letter]);
		    		   letter++;
		    	   } else if (comma == 1){
		    		   items_db[i][1][letter] = data;//player trait (corrispones to 1)
		    		   System.out.print(items_db[i][1][letter]);
		    		   letter++;
		    	   } else if (comma == 2){
		    		   items_db[i][2][letter] = data;//item type id number (corrispones to 2)
		    		   System.out.print(items_db[i][2][letter]);
		    	   }
		       }  else {
		    	   letter=0;
		    	   System.out.print(",");
		    	   comma++; 
		       }
		       if (data == '\n' ) {
		    	   System.out.println("LOAD");
		    	   comma=0;//forgot this little guy
		    	   i++;
		       } 
		       if (data != ';'){
		    	   //end of file
		    	   break;
		       }
			  data = (char) fr.read();
			}
			size = i;
			//fr.close(); 
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
