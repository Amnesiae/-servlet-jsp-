package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String sex;
    private String email;
    private int age;
    private String address;
    private String username;
    private String password;
}
