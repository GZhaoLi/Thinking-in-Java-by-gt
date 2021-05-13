package com.gui.demo.domain;

/**
 * 实体类
 */
public class NbaPlayer {
    private Integer id;
    private String country;
    private String teamName;
    private Long birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public NbaPlayer() {
    }

    public NbaPlayer(Integer id, String country, String teamName, Long birthday) {
        this.id = id;
        this.country = country;
        this.teamName = teamName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "NbaPlayer{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", teamName='" + teamName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
