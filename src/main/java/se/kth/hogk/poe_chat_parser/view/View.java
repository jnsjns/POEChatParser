package se.kth.hogk.poe_chat_parser.view;

import se.kth.hogk.poe_chat_parser.controller.Controller;

public class View {

    public final Controller contr;

    public View(Controller contr){

        this.contr = contr;

    }

    public void sampleExecution() {

        contr.printInput();
    }
}
