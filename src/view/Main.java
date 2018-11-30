package view;

import java.util.ArrayList;
import java.util.List;

import controller.Writer;
import model.Item;

public class Main {
    public static void main(String...argv) throws Exception {
    	List<Item> l = new ArrayList<Item>(0);
        Writer.imprimir(l);
    }
}
