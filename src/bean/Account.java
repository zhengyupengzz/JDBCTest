package bean;

import java.io.Serializable;

public class Account implements Serializable{
    private int STUID;
    private String STUNAME;
    private int STUAGE;

    public Account() {
    }

    public Account(int STUID, String STUNAME, int STUAGE) {
        this.STUID = STUID;
        this.STUNAME = STUNAME;
        this.STUAGE = STUAGE;
    }

    public int getSTUID() {
        return STUID;
    }

    public void setSTUID(int STUID) {
        this.STUID = STUID;
    }

    public String getSTUNAME(String stuname) {
        return STUNAME;
    }

    public void setSTUNAME(String STUNAME) {
        this.STUNAME = STUNAME;
    }

    public int getSTUAGE(int stuage) {
        return STUAGE;
    }

    public void setSTUAGE(int STUAGE) {
        this.STUAGE = STUAGE;
    }

    @Override
    public String toString() {
        return "Account{" +
                "STUID=" + STUID +
                ", STUNAME='" + STUNAME + '\'' +
                ", STUAGE=" + STUAGE +
                '}';
    }
}
