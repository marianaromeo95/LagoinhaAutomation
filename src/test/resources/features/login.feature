@login
  Feature: Title

    @loginSuccess
    Scenario: Successful login
      Given the user attempts to log in using the email "jpbaterabsb@gmail.com" and password "12345678"
      And clicks the login button
      Then the user should be successfully logged in

    @loginFail


