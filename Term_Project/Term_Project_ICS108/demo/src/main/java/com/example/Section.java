package com.example;

import java.io.Serializable;

public class Section implements Serializable{

  // DATA FIELD:
  private String courseSection;
  private String courseType;
  private String courseCRN;
  private String courseName;
  private String courseInstructor;
  private String courseDays;
  private String courseTime;
  private String courseBuilding;
  private String courseStatus;
  private String courseWaitlist;
  //----------

  // CONSTRUCTOR:
  public Section(String courseSection, String courseType, 
                 String courseCRN, String courseName, 
                 String courseInstructor, String courseDays, 
                 String courseTime, String courseBuilding, 
                 String courseStatus, String courseWaitlist)
  {
    this.courseSection = courseSection;
    this.courseType = courseType; 
    this.courseCRN = courseCRN; 
    this.courseName = courseName; 
    this.courseInstructor = courseInstructor; 
    this.courseDays = courseDays; 
    this.courseTime = courseTime; 
    this.courseBuilding = courseBuilding; 
    this.courseStatus = courseStatus; 
    this.courseWaitlist = courseWaitlist; 
  }
  //----------
  
  // GET THE SECTION SECTION NUMBER:
  public String getCourseSection()
  {
    return courseSection;
  }
  //----------

  // GET THE SECTION TYPE (LEC, LAB):
  public String getCourseType()
  {
    return courseType;
  }
  //----------
  // GET THE COURSE NAME:
  public String getCourseName(){
    return courseName;
  }
  //---------

  // GET THE SECTION DAYS (UTR, MW, UT): 
  public String getCourseDays()
  {
    return courseDays;
  }
  //---------

  // GET THE TIMR OF THE SECTION (FROM HOUR X TO HOUR Y): 
  public String getCourseTime()
  {
    return courseTime;
  }
  //---------
  public int getDuration(){
    String start = this.getCourseTime().substring(0, 4);
    String end = this.getCourseTime().substring(5);
    int startn = Integer.parseInt(start);
    int endn = Integer.parseInt(end);
    int duration = endn - startn;
    int result = 0;
    if(duration == 50){
      result = 30;
    }
    else if(duration == 115){
      result = 48;
    }
    else if(duration == 150){
      result = 66;
    }
    else if(duration == 240){
      result = 96;
    }
    return result;
  }
  public int getDurationEX(){
    String start = this.getCourseTime().substring(0, 4);
    String end = this.getCourseTime().substring(5);
    int startn = Integer.parseInt(start);
    int endn = Integer.parseInt(end);
    int duration = endn - startn;
    int result = 0;
    if(duration == 50){
      result = 5;
    }
    else if(duration == 115){
      result = 8;
    }
    else if(duration == 150){
      result = 11;
    }
    else if(duration == 240){
      result = 16;
    }
    return result;

  }
  //---------
  public boolean timeConflictChecker(Section section){
    String first1 = this.getCourseTime().substring(0, 4);
    String first2 = this.getCourseTime().substring(5);
    String second1 = section.getCourseTime().substring(0, 4);
    String second2 = section.getCourseTime().substring(5);
    int first1n = Integer.parseInt(first1);
    int first2n = Integer.parseInt(first2);
    int second1n = Integer.parseInt(second1);
    int second2n = Integer.parseInt(second2);
    if ((this.getCourseDays().contains(section.getCourseDays())) ||
     (section.getCourseDays().contains(this.getCourseDays()))){
      if (( second1n <= first1n && first1n <= second2n)||( second1n <= first2n && first2n <= second2n)){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }
  public boolean timeConflictCheckerInArray(Section[] sections){
    boolean result = false;
    for (int i = 0; i < sections.length; i++){
      if(sections[i] != null){
        if(this.timeConflictChecker(sections[i]) == true){
          result = true;
          break;
        }
      }
    }
    return result;
  }
  public boolean isDublicated(Section section){
    if ((this.getCourseSection().equals(section.getCourseSection()))
    && (this.getCourseType().equals(section.getCourseType()))){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean isDublicatedInArray(Section[] sections){
    int result = 0;
    for(int i = 0; i < sections.length; i++){
      if (sections[i] != null ){
        if(this.isDublicated(sections[i])){
          result++;
          break;
        }
      }
      else{
        result += 0;
      }
    }
    if (result == 0){
      return false;
    }
    else{
      return true;
    }
  }

  public boolean isDublicatedCourse(Section section){
    if ((this.getCourseName().equals(section.getCourseName()))
    && (this.getCourseType().equals(section.getCourseType()))){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean isDublicatedCourseInArray(Section[] sections){
    int result = 0;
    for(int i = 0; i < sections.length; i++){
      if (sections[i] != null ){
        if(this.isDublicatedCourse(sections[i])){
          result++;
          break;
        }
      }
      else{
        result += 0;
      }
    }
    if (result == 0){
      return false;
    }
    else{
      return true;
    }
  }
}