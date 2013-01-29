package generate;

import generate.*;
import generate.CompanyInfo;
import generate.Cv;
import generate.EmpRecord;
import generate.Profile;
import generate.Profile.CvInfo;
import generate.Profile.Transcript.Courses.Course;
import generate.Profile.CompanyInfo.Companies;
import generate.Profile.CompanyInfo.Companies.Company;
import generate.Transcript;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;  

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB_profile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
    try {
        
        Profile profile = new Profile(); 
        
        JAXBContext context0 = JAXBContext.newInstance(Cv.class);
        Marshaller m0 = context0.createMarshaller();
        m0.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller um0 = context0.createUnmarshaller();
        Cv cv = (Cv) um0.unmarshal(new FileReader("src/cv.xml")); 
        
        JAXBContext context1 = JAXBContext.newInstance(EmpRecord.class);
        Marshaller m1 = context1.createMarshaller();
        m1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller um1 = context1.createUnmarshaller();
        EmpRecord empRecord = (EmpRecord) um1.unmarshal(new FileReader("src/empRecord.xml"));
        
        JAXBContext context2 = JAXBContext.newInstance(CompanyInfo.class);
        Marshaller m2 = context2.createMarshaller();
        m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller um2 = context2.createUnmarshaller();
        CompanyInfo companyInfo = (CompanyInfo) um2.unmarshal(new FileReader("src/companyInfo.xml"));

        JAXBContext context3 = JAXBContext.newInstance(Transcript.class);
        Marshaller m3 = context3.createMarshaller();
        m3.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller um3 = context3.createUnmarshaller();
        Transcript transcript = (Transcript) um3.unmarshal(new FileReader("src/transcript.xml"));
        
        CvInfo cvinfo = new Profile.CvInfo();
        cvinfo.setName(cv.name);
        cvinfo.setAddress(cv.getAddress());
        cvinfo.setTelephone(cv.telephone);
        cvinfo.setEmail(cv.email);
        cvinfo.setEducation(cv.education);
        cvinfo.setJobType(cv.jobType);
        for (int i=0; i<cv.language.size(); i++) {
            cvinfo.getLanguage().add(cv.language.get(i));
            cvinfo.language.add(cv.language.get(i));};
        cvinfo.setQualifications(cv.qualifications);
        cvinfo.setDesiredPosition(cv.desiredPosition);
        cvinfo.setReferences(cv.references);
        cvinfo.setMotivation(cv.motivation);
        profile.setCvInfo(cvinfo);
        
        Profile.EmpRecord emprecord = new Profile.EmpRecord();
        emprecord.setEmpName(empRecord.empName);
        String[] companyIds = new String[30];
        
        for (int i=0; i< empRecord.companyWorked.size()-1; i++) {
           Profile.EmpRecord.CompanyWorked newCom = new Profile.EmpRecord.CompanyWorked();   
           newCom.setWorkedAtComId(empRecord.companyWorked.get(i).workedAtComId);
           newCom.setWorkedAt(empRecord.companyWorked.get(i).workedAt);
           newCom.setDuration(empRecord.companyWorked.get(i).duration);
           newCom.setYear(empRecord.companyWorked.get(i).year);
           newCom.setPosition(empRecord.companyWorked.get(i).position);
           emprecord.getCompanyWorked().add(newCom);
           companyIds[i] = empRecord.companyWorked.get(i).workedAtComId;
        };
        profile.setEmpRecord(emprecord);
        
        /// Company Info part not yet done
        Profile.CompanyInfo companyinfo = new Profile.CompanyInfo();
        companyinfo.companies = new Profile.CompanyInfo().companies;
        Companies coms = new Profile.CompanyInfo.Companies();
        for (int i=0; i<companyIds.length; i++) {
            for (int j=0; ((j< companyInfo.companies.company.size()-1) && (companyInfo.companies.company.get(j).companyId == null ? companyIds[i] == null : companyInfo.companies.company.get(j).companyId.equals(companyIds[i])));j++ ) {
                Company com =(Company) new Profile.CompanyInfo.Companies.Company();
                com.companyId = companyIds[i];
                com.companyName = companyInfo.companies.company.get(j).companyName;
                com.category = companyInfo.companies.company.get(j).category;
                com.ceo = companyInfo.companies.company.get(j).ceo;
                com.founders = companyInfo.companies.company.get(j).founders;
                com.location = companyInfo.companies.company.get(j).location;
                com.contact = companyInfo.companies.company.get(j).contact;
                coms.getCompany().add(com);
            } 
        }
        companyinfo.setCompanies(coms);
        profile.setCompanyInfo(companyinfo);
        
        Profile.Transcript trans = new Profile.Transcript();
        trans.courses = new Profile.Transcript.Courses();
        trans.setStudentName(transcript.studentName);
        trans.setUniversity(transcript.university);
        trans.setProgram(transcript.program);
        trans.setIssueDate(transcript.issueDate);
        for (int i=0; i<transcript.courses.course.size()-1; i++){
        Course a = (Course) new Profile.Transcript.Courses.Course();
        a.setCode(transcript.courses.course.get(i).code);
        a.setTitle(transcript.courses.course.get(i).title);
        a.setGrade(transcript.courses.course.get(i).grade);
        a.setCredits(transcript.courses.course.get(i).credits);
        a.setCredits(transcript.courses.course.get(i).getCredits());
        trans.courses.getCourse().add(a);
        }
        profile.setTranscript(trans);
        
        JAXBContext profileContext = JAXBContext.newInstance(Profile.class);
        System.out.println("Test point 1");
        Marshaller profileMarshaller = profileContext.createMarshaller();
        System.out.println("Test point 2");
        profileMarshaller.setProperty("jaxb.schemaLocation", "http://namespace.profile.com/ns/profile profile.xsd");
        System.out.println("Test point 3");
        profileMarshaller.marshal(profile, new File("src/jaxb_output.xml"));
        System.out.println("Test point 4");
        
       } catch (JAXBException e) {System.out.print("JABX");}
        catch (java.io.FileNotFoundException e) {System.out.print("Can't find the file");}
           }
    } 
        
    

