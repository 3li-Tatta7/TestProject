Feature: Invalid Login
  @invalidLog
  Scenario: log in with invalid credentials
    Given User open homepage and click on Login button
    When User logs in with invalid "aaaaaaaaaaaa" and "aaaaaaaaaaaaa"
    Then User should see an "Wrong password." alert
