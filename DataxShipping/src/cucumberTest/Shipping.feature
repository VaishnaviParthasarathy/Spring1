Feature: ShippingApplication
Application is launched

Scenario:Given i open browser
When i open shipping website
When weight is "100" and mode of transport is "air" 
Then result should be Dear Customer, your total shipping cost is $100

Scenario:Given i open browser
When i open shipping website
When weight is "100" and mode of transport is "road" 
Then result should be Dear Customer, your total shipping cost is $50

Scenario:Given i open browser
When i open shipping website
When weight is "100" and mode of transport is "ship" 
Then result should be Dear Customer, your total shipping cost is $70