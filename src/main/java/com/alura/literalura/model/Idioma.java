package com.alura.literalura.model;


public enum Idioma {
    AFRICANER("africâner", "af"),
    ALBANESE("albanês", "sq"),
    ARABE("árabe", "ar"),
    ARMENIO("armênio", "hy"),
    BASCO("basco", "eu"),
    BIELORUSSO("bielorrusso", "be"),
    BULGARO("búlgaro", "bg"),
    CATALAO("catalão", "ca"),
    CHINES("chinês", "zh"),
    CROATA("croata", "hr"),
    TCHECO("tcheco", "cs"),
    DINAMARQUES("dinamarquês", "da"),
    HOLANDES("holandês", "nl"),
    INGLES("inglês", "en"),
    ESTONIANO("estoniano", "et"),
    FINLANDES("finlandês", "fi"),
    FRANCES("francês", "fr"),
    ALEMAO("alemão", "de"),
    GREGO("grego", "el"),
    HEBRAICO("hebraico", "he"),
    HINDI("hindi", "hi"),
    HUNGARO("húngaro", "hu"),
    ISLANDES("islandês", "is"),
    INDONESIO("indonésio", "id"),
    ITALIANO("italiano", "it"),
    JAPONES("japonês", "ja"),
    COREANO("coreano", "ko"),
    LETAO("letão", "lv"),
    LITUANO("lituano", "lt"),
    MACEDONIO("macedônio", "mk"),
    NORUEGUES("norueguês", "no"),
    POLONES("polonês", "pl"),
    PORTUGUES("português", "pt"),
    ROMENO("romeno", "ro"),
    RUSSO("russo", "ru"),
    SERVIO("sérvio", "sr"),
    ESLOVACO("eslovaco", "sk"),
    ESLOVENO("esloveno", "sl"),
    ESPANHOL("espanhol", "es"),
    SUECO("sueco", "sv"),
    TAILANDES("tailandês", "th"),
    TURCO("turco", "tr"),
    UCRANIANO("ucraniano", "uk"),
    VIETNAMITA("vietnamita", "vi");

    private String idiomaApi;
    private String codigoApi;

    Idioma(String idioma, String codigo) {
        this.idiomaApi = idioma;
        this.codigoApi = codigo;
    }

    public static Idioma fromString(String texto) {
        for (Idioma linguagem : Idioma.values()) {
            if (linguagem.codigoApi.equalsIgnoreCase(texto)) {
                return linguagem;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado com o texto digitado: " + texto);
    }
}
