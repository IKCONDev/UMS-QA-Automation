@tag
Feature: Login the UMS

  Scenario Outline: Admin settings
  Meta-data: {"dataFile":"resources/data/logintestdata.csv"}
  
  Given user open the url "http://localhost:4200/#/"
  Then user enter the "<UN>" and "<PW>"
  When user enter the submit button
  And user clear the authentication
  Then User navigate to the settings
  #Then User navigate to the Add Menu Items
  #And Add menu items
  And Navigate to the Permissions
  Then Add the Permissions "<PN3>"
  And Update the Permissions "<PN3>"
  Then Add the Permissions "<PN2>"
  Then Add the Permissions "<PN1>"
  And Navigate to the roles
  And add the role "<RN1>" "<PN1>"
  And add the role "<RN2>" "<PN1>"
  And add the role "<RN3>" "<PN3>"
  And add the role "<RN4>" "<PN4>"
  And add the role "<RN5>" "<PN2>"
  Then Update the role "<RN1>" "<PN2>"
  And Navigate to the Role Menu Items
  Then add the Role Menu Items "<RN1>" "<ASN1>"
  Then add the Role Menu Items "<RN2>" "<ASN1>"
  Then add the Role Menu Items "<RN3>" "<ASN1>"
  Then add the Role Menu Items "<RN4>" "<ASN1>"
  Then add the Role Menu Items "<RN5>" "<ASN1>"
  Then navigate to the task category
  And add the category "<CN1>"
  And add the category "<CN2>"
  And add the category "<CN3>"
  And add the category "<CN4>"
  And add the category "<CN5>"
  And update the category "<CN1>"
  Then navigate to the departments
  And add the department "<DN1>" "<FN>" "<DC1>" "<DL1>"
  And add the department "<DN2>" "<FN>" "<DC2>" "<DL1>"
  And add the department "<DN3>" "<FN>" "<DC3>" "<DL1>"
  And update the department "<DN1>" "<FN>" "<DC1>" "<DL1>"
  Then navigate to the designations
  And add the designation "<DSN1>"
  And add the designation "<DSN2>"
  And add the designation "<DSN3>"
  And add the designation "<DSN4>"
  And add the designation "<DSN5>"
  And add the designation "<DSN6>"
  And update the designation "<DSN1>"
  Then navigate to the employee profiles
  And add the employee profile "<FN1>" "<LN1>" "<EID1>" "<Email1>" "<DN1>" "<DSN1>" "<TID1>" "<FN>" "<GM>"
  And update the employee profile "<FN1>" "<LN1>" "<EID1>" "<Email1>" "<DN2>" "<DSN2>" "<TID1>" "<FN>" "<GM>"
  And add the employee profile "<FN2>" "<LN2>" "<EID2>" "<Email2>" "<DN2>" "<DSN2>" "<TID2>" "<FN1>" "<GF>"
  And add the employee profile "<FN3>" "<LN3>" "<EID3>" "<Email3>" "<DN3>" "<DSN3>" "<TID3>" "<FN2>" "<GM>"
  And add the employee profile "<FN4>" "<LN4>" "<EID4>" "<Email4>" "<DN3>" "<DSN4>" "<TID4>" "<FN3>" "<GF>"
  And add the employee profile "<FN5>" "<LN5>" "<EID5>" "<Email5>" "<DN2>" "<DSN5>" "<TID5>" "<FN4>" "<GM>"
  And add the employee profile "<FN6>" "<LN6>" "<EID6>" "<Email6>" "<DN1>" "<DSN6>" "<TID6>" "<FN5>" "<GM>"
  And add the employee profile "<FN7>" "<LN7>" "<EID7>" "<Email7>" "<DN3>" "<DSN1>" "<TID7>" "<FN6>" "<GM>"
  And add the employee profile "<FN8>" "<LN8>" "<EID8>" "<Email8>" "<DN2>" "<DSN2>" "<TID8>" "<FN6>" "<GM>"
  And add the employee profile "<FN9>" "<LN9>" "<EID9>" "<Email9>" "<DN1>" "<DSN3>" "<TID9>" "<FN7>" "<GM>"
  Then navigate to the users
  And add the user "<RN1>" "<Email1>"
  And update the user "<RN1>" "<Email1>"
  And add the user "<RN2>" "<Email2>"
  And add the user "<RN3>" "<Email3>"
  And add the user "<RN4>" "<Email4>"
  And add the user "<RN5>" "<Email5>"
  And add the user "<RN1>" "<Email6>"
  And add the user "<RN2>" "<Email7>"
  And add the user "<RN3>" "<Email8>"
  And add the user "<RN4>" "<Email9>"
  And Navigate to the Assign MenuItems Permisisons
  #Then add the Assign MenuItems Permisisons "<RN1>" "<ASN1>"
  Then Update the Assign MenuItems Permisisons "<ASN1>" "<ASN2>"
  Then navigate to the company details
  And add the company details
  And update the company details
  Then user enter the profile icon button
  And user enter the logout
  
  Examples: {'datafile':'resources/testdata.xls'}
  | GF     | GM   | ASN2                                | ASN1                                                                                                                                                                                                                                                                                                     | PN1  | PN2         | PN3                | PN4                       | UN                            | PW       | RN1     | RN2         | RN3             | RN4   | RN5       | CN1            | CN2      | CN3  | CN4                | CN5       | DN1                    | FN        | LN | DC1 | DL1       | DN2            | DC2 | DN3     | DC3 | DSN1                         | DSN2          | DSN3         | DSN4             | DSN5               | DSN6            | FN1    | LN1 | EID1     | Email1               | TID1                                 | FN2       | LN2 | EID2     | Email2                    | TID2                                 | FN3      | LN3 | EID3     | Email3                   | TID3                                 | FN4       | LN4 | EID4     | Email4                    | TID4                                 | FN5     | LN5 | EID5     | Email5                     | TID5                                 | FN6         | LN6 | EID6     | Email6                      | TID6                                 | FN7     | LN7 | EID7     | Email7                        | TID7                                 | FN8         | LN8 | EID8     | Email8                      | TID8                                 | FN9     | LN9 | EID9     | Email9                       | TID9                                 |
  | Female | Male | 1,2,3,4,4,3,2,1,4,2,1,4,2,1,4,3,2,4 | Roles,Permissions,Menu Items,Role Menu Items,Overview,Settings,Meetings,Tasks,Employees,Users,Departments,Designations,Task Categories,Organization,Batch Details,Action Items,Reports,Meeting Reports,Help Center,Action Item Reports,Task Category Report,Task Reports,Assign Menu Items & Permissions | View | View,Create | View,Create,Update | View,Create,Update,Delete | venkatesh.udaru@ikcontech.com | Test@123 | MANAGER | TEAM_MEMBER | DEPARTMENT_HEAD | ADMIN | TEAM_LEAD | Organizational | External | Risk | Project Management | Technical | Information Technology | Venkatesh | U  | IT  | Hyderabad | Human Resource | HR  | Finance | FN  | Autoamation Testing Enginner | Product Owner | Scrum Master | Testing Engineer | Software Developer | Project Manager | Bharat | P   | IKC_E002 | bharat@ikcontech.com | 36f3cc24-2a46-4da3-a1f6-9f83e7bdd465 | Sasirekha | T   | IKC_E003 | sasirekha.t@ikcontech.com | 16fbaa99-5b2f-4331-b12e-9d54b9c97773 | Vaishnav | P   | IKC_E004 | vaishnav.p@ikcontech.com | 9e2a07ef-86ff-4814-bf01-92c6bc0a74ff | Samyuktha | R   | IKC_E005 | samyuktha.r@ikcontech.com | 9107dea6-8530-4a4a-aeb0-43430b2e861a | Sashank | A   | IKC_E006 | sashank.arun@ikcontech.com | eb3047ef-f215-4bfb-8b15-a34ad67bd675 | Prabhakaran | A   | IKC_E007 | prabhakaran.a@ikcontech.com | a86c4df6-f64b-47a9-9a32-c50627e1591a | Dhanush | A   | IKC_E008 | dhanush.akunuri@ikcontech.com | 0e398b66-886d-4d89-a15c-ed903b42ab69 | Subramanian | A   | IKC_E009 | subramanian.a@ikcontech.com | 8771d005-53ee-4fc4-b78e-8162073b39be | Praveen | G   | IKC_E010 | praveenreddy.g@ikcontech.com | 6f55b907-7634-4b2a-8cae-1e01d9bc705d |
  @lp
  Scenario Outline: LoginUMS
  Given user open the url "http://localhost:4200/#/"
  Then user enter the "<UN>" and "<PW>"
  When user enter the submit button
  And user clear the authentication
  Then User enter the meeting button
  Then Create the manual meeting "<MT>"
  Then Create the Action item "<MT>" "<AT1>" "<AD1>" "<UN1>" "<S2>"
  And Update the first Action item "<MT>" "<AT1>" "<AD1>" "<UN2>" "<S1>"
  Then Create the Action item "<MT>" "<AT2>" "<AD2>" "<UN1>" "<S2>"
  Then Create the Action item "<MT>" "<AT3>" "<AD3>" "<UN2>" "<S3>"
  Then Submit the three Action items "<MT>" "<AT1>" "<AT2>" "<AT3>"
  And Send the Mom mail "<MT>"
  And Navigate to the Action item
  Then Add task in action item "<AT1>" "<TT1>" "<TD1>" "<UN>" "<CN1>"
  Then Add task in action item "<AT2>" "<TT2>" "<TD2>" "<UN>" "<CN2>"
  Then Add task in action item "<AT3>" "<TT3>" "<TD3>" "<UN>" "<CN3>"
  Then Navigate to Task and Edit the task in Organizer "<TT1>" "<TT1>" "<TD1>" "<UN>" "<CN2>"
  And Update the Task in Assignee "<TT1>"
  And Overview
  Then Notification
  Then user enter the profile icon button
  Then user enter the profile panel
  Then user enter the profile icon button
  And user enter the logout
  
  Examples:
  | S1   | S2     | S3  | UN                            | UN1                           | UN2                           | PW       | MT                | AT1             | AD1                    | AT2               | AD2               | AT3          | AD3                 | TT1                | TD1                      | TT2                      | TD2                                 | TT3               | TD3                              | UTT                | UTD                      | CN1            | CN2                | CN3       |
  | High | Medium | Low | venkatesh.udaru@ikcontech.com | praveenreddy.g@ikcontech.com  | samyuktha.r@ikcontech.com     | Test@123 | UMS AUtomation    | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Regression testing | Dialy Regression testing | Developing the Operation | Developing the Operation of Product | Developmet Update | Development update today         | Monkey testing     | Monkey testing status    | Organizational | Project Management | External  |
  | High | Medium | Low | praveenreddy.g@ikcontech.com  | venkatesh.udaru@ikcontech.com | samyuktha.r@ikcontech.com     | Test@123 | Automation of UMS | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Sanity testing     | Initial Sanity testing   | Updating the Developing  | Updating the Developing of Product  | Bug Update        | Bug Update today                 | Regression testing | Dialy Regression testing | External       | Technical          | Risk      |
  | High | Medium | Low | samyuktha.r@ikcontech.com     | praveenreddy.g@ikcontech.com  | venkatesh.udaru@ikcontech.com | Test@123 | Scrum Meeting     | qa server setup | Qa server installation | Devops operations | Devops operations | Scrum Status | scrum status report | Smoke testing      | Initial Smoke tesing     | Checking the Developing  | Checking the Developing of Product  | Product Update    | Prdouct current completed update | Smoke testing      | Initial Smoke tesing     | Risk           | Organizational     | Technical |
  @reports
  Scenario Outline: Reports
    Given user open the url "http://localhost:4200/#/"
    Then user enter the "<UN>" and "<PW>"
    When user enter the submit button
    And user clear the authentication
    Then Navigate to reports
    And Navigate to Meetings Organized
    And view the reports "<vn>"
    And Navigate to Meetings Attended
    And view the reports "<vn>"
    And Navigate to Meetings All Departments
    And view the reports "<d1>"
    And Navigate to Action Items Organized
    And view the reports "<vn>"
    And Navigate to Action Items Priority
    And view the reports "<p1>"
    And Navigate to Action Items All Department
    And view the reports "<d2>"
    And Task Items Organized
    And view the reports "<vn>"
    And Task Items Severity
    And view the reports "<p1>"
    And Task Items Status
    And view the reports "<s1>"
    And Task Items Aged
    And Task Items All Departments
    And view the reports "<d2>"
    And Task category Organizational
    And Task category External
    And Task category Risk
    And Task category Project Management
    And Task category Technical
    And Task category Task Category summary "<c1>"
    Then user enter the profile icon button
    And user enter the logout

    Examples: 
      | UN                            | UN1                          | UN2                       | PW        | vn        | vn1     | vn2       | d1                     | d2             | d3      | p1   | p2     | p3  | s1           | s2         | s3        | c1             | c2       | c3   | c4                 | c5        |
      | venkatesh.udaru@ikcontech.com | praveenreddy.g@ikcontech.com | sasirekha.t@ikcontech.com | Test@123 | Venkatesh | Praveen | Samyuktha | Information Technology | Human Resource | Finance | High | Medium | Low | Yet to start | Inprogress | Completed | Organizational | External | Risk | Project Management | Technical |

  @fp
  Scenario Outline: forgot password
    Given user open the url "http://localhost:4200/#/"
    When user clik the Forgot password button
    Then user enter the "<mail>"
    And user enter getotp button
    Then user enter the OTP
    And user enter verify OTP  the button
    Then user enter "<newpassword>" and re enter "<newpassword>"

    Examples: 
      | mail                          | newpassword | status  |
      | venkatesh.udaru@ikcontech.com | Test@123    | success |
      | venkatesh.udaru@ikcontech.com |      123456 | fail    |
