package es.brasatech.lirycs.domain;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Data
@Log4j2
@Builder
public class Lyric {

    private Long id;
    private String title;
    private String description;
    private LyricCategory category;
    private Author author;
    private Map<Long, Strophe> stropheMap;
    private List<Long> orderList;

    public void printLyric() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Title: ");
        sb.append(title);
        sb.append("\n");
        sb.append("Description: ");
        sb.append(description);
        sb.append("\n");
        sb.append("Category: ");
        sb.append(category);
        if (author != null && author.getName() != null) {
            sb.append("\n");
            sb.append("Author: ");
            sb.append(author.getName());
            if(author.getNickname() != null){
                sb.append(" ( ");
                sb.append(author.getNickname());
                sb.append(" )");
            }
        }
        sb.append("\n\n");
        orderList.forEach(stropheId -> {
            sb.append("\n");
            sb.append(stropheMap.get(stropheId).getContent());
        });
        log.info(sb.toString());
    }
}
