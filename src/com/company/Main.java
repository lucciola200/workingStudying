package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");
    }
}
class Action {
    public void doAction() {
        System.out.println("Doing an action");
    }
}


class Human {

    public void doYoga() {
        Action action = new Action() {
            public void doAction() {
                System.out.println("Doing yoga.");
            }
        };
        action.doAction();
    }
}