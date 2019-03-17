package Scenes;

import DataModels.Player;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class QuadScene extends Scene {
	
	public Player p;
	
	QuadScene(Pane p, double width, double height){
		super(p, width, height);
	}

}
