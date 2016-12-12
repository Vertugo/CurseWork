package sample.entity.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Model;
import sample.entity.CPU;
import view.View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Alex on 08.12.2016.
 */
public class CpuController implements Initializable {

    @FXML
    private TextField connectorType;

    @FXML
    private TextField numberOfCores;

    @FXML
    private TextField internalCoreRates;

    @FXML
    private TextField theUnlockedMultiplier;

    @FXML
    private TextField frequencyDataBus;

    @FXML
    private TextField numberOfContacts;

    @FXML
    private TextField powerTDP;

    @FXML
    private TextField kernelName;

    @FXML
    private TextField guarantee;

    @FXML
    private TextField price;

    @FXML
    private ComboBox chooseName;

    @FXML
    private Label countOfElements;

    @FXML
    Button next;

    @FXML
    Button previous;

    @FXML
    Button add;

    private View view;

    private Model model;

    private ArrayList<CPU> cpus;

    private int count;

    public void setModelAndView(Model model,View view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectorType.setEditable(false);
        guarantee.setEditable(false);
        internalCoreRates.setEditable(false);
        numberOfContacts.setEditable(false);
        numberOfCores.setEditable(false);
        theUnlockedMultiplier.setEditable(false);
        price.setEditable(false);
        kernelName.setEditable(false);
        powerTDP.setEditable(false);
        frequencyDataBus.setEditable(false);
    }

    public void process(){
        model.getCpuSet();

        if(chooseName.getItems().isEmpty()) {

            if (!model.getCpu().isEmpty()) {
                for (CPU cpu : model.getCpu()) {
                    if(!this.chooseName.getItems().contains(cpu.getName()))
                    this.chooseName.getItems().add(cpu.getName());
                }
                model.getCpu().clear();
            } else {
                view.createAlert(View.NO_ELEMENTS, new RuntimeException());
            }
        }else chooseName.getItems().clear();
    }

    @FXML
    private void showByName(){
        if(!chooseName.getItems().isEmpty()){
            String name = chooseName.getValue().toString();
            cpus = model.searchCPU(name);
            countOfElements.setText("1");
            show(0);
            if(cpus.size() == 1){
                next.setDisable(true);
                previous.setDisable(true);
            }else{
                next.setDisable(false);
                previous.setDisable(false);
            }
        }
    }

    private void show(int i){
        if(!cpus.isEmpty()) {
            connectorType.setText(cpus.get(i).getConnector_type());
            numberOfCores.setText("" + cpus.get(i).getNumber_of_cores());
            internalCoreRates.setText("" + cpus.get(i).getInternal_clock_rate());
            theUnlockedMultiplier.setText("" + cpus.get(i).getThe_unlocked_multiplier());
            frequencyDataBus.setText("" + cpus.get(i).getThe_frequency_of_the_data_bus());
            numberOfContacts.setText("" + cpus.get(i).getNumber_of_contacts());
            powerTDP.setText("" + cpus.get(i).getTDP_power());
            kernelName.setText(cpus.get(i).getKernel_type());
            guarantee.setText("" + cpus.get(i).getGuarantee());
            price.setText("" + cpus.get(i).getPrice());
        }
    }

    @FXML
    public void getNextTemp(){
        count++;
        if(count >= cpus.size())
            count = 0;
        show(count);
        countOfElements.setText("" + (count + 1));
    }
    @FXML
    public void getPreviousTemp(){
        count--;
        if(count < 0)
            count = 0;
        show(count);
        countOfElements.setText("" + (count + 1));
    }
}
