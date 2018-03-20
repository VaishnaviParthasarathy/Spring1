Feature: ShippingApplication

Scenario Outline:
Given I have open the browser
When <ShipmentId> is clicked
Then "<CustomerName>" should be displayed

Examples:
|ShipmentId | CustomerName|
|6543217 | Maya |

