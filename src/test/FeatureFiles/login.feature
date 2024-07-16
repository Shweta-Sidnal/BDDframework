Feature: user login test

Background:
  Given navigate to login page of Saucelabs

  Scenario: Login Elements visibility verification
    Then sauce labs logo is present on screen
    And Username inputbox is visible
    And Password inputbox is visible
    And Login button is visible

   Scenario Outline: Login Sucessful with Valid Username and Password
     Given Enter the username as "<User_name>"
     And Entre the Password as "<Password>"
     When Click on Login button
     Then Login is as "<Message>"
     Examples:
     |User_name|Password|Message|
     |standard_user|secret_sauce|Login Sucess|
     |standard_use |secret_sauce|Epic sadface: Username and password do not match any user in this service|
     |standard_user|secret_sauc|Epic sadface: Username and password do not match any user in this service|
     |locked_out_user|secret_sauce|Epic sadface: Sorry, this user has been locked out.|




