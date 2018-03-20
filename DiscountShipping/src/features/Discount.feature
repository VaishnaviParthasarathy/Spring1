Feature: DiscountApplication

Scenario Outline:
Given I open the browser
When "<weight>" and "<distance>" given and Submit button is clicked
Then discount "<result>" should be displayed

Examples:
| weight | distance | result |
| 100 | 200 | Datax shipping company offers discount |
| 80 | 500 | Datax shipping company offers discount |
| 120 | 320 | Datax shipping company offers discount |
| 300 | 200 | Datax shipping company offers discount |
