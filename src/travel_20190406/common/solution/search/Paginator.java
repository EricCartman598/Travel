package travel_20190406.common.solution.search;

import java.util.*;

public class Paginator {
    private int limit = 0;
    private int offset = 0;

    public Paginator() {

    }

    public Paginator(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    /*public <T extends List> boolean isLimitsValid(int startPos, int endPos, T data) {
        return !(startPos < 0 || startPos > data.size() ||
                endPos < 0 || endPos > data.size() - startPos ||
                endPos < startPos);
    }*/

}
