package com.example.demo.RequestObject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class StudentRequest {

    @Getter
    @Setter
        String date;
        Integer id;
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }


    }
