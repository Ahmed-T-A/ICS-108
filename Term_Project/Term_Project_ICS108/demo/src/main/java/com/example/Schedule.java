package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Schedule implements Serializable{
  // DATA FIELD:
  private Section[] sections;
  private Section[] selectedSections;
  private String savedSchedulesPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\demo\\savedSchedules\\";
  private String courseOfferingPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\CourseOffering.csv";
  private String degreePlanPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\DegreePlan.csv"; 
  private String finishedCoursesPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\FinishedCourses.csv";
  //----------

  // CONSTRUCTOR:
  public Schedule(){
    this.sections = new Section[1];
    this.selectedSections = new Section[1];
  }
  //----------
  public Section[] getSections(){
    return sections;
  }
  public Section[] getSelectedSections(){
    return selectedSections;
  }
  //----------
  public void setSections(Section[] sections){
    this.sections = sections;
  }
  public void setSelectedSections(Section[] selectedSections){
    this.selectedSections = selectedSections;
  }
  // ADD COURSE TO THE SCHEDULE:
  public void addSection(Section section){
    if ((this.getSections().length == 1 ) && (this.getSections()[0] == null )){
      this.getSections()[0] = section;
    }
    else{
      Section[] newArray = new Section[sections.length + 1];
      for(int i = 0; i < sections.length; i++)
      {
        newArray[i] = sections[i];
      }
      newArray[newArray.length - 1] = section;
      this.sections = newArray;
    }
  }
  public void addSelectedSection(Section section){
    if ((this.getSelectedSections().length == 1 ) && (this.getSelectedSections()[0] == null )){
      this.getSelectedSections()[0] = section;
    }
    else{
      Section[] newArray = new Section[selectedSections.length + 1];
      for(int i = 0; i < selectedSections.length; i++)
      {
        newArray[i] = selectedSections[i];
      }
      newArray[newArray.length - 1] = section;
      this.selectedSections = newArray;
    }
  }
  //----------
  public void removeSection(Section section){
    if(this.getSections().length == 1){
      this.getSections()[0] = null;
    }
    else{
      Section[] newArray = new Section[sections.length - 1];
      boolean selecter = true;
      for(int i = 0; i < newArray.length; i++){
        if((sections[i] == section) && (selecter)){
          newArray[i] = sections[i + 1];
          selecter = false;
        }
        else if (selecter == true){
          newArray[i] = sections[i];
        }
        else if (selecter == false){
          newArray[i] = sections[i + 1];
        }
      }
      this.sections = newArray;
    }
  }
  public void removeSelectedSection(Section section){
    if(this.getSelectedSections().length == 1){
      this.getSelectedSections()[0] = null;
    }
    else{
      Section[] newArray = new Section[selectedSections.length - 1];
      boolean selecter = true;
      for(int i = 0; i < newArray.length; i++){
        if((selectedSections[i] == section) && (selecter)){
          newArray[i] = selectedSections[i + 1];
          selecter = false;
        }
        else if (selecter == true){
          newArray[i] = selectedSections[i];
        }
        else if (selecter == false){
          newArray[i] = selectedSections[i + 1];
        }
      }
      this.selectedSections = newArray;
    }
  }
  public void writeInBinaryFile(String path){
    try{
    FileOutputStream theBinaryFile = new FileOutputStream(savedSchedulesPath + path + ".dat");
    ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
    output.writeObject(this);
    output.close();
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
}