# Overview
###### This is an android-based educational quiz application, specifically for providing insights in the area of Natural Disasters.
###### There are 8 Questions in total. The Questions incorporates Text Inputs (EditText), Checkboxes, RadioButoons, and ImageViews.
###### This Project was developed using java and xml with Android Studio as the Integrated Development Environment.
###### It constitutes the final challenge (#7DaysofCodeChallenge) of the Google Africa Scholarship Challenge for scholars on the Android Basics Track. I am a scholar on the Android Basics Track and the experience of taking on a project of this magnitude (however basic it might seem) is second to none.
# Design
#### 1. Styling
###### The application layout consist of a single xml (_activity_main.xml_). It however incorporates nested view groups as shown in the _activity_main.xml_. The scrollable nature of the application is achieved using a ScrollView as the parent of every possible view available within the xml layout. Consistency was maintained in the margins for each View element. There are two ImageViews in total all sitting in the _drawables_ folder with file formats of .png
###### The strings.xml file contains the strings for all 8 questions. The naming convention uses an underscore for separating words
###### The Application theme along with a custome fontSize and fontFamily is defined in the _styles.xml_ and duly referenced in the main layout
###### A Single button exist for submittion is placed down the bottom at the middle inside a RelativeLayout for a better aesthetic effect
#### 2. Program Logic and Workflow
###### The _MainActivity.java_ file contains the logic that adds functionality to the layout.
###### It contains the 3 Private Methods and 1 Public method. The methods are describe as thus
###### 1. *computeScore()* : This a public method called when the button on the xml is clicked. It Computes the total points earned from the questions. It uses The _trim()_ method to remove white trailing and leading spaces to help curb issues with autocorect features adding the aforementioned spaces. Objects are created for each input View element available on the xml layout to correctly get the values or states of the selected input element. Also, checks are carried out to ensure that a value is selected or checked or entered via the Mobile device's keyboard. A _Toast_ is used to display the result of the quiz.
###### 2. *editTextType()* : This is a private method still within the _MainActivity.java_ to award points to questions of type _EditText_. It returns _point_ with a return type of _int_.
###### 3. *checkBoxType()* : This is a private method still within the _MainActivity.java_ to award points to questions of type _CheckBox_ . It returns _point_ with a return type of _int_.
###### 4. *radioButtonType()* : This is a private method still within the _MainActivity.java_ to award points to questions of type _RadioButton_. It returns _point_ with a return type of _int_.
#### 3. Program Challenges
###### 1. Catch and erase white trailing spaces for user input of type _editText_. I solved this problem using the _trim()_ method on a view object.
###### 2. Reset score after each toast message displaying score. I solved this by equating the variable _point_ to zero after the _Toast_
###### 3. Convert all string input to lower cases to help my _if ... else_ condition for checking for correctness. I solved this using the  _toLowerCase()_ on the view object created.
#### 4 Testing
###### 1. The interface was tested in Portrait and Landscape modes. The application showed consistency on a real device with each orientation mode maintaning the visual information with no loss of view element
###### 2. The accuracy of the answers were tested. Leading spaces and trailing spaces were added to _ediText_ type and the java code processed the i put properly. Also, test was carried out to check against displaying or running any method if no option was selected for all questions and on individual questions.
#### 5. Support
###### Feel free to contact me for questions, enquiries, concerns, corrections and suggestions. My handle on slack is *@Victor Etim*.
###### My mail is victoretim961@gmail.com.
###### My Mobile number is +2348163478000


