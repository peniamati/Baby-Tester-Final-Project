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
	
  @AddProducts
  Scenario Outline: I try to purchase succesfully
    Given I open the DemoBlaze home page
    And I click category "<category>" section
    And I select "<product>" product
    When I press Add to cart button
    Then I should "<expected>" added product
    
    Examples:  
 		| category | product 			| expected |
    | Phones   | Nexus 6    	| success	 |
    | Laptops  | MacBook air  | success	 |
    | Monitors | ASUS Full HD |	success	 |

	@PurchaseProducts
	Scenario: I confirm purchase
    And I open the DemoBlaze cart page
    And I click on place order button
    And i fill the name="pedro" field
    And i fill the country="argentina" field
    And i fill the city="viedma" field
    And i fill the credit card="1234" field
    And i fill the month="2" field
    And i fill the year="2025" field
    When I click purchase button
    Then I should confirmed purchase
    



