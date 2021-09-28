Feature: Orion Finance Finco Test Scenarios / Credit Application

#Bu feature dosyasında senaryo 1 - TC001 ve TC002 için step defs'te kodlandı. Gherkin cümlesi var.

  Background: System Login
    Given Open the https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/ URL
    Then I see login page

#    user name: 40001 -> Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

  @Finco
  Scenario: TC001 - E2E Credit Application - Legal Customer Application Creation
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait application button element 30 seconds at index 1
    When I click element: application button at index 1
    And I wait credit application introduction button element 30 seconds at index 1
    When I click element: credit application introduction button at index 1
#   'string' olarak bıraktığım bölgeye, tüzel müşteri numarası girilecek.
#   AM test ortamı için '5427' müşteri numarasını kullanıyorum. (Tüzel)
    Then I enter "5427" text to customer no-new application text area at index 1
#   closeview -> büyüteç -> büyüteçlerin xpath'ini sadece @class ile aldım, aynı sayfada birden fazla olduklarında index ile değiştireceğim.
    When I click element: closeview at index 1
    Then I wait row button element 30 seconds at index 27
    When I click element: row button at index 27
    And I wait trade registration no text area element 30 seconds at index 1
    Then I enter "4600" text to trade registration no text area at index 1
    And I wait parties row element 30 seconds at index 1
    When I click element: parties row at index 1
    And I wait row button element 30 seconds at index 1
    When I click element: row button at index 1
#   checkbox tik'lendiğinde kefil seçilmiş oluyor, tekrar run ettiğimizde seçili olursa doğru ilerlemeyecektir.
    And I wait checkbox element 30 seconds at index 1
    When I click element: checkbox at index 1
    And I wait update the guarantor button element 30 seconds at index 1
    When I click element: update the guarantor button at index 1
    And I need to just wait
    When I click element: continue to Reference Information button at index 1
    And I wait shut down button element 30 seconds at index 1
    When I click element: shut down button at index 1

#   Başvuru Bilgileri sekmesine geçtim.
    Then I wait product name selection element 30 seconds at index 1
    When I select element: "DONANIM - YILLIK" under product name selection at index 1
    And I need to just wait
    When I select element: "136 - 30062021 FINCO" under pricing selection at index 1
    And I need to just wait
    Then I enter "3000" text to invoice amount/product quantity text area at index 1
    And I need to just wait
    When I click element: application calender button at index 1
    Then I enter "2" text to maturity text area at index 1
    When I click element: update product button at index 1
    And I wait shut down button element 30 seconds at index 1
    When I click element: shut down button at index 1
    And I wait row pick input element 30 seconds at index 1
    When I click element: row pick input at index 1
    When I click element: create payment plan button at index 1
    And I wait go on button element 30 seconds at index 1
    When I click element: go on button at index 1
    And I wait payment month selection element 30 seconds at index 1
    When I select element: "MART" under payment month selection at index 1
    When I click element: create payment plan button at index 2
    And I wait pop up save button element 30 seconds at index 1
    When I click element: pop up save button at index 1
#    İlerlemek için -> save button (daha önce oluşturmuşuz.) -> 'Continue to Collateral Information button' olarak düşünebiliriz.
    And I wait save button element 30 seconds at index 1
    When I click element: save button at index 1

#    Teminat bilgileri sekmesine geldim.
    And I wait collateral type selection element 30 seconds at index 1
    When I select element: "KEFALET" under collateral type selection at index 1
    When I select element: "5278 - Sibel Eratak" under guarantor selection at index 1
    Then I enter "30" text to collateral margin ratio text area at index 1
    When I click element: add collateral button at index 1
    And I wait shut down button element 30 seconds at index 1
    When I click element: shut down button at index 1
    And I wait continue to Finco Observation button element 30 seconds at index 1
    When I click element: continue to Finco Observation button at index 1

#    Finco Gözlem sekmesine geldim.
    And I wait continue to Financial Information button element 30 seconds at index 1
    When I click element: continue to Financial Information button at index 1

#    Mali Bilgiler sekmesine geldim.
#    Batu -> Buradan sonrasına upload methodu ekliyoruz. Daha düzenlediğim için karışık.
    And I wait upload1 button element 30 seconds at index 1
    When I click element: upload1 button at index 1
    And I need to just wait
    Then I upload the file
    And I need to just wait
    When I click element: load 1st year button at index 1
#    And I wait upload2 button element 30 seconds at index 1
#    Then I upload the "2018.pdf" file to upload2 button at index 1
#    And I need to just wait
#    When I click element: load 2nd year button at index 1
#    And I wait upload3 button element 30 seconds at index 1
#    Then I upload the "2019.pdf" file to upload3 button at index 1
#    And I need to just wait
#    When I click element: load 3rd year button at index 1
#    And I wait upload4 button element 30 seconds at index 1
#    Then I upload the "2020.pdf" file to upload4 button at index 1
#    And I need to just wait
#    When I click element: load 4th year button at index 1
    When I select element: "YMM" under 1st year signing officer selection at index 1
#    Burada kaydetmemiz gereken butonu daha önceden oluşturmuşuz. (Buton ismi biraz yersiz kaldı.)
    When I click element: save button for parameter management at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: shut down button at index 1
    And I wait continue to Documents button element 30 seconds at index 1
    When I click element: continue to Documents button at index 1

#    Evraklar sekmesine geldim. Evrak olarak herhangi bir PDF,excel,word dosyası yükleyebiliriz. Ben 2017.pdf'i yükledim.
    And I wait upload to excel button element 30 seconds at index 1
    When I click element: upload to excel button at index 1
    Then I upload the "2017" file to upload to excel button at index 1
    And I wait upload to excel button element 30 seconds at index 2
    When I click element: upload to excel button at index 2
    Then I upload the "2017" file to upload to excel button at index 2
    And I wait upload to excel button element 30 seconds at index 3
    When I click element: upload to excel button at index 3
    Then I upload the "2017" file to upload to excel button at index 3
    And I wait side selection element 30 seconds at index 1
    When I select element: "TR - 5278 - Sibel Eratak" under side selection at index 1
    And I wait upload to excel button element 30 seconds at index 1
    When I click element: upload to excel button at index 1
    Then I upload the "2017" file to upload to excel button at index 1
    And I wait upload to excel button element 30 seconds at index 2
    When I click element: upload to excel button at index 2
    Then I upload the "2017" file to upload to excel button at index 2
    And I wait upload to excel button element 30 seconds at index 3
    When I click element: upload to excel button at index 3
    Then I upload the "2017" file to upload to excel button at index 3
    And I wait continue to Summary button element 30 seconds at index 1
    When I click element: continue to Summary button at index 1

#    Özet sekmesine geldim.
    And I wait continue to the Registration button element 30 seconds at index 1
    When I click element: continue to the Registration button at index 1

#    Kayıt sekmesine geldim.
    And I wait sending to approval button element 30 seconds at index 1
    When I click element: sending to approval button at index 1
    And I wait warning popup element 30 seconds at index 1
    Then I enter "Test islem onayina sunulmustur. " text to explanation text area at index 1
    When I click element: add comment button at index 1
    Then I enter "Test" text to note text area at index 1
    When I click element: approve the registration button at index 1

#    Burada oluşturulan referans numarasını alarak da devam edebiliriz, fakat müşteri numarasını da biliyoruz.
    And I wait warning popup element 30 seconds at index 1
    When I click element: close button at index 1
    And I wait customer no-new application text area element 30 seconds at index 1

#    Yeni müşteri sayfasını gördükten sonra sistem kapanıyor, OKEY.

#  @Finco
#  Scenario: TC002 - E2E Credit Application - GKTI Customer Operations
#    And I wait loan button element 30 seconds at index 1
#    When I click element: loan button at index 1
#    Then I see loan page
#    And I wait application button element 30 seconds at index 1
#    When I click element: application button at index 1
#    And I wait credit application introduction button element 30 seconds at index 1
#    When I click element: credit application introduction button at index 30
#
##    'string' olarak bıraktığım bölgeye, GKTI müşteri numarası girilecek.
#    Then I enter "<string>" text to customer no-new application text area at index 1
#
##    closeview -> büyüteç -> büyüteçlerin xpath'ini sadece @class ile aldım, aynı sayfada birden fazla olduklarında index ile değiştireceğim.
#    When I click element: closeview at index 1
#
#    Then I click element: continue button at index 1
##    Bu adımdan sonra yeni sekmelere geçiliyor, fakat elimizde data olmadığı için o sekmelere geçiş aktif değil.
#
#  @Finco
#  Scenario: TC003 - E2E Credit Application - Retail Customer Application Operations
#    And I wait loan button element 30 seconds at index 1
#    When I click element: loan button at index 1
#    Then I see loan page
#    And I wait application button element 30 seconds at index 1
#    When I click element: application button at index 1
#    And I wait credit application introduction button element 30 seconds at index 1
#    When I click element: credit application introduction button at index 30
#
##    'string' olarak bıraktığım bölgeye, bireysel müşteri numarası girilecek.
#    Then I enter "<string>" text to customer no-new application text area at index 1
#
##    closeview -> büyüteç -> büyüteçlerin xpath'ini sadece @class ile aldım, aynı sayfada birden fazla olduklarında index ile değiştireceğim.
#    When I click element: closeview at index 1
#
#    Then I click element: continue button at index 1
##    Bu adımdan sonra yeni sekmelere geçiliyor, fakat elimizde data olmadığı için o sekmelere geçiş aktif değil.
#
#  @Finco
#  Scenario: TC004 - E2E Credit Application - Legal Customer Application Update
#    And I wait loan button element 30 seconds at index 1
#    When I click element: loan button at index 1
#    Then I see loan page
#    And I wait application button element 30 seconds at index 1
#    When I click element: application button at index 1
#    And I wait credit application introduction button element 30 seconds at index 1
#    When I click element: credit application introduction button at index 30
#    And I click element: current application at index 1
#
##    'string' olarak bıraktığım bölgeye, tüzel müşteri için başvuru numarası girilecek.
#    Then I enter "<string>" text to application no-current application text area at index 1
#
##    closeview -> büyüteç -> büyüteçlerin xpath'ini sadece @class ile aldım, aynı sayfada birden fazla olduklarında index ile değiştireceğim.
#    When I click element: closeview at index 2
#
#    Then I click element: continue button at index 1
##    Bu adımdan sonra yeni sekmelere geçiliyor, fakat elimizde data olmadığı için o sekmelere geçiş aktif değil.
#
#  @Finco
#  Scenario: TC005 - E2E Credit Application - GKTI Customer Application Update
#    And I wait loan button element 30 seconds at index 1
#    When I click element: loan button at index 1
#    Then I see loan page
#    And I wait application button element 30 seconds at index 1
#    When I click element: application button at index 1
#    And I wait credit application introduction button element 30 seconds at index 1
#    When I click element: credit application introduction button at index 30
#    And I click element: current application at index 1
#
##    'string' olarak bıraktığım bölgeye, GKTI müşteri için başvuru numarası girilecek.
#    Then I enter "<string>" text to application no-current application text area at index 1
#
##    closeview -> büyüteç -> büyüteçlerin xpath'ini sadece @class ile aldım, aynı sayfada birden fazla olduklarında index ile değiştireceğim.
#    When I click element: closeview at index 2
#
#    Then I click element: continue button at index 1
##    Bu adımdan sonra yeni sekmelere geçiliyor, fakat elimizde data olmadığı için o sekmelere geçiş aktif değil.
#
#  @Finco
#  Scenario: TC006 - E2E Credit Application - Refund Application
#    And I wait close system button element 30 seconds at index 1
#    Then I click element: close system button at index 1
#    Then I see login page
#
##    Kullanıcı değişti -> Kredi Tahsis Uzmanı (user name: 3003)
#    Then I enter "3003" text to username text area at index 1
#    Then I enter "" text to password text area at index 1
#    And I wait login button element 30 seconds at index 1
#    When I click element: login button at index 1
#    Then I see home page
#
#    And I wait workflow management button element 30 seconds at index 1
#    When I click element: workflow management button at index 1
#    Then I see workflowManagement page
#    Then I click element: jobs pending on my list button at index 1
#    And I wait reference number area element 30 seconds at index 1
#
##    Burada gerekli referans_no 'string' olarak girilerek işleme devam edilecek.
#    And I enter "<string>" text to reference number area at index 1
#
#    Then I click element: inquire button at index 1
#
##    Burada tamamlanması gereken 2. & 3. madde bulunuyor, ben 4.maddeye geçiyorum.
#    Then I click element: close system button at index 1
#    Then I see login page
#
##    Kullanıcı değişti -> Satış Temsilcisi
#    Then I enter "4000" text to username text area at index 1
#    Then I enter "" text to password text area at index 1
#    And I wait login button element 30 seconds at index 1
#    When I click element: login button at index 1
#    Then I see home page
#
#    And I wait workflow management button element 30 seconds at index 1
#    When I click element: workflow management button at index 1
#    Then I see workflowManagement page
#    Then I click element: jobs pending on my list button at index 1
#
##    Burada referans numarası ile değil, tarihler ile giriş yapacağız!
##    Başlangıç Tarihi -> index:1 / Bitiş Tarihi -> index:2
#    Then I click element: calender button at index 2
#    Then I enter "<string>" text to calender text area at index 1
#    Then I click element: calender button at index 3
#    Then I enter "<string>" text to calender text area at index 1
#    Then I click element: inquire button at index 1
#
##    Devamında ilerletilmesi gereken 2 adım daha var.
#
  @Finco
  Scenario: TC007 - E2E Credit Application - Application Cancel
    And I wait close system button element 30 seconds at index 1
    Then I click element: close system button at index 1
    Then I see login page

#    Kullanıcı değişti -> Kredi Tahsis Uzmanı (user name: 3003)
    Then I enter "3003" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    Then I click element: jobs pending on my list button at index 1
    And I wait reference number area element 30 seconds at index 1

#    Burada gerekli referans_no 'string' olarak girilerek işleme devam edilecek.
    And I enter "<string>" text to reference number area at index 1

    Then I click element: inquire button at index 1

#    Burada tamamlanması gereken 2. & 3. madde bulunuyor, ben 4.maddeye geçiyorum.
    Then I click element: close system button at index 1
    Then I see login page

#    Kullanıcı değişti -> Satış Temsilcisi
    Then I enter "4000" text to username text area at index 1
    Then I enter "" text to password text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page

    And I wait workflow management button element 30 seconds at index 1
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    Then I click element: jobs pending on my list button at index 1

#    Burada tarihler ya da referans numaraması ile giriş yapacağız.
#    Başlangıç Tarihi -> index:1 / Bitiş Tarihi -> index:2
    Then I click element: calender button at index 2
    Then I enter "<string>" text to calender text area at index 1
    Then I click element: calender button at index 3
    Then I enter "<string>" text to calender text area at index 1
    Then I click element: inquire button at index 1

#    Devamında ilerletilmesi gereken 2 adım daha var.

  @Finco
  Scenario: TC008 - E2E Credit Application - Application Cancel when there is a Positive Result of a Credit Application
    And I wait loan button element 30 seconds at index 1
    When I click element: loan button at index 1
    Then I see loan page
    And I wait application button element 30 seconds at index 1
    When I click element: application button at index 1
    When I click element: application cancel button at index 1
    And I wait customer no-application cancel text area element 30 seconds at index 1

#    Burada gerekli müşteri numarası & başvuru numarası, 'string' olarak girilerek işleme devam edilecek.
#    Müşteri numarası -> 5427'i kullanıyorum.

    Then I enter "5427" text to customer no-application cancel text area at index 1
#    And I enter "<string>" text to application no-application cancel text area at index 1
    When I click element: list references button at index 1
    And I wait row select input element 30 seconds at index 1
    When I click element: row select input at index 1
    When I click element: cancel the application button at index 1
    And I wait reason for cancellation selection element 30 seconds at index 1
    When I select element: "MÜŞTERİ VAZGEÇTİ" under reason for cancellation selection at index 1
    When I click element: reason for cancellation selection at index 1
    And I wait application cancel explanation text area element 30 seconds at index 7
    Then I enter "Test iptal." text to application cancel explanation text area at index 7
    And I wait complete process button element 30 seconds at index 6
    When I click element: complete process button at index 6
    And I wait reference number text area element 30 seconds at index 1
    Then I get the information: reference number text area at index 1
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page
    And I wait close system button element 30 seconds at index 1
    Then I click element: close system button at index 1
    And I wait warning popup element 30 seconds at index 1
    Then I click element: yes button at index 1

#    Kullanıcı değişti -> Kredi Tahsis Uzmanı (user name: 3003)
    Then I see login page
    And I wait username text area element 30 seconds at index 1
    Then I enter "3003" text to username text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page
    And I wait close system button element 30 seconds at index 1
    Then I click element: close system button at index 1
    And I wait warning popup element 30 seconds at index 1
    Then I click element: yes button at index 1

#    Kullanıcı değişti -> Operasyon Uzmanı (user name: 3007)
    Then I see login page
    And I wait username text area element 30 seconds at index 1
    Then I enter "3007" text to username text area at index 1
    And I wait login button element 30 seconds at index 1
    When I click element: login button at index 1
    Then I see home page
    When I click element: workflow management button at index 1
    Then I see workflowManagement page
    And I wait jobs pending on my list button element 30 seconds at index 1
    When I click element: jobs pending on my list button at index 1
    Then I enter my reference: "reference number" text to reference number area at index 1
    And I wait inquire button element 30 seconds at index 1
    When I click element: inquire button at index 1
    When I click element: row button at index 1
    And I wait warning popup element 30 seconds at index 1
    When I click element: yes button at index 1
    And I wait approve button element 30 seconds at index 1
    When I click element: approve button at index 1
    And I wait yes button element 30 seconds at index 1
    When I click element: yes button at index 1
    And I need to just wait
    And I wait close button element 30 seconds at index 1
    When I click element: close button at index 1
    Then I see home page
    And I wait close system button element 30 seconds at index 1
    Then I click element: close system button at index 1
    And I wait warning popup element 30 seconds at index 1
    Then I click element: yes button at index 1


