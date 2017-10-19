package com.qpidhealth.qpid.search.services;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.ejb.LockType.READ;

@Path("/patients")
@Singleton
@Lock(READ)
public class PatientService {
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
   
        
    public List<Patient> searchPatients(@QueryParam("query") String query) {
        
        String q = "";
        q = query;
        
        List<Patient> results = new ArrayList<Patient>();
        
        Patient p1 = new Patient();                                                 /* create a patient*/
        p1.setId(1000000L);                                                         /* set name and id*/
        p1.setName("Mary TestPerson");
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));               /* add two files to the list*/
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        p1.setDocuments(docs);                                                      /* set the documents added to the patient*/
        results = addDocs(docs, q, p1, results);                                    /* check if query present in patient's documents, add the patient to results*/
        
        Patient p2 = new Patient();
        p2.setId(1000001L);
        p2.setName("Joe TestPerson");
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        p2.setDocuments(docs2);
        results = addDocs(docs2, q, p2, results);
        
        Patient p3 = new Patient();
        p3.setId(1000002L);
        p3.setName("Sam TestPerson");
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        p3.setDocuments(docs3);
        results = addDocs(docs3, q, p3, results);     
        
        return results;                                                             /* results contains the list of patients who documents are matched with the query term,*/
    }                                                                               /* which is later displayed in the front end.*/
    
    public List<Patient> addDocs(List<String> docs, String query, Patient p, List<Patient> results){
        
        for(String str: docs){
            String [] arrOfStr = str.split(":::");
                if(arrOfStr[0].trim().toLowerCase().contains(query.toLowerCase()) || arrOfStr[2].trim().toLowerCase().contains(query.toLowerCase())){
                    results.add(p);
                    break;
                }
            }
        return results;
    }
    
    /** 1. "addDocs" function takes documents, query term, patient and results as arguments.
    *   2. The documents is of the form title:::date:::content, since we need to search the query just in the title and the content, I use split() and separate the document.
    *   3. For every string in the documents, I check if the query term is present only in the title and the content. If yes, I add the patient associated with the document 
    *      to the results (no need of checking the all the strings of the document, as we add it even if the query term is present once, hence the "break" statement.)
    *   4. Inside the function, I'm checking if the query term (entered thus far) matched atleast the partial text in the document.
    *   5. "str.contains(query)" - searches the sequence of characters in str that matched with the query, so partial match is done.
    *   6. If match found, the patient whose document is matched is added to the results, which is later displayed.
    */
    
    
    public static String resource(String fileName) {	
    	ClassLoader classLoader = PatientService.class.getClassLoader();
    	try {
    	    return IOUtils.toString(classLoader.getResourceAsStream("documents/"+fileName+".txt"));
    	} catch (IOException e) {
    	    e.printStackTrace();
    	    return "Failed to retrieve resource "+fileName;
    	}
    }
    

    @XmlRootElement
    public static class Patient {
        
        private Long id;    
        private String name;
        private List<String> documents; // id ::: date ::: contents
        
        public Patient() {
            documents = new ArrayList<String>();
        }
        
        public static Patient create() {
            return new Patient();
        }
        
        public Long getId() {                                       // setter and getter functions
            return id;
        }
        
        public void setId(Long id) {
            this.id = id;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public List<String> getDocuments() {
            return documents;
        }
        
        public void setDocuments(List<String> documents) {
            this.documents = documents;
        }
           
    }

}
