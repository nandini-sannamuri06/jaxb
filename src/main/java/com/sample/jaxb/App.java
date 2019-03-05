package com.sample.jaxb;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.sample.jaxb.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

    	String path = "D:\\Practice\\jaxb\\employee.xml";
    	
    	//converting an Employee Object to XML
    	Employee employee = new Employee();
    	Address address = new Address();
    	address.setCity("Hyderabad");
    	address.setLine1("PragathiNagar");
    	address.setLine2("kukatpally");
    	address.setState("Telangana");
    	address.setZipcode(new Long(Long.parseLong("500090")));
    	employee.setAddress(address);
    	employee.setName("Nandini");
    	employee.setSalary(new Double(Double.parseDouble("100000")));
    	employee.setDesignation("S/W Employee");
    	JAXBContext contextObj = JAXBContext.newInstance(Employee.class);  
    	Marshaller marshallerObj = contextObj.createMarshaller();  
    	marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
    	marshallerObj.marshal(employee, new FileOutputStream(path));  
    	
    	//converting an xml to Employee Object
    	File file = new File(path);  
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Employee emp= (Employee) jaxbUnmarshaller.unmarshal(file); 
        System.out.println("Employee Object :::::"+emp.toString());
    	
    
    }
}
