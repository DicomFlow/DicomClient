package br.ufpb.dicomflow.gui.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.ufpb.dicomflow.gui.application.validation.ValidationFields;
import br.ufpb.dicomflow.gui.business.ProcessadorConfiguracao;
import br.ufpb.dicomflow.gui.dao.GenericDao;
import br.ufpb.dicomflow.gui.dao.bean.AuthenticationBean;
import br.ufpb.dicomflow.gui.dao.bean.ConfigurationBean;
import br.ufpb.dicomflow.utils.CryptographyUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

public class ConfigurationController implements Initializable{


	@FXML
    private Text configAlerts;

	@FXML
    ComboBox<String> typeField;

	@FXML
    private TextField mailField;


    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField rePasswordField;

    @FXML
    private Label folderLabel;

    @FXML
    private TextField folderField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    protected void saveAction(ActionEvent event) {

    	if(!validate()){
    		return;
    	}

    	AuthenticationBean authDB = (AuthenticationBean) GenericDao.select(AuthenticationBean.class, "mail", mailField.getText());
    	if(authDB != null){
    		configAlerts.setText("E-mail j� configurado.");
    		return;
    	}

    	String encryptedPassword = CryptographyUtil.encriptSHA256(passwordField.getText());
    	if(encryptedPassword == null){
    		configAlerts.setText("N�o foi poss�vel salvar as configura��es.");
    		return;
    	}


    	ConfigurationBean configuration = (ConfigurationBean) GenericDao.select(ConfigurationBean.class, "title", typeField.getValue());

    	AuthenticationBean auth = new AuthenticationBean();
    	auth.setMail(mailField.getText());
    	auth.setPassword(encryptedPassword);
    	auth.setFolder(folderField.getText());
    	auth.setConfiguration(configuration);

    	GenericDao.save(auth);

    	configAlerts.setText("Configura��es salvas com sucesso.");

    }

    private boolean validate() {

    	if(!ValidationFields.checkEmptyFields(typeField, mailField, passwordField, rePasswordField, folderField)){
			return false;
		}

    	if(!ValidationFields.checkMailFormat(mailField)){
    		return false;
    	}

    	if(!ValidationFields.checkPasswordEquals(passwordField, rePasswordField)){
    		return false;
    	}

    	return true;

	}

	@FXML
    protected void cancelAction(ActionEvent event) {
    	try {
    		SceneLoader.getSceneLoader().loadLoginScene();
		} catch (IOException e) {
			e.printStackTrace();
		}


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//initialize comboBox
		List<String> configurationTitles = ProcessadorConfiguracao.getProcessadorConfiguracao().getConfigurationTitles();
		typeField.getItems().addAll(configurationTitles);

		//install tolltip on folderLabel
		Tooltip tooltip =  new Tooltip("Informe o diret�rio onde ser�o armazenados os exames.");
		ValidationFields.hackTooltipStartTiming(tooltip);
		tooltip.setStyle("-fx-font-weight: bold;");
		Tooltip.install(folderLabel, tooltip);

		//install directoryChooser folderField
		folderField.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDirectory =
                        directoryChooser.showDialog(Main.getpStage());

                if(selectedDirectory != null){
                	folderField.setText(selectedDirectory.getAbsolutePath());
                }
            }

		});

	}



}
