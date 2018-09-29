<h3>ContactManager Android App Automation</h3>
<p>There are total three tests developed for testing Contact Manger App</p>
<ul><li>Verifying UI Elements Vissibility</li><li>Add Contacts Functionality</li><li>Show invisible contact functionality</li></ul>
<h3>Framework Overview</h3>
<p>The framework is based on page object model where for every page of the application there is a java class holding methods specific to that particular page. The major components of the framework are:</p>
<ul><li> DriverFactory: singleton Class to intialize the Appium Driver</li> <li> BaseClass: Having all the reusable methods like find element, isElementPresent, GetElementText, SwipeDownAndFindElement etc..</li><li>PageObjects: Containing application pages and locators</li>
  <li>CentralData.Property: Containing app specific data such as Appname,AppPackage, Waitimeout etc.. </li></ul>
  <h3>Running Tests:</h3>
  <ul>
  <li>Start the Appium server at host: 0.0.0.0 and port : 4723</li>
  <li>Connect the device and change the data such as deviceName and PaltformVersion as per your device "src/test/resources/CentralData.property" file. <br/> <img src="https://preview.ibb.co/emNZKK/data.png" alt="data" border="0"><br /></li>
  <li>Run the "src/test/resources/testng.xml" file:<img src="https://preview.ibb.co/mj5UKK/testng.png" alt="testng" border="0"><br /></li>
  
  </ul>
