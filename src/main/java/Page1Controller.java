import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Page1Controller {
    @FXML
    TableView<Account> expenseTable;
    @FXML
    TextField number;
    @FXML
    TextArea allIncome;

    @FXML
    ComboBox categoryCombobox;
    @FXML
    TableColumn<Account,String> id;
    @FXML
    TableColumn<Account,String> dayColumn;
    @FXML
    TableColumn<Account,String> categoryColumn;
    @FXML
    TableColumn<Account,String> detailColumn;
    @FXML
    TableColumn<Account,String> amountColumn;
    @FXML
    TextField description;
    @FXML
    TextField textField;
    @FXML
    Label balance;
    @FXML
    DatePicker datePicker;
    private int countId;
    Account account=new Account();
    ObservableList<Account> data =FXCollections.observableArrayList();
    private ObservableList<String> categoryList= FXCollections.observableArrayList("เดินทาง","อาหาร","รายรับ","เงินเดือ");
    @FXML public void initialize(){
        FileConnector fileConnector=new FileConnector();
        fileConnector.readAccountFile();
        categoryCombobox.setValue("เลือกประเภท");
        categoryCombobox.setItems(categoryList);
        id.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("day"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("cata"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("showMoney"));
        expenseTable.setItems(fileConnector.getAccount());
        balance.setText(fileConnector.getBalanceMoney()+"");
    }
    @FXML
    public  void handleAddIncomeButtonOnClick(ActionEvent event){
        FileConnector fileConnector=new FileConnector();
        countId=fileConnector.loopId();
        Account account=new Account(String.valueOf(countId), datePicker.getValue().toString(),
                categoryCombobox.getValue().toString(),
                description.getText(),"+"+textField.getText(),
                Double.parseDouble(textField.getText()));
        fileConnector.writeBalanceFile(account);
        data.add(account);
        fileConnector.readAccountFile();
        id.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("day"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("cata"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("showMoney"));
        expenseTable.setItems(fileConnector.getAccount());
        balance.setText(fileConnector.getBalanceMoney()+"");
    }
    @FXML
    public  void handleAddExpenseButtonOnClick(ActionEvent event){
        FileConnector fileConnector=new FileConnector();
        countId=fileConnector.loopId();
        Account account=new Account(String.valueOf(countId), datePicker.getValue().toString(),
                categoryCombobox.getValue().toString(),
                description.getText(),"-"+textField.getText(),
                Double.parseDouble(textField.getText()));
        fileConnector.writeBalanceFile(account);
        fileConnector.readAccountFile();
        id.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("day"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("cata"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("showMoney"));
        expenseTable.setItems(fileConnector.getAccount());
        balance.setText(fileConnector.getBalanceMoney()+"");
    }
    @FXML
    public void onClick(ActionEvent e){
        textField.setText(amountColumn.getText());
    }
    @FXML
    public  void edit(ActionEvent e){
        FileConnector fileConnector=new FileConnector();
        fileConnector.setValueEdit(datePicker.getValue().toString(),
                categoryCombobox.getValue().toString(),
                description.getText(),
                Double.parseDouble(textField.getText()));
        fileConnector.editInput(number.getText());
        id.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("day"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("cata"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("showMoney"));
        expenseTable.setItems(fileConnector.getAccount());
        balance.setText(fileConnector.getBalanceMoney()+"");
    }
    @FXML
    public  void allIncomeOutcomeButtonOnClick(ActionEvent event){
        FileConnector fileConnector=new FileConnector();
        fileConnector.readAccountFile();
        allIncome.setText("รวม รายรับ-รายจ่าย ทั้งหมด : "+fileConnector.getBalanceMoney()+"");


    }
    @FXML
    public  void allIncomeButtonOnClick(ActionEvent event){
        FileConnector fileConnector=new FileConnector();
        fileConnector.readAccountFile();
        allIncome.setText("รวม รายรับทั้งหมด : "+fileConnector.getBalanceMoneyIncome()+"");


    }
    @FXML
    public  void allOutcomeButtonOnClick(ActionEvent event){
        FileConnector fileConnector=new FileConnector();
        fileConnector.readAccountFile();
        allIncome.setText("รวม รายจ่ายทั้งหมด : "+fileConnector.getBalanceMoneyOutcome()+"");


    }

}





