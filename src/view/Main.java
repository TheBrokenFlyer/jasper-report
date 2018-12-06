package view;

import controller.JdbUtil;
import controller.Writer;

public class Main {
    public static void main(String...argv) throws Exception {
        Writer.imprimir(JdbUtil.getItems());
    }
}
