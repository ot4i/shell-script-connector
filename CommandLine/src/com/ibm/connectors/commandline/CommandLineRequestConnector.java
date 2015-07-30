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

import com.ibm.connectors.AbstractRequestConnector;

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

