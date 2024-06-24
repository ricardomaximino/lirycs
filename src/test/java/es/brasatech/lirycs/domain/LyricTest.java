package es.brasatech.lirycs.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LyricTest {

    String one = """
            NO MEIO DA CAPOEIRA
            SE CANTAVA E SEMPRE DIZIA
            QUE NA BOCA DO MUNDO
            O QUE BOM NUNCA TEM VALIA
            """;
    String two = """
            OUVIU FALAR DE MIN
            SEM AOMENOS ME CONHECER
            JÁ ME JULGA ASSIM
            SAI CONTANDO O QUE ESCUTA E NÃO VÊ
            """;
    String three = """
            FALANDO POR AÍ
            SEM SABER O QUE FALSO OU VERDADE
            ACREDITA EM MENTIRA
            VAI LEVANDO A DISCORDIA E A MALDADE
            """;
    String four = """
            SE SUJEITA A TUDO
            SÓ ESCUTA UMA VERSÃO
            É O TIPO DE PESSOA
            QUE O INTERESSE É MAIOR QUE A RAZÃO
            """;

    String five = """
            NO PÉ DO BERIMBAU
            É DIFÍCIL SABER O QUE VEM
            NOS CAMINHOS DO MUND0
            É DIFÍCIL SABER QUEM É QUEM
            """;
    String six = """
            FALAR È BEM MAIS FÁCIL
            MINHA VIDA TU LEVA NA LINGUA
            MÁS NÃO FAZ O QUE EU FAÇO
            SUA VIDA SE ACABA NA MINGUA
            """;
    String chorous = """
            NO PÉ DO BERIMBAU
            EU VOU ME BEMZER
            CONTRA A BOCA DO MUNDO
            ME PROTEGER
            """;

    @Test
    void createLyric() {
        var author = Author.builder()
                .id(1)
                .nickname("Maizena")
                .name("Ricardo Maximino")
                .build();
        var stropheOne = Strophe.builder()
                .id(1L)
                .type(StropheType.REGULAR)
                .content(one)
                .build();
        var stropheTwo = Strophe.builder()
                .id(2L)
                .type(StropheType.REGULAR)
                .content(two)
                .build();
        var stropheThree = Strophe.builder()
                .id(3L)
                .type(StropheType.REGULAR)
                .content(three)
                .build();
        var stropheFour = Strophe.builder()
                .id(4L)
                .type(StropheType.REGULAR)
                .content(four)
                .build();
        var stropheFive = Strophe.builder()
                .id(5L)
                .type(StropheType.REGULAR)
                .content(five)
                .build();
        var stropheSix = Strophe.builder()
                .id(6L)
                .type(StropheType.REGULAR)
                .content(six)
                .build();
        var stropheChorus = Strophe.builder()
                .id(7L)
                .type(StropheType.CHORUS)
                .content(chorous)
                .build();

        Map<Long, Strophe> stropheMap = new HashMap<>();
        stropheMap.put(stropheOne.getId(), stropheOne);
        stropheMap.put(stropheTwo.getId(), stropheTwo);
        stropheMap.put(stropheThree.getId(), stropheThree);
        stropheMap.put(stropheFour.getId(), stropheThree);
        stropheMap.put(stropheFive.getId(), stropheFive);
        stropheMap.put(stropheSix.getId(), stropheSix);
        stropheMap.put(stropheChorus.getId(), stropheChorus);

        List<Long> orderList = List.of(1L, 7L, 2L, 7L, 3L, 7L, 4L, 7L, 5L, 7L, 6L, 7L);
        var lyric = Lyric.builder()
                .id(1L)
                .author(author)
                .title("BOCA DO MUNDO")
                .description("A MALDADE DA BOCA DO MUNDO")
                .category(LyricCategory.CAPOEIRA)
                .stropheMap(stropheMap)
                .orderList(orderList)
                .build();
        lyric.printLyric();

        Assertions.assertNotNull(lyric);
    }

}