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
package com.ibm.connectors.CommandLine;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>CommandLineNodeUDN</I> instance</p>
 * <p></p>
 */
public class CommandLineNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connectors/CommandLine/RequestNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/OS/icons/full/obj16/com/ibm/connectors/CommandLine/ComIbmRequest.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/OS/icons/full/obj30/com/ibm/connectors/CommandLine/ComIbmRequest.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_COMMAND = "command";
	protected final static String PROPERTY_MESSAGEDOMAINPROPERTY = "messageDomainProperty";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(CommandLineNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "CommandLine","","",	"com/ibm/connectors/CommandLine/ComIbmRequest",	"OS"),
			new NodeProperty(CommandLineNodeUDN.PROPERTY_COMMAND,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/CommandLine/ComIbmRequest",	"OS"),
			new NodeProperty(CommandLineNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "XMLNSC","","",	"com/ibm/connectors/CommandLine/ComIbmRequest",	"OS")
		};
	}

	public CommandLineNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_OUT
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>CommandLineNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public CommandLineNodeUDN setConnectorName(String value) {
		setProperty(CommandLineNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>CommandLineNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(CommandLineNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>CommandLineNodeUDN</I> "<I>command</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>command</I>"
	 */
	public CommandLineNodeUDN setCommand(String value) {
		setProperty(CommandLineNodeUDN.PROPERTY_COMMAND, value);
		return this;
	}

	/**
	 * Get the <I>CommandLineNodeUDN</I> "<I>command</I>" property
	 * 
	 * @return String; the value of the property "<I>command</I>"
	 */
	public String getCommand() {
		return (String)getPropertyValue(CommandLineNodeUDN.PROPERTY_COMMAND);
	}

	/**
	 * Set the <I>CommandLineNodeUDN</I> "<I>messageDomainProperty</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>messageDomainProperty</I>"
	 */
	public CommandLineNodeUDN setMessageDomainProperty(String value) {
		setProperty(CommandLineNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>CommandLineNodeUDN</I> "<I>messageDomainProperty</I>" property
	 * 
	 * @return String; the value of the property "<I>messageDomainProperty</I>"
	 */
	public String getMessageDomainProperty() {
		return (String)getPropertyValue(CommandLineNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "CommandLine";
		return retVal;
	};
}
