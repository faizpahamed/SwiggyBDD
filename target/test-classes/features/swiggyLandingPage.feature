
Feature: Swiggy Landing Page

Scenario:checking login link functionality
Given user is on landing page
And user clicks on login link
Then verify Login modal popup shows


Scenario:checking signup link functionality
Given user is on landing page
And user clicks on signup link
Then verify Login signup popup shows

Scenario:checking loacte me functionality
Given user is on landing page
And user clicks on locate me
Then verify user is taken to the restaurnt page

