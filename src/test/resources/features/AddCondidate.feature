#Author: shokriyan@gmail.com
Feature: add Candidates

  Background: 
    Given User enter userName "admin" and password "admin123" and click

  Scenario Outline: Add condidate
    When User click Recruitment Module and click Candidates
    And Click Add
    And Enter "<firstName>" and "<middleName>" and "<lastName>"
    And Enter "<email>" and "<contactNo>"
    Then I see "<jobVacancy>" is displayed
    And I enter any "<keywords>" and any "<comments>"
    And I select a "<DateOfApplication>"
    And User click Save
    Then User see condidate appears in Candidates History "<description>"

    Examples: 
      | firstName | middleName | lastName | email           | contactNo  | jobVacancy       | keywords | comments  | DateOfApplication | description             |
      | Test      | J          | Test     | jsmith@test.com | 1234567890 | Finance Asistant | Test     | Test,test | 19-12-2018        | Admin added Test J Test |

  Scenario Outline: search added condidate
    When User click Recruitment Module and click Candidates
    And I Select All from "<JobTitle>" and "<jobVacancy>"
    And I Select All from the "<HiringManager>" and "<Status>"
    And I Enter "<CandidatesName>" from the previous entry
    And Select "<DateofApplication>"  the previous entry
    And Select "<MethodsOfApplication>" to Manual
    And Click Search button
    Then I see Candidate is present "<CandidateName>"

    Examples: 
      | JobTitle | jobVacancy | HiringManager | Status | CandidatesName | DateofApplication | MethodsOfApplication | CandidateName |
      | All      | All        | All           | All    | Test J Test    | 19-12-2018        | Manual               | Test J Test   |
