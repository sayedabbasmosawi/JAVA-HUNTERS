#Author: Elzada Ekrem
Feature: Performance feature

  Background: 
    Given I logged into OrangeHRM "admin" and "admin123"

  Scenario Outline: add KPI for Performance
    When I click Performance Module and click Configure and click KPI
    And I click add
    And I Select "IT Executive" from  Job Title
    When Enter Key Performance indicator "<KPIs>"
    And Enter Minimum Rating "<MinRate>"
    And Enter Maximum Rating "<MaxRate>"
    And Click Make Default Scale
    And Click Save
    And Select Job Title from Search Key Performance that I chose "IT Executive"
    And click Search 
    Then Validate that Key Performance Indicator has been created
    And Delete created Key Performance Indicator
    And Validate that No Records Found

    Examples: 
      | KPIs     | MinRate | MaxRate |
      | Helpdesk |       6 |      10 |
      
@Temp      
      Scenario: add Tracker for Performance
      When I click Performance Module and click Tracker under Configure
      And I click add button
      And I Enter a Tracker Name "<Ann>"
      And I Enter a Default Employee 
      And I Click "John Smith" in Available Reviewers
      And I Click Add to Assign Reviewers
      And I Click Save
      Then I Validate that Employee is created with Tracker
      And I Delete created Employee
      And I Validate that No Records Found
      
      
      
