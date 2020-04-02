package io.fazreil.confluence;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import io.fazreil.confluence.table.Table;

/**
 * This class manipulates the Table class.
 *
 */
public class TableMan 
{
	/**
	 * the html table
	 */
	private Table doc;
    
    /**
     * This function takes table in html format in a form of String to become a valid xml DOM
     * @param tableInString the String representing table for the class to slurp
     * @return doc the document after slurping
     */
    public Table slurpTable(String tableInString) {
    	Table doc = null;
    	return doc;
    }
    
    /**
     * This function takes table in html format in a form of a File to become a valid xml DOM
     * @param tableInFile the File representing table for the class to slurp
     * @return doc the document after slurping
     */
    public Table slurpTable(File tableInFile) {
    	Table doc = null;
    	return doc;
    }
    /**
     * This function takes a node to be inserted into Document
     * @param nodeToInsert the node representing the new table row to insert into table
     */
    public void insertIntoElement(Node nodeToInsert) {
    	
    }
    
    /** 
     * Prints the structure of the table
     * 
     */
    public void print() {
    	
    }

    /**
     * This function takes the doc and construct it back to the form of a String
     * @return docInString the xml document represented in String
     */
    public String reconstructDocIntoString(){
    	String docInString = null;
    	
    	return docInString;
    }
    
    /**
     * This function takes a string in xml form and transform it into a node.
     * @param stringOfXML
     * @return emptyElement an empty element
     */
    private Node formANodeFromString(String stringOfXML) {
    	Node tableRowInNode = null;
    	
    	return tableRowInNode;
    }
    
    public static Element createEmptyElement() {
    	Element emptyElement = null;
    	try {
			emptyElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElement("empty");
		}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return emptyElement;
    }
    
    /**
     * pojo get for Document doc
     * @return doc the document itself
     */
    public Table getDoc() {
		return doc;
	}

    /**
     * poje set for Document doc
     * @param doc an instance of document like itself
     */
	public void setDoc(Table doc) {
		this.doc = doc;
	}

	/**
     * main program
     * @param args some arguments
     */
    public static void main( String[] args )
    {
    	
    }
}
