package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


    }

    public void breadthFirst(String initial, String goal ){
        State root = new State(initial, null);
        ArrayList<State> queue = new ArrayList<State>();
        queue.add(root);
        while(true){
            State t = queue.get(0);
            queue.remove(0);
            t.setVisited(true);
            if(t.getValue().equals(goal)) return;
            
        }
    }
}
