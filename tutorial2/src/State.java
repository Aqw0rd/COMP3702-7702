
public class State {
    private State parent;
    private boolean visited;
    private String value;
    private State[] children;
    public State(String value, State parent){
        this.value = value;
        this.parent = parent;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public int[] getPos(){
        int i = this.value.indexOf('_');
        int pos[] = {i % 3, i / 3};
        return pos;
    }

    public State[] getChildren() {
        return children;
    }

    public void setChildren(State[] children) {
        this.children = children;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }
}
