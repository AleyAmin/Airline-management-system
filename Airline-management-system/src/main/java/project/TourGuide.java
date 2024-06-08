package project;
import java.util.*;

public class TourGuide extends Project{
    public int tg_Id;
    private String tg_Name;
    private int tg_Age;
    private double tg_Salary;
    private List<Tour> tg_assignedTours;
    
    
    //constructors
    public TourGuide() {
    }

    public TourGuide(int tg_Id) {
        this.tg_Id = tg_Id;
    }
    
    public TourGuide(int tg_Id, String tg_Name, int tg_Age, int tg_Salary) {
        this.tg_Id = tg_Id;
        this.tg_Name = tg_Name;
        this.tg_Age = tg_Age;
        this.tg_Salary = tg_Salary;
    }

    public TourGuide(int tg_Id, String tg_Name, int tg_Age, int tg_Salary, List<Tour> tg_assignedTours) {
        this.tg_Id = tg_Id;
        this.tg_Name = tg_Name;
        this.tg_Age = tg_Age;
        this.tg_Salary = tg_Salary;
        this.tg_assignedTours = tg_assignedTours;
    }
    
    //Getters and Setters
    public String getTg_Name() {
        return tg_Name;
    }

    public int getTg_Id() {
        return tg_Id;
    }

    public int getTg_Age() {
        return tg_Age;
    }

    public double getTg_Salary() {
        return tg_Salary;
    }

    public List<Tour> getTg_assignedTours() {
        return tg_assignedTours;
    }

    public void setTg_Id(int tg_Id) {
        this.tg_Id = tg_Id;
    }

    public void setTg_Name(String tg_Name) {
        this.tg_Name = tg_Name;
    }

    public void setTg_Age(int tg_Age) {
        this.tg_Age = tg_Age;
    }
    
    public void setTg_Salary(double tg_Salary) {
        this.tg_Salary = tg_Salary;
    }

    public void setTg_assignedTours(List<Tour> tg_assignedTours) {
        this.tg_assignedTours = tg_assignedTours;
    }
    
    //=========================================================================
    //Methods 
    @Override
    public String toString(){
        return "\nTour Guide Id : "+ tg_Id+" \nTour Guide Name : "+tg_Name+" \nTour Guide Age : "+tg_Age+" \nTour Guide Salary : "+tg_Salary+" \nTour Guide Assigned Tours : "+tg_assignedTours+"\n\n";
    }

    @Override
    public void editName(int i ,String name) {
        TourGuide tourGuide = findTourGuideById(i);
        if (tourGuide != null) {
            tourGuide.setTg_Name(name);
        }
    }
    @Override
    public void editId(int i ,int id) {
        TourGuide tourGuide = findTourGuideById(i);
        if (tourGuide != null) {
            tourGuide.setTg_Id(id);
        }
    }
    @Override
    public void edit(int i ,int age) {
        TourGuide tourGuide = findTourGuideById(i);
        if (tourGuide != null) {
            tourGuide.setTg_Age(age);
        }
    }
    public void editSalary(int i , double salary) {
        TourGuide tourGuide = findTourGuideById(i);
        if (tourGuide != null) {
            tourGuide.setTg_Salary(salary);
        }
    }
    public void editAssignedTours(int i , int r ,int tourGuideid) {
        Tour tour1 = findTourById(i);
        Tour tour2 = findTourById(r);
        TourGuide tourGuide = findTourGuideById(tourGuideid);
        if(tour1 != null && tour2 != null){
            tourGuide.getTg_assignedTours().remove(tour1);
            tourGuide.assignTourGuideToTour(tourGuideid,r);
        }
    }
    
    public void addTourGuide(TourGuide tourGuide ) {
        getTourGuides().add(tourGuide);
    }
    
    public void deleteTourGuide(int tourGuideId) {
        TourGuide tourGuide = findTourGuideById(tourGuideId);
        if (tourGuide != null) {
            getTourGuides().remove(tourGuide);
        }
    }
    
    public void viewTourGuideInformation(List<TourGuide> tourGuide) {
          for(int i=0;i<tourGuide.size();i++)
        {
            System.out.println(tourGuide.get(i)+" ");
        } 
    }

    public void assignTourGuideToTour(int tourGuideid, int tourId) {
        Tour tour = findTourById(tourId);
        TourGuide tourGuide = findTourGuideById(tourGuideid);
        if (tourGuide != null && tour != null){
            tourGuide.getTg_assignedTours().add(tour);
            tour.setTourGuide(tourGuide);
        }
    }
  
}
