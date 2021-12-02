#Author:Pankaj
#Poject Env.:QA Env.
Feature: Login

  @tag1
  Scenario: Successful login with valid credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Logout link
    Then Page Title should be "Your store. Login"
    And close browser


#  @tag2
#  Scenario Outline: Login Data Drieven
#    Given User launch Chrome browser
#    When User opens URL "https://admin-demo.nopcommerce.com/login"
#    And User enters Email as "<email>" and Password as "<password>"
#    And Click on Login
#    Then Page Title should be "Dashboard / nopCommerce administration"
#    When User Click on Logout link
#    Then Page Title should be "Your store. Login"
#    And close browser

#    Examples: 
#      | email               | password |
#      | admin@yourstore.com | admin    |
#      | admin@yourstore.com | admin123 |
#      | admin@yourstore.com | admin1   |
