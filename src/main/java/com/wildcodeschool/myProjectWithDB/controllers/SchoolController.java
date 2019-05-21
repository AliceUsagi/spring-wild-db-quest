package com.wildcodeschool.myProjectWithDB.controllers;

import com.wildcodeschool.myProjectWithDB.entities.School;
import com.wildcodeschool.myProjectWithDB.repositories.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @GetMapping("/api/schools")
    public List<School> getSchools(@RequestParam(defaultValue = "%") String school) {
        return SchoolRepository.selectByCountry(school);
    }

    @PostMapping("/api/schools")
    @ResponseStatus(HttpStatus.CREATED)
    public School store (
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam String country

    ) {
        int idGeneratedByInsertionSchool = SchoolRepository.insertIntoSchool(
                name,
                capacity,
                country
        );
        return SchoolRepository.selectByIdSchool(
                idGeneratedByInsertionSchool
        );
    }
}

