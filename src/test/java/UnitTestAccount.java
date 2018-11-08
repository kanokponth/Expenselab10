import cucumber.api.java.ca.I;
import javafx.scene.control.cell.PropertyValueFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class UnitTestAccount {
    Account account;
    Double income;


    FileConnector fileConnector=new FileConnector();


    @BeforeEach
    void init(){




    }

    @Test
    public void testCurrentIncome(){
        //Double income;

        fileConnector.readAccountFile();
        income=fileConnector.getBalanceMoney();
        assertEquals(0.0+"",income+"");
    }
    @Test
    public void testAddIncome(){
          //Double income;
          FileConnector fileConnector=new FileConnector();
          Account account=new Account("2","2018-10-09",
                  "Income",
                  "Income","+"+5000,
                  5000.0);
          fileConnector.writeBalanceFile(account);
         fileConnector.readAccountFile();
          income=fileConnector.getBalanceMoney();
        assertEquals(5000.0+"",income+"");
    }
    @Test
    public  void testUseMoney(){
        //Double income;
        FileConnector fileConnector=new FileConnector();
        Account account=new Account("3","2018-10-09",
                "Food",
                "Kfc","-"+5000,
                5000.0);
        fileConnector.writeBalanceFile(account);
        fileConnector.readAccountFile();
        income=fileConnector.getBalanceMoney();
        assertEquals(0.0+"",income+"");
    }
//    @Test
//    public void testEdit(){
//        //Double income;
//        FileConnector fileConnector=new FileConnector();
//        fileConnector.setValueEdit("2018-10-09",
//                "Food",
//                "Eat Kfc",10000.0);
//        fileConnector.editInput("3");
//
//        income=fileConnector.getBalanceMoney();
//        assertEquals(10000.0+"",income+"");
//
//    }


}
