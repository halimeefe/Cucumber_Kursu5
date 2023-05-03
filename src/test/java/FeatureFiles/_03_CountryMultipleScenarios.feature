

  Feature: Country Multi Scenario

    Background: #before senaryo  her zaman bütün senaryolarımızda ilk çalışacak kısımdır
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login succesfully
      And  Navigate to country Page

    Scenario: Create country
      When  create a country
      Then Success message should be displayed

    Scenario:Create a country 2
    When Create a country name as "Avusturya" code as "A777"
      Then  Success message should be displayed