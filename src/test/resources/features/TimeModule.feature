#Tannaz Nazar
@time
Feature: Time Module Feature

  Background: 
    Given I logged into OrangeHRM "Admin" and "admin123"

  @Adding
  Scenario Outline: adding customers
    And I am on Time Module
    When I click Project info
    And I select Customers
    And I click on Add button
    And I add "<CustomerName>"and "<Description>"
    And I click Save
    And I see that "<CustomerName>" is displayed in the Customers table

    Examples: 
      | CustomerName | Description |
      | Tannaz Nazar | Desc1       |
      | Mamad Shoki  | Desc2       |

  @Reporting
  Scenario Outline: Creating a project
    And I am on Time Module
    When I click Project info
    And I select Projects
    And I click on Add button
    And I enter "<customername>" from the previous entry
    And I add the "<projectName>"
    And I select "<projectAdmin>" from default employees
    And I click Save
    And I navigate to project report
    And I see "<customername>" and "<projectAdmin>" is saved

    Examples: 
      | customername | projectName  | projectAdmin  |
      | Tannaz Nazar | projectName1 | Hannah Flores |
      | Mamad Shoki  | projectName2 | Hannah Flores |
@Verifying
  Scenario Outline: ability to search project customers
    And I am on Time Module
    When I click Project info
    And I select Projects
    And I enter "<customername>" from the previous entry
    And I enter "<projectName>" from the previous entry
    And I Click Search
    Then I see "<customername>" and "<projectName>" is displayed

    Examples: 
      | customername | projectName  |
      | Tannaz Nazar | projectName1 |
      | Mamad Shoki  | projectName2 |
