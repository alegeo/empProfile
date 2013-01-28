package empprofile;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParser {
    
    public DOMParser() {
    }
    
    public static void main(String[] args){
     
        DOMParser d = new DOMParser();
        d.createProfile();
      }

    public void createProfile(){
 
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            
            // to make the parser a validating parse
            dFactory.setValidating(true);
            //To parse a XML document with a namespace,
            dFactory.setNamespaceAware(true);
            
            // to ignore cosmetic whitespace between elements.
            dFactory.setIgnoringElementContentWhitespace(true);
            dFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            dFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "profile.xsd");           
            
            Document proDoc = dBuilder.newDocument();
            
            Document cvDoc = normalizeDocument("src/empprofile/cv.xml", "src/empprofile/cv.xsd");
            Document comDoc = normalizeDocument("src/empprofile/companyInfo.xml", "src/empprofile/companyInfo.xsd");
            Document eDoc = normalizeDocument("src/empprofile/empRecord.xml", "src/empprofile/empRecord.xsd");
            Document tDoc = normalizeDocument("src/empprofile/transcript.xml", "src/empprofile/transcript.xsd");
            
            
            String namespace = "http://www.profile.com/ns/profile";          
            
                       
            // root element
            Element rootElement = proDoc.createElementNS(namespace, "app:profile");
            proDoc.appendChild(rootElement);
            
            //cv_info elements
            Element cv_info = proDoc.createElementNS(namespace, "app:cv_info");
            rootElement.appendChild(cv_info);            

                    //name elements
                    Element name = proDoc.createElementNS(namespace, "app:name");
                    NodeList cvName = cvDoc.getElementsByTagName("apcv:name");
                    name.setTextContent(cvName.item(0).getTextContent());
                    cv_info.appendChild(name);

                    // address elements
                    Element address = proDoc.createElementNS(namespace, "app:address");
                    NodeList cvAddress = cvDoc.getElementsByTagName("apcv:address");
                    address.setTextContent(cvAddress.item(0).getTextContent());
                    cv_info.appendChild(address);

                    // telephone elements
                    Element telephone = proDoc.createElementNS(namespace, "app:telephone");
                    NodeList cvTelephone = cvDoc.getElementsByTagName("apcv:telephone");
                    telephone.setTextContent(cvTelephone.item(0).getTextContent());
                    cv_info.appendChild(telephone);

                    // email elements
                    Element email = proDoc.createElementNS(namespace, "app:email");
                    NodeList cvEmail = cvDoc.getElementsByTagName("apcv:email");
                    email.setTextContent(cvEmail.item(0).getTextContent());
                    cv_info.appendChild(email);

                    // education elements
                    Element education = proDoc.createElementNS(namespace, "app:education");
                    NodeList cvEducation = cvDoc.getElementsByTagName("apcv:email");
                    education.setTextContent(cvEducation.item(0).getTextContent());
                    cv_info.appendChild(education);

                    // language elements
                    Element language = proDoc.createElementNS(namespace, "app:language");
                    NodeList cvLanguage = cvDoc.getElementsByTagName("apcv:language");
                    language.setTextContent(cvLanguage.item(0).getTextContent());
                    cv_info.appendChild(language);

                    // qualifications elements
                    Element qualifications = proDoc.createElementNS(namespace, "app:qualifications");
                    NodeList cvQualifications = cvDoc.getElementsByTagName("apcv:qualifications");
                    qualifications.setTextContent(cvQualifications.item(0).getTextContent());
                    cv_info.appendChild(qualifications);

                    // jobType elements
                    Element jobType = proDoc.createElementNS(namespace, "app:jobType");
                    NodeList cvJobType = cvDoc.getElementsByTagName("apcv:jobType");
                    jobType.setTextContent(cvJobType.item(0).getTextContent());
                    cv_info.appendChild(jobType);

                    // desiredPosition elements
                    Element desiredPosition = proDoc.createElementNS(namespace, "app:desiredPosition");
                    NodeList cvDesiredPosition = cvDoc.getElementsByTagName("apcv:desiredPosition");
                    desiredPosition.setTextContent(cvDesiredPosition.item(0).getTextContent());
                    cv_info.appendChild(desiredPosition);

                    // references elements
                    Element references = proDoc.createElementNS(namespace, "app:references");
                    NodeList cvReferences = cvDoc.getElementsByTagName("apcv:references");
                    references.setTextContent(cvReferences.item(0).getTextContent());
                    cv_info.appendChild(references);

                    // motivation elements
                    Element motivation = proDoc.createElementNS(namespace, "app:motivation");
                    NodeList cvMotivation = cvDoc.getElementsByTagName("apcv:motivation");
                    motivation.setTextContent(cvMotivation.item(0).getTextContent());
                    cv_info.appendChild(motivation);



        //empRecord elements
        Element empRecord = proDoc.createElementNS(namespace, "app:empRecord");
        rootElement.appendChild(empRecord);
            
                    //empName elements
                    Element empName = proDoc.createElementNS(namespace, "app:empName");
                    NodeList eEmpName= eDoc.getElementsByTagName("e:empName");
                    empName.setTextContent(eEmpName.item(0).getTextContent());
                    empRecord.appendChild(empName);
                    
                    
                //companyWorked elements
                Element companyWorked = proDoc.createElementNS(namespace, "app:companyWorked");
                empRecord.appendChild(companyWorked);

                    // workedAtComId elements
                    Element workedAtComId = proDoc.createElementNS(namespace, "app:workedAtComId");
                    NodeList eWorkedAtComId= eDoc.getElementsByTagName("e:workedAtComId");
                    workedAtComId.setTextContent(eWorkedAtComId.item(0).getTextContent());
                    companyWorked.appendChild(workedAtComId);
                    
                    // workedAt elements
                    Element workedAt = proDoc.createElementNS(namespace, "app:workedAt");
                    NodeList eWorkedAt= eDoc.getElementsByTagName("e:workedAt");
                    workedAt.setTextContent(eWorkedAt.item(0).getTextContent());
                    companyWorked.appendChild(workedAt);

                    // duration elements
                    Element duration = proDoc.createElementNS(namespace, "app:duration");
                    NodeList eDuration= eDoc.getElementsByTagName("e:duration");
                    duration.setTextContent(eDuration.item(0).getTextContent());
                    companyWorked.appendChild(duration);

                    // year elements
                    Element year = proDoc.createElementNS(namespace, "app:year");
                    NodeList eYear= eDoc.getElementsByTagName("e:year");
                    year.setTextContent(eYear.item(0).getTextContent());
                    companyWorked.appendChild(year);

                    // position elements
                    Element position = proDoc.createElementNS(namespace, "app:position");
                    NodeList ePosition= eDoc.getElementsByTagName("e:position");
                    position.setTextContent(ePosition.item(0).getTextContent());
                    companyWorked.appendChild(position);

       //companyInfo elements
        Element companyInfo = proDoc.createElementNS(namespace, "app:companyInfo");
        rootElement.appendChild(companyInfo);
        
            //companies elements
            Element companies = proDoc.createElementNS(namespace, "app:companies");
            companyInfo.appendChild(companies);

                    //company elements
                    Element company = proDoc.createElementNS(namespace, "app:company");
                    companies.appendChild(company);

                    //companyId elements
                    Element companyId = proDoc.createElementNS(namespace, "app:companyId");
                    NodeList comCompanyId= comDoc.getElementsByTagName("com:companyId");
                    companyId.setTextContent(comCompanyId.item(0).getTextContent());
                    companies.appendChild(companyId);

                    //companyName elements
                    Element companyName = proDoc.createElementNS(namespace, "app:companyName");
                    NodeList comCompanyName= comDoc.getElementsByTagName("com:companyName");
                    companyName.setTextContent(comCompanyName.item(0).getTextContent());
                    companies.appendChild(companyName);

                    // category elements
                    Element category = proDoc.createElementNS(namespace, "app:category");
                    NodeList comCategory= comDoc.getElementsByTagName("com:category");
                    category.setTextContent(comCategory.item(0).getTextContent());
                    companies.appendChild(category);

                    // founders elements
                    Element founders = proDoc.createElementNS(namespace, "app:founders");
                    NodeList comFounders= comDoc.getElementsByTagName("com:founders");
                    founders.setTextContent(comFounders.item(0).getTextContent());
                    companies.appendChild(founders);

                    // ceo elements
                    Element ceo = proDoc.createElementNS(namespace, "app:ceo");
                    NodeList comCeo= comDoc.getElementsByTagName("com:ceo");
                    ceo.setTextContent(comCeo.item(0).getTextContent());
                    companies.appendChild(ceo);

                    // location elements
                    Element location = proDoc.createElementNS(namespace, "app:location");
                    NodeList comLocation= comDoc.getElementsByTagName("com:location");
                    location.setTextContent(comLocation.item(0).getTextContent());
                    companies.appendChild(location);    

                    // contact elements
                    Element contact = proDoc.createElementNS(namespace, "app:contact");
                    NodeList comContact= comDoc.getElementsByTagName("com:contact");
                    contact.setTextContent(comContact.item(0).getTextContent());
                    companies.appendChild(contact);  

        //transcript elements
        Element transcript = proDoc.createElementNS(namespace, "app:transcript");
        rootElement.appendChild(transcript);


                    //studentName elements
                    Element studentName = proDoc.createElementNS(namespace, "app:studentName");
                    NodeList tStudentName= tDoc.getElementsByTagName("t:studentName");
                    studentName.setTextContent(tStudentName.item(0).getTextContent());
                    transcript.appendChild(studentName);

                    // university elements
                    Element university = proDoc.createElementNS(namespace, "app:university");
                    NodeList tUniversity= tDoc.getElementsByTagName("t:university");
                    university.setTextContent(tUniversity.item(0).getTextContent());
                    university.setTextContent("KTH");
                    transcript.appendChild(university);

                    // program elements
                    Element program = proDoc.createElementNS(namespace, "app:program");
                    NodeList tProgram= tDoc.getElementsByTagName("t:program");
                    program.setTextContent(tProgram.item(0).getTextContent());
                    transcript.appendChild(program);

                    // issueDate elements
                    Element issueDate = proDoc.createElementNS(namespace, "app:issueDate");
                    NodeList tIssueDate= tDoc.getElementsByTagName("t:issueDate");
                    issueDate.setTextContent(tIssueDate.item(0).getTextContent());
                    transcript.appendChild(issueDate);

                    // courses elements
                    Element courses = proDoc.createElementNS(namespace, "app:courses");
                    transcript.appendChild(courses);

                    
                    NodeList tCourses = tDoc.getElementsByTagName("t:courses");
                    NodeList tCourse = ((Element)tCourses.item(0)).getElementsByTagName("t:course");
                    for(int i = 0; i < tCourse.getLength(); i++) {
                    //course elements
                    Element course = proDoc.createElementNS(namespace, "app:course");
                    transcript.appendChild(course);
                             
                    // code elements    
                    Element code = proDoc.createElementNS(namespace, "app:code");
                    NodeList tCode = ((Element)tCourse.item(i)).getElementsByTagName("t:code");
                    code.setTextContent(tCode.item(0).getTextContent());
                    course.appendChild(code);
                   
                    // title elements
                    Element title = proDoc.createElementNS(namespace, "app:title");
                    NodeList tTitle = ((Element)tCourse.item(i)).getElementsByTagName("t:title");
                    title.setTextContent(tTitle.item(0).getTextContent());
                    course.appendChild(title);

                    // credits elements
                    Element credits = proDoc.createElementNS(namespace, "app:credits");
                    NodeList tCredits = ((Element)tCourse.item(i)).getElementsByTagName("t:credits");
                    credits.setTextContent(tCredits.item(0).getTextContent());
                    course.appendChild(credits);

                    // grade elements
                    Element grade = proDoc.createElementNS(namespace, "app:grade");
                    NodeList tGrade = ((Element)tCourse.item(i)).getElementsByTagName("t:grade");
                    grade.setTextContent(tGrade.item(0).getTextContent());
                    course.appendChild(grade);
                    }

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
    

    
    private Document normalizeDocument(String xml, String xsd) {
        Document xmlDocument = null;
        
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setValidating(true);
            docBuilderFactory.setNamespaceAware(true);
            docBuilderFactory.setIgnoringElementContentWhitespace(true);
            docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", xsd);

            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            xmlDocument = docBuilder.parse(new File(xml));
            xmlDocument.getDocumentElement().normalize();
        }
        catch(IllegalArgumentException | ParserConfigurationException | SAXException | IOException ex) {
            System.err.println("[ERROR] Something is wrong!");
        }
        
        return xmlDocument;
    }
}

