@tag
Feature: Login the UMS
#
  #@lp
  #Scenario Outline: LoginUMS
  #Given user open the url "http://localhost:4200/#/"
  #Then user enter the "<UN>" and "<PW>"
  #When user enter the submit button
  #And user clear the authentication
  #Then User enter the meeting button
  #Then Create the manual meeting "<MT>"
  #Then Create the Action item "<MT>" "<AT1>" "<AD1>" "<UN1>"
  #And Update the first Action item "<MT>" "<AT1>" "<AD1>" "<UN2>"
  #Then Create the Action item "<MT>" "<AT2>" "<AD2>" "<UN>"
  #Then Create the Action item "<MT>" "<AT3>" "<AD3>" "<UN>"
  #Then Submit the three Action items "<MT>" "<AT1>" "<AT2>" "<AT3>"
  #And Send the Mom mail "<MT>"
  #And Navigate to the Action item
  #Then Add task in action item "<AT1>" "<TT1>" "<TD1>" "<UN>" "<CN1>"
  #Then Add task in action item "<AT2>" "<TT2>" "<TD2>" "<UN>" "<CN2>"
  #Then Add task in action item "<AT3>" "<TT3>" "<TD3>" "<UN>" "<CN3>"
  #Then Navigate to Task and Edit the task in Organizer "<TT1>" "<TT1>" "<TD1>" "<UN>" "<CN2>"
  #And Update the Task in Assignee "<TT1>"
  #Then user enter the profile icon button
  #Then user enter the profile panel
  #Then user enter the profile icon button
  #And user enter the logout
  #
  #Examples:
  #| UN                            | UN1                          | UN2                       | PW       | MT             | AT1             | AD1                    | AT2               | AD2               | AT3          | AD3                 | TT1                | TD1                      | TT2                      | TD2                                 | TT3               | TD3                      | UTT            | UTD                   | CN1            | CN2                | CN3      |
  #| venkatesh.udaru@ikcontech.com | praveenreddy.g@ikcontech.com | sasirekha.t@ikcontech.com | Test@123 | UMS AUtomation | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Regression testing | Dialy Regression testing | Developing the Operation | Developing the Operation of Product | Developmet Update | Development update today | Monkey testing | Monkey testing status | Organizational | Project Management | External |
  #| praveenreddy.g@ikcontech.com  | venkatesh.udaru@ikcontech.com | praveenreddy.g@ikcontech.com  | Test@123 | Automation of UMS | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Sanity testing     | Initial Sanity testing   | Updating the Developing  | Updating the Developing of Product  | Bug Update        | Bug Update today                 | Regression testing | Dialy Regression testing | External       | Technical          | Risk      |
  #| sasirekha.t@ikcontech.com     | praveenreddy.g@ikcontech.com  | venkatesh.udaru@ikcontech.com | Test@123 | Scrum Meeting     | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Smoke testing      | Initial Smoke tesing     | Checking the Developing  | Checking the Developing of Product  | Product Update    | Prdouct current completed update | Smoke testing      | Initial Smoke tesing     | Risk           | Organizational     | Technical |
  #Scenario Outline: Admin settings
    #Given user open the url "http://localhost:4200/#/"
    #Then user enter the "<UN>" and "<PW>"
    #When user enter the submit button
    #And user clear the authentication
    #Then User navigate to the settings
    #And Navigate to the Permissions
    #Then Add the Permissions "<PN3>"
    #And Update the Permissions "<PN3>"
    #Then Add the Permissions "<PN2>"
    #Then Add the Permissions "<PN1>"
    #And Navigate to the roles
    #And add the role "<RN1>" "<PN1>"
    #And add the role "<RN2>" "<PN1>"
    #And add the role "<RN3>" "<PN3>"
    #And add the role "<RN4>" "<PN4>"
    #And add the role "<RN5>" "<PN2>"
    #Then Update the role "<RN1>" "<PN2>"
   #And Navigate to the Role Menu Items
    #Then add the Role Menu Items "<RN4>" "<PnN>"
    #And Navigate to the Assign MenuItems Permisisons
    #Then add the Assign MenuItems Permisisons "<RN1>" "<PnN>"
    #Then Update the Assign MenuItems Permisisons "<ASN1>" "<ASN2>"
    #Then navigate to the task category
    #And add the category "<CN1>"
    #And add the category "<CN2>"
    #And add the category "<CN3>"
    #And add the category "<CN4>"
    #And add the category "<CN5>"
    #And update the category "<CN1>"
    #Then navigate to the departments
    #And add the department "<DN1>" "<FN>" "<DC1>" "<DL1>"
    #And add the department "<DN2>" "<FN>" "<DC2>" "<DL1>"
    #And add the department "<DN3>" "<FN>" "<DC3>" "<DL1>"
    #And update the department "<DN1>" "<FN>" "<DC1>" "<DL1>"
    #Then navigate to the designations
    #And add the designation "<DSN1>"
    #And add the designation "<DSN2>"
    #And add the designation "<DSN3>"
    #And add the designation "<DSN4>"
    #And add the designation "<DSN5>"
    #And add the designation "<DSN6>"
    #And update the designation "<DSN1>"
    #Then navigate to the employee profiles
    #And add the employee profile "<FN1>" "<LN1>" "<EID1>" "<Email1>" "<DN1>" "<DSN1>" "<TID1>" "<FN>"
    #And update the employee profile "<FN1>" "<LN1>" "<EID1>" "<Email1>" "<DN2>" "<DSN2>" "<TID1>" "<FN>"
    #And add the employee profile "<FN2>" "<LN2>" "<EID2>" "<Email2>" "<DN2>" "<DSN2>" "<TID2>" "<FN1>"
    #And add the employee profile "<FN3>" "<LN3>" "<EID3>" "<Email3>" "<DN3>" "<DSN3>" "<TID3>" "<FN2>"
    #And add the employee profile "<FN4>" "<LN4>" "<EID4>" "<Email4>" "<DN3>" "<DSN4>" "<TID4>" "<FN3>"
    #And add the employee profile "<FN5>" "<LN5>" "<EID5>" "<Email5>" "<DN2>" "<DSN5>" "<TID5>" "<FN4>"
    #And add the employee profile "<FN6>" "<LN6>" "<EID6>" "<Email6>" "<DN1>" "<DSN6>" "<TID6>" "<FN5>"
    #And add the employee profile "<FN7>" "<LN7>" "<EID7>" "<Email7>" "<DN3>" "<DSN1>" "<TID7>" "<FN6>"
    #And add the employee profile "<FN8>" "<LN8>" "<EID8>" "<Email8>" "<DN2>" "<DSN2>" "<TID8>" "<FN6>"
    #And add the employee profile "<FN9>" "<LN9>" "<EID9>" "<Email9>" "<DN1>" "<DSN3>" "<TID9>" "<FN7>"
    #Then navigate to the users
    #And add the user "<RN1>" "<Email1>"
    #And add the user "<RN2>" "<Email2>"
    #And add the user "<RN3>" "<Email3>"
    #And add the user "<RN4>" "<Email4>"
    #And add the user "<RN5>" "<Email5>"
    #And add the user "<RN1>" "<Email6>"
    #And add the user "<RN2>" "<Email7>"
    #And add the user "<RN3>" "<Email8>"
    #And add the user "<RN4>" "<Email9>"
    #And update the user "<RN1>" "<Email1>"
    #Then navigate to the company details
    #And add the company details
    #And update the company details
    #Then user enter the profile icon button
    #And user enter the logout
#
    #Examples: 
      #| ASN2                                | ASN1                                                                                                                                                                                                                    | PN4                       | PN1  | PN2         | PN3                | UN                            | PW       | RN1     | RN2         | RN3             | RN4   | RN5       | CN1            | CD1                 | CN2      | CN3  | CN4                | CN5       | DN1                    | FN        | LN | DC1 | DL1       | DN2            | DC2 | DN3     | DC3 | DSN1                         | DSN2          | DSN3         | DSN4             | DSN5               | DSN6            | FN1    | LN1 | EID1     | Email1               | TID1                                 | FN2       | LN2 | EID2     | Email2                    | TID2                                 | FN3      | LN3 | EID3     | Email3                   | TID3                                 | FN4       | LN4 | EID4     | Email4                    | TID4                                 | FN5     | LN5 | EID5     | Email5                     | TID5                                 | FN6         | LN6 | EID6     | Email6                      | TID6                                 | FN7     | LN7 | EID7     | Email7                        | TID7                                 | FN8         | LN8 | EID8     | Email8                      | TID8                                 | FN9     | LN9 | EID9     | Email9                       | TID9                                 | PnN                                                                                                                                                                                                              |
      #| 1,2,3,4,4,3,2,1,4,2,1,4,2,1,4,3,2,4 | Permissions,Menu Items,Roles,Menu Items,Overview,Settings,User Menu Item Permissions,Reports,Meetings,ActionItems,Tasks,Employees,Users,Departments,Designations,Task Categories,Organization,Batch Details,Help Center | View,Create,Update,Delete | View | View,Create | View,Create,Update | venkatesh.udaru@ikcontech.com | Test@123 | MANAGER | TEAM_MEMBER | DEPARTMENT_HEAD | ADMIN | TEAM_LEAD | Organizational | Organizational Task | External | Risk | Project Management | Technical | Information Technology | Venkatesh | U  | D1  | Hyderabad | Human Resource | D2  | Finance | D3  | Autoamation Testing Enginner | Product Owner | Scrum Master | Testing Engineer | Software Developer | Project Manager | Bharat | P   | IKC_E002 | bharat@ikcontech.com | 36f3cc24-2a46-4da3-a1f6-9f83e7bdd465 | Sasirekha | T   | IKC_E003 | sasirekha.t@ikcontech.com | 16fbaa99-5b2f-4331-b12e-9d54b9c97773 | Vaishnav | P   | IKC_E004 | vaishnav.p@ikcontech.com | 9e2a07ef-86ff-4814-bf01-92c6bc0a74ff | Samyuktha | R   | IKC_E005 | samyuktha.r@ikcontech.com | 9107dea6-8530-4a4a-aeb0-43430b2e861a | Sashank | A   | IKC_E006 | sashank.arun@ikcontech.com | eb3047ef-f215-4bfb-8b15-a34ad67bd675 | Prabhakaran | A   | IKC_E007 | prabhakaran.a@ikcontech.com | a86c4df6-f64b-47a9-9a32-c50627e1591a | Dhanush | A   | IKC_E008 | dhanush.akunuri@ikcontech.com | 0e398b66-886d-4d89-a15c-ed903b42ab69 | Subramanian | A   | IKC_E009 | subramanian.a@ikcontech.com | 8771d005-53ee-4fc4-b78e-8162073b39be | Praveen | G   | IKC_E010 | praveenreddy.g@ikcontech.com | 6f55b907-7634-4b2a-8cae-1e01d9bc705d | Roles,Permissions,Menu Items,Role Menu Items,Overview,Settings,User Menu Item Permissions,Reports,Meetings,Tasks,Employees,Users,Departments,Designations,Task Categories,Organization,Batch Details,ActionItems |
  #@fp
  #Scenario Outline: forgot password
    #Given user enter the url "http://localhost:4200/#/"
    #When user clik the Forgot password button
    #Then user enter the "<mail>"
    #And user enter getotp button
    #Then user enter the OTP
    #And user enter verify OTP  the button
    #Then user enter "<newpassword>" and re enter "<newpassword>"
#
    #Examples: 
      #| mail                          | newpassword | status  |
      #4   | success |
      #| venkatesh.udaru@ikcontech.com |      123456 | fail    |
      
      @reports
    Scenario Outline: Reports
    #Given user open the url "http://localhost:4200/#/"
    #Then user enter the "<UN>" and "<PW>"
    #When user enter the submit button
    #And user clear the authentication  
    Then Navigate to reports
    And Navigate to Meetings Organized
    And Navigate to Meetings Attended
    And Navigate to Meetings All Departments
    And Navigate to Action Items Organized
    And Navigate to Action Items Priority
    And Navigate to Action Items All Department
    And Task Items Organized
    And Task Items Severity
    And Task Items Status
    And Task Items Aged
    And Task Items All Departments
    And Task category Organizational
    And Task category External
    And Task category Risk
    And Task category Project Management
    And Task category Technical
    And Task category Task Category summary
