package com.example;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application{
    // DATA FIELD
    Scene scene1, scene2, scene3;
    GridPane mainPain = new GridPane(); // THE MAIN PANE OF THE FIRST PAGE
    StackPane root = new StackPane();   // SCROLL PANE FOR PAGE 1 
    VBox a = new VBox();                // THE COURSES THAT APPERAR IN THE SCROLL PANE 1
    VBox basket = new VBox(5);
    VBox addedToSchedule = new VBox(5);
    GridPane holePage = new GridPane(); // THE MAIN PANE FOR PAGE 2
    GridPane schedule = new GridPane(); // THE SCHEDULE GRID PANE
    GridPane realSchedule = new GridPane();
    VBox savedScheduals = new VBox(10);
    ComboBox<String> sections = new ComboBox<>();
    ComboBox<String> departments = new ComboBox<>();
    String savedSchedulesPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\demo\\savedSchedules";
    String courseOfferingPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\CourseOffering.csv";
    String finishedCoursesPath = "C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Term_Project\\Term_Project_ICS108\\FinishedCourses.csv";
    CheckBox darkMood = new CheckBox("Dark Mood");

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Course Offering");
        stage.getIcons().add(new Image("kfupm-logo.png"));
        // MAIN PAGE:
        // Grid pane settings:
        RowConstraints topRow = new RowConstraints();
        RowConstraints midRow = new RowConstraints();
        RowConstraints buttomRow = new RowConstraints();
        ColumnConstraints leftCol = new ColumnConstraints();
        ColumnConstraints midCol = new ColumnConstraints();
        ColumnConstraints rightCol = new ColumnConstraints();
        topRow.setPercentHeight(15);
        midRow.setPercentHeight(75);
        buttomRow.setPercentHeight(20);
        leftCol.setPercentWidth(10);
        midCol.setPercentWidth(80);
        rightCol.setPercentWidth(10);
        mainPain.getRowConstraints().addAll(topRow, midRow, buttomRow);
        mainPain.getColumnConstraints().addAll(leftCol, midCol, rightCol);
        //--------------------------
        Text page1 = new Text("Add Courses"); // Title of the 1st page.
        page1.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 50));
        page1.setFill(Color.MEDIUMSEAGREEN);

        Button next = new Button("Next"); // GOING FROM SCENE 1 TO SCENE 2
        next.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
        next.setOnAction(e -> {stage.setScene(scene2);});

        Button saved = new Button("Start with a saved Schedule"); // GOING FROM SCENE 1 TO SCENE 3
        saved.setWrapText(true);
        saved.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';"); 
        saved.setOnAction(e -> {stage.setScene(scene3);});
        //--------------------------
        // THIS SCROLL PANE DISPLAY THE SECTIONS
        ScrollPane scrollPane = new ScrollPane(a);
        scrollPane.setFitToHeight(true);
        BorderPane root = new BorderPane(scrollPane);
        root.setPadding(new Insets(15));
        //--------------------------
        // COMBO BOX FOR COURSES:
        ComboBox<String> sections = new ComboBox<>();
        ComboBox<String> departments = new ComboBox<>();
        sections.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");
        departments.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");    
        sections.setPrefWidth(110);
        sections.setPromptText("courses");
        departments.setPromptText("Departments");
        
        String[] MATH_dep     = { "MATH101", "MATH102", "MATH201","MATH208","STAT319"};
        String[] PHYS_dep     = {"PHYS101","PHYS102"};
        String[] CHEM_dep     = {"CHEM101"};
        String[] ENGL_dep     = {"ENGL101","ENGL102","ENGL214","CGS 392"};
        String[] IAS_dep      = {"IAS 111","IAS 121","IAS 212","IAS 321"};
        String[] PE_dep       = {"PE  101"};
        String[] COE_dep      = {"COE 292","COE 233"};
        String[] ISE_dep      = {"ISE 291"};
        String[] BUS_dep      = {"BUS 200"};
        String[] GS_dep       = {"GS  318"};
        String[] SWE_dep      = {"SWE 206","SWE 216","SWE 316","SWE 363","SWE 326","SWE 387","SWE 399","SWE 439","SWE 411","SWE 412"};
        String[] ICS_dep      = {"ICS 104", "ICS 108", "ICS 202","ICS 253","ICS 321", "ICS 343","ICS 344","ICS 433","ICS 353","ICS 442","ICS 381"};
        String[] departments1 = {"MATH","PHYS","CHEM","ENGL","IAS","PE","COE","ISE","BUS","GS","SWE","ICS"};

        departments.getItems().addAll(departments1);
        departments.setOnAction(e-> {
            if(departments.getValue().equals("MATH")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(MATH_dep);
            }
            else if(departments.getValue().equals("PHYS")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(PHYS_dep);
            }
            else if(departments.getValue().equals("CHEM")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(CHEM_dep);
            }
            else if(departments.getValue().equals("ENGL")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(ENGL_dep);
            }
            else if(departments.getValue().equals("IAS")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(IAS_dep);
            }
            else if(departments.getValue().equals("PE")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(PE_dep);
            }
            else if(departments.getValue().equals("COE")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(COE_dep);
            }
            else if(departments.getValue().equals("ISE")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(ISE_dep);
            }
            else if(departments.getValue().equals("BUS")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(BUS_dep);
            }
            else if(departments.getValue().equals("GS")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(GS_dep);
            }
            else if(departments.getValue().equals("SWE")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(SWE_dep);
            }
            else if(departments.getValue().equals("ICS")){
                sections.getItems().removeAll(sections.getItems());
                sections.getItems().addAll(ICS_dep);
            }
        });
        // TAKE THE SELCTED SECTION AND DISPLAY IT IN THE SCROLL PANE
        sections.setOnAction(ex -> displaySections(sections.getValue()));

        VBox q = new VBox(15);
        q.getChildren().addAll(departments,sections);
        q.setAlignment(Pos.CENTER);
        
        //--------------------------
        // Adding elements to the main pane:
        mainPain.add(page1, 1, 0);
        mainPain.add(next, 2, 2);
        mainPain.add(saved, 1, 2);
        mainPain.add(root, 1, 1);
        mainPain.add(q, 0, 1);
        mainPain.add(darkMood,0,2);
        GridPane.setHalignment(page1, HPos.CENTER);
        GridPane.setHalignment(next, HPos.CENTER);
        GridPane.setHalignment(saved, HPos.CENTER);
        GridPane.setHalignment(root, HPos.CENTER);
        GridPane.setValignment(q, VPos.TOP);
        GridPane.setHalignment(darkMood, HPos.CENTER);
        //--------------------------
        scene1 = new Scene(mainPain, 1300, 650);
        stage.setScene(scene1);

        //=================================================
        // PAGE 2:
        HBox savedScheduleButton = new HBox(5); // SAVE SCHEDULE BUTTON AND THE TEXT FIELD
        Button main = new Button("Main"); // GO FROM PAGE 2 TO PAGE 1
        main.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
        main.setOnAction(e -> {stage.setScene(scene1);});
        Button saveSchedule = new Button("Save Schedule"); // SAVE THE SCHEDULE IN A SPECIFIC FILE
        saveSchedule.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  

        ScrollPane scrollPane2 = new ScrollPane(basket); // DISPLAY THE SELECTED SECTIONS IN THE BASKET
        scrollPane2.setFitToHeight(true);
        scrollPane2.setMinWidth(12);
        BorderPane root2 = new BorderPane(scrollPane2);
        ScrollPane scrollPane3 = new ScrollPane(addedToSchedule); // DISPLAY THE ADDED SECTIONS IN THE SCHEDULE
        scrollPane3.setFitToHeight(true);
        scrollPane3.setMinWidth(12);
        BorderPane root3 = new BorderPane(scrollPane3);
        root2.getChildren().add(main);

        
        // THE PAGE ALLIMENTS
        RowConstraints topRow2 = new RowConstraints();
        RowConstraints middleRow2 = new RowConstraints();
        RowConstraints buttomRow2 = new RowConstraints();
        ColumnConstraints leftCol2 = new ColumnConstraints();
        ColumnConstraints MiddleCol2 = new ColumnConstraints();
        ColumnConstraints rightCol2 = new ColumnConstraints();
        topRow2.setPercentHeight(10);
        middleRow2.setPercentHeight(80);
        buttomRow2.setPercentHeight(10);
        leftCol2.setPercentWidth(12);
        MiddleCol2.setPercentWidth(76);
        rightCol2.setPercentWidth(12);
        holePage.getRowConstraints().addAll(topRow2,middleRow2, buttomRow2);
        holePage.getColumnConstraints().addAll(leftCol2,MiddleCol2, rightCol2);
        holePage.setGridLinesVisible(false);

        RowConstraints Row1 = new RowConstraints();
        RowConstraints Row2 = new RowConstraints();
        RowConstraints Row3 = new RowConstraints();
        RowConstraints Row4 = new RowConstraints();
        RowConstraints Row5 = new RowConstraints();
        RowConstraints Row6 = new RowConstraints();
        RowConstraints Row7 = new RowConstraints();
        RowConstraints Row8 = new RowConstraints();
        RowConstraints Row9 = new RowConstraints();
        RowConstraints Row10 = new RowConstraints();
        RowConstraints Row11 = new RowConstraints();
        RowConstraints Row12 = new RowConstraints();
        RowConstraints Row13 = new RowConstraints();
        RowConstraints Row14 = new RowConstraints();
        RowConstraints Row15 = new RowConstraints();
        RowConstraints Row16 = new RowConstraints();
        RowConstraints Row17 = new RowConstraints();
        RowConstraints Row18 = new RowConstraints();
        RowConstraints Row19 = new RowConstraints();
        RowConstraints Row20 = new RowConstraints();
        RowConstraints Row21 = new RowConstraints();
        RowConstraints Row22 = new RowConstraints();
        RowConstraints Row23 = new RowConstraints();
        RowConstraints Row24 = new RowConstraints();
        RowConstraints Row25 = new RowConstraints();
        RowConstraints Row26 = new RowConstraints();
        RowConstraints Row27 = new RowConstraints();
        RowConstraints Row28 = new RowConstraints();
        RowConstraints Row29 = new RowConstraints();
        RowConstraints Row30 = new RowConstraints();
        RowConstraints Row31 = new RowConstraints();
        RowConstraints Row32 = new RowConstraints();
        RowConstraints Row33 = new RowConstraints();
        RowConstraints Row34 = new RowConstraints();
        RowConstraints Row35 = new RowConstraints();
        RowConstraints Row36 = new RowConstraints();
        RowConstraints Row37 = new RowConstraints();
        RowConstraints Row38 = new RowConstraints();
        RowConstraints Row39 = new RowConstraints();
        RowConstraints Row40 = new RowConstraints();
        RowConstraints Row41 = new RowConstraints();
        RowConstraints Row42 = new RowConstraints();
        RowConstraints Row43 = new RowConstraints();
        RowConstraints Row44 = new RowConstraints();
        RowConstraints Row45 = new RowConstraints();
        RowConstraints Row46 = new RowConstraints();
        RowConstraints Row47 = new RowConstraints();
        RowConstraints Row48 = new RowConstraints();
        RowConstraints Row49 = new RowConstraints();
        RowConstraints Row50 = new RowConstraints();
        RowConstraints Row51 = new RowConstraints();
        RowConstraints Row52 = new RowConstraints();
        RowConstraints Row53 = new RowConstraints();
        RowConstraints Row54 = new RowConstraints();
        RowConstraints Row55 = new RowConstraints();
        RowConstraints Row56 = new RowConstraints();
        RowConstraints Row57 = new RowConstraints();
        RowConstraints Row58 = new RowConstraints();
        RowConstraints Row59 = new RowConstraints();
        RowConstraints Row60 = new RowConstraints();
        RowConstraints Row61 = new RowConstraints();
        RowConstraints Row62 = new RowConstraints();
        RowConstraints Row63 = new RowConstraints();
        RowConstraints Row64 = new RowConstraints();
        RowConstraints Row65 = new RowConstraints();
        RowConstraints Row66 = new RowConstraints();
        RowConstraints Row67 = new RowConstraints();

        ColumnConstraints Col1 = new ColumnConstraints();
        ColumnConstraints Col2 = new ColumnConstraints();
        ColumnConstraints Col3 = new ColumnConstraints();
        ColumnConstraints Col4 = new ColumnConstraints();
        ColumnConstraints Col5 = new ColumnConstraints();
        ColumnConstraints Col6 = new ColumnConstraints();
        double heightxxx = 8.0/6.0;
        Row1.setPercentHeight(12);
        Row2.setPercentHeight(heightxxx);
        Row3.setPercentHeight(heightxxx);
        Row4.setPercentHeight(heightxxx);
        Row5.setPercentHeight(heightxxx);
        Row6.setPercentHeight(heightxxx);
        Row7.setPercentHeight(heightxxx);
        Row8.setPercentHeight(heightxxx);
        Row9.setPercentHeight(heightxxx);
        Row10.setPercentHeight(heightxxx);
        Row11.setPercentHeight(heightxxx);
        Row12.setPercentHeight(heightxxx);
        Row13.setPercentHeight(heightxxx);
        Row14.setPercentHeight(heightxxx);
        Row15.setPercentHeight(heightxxx);
        Row16.setPercentHeight(heightxxx);
        Row17.setPercentHeight(heightxxx);
        Row18.setPercentHeight(heightxxx);
        Row19.setPercentHeight(heightxxx);
        Row20.setPercentHeight(heightxxx);
        Row21.setPercentHeight(heightxxx);
        Row22.setPercentHeight(heightxxx);
        Row23.setPercentHeight(heightxxx);
        Row24.setPercentHeight(heightxxx);
        Row25.setPercentHeight(heightxxx);
        Row26.setPercentHeight(heightxxx);
        Row27.setPercentHeight(heightxxx);
        Row28.setPercentHeight(heightxxx);
        Row29.setPercentHeight(heightxxx);
        Row30.setPercentHeight(heightxxx);
        Row31.setPercentHeight(heightxxx);
        Row32.setPercentHeight(heightxxx);
        Row33.setPercentHeight(heightxxx);
        Row34.setPercentHeight(heightxxx);
        Row35.setPercentHeight(heightxxx);
        Row36.setPercentHeight(heightxxx);
        Row37.setPercentHeight(heightxxx);
        Row38.setPercentHeight(heightxxx);
        Row39.setPercentHeight(heightxxx);
        Row40.setPercentHeight(heightxxx);
        Row41.setPercentHeight(heightxxx);
        Row42.setPercentHeight(heightxxx);
        Row43.setPercentHeight(heightxxx);
        Row43.setPercentHeight(heightxxx);
        Row44.setPercentHeight(heightxxx);
        Row45.setPercentHeight(heightxxx);
        Row46.setPercentHeight(heightxxx);
        Row47.setPercentHeight(heightxxx);
        Row48.setPercentHeight(heightxxx);
        Row49.setPercentHeight(heightxxx);
        Row50.setPercentHeight(heightxxx);
        Row51.setPercentHeight(heightxxx);
        Row52.setPercentHeight(heightxxx);
        Row53.setPercentHeight(heightxxx);
        Row54.setPercentHeight(heightxxx);
        Row55.setPercentHeight(heightxxx);
        Row56.setPercentHeight(heightxxx);
        Row57.setPercentHeight(heightxxx);
        Row58.setPercentHeight(heightxxx);
        Row59.setPercentHeight(heightxxx);
        Row60.setPercentHeight(heightxxx);
        Row61.setPercentHeight(heightxxx);
        Row62.setPercentHeight(heightxxx);
        Row63.setPercentHeight(heightxxx);
        Row64.setPercentHeight(heightxxx);
        Row65.setPercentHeight(heightxxx);
        Row66.setPercentHeight(heightxxx);
        Row67.setPercentHeight(heightxxx);

        Col1.setPercentWidth(10);
        Col2.setPercentWidth(18);
        Col3.setPercentWidth(18);
        Col4.setPercentWidth(18);
        Col5.setPercentWidth(18);
        Col6.setPercentWidth(18);

        realSchedule.getRowConstraints().addAll(Row1,Row2,Row3,Row4,Row5,Row6,Row7,Row8,Row9,Row10,Row11,Row12,Row13
        ,Row14,Row15,Row16,Row17,Row18,Row19,Row20,Row21,Row22,Row23,Row24,Row25,Row26,Row27,Row28,Row29,Row30,Row31
        ,Row32,Row33,Row34,Row35,Row36,Row37,Row38,Row39,Row40,Row41,Row42,Row43,Row44,Row45,Row46,Row47,Row48,Row49
        ,Row50,Row51,Row52,Row53,Row54,Row55,Row56,Row57,Row58,Row59,Row60,Row61,Row62,Row63,Row64,Row65,Row66,Row67);
        realSchedule.getColumnConstraints().addAll(Col1,Col2,Col3,Col4,Col5,Col6);

        RowConstraints rRow1 = new RowConstraints();
        RowConstraints rRow2 = new RowConstraints();
        RowConstraints rRow3 = new RowConstraints();
        RowConstraints rRow4 = new RowConstraints();
        RowConstraints rRow5 = new RowConstraints();
        RowConstraints rRow6 = new RowConstraints();
        RowConstraints rRow7 = new RowConstraints();
        RowConstraints rRow8 = new RowConstraints();
        RowConstraints rRow9 = new RowConstraints();
        RowConstraints rRow10 = new RowConstraints();
        RowConstraints rRow11 = new RowConstraints();
        RowConstraints rRow12 = new RowConstraints();
        ColumnConstraints rCol1 = new ColumnConstraints();
        ColumnConstraints rCol2 = new ColumnConstraints();
        ColumnConstraints rCol3 = new ColumnConstraints();
        ColumnConstraints rCol4 = new ColumnConstraints();
        ColumnConstraints rCol5 = new ColumnConstraints();
        ColumnConstraints rCol6 = new ColumnConstraints();
        rRow1.setPercentHeight(12);
        rRow2.setPercentHeight(8);
        rRow3.setPercentHeight(8);
        rRow4.setPercentHeight(8);
        rRow5.setPercentHeight(8);
        rRow6.setPercentHeight(8);
        rRow7.setPercentHeight(8);
        rRow8.setPercentHeight(8);
        rRow9.setPercentHeight(8);
        rRow10.setPercentHeight(8);
        rRow11.setPercentHeight(8);
        rRow12.setPercentHeight(8);

        rCol1.setPercentWidth(10);
        rCol2.setPercentWidth(18);
        rCol3.setPercentWidth(18);
        rCol4.setPercentWidth(18);
        rCol5.setPercentWidth(18);
        rCol6.setPercentWidth(18);

        schedule.getRowConstraints().addAll(rRow1,rRow2,rRow3,rRow4,rRow5,rRow6,rRow7,rRow8,rRow9,rRow10,rRow11,rRow12);
        schedule.getColumnConstraints().addAll(rCol1,rCol2,rCol3,rCol4,rCol5,rCol6);

        Text sunday = new Text("Sunday");
        Text monday = new Text("Monday");
        Text tuesday = new Text("Tuesday");
        Text wednesday = new Text("Wednesday");
        Text thursday = new Text("Thursday");

        Text first = new Text("07:00 -> 08:00");
        Text second = new Text("08:00 -> 09:00");
        Text third = new Text("09:00 -> 10:00");
        Text forth = new Text("10:00 -> 11:00");
        Text fifth = new Text("11:00 -> 12:00");
        Text sixth = new Text("12:00 -> 13:00");
        Text seventh = new Text("13:00 -> 14:00");
        Text eigth = new Text("14:00 -> 15:00");
        Text ninth = new Text("15:00 -> 16:00");
        Text tenth = new Text("16:00 -> 17:00");
        Text eleventh = new Text("17:00 -> 18:00");
        
        schedule.add(sunday,1,0);
        schedule.add(monday,2,0);
        schedule.add(tuesday,3,0);
        schedule.add(wednesday,4,0);
        schedule.add(thursday,5,0);

        schedule.add(first,0,1);
        schedule.add(second,0,2);
        schedule.add(third,0,3);
        schedule.add(forth,0,4);
        schedule.add(fifth,0,5);
        schedule.add(sixth,0,6);
        schedule.add(seventh,0,7);
        schedule.add(eigth,0,8);
        schedule.add(ninth,0,9);
        schedule.add(tenth,0,10);
        schedule.add(eleventh,0,11);

        GridPane.setHalignment(sunday, HPos.CENTER);
        GridPane.setHalignment(monday, HPos.CENTER);
        GridPane.setHalignment(tuesday, HPos.CENTER);
        GridPane.setHalignment(wednesday, HPos.CENTER);
        GridPane.setHalignment(thursday, HPos.CENTER);
        GridPane.setHalignment(first, HPos.CENTER);
        GridPane.setHalignment(second, HPos.CENTER);
        GridPane.setHalignment(third, HPos.CENTER);
        GridPane.setHalignment(forth, HPos.CENTER);
        GridPane.setHalignment(fifth, HPos.CENTER);
        GridPane.setHalignment(sixth, HPos.CENTER);
        GridPane.setHalignment(seventh, HPos.CENTER);
        GridPane.setHalignment(eigth, HPos.CENTER);
        GridPane.setHalignment(ninth, HPos.CENTER);
        GridPane.setHalignment(tenth, HPos.CENTER);
        GridPane.setHalignment(eleventh, HPos.CENTER);
        schedule.setGridLinesVisible(false);

        StackPane doubleSchedule = new StackPane();
        doubleSchedule.getChildren().addAll(schedule,realSchedule);

        // THIS CHECK BOX IS TO MAKE THE BORDERS OF THE SCHEDULE VISIBIL OR NOT
        CheckBox scheduleVisibilty = new CheckBox("Schedule Borders");
        scheduleVisibilty.setFont(new Font(14));
        scheduleVisibilty.setOnAction(e->{
            if(scheduleVisibilty.isSelected()){
                schedule.setGridLinesVisible(true);
            }
            else{
                schedule.setGridLinesVisible(false);
            }
        });


        Label basketMessage = new Label("         Basket");
        Label removeingLabel = new Label("< click to remove >\n     from schedule");
        basketMessage.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
        removeingLabel.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 17px 'serif';"); 

        Text secondPageTitle = new Text("Schedule");
        secondPageTitle.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 50));
        secondPageTitle.setFill(Color.MEDIUMSEAGREEN);
        
        // THIS TEXT FIELD IS TO CHOOSE THE NAME OF THE FILE THAT YOU WANT TO SAVE THE SCHEDULE IN
        TextField fileName = new TextField();
        fileName.setMinWidth(320);
        fileName.setPromptText("Type a name for the schedule before saving");
        fileName.setFont(new Font(15.5));
        savedScheduleButton.getChildren().addAll(saveSchedule, fileName);
        savedScheduleButton.setAlignment(Pos.CENTER);
        saveSchedule.setOnAction(e -> {
            mySchedule.writeInBinaryFile(fileName.getText());
        });
        
        holePage.add(main,2,2);
        holePage.add(savedScheduleButton,1,2);
        holePage.add(doubleSchedule, 1, 1);
        holePage.add(scheduleVisibilty,0,2);
        holePage.add(root2, 2, 1);   
        holePage.add(root3, 0, 1);  
        holePage.add(basketMessage, 2, 0);
        holePage.add(secondPageTitle, 1, 0);
        holePage.add(removeingLabel, 0, 0);  
 
        GridPane.setHalignment(secondPageTitle, HPos.CENTER);
        GridPane.setHalignment(main, HPos.CENTER);
        GridPane.setHalignment(saveSchedule, HPos.CENTER);
        GridPane.setHalignment(root2, HPos.CENTER);
        holePage.setAlignment(Pos.BASELINE_RIGHT);
        holePage.setPadding(new Insets(40,40,40,40));
        scene2 = new Scene(holePage,1300, 650);
        //=================================================
        // Saved Schedules page:
        GridPane x = new GridPane();
        RowConstraints RowSaved1 = new RowConstraints();
        RowConstraints RowSaved2 = new RowConstraints();
        RowConstraints RowSaved3 = new RowConstraints();
        ColumnConstraints ColSaved1 = new ColumnConstraints();
        RowSaved1.setPercentHeight(10);
        RowSaved2.setPercentHeight(80);
        RowSaved3.setPercentHeight(10);
        ColSaved1.setPercentWidth(100);
        x.getRowConstraints().addAll(RowSaved1, RowSaved2);
        x.getColumnConstraints().add(ColSaved1);
        x.setAlignment(Pos.CENTER);

        Text pageLable = new Text("Saved schedules");
        pageLable.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 50));
        pageLable.setFill(Color.MEDIUMSEAGREEN);

        Button mainPage = new Button("main Page"); // GOING FROM PAGE 3 TO PAGE 1
        mainPage.setStyle("-fx-font-size: 1.5em; ");
        mainPage.setOnAction(e -> {stage.setScene(scene1);});
        Button schedualPage = new Button("Schedual Page"); // GOING FROM PAGE 3 TO PAGE 2 
        schedualPage.setStyle("-fx-font-size: 1.5em; ");
        schedualPage.setOnAction(e -> {stage.setScene(scene2);});
        
        

        HBox savedbuttons = new HBox(10);
        savedbuttons.getChildren().addAll(schedualPage, mainPage);
        savedbuttons.setAlignment(Pos.CENTER);

        File file = new File(savedSchedulesPath);
        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++){
            int v = i;
            VBox h = new VBox(10);
            Button k = new Button("     Select     ");
            k.setStyle("-fx-font-size: 1.3em; ");
            Text myFileName = new Text(files[i].getName());
            myFileName.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.REGULAR, 30));
            myFileName.setFill(Color.BLACK);
            myFileName.setStrokeWidth(0.3);
            Text partition = new Text("<........................................................"+
            "..................................................................................."+
            "..................................................................................."+
            "..................................................................................."+
            "..................................................................................."+
            "....................................................>");
            k.setOnAction(e -> { 
                readSavedSheduals(files[v]);
                h.getChildren().removeAll(myFileName, k, partition);
            });
            h.getChildren().addAll(myFileName, k, partition);
            savedScheduals.getChildren().add(h);
        }
        

        ScrollPane scrollPane4 = new ScrollPane(savedScheduals);
        scrollPane4.setFitToHeight(true);
        scrollPane4.setPadding(new Insets(20,20,20,20));
        BorderPane root4 = new BorderPane(scrollPane4);
        root4.setPadding(new Insets(70));

        x.add(pageLable,0,0);
        x.add(scrollPane4,0,1);
        x.add(savedbuttons,0,2);
        x.setPadding(new Insets(30,30,30,30));
        GridPane.setHalignment(scrollPane4, HPos.CENTER);
        GridPane.setHalignment(pageLable, HPos.CENTER);
        GridPane.setHalignment(savedbuttons, HPos.CENTER);
        scene3 = new Scene(x,1300, 650);
        //=================================================
        // THE DARK MODE THEME SETTING 
        darkMood.setOnAction(e->{
            if(darkMood.isSelected()){
                // Page1
                mainPain.setStyle("-fx-background-color: #585858;"); 
                saved.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818; -fx-font: normal bold 20px 'serif';");  
                next.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                sections.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");
                departments.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");  
                darkMood.setStyle("-fx-text-fill: white;"); 
                scrollPane.setStyle("-fx-background: #585858; -fx-border-color: #90EE90;");
                // Page2
                holePage.setStyle("-fx-background-color: #585858;"); 
                main.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                saveSchedule.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';"); 
                scrollPane2.setStyle("-fx-background: #585858; -fx-border-color: #90EE90;"); 
                scrollPane3.setStyle("-fx-background: #585858; -fx-border-color: #90EE90;"); 
                basketMessage.setStyle("-fx-text-fill: white;  -fx-font: normal bold 20px 'serif';");  
                removeingLabel.setStyle("-fx-text-fill: white;  -fx-font: normal bold 17px 'serif';"); 
                fileName.setStyle("-fx-background-color: #E8E8E8;  -fx-font: normal bold 15px 'serif';"); 
                sunday.setFill(Color.WHITE);
                monday.setFill(Color.WHITE);
                tuesday.setFill(Color.WHITE);
                wednesday.setFill(Color.WHITE);
                thursday.setFill(Color.WHITE);
                first.setFill(Color.WHITE);
                second.setFill(Color.WHITE);
                third.setFill(Color.WHITE);
                forth.setFill(Color.WHITE);
                fifth.setFill(Color.WHITE);
                sixth.setFill(Color.WHITE);
                seventh.setFill(Color.WHITE);
                eigth.setFill(Color.WHITE);
                ninth.setFill(Color.WHITE);
                tenth.setFill(Color.WHITE);
                eleventh.setFill(Color.WHITE);
                scheduleVisibilty.setStyle("-fx-text-fill: white;"); 
                schedule.setStyle("-fx-border-color: #90EE90; -fx-border-style: solid inside;"); 
                // Page3
                x.setStyle("-fx-background-color: #585858;"); 
                mainPage.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818; -fx-font: normal bold 20px 'serif';");
                schedualPage.setStyle("-fx-background-color: #B8B8B8; -fx-text-fill: #181818; -fx-font: normal bold 20px 'serif';");
                scrollPane4.setStyle("-fx-background: #585858; -fx-border-color: #90EE90;"); 
            }
            else{
                //Page1
                mainPain.setStyle("-fx-background-color: #F8F8F8;");
                next.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                saved.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';"); 
                sections.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");  
                departments.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 13px 'serif';");  
                darkMood.setStyle("-fx-text-fill: #181818;");  
                scrollPane.setStyle("-fx-background: #F8F8F8; -fx-border-color: #90EE90;");  
                // Page 2:
                holePage.setStyle("-fx-background-color: #F8F8F8;");
                main.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                saveSchedule.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                scrollPane2.setStyle("-fx-background: #F8F8F8; -fx-border-color: #90EE90;");  
                scrollPane3.setStyle("-fx-background: #F8F8F8; -fx-border-color: #90EE90;");  
                basketMessage.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");  
                removeingLabel.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 17px 'serif';"); 
                fileName.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 15px 'serif';");  
                sunday.setFill(Color.BLACK);
                monday.setFill(Color.BLACK);
                tuesday.setFill(Color.BLACK);
                wednesday.setFill(Color.BLACK);
                thursday.setFill(Color.BLACK);
                first.setFill(Color.BLACK);
                second.setFill(Color.BLACK);
                third.setFill(Color.BLACK);
                forth.setFill(Color.BLACK);
                fifth.setFill(Color.BLACK);
                sixth.setFill(Color.BLACK);
                seventh.setFill(Color.BLACK);
                eigth.setFill(Color.BLACK);
                ninth.setFill(Color.BLACK);
                tenth.setFill(Color.BLACK);
                eleventh.setFill(Color.BLACK);
                scheduleVisibilty.setStyle("-fx-text-fill: #181818;");  
                // Page3
                x.setStyle("-fx-background-color: #F8F8F8;");
                mainPage.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 20px 'serif';");
                schedualPage.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 18px 'serif';");
                scrollPane4.setStyle("-fx-background: #F8F8F8; -fx-border-color: #90EE90;"); 
            }
        });
        stage.show();
    }

    Schedule mySchedule = new Schedule(); // THIS IS THE SCHEDULE THAT HAS BEEN ADDED TO THE SCHEDULE
    public void displaySections(String course){
        // REMOVE ALL THE ELEMENTS IN SCROLL PANE 1
        a.getChildren().removeAll(a.getChildren());

        ReadFiles finishedCoursesFile = new ReadFiles(finishedCoursesPath);
        ArrayList<String> finishedCourses = finishedCoursesFile.readFinishedCourses(); // FINISHED COURSES ARRAY LIST
        Course thisCourseClass = new Course(course); 
        String[] preCourses = thisCourseClass.getPreCourses(); // PRECOURSES ARRAY OF THIS COURSE
        List<String> preCoursesList = Arrays.asList(preCourses); // CONVERTING THE ARRAY TO LIST

        /*
         * READ THE COURSE OFFERING FILE
         * GO TO THE CHOOSEN COURSE 
         * SPERATE THE ELEMENTS OF THE COURSE WITH |
         * [COURSE SEC, COURSE TYPE, CRN, COURSE NAME, INSTRUCTOR, DAYS, TIME, LOCATION, COURSE STATUS, WAITLIST STATUS]
         */
        ReadFiles x = new ReadFiles(courseOfferingPath);
        String[] coursesArray = x.readSpecificCourse(course);
        a.setPadding(new Insets(10,10,10,10));
        for(int i = 0; i < coursesArray.length; i++){
            String[] section = coursesArray[i].split(",");
            String w = section[0] + " | " + section[1] + " | " + section[2] + " | " + section[3] + " | " +
            section[4] + " | " + section[5] + " | " + section[6] + " | " + section[7] + " | " + section[8]
            + " | " + section[9];
            
            Section thisCourse = new Section(section[0],section[1],section[2],section[3],section[4],
            section[5],section[6],section[7],section[8],section[9]);

            
            
            Text s = new Text(w);
            Text Divider = new Text("•·····················•·········································"+
            "·························································································"+
            "·························································································"+
            "·························································································"+
            "·····································•");
            Button addCourse = new Button("ADD");
            

            int classLength = thisCourse.getDuration();
            
            int[] red = {157,255,141,255,255};
            int[] green = {222,210,193,254,133};
            int[] blue = {186,150,251,150,136};
            int colorSelecter = (int)(Math.random()*5);
            Rectangle rectangle = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));
            Rectangle rectangle1 = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));
            Rectangle rectangle2 = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));

           

            StackPane scheduleCell = new StackPane();
            StackPane scheduleCell1 = new StackPane();
            StackPane scheduleCell2 = new StackPane();



            scheduleCell.getChildren().addAll(rectangle, new Label(section[0]+"  |  "+section[6]));
            scheduleCell1.getChildren().addAll(rectangle1, new Label(section[0]+"  |  "+section[6]));
            scheduleCell2.getChildren().addAll(rectangle2, new Label(section[0]+"  |  "+section[6]));

            //===========================================================
            String startingTimeH = section[6].substring(0, 2);
            int startingTimeHI = Integer.parseInt(startingTimeH);

            String startingTimeM = section[6].substring(2, 3);
            int startingTimeMI = Integer.parseInt(startingTimeM);

            int loc = (startingTimeHI - 06) + ((startingTimeHI - 07)*5) + startingTimeMI;
            int classDurationEX = thisCourse.getDurationEX();
            //===========================================================

            Button g = new Button(section[0]+" | "+section[1]);
            g.setStyle("-fx-font-size: 1.1em; ");
            Button gg = new Button(section[0]+" | "+section[1]);
            gg.setStyle("-fx-font-size: 1.1em; ");

            addCourse.setOnAction(e ->{
                if((mySchedule.getSelectedSections().length == 1 ) && mySchedule.getSelectedSections()[0] == null){
                    addCourse.setText("< ADDED >");
                    s.setFill(Color.SEAGREEN);
                    mySchedule.addSelectedSection(thisCourse);
                    basket.getChildren().add(g);
                    if (true){
                        g.setOnAction( h -> {
                            if ((((!(thisCourse.timeConflictCheckerInArray(mySchedule.getSections())) 
                                || (mySchedule.getSections().length == 1 && mySchedule.getSections()[0] == null)) 
                                && !(thisCourse.isDublicatedCourseInArray(mySchedule.getSections()))) 
                                && (finishedCourses.containsAll(preCoursesList) 
                                && !finishedCourses.contains(course))))
                            {
                                mySchedule.addSection(thisCourse);
                                if(section[5].equals("U")){
                                    realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("M")){
                                    realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("T")){
                                    realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("W")){
                                    realSchedule.add(scheduleCell, 4, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("R")){
                                    realSchedule.add(scheduleCell, 5, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("UT")){
                                    realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                    realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("MW")){
                                    realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX); 
                                    realSchedule.add(scheduleCell1, 4, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("TR")){
                                    realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX); 
                                    realSchedule.add(scheduleCell1, 5, loc, 1, classDurationEX);
                                }
                                else if(section[5].equals("UTR")){
                                    realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                    realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX); 
                                    realSchedule.add(scheduleCell2, 5, loc, 1, classDurationEX);
                                }
                            }
                            else{
                                if(!finishedCourses.containsAll(preCoursesList)){
                                    Alert errorAlert = new Alert(AlertType.ERROR);
                                    errorAlert.setHeaderText("Error");
                                    errorAlert.setContentText("Prerequest Missing");
                                    errorAlert.showAndWait();
                                }
                                else if (finishedCourses.contains(course)){
                                    Alert errorAlert = new Alert(AlertType.ERROR);
                                    errorAlert.setHeaderText("Error");
                                    errorAlert.setContentText("You have already finished this course");
                                    errorAlert.showAndWait();
                                }
                                else if(thisCourse.isDublicatedCourseInArray(mySchedule.getSections())){
                                    Alert errorAlert = new Alert(AlertType.ERROR);
                                    errorAlert.setHeaderText("Error");
                                    errorAlert.setContentText("Already added");
                                    errorAlert.showAndWait();
                                }
                                else if (thisCourse.timeConflictCheckerInArray(mySchedule.getSections())){
                                    Alert errorAlert = new Alert(AlertType.ERROR);
                                    errorAlert.setHeaderText("Error");
                                    errorAlert.setContentText("Time Conflict");
                                    errorAlert.showAndWait();
                                }
                            }
                            
                        });
                    }
                    
                    addedToSchedule.getChildren().add(gg);
                    gg.setOnAction(q->{
                        realSchedule.getChildren().removeAll(scheduleCell,scheduleCell1,scheduleCell2);
                        mySchedule.removeSection(thisCourse);
                    });
                }
                else if(!(thisCourse.isDublicatedInArray(mySchedule.getSelectedSections()))){
                    addCourse.setText("< ADDED >");
                    s.setFill(Color.SEAGREEN);
                    mySchedule.addSelectedSection(thisCourse);
                    basket.getChildren().add(g);
                    g.setOnAction( h -> {
                        if ((!(thisCourse.timeConflictCheckerInArray(mySchedule.getSections()) 
                            || thisCourse.isDublicatedCourseInArray(mySchedule.getSections())))
                            && (finishedCourses.containsAll(preCoursesList) 
                            && !finishedCourses.contains(course)))
                        {
                            mySchedule.addSection(thisCourse);
                            if(section[5].equals("U")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("M")){
                                realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("T")){
                                realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("W")){
                                realSchedule.add(scheduleCell, 4, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("R")){
                                realSchedule.add(scheduleCell, 5, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("UT")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("MW")){
                                realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 4, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("TR")){
                                realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 5, loc, 1, classDurationEX);
                            }
                            else if(section[5].equals("UTR")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell2, 5, loc, 1, classDurationEX);

                            }
                        }
                        else{
                            if(!finishedCourses.containsAll(preCoursesList)){
                                Alert errorAlert = new Alert(AlertType.ERROR);
                                errorAlert.setHeaderText("Error");
                                errorAlert.setContentText("Prerequest Missing");
                                errorAlert.showAndWait();
                            }
                            else if (finishedCourses.contains(course)){
                                Alert errorAlert = new Alert(AlertType.ERROR);
                                errorAlert.setHeaderText("Error");
                                errorAlert.setContentText("You have already finished this course");
                                errorAlert.showAndWait();
                            }
                            else if(thisCourse.isDublicatedCourseInArray(mySchedule.getSections())){
                                Alert errorAlert = new Alert(AlertType.ERROR);
                                errorAlert.setHeaderText("Error");
                                errorAlert.setContentText("Already added");
                                errorAlert.showAndWait();
                            }
                            else if (thisCourse.timeConflictCheckerInArray(mySchedule.getSections())){
                                Alert errorAlert = new Alert(AlertType.ERROR);
                                errorAlert.setHeaderText("Error");
                                errorAlert.setContentText("Time Conflict");
                                errorAlert.showAndWait();
                            }
                        }
                    });
                    addedToSchedule.getChildren().add(gg);
                    gg.setOnAction(q->{
                        realSchedule.getChildren().removeAll(scheduleCell,scheduleCell1,scheduleCell2);
                        mySchedule.removeSection(thisCourse);
                    });
                }
            });
            Button removeCourse = new Button("REMOVE");
            removeCourse.setOnAction(e->{
                addCourse.setText("ADD");
                s.setFill(Color.BLACK);
                mySchedule.removeSelectedSection(thisCourse);
                mySchedule.removeSection(thisCourse);
                basket.getChildren().remove(g);
                addedToSchedule.getChildren().remove(gg);
                realSchedule.getChildren().removeAll(scheduleCell,scheduleCell1,scheduleCell2);
            });
            HBox buttons = new HBox(20);
            buttons.setPadding(new Insets(10,10,10,10));
            buttons.getChildren().addAll(addCourse, removeCourse);  
            s.setFont(Font.font("Lucida Sans Unicode", FontPosture.REGULAR, 12));
            a.getChildren().addAll(s,buttons,Divider);
        }
    }
    public void readSavedSheduals(File file)
    {
        try{
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Schedule scheduleeZZ = (Schedule) input.readObject();
            mySchedule.setSections(scheduleeZZ.getSections());
            mySchedule.setSelectedSections(scheduleeZZ.getSelectedSections());



            

            for(int z = 0; z < mySchedule.getSelectedSections().length; z++){
                Section thisCourse = mySchedule.getSelectedSections()[z];

                String xCourse = thisCourse.getCourseSection();
                String[] xxCourse = xCourse.split("-");
                String course = xxCourse[0];
                
                ReadFiles finishedCoursesFile = new ReadFiles(finishedCoursesPath);
                ArrayList<String> finishedCourses = finishedCoursesFile.readFinishedCourses();
                Course thisCourseClass = new Course(course);
                String[] preCourses = thisCourseClass.getPreCourses();
                List<String> preCoursesList = Arrays.asList(preCourses);

                int classLength = thisCourse.getDuration();
                int[] red = {157,255,141,255,255};
                int[] green = {222,210,193,254,133};
                int[] blue = {186,150,251,150,136};
                int colorSelecter = (int)(Math.random()*5);
                Rectangle rectangle = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));
                Rectangle rectangle1 = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));
                Rectangle rectangle2 = new Rectangle(161.7, classLength, Color.rgb(red[colorSelecter], green[colorSelecter], blue[colorSelecter]));
                StackPane scheduleCell = new StackPane();
                StackPane scheduleCell1 = new StackPane();
                StackPane scheduleCell2 = new StackPane();
                scheduleCell.getChildren().addAll(rectangle, new Label(thisCourse.getCourseSection() + " | " + thisCourse.getCourseTime()));
                scheduleCell1.getChildren().addAll(rectangle1, new Label(thisCourse.getCourseSection() + " | " + thisCourse.getCourseTime()));
                scheduleCell2.getChildren().addAll(rectangle2, new Label(thisCourse.getCourseSection() + " | " + thisCourse.getCourseTime()));
                
                String startingTimeH = thisCourse.getCourseTime().substring(0, 2);
                int startingTimeHI = Integer.parseInt(startingTimeH);
                String startingTimeM = thisCourse.getCourseTime().substring(2, 3);
                int startingTimeMI = Integer.parseInt(startingTimeM);
                int loc = (startingTimeHI - 06) + ((startingTimeHI - 07)*5) + startingTimeMI;
                int classDurationEX = thisCourse.getDurationEX();

                for(int re = 0; re < mySchedule.getSections().length; re++){
                    if(mySchedule.getSections()[re] == thisCourse){
                        if(thisCourse.getCourseDays().equals("U")){
                            realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("M")){
                            realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("T")){
                            realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("W")){
                            realSchedule.add(scheduleCell, 4, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("R")){
                            realSchedule.add(scheduleCell, 5, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("UT")){
                            realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                            realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("MW")){
                            realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX); 
                            realSchedule.add(scheduleCell1, 4, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("TR")){
                            realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX); 
                            realSchedule.add(scheduleCell1, 5, loc, 1, classDurationEX);
                        }
                        else if(thisCourse.getCourseDays().equals("UTR")){
                            realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                            realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX); 
                            realSchedule.add(scheduleCell2, 5, loc, 1, classDurationEX);
                        }
                    }
                }
                Button g = new Button(thisCourse.getCourseSection() + " | " + thisCourse.getCourseType());
                g.setStyle("-fx-font-size: 1.1em; ");
                basket.getChildren().add(g);
                g.setOnAction(e->{
                    if (((!(thisCourse.timeConflictCheckerInArray(mySchedule.getSections())) 
                    || (mySchedule.getSections().length == 1 && mySchedule.getSections()[0] == null)) 
                    && !(thisCourse.isDublicatedCourseInArray(mySchedule.getSections()))) 
                    && (finishedCourses.containsAll(preCoursesList) 
                    && !finishedCourses.contains(course))){
                            mySchedule.addSection(thisCourse);
                            if(thisCourse.getCourseDays().equals("U")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("M")){
                                realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("T")){
                                realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("W")){
                                realSchedule.add(scheduleCell, 4, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("R")){
                                realSchedule.add(scheduleCell, 5, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("UT")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("MW")){
                                realSchedule.add(scheduleCell, 2, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 4, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("TR")){
                                realSchedule.add(scheduleCell, 3, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 5, loc, 1, classDurationEX);
                            }
                            else if(thisCourse.getCourseDays().equals("UTR")){
                                realSchedule.add(scheduleCell, 1, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell1, 3, loc, 1, classDurationEX); 
                                realSchedule.add(scheduleCell2, 5, loc, 1, classDurationEX);
                            }
                    }
                    else{
                        if(!finishedCourses.containsAll(preCoursesList)){
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Error");
                            errorAlert.setContentText("Prerequest Missing");
                            errorAlert.showAndWait();
                        }
                        else if (finishedCourses.contains(course)){
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Error");
                            errorAlert.setContentText("You have already finished this course");
                            errorAlert.showAndWait();
                        }
                        else if(thisCourse.isDublicatedCourseInArray(mySchedule.getSections())){
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Error");
                            errorAlert.setContentText("Already added");
                            errorAlert.showAndWait();
                        }
                        else if (thisCourse.timeConflictCheckerInArray(mySchedule.getSections())){
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Error");
                            errorAlert.setContentText("Time Conflict");
                            errorAlert.showAndWait();
                        }
                    }
                });
                Button gg = new Button(thisCourse.getCourseSection() + " | " + thisCourse.getCourseType());
                gg.setStyle("-fx-font-size: 1.1em; ");
                addedToSchedule.getChildren().add(gg);
                gg.setOnAction(q->{
                    realSchedule.getChildren().removeAll(scheduleCell,scheduleCell1,scheduleCell2);
                    mySchedule.removeSection(thisCourse);
                });
            }
            input.close();
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException emm){
            System.out.println(emm.getMessage());
        }
    }
    public static void main(String[] args) {
        launch();
    }
}