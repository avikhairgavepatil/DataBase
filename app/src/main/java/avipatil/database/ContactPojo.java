package avipatil.database;

/**
 * Created by avipatil on 4/17/2017.
 */

public class ContactPojo
{
    private  int id;
    private String name;
    private String number;

    public ContactPojo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
