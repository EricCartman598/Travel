package main.java.travel_20190228.Common.Business.Repos;

import main.java.travel_20190228.Common.Business.Domain.SequenceGenerator;

public interface BaseRepos extends SequenceGenerator {

    void deleteById(long id);

    void printAll();

    void update();
}
