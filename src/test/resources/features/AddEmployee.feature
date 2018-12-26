#Author: Andrea Ramirez
Feature: US 121335 As an admin, I should have the ability to add, modify and delete an employee.

  Background: 
    Given I logged into OrangeHRM "admin" and "admin123"

  @Add
  Scenario Outline: Admin should be able to Add Employees
    When I will click on PIM link and then click to the Add Employee Page
    Then I provide the "<first name>", "<middle name>" and "<last name>" of the employee
    Then I successfully added an employee
    And I navigated to the Employee List Page

    Examples: 
      | first name | middle name | last name |
      | Bob     	 | L.          | Smith     |
      | Louie      | S.          | Clark     |
      | Mark       | L.          | Antho     |

  @Search
  Scenario Outline: Search and Edit Employee
    And I navigated to the Employee List Page
    When I search for an "<addedemployee>" 
    And selected that employee "<firstName>" 
    Then I navigated to the employee profile
    And I can edit Employee information "<fName>","<lName>" 

    Examples: 
      | addedemployee | firstName   |fName	|lName  |
      | Bob L. Smith  | Bob L.    	|Charly	|Markle |
      | Louie S. Clark | Louie S.   |Eddy		|Boris	|
      | Mark L. Antho  | Mark L.    |Nick		|Lee		|

  @Delete
  Scenario Outline: Search and Delete Employee
    When I navigated to the Employee List Page
    Then I search for the "<editted>" added employee
    Then I should be able to delete that employee
    	
    	Examples:
     |editted    		|
     |Charly Markle |
     |Eddy Boris		|
     |Nick Lee			|
     
