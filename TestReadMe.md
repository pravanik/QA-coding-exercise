## Paint Calculator Testing Repository

#Prerequisites

Latest google chrome browser.
Eclipse/Intellij IDE
Cucumber eclipse and natural plugin(download from IDE marketplace).

# Project Setup
1. Clone the repo

   git clone <url>
   
2. Import the project into Eclipse

From the main menu choose `File -> Import ...` (**hint**: The import option is near the bottom of the File menu)

In the `Import` window open `Maven -> Existing Maven Projects` and click the `Next` button.

In the `Import Maven Projects` window click the `Browse` button.

In the dialog that opens find the locally cloned directory of the bitbucket repo directory that you cloned in the previous step and click the `OK` button. 

Verify that you have returned to the `Import Maven Project` dialgo and verify that there is a `pom.xml` file in the **Projects** text box area.

#Run Configuration


3.  Run the app and make sure it is up and running
4.Right click on the project and do a Maven Clean , and followed by Maven Install 
5.You can run the test in different ways:
     1.Using Maven Test
     2.Right click on RunTest.class and say Run As -> junit test
     3.Open the feature fail and right click on it Run As -> Cucumber feature

#Project Structure


5.Features folder has all the scenarios in gherkin(Given, When, Then ) format
6.stepdefinitions folder has all the glue code related to the scenarios 
7.pages has all the different pages of the application where each page consists of the webelements and actions performed on them.
8.testrunner has the RunTest class which is a junit runner , which has the feature path ,  glue code path and the tags to run the scenarios

Notes : I made few changes to the dev code as few steps in the scenario are failing for below reason:

The scenario "Calculate gallons of paint required" is failing at the step 
 1."the amount of feet to paint value is displayed" because there is an error in the dev code , where the surface area on the page says  ((Length * 2) + (Width * 2)) * Height but in the dev code it is calculated as length * breadth * height.
 2."And the gallons required is displayed " because there is an error in the dev code , where the gallons required actual should be surface area / 400 but the dev code says is as surface area / 350.
 
 
                          Test Plan for Paint Calculator Application
1.	Scope:
The scope of this test plan is to test the functionality of the Paint Calculator Application.
2.	Features to be tested:
Home Page
Rooms Page
Results Page
Results Page
3.	Approach:
 Agile Methodology with Scrum.
The testing will initiate with the review of the user requirements documents.
One approach is to write unit tests that run as much of the processing infrastructure as possible, capture the output, and assert what they can about its content. 
4.	Testing Environment
Selenium
5.	Test Tools:
Test Management tool-JIRA can be used for all Test Cases.
JIRA will be used for defect reporting and management.
Selenium can be introduced for Automation Testing.
6.	Responsibilities
Preparation and execution of the testing will be carried out by the Test Team
Development team will provide environment specification
Business Analyst team will provide with all the user stories and use cases.
Quality Analyst will review all the test products such as specifications, reports, etc.
7.	Resource
List out the members to reach out during test preparation phase.
8.	Test Estimation
No of test cases: 4
9.	Bug Handling 
Weekly Bug Prioritization Meeting:
Bug Story created in JIRA
Place in “Bugs to Triage” Epic
Business review of stories
Add/Update business priority
Change epic as needed(short term/future bug epic)
If short term, Product Owner places in a draft sprint.
10.	Severity
1.Immediate
2. High
3. Medium
4. Low

Feature List
As part of implementing running Selenium tests efforts to make this an efficient and highly configurable process:
•	Tests should be able to be run within Eclipse as they normally would. (right click, run as test)
•	The ability to run tests in parallel. 
•	The ability to re-run only the tests that failed in the last run.
•	The ability to filter tests based on annotations.
•	The ability to prioritize tests based on how long they took to run in previous iteration to minimize the overall runtime.
•	The ability to insure that a particular order is enforced when running these tests. (say you want to run one particular test before other tests)
•	The ability to run tests multiple times to weed or highlight out flaky tests. 
•	The ability to log the results of tests to a database, xml and standard logging. (and of course, customize the reporting)
•	The ability to cancel long running tests via a timeout.
•	Give a little status message with how many tests are left to run, and how many threads are currently active.
•	The ability to not run some tests if other tests failed.
•	The ability to iterate tests with parameters.
•	It should be a library that we can use elsewhere and integrate with the new QA regression suite, AND utilize within other groups.
•	Of course, it should run from Ant (or Maven)
 