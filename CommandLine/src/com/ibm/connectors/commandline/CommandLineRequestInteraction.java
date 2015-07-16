package com.ibm.connectors.commandline;

import java.io.IOException;
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

	@Override
	public Object request(Properties properties, Object arg1)
			throws ConnectorException {

		Runtime rt = Runtime.getRuntime();
        RuntimeExec rte = new RuntimeExec();
        com.ibm.connectors.commandline.RuntimeExec.StreamWrapper error, output;
        
        String command = properties.getProperty("command");
        String Output = "";
        
        if(command == null || command == ""){
        	Output = "<Result><message>No Command given</message></Result>";
        	
        }else{
	        
	        try {
                Process proc = rt.exec(command);
                error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
                output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
                int exitVal = 0;
                error.start();
                output.start();
                error.join(3000);
                output.join(3000);
                exitVal = proc.waitFor();
                Output = "<Result><command>"+command+"</command><output><![CDATA[" + output.message +" ]]></output><error><![CDATA[" + error.message +"]]></error></Result>";
	        } catch (IOException e) {
	                    Output = "<Result><command>"+command+"</command><error><![CDATA["+e.toString()+"]]></error></Result>";
	        } catch (InterruptedException e) {
	                    Output = "<Result><command>"+command+"</command><error><![CDATA["+e.toString()+"]]></error></Result>";
	        }
        }
        
        byte[] responseBytes = Output.getBytes();
        return responseBytes;
	}
}
