package travel_20190327.common.solution.utils;

import java.util.List;

public class CollectionUtils {
    private CollectionUtils() {

    }

    public static <T> List<T> getPageableData(List<T> list, final int limit, final int offset) {
        if (offset >= list.size()) {
            return list;
        } else {
            int l = offset + limit > list.size() ? list.size() % limit : limit;
            return list.subList(offset, offset + l);
        }
    }
}
