@Events
Feature: User Authentication and Password Management

  Background:
    Given the user is authenticated and on the event management page

  @eventSuccess
  Scenario: Successful event creation
    When the user clicks on the create event button
    And inputs the title "Legacy Experience"
    And clicks on the register button
    Then the event "Legacy Experience" should be successfully created

  @eventDelete
  Scenario: Successfully delete an event
    Given an event "Legacy Experience" exists
    When the user selects the delete button for "Legacy Experience"
    And clicks confirm deletion
    Then "Legacy Experience" should be successfully deleted


  @emptyTitle
  Scenario: Event creation without a title
    When the user clicks on the create event button
    And clicks on the register button without entering a title
    Then a mandatory title error message should be displayed

  @createMultipleEvents
  Scenario Outline: : Create multiple events
    When the user clicks on the create event button
    And inputs the title <title>
    And clicks on the register button
    Then the event <title> should be successfully created

    Examples:
      | title                               |
      | Legacy                              |
      | Hope                                |
      | Culto Fe                            |
      | Rock it                             |
      | Lagoinha M*^%$@!!#%(0e82:";'~       |
      | Mari Romeo Breakfast party          |
      | Joao Birthday bash                  |
      | Luana Sweet sixteen                 |
      | Pera maca chocolate                 |
      | acucar limao e sal                  |


  @deleteMultipleEvents
  Scenario Outline: : Delete multiple events
    Given an event <title> exists
    When the user selects the delete button for <title>
    And clicks confirm deletion
    Then <title> should be successfully deleted

    Examples:
      | title                               |
      | Legacy                              |
      | Hope                                |
      | Culto Fe                            |
      | Rock it                             |
      | Lagoinha M*^%$@!!#%(0e82:";'~       |
      | Mari Romeo Breakfast party          |
      | Joao Birthday bash                  |
      | Luana Sweet sixteen                 |
      | Pera maca chocolate                 |
      | acucar limao e sal                  |

    @editEvent
    Scenario: Successfully edit an event
      Given an event with the title "Experience" exists
      When the user edits the event "Experience"
      And changes the title to "Legacy Experience" and adds a description "Best service of the week"
      And clicks the save button
      Then the event is successfully edited

    @emptyTitleEditEvent
    Scenario: Event editing without a title
      Given an event with the title "Legacy Experience" exists
      When the user edits the event "Legacy Experience"
      And erases the title
      And clicks the save button
      Then a mandatory title error message should be displayed

    @searchEvent
    Scenario: Event search successfully
      Given an event with the title "Legacy Experience" exists
      When the user searches for "Legacy Experience"
      Then the event "Legacy Experience" should be displayed
