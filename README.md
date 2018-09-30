<h3>ContactManager Android App Automation</h3>
<p>I have automated the following three tests for the Contact Manger App:</p>
<ul><li>Verifying UI Elements Vissibility</li><li>Add Contacts Functionality</li><li>Show invisible contact functionality</li></ul>
<h3>Programming Language and Automation Tools</h3>
<ul><li>Programming Language:<b>Java(jdk 1.8)</b></li>
  <li> Build Tool: Maven</li>
  <li> Appium Server:1.6.5 </li>
  <li> Appium Java Client: 6.0.1</li>
  <li> IDE: IntelliJ IDEA 2017.1</li> 
</ul>
<h3>Framework Overview</h3>
<p>The framework is based on page object model where for every page of the application there is a java class in the framework holding methods specific to that particular page. The major components of the framework are:</p>
<ul><li> DriverFactory: singleton Class to intialize the Appium Driver</li> <li> BaseClass: Contians all the reusable methods like find element, isElementPresent, GetElementText, SwipeDownAndFindElement etc..</li><li>PageObjects: Application pages containing page methods and locators</li>
  <li>CentralData.Property: Containing app specific data such as Appname,AppPackage, Waitimeout etc.. </li></ul>
  <h3>Running Tests:</h3>
  <h4> Prerequisites:</h4>
  <ul>
  <li>Java should be installed and environment variables should be set</li>
  <li>Appium Server should be installed</li>
</ul>
<h4>Steps:</h4>
  <ul>
  <li>Start the Appium server at host: 0.0.0.0 and port : 4723</li>
  <li>Connect the device and set the deviceName and PaltformVersion as per your device in "src/test/resources/CentralData.property" file. <br/> <img src="https://preview.ibb.co/emNZKK/data.png" alt="data" border="0"><br /></li>
  <li>Run the "src/test/resources/testng.xml" file:<img src="https://preview.ibb.co/mj5UKK/testng.png" alt="testng" border="0"><br /></li>
  </ul>
