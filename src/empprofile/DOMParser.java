package empprofile;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParser {
    
    public DOMParser() {
    }
	
    public static void main(String[] args) {
            try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // to make the parser a validating parse
            docFactory.setValidating(true);
            //To parse a XML document with a namespace,
            docFactory.setNamespaceAware(true);
            
            // to ignore cosmetic whitespace between elements.
            docFactory.setIgnoringElementContentWhitespace(true);
            docFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            docFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "profile.xsd");
            
            
            // root element
            Document proDoc = docBuilder.newDocument();
            
            Document cvDoc = createNormalizedDocument(data.get(0));
            Document comDoc = createNormalizedDocument(data.get(1));
            Document eDoc = createNormalizedDocument(data.get(2));
            Document tDoc = createNormalizedDocument(data.get(3));
            
            
            String namespace = "http://www.profile.com/ns/profile";          
            
            Element personalInfo = proDoc.create
            
            
            Element rootElement = proDoc.createElement("profile");
            proDoc.appendChild(rootElement);

            //cv elements
            Element cv = proDoc.createElement("cv");
            rootElement.appendChild(cv);

        //		// set attribute to staff element
        //		Attr attr = proDoc.createAttribute("id");
        //		attr.setValue("1");
        //		staff.setAttributeNode(attr);

                        // shorten way
                        // staff.setAttribute("id", "1");

                        //name elements
                        Element name = proDoc.createElement("name");
                        name.setTextContent("Alexandra Georgoudaki");
                        cv.appendChild(name);

                        // address elements
                        Element address = proDoc.createElement("address");
                        address.setTextContent("Kungshamra 5");
                        cv.appendChild(address);

                        // telephone elements
                        Element telephone = proDoc.createElement("telephone");
                        telephone.setTextContent("0737217170");
                        cv.appendChild(telephone);

                        // email elements
                        Element email = proDoc.createElement("email");
                        email.setTextContent("alegeo@kth.se");
                        cv.appendChild(email);

                        // education elements
                        Element education = proDoc.createElement("education");
                        education.setTextContent("Bachelor Degree in Information "
                                + "Technology and Telecommunications, 2011");
                        cv.appendChild(education);

                        // language elements
                        Element language = proDoc.createElement("language");
                        language.setTextContent("English, Swedish");
                        cv.appendChild(language);

                        // qualifications elements
                        Element qualifications = proDoc.createElement("qualifications");
                        qualifications.setTextContent("Driving license (car)");
                        cv.appendChild(qualifications);

                        // jobType elements
                        Element jobType = proDoc.createElement("jobType");
                        jobType.setTextContent("Permanent");
                        cv.appendChild(jobType);

                        // desiredPosition elements
                        Element desiredPosition = proDoc.createElement("desiredPosition");
                        desiredPosition.setTextContent("Software Developer, Web developer, Web designer");
                        cv.appendChild(desiredPosition);

                        // references elements
                        Element references = proDoc.createElement("references");
                        references.setTextContent("Available upon request");
                        cv.appendChild(references);

                        // motivation elements
                        Element motivation = proDoc.createElement("motivation");
                        motivation.setTextContent("I am suitable for the position because I enjoy the process of solving problems...");
                        cv.appendChild(motivation);



            //empRecord elements
            Element empRecord = proDoc.createElement("empRecord");
            rootElement.appendChild(empRecord);


                        //empName elements
                        Element empName = proDoc.createElement("empName");
                        empName.setTextContent("Alexandra Georgoudaki");
                        empRecord.appendChild(name);

                        // workedAt elements
                        Element workedAt = proDoc.createElement("workedAt");
                        workedAt.setTextContent("Google Inc.");
                        empRecord.appendChild(workedAt);

                        // duration elements
                        Element duration = proDoc.createElement("duration");
                        duration.setTextContent("18 months");
                        empRecord.appendChild(duration);

                        // year elements
                        Element year = proDoc.createElement("year");
                        year.setTextContent("2011");
                        empRecord.appendChild(year);

                        // position elements
                        Element position = proDoc.createElement("position");
                        position.setTextContent("Software Developer");
                        empRecord.appendChild(position);

           //companyInfo elements
            Element companyInfo = proDoc.createElement("companyInfo");
            rootElement.appendChild(companyInfo);

                //company elements
                Element company = proDoc.createElement("company");
                empRecord.appendChild(company);


                        //empName elements
                        Element companyName = proDoc.createElement("companyName");
                        companyName.setTextContent("Google Inc.");
                        empRecord.appendChild(companyName);

                        // category elements
                        Element category = proDoc.createElement("category");
                        category.setTextContent("Internet, Computer software");
                        empRecord.appendChild(category);

                        // founders elements
                        Element founders = proDoc.createElement("founders");
                        founders.setTextContent("Larry Page, Sergey Brin");
                        empRecord.appendChild(founders);

                        // ceo elements
                        Element ceo = proDoc.createElement("ceo");
                        ceo.setTextContent("Larry Page");
                        empRecord.appendChild(ceo);

                        // location elements
                        Element location = proDoc.createElement("location");
                        location.setTextContent("Googleplex, Mountain View, California, United States");
                        empRecord.appendChild(location);    

                        // contact elements
                        Element contact = proDoc.createElement("contact");
                        contact.setTextContent("1-801-456-2435");
                        empRecord.appendChild(contact);  

            //transcript elements
            Element transcript = proDoc.createElement("transcript");
            rootElement.appendChild(transcript);


                        //studentName elements
                        Element studentName = proDoc.createElement("studentName");
                        studentName.setTextContent("Alexandra Georgoudaki");
                        transcript.appendChild(studentName);

                        // university elements
                        Element university = proDoc.createElement("university");
                        university.setTextContent("KTH");
                        transcript.appendChild(university);

                        // program elements
                        Element program = proDoc.createElement("program");
                        program.setTextContent("Master Software Engineering of Distributed Systems");
                        transcript.appendChild(program);

                        // issueDate elements
                        Element issueDate = proDoc.createElement("issueDate");
                        issueDate.setTextContent("2011");
                        transcript.appendChild(issueDate);

                        // courses elements
                        Element courses = proDoc.createElement("courses");
                        transcript.appendChild(courses);

                        // course elements
                        Element course = proDoc.createElement("course");
                        transcript.appendChild(course);

                        // code elements
                        Element code = proDoc.createElement("code");
                        code.setTextContent("IK2210");
                        transcript.appendChild(code);

                        // title elements
                        Element title = proDoc.createElement("title");
                        title.setTextContent("Distributed Systems, Basic Course");
                        transcript.appendChild(title);

                        // credits elements
                        Element credits = proDoc.createElement("credits");
                        credits.setTextContent("7.5");
                        transcript.appendChild(credits);

                        // grade elements
                        Element grade = proDoc.createElement("grade");
                        grade.setTextContent("A");
                        transcript.appendChild(grade);








            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(proDoc);
            StreamResult result = new StreamResult(new File("src/empprofile/profile.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            
            System.out.println("Profile saved!");

      } catch (ParserConfigurationException pce) {
            System.err.println("[ERROR] 1");
      } catch (TransformerException tfe) {
            System.err.println("[ERROR] 2");
      }catch (DOMException de) {
            System.err.println("[ERROR] 3");
      }catch (TransformerFactoryConfigurationError tfce) {
            System.err.println("[ERROR] 4");
      }
    }
}

