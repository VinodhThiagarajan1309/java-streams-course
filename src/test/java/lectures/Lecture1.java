package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.omg.CORBA.PERSIST_STORE;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> finalList = new ArrayList<>();

    for(Person p : people) {
      if(p.getAge() <= 18 && finalList.size() < 10) {
        finalList.add(p);
      }
    }
    System.out.println();


    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
    List<Person> finalList = people.stream().filter( person -> person.getAge() <= 18).collect(Collectors.toList());

  }
}
