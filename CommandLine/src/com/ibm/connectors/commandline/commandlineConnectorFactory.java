package com.ibm.connectors.commandline;

import com.ibm.connectors.AbstractConnectorFactory;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.RequestConnector;

public class commandlineConnectorFactory extends AbstractConnectorFactory {

	

	@Override
	public RequestConnector createRequestConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return new CommandLineRequestConnector();
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "CommandLine Node";
	}

	@Override
	public InputConnector createInputConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputConnector createOutputConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
