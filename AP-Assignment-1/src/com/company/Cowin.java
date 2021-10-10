package com.company;

import java.util.*;

public class Cowin {

    private static int hospital_id ;
    private ArrayList<Vaccine> Vaccines_record ;
    private ArrayList<Hospital> Hospital_record ;
    private ArrayList<Citizen> Citizen_record ;
    private ArrayList<Slot> Slots_Available ;

    Cowin(){

        hospital_id = 100000;
        Vaccines_record = new ArrayList<Vaccine>();
        Hospital_record = new ArrayList<Hospital>();
        Citizen_record = new ArrayList<Citizen>();
        Slots_Available = new ArrayList<Slot>();

    }

    void book_slot(){

        Scanner sc= new Scanner(System.in);
        // Extra line sc.next()
        System.out.print("Enter Unique Id: ");
        String Id = sc.nextLine();

        if(!Is_citizen_present(Id)){
            System.out.println("Invalid User Id"); return ;}

        Citizen citizen = Find_citizen(Id);
        if(citizen.getVaccinationStatus()==2 ) {
            System.out.println("Fully vaccinated No bookings available");
            return;
        }

        System.out.println("1.Search by Area");
        System.out.println("2.Search by Vaccine");
        System.out.println("3.Exit");
        System.out.print("Enter option: ");
        int choice = sc.nextInt();

        if(choice==1) {
            System.out.print("Enter Pincode: ");
            int pin = sc.nextInt();
            search_slots_by_area(pin,citizen);
        }

        if(choice==2){
            System.out.print("Enter Vaccine Name: ");
            String vaccine_name = sc.next();
            search_slots_by_vaccine(vaccine_name , citizen );
        }

        if(choice==3){return;}
    }

    void Enter_Slots(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Hospital ID: ");
        int id = sc.nextInt();

        if(id<100000 || id>=hospital_id){
            System.out.println("Not Valid Id");
            return;
        }

        System.out.print("Enter Number of Slots to be added: ");
        int num = sc.nextInt();
        boolean is_vaccine=false;

        for(int i=0;i<num;i++){

            System.out.print("Enter Day Number: ");
            int day = sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            System.out.println("Select Vaccine: ");

            for(int j = 0 ; j < Vaccines_record.size();j++){

                System.out.println(j+"."+Vaccines_record.get(j).getName());
                is_vaccine=true;
            }

            if(!is_vaccine) {
                System.out.println("No vaccine registered");
                return;
            }

            int vaccine_ind = sc.nextInt();
            if(vaccine_ind>= Vaccines_record.size()){
                System.out.println("Invalid Vaccine Code");
                return;
            }
            add_Slot(id,day,qty,vaccine_ind);
        }
    }

    void add_Slot(int id ,int day,int qty,int vaccine_ind){

        Slot slot = new Slot(id,day,qty,Vaccines_record.get(vaccine_ind));
        Hospital_record.get(id-100000).add_slot(slot);
        Slots_Available.add(slot);
        slot.print_details();
    }

    void Register_Vaccine(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Vaccine Name: ");
        String name = sc.nextLine();
        System.out.print("Number of Doses: ");
        int doses = sc.nextInt();
        if(doses<=0){
            System.out.println("Invalid Input for required field");}
        else if(doses==1){
            add_Vaccine(name,doses,0); }
        else {
            System.out.print("Gap between Doses: ");
            int gap = sc.nextInt();
            if (gap < 1) {
                System.out.println("Invalid Input for required field");
            } else {
                add_Vaccine(name, doses, gap);
            }
        }
    }

    void add_Vaccine(String name,int doses,int gap){

        Vaccine vaccine = new Vaccine(name,doses,gap);

        if(!Is_Vaccine_present(vaccine)) {
            Vaccines_record.add(vaccine);
            vaccine.print_details();
        }

        else {
            System.out.println("Vaccine already Registered");
        }
    }

    void Register_Hospital(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Hospital Name: ");
        String name = sc.nextLine();
        System.out.print("Pincode: ");
        int pincode = sc.nextInt();

        if( pincode<0 || pincode>=1000000 ){
            System.out.println("Invalid Pincode");}

        else{
            add_Hospital(name,pincode);
        }
    }

    void add_Hospital(String name,int pincode){

        Hospital hospital = new Hospital(name,pincode,hospital_id);

        if(!Is_Hospital_registered(hospital)) {
            Hospital_record.add(hospital);
            hospital.print_details();
            hospital_id++;
        }
        else {
            System.out.println("Hospital already registered");
        }
    }

    void Register_citizen(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Citizen Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Unique Id: ");
        String Id = sc.nextLine();

        Citizen citizen = new Citizen(age,name,Id);
        citizen.print_details();

        if(age<=18){
            System.out.println("Only above 18 are allowed");
            return;
        }

        if(Id.length()!=12){
            System.out.println("Invalid ID , Length must be of Length 12 ");
            return;
        }

        add_Citizen(citizen);
    }

    void add_Citizen(Citizen citizen){

        if(!Is_citizen_present(citizen.getId())){
            Citizen_record.add(citizen);
            System.out.println("Registered Successfully");
        }

        else{
            System.out.println("ID Already registered , Registration unsuccessful");
        }
    }

    void search_slots_by_hospital(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Hospital Id: ");
        int id = sc.nextInt();

        if(id<100000 || id>=hospital_id){
            System.out.println("Not Valid Id");
            return;
        }

        Hospital_record.get(id-100000).print_slots();
    }

    void search_slots_by_area(int Pincode , Citizen citizen ){

        Scanner sc= new Scanner(System.in);
        sc.next();
        boolean hosp_avail=false;
        ArrayList<Hospital>Hosp_shown = new ArrayList<Hospital>();

        int hospital_record_size = Hospital_record.size();
        for(int i=0 ; i < hospital_record_size ; i++ ){

            if(Pincode == Hospital_record.get(i).getPincode()){
                Hospital hospital = Hospital_record.get(i);

                if (!Hosp_shown.contains(hospital)){
                    Hosp_shown.add(hospital);
                    System.out.println(hospital.getHospital_id() + " " + hospital.getName());
                    hosp_avail = true;
                }
            }
        }

        if(!hosp_avail) {
            System.out.println("No Available Hospital for this Pincode");
            return;
        }

        System.out.print("Enter Hospital Id: ");
        int id = sc.nextInt();

        Hospital hospital = Hospital_record.get(id-100000);   // Assuming valid id will be given
        print_valid_slots(hospital,citizen);

    }

    void print_valid_slots( Hospital hospital , Citizen citizen ){

        Scanner sc= new Scanner(System.in);

        if(hospital.getSlots().size()==0){
            System.out.println("No valid Slots for given Hospital"); return ;}

        ArrayList<Slot> ValidSlots = new ArrayList<Slot>();
        int count = 0;
        boolean slot_av = false;

        for(int i=0;i<hospital.getSlots().size();i++){

            Slot slot = hospital.getSlots().get(i);

            if(citizen.getVaccine_taken()==null){

                ValidSlots = hospital.getSlots();
                hospital.print_slots();
                count = ValidSlots.size();
                slot_av = true;
                break;
            }

            else if(slot.getVaccine().is_equal(citizen.getVaccine_taken())){

                if((slot.getDay()>=citizen.getDue_date()) && (citizen.getNo_of_doses_taken()<citizen.getVaccine_taken().getDoses()) && slot.getQty()>0 ){

                    System.out.println(count+". Day: "+slot.getDay()+" | Vaccine: "+slot.getVaccine().getName()+" | Available Qty :"+slot.getQty());
                    ValidSlots.add(slot);
                    count++;
                    slot_av = true;
                }
            }
        }

        if(!slot_av){
            System.out.println("No Slot Available");
            return;
        }

        System.out.print("Choose Slot: ");
        int choice = sc.nextInt();

        if(choice>=count) {
            System.out.println("Invalid choice");
            return;
        }

        Slot slot_booked = ValidSlots.get(choice);

        slot_booked.setQty(slot_booked.getQty()-1);

        citizen.setVaccine_taken(slot_booked.getVaccine());
        citizen.setNo_of_doses_taken(citizen.getNo_of_doses_taken()+1);
        citizen.setDue_date(slot_booked.getDay()+citizen.getVaccine_taken().getGap());
        System.out.println(citizen.getName()+" Vaccinated with "+ citizen.getVaccine_taken().getName());
    }

    void search_slots_by_vaccine(String vaccine_name,Citizen citizen){

        Scanner sc= new Scanner(System.in);
        boolean hosp_avail = false;
        int Slots_size = Slots_Available.size();
        ArrayList<Hospital>Hosp_shown = new ArrayList<Hospital>();

        for(int i=0 ; i < Slots_size ; i++ ){
            if(vaccine_name.equals(Slots_Available.get(i).getVaccine().getName())) {

                Slot slot = Slots_Available.get(i);
                Hospital hospital = Hospital_record.get(slot.getHospital_id() - 100000);

                if (!Hosp_shown.contains(hospital)){
                    Hosp_shown.add(hospital);
                    System.out.println(hospital.getHospital_id() + " " + hospital.getName());
                    hosp_avail = true;}
            }
        }

        if(!hosp_avail) {
            System.out.println("No Available Hospital for this vaccine");
            return;
        }

        System.out.print("Enter Hospital Id: ");
        int id = sc.nextInt();

        Hospital hospital = Hospital_record.get(id-100000);
        print_valid_slots_for_vaccine(hospital,citizen,vaccine_name);
    }

    void print_valid_slots_for_vaccine( Hospital hospital , Citizen citizen , String vaccine_name ){

        Scanner sc= new Scanner(System.in);

        if(hospital.getSlots().size()==0){
            System.out.println("No valid Slots for given Hospital"); return ;}

        ArrayList<Slot> ValidSlots = new ArrayList<Slot>();
        int count = 0;
        boolean slot_av = false;

        for(int i=0; i<hospital.getSlots().size(); i++){

            Slot slot = hospital.getSlots().get(i);

            if(vaccine_name.equals(slot.getVaccine().getName()) && slot.getQty()>0){

                if(citizen.getVaccine_taken()==null){

                    System.out.println(count+". Day: "+slot.getDay()+" | Vaccine: "+vaccine_name+" | Available Qty :"+slot.getQty());
                    ValidSlots.add(slot);
                    count++;
                    slot_av = true;
                }

                else if(slot.getVaccine().is_equal(citizen.getVaccine_taken())){

                    if((slot.getDay()>=citizen.getDue_date()) && (citizen.getNo_of_doses_taken()<citizen.getVaccine_taken().getDoses()) && slot.getQty()>0 ){

                        System.out.println(count+". Day: "+slot.getDay()+" | Vaccine: "+slot.getVaccine().getName()+" | Available Qty :"+slot.getQty());
                        ValidSlots.add(slot);
                        count++;
                        slot_av = true;
                    }
                }
            }
        }

        if(!slot_av){
            System.out.println("No Slot Available");
            return;
        }

        System.out.print("Choose Slot: ");
        int choice = sc.nextInt();

        if(choice>=count) {
            System.out.println("Invalid choice");
            return;
        }

        Slot slot_booked = ValidSlots.get(choice);

        slot_booked.setQty(slot_booked.getQty()-1);

        citizen.setVaccine_taken(slot_booked.getVaccine());
        citizen.setNo_of_doses_taken(citizen.getNo_of_doses_taken()+1);
        citizen.setDue_date(slot_booked.getDay()+citizen.getVaccine_taken().getGap());
        System.out.println(citizen.getName()+" Vaccinated with "+ citizen.getVaccine_taken().getName());

    }

    void check_Vaccination_status(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Patient Id: ");
        String Id = sc.next();

        if(!Is_citizen_present(Id)){
            System.out.println("Invalid User Id"); return ;}

        Citizen citizen = Find_citizen(Id);

        int vaccination_status = citizen.getVaccinationStatus();

        if(vaccination_status==0){
            System.out.println("REGISTERED");
        }

        else if(vaccination_status==1){

            System.out.println("PARTIALLY VACCINATED");
            System.out.println("Vaccine given: "+citizen.getVaccine_taken().getName());
            System.out.println("Number of doses taken: "+citizen.getNo_of_doses_taken());
            System.out.println("Next dose due date: "+citizen.getDue_date());
        }

        else{
            System.out.println("FULLY VACCINATED");
            System.out.println("Vaccine given: "+citizen.getVaccine_taken().getName());
            System.out.println("Number of doses taken: "+citizen.getNo_of_doses_taken());
        }
    }

    boolean Is_citizen_present(String Id){

        int citizen_record_size = Citizen_record.size();

        for (int i = 0; i < citizen_record_size; i++) {

            if(Id.equals(Citizen_record.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    boolean Is_Vaccine_present(Vaccine vaccine){

        int vaccine_record_size = Vaccines_record.size();

        for(int i=0 ; i < vaccine_record_size ; i++ ){

            if(vaccine.is_equal(Vaccines_record.get(i))){
                return true;
            }
        }
        return false;
    }

    boolean Is_Hospital_registered(Hospital hospital){

        int hospital_record_size = Hospital_record.size();

        for(int i=0 ; i < hospital_record_size ; i++ ){

            if(hospital.is_equal(Hospital_record.get(i))){
                return true;
            }
        }
        return false;
    }

    Citizen Find_citizen(String Id){

        int citizen_record_size = Citizen_record.size();
        for (int i = 0; i < citizen_record_size; i++) {
            if(Id.equals(Citizen_record.get(i).getId())) {
                return Citizen_record.get(i);
            }
        }
        return null;
    }

    void display_menu(){
        System.out.println("--------------------------------------------");
        System.out.println("1.Add Vaccine");
        System.out.println("2.Register Hospital");
        System.out.println("3.Register Citizen");
        System.out.println("4.Add Slot for Vaccination");
        System.out.println("5.Book Slot for Vaccination");
        System.out.println("6.List all slots for a Hospital");
        System.out.println("7.Check Vaccination Status");
        System.out.println("8.Exit");
        System.out.println("--------------------------------------------");
    }
}
