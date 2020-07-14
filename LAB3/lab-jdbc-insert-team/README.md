![Image description](https://i1.faceprep.in/ProGrad/face-logo-resized.png)

# ProGrad Lab | ProGrad Pro Kabbadi League 

ProGrad Pro Kabbadi League is gonna begin in a month from now. Our ProGrad organizers are pretty excited to see the champions. We have nearly 20 teams participating in the league. So, there's a lot of data like players, scores etc that need to be collected and stored to decide the winners at each level.

One of our Database specialist has done half the job by creating an ER diagram to visualise the database structure. That's when we thought we could take your help to take this project to completion as you have just started working with databases.

Can you give it a try?


## What Should You Do
```
Fork this repo
Clone this repo
Practice Java JDBC - connections, class and object
```

## How To Submit
```
Upon completion, run the following commands:

git add .
git commit -m "ProGrad ID"
git push origin master

And finally, create a pull request so your ProGrad Mentor (PM) can review your work.
```

## Instructions

1. ***Do not modify the entire code.***
2. ***Edit the code as per the instructions.***
3. ***Go to Java Resources -> src folder.***
4. ***Your database connection code should exist inside the utlity package.***
5. ***Your CREATE,READ,UPDATE and DELETE operations should exist inside the dao package.***
6. ***Once the progressions are completed follow the instructions to run the application and test your code.***
7. ***Add appropriate jars to your project directory.***
8. ***To add dependencies, right click on your project - select build path - configure build path - select libraries tab - select add external jars and add the downloaded jar files.***

## Requirements

Download ojdbc6.jar from the given link [https://www.oracle.com/database/technologies/jdbcdriver-ucp-downloads.html]

## Progression 0:

1. Right click on src folder and select new - file and name it as jdbc.properties.
2. You can use the jdbc properties given below in the NOTE section.

## Progression 1:

1. Create a class called as `ConnectionManager` inside the utility package.
2. Create a method public static Connection getConnection() which returns a connection object. 
3. Use the method public static Properties loadPropertiesFile() to load the jdbc properties from the jdbc.properties file.

## Progression 2:

1. Create a class called as `Team` inside the model package with below attributes,
	- name - String 
	- coach - String 
	- city - City 
2. Include getter and setter method for all the attributes
3. Include a constructor with below arguments,
	- public Team(String name, String coach, String captain, City city)
 
 
## Progression 3:

1. Create a class called as `City` inside the model package with below attributes,
	- cityld - Long 
	- cityName - String 
2. Include getter and setter method for all the attributes,
3. Include a constructor with below arguments,
	- public City(cityld,cityName)


## Progression 4:

1. Create a dao-class called as `CityDA0` with below methods
	- public City getCityByName(String name) - Method to fetch the city information from database based on the city name.
	- public createCity()- which takes the city class as argument.

## Progression 5:

1. Create a dao-class called as `TeamDAO` to insert user into the database,
	- public void createTeam(Team team) - Method used to insert new team into the database.
	
## Progression 6:
1. Create a main-class called Main inside the controller package.
2. Create appropriate objects for the TeamDAO and CityDAO class.
3. Create appropriate objects for the model classes.
4. Get the values from main class and pass to the createTeam method to store in the database.
5. Call the getCityByName method and display the details of the players.



![1 2](https://user-images.githubusercontent.com/61002120/76416050-5807d380-63c0-11ea-8d52-9e8750e800f9.png)


### Note:

Use the below code to retreive the connection details from mysql.properties to establish connection
```
public static Properties loadPropertiesFile() throws Exception {
	Properties prop = new Properties();	
	InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	prop.load(in);
	in.close(); 
	return prop;
}
```  

Create a file called as jdbc.properites. To create a file right click on the application - new - file - name the file as jdbc.properties.
```
jdbc.properties
#JDBC properties entry for ORACLE server
driver = oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:xe
username=your_username
password=your_password

```
**Sample Input and Output**
```
Enter team name 
England 
Enter coach name 
Pravin Amre 
Enter the city 
Cape Town
Team has been created 
Team Details are: 
Name 			Coach			City
England 		Paddy Upton     	Yorkshire
Australia 		Brad Hodge		Victoria
India 			Sanjay Bangar		Kolkata
England		 	Jacques Kallis		New Orleans
America 		Ricky Ponting		New York
South Africa 		Pravin Amre 		Cape Town
```

Happy Coding ❤️
