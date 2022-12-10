package models;

public class Cat {

    private final String petType;
    private final String petName;
    private final String petGender;
    private final String petBreed;
    private final String petPrice;
    private final String petAgeDay;
    private final String petAgeMonth;
    private final String petAgeYear;
    private final String petNeutered;
    private final String petChipped;
    private final String petVaccine;
    private final String petIllness;


    public Cat(String petType, String petName, String petGender, String petBreed, String petPrice,
               String petAgeDay, String petAgeMonth, String petAgeYear, String petNeutered,
               String petChipped, String petVaccine, String petIllness) {

        this.petType = petType;
        this.petName = petName;
        this.petGender = petGender;
        this.petBreed = petBreed;
        this.petAgeDay = petAgeDay;
        this.petPrice = petPrice;
        this.petAgeMonth = petAgeMonth;
        this.petAgeYear = petAgeYear;
        this.petNeutered = petNeutered;
        this.petChipped = petChipped;
        this.petVaccine = petVaccine;
        this.petIllness = petIllness;
    }

    public String getPetType() {return petType;}
    public String getPetName() {return petName;}
    public String getPetGender() {return petGender;}
    public String getPetBreed() {return petBreed;}
    public String getPetAgeDay() { return petAgeDay;}
    public String getPetPrice() {return petPrice;}
    public String getPetAgeMonth() {return petAgeMonth;}
    public String getPetAgeYear() {return petAgeYear;}
    public String getPetNeutered() {return petNeutered;}
    public String getPetChipped() {return petChipped;}
    public String getPetVaccine() {return petVaccine;}
    public String getPetIllness() {return petIllness;}

}
