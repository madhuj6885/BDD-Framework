@Actitime
Feature: Login feature
Scenario Outline: Valid Login
Given User should trigger "http://localhost/login.do" 
When User enter "<username>" as username
And He enters "<password>" as password
And He clicks on login button 
Then Home Page should be displayed
Examples: 
|username|password|
|admin|manager|
#|manager|admin|
#|admin|admin|