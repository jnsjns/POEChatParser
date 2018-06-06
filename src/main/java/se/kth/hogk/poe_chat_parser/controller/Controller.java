package se.kth.hogk.poe_chat_parser.controller;

import se.kth.hogk.poe_chat_parser.model.InputPrinter;

public class Controller {

    private final InputPrinter inputPrinter;

    public Controller(){
        this.inputPrinter = new InputPrinter();
    }


    public void printInput() {

        inputPrinter.printInput();

    }
}
