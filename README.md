# Simple Patient Search Application in Ember

This is a simple search application over a set of patient records.

The backend code is in src/main/java and the UI code in src/main/webapp.

It's a simple ember app that hits an endpoint in src/main/java/com/qpidhealth/qpid/search/services/PatientService. 
The app filters the results it returns by a case-insensitive, partial match over the document title and contents.

This is a part of a coding challenge by QPID Health
