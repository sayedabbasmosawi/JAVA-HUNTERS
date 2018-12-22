#Author: Abbas
@Vacancy
Feature: User should have the ability to add Vacancies
Background:
    Given I logged into OrangeHRM by entering username "Admin" and password "admin123"

  @Vacancy1
  Scenario: add Vacancies
    When I click Recruitment Module and click Vacancies
    And Click Add
    And Select "CEO" to job Title dropdown
    And Enter Vacancy Name "Finance Asistant"
    And Enter Hiring Manager to "John Smith"
    And Enter Number Of Positions "1"
    And Enter Description "Staff cavancies description"
    And I Click Save
    Then I see vacancy details name "John Smith" and  job Title "CEO" are displayed

  @Vacancy2
  Scenario: check Vacancies
    When I click Recruitment Module and click Vacancies
    And Select Job Title that matches previous entry "CEO"
    And Select Vacancy to Vacancy name that matches previous entry "Finance Asistant"
    And Select Hiring Manager to "John Smith"
    And Select Status to "All"
    Then Click Search
    Then I see vacancy details name "John Smith" and  job Title "CEO" are displayed

  @Vacancy3
  Scenario: delete Vacancies
    When I click Recruitment Module and click Vacancies
    And Select Job Title that matches previous entry "CEO"
    And Select Vacancy to Vacancy name that matches previous entry "Finance Asistant"
    And Select Hiring Manager to "John Smith"
    And Select Status to "All"
    Then Click Search
    And Validate Vacancy appears name "John Smith" and  job Title "CEO" are displayed
    And Check the Checkbox of created Vacancy
    And Click Delete
    Then I see the message "No Records Found"
