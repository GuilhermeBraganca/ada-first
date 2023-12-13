package br.com.ada.ifome.validCadusuario;


import br.com.ada.ifome.exceptions.CpfInvalidoException;
import br.com.ada.ifome.exceptions.UsuarioInvalidoException;
import br.com.ada.ifome.usuario.Usuario;
import br.com.ada.ifome.usuario.UsuarioRepository;
import br.com.ada.ifome.usuario.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testaUsuarioNull() {

        assertThrows(UsuarioInvalidoException.class, () -> usuarioService.salvar(null));
    }

    @Test
    public void usuarioCpfInvalidoComLetra() {
        var usuario = new Usuario();
        usuario.setCpf("1234567891e");
        assertThrows(CpfInvalidoException.class, () -> usuarioService.salvar(usuario));
    }

    @Test
    public void usuarioCpfInvalidoCom12Digitos() {
        var usuario = new Usuario();
        usuario.setCpf("123456789123");
        assertThrows(CpfInvalidoException.class, () -> usuarioService.salvar(usuario));
    }

    @Test
    public void usuarioComCpfValido() {

        var usuario = new Usuario();
        usuario.setCpf("04455566633");
        when(usuarioRepository.save(any())).thenReturn(usuario);
        var usuarioSalvo = usuarioService.salvar(usuario);

        assertNotNull(usuarioSalvo);

        verify(usuarioRepository, Mockito.times(1)).save(usuario);
    }
}
