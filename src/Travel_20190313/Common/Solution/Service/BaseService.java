package Travel_20190313.Common.Solution.Service;

import Travel_20190313.Common.Business.Exceptions.NeedToCancelOrderException;
import Travel_20190313.Common.Business.Exceptions.NoSuchCityException;
import Travel_20190313.Common.Business.Exceptions.NoSuchCountryException;

public interface BaseService<T, ID> {

    void add(T data) throws NoSuchCountryException, NoSuchCityException;

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException;

    void printAll();

    void update(T data);
}
