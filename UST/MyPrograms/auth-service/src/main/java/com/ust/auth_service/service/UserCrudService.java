package com.ust.auth_service.service;

import com.ust.auth_service.model.UserModel;

public interface UserCrudService {
    public UserModel saveUser(UserModel user);
}
