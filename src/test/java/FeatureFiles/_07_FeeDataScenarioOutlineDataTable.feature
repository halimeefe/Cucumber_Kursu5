



#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | <name> |

    Then Success message should be displayed

    Examples:
      |  name    | code| intCode | priority|
      | hlmeFee1 | 258 | payPal   | 12798    |
      | hlmeFee2 | 289 | cash     | 155256   |
      | hlmeFee3 | 456 | cheque   | 125814   |
      | hlmeFee4 | 321 | applePay | 127913   |
      | hlmeFee5 | 957 | crypto   | 188912   |

