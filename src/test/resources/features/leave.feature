#Author: Mohammad Shokriyan
#Summery:  I should have the ability to add Entitlements to all Default employees.
@Leave
Feature: Ability to add Entitlements

  Background: 
    Given I logged into OrangeHRM "Admin" and "admin123"

  @scenario1
  Scenario: Add entitlement to all default employee
    When I click Leave Module and click add Entitlements
    And Add all default employees to "FMLA US" leave type
    And I Enter "50" Entitlement
    Then I Confirm that all default employees have new Entitlements added for "FMLA US"
      | employeeName     |
      | Linda Anderson   |
      | Russel Hamilton  |
      | Robert Craig     |
      | Steven Edwards   |
      | Thomas Fleming   |
      | Hannah Flores    |
      | Fiona Grace      |
      | Jasmine Morgan   |
      | John Smith       |
      | Ray Bayou Prince |

  @scenario2
  Scenario Outline: Add entitlement for one defual employee
    When I click Leave Module and click add Entitlements
    And Add default employees "<employeeName>" to any leave type besides FMLA US "<leaveType>"
    And I Enter "50" Entitlement
    Then I Confirm that "<employeeName>" has new Entitlements added for new "<leaveType>"

    Examples: 
      | employeeName | leaveType   |
      | John Smith   | Vacation US |

  @scenario3
  Scenario Outline: Assign leave to one employee and check balance
    When I click Leave Module
    And click Assign Leave
    And I enter employee name "<employeeName>"
    And I select leave type "<leaveType>"
    Then Balance of "<balance>" should be present for employee
    And I select From Date "<fromDate>"
    And I select To Date "<toDate>" that doesn’t exceed "<balance>" "<newBalance>" days
    Then I verify new Balance "<fromDate>" and "<toDate>" and "<newBalance>"

    Examples: 
      | employeeName   | leaveType   | balance | fromDate   | toDate     | newBalance |
      | Linda Anderson | FMLA US     |    50.0 | 2018-12-10 | 2018-12-14 |         45 |
      | John Smith     | Vacation US |    50.0 | 2018-12-10 | 2018-12-14 |         45 |

  @scenario4
  Scenario Outline: Leave List report functionality
    When I click Leave Module
    And click Leave List
    And I select From Date "<fromDate>" from previous
    And I select To Date "<toDate>" from previous
    And I select on All "<leaveStatus>" from show leave with the status
    And I enter the default employee name "<emoloyeeName>"
    And I select Sub Unit "<subUnit>"
    Then Click Search
    And Verify that default "<emoloyeeName>" and "<leaveType>" and "<daynums>" appears

    Examples: 
      | fromDate   | toDate     | leaveStatus | emoloyeeName   | subUnit        | leaveType   | daynums |
      | 2018-12-10 | 2018-12-14 | All         | Linda Anderson | Administration | FMLA US     |    5.00 |
      | 2018-12-10 | 2018-12-14 | All         | John Smith     | Administration | Vacation US |    5.00 |
