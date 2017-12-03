package io.read;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileUsingByteInputStream {
public static void main(String[] args) {
	
	
	
	readContentIntoByteArray(new File("res/input.txt"));
	
	
	
//	try(ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get("res/input.txt")))){
//		int content;
//		while ((content = bis.read()) != -1) {
//			// convert to char and display it
//			System.out.println((char) content);
//		}
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
private static byte[] readContentIntoByteArray(File file)
{
	System.out.println("ReadFileUsingByteInputStream.readContentIntoByteArray()");
  FileInputStream fileInputStream = null;
  byte[] bFile = new byte[10];
  try
  {
     //convert file into array of bytes
     fileInputStream = new FileInputStream(file);
     while( fileInputStream.read(bFile)!=-1){
    	 System.out.println("-->"+new String(bFile, Charset.defaultCharset()));
     }
     fileInputStream.close();
  }
  catch (Exception e)
  {
     e.printStackTrace();
  }
  return bFile;
}
}
