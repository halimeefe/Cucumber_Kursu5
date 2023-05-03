


#
#// FEATURE FİLE DA SENARYOLAR YAZILIR
#// SENARYOLARIN ÜZERİNE GELİP CTRL YE BASTIĞIMIZDA HANGİ METODDA KULLANILDIĞINI GÖREBİLİRİZ


#      21.03.2023 tarihinde cucumber'a başladık


  #Senaryo
#  siteye git  -> test case -> adım
#  login bilgilerini gir
#  siteye girdiğini doğrula

   @Smoke

Feature: Login Functionality

  Scenario: Login with valid userName and Passsword

    Given Navigate to Campus
    When  Enter username and password and click login button
    Then  User should login succesfully

  

# campüs site url :   https://test.mersys.io/
#
#  kullanıcı adı:   turkeyts

#  şifre :    TechnoStudy123