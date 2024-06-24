package es.brasatech.lirycs.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Author {

    private long id;
    private String name;
    private String nickname;
    private List<Lyric> lyrics;
}
