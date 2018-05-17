package com.example.fernandon.android_client.TALLER2.services;

import com.example.fernandon.android_client.TALLER2.model.User;
import java.util.List;

public interface UsersService extends CustomService {
    List<User> getUsers();
    List<String> getUsersName();
}