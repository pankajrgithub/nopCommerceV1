Feature: Customers

  Background: All comment steps are here
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on Cutomer menu
    And click on Customer menu item

  @sanity
  Scenario: Add a New Customer
    And click on Add New button
    Then User can view Add a new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "Customers / nopCommerce administration"
    And close browser

  @regression
  Scenario: Serach Customer by emailID
    And Enter customer emailID
    When Click on search button
    Then User should found email in the Search Table
    And close browser

  @regression
  Scenario: Search Customer By Username
    And enter customer fisrtname
    And enter customer lastname
    When Click on search button
    Then User should found name in the Search Table
    And close browser

 # @tag3
 # Scenario: Search Customer by Customer Roles
  #  And User clear the listitem
   # And User selects Role item
    #When Click on search button
    #Then User should found records in table based on customer role
    #And close browser
