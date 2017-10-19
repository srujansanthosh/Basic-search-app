//package com.qpidhealth.qpid.search.services;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;


// ******************************************************************************************************************************************************************* //

// ------- TEST 1 -------

//public class PatientServiceTest {
//    
//    String query = "Mary";
//    public static boolean queryInDoc (String query){
//        
//    PatientService pj = new PatientService();
//    List<String> docs = new ArrayList<String>();
//    docs.add(pj.resource("Mary_1"));
//        for(String str: docs){
//            String [] arrOfStr = str.split(":::");
//                if(arrOfStr[2].trim().contains(query.toLowerCase()) || arrOfStr[2].contains(query.toLowerCase())){
//                    return true;
//                }
//            }
//        return false;
//
//    }
//        @Test
//        public void checkTrue(){
//            
//            assertTrue(PatientServiceTest.queryInDoc("lumbar"));
//        }
//        
//    
//}

// 1. This test checks if the query entered is present in the patient who has atleast a document added.
// 2. It returns a boolean, true if present or false otherwise.
// 3. This patient pj, has a document which contains the query term.

// ******************************************************************************************************************************************************************* //

// ------- TEST 2 -------

//public class PatientServiceTest {
//    
//    String query = "coffee";
//    public static long docCount (String query){
//        
//    PatientService pj = new PatientService();
//    List<String> docs = new ArrayList<String>();
//    docs.add(pj.resource("Sam_1"));
//    docs.add(pj.resource("Mary_1"));
//    docs.add(pj.resource("Mary_2"));
//    docs.add(pj.resource("Joe_1"));
//    docs.add(pj.resource("Joe_2"));
//    long count=0;
//        for(String str: docs){
//              String [] arrOfStr = str.split(":::");
//                   if(arrOfStr[2].trim().contains(query.toLowerCase()) || arrOfStr[2].contains(query.toLowerCase())){
//                        count+=1;
//                    }
//               }
//    return count;
//
//    }
//        @Test
//        public void checkTrue(){
//            
//            assertEquals(1,docCount ("lumbar") );
//        }
//        
//    
//}

// 1. This test counts the number of times the query term has occured in the documents of the patient.
// 2. The query term has ocurred once in all of the documents of this patient.

// ******************************************************************************************************************************************************************* //
// ******************************************************************************************************************************************************************* //
