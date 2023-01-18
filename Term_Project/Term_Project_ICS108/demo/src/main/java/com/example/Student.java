package com.example;

import java.io.Serializable;

public class Student implements Serializable{
  // DATA FIELD:
  private static  String[] finishedCourses;
  //----------
  
  // CONSTRUCTOR:
  public Student()
  {

  } 
  //----------

  // RETURN THE ARRAY OF THE FINISHED COURSES:
  public String[] getFinishedCourses()
  {
    return finishedCourses;
  }
  //----------

  // ADD NEW FINISHED COURSE:
  public String[] addFinishedCourse(String newCourse)
  {
    String[] newArray = new String[finishedCourses.length + 1]; // Creating new array with length + 1
    for(int i = 0; i < finishedCourses.length; i++)
    {
      newArray[i] = finishedCourses[i]; // Copying the array elements
    }
    newArray[newArray.length - 1] = newCourse; // Add the new elements
    return newArray;
  }
  //----------

  // PRINTING THE ARRAY ELEMENTS:
  public String toString()
  {
    String myArray = ""; // Inishlizing the string 
    for(int i=0; i<finishedCourses.length; i++)
    {
      myArray = myArray + finishedCourses[i] + " "; // Adding the elements to the string
    }
    return myArray;
  }
  //----------
}
