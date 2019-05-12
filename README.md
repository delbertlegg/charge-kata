# AEP Charge Kata

This is an exercise based on the Gist provided for the AEP Charge Kata 
[here](https://gist.github.com/Charge-Aep/6c868cdac615a64b8b1bb024f956cad4)

### Special Instructions

Both the application and the tests expect a `application.properties.local` file in the `resources` folder that define 
the implementation specific properties. For the purposes of this exercise, there are two properties expected in order 
to successfully run the tests:

- `interface.slack.token.user`: This is the token provided by the Slack API to retrieve user information. Note that the
token must include both the `users:read` and `users:read.email` scope in order to retrieve the full details of the user
- `interface.slack.testUser`: This is the ID of a known Slack user. This is supplied for the integration tests to verify 
that the service is functional, the API returns a non-null value and the ID of the response user matches the value 
provided