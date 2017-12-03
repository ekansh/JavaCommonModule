package io.write;

import java.io.File;
import java.io.FileOutputStream;

public class WriteFileUsingByteInputStream {
public static void main(String[] args) {
	
	
	
	readContentIntoByteArray(new File("res/input3.txt"));
	
	
	
}
private static byte[] readContentIntoByteArray(File file)
{
  FileOutputStream fos = null;
  byte[] bFile = "hello world".getBytes();
  try
  {
     //convert file into array of bytes
	  fos = new FileOutputStream(file);
	  fos.write(bFile);
	  fos.close();
  }
  catch (Exception e)
  {
     e.printStackTrace();
  }
  return bFile;
}
}
