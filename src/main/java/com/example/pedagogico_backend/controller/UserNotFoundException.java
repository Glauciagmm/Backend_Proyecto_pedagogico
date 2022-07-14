package com.example.pedagogico_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found on the Data Base")
public class UserNotFoundException {
}
