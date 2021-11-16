package com.dbc.pessoaapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> usuario = tokenService.isValid(token);

        authenticate(usuario);

        filterChain.doFilter(request, response);
    }

    private void authenticate(Optional<UsuarioEntity> usuario) {
        if (usuario.isPresent()) {
            // correto, usuario autentico
            UsuarioEntity usuarioEntity = usuario.get();
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(
                    usuarioEntity.getLogin(),
                    usuarioEntity.getSenha(),
                    Collections.emptyList()
            );
            SecurityContextHolder.getContext().setAuthentication(token);
        } else {
            // usuário não autêntico
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        return token;
    }
}
