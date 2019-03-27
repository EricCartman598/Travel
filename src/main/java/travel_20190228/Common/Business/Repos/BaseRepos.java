package Travel_20190228.Common.Business.Repos;

import Travel_20190228.Common.Business.Domain.SequenceGenerator;

public interface BaseRepos extends SequenceGenerator {

    void deleteById(long id);

    void printAll();

    void update();
}
