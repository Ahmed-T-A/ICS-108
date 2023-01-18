package com.example;

import java.io.Serializable;

public class Course implements Serializable{
  // DATA FIELD:

  private String[] allSections;
  private String courseName;
  private String courseOfferingPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\CourseOffering.csv";
  private String degreePlanPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\DegreePlan.csv"; 
  //----------

  // CONSTRUCTOR:
  public Course(String courseName)
  {
    ReadFiles course = new ReadFiles(courseOfferingPath);
    allSections = course.readSpecificCourse(courseName); // allSections = array of all sections to this course.
    this.courseName = courseName;
  }
  //----------
  // GET THE PREREQUISITE TO THE COURSE:
  public String[] getPreCourses()
  {
    ReadFiles myFile = new ReadFiles(degreePlanPath);
    String[] courseInfo = myFile.readCourseInfo(courseName);
    String preCourses = courseInfo[2]; // GET ONLY THE PRECOURSES.
    String[] preCoursesArray = preCourses.split("-"); // IF THE COURSE HAS MULTIPLE PRE-COURSES, THIS LINE WILL HANDLE THEM.
    return preCoursesArray;
  }
  //----------

  // GET THE COREQUISITE TO THE COURSE:
  public String[] getCoCourses()
  {
    ReadFiles myFile = new ReadFiles(degreePlanPath);
    String[] courseInfo = myFile.readCourseInfo(courseName);
    String coCourses = courseInfo[3]; // GET ONLY THE CO-COURSES.
    String[] coCoursesArray = coCourses.split("-"); // IF THE COURSE HAS MULTIPLE CO-COURSES, THIS LINE WILL HANDLE THEM.
    return coCoursesArray;
  }
  //----------
}
