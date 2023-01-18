package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles implements Serializable{
  
  // DATA FIELD:
  private File file;

  //----------

  // CONSTRUCTORS:
  public ReadFiles(String path){
    this.file = new File(path);
  }
  //----------

  // THIS METHOD TAKE THE NAME OF THE COURSE AND RETUTN AN ARRAY OF THE SECTIONS OF THAT COURSE.
  public String[] readSpecificCourse(String courseName)
  {
    try
    {
      Scanner input = new Scanner(this.file);
      Scanner input2 = new Scanner(this.file);
      int counter = 0;
      String line, line2;

      // THIS WHILE LOOP IS FOR CALCULATING THE NUMBER OF SECTIONS OF THE COURSE.
      while(input.hasNext()){
        line = input.nextLine();
        if (line.contains(courseName)){ // read the line and increament the counter of the line contain the given course name.
          counter += 1;
        }
      }
      
      // THIS PART IS FOR ADDING THE SECTIONS TO THE ARRAY.
      String[] courses = new String[counter];
      int i = 0;
      while(input2.hasNext())
      {
        line2 = input2.nextLine();
        if ((line2.contains(courseName)))
        {
          courses[i] = line2;
          i++;
        }
      }
      input.close();
      input2.close();

      return courses;
    }

    catch(FileNotFoundException e)
    {
      String[] massage = {e.getMessage()};
      return massage;
    }
  }
  //----------

  // THIS METHOD TAKE THE NAME OF THE COURSE AND RETURN ITS DEGREE PLAN:
  // DEGREE PLAN FILE:
  public String[] readCourseInfo(String courseName)
  {
    try
    {
      Scanner input = new Scanner(this.file);
      String line, myLine = "";

      while(input.hasNext()){
        line = input.nextLine();
        if ((line.contains(courseName))){
          myLine = line;
          break;
        }
      }
      String[] information = myLine.split(",");
      input.close();
      return information;
    }

    catch(FileNotFoundException e)
    {
      String[] massage = {e.getMessage()};
      return massage;
    }
  }


  // not finished yet......
  public ArrayList<String> readFinishedCourses()
  {
    try
    {
      Scanner input = new Scanner(this.file);
      ArrayList<String> finishedCourses = new ArrayList<>();
      String line;

      // // THIS WHILE LOOP IS FOR CALCULATING THE NUMBER OF SECTIONS OF THE COURSE.
      while(input.hasNext())
      {
        line = input.nextLine();
        String[] lineArray = line.split(",");
        finishedCourses.add(lineArray[0]);
      }
      input.close();
      
      return finishedCourses;
    }

    catch(FileNotFoundException e)
    {
      ArrayList<String> massage = new ArrayList<>();
      massage.add(e.getMessage());
      return massage;
    } 
  }
}
