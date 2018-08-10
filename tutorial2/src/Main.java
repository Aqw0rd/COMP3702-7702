
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //breadthFirst("1348627_5","1238_4765")
        State root = new State("1348627_5", null);
        if(tempPos[0] > 0) queue.add(new State(getNewString(tempPos[0] - 1, tempPos[1], t.getValue()),t));//left
        if(tempPos[0] < 2) queue.add(new State(getNewString(tempPos[0] + 1, tempPos[1], t.getValue()),t));//right
        if(tempPos[1] > 0) queue.add(new State(getNewString(tempPos[0] , tempPos[1] - 1, t.getValue()),t));//up
        if(tempPos[1] < 2) queue.add(new State(getNewString(tempPos[0] , tempPos[1] + 1, t.getValue()),t));//down
        System.out.println(getNewString())
    }

    public void breadthFirst(String initial, String goal){
        State root = new State(initial, null);
        ArrayList<State> queue = new ArrayList<State>();
        queue.add(root);
        while(true){
            State t = queue.get(0);
            queue.remove(0);
            t.setVisited(true);
            if(t.getValue().equals(goal)) return;
            int[] tempPos = t.getPos();
            if(tempPos[0] > 0) queue.add(new State(getNewString(tempPos[0] - 1, tempPos[1], t.getValue()),t));//left
            if(tempPos[0] < 2) queue.add(new State(getNewString(tempPos[0] + 1, tempPos[1], t.getValue()),t));//right
            if(tempPos[1] > 0) queue.add(new State(getNewString(tempPos[0] , tempPos[1] - 1, t.getValue()),t));//up
            if(tempPos[1] < 2) queue.add(new State(getNewString(tempPos[0] , tempPos[1] + 1, t.getValue()),t));//up

        }
    }

    public String getNewString(int x, int y, String value){
        int underscore = value.indexOf('_');
        int newIndex = (y*3) + x + 1;
        String temp = value[newIndex];
        value[newIndex] = '_';
        value[underscore] = temp;
        return value;

    }


}
