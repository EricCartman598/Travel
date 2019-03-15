package Travel_20190315.Common.Solution.Service;

import Travel_20190315.Common.Business.Exceptions.NeedToCancelOrderException;
import Travel_20190315.Common.Business.Exceptions.NoSuchCityException;
import Travel_20190315.Common.Business.Exceptions.NoSuchCountryException;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException;

    void printAll();

    void update(T data);
}
