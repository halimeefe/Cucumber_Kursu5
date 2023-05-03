


@Regression

Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput |halimeULKE1     |
      | codeInput | hlm1313   |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | halimeULKE1|

    Then Success message should be displayed



  Scenario: Create Nationality

    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | halimeNTLY |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      |halimeNTLY |

    Then Success message should be displayed


  Scenario: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput       |halime111 |
      | codeInput       | hlm11   |
      | integrationCode | paypal     |
      | priorityCode    | 111   |

    And Click on the element in Dialog
      | saveButton |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      |halime111|

    Then Success message should be displayed


