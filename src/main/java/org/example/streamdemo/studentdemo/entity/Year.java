package org.example.streamdemo.studentdemo.entity;

public enum Year {

    Y23("2022-23"),
    Y22("2021-22"),
    Y21("2020-21"),
    Y20("2019-20"),
    Y19("2018-19"),
    Y18("2017-18"),
    Y17("2016-17"),
    Y16("2015-16"),
    Y15("2014-15"),
    Y14("2013-14"),
    Y13("2012-13");

    private final String actualYear;

    Year(String actualYear) {
        this.actualYear = actualYear;
    }
}
