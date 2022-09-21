@context:API
@RCBPlayerValidation
Feature: RCB Player Validation

  Scenario: validating team has only four foreign player
    Given I am RCB team management
    When I submit the team for upcoming match
    Then I verify team should have only four foreign player

  Scenario: validating team has at least one wicket keeper
    Given I am RCB team management
    When I submit the team for upcoming match
    Then I am notified team has at least one wicket keeper

  Scenario: fail to validate more than four foreign player
    Given I am RCB team management
    When I submit the team for upcoming match
    Then I am notified team has more than four foreign player

  Scenario: validating team has more than one wicket keeper
    Given I am RCB team management
    When I submit the team for upcoming match
    Then I am notified team has more than one wicket keeper
