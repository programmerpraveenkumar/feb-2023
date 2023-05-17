package com.feb2023.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class UserServerResponse {
    String page;
    List<HashMap<String,String>> data;
}
