package project;
import java.util.*;

public class Client extends Project{
    private int c_Id;
    private String c_Name;
    private int c_age;
    private List<Tour> c_pastTours;
    private Tour c_currentTour;
    private List<Tour> c_upcomingTours;

    public Client() {
    }

    public Client(int c_Id,String c_Name, int c_age, List<Tour> c_pastTours, Tour c_currentTour, List<Tour> c_upcomingTours) {
        this.c_Id = c_Id;
        this.c_Name = c_Name;
        this.c_age = c_age;
        this.c_pastTours = c_pastTours;
        this.c_currentTour = c_currentTour;
        this.c_upcomingTours = c_upcomingTours;
    }

    public Client(String c_Name) {
        this.c_Name = c_Name;
        this.c_pastTours = new ArrayList<>();
        this.c_upcomingTours = new ArrayList<>();
    }

    public int getC_Id() {
        return c_Id;
    }

    public void setC_Id(int c_Id) {
        this.c_Id = c_Id;
    }
    
    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public int getC_age() {
        return c_age;
    }

    public void setC_age(int c_age) {
        this.c_age = c_age;
    }

    public List<Tour> getC_pastTours() {
        return c_pastTours;
    }

    public void setC_pastTours(List<Tour> c_pastTours) {
        this.c_pastTours = c_pastTours;
    }

    public Tour getC_currentTour() {
        return c_currentTour;
    }

    public void setC_currentTour(Tour c_currentTour) {
        this.c_currentTour = c_currentTour;
    }

    public List<Tour> getC_upcomingTours() {
        return c_upcomingTours;
    }

    public void setC_upcomingTours(List<Tour> c_upcomingTours) {
        this.c_upcomingTours = c_upcomingTours;
    }
     
    //===================================================================
    
    //Methods
    @Override
    public String toString(){         
        return "\nClient Id : "+ c_Id+" \nClient Name : "+c_Name+" \nClient Age : "+c_age+" \nClient Age : "+c_age;
    }
    public void addClient(Client client) {
        getClients().add(client);
    }
    
    public void addpastTours(Tour tour) {
        c_pastTours.add(tour);
    }
    
    public void addUpcomingTours(Tour tour) {
        c_upcomingTours.add(tour);
    }
   
    @Override
    public void editName(int i ,String name) {
        Client client = findClientById(i);
        if (client != null) {
            client.setC_Name(name);
        }
    }
    @Override
    public void editId(int i ,int id) {
        Client client = findClientById(i);
        if (client != null) {
            client.setC_Id(id);
        }
    }
    @Override
    public void edit(int i ,int age) {
        Client client = findClientById(i);
        if (client != null) {
            client.setC_age(age);
        }
    }
    
    public void deleteClient(int clientId) {
        Client client = findClientById(clientId);
        if (client != null) {
            client.getClients().remove(client);
        }
    }

    public void cancelClientTour(int clientId , int tourId) {
        Client client = findClientById(clientId);
        Tour tour = findTourById(tourId);
        if (client != null && tour != null) {
                client.setC_currentTour(null);
                tour.getT_clients().remove(client);
        }
    }
    
    public void checkToPostpone(int clientId){
        Client client = findClientById(clientId);
        Date date = new Date();
        if (client != null) {
            int flag =0;
            for (Tour tour : getTours()) {
                if (flag == 0){
                    int d1 = getC_currentTour().getT_Date();
                    int d2 = tour.getT_Date();
                
                    if (getC_currentTour().getT_sites().equals(tour.getT_sites())){
                        if (date.CheckIfUpcomingDate(d1,d2) == 1){
                            client.postponeClientTour(clientId,getC_currentTour().getT_Id(),tour.getT_Id());
                            flag += 1;
                        }
                    }
                }
                else 
                    break;
            }
        } 
    }
    
    public void postponeClientTour(int clientId, int tour1Id, int tour2Id) {
        Client client = findClientById(clientId);
        Tour tour1 = findTourById(tour1Id);
        Tour tour2 = findTourById(tour2Id);
        if (client != null && tour1 != null && tour2 != null) {
                client.setC_currentTour(null);
                tour1.getT_clients().remove(client);
                tour2.getT_clients().add(client);
                client.setC_currentTour(tour2);
        }
    }
    public void viewClientInformation(List<Client> client) {
          for(int i=0;i<client.size();i++)
        {
            System.out.println(client.get(i)+" ");
        } 
    }
    
}
