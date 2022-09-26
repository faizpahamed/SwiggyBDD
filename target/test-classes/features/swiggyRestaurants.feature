Feature: Swiggy Restaurants Page

Scenario:checking filter link functionality
Given user is on restaurants page
And user clicks on the filter option
Then verify filter modal popup shows up

Scenario:checking search link functionality
Given user is on restaurants page
And user clicks on the search link
Then verify search page shows up

Scenario:checking offers link functionality
Given user is on restaurants page
And user clicks on the offers link
Then verify offers page shows up

Scenario:checking help link functionality
Given user is on restaurants page
And user clicks on the help link
Then verify help page shows up