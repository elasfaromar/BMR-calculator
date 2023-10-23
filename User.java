/**
 * BMR calculator (how many calories a person burns a day w/o exercise) that takes in a person’s weight, gender, age, and goal (lose/gain/maintain weight)
 * and the date at which the user wants to achieve his goal. Then using some calculations the program will calculate the number of calories the user should
 * eat in a day to achieve his goal at the rate he specified. 
 *
 * @author (Nikki, Aiden, Omar, and Hari)
 * @version (2022-11-16)
 */
public class User implements java.io.Serializable
{
    // constants
    public final int CALS_PER_KILO = 7700;

    // instance variables
    int age;
    int days;
    int calsToEat;
    int bmr;
    float weight;
    float height;
    float target;
    boolean metric;
    boolean male;
    String goal;

    /**
     * Constructor for objects of class User
     */
    public User()
    {
        // initialise instance variables
        this.age = 0;
        this.days = 0;
        this.calsToEat = 0;
        this.bmr = 0;
        this.weight = 0;
        this.height = 0;
        this.target = 0;
        this.metric = true;
        this.male = true;
        this.goal = "lose";
    }
    
    
    //toString() method
    public String toString()
    {
        String g;

        if (this.male)
        {
            g = "Male";
        }
        else
        {
            g = "Female";
        }

        if (this.metric)
        {
            return String.format("\nCurrent Weight: %.1f kg\nGoal Weight: %.1f kg\n\nCurrent Height: %.1f cm\n\nAge: %d years old\nGender: %s\nBMR: %d" +
                "\n\nTo achieve your goal, %s weight, in %d days, you must eat %d calories a day.", this.weight, this.target, this.height, this.age, g,
                this.bmr, this.goal, this.days,this.calsToEat);
        }
        else
        {
            return String.format("\nCurrent Weight: %.1f lbs\nGoal Weight: %.1f lbs\n\nCurrent Height: %.1f inches\n\nAge: %d years old\nGender: %s\nBM" +
                "R:%d\n\nTo achieve your goal, %s weight, in %d days, you must eat %d calories a day.", kgToLbs(this.weight), kgToLbs(this.target),
                cmToInch(this.height), this.age, g, this.bmr, this.goal, this.days, this.calsToEat);
        }
    }
    
    //Method to determine the amount of calories a person should eat based on 
    public void eat()
    {
        if (this.goal.equals("maintain"))
        {
            this.calsToEat = this.bmr;
        }
        else if (this.goal.equals("lose"))
        {
            int cals = this.bmr * this.days;
            int deficit = (int)(CALS_PER_KILO * (this.weight-this.target));

            this.calsToEat = this.bmr - ((cals-deficit)/this.days);
        }
        else if (this.goal.equals("gain"))
        {
            int cals = this.bmr * this.days;
            int surplus = (int)(CALS_PER_KILO * (this.target-this.weight));

            this.calsToEat = this.bmr + ((cals+surplus)/this.days);
        }
    }

    public void calcBMR()
    {
        if (this.male)
        {
            this.bmr = (int)(88.362 + (13.397 * this.weight) + (4.799 * this.height) - (5.677 * this.age)); 
        }
        else
        {
            this.bmr = (int)(447.593 + (9.247 * this.weight) + (3.098 * this.height) - (4.330 * this.age));
        }
    }
    
    public static float lbsToKg(float x)
    {
        return x/(float)2.205;
    }

    public static float kgToLbs(float x)
    {
        return x*(float)2.205;
    }

    public static float inchToCm(float x)
    {
        return x*(float)2.54;
    }

    public static float cmToInch(float x)
    {
        return x/(float)2.54;
    }
}
