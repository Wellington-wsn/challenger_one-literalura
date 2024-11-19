package com.alura.literalura.model;

public enum Idioma {
    Catalan("ca"),
    Checo("cs"),
    Danes("da"),
    Holandes("nl"),
    Ingles("es"),
    Fines("fi"),
    Frances("fr"),
    Aleman("de"),
    Hungaro("hu"),
    Italiano("it"),
    Japones("ja"),
    Noruego("no"),
    Polaco("pl"),
    Portugues("pt"),
    Ruso("ru"),
    Esloveno("sl"),
    Espanol("es"),
    Sueco("sv"),
    Turco("tr"),
    Coreano("ko"),
    Chino("zh");

    private String idiomaApi;

    Idioma(String idioma) {
        this.idiomaApi = idioma;
    }

    public static Idioma fromString(String texto) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaApi.equalsIgnoreCase(texto)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado com o texto digitado: " + texto);
    }
}
