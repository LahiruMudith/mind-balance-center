package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class TherapyProgramTM {
    private String id;
    private String name;
    private String duration;
    private BigDecimal cost;
    private String description;
    private String therapistId;
}
