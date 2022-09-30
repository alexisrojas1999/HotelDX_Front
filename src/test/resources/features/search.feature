Feature:Search
  AS a QAA
  I want to search for a hotel using the website
  to secure a room


  Scenario Outline: Search
    Given  that the user is looking for a hotel
    When the user fills out the following information
      | location     | checkout   |checkin   |room    | adult    | child  |
      | <location>   | <checkout>  | <checkin> |<room>  |<adult>   | <child> |

    Then the user should the available rooms

    Examples:

      | location     | checkout   |checkin  |room|adult|child|
      | Los Angeles  | 10/2/2022  |9/30/2022  | 1 | 1 |  0  |



