package com.ibm.connectors.commandline;

import java.util.Properties;

import com.ibm.connectors.AbstractRequestConnector;
import com.ibm.connectors.AbstractRequestInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.RequestConnector;
import com.ibm.connectors.RequestInteraction;

public class CommandLineRequestConnector extends AbstractRequestConnector
implements RequestConnector{

	@Override
	public RequestInteraction createRequestInteraction()
			throws ConnectorException {
		
		return new CommandLineRequestInteraction();
	}

}

