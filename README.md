# bytecode-intelligence

The system purpose is to inspect Java bytecode internals using dependencies. The software generates a report after inspection of jar files with consideration of security, performance and configuration standards. The system Bytecode intelligence will generate a report after analyzing the Jar files provided by the end user.



###Current Version:0.2 (Iteration 2)

 Package Analyzer - In the version 0.2  package analyzer will inspect code using BCEL and bruteforce approaches. And the rule dictionary matching will take the results and match every unit of code to rules and produce report dictionary.
 
 Pending:
 
 1) Email Generation for the report
 2) Including more rule combinations for inspecting Security and Performance categories. 


Open the projects in Netbeans 

### Version:0.1

- Package Analyzer - extract all class files from the jar. 
- Core - analyze class files using Rule definition schema.
- Report generator - generates a report and sends mail to the customer.


##References & Libraries:
####Apache BCEL: 
https://commons.apache.org/proper/commons-bcel/

####GSON Libraries: 
https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html

####Jodd Mail
http://jodd.org/doc/email.html






