@Add_to_cart
Feature: Add to cart
Scenario Outline: Search and add item to the cart
Given User should be present in myntra home page
When User search for "<Item>"
Then "<Item>" page should be displayed
When He selects the first product
Then Product details page should be displayed
When he selects the size as "<Size>"
And he clicks on add to bag
Then Added to bag popup should be displayed
When he clicks on the bag
Then Shopping bag page should be displayed
When he clicks on remove option
And click on remove button
Then Item has been removed should be displayed

Examples:
|Item|Size|
|Shirts|42|
|Heels|41|
|Bangles|2.8|