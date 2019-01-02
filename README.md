## Please follow below steps to run the code.
### Pre-Requisits
    Maven software should be installed and configured.
    JRE/JDK 1.8 should be installed.

#### Step 1: Download Zip by Clicking "Clone or Download" button.

#### Step 2: Extract the zip file in your local machine.

#### Step 3: Go to extracted folder using command line.

#### Step 4: Build the application using below Maven Command.
        Example: C:\Pizza> mvn clean compile package <enter>
        
#### Step 5: Run the application using below command.
     Example: C:\Pizza> java -jar target\PizzaSorting-0.0.1-SNAPSHOT.jar com.xyz.pizza.PizzaSortingApplication <SourceFile> <DestinationFile> <enter>        
     Note : Sample input file "sampleOrders.txt" and output file "output.txt" are available in the root folder.
     
#### Step 6: Check the output file in the destination folder.


Assumptions
===========
	1. Input file will be txt file. 1st line should be header and will be skipped. Should contain two columns.
	2. The time will be mentioned as long value.
		
Design Decision
===============
	1. Builder Desing Pattern is used.

Future Changes
==============
	1. We can store the order to database by getting user details.
	2. All the database configuration can be made by writing a configuration class.
	3. File can be uploaded from UI, file/file path can be passed to Controller.
