package com.soe.streams.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serializes a bank or ban kaccout into a file
 * @author Sam
 *
 */
public class Serialization {
	
	public Serialization(){
		
	}
	
	public Serialization(Object object, String filename) throws FileNotFoundException, IOException{
		this.writeObject(object, filename);
	}

	public boolean writeObject(Object object, String filename) throws FileNotFoundException, IOException{
		
		File f = new File(filename);
		if(f.exists())
			return false;
		// Create new ObjectOutputStream
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(object);
		out.close();
		return true;
	}
	
	public Object readObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		File f = new File(filename);
		if(!f.exists())
			return null;
		// Create new ObjectOutputStream
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Object o = in.readObject();
		in.close();
		return o;
	}
}
