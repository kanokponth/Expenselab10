import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Account {
    private SimpleStringProperty id;
    private SimpleStringProperty day;
    private SimpleStringProperty cata;
    private SimpleStringProperty description;
    private SimpleStringProperty showMoney;
    private SimpleDoubleProperty money;
    private String input;
    private Double balance=0.0;
    private int newId;
    private Double balanceIncome=0.0;
    private Double balanceOutcome=0.0;


    public int getNewId() {
        return newId;
    }

    public Double getBalance() {
        return balance;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Account() {
    }

    public String getShowMoney() {
        return showMoney.get();
    }


    public void setShowMoney(String showMoney) {
        this.showMoney.set(showMoney);
    }

    public Account(String id, String day, String cata, String description,String show, Double money) {
        this.id = new SimpleStringProperty(id);
        this.day = new SimpleStringProperty(day);
        this.cata = new SimpleStringProperty(cata);
        this.description = new SimpleStringProperty(description);
        this.showMoney = new SimpleStringProperty(show);
        this.money =new SimpleDoubleProperty(money);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public String getDay() {
        return day.get();
    }
    public void setDay(String day) {
        this.day.set(day);
    }
    public String getCata() {
        return cata.get();
    }
    public void setCata(String cata) {
        this.cata.set(cata);
    }

    public String getDescription() {
        return description.get();
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public double getMoney() {
        return money.get();
    }
    public void setMoney(double money) {
        this.money.set(money);
    }

    public Double balanceMoney(String type,Double money){
        if(type.equals("+")){
            balance+=money;
            balanceIncome+=money;
        }
        else if(type.equals("-")){
            balance-=money;
            balanceOutcome-=money;
        }
        return balance;
    }
    public int addId(int id){
        newId=id;
        return newId;
    }
    public Double getBalanceIncome() {
        return balanceIncome;
    }
    public Double getBalanceOutcome() {
        return balanceOutcome;
    }
}
