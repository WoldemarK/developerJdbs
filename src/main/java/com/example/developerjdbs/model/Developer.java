package com.example.developerjdbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Developer {

    private Long id;
    private String firstName;

    private String lastName;

    private Specialty specialty;

    private List<Skill> skills;

    public void addSkill(Skill skill) {
        if (this.skills == null)
            this.skills = new ArrayList<>();
        this.skills.add(skill);
    }

}
