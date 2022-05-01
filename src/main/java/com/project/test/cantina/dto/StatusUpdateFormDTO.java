package com.project.test.cantina.dto;

import com.project.test.cantina.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusUpdateFormDTO {

    private Status status;

}
