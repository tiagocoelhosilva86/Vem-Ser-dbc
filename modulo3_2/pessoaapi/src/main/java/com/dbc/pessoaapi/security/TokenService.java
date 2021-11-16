package com.dbc.pessoaapi.security;

public class TokenService {
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuario) {
        String tokenTexto = usuario.getLogin() + ";" + usuario.getSenha();
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token){
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes);
        String[] separado = decoded.split(";");
        return usuarioService.findByLoginAndSenha(separado[0], separado[1]);
    }

}
