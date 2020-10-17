package io.fazreil.confluence;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/**
 * This class manipulates the Table class.
 *
 */
public class TableMan 
{
	/**
	 * the html table in the form of document
	 */
	private Document tableDoc = null;
    
	/**
     * This function takes table in String HTML format to become a valid DOM
     * @param tableInString representing the table String 
     * @return doc the document after slurping
     */
    public Document slurpTable(String tableInString) 
    {
    	Document doc = null;		
    	doc = Jsoup.parse(tableInString, "UTF-8", Parser.xmlParser());
		return doc;
    }
    
    /**
     * This function takes the  HTML table file path to become a valid DOM
     * @param tableInFile representing the file path for which contains the table String 
     * @return doc the document after slurping
     */
    public Document slurpTable(Path tableInFile) 
    {
    	String tableInFileStr = null;
		Document doc = null;	
		try {
			tableInFileStr = new String(Files.readAllBytes(tableInFile), StandardCharsets.UTF_8);
			tableInFileStr = tableInFileStr.replace("\\\"", "\"");
			doc = Jsoup.parse(tableInFileStr, "UTF-8", Parser.xmlParser());			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doc;
    }

    /**
     * This function is to takes the new row element to be inserted into the table element
     * of the table Document
     * @param newRowInStr representing the new table row to insert into the existing table
     * @return doc which is a Document consisting of the newly inserted row to the
     * existing table
     */
    public Document insertIntoElement(String newRowInStr) 
    {
    	Document doc = getTableDoc();
    	doc.select("tbody").first().children().next().before(newRowInStr);
    	return doc;
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
     * get for Document doc
     * @return tableDoc the table document itself
     */        
	public Document getTableDoc() {
		return tableDoc;	
	}

	/**
     * set for Document doc
     * @param tableDoc an instance of document like itself
     */
	public void setTableDoc(Document tableDoc) {
		this.tableDoc = tableDoc;	
	}

	/**
     * main program
     * @param args some arguments
     */
    public static void main( String[] args )
    {
    	
    }
}
