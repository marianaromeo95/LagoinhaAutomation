@Events
Feature: User Authentication and Password Management


  @eventSuccess
  Scenario: Successful event creation and deletion
    When the user clicks on the create event button
    And inputs the title "Legacy Experience"
    And clicks on the register button
    Then the event should be successfully created and deleted afterwards

  @createMultipleEvents
  Scenario Outline: : Create multiple events
    When the user clicks on the create event button
    And inputs the title <title>
    And clicks on the register button
    Then the event "<title>" should be successfully created and deleted afterwards

    Examples:
      | title                               |
      | Legacy                              |
      | Hope                                |
      | Culto Fe                            |
      | Rock it                             |
      | Mari Romeo Breakfast party          |
      | Joao Birthday bash                  |
      | Luana Sweet sixteen                 |
      | Pera maca chocolate                 |
      | acucar limao e sal                  |

  @emptyTitle
  Scenario: Event creation without a title
    When the user clicks on the create event button
    And clicks on the register button without entering a title
    Then a mandatory title error message should be displayed

    @editEvent
    Scenario: Successfully edit an event
      Given an event with the title "Legacy Experience" exists
      When the user edits the event title to "Culto Hope Terca"
      And description to "Best service of the week"
      Then the event is successfully edited

    @emptyTitleEditEvent
    Scenario: Event editing without a title
      Given an event with the title "Legacy Experience" exists
      When the user edits the event title to ""
      And clicks the save button
      Then a mandatory title error message should be displayed
      And the event should be deleted

    @searchEvent
    Scenario: Event search successfully
      Given an event with the title "Legacy Experience" exists
      When the user searches for "Legacy Experience"
      Then the event should be displayed
