

Feature: DataTable Ornek
  #Spesifik değer göndermeK için dataTable kullanırız

  Scenario: Users List
    When Write username "ismet"
    And Write username and Password "ismet" and "1234"
    And Write username as DataTable
      | kismet  |
      | mmehmet |
      | aayşe   |
      | kkaya   |

    And Write username and password as DataTable
      | kismet  | 12341 |
      | mmehmet | 23242 |
      | aayşe   | 45453 |
      | kkaya   | 45544 |