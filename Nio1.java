
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio1 {

	public static void main(String[] args) throws IOException {
		String currentPath=System.getProperty("user.dir");
		String copyPath=currentPath+"\\src\\copy.txt";
		String pastePath=currentPath+"\\src\\paste.txt";
		
		FileInputStream fis=new FileInputStream(new File(copyPath));
		FileOutputStream fos=new FileOutputStream(new File(pastePath));
		
		FileChannel fc_in=fis.getChannel();
		FileChannel fc_out=fos.getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		
		while(true){
			buffer.clear();
			
			int n=fc_in.read(buffer);
			if (n==-1) {
				break;
			}
			
			buffer.flip();
			fc_out.write(buffer);
			
		}
		
		System.out.println("over!");
	}
	
}
