package travel_20190406.common.solution.dataclasses;

public class Pair {
    private String left;
    private String right;
    private String[] rightList;

    public Pair(String left, String[] rightList) {
        this.left = left;
        this.rightList = rightList;
    }

    public Pair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    /*public void setPair(String string, String separator) {
        if(separator == null)
            return;

        String[] buf = string.split(separator);
        this.left = buf[0];
        this.right = buf[1].split(",");
    }*/

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String[] getRightList() {
        return rightList;
    }

    public void setRightList(String[] rightList) {
        this.rightList = rightList;
    }
}