#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

   # OUTLİNE BİZİM VERDİĞİMİZ DATALARA GÖRE OLUŞTURUR
   # AYNI ZAMANDA BİR DEFADA BİR ÇOK BİLGİYİ GİRME KOLAYLIĞI VERİR

  @Regression

Feature: Citizenship Functionality

    Background:  # before senaryo
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login succesfully
      And Navigate to CitizenShip page

    Scenario Outline: CitizenShip create
      When User a CitizenShip name as "<name>" short name as "<short>"
      Then Success message should be displayed

      When User a CitizenShip name as "<name>" short name as "<short>"
      Then Already exist message should be displayed

      When User delete the "<name>"
      Then Success message should be displayed

      Examples:
        | name | short |
        | HLM2114 | h214 |
        | HLM2114 | h214 |
        | HLM34  | h34 |
        | HLM 44 | h44 |