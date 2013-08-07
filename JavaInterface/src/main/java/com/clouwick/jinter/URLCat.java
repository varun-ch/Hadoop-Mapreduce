package com.clouwick.jinter;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class URLCat {

	/**
	 * @param args
	 * 
	 */
	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream in = null;
		try {
			in = new URL("hdfs://192.168.1.122/client114/emp").openStream();
			IOUtils.copyBytes(in, System.out, 4096, false);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.closeStream(in);
		}
		

	}

}
