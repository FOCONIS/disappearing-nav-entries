disappearing navigation entries
================

A sample project to demonstrate ... in the browser using the basic Vaadin template with the latest Vaadin 8.2.0 release.

Vaadin Issue #10232 on GitHub: https://github.com/vaadin/framework/issues/10232 

Project Usage
=============

To compile the entire project, run "mvn install" using Maven > 3.

To run the application, run "mvn jetty:run" and open http://localhost:8080/ 
- then ...

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean package"
- test the war file with "mvn jetty:run-war"
