$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddEmployee.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Andrea Ramirez"
    }
  ],
  "line": 2,
  "name": "US 121335 As an admin, I should have the ability to add, modify and delete an employee.",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Admin should be able to Add Employees",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Add"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I will click on PIM link and then click to the Add Employee Page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I provide the \"\u003cfirst name\u003e\", \"\u003cmiddle name\u003e\" and \"\u003clast name\u003e\" of the employee",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I successfully added an employee",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I navigated to the Employee List Page",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;",
  "rows": [
    {
      "cells": [
        "first name",
        "middle name",
        "last name"
      ],
      "line": 15,
      "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;1"
    },
    {
      "cells": [
        "Bob",
        "L.",
        "Smith"
      ],
      "line": 16,
      "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;2"
    },
    {
      "cells": [
        "Louie",
        "S.",
        "Clark"
      ],
      "line": 17,
      "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;3"
    },
    {
      "cells": [
        "Mark",
        "L.",
        "Antho"
      ],
      "line": 18,
      "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 18556576662,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I logged into OrangeHRM \"admin\" and \"admin123\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 25
    },
    {
      "val": "admin123",
      "offset": 37
    }
  ],
  "location": "EntitlementSteps.i_logged_into_OrangeHRM_and(String,String)"
});
formatter.result({
  "duration": 2728363335,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Admin should be able to Add Employees",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Add"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I will click on PIM link and then click to the Add Employee Page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I provide the \"Bob\", \"L.\" and \"Smith\" of the employee",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I successfully added an employee",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I navigated to the Employee List Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_will_click_on_PIM_link_and_then_click_to_the_Add_Employee_Page()"
});
formatter.result({
  "duration": 2865865703,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bob",
      "offset": 15
    },
    {
      "val": "L.",
      "offset": 22
    },
    {
      "val": "Smith",
      "offset": 31
    }
  ],
  "location": "AddEmployeeSteps.i_provide_the_and_of_the_employee(String,String,String)"
});
formatter.result({
  "duration": 482281305,
  "status": "passed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_successfully_added_an_employee()"
});
formatter.result({
  "duration": 21236622849,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h1[1]\"}\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.15063 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027DESKTOP-2O2VKEV\u0027, ip: \u0027192.168.1.30\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591088 (7b2b2dca23cca0..., userDataDir: C:\\Users\\ALIJAN~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:64252}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 71.0.3578.98, webStorageEnabled: true}\nSession ID: 026b1cac772f6dbaa12fd855baaae898\n*** Element info: {Using\u003dxpath, value\u003d/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h1[1]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy20.getText(Unknown Source)\r\n\tat com.syntax.stepDefinitions.AddEmployeeSteps.i_successfully_added_an_employee(AddEmployeeSteps.java:41)\r\n\tat ✽.Then I successfully added an employee(AddEmployee.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_navigated_to_the_Employee_List_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1003524791,
  "status": "passed"
});
formatter.before({
  "duration": 9327646060,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I logged into OrangeHRM \"admin\" and \"admin123\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 25
    },
    {
      "val": "admin123",
      "offset": 37
    }
  ],
  "location": "EntitlementSteps.i_logged_into_OrangeHRM_and(String,String)"
});
formatter.result({
  "duration": 1885645035,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Admin should be able to Add Employees",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Add"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I will click on PIM link and then click to the Add Employee Page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I provide the \"Louie\", \"S.\" and \"Clark\" of the employee",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I successfully added an employee",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I navigated to the Employee List Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_will_click_on_PIM_link_and_then_click_to_the_Add_Employee_Page()"
});
formatter.result({
  "duration": 1863505843,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Louie",
      "offset": 15
    },
    {
      "val": "S.",
      "offset": 24
    },
    {
      "val": "Clark",
      "offset": 33
    }
  ],
  "location": "AddEmployeeSteps.i_provide_the_and_of_the_employee(String,String,String)"
});
formatter.result({
  "duration": 572226038,
  "status": "passed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_successfully_added_an_employee()"
});
formatter.result({
  "duration": 1225142113,
  "status": "passed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_navigated_to_the_Employee_List_Page()"
});
formatter.result({
  "duration": 1483645586,
  "status": "passed"
});
formatter.after({
  "duration": 788109111,
  "status": "passed"
});
formatter.before({
  "duration": 8048786515,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I logged into OrangeHRM \"admin\" and \"admin123\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 25
    },
    {
      "val": "admin123",
      "offset": 37
    }
  ],
  "location": "EntitlementSteps.i_logged_into_OrangeHRM_and(String,String)"
});
formatter.result({
  "duration": 1743153324,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Admin should be able to Add Employees",
  "description": "",
  "id": "us-121335-as-an-admin,-i-should-have-the-ability-to-add,-modify-and-delete-an-employee.;admin-should-be-able-to-add-employees;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Add"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I will click on PIM link and then click to the Add Employee Page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I provide the \"Mark\", \"L.\" and \"Antho\" of the employee",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I successfully added an employee",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I navigated to the Employee List Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_will_click_on_PIM_link_and_then_click_to_the_Add_Employee_Page()"
});
formatter.result({
  "duration": 1975163035,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mark",
      "offset": 15
    },
    {
      "val": "L.",
      "offset": 23
    },
    {
      "val": "Antho",
      "offset": 32
    }
  ],
  "location": "AddEmployeeSteps.i_provide_the_and_of_the_employee(String,String,String)"
});
formatter.result({
  "duration": 448572951,
  "status": "passed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_successfully_added_an_employee()"
});
formatter.result({
  "duration": 996354018,
  "status": "passed"
});
formatter.match({
  "location": "AddEmployeeSteps.i_navigated_to_the_Employee_List_Page()"
});
formatter.result({
  "duration": 1320326465,
  "status": "passed"
});
formatter.after({
  "duration": 850564898,
  "status": "passed"
});
});