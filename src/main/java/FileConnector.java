import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileConnector {
    //    private int sum;
    private String line ;
    Account balance =new Account();
    private Double balanceMoneyIncome;
    private Double balanceMoneyOutcome;
    private Double balanceMoney;
    private String id;
    private String day;
    private String cata;
    private String description;
    private Double money;
    int count=0;
    String fileSep=System.getProperty("file.separator");
    File jar=new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String jarPath=jar.getAbsoluteFile().getParentFile().getAbsolutePath()+fileSep;
    File file = new File(jarPath+"expense.txt");
    public FileConnector() {
        try {
            file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }
    public Double getBalanceMoney() {
        return balanceMoney;
    }


    ObservableList<Account>account= FXCollections.observableArrayList();
    public String readAccountFile() {
        try {

           // Path file = Paths.get("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
            //BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!=null){

                //System.out.println(line);
                addInput(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return line;
    }
    public void writeBalanceFile(Account account) {
        try {
            //File file = new File("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
            FileWriter writer = new FileWriter(file, true); // true จะเขียนต่อท้ายไฟล์
            writer.write(account.getId()+" "+account.getDay()+" "+account.getCata()
                    +" "+account.getDescription()+" "+account.getShowMoney()+" "+account.getMoney()+ System.getProperty("line.separator"));//เขียนละขึ้นบรรทัดใหม่
            writer.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public String getLine() {
        return line;
    }
    public void addInput(String input){
        if(input.isEmpty()){

        }else {
            //System.out.println(input);
            String[] strings=input.split(" ");
            account.add(new Account(strings[0],
                    strings[1],
                    strings[2],
                    strings[3],
                    strings[4],
                    Double.parseDouble(strings[5])));
            balance.balanceMoney(String.valueOf(strings[4].charAt(0)),Double.parseDouble(strings[5]));
            this.balanceMoney=balance.getBalance();
            this.balanceMoneyIncome=balance.getBalanceIncome();
            this.balanceMoneyOutcome=balance.getBalanceOutcome();
            this.id=strings[0];

            }
    }
    public ObservableList<Account> getAccount() {
        return account;
    }
    public void editInput(String number){
        try {
            //Path file = Paths.get("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
            //BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!=null){
                count++;
                if(line.isEmpty()){

                }else {
                    String[] strings=line.split(" ");
                    if(number.equals(strings[0])){
                        account.add(new Account(strings[0],
                                day,
                                cata,
                                description,
                                String.valueOf(strings[4].charAt(0))+money,money
                                ));
                        balance.balanceMoney(String.valueOf(strings[4].charAt(0)),money);
                        this.balanceMoney=balance.getBalance();
                        this.balanceMoneyIncome=balance.getBalanceIncome();
                        this.balanceMoneyOutcome=balance.getBalanceOutcome();
                        File file1 = new File("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
                        if(count==1){
                            FileWriter writer = new FileWriter(file1, false); // true จะเขียนต่อท้ายไฟล์
                            writer.write(strings[0]+" "+day+" "+cata+" "+description+" "+String.valueOf(strings[4].charAt(0))+money+" "+money+ System.getProperty("line.separator"));//เขียนละขึ้นบรรทัดใหม่
                            writer.close();
                        } else if (count > 1) {

                            FileWriter writer = new FileWriter(file1, true); // true จะเขียนต่อท้ายไฟล์
                            writer.write(strings[0]+" "+day+" "+cata+" "+description+" "+String.valueOf(strings[4].charAt(0))+money+" "+money+ System.getProperty("line.separator"));//เขียนละขึ้นบรรทัดใหม่
                            writer.close();
                        }
                    }else{account.add(new Account(strings[0],
                            strings[1],
                            strings[2],
                            strings[3],
                            strings[4],
                            Double.parseDouble(strings[5])));
                        balance.balanceMoney(String.valueOf(strings[4].charAt(0)),Double.parseDouble(strings[5]));
                        this.balanceMoney=balance.getBalance();
                        this.balanceMoneyIncome=balance.getBalanceIncome();
                        this.balanceMoneyOutcome=balance.getBalanceOutcome();
                        File file1 = new File("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
                        if(count==1){
                            FileWriter writer = new FileWriter(file1, false); // true จะเขียนต่อท้ายไฟล์
                            writer.write(strings[0]+" "+strings[1]+" "+strings[2]
                                    +" "+strings[3]
                                    +" "+strings[4]
                                    +" "+strings[5]+ System.getProperty("line.separator"));//เขียนละขึ้นบรรทัดใหม่
                            writer.close();
                        } else if (count > 1) {

                            FileWriter writer = new FileWriter(file1, true); // true จะเขียนต่อท้ายไฟล์
                            writer.write(strings[0]+" "+strings[1]+" "+strings[2]
                                    +" "+strings[3]
                                    +" "+strings[4]
                                    +" "+strings[5]+ System.getProperty("line.separator"));//เขียนละขึ้นบรรทัดใหม่
                            writer.close();
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public void setValueEdit(String day,String cata,String description,Double money){
        this.day=day;
        this.cata=cata;
        this.description=description;
        this.money=money;
    }
    public int loopId(){
        int loop=1;
        try {

            //Path file = Paths.get("C:\\Users\\User\\IdeaProjects\\ExpenseFX\\expense.txt");
            //BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!=null){
                if(line.isEmpty()){

                }else {
                    loop++;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return  loop;

    }

    public Double getBalanceMoneyIncome() {
        return balanceMoneyIncome;
    }

    public Double getBalanceMoneyOutcome() {
        return balanceMoneyOutcome;
    }
}

