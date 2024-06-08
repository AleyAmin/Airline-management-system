package project;
import java.util.*;

public abstract class Project {
    private List<Tour> tours;
    private List<TourGuide> tourGuides;
    private List<Client> clients;

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<TourGuide> getTourGuides() {
        return tourGuides;
    }

    public void setTourGuides(List<TourGuide> tourGuides) {
        this.tourGuides = tourGuides;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    // Methods
    public abstract void editName(int i , String name);
    public abstract void editId(int i , int id);
    public abstract void edit(int i , int num);
    
    
    public Project() {
        tours = new ArrayList<>();
        tourGuides = new ArrayList<>();
        clients = new ArrayList<>();
    }
    public Tour findTourById(int tourId) {
        for (Tour tour : getTours()) {
            if (tour.getT_Id() == tourId) {
                return tour;
            }
        }
        return null;
    }

    public TourGuide findTourGuideById(int tourGuideId) {
        for (TourGuide tourGuide : getTourGuides()) {
            if (tourGuide.getTg_Id() == tourGuideId) {
                return tourGuide;
            }
        }
        return null;
    }
    public Client findClientById(int clientId) {
        for (Client client : getClients()) {
            if (client.getC_Id() == clientId) {
                return client;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Tour tour = new Tour();
        TourGuide tourguide = new TourGuide();
        Client client = new Client();
        int countMain = 0;
        System.out.println("Can you please enter your name");
        String name = input.next();
        System.out.printf("Hi %s what would you like to do today. %n",name);
        
        while (countMain == 0){
            System.out.println("What would do you like to manage:");
            System.out.println("Press 1 for Tours \nPress 2 for Tour Guides \nPress 3 for Clients\n");
            int firstChoice;
            firstChoice = input.nextInt();
            while (firstChoice > 3 || firstChoice < 1){
                System.out.println("Please enter a number from what's mentioned above");
                firstChoice = input.nextInt();
            }
            switch(firstChoice){
                case 1 -> {
                    int countTour = 0;
                    while (countTour == 0){
                        System.out.println("What do you want to do with Tours:");
                        System.out.println("Press 1 to add Tour \nPress 2 to edit Tour \nPress 3 delete Tour \n");
                        int secondChoice = input.nextInt();
                        while (secondChoice > 3 || secondChoice < 1){
                            System.out.println("Please enter a number from what's mentioned above");
                            secondChoice = input.nextInt();
                        }
                        switch(secondChoice){
                            case 1 -> {
                                int countAddTour = 0;
                                while (countAddTour == 0){
                                    
                                    tour.addTour(tour);
                                    System.out.println("Please enter the tour's information");
                                    System.out.println("Id");
                                    tour.setT_Id(input.nextInt());
                                    System.out.println("Date in this format DDMMYYY only numbers!!");
                                    tour.setT_Date(input.nextInt());
                                    System.out.println("Category");
                                    System.out.println("Press 1 for Safari holidays \nPress 2 for Adventure tour \nPress 3 for Culture trip \nPress 4 for Religious tour \n");
                                    int thirdChoice = input.nextInt();
                                    while (thirdChoice > 4 || thirdChoice < 1){
                                        System.out.println("Please enter a number from what's mentioned above");
                                        thirdChoice = input.nextInt();
                                    }
                                    switch(thirdChoice){
                                        case 1 -> tour.setT_Category("Safari holidays");
                                        case 2 -> tour.setT_Category("Adventure tour");
                                        case 3 -> tour.setT_Category("Culture trip");
                                        case 4 -> tour.setT_Category("Religious tour");
                                    }
                                    System.out.println("Name");
                                    tour.setT_Name(input.next());
                                    System.out.println("Max number of clients");
                                    tour.setT_maxClients(input.nextInt());
                                    System.out.println("Sites");
                                    tour.setT_sites(input.next());
                                    System.out.println("Price");
                                    tour.setT_price(input.nextInt());
                                    System.out.println("If you want to add another thing press 0 if not press 1");
                                    countAddTour = input.nextInt();
                                }
                            }
                            case 2 -> {
                                int countTourEdit = 0;
                                while(countTourEdit == 0){
                                    System.out.println("Enter Tour Id");
                                    int id = input.nextInt();
                                    tour = tour.findTourById(id);
                                    System.out.println("What do you want to edit :");
                                    System.out.println("Press 1 to edit name, Id and Max Clients \nPress 2 to edit Date , Category and Tour Guide \nPress 3 to edit Sites , Price and Profit\n");
                                    int fourthChoice = input.nextInt();
                                    while (fourthChoice > 3 || fourthChoice < 1){
                                        System.out.println("Please enter a number from what's mentioned above");
                                        fourthChoice = input.nextInt();
                                    }
                                    switch(fourthChoice){
                                        case 1 -> {
                                            System.out.println("Enter the apropriate replacements");
                                            tour.editName(id, input.next());
                                            tour.editId(id , input.nextInt());
                                            tour.edit(id, input.nextInt());
                                        }
                                        case 2 -> {
                                            System.out.println("Enter the apropriate replacements Category from 1 to 4 respectively ");
                                            tour.editDate(id, input.nextInt());
                                            tour.editCategory(id , input.nextInt());
                                            tour.editTourGuide(input.nextInt(),input.nextInt(),id);
                                        }
                                        case 3 -> {
                                            tour.editSites(id, input.next());
                                            tour.editPrice(id, input.nextInt());
                                            tour.editProfit(id, input.nextInt());
                                        }
                                    }
                                    System.out.println("If you want to edit another thing press 0 if not press 1");
                                    countTourEdit = input.nextInt();
                                }
                            }
                            case 3 -> {
                                int countTourDelete = 0;
                                while(countTourDelete == 0){
                                    System.out.println("Enter Tour Id");
                                    int id = input.nextInt();
                                    tour = tour.findTourById(id);
                                    tour.cancelTour(id);
                                    System.out.println("If you want to delete another thing press 0 if not press 1");
                                    countTourDelete = input.nextInt();
                                }
                            }
                        }
                        System.out.println("If manage tours again press 0 if not press 1");
                        countTour = input.nextInt();
                    }
                }
                case 2 -> {
                    int countTourGuide = 0;
                    while (countTourGuide == 0){
                        System.out.println("What do you want to do with Tour Guides:");
                        System.out.println("Press 1 to add Tour Guide \nPress 2 to edit Tour Guide \nPress 3 to delete Tour Guide \nPress 4 to view Tour Guides \nPress 5 to Assign Tour Guide \n");
                        int fifthChoice = input.nextInt();
                        while (fifthChoice > 5 || fifthChoice < 1){
                            System.out.println("Please enter a number from what's mentioned above");
                            fifthChoice = input.nextInt();
                        }
                        switch(fifthChoice){
                            case 1 -> {
                                int countAddTourGuide = 0;
                                while (countAddTourGuide == 0){
                                    tourguide.addTourGuide(tourguide);
                                    System.out.println("Please enter the Tour Guide's information");
                                    System.out.println("Id");
                                    tourguide.setTg_Id(input.nextInt());
                                    System.out.println("Name");
                                    tourguide.setTg_Name(input.next());
                                    System.out.println("Age");
                                    tourguide.setTg_Age(input.nextInt());
                                    System.out.println("Salary");
                                    tourguide.setTg_Salary(input.nextInt());
                                    System.out.println("If you want to add another thing press 0 if not press 1");
                                    countAddTourGuide = input.nextInt();
                                }
                            }
                            case 2 -> {
                                int countEditTourGuide = 0;
                                while (countEditTourGuide == 0){
                                    System.out.println("Enter Tour Guide Id");
                                    int id = input.nextInt();
                                    tourguide = tourguide.findTourGuideById(id);
                                    System.out.println("What do you want to edit :");
                                    System.out.println("Press 1 to edit name, Id , Age and Salary \nPress 2 to edit Assigned Tours\n");
                                    int sixthChoice = input.nextInt();
                                    while (sixthChoice > 2 || sixthChoice < 1){
                                        System.out.println("Please enter a number from what's mentioned above");
                                        sixthChoice = input.nextInt();
                                    }
                                    switch(sixthChoice){
                                        case 1 -> {
                                            System.out.println("Enter the apropriate replacements");
                                            tourguide.editName(id, input.next());
                                            tourguide.editId(id , input.nextInt());
                                            tourguide.edit(id, input.nextInt());
                                            tourguide.editSalary(id, input.nextInt());
                                        }
                                        case 2 -> {
                                            System.out.println("Enter New Tour Id and Old Tour Id respectively");
                                            tourguide.editAssignedTours(input.nextInt(),input.nextInt(),id);
                                        }
                                    }
                                    System.out.println("If you want to edit another thing press 0 if not press 1");
                                    countEditTourGuide = input.nextInt();
                                }
                            }
                            case 3 -> {
                                int countTourGuideDelete = 0;
                                while(countTourGuideDelete == 0){
                                    System.out.println("Enter Tour Guide Id");
                                    int id = input.nextInt();
                                    tourguide = tourguide.findTourGuideById(id);
                                    tourguide.deleteTourGuide(id);
                                    System.out.println("If you want to delete another thing press 0 if not press 1");
                                    countTourGuideDelete = input.nextInt();
                                }
                            }
                            case 4 -> {
                                tourguide.viewTourGuideInformation(tourguide.getTourGuides());
                            }
                            case 5 -> {
                                int CountAssignTourGuide = 0;
                                while(CountAssignTourGuide == 0){
                                    System.out.println("Enter Tour Guide Id");
                                    int id = input.nextInt();
                                    tourguide = tourguide.findTourGuideById(id); 
                                    System.out.println("Enter Tour Id");
                                    int tourId = input.nextInt();
                                    tourguide.assignTourGuideToTour(id, tourId);
                                    System.out.println("If you want to assign tour guide to tour again press 0 if not press 1");
                                    CountAssignTourGuide = input.nextInt();
                                }
                            }
                            
                        }
                        System.out.println("If you want to manage tour guides again press 0 if not press 1");
                        countTourGuide = input.nextInt();       
                    }
                }
                case 3 -> {
                    int countClient = 0;
                    while (countClient == 0){
                        System.out.println("What do you want to do with Clients:");
                        System.out.println("Press 1 to add Client \nPress 2 to edit Client \nPress 3 to delete Client \nPress 4 to view Clients \nPress 5 to Cancel Client Tours \n");
                        int seventhChoice = input.nextInt();
                        while (seventhChoice > 6 || seventhChoice < 1){
                            System.out.println("Please enter a number from what's mentioned above");
                            seventhChoice = input.nextInt();
                        }
                        switch(seventhChoice){
                            case 1 -> {
                                int countAddClient = 0;
                                while (countAddClient == 0){
                                    client.addClient(client);
                                    System.out.println("Please enter the Client's information");
                                    System.out.println("Id");
                                    client.setC_Id(input.nextInt());
                                    System.out.println("Name");
                                    client.setC_Name(input.next());
                                    System.out.println("Age");
                                    client.setC_age(input.nextInt());
                                    System.out.println("Current Tour Id");
                                    int addCurrentTourId = input.nextInt();
                                    tour = tour.findTourById(addCurrentTourId);
                                    client.setC_currentTour(tour);
                                    System.out.println("If you want to add another thing press 0 if not press 1");
                                    countAddClient = input.nextInt();
                                    
                                }
                            }
                            case 2 -> {
                                int countEditClient = 0;
                                while (countEditClient == 0){
                                    System.out.println("Enter Client Id");
                                    int id = input.nextInt();
                                    client = client.findClientById(id);
                                    System.out.println("What do you want to edit :");
                                    System.out.println("Press 1 to edit name and Id\nPress 2 to edit Age\n");
                                    int eigthChoice = input.nextInt();
                                    while (eigthChoice > 2 || eigthChoice < 1){
                                        System.out.println("Please enter a number from what's mentioned above");
                                        eigthChoice = input.nextInt();
                                    }
                                    switch(eigthChoice){
                                        case 1 -> {
                                            System.out.println("Enter Name then Id");
                                            client.editName(id, input.next());
                                            client.editId(id , input.nextInt());
                                            
                                        }
                                        case 2 -> {
                                            System.out.println("Enter Age");
                                            client.edit(id, input.nextInt());
                                        }
                                    }
                                    System.out.println("If you want to edit another thing press 0 if not press 1");
                                    countEditClient = input.nextInt();
                                }
                            }
                            case 3 -> {
                                int countClientDelete = 0;
                                while(countClientDelete == 0){
                                    System.out.println("Enter Client Id");
                                    int id = input.nextInt();
                                    client = client.findClientById(id);
                                    client.deleteClient(id);
                                    System.out.println("If you want to delete another thing press 0 if not press 1");
                                    countClientDelete = input.nextInt();
                                }
                            }
                            case 4 -> {
                                client.viewClientInformation(client.getClients());
                            }
                            case 5 -> {
                                int countClientCancel = 0;
                                while(countClientCancel == 0){
                                    System.out.println("Enter Client Id");
                                    int id = input.nextInt();
                                    System.out.println("Enter Tour Id");
                                    int tourId = input.nextInt();
                                    client.cancelClientTour(id, tourId);
                                    System.out.println("If you want to cancel another thing press 0 if not press 1");
                                    countClientCancel = input.nextInt();
                                }
                            }
                            case 6 -> {
                                int countClientPostpone = 0;
                                while(countClientPostpone == 0){
                                    System.out.println("Enter Client Id");
                                    int id = input.nextInt();
                                    client.checkToPostpone(id);
                                    System.out.println("If you want to postpone another clients tour press 0 if not press 1");
                                    countClientPostpone = input.nextInt();
                                }
                            }
                        }
                        System.out.println("If manage clients again press 0 if not press 1");
                        countClient = input.nextInt();       
                    }
                }
            }
            System.out.println("If you want to do another process press 0 if not press 1");
            countMain = input.nextInt();
            if (countMain == 1)
                System.out.println("Thank you for using our app");
        }
    }
}
