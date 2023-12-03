package com.buildfor2030.api.Auth;

public interface AuthService {

    UserVO signUp(SignupDTO dto);

    Boolean isSignedIn();

}
