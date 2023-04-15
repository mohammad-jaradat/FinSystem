package com.qu.finsys.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO {
    private Long currNo;
    private String currAName;
    private String currEName;
    private String currSign;
    private String currPartEName;
    private String currPartAName;
    private Double minRate;
    private Double maxRate;
    private Boolean isMainCurr;
}
