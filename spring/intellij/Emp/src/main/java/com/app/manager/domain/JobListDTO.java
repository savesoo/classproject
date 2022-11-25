package com.app.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class JobListDTO {
    private static List<String> jobList;

    static {
        jobList = new ArrayList<>();
        jobList.add("SALESMAN");
        jobList.add("MANAGER");
        jobList.add("ANALYST");
        jobList.add("PRESIDENT");
        jobList.add("CLERK");
    }

    public List<String> getJobList() {
        return jobList;
    }

    public void addJob(String job) {
        jobList.add(job);
    }
}
