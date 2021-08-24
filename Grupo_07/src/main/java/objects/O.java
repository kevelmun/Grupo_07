/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Elix
 */
public class O extends Sign{
    
    public O(String id) {
        super(id);
        Image i= new Image("/pics/O.png");
       
        ImageView im =new ImageView(i);
        im.setFitHeight(80);
        im.setFitWidth(80);
        this.setImage(im);
    }
    
}
