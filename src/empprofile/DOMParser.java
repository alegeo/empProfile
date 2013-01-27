package empprofile;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 //import org.w3c.dom.Attr

public class DOMParser {

	
	public static void main(String[] args) {
		try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("profile");
		doc.appendChild(rootElement);
 
		//cv elements
		Element cv = doc.createElement("cv");
		rootElement.appendChild(cv);
 
            //		// set attribute to staff element
            //		Attr attr = doc.createAttribute("id");
            //		attr.setValue("1");
            //		staff.setAttributeNode(attr);

                            // shorten way
                            // staff.setAttribute("id", "1");

                            //name elements
                            Element name = doc.createElement("name");
                            name.setTextContent("Alexandra Georgoudaki");
                            cv.appendChild(name);

                            // address elements
                            Element address = doc.createElement("address");
                            address.setTextContent("Kungshamra 5");
                            cv.appendChild(address);

                            // telephone elements
                            Element telephone = doc.createElement("telephone");
                            telephone.setTextContent("0737217170");
                            cv.appendChild(telephone);

                            // email elements
                            Element email = doc.createElement("email");
                            email.setTextContent("alegeo@kth.se");
                            cv.appendChild(email);

                            // education elements
                            Element education = doc.createElement("education");
                            education.setTextContent("Bachelor Degree in Information "
                                    + "Technology and Telecommunications, 2011");
                            cv.appendChild(education);

                            // language elements
                            Element language = doc.createElement("language");
                            language.setTextContent("English, Swedish");
                            cv.appendChild(language);

                            // qualifications elements
                            Element qualifications = doc.createElement("qualifications");
                            qualifications.setTextContent("Driving license (car)");
                            cv.appendChild(qualifications);

                            // jobType elements
                            Element jobType = doc.createElement("jobType");
                            jobType.setTextContent("Permanent");
                            cv.appendChild(jobType);

                            // desiredPosition elements
                            Element desiredPosition = doc.createElement("desiredPosition");
                            desiredPosition.setTextContent("Software Developer, Web developer, Web designer");
                            cv.appendChild(desiredPosition);

                            // references elements
                            Element references = doc.createElement("references");
                            references.setTextContent("Available upon request");
                            cv.appendChild(references);

                            // motivation elements
                            Element motivation = doc.createElement("motivation");
                            motivation.setTextContent("I am suitable for the position because I enjoy the process of solving problems...");
                            cv.appendChild(motivation);
                
                
                
                //empRecord elements
		Element empRecord = doc.createElement("empRecord");
		rootElement.appendChild(empRecord);

 
                            //empName elements
                            Element empName = doc.createElement("empName");
                            empName.setTextContent("Alexandra Georgoudaki");
                            empRecord.appendChild(name);

                            // workedAt elements
                            Element workedAt = doc.createElement("workedAt");
                            workedAt.setTextContent("Google Inc.");
                            empRecord.appendChild(workedAt);

                            // duration elements
                            Element duration = doc.createElement("duration");
                            duration.setTextContent("18 months");
                            empRecord.appendChild(duration);

                            // year elements
                            Element year = doc.createElement("year");
                            year.setTextContent("2011");
                            empRecord.appendChild(year);

                            // position elements
                            Element position = doc.createElement("position");
                            position.setTextContent("Software Developer");
                            empRecord.appendChild(position);
                            
               //companyInfo elements
		Element companyInfo = doc.createElement("companyInfo");
		rootElement.appendChild(companyInfo);
                
                    //company elements
                    Element company = doc.createElement("company");
                    empRecord.appendChild(company);

 
                            //empName elements
                            Element companyName = doc.createElement("companyName");
                            companyName.setTextContent("Google Inc.");
                            empRecord.appendChild(companyName);

                            // category elements
                            Element category = doc.createElement("category");
                            category.setTextContent("Internet, Computer software");
                            empRecord.appendChild(category);

                            // founders elements
                            Element founders = doc.createElement("founders");
                            founders.setTextContent("Larry Page, Sergey Brin");
                            empRecord.appendChild(founders);

                            // ceo elements
                            Element ceo = doc.createElement("ceo");
                            ceo.setTextContent("Larry Page");
                            empRecord.appendChild(ceo);

                            // location elements
                            Element location = doc.createElement("location");
                            location.setTextContent("Googleplex, Mountain View, California, United States");
                            empRecord.appendChild(location);    
                            
                            // contact elements
                            Element contact = doc.createElement("contact");
                            contact.setTextContent("1-801-456-2435");
                            empRecord.appendChild(contact);  
                            
                //transcript elements
		Element transcript = doc.createElement("transcript");
		rootElement.appendChild(transcript);

 
                            //studentName elements
                            Element studentName = doc.createElement("studentName");
                            studentName.setTextContent("Alexandra Georgoudaki");
                            transcript.appendChild(studentName);

                            // university elements
                            Element university = doc.createElement("university");
                            university.setTextContent("KTH");
                            transcript.appendChild(university);

                            // program elements
                            Element program = doc.createElement("program");
                            program.setTextContent("Master Software Engineering of Distributed Systems");
                            transcript.appendChild(program);

                            // issueDate elements
                            Element issueDate = doc.createElement("issueDate");
                            issueDate.setTextContent("2011");
                            transcript.appendChild(issueDate);

                            // courses elements
                            Element courses = doc.createElement("courses");
                            transcript.appendChild(courses);
                            
                            // course elements
                            Element course = doc.createElement("course");
                            transcript.appendChild(course);
                            
                            // code elements
                            Element code = doc.createElement("code");
                            code.setTextContent("IK2210");
                            transcript.appendChild(code);
                            
                            // title elements
                            Element title = doc.createElement("title");
                            title.setTextContent("Distributed Systems, Basic Course");
                            transcript.appendChild(title);
                            
                            // credits elements
                            Element credits = doc.createElement("credits");
                            credits.setTextContent("7.5");
                            transcript.appendChild(credits);
                            
                            // grade elements
                            Element grade = doc.createElement("grade");
                            grade.setTextContent("A");
                            transcript.appendChild(grade);
                            
                            
                            
               
                
                
                
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("src/empprofile/profile.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("Profile saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}

