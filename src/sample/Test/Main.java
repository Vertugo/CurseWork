package sample.Test;

import sample.Model;
import sample.entity.*;

/**
 * Created by Alex on 03.12.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
       for(VideoCard card:model.searchVideoCard("MSI"))
           System.out.println(card);
    }
}
