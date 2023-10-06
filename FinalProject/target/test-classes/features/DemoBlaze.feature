#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Purchase
Feature: Purchase order
	As a user
	I want to add two or more products to the cart and proceed with the purchase by placing the order
	
  @PurchaseProducts
  Scenario: I try to purchase succesfully
    Given I am at the home page and I added 3 products to cart
    And I open the DemoBlaze cart page
    And I click on place order button
    And I fill the inputs
    When I click purchase button
    Then I should confirmed purchase
