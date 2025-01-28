Feature: Negative Sign-Up

  @existUser
  Scenario: sign up with an existing username
    Given User navigates to the sign-up page
    When User enters "alifathi" and "123456789" and clicks on sign-up
    Then User should see a "This user already exist." message for sign-up