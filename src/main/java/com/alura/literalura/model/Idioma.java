package com.alura.literalura.model;


public enum Idioma {
    AFRICANER("AFRICANER", "af"),
    ALBANESE("ALBANESE", "sq"),
    ARABE("ARABE", "ar"),
    ARMENIO("ARMENIO", "hy"),
    BASCO("BASCO", "eu"),
    BIELORUSSO("BIELORUSSO", "be"),
    BULGARO("BULGARO", "bg"),
    CATALAO("CATALAO", "ca"),
    CHINES("CHINES", "zh"),
    CROATA("CROATA", "hr"),
    TCHECO("TCHECO", "cs"),
    DINAMARQUES("DINAMARQUES", "da"),
    HOLANDES("HOLANDES", "nl"),
    INGLES("INGLES", "en"),
    ESTONIANO("ESTONIANO", "et"),
    FINLANDES("FINLANDES", "fi"),
    FRANCES("FRANCES", "fr"),
    ALEMAO("ALEMAO", "de"),
    GREGO("GREGO", "el"),
    HEBRAICO("HEBRAICO", "he"),
    HINDI("HINDI", "hi"),
    HUNGARO("HUNGARO", "hu"),
    ISLANDES("ISLANDES", "is"),
    INDONESIO("INDONESIO", "id"),
    ITALIANO("ITALIANO", "it"),
    JAPONES("JAPONES", "ja"),
    COREANO("COREANO", "ko"),
    LETAO("LETAO", "lv"),
    LITUANO("LITUANO", "lt"),
    MACEDONIO("MACEDONIO", "mk"),
    NORUEGUES("NORUEGUES", "no"),
    POLONES("POLONES", "pl"),
    PORTUGUES("PORTUGUES", "pt"),
    ROMENO("ROMENO", "ro"),
    RUSSO("RUSSO", "ru"),
    SERVIO("SERVIO", "sr"),
    ESLOVACO("ESLOVACO", "sk"),
    ESLOVENO("ESLOVENO", "sl"),
    ESPANHOL("ESPANHOL", "es"),
    SUECO("SUECO", "sv"),
    TAILANDES("TAILANDES", "th"),
    TURCO("TURCO", "tr"),
    UCRANIANO("UCRANIANO", "uk"),
    VIETNAMITA("VIETNAMITA", "vi");

    private String idiomaApi;
    private String codigoApi;

    Idioma(String idioma, String codigo) {
        this.idiomaApi = idioma;
        this.codigoApi = codigo;
    }

    public static Idioma fromCodigo(String codigo) {
        for (Idioma linguagem : Idioma.values()) {
            if (linguagem.codigoApi.equalsIgnoreCase(codigo)) {
                return linguagem;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado com o codigo digitado: " + codigo);
    }

    public static Idioma fromNome(String nome) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaApi.equalsIgnoreCase(nome)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Linguagem não encontrado: " + nome);
    }
}
