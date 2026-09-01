Feature: Login Functionality for opencart E-commerce website

  Background:
    Given I am on the OpenCart login page

  @Test(group="sanity")
  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                         |
      | invalid@gmail.com | invalidPassword | Warning: No match for E-mail Address and/or Password. |
      | abccc@gmail.com   | validPassword   | Warning: No match for E-mail Address and/or Password. |
      | valid@gmail.com   | abccc           | Warning: No match for E-mail Address and/or Password. |

  Scenario: Navigating to the forgot password page
      When I click on the "forgottten password" link
      Then I should be redirected to the password reset page