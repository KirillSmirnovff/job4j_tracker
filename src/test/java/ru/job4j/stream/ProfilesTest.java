package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address one = new Address("Moscow", "Uvarovskaya", 2, 40);
        Address two = new Address("Moscow", "Lukinskaya", 7, 77);
        Address three = new Address("Vladimir", "Lenina", 5, 35);
        List<Profile> profileList = List.of(
                new Profile(one),
                new Profile(two),
                new Profile(three));
        List<Address> expected = List.of(one, two, three);
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(profileList);
        assertThat(expected, is(result));
    }

    @Test
    public void whenSameAddressThenDistinctAndSort() {
        Address one = new Address("Vladimir", "Lenina", 5, 35);
        Address two = new Address("Vladimir", "Lenina", 5, 35);
        Address three = new Address("Moscow", "Uvarovskaya", 2, 40);
        Address four = new Address("Moscow", "Lukinskaya", 7, 77);
        Address five = new Address("Astrakhan", "Pskovskaya", 22, 15);
        List<Profile> profileList = List.of(
                new Profile(one),
                new Profile(two),
                new Profile(three),
                new Profile(four),
                new Profile(five));
        List<Address> expected = List.of(five, three, four, one);
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(profileList);
        assertThat(expected, is(result));
    }
}