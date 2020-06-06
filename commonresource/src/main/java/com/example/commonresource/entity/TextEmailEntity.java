package com.example.commonresource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextEmailEntity {

    private String to;
    private String content;

    public static TextEmailEntity setToAndText(String to, String content){
        TextEmailEntity textEmailEntity = new TextEmailEntity();
        textEmailEntity.setTo(to);
        textEmailEntity.setContent(content);

        return textEmailEntity;
    }

}
