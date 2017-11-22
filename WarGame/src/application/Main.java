package application;

import java.sql.SQLException;

import com.falcon.controllers.DBManagerAirplane;
import com.falcon.io.FileLog;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

	Label title = null;
	TextField txtTypes = null;
	TextField txtCrew = null;
	TextField txtWeapons = null;
	RadioButton radRadarYes = null;
	RadioButton radRadarNo = null;
	TextField txtAutonomy = null;
	TextField txtFuel = null;
	Label lblTypes = null;
	Label lblCrew = null;
	Label lblWeapons = null;
	Label lblRadar = null;
	Label lblAutonomy = null;
	Label lblFuel = null;
	Button btnInsert = null;
	Button btnWeapons = null;
	boolean radioResult = false;
	
	

	@Override
	public void start(Stage primaryStage) {
		
		

		try {

			VBox layout = new VBox(10);
			layout.getStyleClass().add("layout");
			Scene insertScene = new Scene(layout, 300, 600);
			primaryStage.setScene(insertScene);
			primaryStage.setTitle("Insert Aircraft to the DB");	
			
			txtTypes = new TextField();
			txtCrew = new TextField();
			txtWeapons = new TextField();
			radRadarYes = new RadioButton("Yes");
			radRadarNo = new RadioButton("No");
			txtAutonomy = new TextField();
			txtFuel = new TextField();
		
			
			/* Start Shadow effects */
			DropShadow shadow = new DropShadow();
			shadow.setOffsetY(3.0f);
			shadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
			/* End Shadow effects */

			/* Title Text */
			Text header = new Text(20,20,"Insert Airplane");
			header.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
			header.setFill(Color.WHITE);
			header.setEffect(shadow);
			/* Title Text */
			
			/* Airplane label */
			lblTypes = new Label("Airplane");
			lblTypes.setTextFill(Color.WHITE);
			lblTypes.setEffect(shadow);
			lblTypes.setFont(Font.font(null,FontWeight.BOLD,15));
			/* Airplane label */
			
			/* Crew label */
			lblCrew = new Label("Crew");
			lblCrew.setTextFill(Color.WHITE);
			lblCrew.setEffect(shadow);
			lblCrew.setFont(Font.font(null,FontWeight.BOLD,15));
			/* Crew label */
			
			/* Weapons label */
			lblWeapons = new Label("Weapons");
			lblWeapons.setTextFill(Color.WHITE);
			lblWeapons.setEffect(shadow);
			lblWeapons.setFont(Font.font(null,FontWeight.BOLD,15));
			/* Weapons label */
			
			lblRadar = new Label("Radar");
			lblRadar.setTextFill(Color.WHITE);
			lblRadar.setEffect(shadow);
			lblRadar.setFont(Font.font(null,FontWeight.BOLD,15));
			
			lblAutonomy = new Label("Autonomy");
			lblAutonomy.setTextFill(Color.WHITE);
			lblAutonomy.setEffect(shadow);
			lblAutonomy.setFont(Font.font(null,FontWeight.BOLD,15));
			
			lblFuel = new Label("Fuel");
			lblFuel.setTextFill(Color.WHITE);
			lblFuel.setEffect(shadow);
			lblFuel.setFont(Font.font(null,FontWeight.BOLD,15));
			lblFuel.getStyleClass().add("lblFuel");
			
			ToggleGroup group = new ToggleGroup();
			radRadarYes.setToggleGroup(group);
			radRadarNo.setToggleGroup(group);
			radRadarYes.setText("button 1");
			radRadarYes.setUserData("1");
			radRadarNo.setText("button 0");
			radRadarYes.setUserData("0");
			
			layout.setId("layout");
			insertScene.getStylesheets().addAll(this.getClass().getResource("insertScene.css").toExternalForm());
			
			
			
			DBManagerAirplane dbm = new DBManagerAirplane();
			
			/* Insert Button */
			btnInsert = new Button("Insert");
			
			
			/* Insert action event button */
			btnInsert.setOnAction(e -> {
				try {
					dbm.insert(txtTypes.getText(), Integer.parseInt(txtCrew.getText()), txtWeapons.getText(), group.getSelectedToggle().isSelected(), Double.parseDouble(txtAutonomy.getText()), Double.parseDouble(txtFuel.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileLog e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} );

			/* Back button */
			Button back = new Button("Back");
			btnWeapons = new Button("Add Weapons");
			
			/* Back action event button */
			btnWeapons.setOnAction(e ->{
				
				Label lblWeapons = new Label("Insert weapons");
				Label lblType = new Label("Description");
				TextField txtWeapons = new TextField();
				Label lblQuantity = new Label("Quantity");
				TextField txtQuantity = new TextField();
				
				VBox weaponsLayout = new VBox();
				weaponsLayout.setId("weaponsLayout");
				weaponsLayout.getStyleClass().add("weaponsLayout");
				
				weaponsLayout.setPadding(new Insets(20, 20, 20, 20));
				Scene weaponsScene = new Scene(weaponsLayout, 300, 500);
				weaponsScene.getStylesheets().addAll(this.getClass().getResource("insertScene.css").toExternalForm());
				
				primaryStage.setScene(weaponsScene);
				weaponsLayout.getChildren().addAll(lblWeapons, lblType, txtWeapons, lblQuantity, txtQuantity, back);
			});
			
			
			back.setOnAction(e -> {
				primaryStage.setScene(insertScene);
			});
			
			Button login = new Button("Login");
			login.setOnAction(e -> {
				LoginStage loginStg = new LoginStage();
				Stage loginStage = loginStg.newLoginStage();
				loginStage.show();
				}
			);
			
			//DBManagerAirplane validatedLogin = new DBManagerAirplane();
	if(DBManagerAirplane.validated == true) {
		btnInsert.setDisable(false);
	}
			
			
			layout.getChildren().addAll(header, lblTypes, txtTypes, lblCrew, txtCrew, lblWeapons, txtWeapons, lblRadar, radRadarYes, radRadarNo, lblAutonomy, txtAutonomy, lblFuel, txtFuel, btnInsert, btnWeapons, login);
			
			layout.setPadding(new Insets(20, 20, 20, 20));

			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
