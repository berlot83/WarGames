package application;

import com.falcon.controllers.DBManagerAirplane;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LoginStage {

	public Stage newLoginStage() {

		/* TextShadow */
		DropShadow shadow = new DropShadow();
		shadow.setOffsetY(3.0f);
		shadow.setColor(Color.color(0, 0, 0));

		/* Title Text */
		Text title = new Text("Login on:");
		title.setEffect(shadow);
		title.setFont(Font.font(null, FontWeight.BOLD, 25));
		title.setFill(Color.WHITE);

		/* Components */
		TextField user = new TextField();
		TextField password = new TextField();

		/* Label User */
		Label lblUser = new Label("User:");
		lblUser.setFont(Font.font(null, FontWeight.BOLD, 16));
		lblUser.setEffect(shadow);
		lblUser.setTextFill(Color.WHITE);

		/* Label Password */
		Label lblPassword = new Label("Password:");
		lblPassword.setFont(Font.font(null, FontWeight.BOLD, 16));
		lblPassword.setEffect(shadow);
		lblPassword.setTextFill(Color.WHITE);

		/* Hyperlink */
		Hyperlink missPassword = new Hyperlink("");
		missPassword.setText("I don't remember my User or Password");
		missPassword.setFont(Font.font(null, FontWeight.BOLD, 14));
		missPassword.setEffect(shadow);
		missPassword.setTextFill(Color.DEEPPINK);

		// WebView browser = new WebView();
		// missPassword.setOnAction(e ->
		// browser.getEngine().load("http://google.com.ar"));

		Stage stage = new Stage();
		stage.setTitle("Login");

		/* Login Button */
		Button login = new Button("Login");
		login.setOnAction(e -> {
			Object obj = DBManagerAirplane.getUserLogin(user.getText(), password.getText());
			stage.close();
		});

		/* Back Button */
		Button back = new Button();
		back.setOnAction(e -> {
			stage.close();
		});

		/* Layout where all the components are inside */
		VBox vBoxLayout = new VBox();
		vBoxLayout.setPadding(new Insets(50, 50, 50, 50));
		vBoxLayout.getStyleClass().add("vBoxLayout");
		vBoxLayout.getChildren().addAll(title, lblUser, user, lblPassword, password, missPassword, login);

		/* Scene or Panel where we need to put the layout inside */
		Scene scene = new Scene(vBoxLayout, 500, 300);
		scene.getStylesheets().addAll(this.getClass().getResource("login.css").toExternalForm());

		/* Assing the scene to the Stage */
		stage.setScene(scene);

		return stage;
	}

}
