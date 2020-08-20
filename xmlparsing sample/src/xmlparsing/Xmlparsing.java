/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparsing;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.Scanner;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
/**
 *
 * @author vikpatha
 */
public class Xmlparsing {
    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    String datafile="C:\\Users\\vikpatha\\Documents\\NetBeansProjects\\xmlparsing\\src\\xmlparsing\\data.xml";
   Scanner sc=new Scanner(System.in);
    
    public static void main(String...arg){
        Xmlparsing xp=new Xmlparsing();
        Scanner s=new Scanner(System.in);
        int option;
        boolean active=true;
        while(active){
        System.out.println("Choose Option: \n1. Read XML File\n2. Add New Node\n3. Update a Node Value\n0. Exit");
        option=s.nextInt();
        if(option==1){
            xp.readFile();}
        else if(option==2){
            xp.addNode();}
        else if(option==3){
            xp.modifyNode();}
        else if(option==0){
        active=false;
        }
        System.out.println("Enter Choice: ");
        }
        
    
}
    void readFile(){
    try{
        
        DocumentBuilder dbuilder=factory.newDocumentBuilder();
        Document doc=dbuilder.parse(datafile);
        doc.getDocumentElement().normalize();
        
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        Node nNode=doc.getElementsByTagName("department").item(0);
        NodeList nList=nNode.getChildNodes();
        for(int i=0;i<nList.getLength();i++){
        if(nList.item(i).getNodeType()==Node.ELEMENT_NODE){
        Element e=(Element)nList.item(i);
        String tagname=e.getTagName();
        
        System.out.println(tagname+" : "+e.getTextContent());
        }
        }
    }catch(Exception e){e.printStackTrace();}
   
}
    void addNode(){
       try{
           String node, data;
        DocumentBuilder dbuilder=factory.newDocumentBuilder();
        Document doc=dbuilder.parse(datafile);
        Node dept = doc.getElementsByTagName("department").item(0);
        System.out.println("enter node name: ");
        node=sc.nextLine();
        System.out.println("enter node data: ");
        data=sc.nextLine();
        Element newEl = doc.createElement(node);
		newEl.appendChild(doc.createTextNode(data));
		dept.appendChild(newEl);
                
                
         Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(datafile));
	transformer.transform(source, result);
        
        
        }catch(Exception e){e.printStackTrace();}
    
    }
    void modifyNode(){
        try{
            String str, newdata;
        DocumentBuilder dbuilder=factory.newDocumentBuilder();
        Document doc=dbuilder.parse(datafile);
        Node company = doc.getFirstChild();
        Node dept = doc.getElementsByTagName("department").item(0);
        NodeList list = dept.getChildNodes();
        
        System.out.println("Enter node name to update: ");
        str=sc.nextLine();
        System.out.println("Enter the Value: ");
        newdata=sc.nextLine();
        for(int i=0;i<list.getLength();i++){
        Node node=list.item(i);
        
        
        if(str.equalsIgnoreCase(node.getNodeName())){
        node.setTextContent(newdata);
        
        Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(datafile));
	transformer.transform(source, result);
        }}
        }catch(Exception e){e.printStackTrace();}
    
    }
    
}