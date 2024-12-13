package com.example.module19_knife.pojo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "用户实体类")
public class User {
    @Schema(description = "用户姓名")
    private String username;
    @Schema(description = "用户密码")
    private String password;
}
