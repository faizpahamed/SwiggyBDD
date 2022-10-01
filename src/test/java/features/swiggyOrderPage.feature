Feature: Swiggy Order Page Functionality



Scenario Outline: Checking cart Empty message for the first time
Given user has entered <location> on landing page
And user has selected <restaurant> from page
And user has enterd order page
And user has no items added to cart
Then verify user can see cart empty message

Examples:
|location	|restaurant	|item |
|Kootupatha Bus Stop|AL-Baith	|Chicken Biryani	|



Scenario Outline: Verifying Checkout option visibility and functionality
Given user has entered <location> on landing page
And user has selected <restaurant> from page
And user has enterd order page
When user clicks on add button of an <item>
And user has no items added to cart
Then checkout option is visible
And user can proceed to checkout page

Examples:
|location	|restaurant	|item |
|Kootupatha Bus Stop|AL-Baith	|Chicken Biryani	|



Scenario Outline: Verifying Checkout items and cart items are same
Given user has entered <location> on landing page
And user has selected <restaurant> from page
And user has enterd order page
When user adds multiple items to cart
And user can proceed to checkout page
Then verify cart items same as checkout item

Examples:
|location	|restaurant	|
|Kootupatha Bus Stop |AL-Baith	|	



#
#Scenario Outline: checking functionality of item counter buttons after item is added to cart 
#
#Given user has entered <location> on landing page
#And user has selected <restaurant> from page
#And user has enterd order page
#When user clicks on add button of an <item>
#And cart counter operator options are visible
#Then verify item counter plus increases item count
#And verify item counter minus decreases item count
#
#Examples:
#|location	|restaurant	|item |
#|Kootupatha Bus Stop|AL-Baith	|Chicken Biryani	|
   