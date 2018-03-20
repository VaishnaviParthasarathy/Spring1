Feature: NoDiscountApplication

Scenario Outline:
Given I have open the browser
When "<weight>" and "<distance>" are given and Submit button is clicked
Then no discount "<result>" should be displayed

Examples:
| weight | distance | result |
| 60 | 110 | Datax shipping offers no discount |
| 50 | 150 | Datax shipping offers no discount |
