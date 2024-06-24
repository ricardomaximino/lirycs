package es.brasatech.lirycs.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Strophe {

    private long id;
    private StropheType type;
    private String content;
}
