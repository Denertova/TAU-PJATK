Feature: Player movement on the board
  Player should not be able to move outside the board
  or move into obstacles

  Scenario: Player tries to move outside the board
    Given a 5x5 board
    And the player is at position (0,0)
    When the player moves "up"
    Then the move should fail

    When the player moves "left"
    Then the move should fail

  Scenario: Player tries to move into an obstacle
    Given a 5x5 board
    And there is an obstacle at position (1,0)
    And the player is at position (0,0)
    When the player moves "down"
    Then the move should fail
