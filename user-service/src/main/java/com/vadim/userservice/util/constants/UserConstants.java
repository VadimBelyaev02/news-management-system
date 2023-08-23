package com.vadim.userservice.util.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConstants {

    public final static String USER_API_PATH = "/api/users";

    public final static String USER_NOT_FOUND = "User with id = %s is not found";

    public final static String USER_EXISTS_BY_USERNAME = "User with username = %s already exists";
    public final static String USER_EXISTS_BY_EMAIL = "User with email = %s already exists";
}
