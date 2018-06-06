package se.kth.hogk.poe_chat_parser.startup;

import se.kth.hogk.poe_chat_parser.controller.Controller;
import se.kth.hogk.poe_chat_parser.view.View;

public class Main {

    public static void main(String[] args) {

        new View(new Controller()).sampleExecution();

    }
}
