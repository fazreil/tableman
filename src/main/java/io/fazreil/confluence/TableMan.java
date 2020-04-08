package io.fazreil.confluence;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
     * This function takes table and new row element in String HTML format to become a valid DOM
     * @param tableInString representing the table String 
     * @param newRowInString representing the new row String 
     * @return docList which is a list of Document consisting of table and row string which 
     * is transformed into Document
     */
    public List<Document> slurpTable(String tableInString, String newRowInString) 
    {
    	List<Document> docList = new ArrayList<>();
    	Document doSampleContentStr, docSampleNewRowStr;		
		doSampleContentStr = Jsoup.parse(tableInString, "UTF-8", Parser.xmlParser());
		docSampleNewRowStr = Jsoup.parse(newRowInString,"UTF-8", Parser.xmlParser());
    	docList.add(doSampleContentStr);
    	docList.add(docSampleNewRowStr);
		return docList;
    }
    
    /**
     * This function takes the file path for which the table and new row element is in 
     * String HTML format to become a valid DOM
     * @param tableInFile representing the file path for which contains the table String 
     * @param newRowInFile representing the file path for which  contains the new row String 
     * @return docList which is a list of Document consisting of table and row string which 
     * was transformed into Document
     */
    public List<Document> slurpTable(Path tableInFile, Path newRowInFile) {
    	List<Document> docList = new ArrayList<>();
    	String sampleContentFileStr = null, sampleNewRowFileStr = null;
		Document doSampleContentFileEscape = null, docSampleNewRowFileEscape = null;	
		try {
			sampleContentFileStr = new String(Files.readAllBytes(tableInFile), StandardCharsets.UTF_8);
			sampleNewRowFileStr  = new String(Files.readAllBytes(newRowInFile), StandardCharsets.UTF_8);
			sampleContentFileStr = sampleContentFileStr.replace("\\\"", "\"");
			sampleNewRowFileStr = sampleNewRowFileStr.replace("\\\"", "\"");			
			doSampleContentFileEscape = Jsoup.parse(sampleContentFileStr, "UTF-8", Parser.xmlParser());
			docSampleNewRowFileEscape = Jsoup.parse(sampleNewRowFileStr, "UTF-8", Parser.xmlParser());			
			docList.add(doSampleContentFileEscape);
	    	docList.add(docSampleNewRowFileEscape);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return docList;
    }
    
    /**
     * This function is to takes the row element in the form of Document to be inserted
     * into the table element of the Document
     * @param inTableDoc representing the existing table
     * @param inNewRowDoc representing the new table row to insert into the existing table
     * @return inTableDoc which is a Document consisting of the newly inserted row to the
     * existing table
     */
    public Document insertIntoElement(Document inTableDoc, Document inNewRowDoc) 
    {
    	inTableDoc.select("tbody").first().children().next().before(inNewRowDoc.toString());
    	return inTableDoc;
    }
    
    /** 
     * This function prints the structure of the table in the html format
     * @param inDocument take the input parameter as a Document
     * 
     */
    public void print(Document inDocument) 
    {
    	System.out.println(inDocument.html());
    }

    /**
     * This function takes the Document and construct it back to the form of a String
     * @param inDocument take the input parameter as a Document
     * @return inDocument which is a String in the html format
     */
    public String reconstructDocIntoString(Document inDocument)
    {    	
    	return inDocument.html();
    }
        
	/**
     * main program
     * @param args some arguments
     */
	public static void main(String[] args) 
	{
		TableMan tblMan = new TableMan();
		List<Document> docStrList = null, docFileList = null;
		Document docStr = null, docFile = null;
		String htmlStr = null, htmlFile = null;
		
		String tableInStr = "<table class=\"relative-table\" style=\"width: 100.0%;\"><colgroup><col style=\"width: 4.87651%;\" /><col style=\"width: 34.8985%;\" /><col style=\"width: 7.07099%;\" /><col style=\"width: 19.6707%;\" /><col style=\"width: 26.245%;\" /><col style=\"width: 7.23838%;\" /></colgroup><tbody><tr><th colspan=\"2\"><span>SIT Build</span></th><th colspan=\"1\"><span>UAT Build</span></th><th>Bug Fixes</th><th><p>User Story or Features</p></th><th colspan=\"1\">Remarks</th></tr><tr><td colspan=\"2\"><div class=\"content-wrapper\"><p><strong><span class=\"status-macro aui-lozenge aui-lozenge-success conf-macro output-inline\">RELEASED</span></strong><br /><strong>20 Feb 2020</strong></p><p>Version: 1.2.5.6</p><p>Git URL : <a class=\"external-link\" href=\"http://172.30.81.68:3000/DCP/dcpApp.git\" rel=\"nofollow\">http://172.30.81.68:3000/DCP/dcpApp.git</a></p><p>Build: 06</p><p>Git Branch : QRP2_ASNB</p><p>Hash Tag : <a class=\"external-link\" href=\"http://172.30.81.68:3000/DCP/dcpApp/commit/0be686743e1faa8f4db17a612309e9607c48b3dc\" rel=\"nofollow\">0be686743e</a></p><p><a class=\"external-link\" href=\"http://172.30.79.26:8081/artifactory/generic-local/SIT_PROJ2/1.2.5/SIT_2_1.2.5.6.apk\" rel=\"nofollow\">Artifactory</a></p></div></td><td colspan=\"1\"><br /></td><td colspan=\"1\"><div class=\"content-wrapper\"><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-10629\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/secure/viewavatar?size=xsmall&amp;avatarId=10303&amp;avatarType=issuetype\" /></ac:image>DCP2-10629</a> - <span class=\"summary\">DCP2-822 - ASNB - Non whitelisted user showing ASNB dashboard and Accounts page</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-success jira-macro-single-issue-export-pdf\">Closed</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-9265\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/secure/viewavatar?size=xsmall&amp;avatarId=10303&amp;avatarType=issuetype\" /></ac:image>DCP2-9265</a> - <span class=\"summary\">ASNB - Secondary device - Increase Investment Limits, authorization in-progress is not displayed.</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Reopened</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-9920\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/secure/viewavatar?size=xsmall&amp;avatarId=10303&amp;avatarType=issuetype\" /></ac:image>DCP2-9920</a> - <span class=\"summary\">DCP2-1202 - Fund Name is not automatically populated in the Top up details screen when navigated from Fund details screen</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-success jira-macro-single-issue-export-pdf\">Closed</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1095\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1095</a> - <span class=\"summary\">MBK : ASNB (2) Account Details</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1202\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1202</a> - <span class=\"summary\">MBK : ASNB (3) Transaction Details</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-success jira-macro-single-issue-export-pdf\">Development - Done</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1490\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1490</a> - <span class=\"summary\">MBK : Account listing page to include ASNB</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span> </p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-822\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-822</a> - <span class=\"summary\">ASNB - Whitelisting Pilot Users</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-success jira-macro-single-issue-export-pdf\">Developme</span></p></div></td><td colspan=\"1\"><div class=\"content-wrapper\"><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1371\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1371</a> - <span class=\"summary\">MBK ASNB - Manage Favourites - Landing Page</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1803\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1803</a> - <span class=\"summary\">MBK ASNB - Search Favourite Function</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1804\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1804</a> - <span class=\"summary\">MBK ASNB - Filter Pills</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span> </p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1376\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1376</a> - <span class=\"summary\">MBK ASNB - Unified Manage Favourites - No Positive Match</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1377\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1377</a> - <span class=\"summary\">MBK ASNB - Unified Manage Favourites - Positive Match</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1391\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1391</a> - <span class=\"summary\">MBK ASNB - Favourite Investment Account Display on Favourites Landing Page</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1392\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1392</a> - <span class=\"summary\">MBK ASNB - View Favourite Profile </span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span> </p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1398\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1398</a> - <span class=\"summary\">MBK ASNB - Edit Favourite ASNB </span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1404\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1404</a> - <span class=\"summary\">MBK ASNB - Successfully Save Edited Favourite</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1405\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1405</a> - <span class=\"summary\">MBK ASNB - Successfully Delete Existing Favourite</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1412\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1412</a> - <span class=\"summary\">MBK ASNB - Select Type of Favourite Investment </span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1421\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1421</a> - <span class=\"summary\">MBK ASNB - Add New ASNB Favourite (Details)</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1468\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1468</a> - <span class=\"summary\">MBK ASNB - Select Type of Favourite to Add</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1439\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1439</a> - <span class=\"summary\">MBK ASNB - Add New ASNB Favourite (Dropdown Select ID Type)</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Development - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1513\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1513</a> - <span class=\"summary\">MBK ASNB - Add New ASNB Favourite (Additional Details After API Call)</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-2519\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-2519</a> - <span class=\"summary\">MBK ASNB - Add Favourite Confirmation Screen</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1460\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1460</a> - <span class=\"summary\">MBK ASNB - Secure Plus (0) - Approve Reject Master</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1497\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1497</a> - <span class=\"summary\">MBK ASNB - Secure Plus Retry (Secondary Device)</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1498\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1498</a> - <span class=\"summary\">MBK ASNB - Secure Plus fall back to OTP (Secondary Device) </span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1499\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1499</a> - <span class=\"summary\">MBK ASNB - One-Time Password (OTP) Messaging</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1464\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1464</a> - <span class=\"summary\">MBK ASNB - Fail Screen for Authorisation Rejection</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1465\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1465</a> - <span class=\"summary\">MBK ASNB - Add Successful Screen Post-Authorisation/OTP</span> <span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p></div></td><td colspan=\"1\"><br /></td></tr></tbody></table>";
		String newRowInStr = "<tr><td colspan=\"2\"><div class=\"content-wrapper\"><p><strong><span class=\"status-macro aui-lozenge aui-lozenge-success conf-macro output-inline\">RELEASED</span></strong><br /><strong>20 Feb 2020</strong></p><p>Version: 1.3</p><p>Git URL : <a class=\"external-link\" href=\"http://172.30.81.68:3000/DCP/dcpApp.git\" rel=\"nofollow\">http://172.30.81.68:3000/DCP/dcpApp.git</a></p><p>Build: 10</p><p>Git Branch : QRP3_ASNB</p><p>Hash Tag : <a class=\"external-link\" href=\"http://172.30.81.68:3000/DCP/dcpApp/commit/0be686743e1faa8f4db17a612309e9607c48b3dc\" rel=\"nofollow\">0be686743e</a></p><p><a class=\"external-link\" href=\"http://172.30.79.26:8081/artifactory/generic-local/SIT_PROJ2/1.2.5/SIT_2_1.2.5.6.apk\" rel=\"nofollow\">Artifactory</a></p></div></td><td colspan=\"1\"><br /></td><td colspan=\"1\"><div class=\"content-wrapper\"><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-10629\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/secure/viewavatar?size=xsmall&amp;avatarId=10303&amp;avatarType=issuetype\" /></ac:image>DCP2-10629</a> - <span class=\"summary\">DCP2-822 - ASNB - Non whitelisted user showing ASNB dashboard and Accounts page</span><span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-success jira-macro-single-issue-export-pdf\">Closed</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-9265\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/secure/viewavatar?size=xsmall&amp;avatarId=10303&amp;avatarType=issuetype\" /></ac:image>DCP2-9265</a> - <span class=\"summary\">ASNB - Secondary device - Increase Investment Limits, authorization in-progress is not displayed.</span><span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Reopened</span></p></div></td><td colspan=\"1\"><div class=\"content-wrapper\"><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1371\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1371</a> - <span class=\"summary\">MBK ASNB - Manage Favourites - Landing Page</span><span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">Code Review</span></p><p><a class=\"jira-issue-key\" href=\"http://172.30.81.66:8080/browse/DCP2-1803\"><ac:image ac:class=\"icon\"><ri:url ri:value=\"http://172.30.81.66:8080/images/icons/issuetypes/story.svg\" /></ac:image>DCP2-1803</a> - <span class=\"summary\">MBK ASNB - Search Favourite Function</span><span class=\"aui-lozenge aui-lozenge-subtle aui-lozenge-current jira-macro-single-issue-export-pdf\">SIT - In Progress</span></p> </div></td><td colspan=\"1\"><br /></td></tr>";
		
		Path tableInFile = Paths.get("C:\\Users\\naree\\Documents\\GitHub\\tableman\\sample-content.xml");
		Path newRowInFile = Paths.get("C:\\Users\\naree\\Documents\\GitHub\\tableman\\sample-new-row.xml");
		
		docStrList = tblMan.slurpTable(tableInStr, newRowInStr);
		docStr = tblMan.insertIntoElement(docStrList.get(0), docStrList.get(1));
		htmlStr = tblMan.reconstructDocIntoString(docStr);
		tblMan.print(docStr);
		
		docFileList = tblMan.slurpTable(tableInFile, newRowInFile);
		docFile = tblMan.insertIntoElement(docFileList.get(0), docFileList.get(1));
		htmlFile = tblMan.reconstructDocIntoString(docFile);
		tblMan.print(docFile);
		
	}
}
