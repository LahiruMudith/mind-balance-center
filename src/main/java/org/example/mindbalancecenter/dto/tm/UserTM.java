package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserTM {
    private String userName;
    private String password;
    private String role;
}
