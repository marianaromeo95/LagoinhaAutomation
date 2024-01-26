@login
  Feature: User Authentication and Password Management

    @loginSuccess
    Scenario: Successful login
      Given the user attempts to log in using the email "jpbaterabsb@gmail.com" and password "12345678"
      When the user clicks the login button
      Then the user should be successfully logged in

    @loginFail
    Scenario Outline: : Unsuccessful login utilizing wrong email or password
      Given the user attempts to log in using the email <email> and password <password>
      When the user clicks the login button
      Then the system should throw invalid email/password error message

      Examples:
      | email                  | password   |
      | jpbaterabsb1@gmail.com | 12345678   |
      | jpbaterabsbgmailcom    | 12345678   |
      | jpbaterabsb@gmail.com  | 123456789  |

    @passwordIcon
    Scenario: User can toggle password visibility
      Given the user attempts to log in using the email "jpbaterabsb@gmail.com" and password "12345678"
      When the user clicks the password visibility toggle icon
      Then the password field should display the password
      And the user clicks the password visibility toggle icon again
      Then the password field should hide the password