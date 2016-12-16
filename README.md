# UrlShortSpringMVC

CPSC-476-Fall-2016-Url Shortner(Project 3- Spring MVC)
Screenshots: check project doc pdf file
Signup Page:
Figure 1: Our application’s Sign up and Login page is depicted as above. It contains Sign up form on the left side and login form on the right side. Moreover, it has a “Guest User Button” it will take user to a public front page where any user can input a shortened URL and view the original URL without following the link.
Sign Up Form Validations: Password and Confirm Password must match.
Welcome Page:
Short it page:
Figure 2: Dashboard or Main page. Here on the top we are showing the username and email id of user logged in. With button and text boxes as follows:
Logout: will invalidate the session and takes out user from application to sign up page.
Show Hits Page:
Figure 3: View all URLs and its count: It will redirect user to a private page where users can view a list of the URLs they have shortened and the number of clicks each has received. (As shown in Figure 3).
Short It: An input box where users will enter their URLs to be short and will click this button to get them short on the right-hand side. The shortened URL is a hyperlink that will redirect user to the actual page with long URL.
Guest User Page:
Guest users page will just give the functionality of shortening the url, A guest user cannot view all the shorted url later.
Users Table HsqlDb
Figure 4: This figure shows the HSQL Database Manager and the tables created in them. PUBLIC.ALLUSERTABLE contains Username, password of the registered users. PUBLIC.URLHITS contains username along with its LongURL, ShortURL, and hits.
Url Hits HSqlDb

Installation Instructions:
Step 1: Downloading Apache Maven 3.3.9: Download .zip file from apache maven from its repository " https://maven.apache.org/download.cgi"
Step 2: Extract the zip contents.
Step 3: Downloading Apache Ant 3.3.9: Download .zip file from apache ant from its repository " https://ant.apache.org/bindownload.cgi”
Step 4: Extract the zip contents.
Step 5: Copy paste the attached “build.xml” in bin directory of apache ant.
Step 6: Open cmd in bin folder, and run command ant init and after that ant start.
Step 7: Go to bin Folder of apache maven and copy paste "Pom.xml" and "src folder" of the zip file of project attached.
Step 8: Open command prompt in the bin folder of apache maven and run command mvn clean package.
Step 9: After build successful, check UrlShortSpringMVC.war in target folder created.
Step 10: Copy UrlShortSpringMVC.war created to the webapps directory of apache tomcat.
Step 11: Open cmd in bin directory of apache tomcat and run command startup.bat
Step 12: Run command ant manage in command prompt of apache ant
Step 13: Hit URL "http://localhost:8080/UrlShortSpringMVC"
