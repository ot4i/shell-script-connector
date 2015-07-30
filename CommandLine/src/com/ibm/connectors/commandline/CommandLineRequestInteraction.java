/*
Copyright 2015 IBM Corporation 
Author Oliver Wynn
 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the MIT License
  which accompanies this distribution, and is available at
  http://opensource.org/licenses/MIT
 
  Contributors:
      Oliver Wynn - initial implementation v0.1
*/

package com.ibm.connectors.commandline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;



import com.ibm.connectors.AbstractRequestInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;

public class CommandLineRequestInteraction extends AbstractRequestInteraction {

	@Override
	public long asyncRequest(Properties arg0, Object arg1,
			ConnectorCallback arg2) throws ConnectorException {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String readOutput(InputStream output){
		   
		   String message = null;
		   BufferedReader bfReader = new BufferedReader(new InputStreamReader(output)); 
		   StringBuffer buffer = new StringBuffer();
	    String line = null;
	    try {
	 	   while ( (line = bfReader.readLine()) != null) {
			       buffer.append(line + "\n");
			   }
	    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    }
	    message = buffer.toString();
		   
		   return message;
	}
	
	@Override
	public Object request(Properties properties, Object arg1)
			throws ConnectorException {

		
        
        String command = properties.getProperty("command");
        String Out = "";
        
        if(command == null || command == ""){
        	Out = "<Result><message>No Command given</message></Result>";
        	
        }else{
			Runtime rt = Runtime.getRuntime();
			String outMsg = null;
			String errorMsg = null;
	  
			Process pr = null;
			try {
				pr = rt.exec(command);
				InputStream Output = pr.getInputStream();
				InputStream error = pr.getErrorStream();
				
			outMsg = readOutput(Output);
			errorMsg = readOutput(error);
			Out = "<Result><command>"+command+"</command><output><![CDATA[" + outMsg +" ]]></output><error><![CDATA[" + errorMsg +"]]></error></Result>";
			} catch (IOException e) {
				Out = "<Result><command>"+command+"</command><error><![CDATA["+e.toString()+"]]></error></Result>";
			}
					
        }
	        
        byte[] responseBytes = Out.getBytes();
        return responseBytes;
	}
}
