package org.example;

import lombok.Getter;
import lombok.ToString;
import org.example.util.Util;

@ToString
@Getter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    public Department(String departmentName) {
        if (!validateDepartmentName(departmentName)) {
            System.out.printf("%s is invalid for department name\n", departmentName);
            return;
        }
        this.departmentId = String.format("D%02d", nextId++);
        this.departmentName = Util.toTitleCase(departmentName);
    }

    /**
     * checks if a department name is valid or not, a department name should only contain letters or space
     * @param departmentName the department name to be checked
     * @return if the department name is valid
     */
    private boolean validateDepartmentName(String departmentName) {
        for (char c : departmentName.toCharArray()) {
            if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }

        return true;
    }
}
