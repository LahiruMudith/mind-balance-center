package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.UserDto;

public interface UserBO extends SuperBO {
    UserDto checkUser(String userName) throws Exception;
}
