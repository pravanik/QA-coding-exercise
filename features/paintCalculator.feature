@paintcalculator
Feature: Paint Calculator Features


Scenario: Error is displayed if submit is clicked without entering any value
    Given I launch the  url
    When I click submit button without entering any value
    Then I should see required field error

Scenario: Error is displayed if submit is clicked if value entered is less than 1.
    Given I launch the  url
    When I enter any value less than 1 and submit
    Then I should see "enter value greater than or equal to 1" error
    
Scenario: Error is displayed if submit is clicked if value entered is a decimal.
    Given I launch the  url
    When I enter any decimal value
    Then I should see the"Please select a valid value.The two nearest valid numbers.."error.

Scenario Outline: Calculate gallons of paint required
    Given I launch the  url
    When I enter a value for number of rooms and submit <numberOfRooms>
    Then the rooms with dimensions page is displayed
    When we enter length breadth height <numberOfRooms> <length> <breadth> <height>
    And click submit button 
    Then the results page is displayed
    And the amount of feet to paint value is displayed  <length> <breadth> <height>
    And the gallons required is displayed  <length> <breadth> <height>

    Examples: 
      | numberOfRooms | length | breadth | height |
      |             1 |     20 |      20 |     20 |
      |             2 |     10 |10       |     10 |
      
 
