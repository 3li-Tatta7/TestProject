Feature: Sign Up feature
  @uniqueSingUp
  Scenario: Sign Up With invalid credential
    Given User open homepage and click on Sing Up button
    When  enter a unique "user" and "pass" and click on Sign Up confirmation button
    Then  User should see a Sign up message