@login @regression
Feature: Log In to Saucedemo Page
	This feature validates some scenarios about log in process.

	Scenario Outline: Login into Sauce Demo page "<username>" and "<password>"
		Given I login with "<username>" and "<password>"
		When 	I validate the following behavior "<validation>"
		
		Examples:
		|	username				|	password				|	validation											|
		|	standard_user		|	secret_sauce		|	Products Page was not displayed	|
		|	incorrect_user	|	incorrect_pass	|	error message is displayed			|

	@logout
	Scenario: Validate Log out action works as expected
		Given I login with "standard_user" and "secret_sauce"
		When 	I logout from the site
		And 	Validate logout was succesfully