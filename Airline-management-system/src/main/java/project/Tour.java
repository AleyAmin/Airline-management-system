package project;
import java.util.*;

public class Tour extends Project{
    private int t_Id;
    private int t_Date;
    private String t_Category;
    private String t_Name;
    private TourGuide tourGuide;
    private int t_maxClients;
    private List<Client> t_clients;
    private String t_sites;
    private double t_price;
    private double t_totalProfit;

    public Tour() {
    }

    public Tour(int t_Id) {
        this.t_Id = t_Id;
    }

    public Tour(int t_Id, int t_Date, String t_Category, String t_Name, TourGuide tourGuide, int t_maxClients, List<Client> t_clients, String t_sites, double t_price, double t_totalProfit) {
        this.t_Id = t_Id;
        this.t_Date = t_Date;
        this.t_Category = t_Category;
        this.t_Name = t_Name;
        this.tourGuide = tourGuide;
        this.t_maxClients = t_maxClients;
        this.t_clients = t_clients;
        this.t_sites = t_sites;
        this.t_price = t_price;
        this.t_totalProfit = t_totalProfit;
    }

    public Tour(int t_Id, int t_Date, String t_Category, String t_Name, TourGuide tourGuide, int t_maxClients, List<Client> t_clients, String t_sites, double t_price) {
        this.t_Id = t_Id;
        this.t_Date = t_Date;
        this.t_Category = t_Category;
        this.t_Name = t_Name;
        this.tourGuide = tourGuide;
        this.t_maxClients = t_maxClients;
        this.t_clients = t_clients;
        this.t_sites = t_sites;
        this.t_price = t_price;
    }
    

    public int getT_Id() {
        return t_Id;
    }

    public void setT_Id(int t_Id) {
        this.t_Id = t_Id;
    }
    
    public String getT_Category() {
        return t_Category;
    }

    public void setT_Category(String t_Category) {
        this.t_Category = t_Category;
    }

    public int getT_Date() {
        return t_Date;
    }

    public void setT_Date(int t_Date) {
        this.t_Date = t_Date;
    }

    public String getT_Name() {
        return t_Name;
    }

    public void setT_Name(String t_Name) {
        this.t_Name = t_Name;
    }

    public TourGuide getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(TourGuide tourGuide) {
        this.tourGuide = tourGuide;
    }

    public int getT_maxClients() {
        return t_maxClients;
    }

    public void setT_maxClients(int t_maxClients) {
        this.t_maxClients = t_maxClients;
    }

    public List<Client> getT_clients() {
        return t_clients;
    }

    public void setT_clients(List<Client> t_clients) {
        this.t_clients = t_clients;
    }

    public String getT_sites() {
        return t_sites;
    }

    public void setT_sites(String t_sites) {
        this.t_sites = t_sites;
    }

    public double getT_price() {
        return t_price;
    }

    public void setT_price(double t_price) {
        this.t_price = t_price;
    }

    public double getT_totalProfit() {
        return t_totalProfit;
    }

    public void setT_totalProfit(double t_totalProfit) {
        this.t_totalProfit = t_totalProfit;
    }

    //========================================================================
    // Methods
    public void addTour(Tour tour) {
        getTours().add(tour);
    }
   
    @Override
    public void editName(int i ,String Name){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_Name(Name);
        }
    }
    @Override
    public void editId(int i , int id){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_Id(id);
        }
    }
    @Override
    public void edit(int i , int max){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_maxClients(max);
        }
    }
    public void editDate(int i , int date){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_Date(date);
        }
    }
    public void editCategory(int i , int input){
        Tour tour = findTourById(i);
        if (tour != null) {
            switch(input){
                case 1 -> tour.setT_Category("Safari holidays");
                case 2 -> tour.setT_Category("Adventure tour");
                case 3 -> tour.setT_Category("Culture trip");
                case 4 -> tour.setT_Category("Religious tour");
                default -> tour.setT_Category(null);
            }    
        }
    }
    public void editTourGuide(int i ,int r, int tourid) {
        TourGuide tourGuide1 = findTourGuideById(i);
        TourGuide tourGuide2 = findTourGuideById(r);
        Tour tour = findTourById(tourid);
        if(tourGuide1 != null && tourGuide2 != null){
            tourGuide2.getTg_assignedTours().remove(tour);
            tour.setTourGuide(tourGuide1);
            tourGuide1.getTg_assignedTours().add(tour);
        }
    }
    public void editSites(int i , String sites){
        Tour tour = findTourById(i);
        if (tour != null){
            tour.setT_sites(sites);
        }
    }
    public void editPrice(int i , double price){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_price(price);
        }
    }
    public void editProfit(int i , double profit){
        Tour tour = findTourById(i);
        if (tour != null) {
            tour.setT_totalProfit(profit);
        }
    }
    public void cancelTour(int tourId) {
        Tour tour = findTourById(tourId);
        if (tour != null) {
            getTours().remove(tour);
        }
    }
    
    public double calculateCategoryProfit(String category) {
        double categoryProfit = 0.0;
        for (Tour tour : getTours()) {
            if (tour.getT_Category().equals(category)) {
                categoryProfit += tour.getT_totalProfit();
            }
        }
        return categoryProfit;
    }

    public double calculateTotalProfit() {
        double totalProfit = 0.0;
        for (Tour tour : getTours()) {
            totalProfit += tour.getT_totalProfit();
        }
        return totalProfit;
    }
    public void addClients(int clientId , int tourId){
        Client client = findClientById(clientId);
        Tour tour = findTourById(tourId);
        if (client != null && tour != null){
            tour.getT_clients().add(client);
            client.addUpcomingTours(tour);
        }
    }
}

