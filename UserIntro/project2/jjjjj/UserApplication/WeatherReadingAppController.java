/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userapplication;

import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
/**
 *
 * @author Jacob Lo
 */
public class WeatherReadingAppController implements Initializable {
    
    private final ObservableList<String> choiceList = FXCollections.observableArrayList();
    private final ObservableList<Reading> readingObj = FXCollections.observableArrayList();
    @FXML private Button btnNewReading;
    @FXML private Button btnSaveReadings;
    @FXML private Button btnDeleteReading;
    @FXML private Button btnRequestReading;
    @FXML private Button btnEditReading;
    @FXML private TextField txtId;
    @FXML private TextField txtTemp;
    @FXML private TextField txtWind;    
    @FXML private TextField txtPort;
    @FXML private TextField txtHost;
    @FXML private ChoiceBox<String> chLoc;
    @FXML private ListView<String> list;
    @FXML private TableView<Reading> table;
    @FXML private TableColumn<Reading, Integer> colId;
    @FXML private TableColumn<Reading, String> colLoc;
    @FXML private TableColumn<Reading, Double> colTemp;
    @FXML private TableColumn<Reading, Double> colWind;
    
    @FXML
    public void newIssueFired(ActionEvent e){
        if(txtId.getText() == null || txtId.getText().isEmpty() || txtTemp.getText() == null || txtTemp.getText().isEmpty() || txtWind.getText() == null || txtWind.getText().isEmpty()){
            list.getItems().add("No or Incomplete Data Entered");
        }else{
            try{
                readingObj.add(new Reading(Integer.parseInt(txtId.getText()),chLoc.getValue(),
                    Double.parseDouble(txtTemp.getText()),Double.parseDouble(txtWind.getText())));
                table.setItems(readingObj);

                if(readingObj.size() == 1){
                    list.getItems().add("Added Reading Object. You have total of " + readingObj.size() + " reading object.");
                }else{
                    list.getItems().add("Added Reading Object. You have total of " + readingObj.size() + " reading objects.");
                }
            } catch (NumberFormatException nfe){
                list.getItems().add("Re-entered Data Correctly");
            }            
        }
        txtId.setText("");
        chLoc.setValue("North East");
        txtTemp.setText("");
        txtWind.setText("");
    }
 
    @FXML
    public void saveIssueFired(ActionEvent e) {
        try{  
            //step1 load the driver class  
            Class.forName("com.mysql.jdbc.Driver");  

            //step2 create  the connection object  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","jklo1","password");  

            //step3 create the statement object  
            Statement stmt = con.createStatement();
            
            //step4 execute the insert statement for storing data
            stmt.execute("TRUNCATE TABLE Reading");
            for(Reading rObj : readingObj){
                stmt.executeUpdate("INSERT INTO Reading(readingId,location,windspeed,temperature) VALUES('" + rObj.getAge() + "','" + rObj.getGender() + "','" + rObj.getHeight() + "','" + rObj.getWeight() + "')");
            }
            
            //step5 close the connection object
            list.getItems().add("Data has been successfully saved in the system");
            con.close();
        }catch(SQLException se){ 
            list.getItems().add("Cannot save the data in the system");
        }catch(ClassNotFoundException ce){
            list.getItems().add("Cannot connect to the database");
        }
    }
    
    @FXML
    public void editIssueFired(ActionEvent e){
        Reading selectedReading = table.getSelectionModel().getSelectedItem();
        int index = 0;
        if(selectedReading != null){
            if(txtId.getText() == null || txtId.getText().isEmpty() || txtTemp.getText() == null || txtTemp.getText().isEmpty() || txtWind.getText() == null || txtWind.getText().isEmpty()){
                list.getItems().add("No or Incomplete Data Entered");
            }else{
                try{
                    for(Reading rObj : readingObj){
                        if(selectedReading.getAge() == rObj.getAge()){
                            index = readingObj.indexOf(rObj);    
                            Reading newReading = new Reading(Integer.parseInt(txtId.getText()),chLoc.getValue(),Double.parseDouble(txtTemp.getText()),Double.parseDouble(txtWind.getText()));
                            readingObj.add(index,newReading);
                            readingObj.remove(rObj);
                        }
                    }
                } catch (NumberFormatException nfe){
                    list.getItems().add("Re-entered Data Correctly");
                } catch (RuntimeException re) {
                }
            }
        }else{
           list.getItems().add("No Data Selected");
        }
        txtId.setText("");
        chLoc.setValue("North East");
        txtTemp.setText("");
        txtWind.setText("");
    }
    
    @FXML
    public void deleteIssueFired(ActionEvent e){
        Reading selectedReading = table.getSelectionModel().getSelectedItem();
        
        if(selectedReading != null){
            Alert confirmation = new Alert(AlertType.CONFIRMATION, "Delete Reading Id " + selectedReading.getAge() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.YES) {
                table.getItems().remove(selectedReading);
                readingObj.remove(selectedReading);
                if(readingObj.size() == 1){
                    list.getItems().add("Removed Reading Object. You have total of " + readingObj.size() + " reading object.");
                }else{
                    list.getItems().add("Removed Reading Object. You have total of " + readingObj.size() + " reading objects.");
                }
            }
        }else{
            list.getItems().add("No Data Selected");
        }
    }
    
    @FXML
    public void requestIssueFired(ActionEvent e){
        if(txtPort.getText() == null || txtPort.getText().isEmpty() || txtHost.getText() == null || txtHost.getText().isEmpty()){
            list.getItems().add("No host or port number has been entered");
        }else{
            try{
               Socket clientSocket = new Socket(txtHost.getText(), Integer.parseInt(txtPort.getText()));
               list.getItems().add("Successfully connected to " + txtHost.getText() + " at " + txtPort.getText());
               DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());       
               out.writeUTF("requesting for reading objects");
               out.flush();
               ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
               DataInputStream inMessage = new DataInputStream(clientSocket.getInputStream());
               String message = inMessage.readUTF();
               ArrayList<Reading> readingList = (ArrayList) in.readObject();
               readingObj.addAll(readingList);
               list.getItems().add(message);
               table.setItems(readingObj);
               clientSocket.close();
            } catch (NumberFormatException nfe) {
                list.getItems().add("Enter the appropriate port number");
            } catch (SocketException se) {
                list.getItems().add("Enter the correct port number");
            } catch (UnknownHostException ue) {
                list.getItems().add("Don't know about host " + txtHost.getText());
            } catch (IOException ie) {
                list.getItems().add("Couldn't get I/O for the connection to " + txtHost.getText());
            } catch (ClassNotFoundException ce){
                list.getItems().add(txtHost.getText());
            }
        }
        txtHost.setText("");
        txtPort.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();

        colId.setCellValueFactory(new PropertyValueFactory<>("age"));
        colLoc.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colTemp.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colWind.setCellValueFactory(new PropertyValueFactory<>("height"));

        try{  
            //step1 load the driver class  
            Class.forName("com.mysql.jdbc.Driver");  

            //step2 create  the connection object  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","jklo1","password");  

            //step3 create the statement object  
            Statement stmt = con.createStatement();
            
            //step4 execute the select statement for retrieving data
            ResultSet rs=stmt.executeQuery("select * from Reading");  
            while(rs.next()){
                readingObj.add(new Reading(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4)));
                
            }
            table.setItems(readingObj);
            
            //step5 close the connection object
            con.close();
        }catch(SQLException se){ 
            list.getItems().add("Cannot retrieve the data to the system");
        }catch(ClassNotFoundException ce){
            list.getItems().add("Cannot connect to the database");
        }
    }

    public void loadData(){
        choiceList.removeAll(choiceList);
        String ne = "North East";
        String nw = "North West";
        String se = "South East";
        String sw = "South West";
        choiceList.addAll(ne,nw,se,sw);
        chLoc.getItems().addAll(choiceList);
        chLoc.setValue("North East");
    }

}
