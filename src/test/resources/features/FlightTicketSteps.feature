Feature: Flight ticket purchasing steps

  Scenario Outline: Filling and filtering the required fields to fly
    Given I'm on the flight ticket screen on the home page
    When I select the departure route "<departureCity>"
    And I select the return route "<returnDepartureCity>"
    And I select the departure date "<departureDate>"
    And I select the return date "<ReturnDate>"
    And I mark the non-stop flight checkbox
    And I select the number of adult passengers as "<adultPassengers>"
    And I select the number of child passengers as "<childPassengers>"
    And I select the number of infant passengers as "<infantPassengers>"
    And I select the cabin class as "<cabinClass>"
    And I submit the form
    Then I should see flight list

    Examples:
      | departureCity | returnDepartureCity | departureDate | ReturnDate | adultPassengers | childPassengers | infantPassengers | cabinClass |
      | Sabiha Gökçen | Erzurum             | 10            | 20         | 3               | 2               | 1                | Ekonomi    |