package biz.anho;

import biz.anho.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static Stack<String> actions = new Stack<>();
    public static void main(String[] args) {
        long start, end = 0;
        boolean s = false;
        start = System.currentTimeMillis();
        s = depthFirst("1348627_5","1238_4765");
        end = System.currentTimeMillis();
        System.out.println("Solvable: " + s + ", time: " + (end - start) + "ms");
        while(!actions.empty())
            System.out.println(actions.pop());
        System.out.println("\n");

        start = System.currentTimeMillis();
        s = depthFirst("281_43765","1238_4765");
        end = System.currentTimeMillis();
        System.out.println("Solvable: " + s + ", time: " + (end - start) + "ms");
        while(!actions.empty())
            System.out.println(actions.pop());
        System.out.println("\n");

        start = System.currentTimeMillis();
        s= depthFirst("281463_75","1238_4765");
        end = System.currentTimeMillis();
        System.out.println("Solvable: " + s + ", time: " + (end - start) + "ms");
        while(!actions.empty())
            System.out.println(actions.pop());

    }

    public static Boolean breadthFirst(String initial, String goal){
        long start = System.currentTimeMillis();
        State root = new State(initial, null, "start");
        ArrayList<State> queue = new ArrayList<State>();
        ArrayList<String> visited = new ArrayList<>();
        queue.add(root);
        while(queue.size() > 0){
            State t = queue.get(0);
            visited.add(t.getValue());
            queue.remove(0);
            t.setVisited(true);
            if(t.getValue().equals(goal)) {
                System.out.println("Solved in: " + (System.currentTimeMillis() - start) + "ms");
                backTrack(t);
                return true;
            }
            int[] tempPos = t.getPos();
            if(tempPos[0] > 0) {
                String newValue = getNewString(tempPos[0] - 1, tempPos[1], t.getValue());
                if(!visited.contains(newValue)) queue.add(new State(newValue,t, "left"));//left
            }
            if(tempPos[0] < 2){
                String newValue = getNewString(tempPos[0] + 1, tempPos[1], t.getValue());
                if(!visited.contains(newValue)) queue.add(new State(newValue,t, "right"));//right
            }
            if(tempPos[1] > 0){
                String newValue = getNewString(tempPos[0] , tempPos[1] - 1, t.getValue());
                if(!visited.contains(newValue)) queue.add(new State(newValue,t, "up"));//up
            }
            if(tempPos[1] < 2){
                String newValue = getNewString(tempPos[0], tempPos[1] + 1, t.getValue());
                if(!visited.contains(newValue)) queue.add(new State(newValue,t, "down"));//down
            }

        }
        return false;
    }

    public static void backTrack(State state){
        if(state.getParent() == null) return;
        actions.push(state.action);
        backTrack(state.getParent());
    }

    public static Boolean depthFirst(String initial, String goal){
        long start = System.currentTimeMillis();
        State root = new State(initial, null, "start");
        Stack<State> stack = new Stack<State>();
        ArrayList<String> visited = new ArrayList<>();
        stack.push(root);
        while(!stack.empty()) {
            State t = stack.pop();
            if (!t.isVisited()) {
                visited.add(t.getValue());
                t.setVisited(true);
                if (t.getValue().equals(goal)) {
                    System.out.println("Solved in: " + (System.currentTimeMillis() - start) + "ms");
                    //backTrack(t);
                    return true;
                }
                int[] tempPos = t.getPos();
                if (tempPos[0] > 0) {
                    String newValue = getNewString(tempPos[0] - 1, tempPos[1], t.getValue());
                    if (!visited.contains(newValue)) stack.push(new State(newValue, t, "left"));//left
                }
                if (tempPos[0] < 2) {
                    String newValue = getNewString(tempPos[0] + 1, tempPos[1], t.getValue());
                    if (!visited.contains(newValue)) stack.push(new State(newValue, t, "right"));//right
                }
                if (tempPos[1] > 0) {
                    String newValue = getNewString(tempPos[0], tempPos[1] - 1, t.getValue());
                    if (!visited.contains(newValue)) stack.push(new State(newValue, t, "up"));//up
                }
                if (tempPos[1] < 2) {
                    String newValue = getNewString(tempPos[0], tempPos[1] + 1, t.getValue());
                    if (!visited.contains(newValue)) stack.push(new State(newValue, t, "down"));//down
                }

            }
        }
        return false;
    }

    public static String getNewString(int x, int y, String value){
        int underscore = value.indexOf('_');
        int newIndex = (y*3) + x;
        String[] stringlist = value.split("");
        String temp = stringlist[newIndex];
        stringlist[newIndex] = "_";
        stringlist[underscore] = temp;
        return String.join("",stringlist);

    }


}
